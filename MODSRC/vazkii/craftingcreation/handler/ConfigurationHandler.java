package vazkii.craftingcreation.handler;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigurationHandler {
	
	public static int blockIDCreationClay = 240,
					blockIDCreationClayBreakable = 941,
					blockIDCreationBricks = 942,
					blockIDPortal = 943,
					blockIDKiln = 944,
					blockIDAltar = 945,
					blockIDCreationChest = 946,
					blockIDBeacon = 947,
					blockIDInvisibleWall = 948,
					blockIDSmokeyBlock = 949;
	
	public static int itemIDCreationClay = 14320,
					itemIDCreationClaySword = 14321,
					itemIDCreationClayPick = 14322,
					itemIDCreationClayAxe = 14323,
					itemIDCreationClayShovel = 13324,
					itemIDCreationClayHelmet = 13325,
					itemIDCreationClayChestplate = 13326,
					itemIDCreationClayLeggings = 13327,
					itemIDCreationClayBoots = 13328,
					itemIDCreationClayApple = 13329,
					itemIDCreationClayBow = 13330,
					itemIDCreationClayArrow = 13331,
					itemIDCreationStar = 13332;
	
	public static int dimID = 19;
	public static int biomeID = 39;
	
	private static Configuration config;
	
	public static void loadConfig(File file) {
		config = new Configuration(file);
		
		config.load();
		
		dimID = config.get(Configuration.CATEGORY_GENERAL, "dimensionID", dimID).getInt(dimID);
		biomeID = config.get(Configuration.CATEGORY_GENERAL, "biomeID", biomeID).getInt(biomeID);
		
		blockIDCreationClay = loadTerrainBlock("creationClay", blockIDCreationClay);
		blockIDCreationClayBreakable = loadBlock("creationClayBreakable", blockIDCreationClayBreakable);
		blockIDCreationBricks = loadBlock("creationBricks", blockIDCreationBricks);
		blockIDPortal = loadBlock("portal", blockIDPortal);
		blockIDKiln = loadBlock("kiln", blockIDKiln);
		blockIDBeacon = loadBlock("beacon", blockIDBeacon);
		blockIDInvisibleWall = loadBlock("invisibleWall", blockIDInvisibleWall);
		blockIDSmokeyBlock = loadBlock("smokeyBlock", blockIDSmokeyBlock);

		itemIDCreationClay = loadItem("creationClayItem", itemIDCreationClay);
		itemIDCreationClaySword = loadItem("creationClaySword", itemIDCreationClaySword);
		itemIDCreationClayPick = loadItem("creationClayPick", itemIDCreationClayPick);
		itemIDCreationClayAxe = loadItem("creationClayAxe", itemIDCreationClayAxe);
		itemIDCreationClayShovel = loadItem("creationClayShovel", itemIDCreationClayShovel);
		itemIDCreationClayHelmet = loadItem("creationClayHelmet", itemIDCreationClayHelmet);
		itemIDCreationClayChestplate = loadItem("creationClayChestplate", itemIDCreationClayChestplate);
		itemIDCreationClayLeggings = loadItem("creationClayLeggings", itemIDCreationClayLeggings);
		itemIDCreationClayBoots = loadItem("creationClayBoots", itemIDCreationClayBoots);
		itemIDCreationClayApple = loadItem("creationClayApple", itemIDCreationClayApple);
		itemIDCreationClayBow = loadItem("creationClayBow", itemIDCreationClayBow);
		itemIDCreationClayArrow = loadItem("creationClayArrow", itemIDCreationClayArrow);
		itemIDCreationStar = loadItem("creationStar", itemIDCreationStar);

		config.save();
	}

	public static int loadTerrainBlock(String label, int defaultID) {
		return config.getTerrainBlock(config.CATEGORY_BLOCK, label, defaultID, null).getInt();
	}
	
	public static int loadBlock(String label, int defaultID) {
		return config.getBlock(label, defaultID).getInt(defaultID);
	}
	
	public static int loadItem(String label, int defaultID) {
		return config.getItem(label, defaultID).getInt(defaultID);
	}
}
