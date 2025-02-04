package net.mehvahdjukaar.supplementaries.common.block.blocks;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.mehvahdjukaar.supplementaries.common.configs.ServerConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class CandleHolderBlock extends SconceWallBlock {

    private static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, Block.box(6D, 2.0D, 11D, 10D, 13.0D, 16.0D),
            Direction.SOUTH, Block.box(6D, 2.0D, 0.0D, 10D, 13.0D, 5D),
            Direction.WEST, Block.box(11D, 2.0D, 6D, 16.0D, 13.0D, 10D),
            Direction.EAST, Block.box(0.0D, 2.0D, 6D, 5D, 13.0D, 10D)));

    public CandleHolderBlock(Properties properties, Supplier<SimpleParticleType> particleData) {
        super(properties, particleData);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH).setValue(LIT, true));
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        return ServerConfigs.cached.CANDLE_HOLDER_LIGHT;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        if (stateIn.getValue(LIT)) {
            Direction direction = stateIn.getValue(FACING);
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY() + 0.8;
            double d2 = (double) pos.getZ() + 0.5D;
            Direction direction1 = direction.getOpposite();
            worldIn.addParticle(ParticleTypes.SMOKE, d0 + 0.3125 * (double) direction1.getStepX(), d1, d2 + 0.3125 * (double) direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
            worldIn.addParticle(this.particleData.get(), d0 + 0.3125 * (double) direction1.getStepX(), d1, d2 + 0.3125 * (double) direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
        }
    }

}
