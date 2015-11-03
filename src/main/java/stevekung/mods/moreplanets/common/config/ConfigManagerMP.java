/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;

import org.apache.logging.log4j.Level;

import stevekung.mods.moreplanets.common.util.MPLog;

public class ConfigManagerMP
{
	public static boolean loaded;

	static Configuration configuration;

	public static int idDimensionDiona;
	public static int idDimensionPolongnius;
	public static int idDimensionKoentus;
	public static int idDimensionNibiru;
	public static int idDimensionFronos;
	public static int idDimensionKapteynB;
	public static int idDimensionSiriusB;
	public static int idDimensionMercury;
	public static int idDimensionVenus;
	public static int idDimensionPluto;
	public static int idDimensionDeimos;
	public static int idDimensionPhobos;
	public static int idDimensionJupiterSpaceStation;
	public static int idDimensionStaticJupiterSpaceStation;
	public static int idDimensionJupiter;

	public static int idDionaBiome;
	public static int idPolongniusBiome;
	public static int idKoentusBiome;
	public static int idNibiruBiome;
	public static int idCoconutForestBiome;
	public static int idGoldenFieldBiome;
	public static int idPurpleMapleForestBiome;
	public static int idMapleForestBiome;
	public static int idGrassyPlainsBiome;
	public static int idCandyLandBiome;
	public static int idBiomeKapteynB;
	public static int idBiomeSiriusB;
	public static int idMercuryBiome;
	public static int idVenusBiome;
	public static int idPlutoBiome;
	public static int idDeimosBiome;
	public static int idPhobosBiome;
	public static int idIoBiome;
	public static int idMPSpaceStationBiome;

	public static int idSchematicTier4Rocket;
	public static int idSchematicTier4RocketNoFlag;
	public static int idSchematicTier5Rocket;
	public static int idSchematicTier5RocketNoFlag;
	public static int idSchematicTier6Rocket;
	public static int idSchematicTier6RocketNoFlag;
	public static int idSchematicTier7Rocket;
	public static int idSchematicTier8Rocket;

	public static int idGuiSchematicTier4Rocket;
	public static int idGuiSchematicTier4RocketNoFlag;
	public static int idGuiSchematicTier5Rocket;
	public static int idGuiSchematicTier5RocketNoFlag;
	public static int idGuiSchematicTier6Rocket;
	public static int idGuiSchematicTier6RocketNoFlag;
	public static int idGuiSchematicTier7Rocket;
	public static int idGuiSchematicTier8Rocket;

	public static int idPotionInfectedGas;
	public static int idPotionChemical;
	public static int idPotionEMP;
	public static int idPotionIcyPoison;

	public static boolean disableKoentusVillageGen;
	public static boolean disableMultipleCandyCaneRecipe;
	public static boolean disableInfectedGas;
	public static boolean allowMobCreatureSpawningOnFronos;
	public static boolean enableVersionCheck;
	public static boolean enableNewMainManu;
	public static boolean enableDebug;

	public static boolean enableMercuryPlanet;
	public static boolean enableVenusPlanet;
	public static boolean enablePlutoPlanet;
	public static boolean enablePhobosMoon;
	public static boolean enableDeimosMoon;
	public static boolean enableJupiterPlanet;
	public static boolean enableJupiterSpaceStation;

	public ConfigManagerMP(File file)
	{
		if (!ConfigManagerMP.loaded)
		{
			ConfigManagerMP.configuration = new Configuration(file);
			this.setDefaultValues();
		}
		MPLog.debug("Register Config Manager");
	}

