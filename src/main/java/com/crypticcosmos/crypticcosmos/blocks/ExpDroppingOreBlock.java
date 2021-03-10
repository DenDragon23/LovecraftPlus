package com.crypticcosmos.crypticcosmos.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nonnull;

public class ExpDroppingOreBlock extends OreBlock {
    private final int expDrop;

    public ExpDroppingOreBlock(Properties properties, int expDrop) {
        super(properties);

        this.expDrop = expDrop;
    }

    @Override
    public int getExpDrop(@Nonnull BlockState state, @Nonnull IWorldReader reader, @Nonnull BlockPos pos, int fortune, int silktouch) {
        return expDrop;
    }
}
