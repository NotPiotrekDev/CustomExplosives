package pl.notpiotrekdev.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pl.notpiotrekdev.CustomExplosives;

public class ModBlocks {
    public static final Block DYNAMITE_BLOCK = registerBlock("dynamite_block", new DynamiteBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));
    public static final Block MINER_BLOCK = registerBlock("miner_block", new MinerBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CustomExplosives.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CustomExplosives.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        CustomExplosives.LOGGER.info("Registering Mod Blocks for " + CustomExplosives.MOD_ID);
    }
}
