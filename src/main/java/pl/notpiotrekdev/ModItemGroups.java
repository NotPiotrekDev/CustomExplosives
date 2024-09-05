package pl.notpiotrekdev;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pl.notpiotrekdev.block.ModBlocks;
import pl.notpiotrekdev.item.ModItems;

public class ModItemGroups {
    public static final ItemGroup CUSTOMEXPLOSIVES_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(CustomExplosives.MOD_ID, "customexplosives"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.customexplosives")).icon(() -> new ItemStack(ModItems.SCYTHE)).entries((displayContext, entries) -> {
        entries.add(ModItems.SCYTHE);
        entries.add(ModItems.FLARE);

        entries.add(ModBlocks.DYNAMITE_BLOCK);
        entries.add(ModBlocks.MINER_BLOCK);
    }).build());

    public static void registerItemGroups() {
        CustomExplosives.LOGGER.info("Registering Item Groups for " + CustomExplosives.MOD_ID);
    }
}