	private void setDefaultValues()
	{
		try
		{
			ConfigManagerMP.configuration.load();

			// Dimensions
			ConfigManagerMP.idDimensionDiona = ConfigManagerMP.configuration.get("Dimensions", "Diona Dimension", -2542).getInt(-2542);
			ConfigManagerMP.idDimensionKoentus = ConfigManagerMP.configuration.get("Dimensions", "Koentus Dimension", -2543).getInt(2543);
			ConfigManagerMP.idDimensionPolongnius = ConfigManagerMP.configuration.get("Dimensions", "Polongnius Dimension", -2544).getInt(-2544);
			ConfigManagerMP.idDimensionNibiru = ConfigManagerMP.configuration.get("Dimensions", "Nibiru Dimension", -2545).getInt(-2545);
			ConfigManagerMP.idDimensionFronos = ConfigManagerMP.configuration.get("Dimensions", "Fronos Dimension", -2546).getInt(-2546);
			ConfigManagerMP.idDimensionKapteynB = ConfigManagerMP.configuration.get("Dimensions", "Kapteyn B Dimension", -2547).getInt(-2547);
			ConfigManagerMP.idDimensionSiriusB = ConfigManagerMP.configuration.get("Dimensions", "Sirius B Dimension", -2548).getInt(-2548);
			ConfigManagerMP.idDimensionMercury = ConfigManagerMP.configuration.get("Dimensions", "Mercury Dimension", -2549).getInt(-2549);
			ConfigManagerMP.idDimensionVenus = ConfigManagerMP.configuration.get("Dimensions", "Venus Dimension", -2550).getInt(-2550);
			ConfigManagerMP.idDimensionPluto = ConfigManagerMP.configuration.get("Dimensions", "Pluto Dimension", -2551).getInt(-2551);
			ConfigManagerMP.idDimensionDeimos = ConfigManagerMP.configuration.get("Dimensions", "Deimos Dimension", -2552).getInt(-2552);
			ConfigManagerMP.idDimensionPhobos = ConfigManagerMP.configuration.get("Dimensions", "Phobos Dimension", -2553).getInt(-2553);
			ConfigManagerMP.idDimensionJupiterSpaceStation = ConfigManagerMP.configuration.get("Dimensions", "Jupiter Space Station Dimension", -2600).getInt(-2600);
			ConfigManagerMP.idDimensionStaticJupiterSpaceStation = ConfigManagerMP.configuration.get("Dimensions", "Jupiter Static Space Station Dimension", -2601).getInt(-2601);

			ConfigManagerMP.idDimensionJupiter = ConfigManagerMP.configuration.get("Dimensions", "Jupiter Dimension", -5000).getInt(-5000);

			// Generals
			ConfigManagerMP.disableKoentusVillageGen = ConfigManagerMP.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Koentus Village Gen", false).getBoolean(false);
			ConfigManagerMP.disableMultipleCandyCaneRecipe = ConfigManagerMP.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Multiple Candy Tools Recipe", true, "If set this to false. Candy Tools, Candy Bow and Poison Arrow can crafted by any candy cane. Default is true.").getBoolean(true);
			ConfigManagerMP.disableInfectedGas = ConfigManagerMP.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Infected Gas on Nibiru", false, "If you disable this option. When you mining any blocks on the Nibiru you will getting Infected Gas. and Infected Gas does not affected when equipped Purple Crystal Armor. Default is false.").getBoolean(false);
			ConfigManagerMP.allowMobCreatureSpawningOnFronos = ConfigManagerMP.configuration.get(Configuration.CATEGORY_GENERAL, "Allow Overworld Mobs/Creatures Spawning on Fronos Planet", false, "If set this to true. Overworld mobs and creatures will be spawning on Fronos by default, but this will disabled Galacticraft evolved mob spawning. Default is false.").getBoolean(false);
			ConfigManagerMP.enableVersionCheck = ConfigManagerMP.configuration.get(Configuration.CATEGORY_GENERAL, "Enable Version Check", true).getBoolean(true);
			ConfigManagerMP.enableNewMainManu = ConfigManagerMP.configuration.get(Configuration.CATEGORY_GENERAL, "Enable New Main Manu", true).getBoolean(true);
			ConfigManagerMP.enableDebug = ConfigManagerMP.configuration.get(Configuration.CATEGORY_GENERAL, "Enable Debug Log", false).getBoolean(false);

			// Biomes
			ConfigManagerMP.idDionaBiome = ConfigManagerMP.configuration.get("Biomes", "Diona Biome", 220).getInt(220);
			ConfigManagerMP.idPolongniusBiome = ConfigManagerMP.configuration.get("Biomes", "Polongnius Biome", 221).getInt(221);
			ConfigManagerMP.idNibiruBiome = ConfigManagerMP.configuration.get("Biomes", "Nibiru Biome", 222).getInt(222);
			ConfigManagerMP.idKoentusBiome = ConfigManagerMP.configuration.get("Biomes", "Koentus Biome", 223).getInt(223);
			ConfigManagerMP.idCoconutForestBiome = ConfigManagerMP.configuration.get("Biomes", "Coconut Forest (Fronos Biome)", 224).getInt(224);
			ConfigManagerMP.idBiomeKapteynB = ConfigManagerMP.configuration.get("Biomes", "Kapteyn B Biome", 225).getInt(225);
			ConfigManagerMP.idBiomeSiriusB = ConfigManagerMP.configuration.get("Biomes", "Sirius B Biome", 226).getInt(226);
			ConfigManagerMP.idGoldenFieldBiome = ConfigManagerMP.configuration.get("Biomes", "Golden Field (Fronos Biome)", 244).getInt(244);
			ConfigManagerMP.idPurpleMapleForestBiome = ConfigManagerMP.configuration.get("Biomes", "Purple Maple Forest (Fronos Biome)", 245).getInt(245);
			ConfigManagerMP.idMapleForestBiome = ConfigManagerMP.configuration.get("Biomes", "Maple Forest (Fronos Biome)", 246).getInt(246);
			ConfigManagerMP.idGrassyPlainsBiome = ConfigManagerMP.configuration.get("Biomes", "Grassy Plains (Fronos Biome)", 247).getInt(247);
			ConfigManagerMP.idCandyLandBiome = ConfigManagerMP.configuration.get("Biomes", "Candy Land (Fronos Biome)", 248).getInt(248);
			ConfigManagerMP.idMercuryBiome = ConfigManagerMP.configuration.get("Biomes", "Mercury Biome", 240).getInt(240);
			ConfigManagerMP.idVenusBiome = ConfigManagerMP.configuration.get("Biomes", "Venus Biome", 241).getInt(241);
			ConfigManagerMP.idPlutoBiome = ConfigManagerMP.configuration.get("Biomes", "Pluto Biome", 242).getInt(242);
			ConfigManagerMP.idDeimosBiome = ConfigManagerMP.configuration.get("Biomes", "Deimos Biome", 210).getInt(210);
			ConfigManagerMP.idPhobosBiome = ConfigManagerMP.configuration.get("Biomes", "Phobos Biome", 211).getInt(211);
			ConfigManagerMP.idIoBiome = ConfigManagerMP.configuration.get("Biomes", "Io Biome", 212).getInt(212);
			ConfigManagerMP.idMPSpaceStationBiome = ConfigManagerMP.configuration.get("Biomes", "More Planets Space Station Biome", 130).getInt(130);

			// Schematics
			ConfigManagerMP.idSchematicTier4Rocket = ConfigManagerMP.configuration.get("Schematics", "Schematic Tier 4 Rocket", 784).getInt(784);
			ConfigManagerMP.idSchematicTier4RocketNoFlag = ConfigManagerMP.configuration.get("Schematics", "Schematic Tier 4 Rocket No Flag", 785).getInt(785);
			ConfigManagerMP.idSchematicTier5Rocket = ConfigManagerMP.configuration.get("Schematics", "Schematic Tier 5 Rocket", 786).getInt(786);
			ConfigManagerMP.idSchematicTier5RocketNoFlag = ConfigManagerMP.configuration.get("Schematics", "Schematic Tier 5 Rocket No Flag", 787).getInt(787);
			ConfigManagerMP.idSchematicTier6Rocket = ConfigManagerMP.configuration.get("Schematics", "Schematic Tier 6 Rocket", 788).getInt(788);
			ConfigManagerMP.idSchematicTier6RocketNoFlag = ConfigManagerMP.configuration.get("Schematics", "Schematic Tier 6 Rocket No Flag", 789).getInt(789);
			ConfigManagerMP.idSchematicTier7Rocket = ConfigManagerMP.configuration.get("Schematics", "Schematic Tier 7 Rocket", 790).getInt(790);
			ConfigManagerMP.idSchematicTier8Rocket = ConfigManagerMP.configuration.get("Schematics", "Schematic Tier 8 Rocket", 791).getInt(791);

			// GUIs
			ConfigManagerMP.idGuiSchematicTier4Rocket = ConfigManagerMP.configuration.get("GUI", "GUI Tier 4 Rocket", 428).getInt(428);
			ConfigManagerMP.idGuiSchematicTier4RocketNoFlag = ConfigManagerMP.configuration.get("GUI", "GUI Tier 4 Rocket No Flag", 429).getInt(429);
			ConfigManagerMP.idGuiSchematicTier5Rocket = ConfigManagerMP.configuration.get("GUI", "GUI Tier 5 Rocket", 430).getInt(430);
			ConfigManagerMP.idGuiSchematicTier5RocketNoFlag = ConfigManagerMP.configuration.get("GUI", "GUI Tier 5 Rocket No Flag", 431).getInt(431);
			ConfigManagerMP.idGuiSchematicTier6Rocket = ConfigManagerMP.configuration.get("GUI", "GUI Tier 6 Rocket", 432).getInt(432);
			ConfigManagerMP.idGuiSchematicTier6RocketNoFlag = ConfigManagerMP.configuration.get("GUI", "GUI Tier 6 Rocket No Flag", 433).getInt(433);
			ConfigManagerMP.idGuiSchematicTier7Rocket = ConfigManagerMP.configuration.get("GUI", "GUI Tier 7 Rocket", 434).getInt(434);
			ConfigManagerMP.idGuiSchematicTier8Rocket = ConfigManagerMP.configuration.get("GUI", "GUI Tier 8 Rocket", 435).getInt(435);

			// Potions
			ConfigManagerMP.idPotionInfectedGas = ConfigManagerMP.configuration.get("Potions", "Infected Gas", 60).getInt(60);
			ConfigManagerMP.idPotionChemical = ConfigManagerMP.configuration.get("Potions", "Chemical", 61).getInt(61);
			ConfigManagerMP.idPotionEMP = ConfigManagerMP.configuration.get("Potions", "EMP", 62).getInt(62);
			ConfigManagerMP.idPotionIcyPoison = ConfigManagerMP.configuration.get("Potions", "Icy Poison", 63).getInt(63);

			// Planets
			ConfigManagerMP.enableMercuryPlanet = ConfigManagerMP.configuration.get("Planets", "Enable Mercury Planet", true).getBoolean(true);
			ConfigManagerMP.enableVenusPlanet = ConfigManagerMP.configuration.get("Planets", "Enable Venus Planet", true).getBoolean(true);
			ConfigManagerMP.enablePlutoPlanet = ConfigManagerMP.configuration.get("Planets", "Enable Pluto Planet", true).getBoolean(true);
			ConfigManagerMP.enableJupiterPlanet = ConfigManagerMP.configuration.get("Planets", "Enable Jupiter Planet", true).getBoolean(true);

			// Moons
			ConfigManagerMP.enablePhobosMoon = ConfigManagerMP.configuration.get("Moons", "Enable Phobos Moon", true).getBoolean(true);
			ConfigManagerMP.enableDeimosMoon = ConfigManagerMP.configuration.get("Moons", "Enable Deimos Moon", true).getBoolean(true);

			// Space Stations
			ConfigManagerMP.enableJupiterSpaceStation = ConfigManagerMP.configuration.get("Space Stations", "Enable Mars Space Station", true).getBoolean(true);

		}
		catch (Exception e)
		{
			FMLLog.log(Level.ERROR, e, "More Planets has a problem loading it's configuration");
		}
		finally
		{
			ConfigManagerMP.configuration.save();
			ConfigManagerMP.loaded = true;
		}
	}
}