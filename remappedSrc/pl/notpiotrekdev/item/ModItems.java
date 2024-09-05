package pl.notpiotrekdev.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import pl.notpiotrekdev.CustomExplosives;

public class ModItems {
    public static final SwordItem SCYTHE = (SwordItem) registerItem("scythe", new Scythe(ModToolMaterial.STRANGE_IRON, 0, 10, new Item.Settings().rarity(Rarity.EPIC).maxCount(1)));
    public static final Item FLARE = registerItem("flare", new Flare(new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1).maxDamage(100)));
    public static final Item TEST = registerItem("test", new Test(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CustomExplosives.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CustomExplosives.LOGGER.info("Registering Mod Items for " + CustomExplosives.MOD_ID);
    }
}
