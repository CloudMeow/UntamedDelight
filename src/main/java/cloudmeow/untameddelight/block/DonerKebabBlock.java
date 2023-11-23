package cloudmeow.untameddelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.function.Supplier;

public class DonerKebabBlock extends FeastBlock {
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 5);
    protected static final VoxelShape IRON_BAR = Shapes.or(
            Block.box(7, 1, 7, 9, 32, 9),
            Block.box(1, 0, 1, 15, 1, 15));
    protected static final VoxelShape MEAT_SHAPE = Shapes.joinUnoptimized(IRON_BAR, Block.box(5, 7, 5, 11, 27, 11), BooleanOp.OR);

    public DonerKebabBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }

    public int getMaxServings() {
        return 5;
    }

    public IntegerProperty getServingsProperty() {
        return SERVINGS;
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
                if (heldStack.is(ModTags.KNIVES)) {
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

                    level.playSound((Player)null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return InteractionResult.SUCCESS;
                }

                player.displayClientMessage(Component.translatable("untameddelight.block.kebab.use_container"),true);
            }

            return InteractionResult.PASS;
        }
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(SERVINGS) == 0 ? IRON_BAR : MEAT_SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }
}
