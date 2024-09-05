package pl.notpiotrekdev;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.notpiotrekdev.block.ModBlocks;
import pl.notpiotrekdev.item.ModItems;

public class CustomExplosives implements ModInitializer {
	public static final String MOD_ID = "customexplosives";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Mod is loading..");
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		LOGGER.info("Mod loaded!");
	}
}