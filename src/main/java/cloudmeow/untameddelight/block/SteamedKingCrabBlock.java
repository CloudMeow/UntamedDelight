package cloudmeow.untameddelight.block;

import cloudmeow.untameddelight.registry.UDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.utility.TextUtils;

public class SteamedKingCrabBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 3);

    protected static final VoxelShape PLATE_SHAPE =  Shapes.or(Block.box(0, 0, 0, 16, 1, 16),
            Block.box(-1, 1, 16, 16, 4, 17),
            Block.box(0, 1, -1, 17, 4, 0),
            Block.box(-1, 1, -1, 0, 4, 16),
            Block.box(16, 1, 0, 17, 4, 17)
    );
    protected static final VoxelShape CRAB_WEST = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(5, 3, 4, 12, 7, 12), BooleanOp.OR);
    protected static final VoxelShape CRAB_EAST = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(4, 3, 4, 11, 7, 12), BooleanOp.OR);
    protected static final VoxelShape CRAB_NORTH = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(4, 3, 5, 12, 7, 12), BooleanOp.OR);
    protected static final VoxelShape CRAB_SOUTH = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(4, 3, 4, 12, 7, 11), BooleanOp.OR);

    public SteamedKingCrabBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(getServingsProperty(), getMaxServings()));
    }

    public IntegerProperty getServingsProperty() {
        return SERVINGS;
    }

    public int getMaxServings() {
        return 3;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if(state.getValue(SERVINGS)>1){
            switch (state.getValue(FACING)) {
                case NORTH:
                    return CRAB_NORTH;
                case SOUTH:
                    return CRAB_SOUTH;
                case WEST:
                    return CRAB_WEST;
                case EAST:
                    return CRAB_EAST;
            }
        }
        return PLATE_SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).getMaterial().isSolid();
    }

    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        int servings = state.getValue(SERVINGS);
        ItemStack heldStack = player.getItemInHand(handIn);

        if (heldStack.is(Items.BOWL)) {
            if (servings == 3) {
                return takeServing(level, pos, state, player, handIn, UDItems.STEAMED_KING_CRAB_LEGS.get());
            }
            if (servings == 2) {
                return takeServing(level, pos, state, player, handIn, UDItems.STEAMED_KING_CRAB.get());
            }
            if (servings == 1) {
                return takeServing(level, pos, state, player, handIn, UDItems.STEAMED_EGG_WITH_KING_CRAB_ROE.get());
            }
        }
        if (servings == 0) {
            level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
            level.destroyBlock(pos, true);
        }
        else {
            player.displayClientMessage(TextUtils.getTranslation("block.feast.use_container", new ItemStack(Items.BOWL).getHoverName()), true);
        }
        return InteractionResult.SUCCESS;
    }

    protected InteractionResult takeServing(Level level, BlockPos pos, BlockState state, Player player, InteractionHand handIn, Item serving) {
        int servings = state.getValue(SERVINGS);
        ItemStack heldItem = player.getItemInHand(handIn);
        level.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3);

        if (!player.isCreative()) {
            heldItem.shrink(1);
        }
        if (!player.getInventory().add(new ItemStack(serving))) {
            player.drop(new ItemStack(serving), false);
        }
        level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.PLAYERS, 1.0F, 1.0F);
        return InteractionResult.SUCCESS;
    }

}
