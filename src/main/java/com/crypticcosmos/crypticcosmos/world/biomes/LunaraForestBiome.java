package com.crypticcosmos.crypticcosmos.world.biomes;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraftforge.common.IPlantable;

public class LunaraForestBiome extends Biome {
    public static final BlockClusterFeatureConfig MONDROVE_FUNGUS_CONFIG =
            new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider()
                    .addWeightedBlockstate(BlockRegistries.MONDROVE_FUNGUS.get().getDefaultState(), 2),
                    new SimpleBlockPlacer()
            ).tries(64).build();
    public static final TreeFeatureConfig MOON_TREE_CONFIG = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockRegistries.MONDROVE_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockRegistries.MONDROVE_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))
            .baseHeight(5)
            .heightRandA(2)
            .foliageHeight(3)
            .ignoreVines()
            .decorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F)))
            .setSapling((IPlantable) BlockRegistries.MONDROVE_SAPLING.get())
            .build();

    public LunaraForestBiome(Biome.Builder builder) {
        super(builder);

        this.addSpawn(
                EntityClassification.MONSTER,
                new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4)
        );

        DefaultBiomeFeatures.addCarvers(this);

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.NORMAL_TREE
                        .withConfiguration(MOON_TREE_CONFIG)
                        .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
                                .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1)))
        );

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(MONDROVE_FUNGUS_CONFIG)
                        .withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }
}
