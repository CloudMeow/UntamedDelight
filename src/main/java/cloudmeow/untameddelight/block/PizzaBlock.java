package cloudmeow.untameddelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.function.Supplier;

public class PizzaBlock extends FeastBlock {
    protected static final VoxelShape[] PIZZA_SOUTH = new VoxelShape[]{
            Block.box(8, 0, 8, 16, 2, 16),
            Block.box(0, 0, 8, 16, 2, 16),
            Shapes.or(Block.box(8, 0, 0, 16, 2, 8),
                      Block.box(0, 0, 8, 16, 2, 16)),
            Block.box(0, 0, 0, 16, 2, 16)
    };
    protected static final VoxelShape[] PIZZA_NORTH = new VoxelShape[]{
            Block.box(0, 0, 0, 8, 2, 8),
            Block.box(0, 0, 0, 16, 2, 8),
            Shapes.or(Block.box(0, 0, 0, 16, 2, 8),
                    Block.box(0, 0, 8, 8, 2, 16)),
            Block.box(0, 0, 0, 16, 2, 16)
    };
    protected static final VoxelShape[] PIZZA_EAST = new VoxelShape[]{
            Block.box(8, 0, 0, 16, 2, 8),
            Block.box(8, 0, 0, 16, 2, 16),
            Shapes.or(Block.box(0, 0, 0, 8, 2, 8),
                    Block.box(8, 0, 0, 16, 2, 16)),
            Block.box(0, 0, 0, 16, 2, 16)
    };
    protected static final VoxelShape[] PIZZA_WEST = new VoxelShape[]{
            Block.box(0, 0, 8, 8, 2, 16),
            Block.box(0, 0, 0, 8, 2, 16),
            Shapes.or(Block.box(8, 0, 8, 16, 2, 16),
                    Block.box(0, 0, 0, 8, 2, 16)),
            Block.box(0, 0, 0, 16, 2, 16)
    };
    public PizzaBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int s = state.getValue(SERVINGS);
        if (s>0) {
            switch (state.getValue(FACING)) {
                case NORTH:
                    return PIZZA_NORTH[s-1];
                case SOUTH:
                    return PIZZA_SOUTH[s-1];
                case WEST:
                    return PIZZA_WEST[s-1];
                case EAST:
                    return PIZZA_EAST[s-1];
            }
        }
		return PIZZA_NORTH[0];
    }

    protected InteractionResult takeServing(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = (Integer)state.getValue(this.getServingsProperty());
        if (servings == 0) {
            level.playSound((Player)null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.destroyBlock(pos, true);
            return InteractionResult.SUCCESS;
        } else {
            ItemStack serving = this.getServingItem(state);
            ItemStack heldStack = player.getItemInHand(hand);
            if (servings > 0) {
                if (!serving.hasCraftingRemainingItem() || heldStack.sameItem(serving.getCraftingRemainingItem())) {
                    level.setBlock(pos, (BlockState)state.setValue(this.getServingsProperty(), servings - 1), 3);
                    if (!player.getAbilities().instabuild && serving.hasCraftingRemainingItem()) {
                        heldStack.shrink(1);
                    }

                    if (!player.getInventory().add(serving)) {
                        player.drop(serving, false);
                    }

                    if ((Integer)level.getBlockState(pos).getValue(this.getServingsProperty()) == 0 && !this.hasLeftovers) {
                        level.removeBlock(pos, false);
                    }

                    level.playSound((Player)null, pos, SoundEvents.SLIME_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return InteractionResult.SUCCESS;
                }

                player.displayClientMessage(TextUtils.getTranslation("block.feast.use_container", new Object[]{serving.getCraftingRemainingItem().getHoverName()}), true);
            }

            return InteractionResult.PASS;
        }
    }
}
