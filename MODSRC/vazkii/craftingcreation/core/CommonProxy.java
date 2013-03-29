package vazkii.craftingcreation.core;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import vazkii.craftingcreation.CraftingCreation;
import vazkii.craftingcreation.block.ModBlocks;
import vazkii.craftingcreation.dim.BiomeCreation;
import vazkii.craftingcreation.dim.WorldProviderCreation;
import vazkii.craftingcreation.handler.ConfigurationHandler;
import vazkii.craftingcreation.handler.GuiHandler;
import vazkii.craftingcreation.handler.ItemNoSmuggleHandler;
import vazkii.craftingcreation.item.ModItems;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.loadConfig(event.getSuggestedConfigurationFile());
	}
	
	public void init(FMLInitializationEvent event) {
		initDimension();
		
		ModBlocks.initBlocks();
		ModItems.initItems();
		
		ModBlocks.nameBlocks();
		ModItems.nameItems();
		
		initTickHandler();
		
		MinecraftForge.EVENT_BUS.register(new ItemNoSmuggleHandler());
		
		NetworkRegistry.instance().registerGuiHandler(CraftingCreation.instance, new GuiHandler());
		
		initClient();
	}
	
	public void initTickHandler() {
		// TODO Add Server Tick handler
	}
	
	public void initClient() {
		// NO-OP
	}
	
	public void initDimension() {
		BiomeCreation.theBiome = new BiomeCreation(ConfigurationHandler.biomeID);
		DimensionManager.registerProviderType(ConfigurationHandler.dimID, WorldProviderCreation.class, false);
		DimensionManager.registerDimension(ConfigurationHandler.dimID, ConfigurationHandler.dimID);
	}

}
