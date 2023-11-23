package cloudmeow.untameddelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.function.Supplier;

public class SourSunfishBrothBlock extends FeastBlock {
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 3);
    protected static final VoxelShape PLATE_SHAPE =  Shapes.or(Block.box(4, 0, 4, 12, 1, 12),
            Block.box(3, 1, 3, 4, 4, 13),
            Block.box(12, 1, 3, 13, 4, 13),
            Block.box(4, 1, 3, 12, 4, 4),
            Block.box(4, 1, 12, 12, 4, 13)
    );
    protected static final VoxelShape SOUP_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(4, 1, 4, 12, 4, 12), BooleanOp.OR);
    public SourSunfishBrothBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }

    public int getMaxServings() {
        return 3;
    }

    public IntegerProperty getServingsProperty() {
        return SERVINGS;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(SERVINGS) == 0 ? PLATE_SHAPE : SOUP_SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }
}
