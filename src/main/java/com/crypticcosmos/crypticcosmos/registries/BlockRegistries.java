package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.blocks.*;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistries {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CrypticCosmos.MOD_ID);

    //Portal Blocks
    public static final RegistryObject<Block> HUMMING_STONE = BLOCKS.register("humming_stone", () ->
            new ExpDroppingOreBlock(
                    Properties.of(Material.STONE)
                            .strength(6.0f, 34)
                            .sound(SoundType.STONE)
                            .harvestLevel(3)
                            .harvestTool(ToolType.PICKAXE)
                            .requiresCorrectToolForDrops(),
                    3
            )
    );

    public static final RegistryObject<Block> HUMMING_OBSIDIAN = BLOCKS.register("humming_obsidian", () ->
            new Block(Properties.of(Material.STONE)
                    .strength(50.0F, 1200.0F)
                    .sound(SoundType.STONE)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops())
    );

    // Overgrown Lunon
    public static final RegistryObject<Block> OVERGROWN_LUNON = BLOCKS.register("overgrown_lunon", OvergrownLunonBlock::new);

    // Lunon
    public static final RegistryObject<Block> LUNON = BLOCKS.register("lunon", () ->
            new Block(Properties.of(Material.STONE)
                    .strength(2.0f, 10)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops())
    );

    public static final RegistryObject<Block> LUNON_BRICKS = BLOCKS.register("lunon_bricks", () ->
            new Block(Properties.of(Material.STONE)
                    .strength(4.0f, 15)
                    .sound(SoundType.STONE)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops())
    );

    public static final RegistryObject<Block> LUNON_BRICK_SLAB = BLOCKS.register("lunon_brick_slab", () ->
            new SlabBlock(Properties.copy(LUNON_BRICKS.get()))
    );

    public static final RegistryObject<Block> LUNON_BRICK_STAIRS = BLOCKS.register("lunon_brick_stairs", () ->
            new StairsBlock(() -> LUNON_BRICKS.get().defaultBlockState(), Properties.copy(LUNON_BRICKS.get()))
    );

    public static final RegistryObject<Block> POLISHED_LUNON = BLOCKS.register("polished_lunon", () ->
            new Block(Properties.copy(LUNON_BRICKS.get()))
    );

    public static final RegistryObject<Block> POLISHED_LUNON_SLAB = BLOCKS.register("polished_lunon_slab", () ->
            new SlabBlock(Properties.copy(POLISHED_LUNON.get()))
    );

    public static final RegistryObject<Block> CHISELED_POLISHED_LUNON = BLOCKS.register("chiseled_polished_lunon", () ->
            new Block(Properties.copy(POLISHED_LUNON.get()))
    );

    public static final RegistryObject<Block> LUNON_DUST = BLOCKS.register("lunon_dust", () ->
            new SandBlock(22, Properties.of(Material.SAND)
                    .strength(0.5F)
                    .sound(SoundType.SAND))
    );

    //Moon Wood
    public static final RegistryObject<Block> MONDROVE_LOG = BLOCKS.register("mondrove_log", MoonLog::new);

    public static final RegistryObject<Block> MONDROVE_PLANKS = BLOCKS.register("mondrove_planks", MoonPlanks::new);

    public static final RegistryObject<Block> MONDROVE_SAPLING = BLOCKS.register("mondrove_sapling", MoonSapling::new);

    public static final RegistryObject<Block> MONDROVE_LEAVES = BLOCKS.register("mondrove_leaves", () ->
            new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES))
    );

    public static final RegistryObject<Block> MONDROVE_FUNGUS = BLOCKS.register("mondrove_fungus", MondroveFungus::new);

    //Other Blocks
    public static final RegistryObject<Block> LAVA_SPONGE = BLOCKS.register("lava_sponge", LavaSponge::new);

    public static final RegistryObject<Block> MOLTEN_LAVA_SPONGE =
            BLOCKS.register("molten_lava_sponge", MoltenLavaSponge::new);

    public static final RegistryObject<Block> RIFT_BLOCK = BLOCKS.register("rift_block", RiftBlock::new);

    // Umbral Plains
    public static final RegistryObject<Block> UMBRAL_DUNE = BLOCKS.register("umbral_dune", () ->
            new SandBlock(22, Properties.of(Material.SAND)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));
}

