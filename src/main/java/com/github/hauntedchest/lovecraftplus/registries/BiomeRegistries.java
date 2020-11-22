package com.github.hauntedchest.lovecraftplus.registries;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.world.biomes.*;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeRegistries {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, LovecraftPlus.MOD_ID);

    public static final SurfaceBuilderConfig GRASS_STONE_SAND = new SurfaceBuilderConfig(
            Blocks.GRASS_BLOCK.getDefaultState(),
            Blocks.STONE.getDefaultState(),
            Blocks.SAND.getDefaultState()
    );

    public static final RegistryObject<Biome> THORN_JUNGLE = BIOMES.register(
            "thorn_jungle",
            () -> new ThornJungleBiome(new Biome.Builder()
                    .scale(1f)
                    .temperature(0.2f)
                    .waterColor(0x465623)
                    .waterFogColor(0x88ba40)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT, BiomeRegistries.GRASS_STONE_SAND)
                    .category(Biome.Category.JUNGLE)
                    .downfall(0.0001f)
                    .depth(0.125f)
                    .parent(null)
                    .precipitation(Biome.RainType.RAIN))
    );

    // moon biomes
    public static final RegistryObject<VulvonPlainsBiome> VULVON_PLAINS = BIOMES.register(
            "vulvon_plains",
            () -> new VulvonPlainsBiome(new Biome.Builder()
                    .scale(1f)
                    .temperature(0f)
                    .waterColor(0xfffff5)
                    .waterFogColor(0xfffff5)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    BlockRegistries.MOONCALITE.get().getDefaultState(),
                                    BlockRegistries.MOONSTONE.get().getDefaultState(),
                                    BlockRegistries.MOONCALITE.get().getDefaultState()))
                    .category(Biome.Category.PLAINS)
                    .downfall(0.0001f)
                    .depth(0.125f)
                    .parent(null)
                    .precipitation(Biome.RainType.RAIN))
    );
    public static final RegistryObject<MoonMountainsBiome> MOON_MOUNTAINS = BIOMES.register(
            "moon_mountains",
            () -> new MoonMountainsBiome(new Biome.Builder()
                    .scale(1f)
                    .temperature(0f)
                    .waterColor(0xfffff5)
                    .waterFogColor(0xfffff5)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    BlockRegistries.MOONCALITE.get().getDefaultState(),
                                    BlockRegistries.MOONSTONE.get().getDefaultState(),
                                    BlockRegistries.MOONCALITE.get().getDefaultState()
                            ))
                    .category(Biome.Category.EXTREME_HILLS)
                    .downfall(0.0001f)
                    .depth(0.125f)
                    .parent(null)
                    .precipitation(Biome.RainType.RAIN))
    );
    public static final RegistryObject<MondroveGroveBiome> MONDROVE_GROVE = BIOMES.register(
            "mondrove_grove",
            () -> new MondroveGroveBiome(new Biome.Builder()
                    .scale(1f)
                    .temperature(0f)
                    .waterColor(0xfffff5)
                    .waterFogColor(0xfffff5)
                    .surfaceBuilder(
                            SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    BlockRegistries.MOONCALITE.get().getDefaultState(),
                                    BlockRegistries.MOONSTONE.get().getDefaultState(),
                                    BlockRegistries.MOONCALITE.get().getDefaultState()
                            )
                    )
                    .category(Biome.Category.FOREST)
                    .downfall(0.0001f)
                    .depth(0.125f)
                    .parent(null)
                    .precipitation(Biome.RainType.RAIN))
    );

    public static void registerBiomes() {
        registerBiome(THORN_JUNGLE.get(), true, Type.JUNGLE, Type.LUSH, Type.OVERWORLD, Type.SPOOKY);
        registerBiome(BiomeRegistries.VULVON_PLAINS.get(), false, Type.PLAINS, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        registerBiome(BiomeRegistries.MOON_MOUNTAINS.get(), false, Type.MOUNTAIN, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        registerBiome(BiomeRegistries.MONDROVE_GROVE.get(), false, Type.FOREST, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);

    }

    private static void registerBiome(Biome biome, boolean addBiome, Type... types) {
        if (addBiome) {
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 25));
        }

        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
