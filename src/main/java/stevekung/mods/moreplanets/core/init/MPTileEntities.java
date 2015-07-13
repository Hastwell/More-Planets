/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.init;

import net.minecraftforge.fml.common.registry.GameRegistry;
import stevekung.mods.moreplanets.moons.koentus.tileentities.TileEntityEledosEgg;
import stevekung.mods.moreplanets.moons.koentus.tileentities.TileEntityKoentusAncientChest;
import stevekung.mods.moreplanets.moons.koentus.tileentities.TileEntityKoentusDungeonSpawner;
import stevekung.mods.moreplanets.moons.koentus.tileentities.TileEntityKoentusTreasureChest;
import stevekung.mods.moreplanets.planets.diona.tileentities.TileEntityDionaAncientChest;
import stevekung.mods.moreplanets.planets.diona.tileentities.TileEntityDionaDungeonSpawner;
import stevekung.mods.moreplanets.planets.diona.tileentities.TileEntityDionaTreasureChest;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityCandyExtractor;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityFronosAncientChest;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityFronosDungeonSpawner;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityFronosTreasureChest;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityMineralWaterGenerator;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityIcyPoisonCrystal;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityKapteynBAncientChest;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityKapteynBDungeonSpawner;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityKapteynBTreasureChest;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityUraniumWaste;
import stevekung.mods.moreplanets.planets.mercury.tileentities.TileEntityMercuryAncientChest;
import stevekung.mods.moreplanets.planets.mercury.tileentities.TileEntityMercuryDungeonSpawner;
import stevekung.mods.moreplanets.planets.mercury.tileentities.TileEntityMercuryTreasureChest;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruAncientChest;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruDungeonSpawner;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruTreasureChest;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityPowerCrystalGenerator;
import stevekung.mods.moreplanets.planets.pluto.tileentities.TileEntityPlutoAncientChest;
import stevekung.mods.moreplanets.planets.pluto.tileentities.TileEntityPlutoTreasureChest;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityPolongniusAncientChest;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityPolongniusDungeonSpawner;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityPolongniusTreasureChest;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityUltraVioletFake;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityUltraVioletSolarPanel;
import stevekung.mods.moreplanets.planets.siriusb.tileentities.TileEntitySiriusBAncientChest;
import stevekung.mods.moreplanets.planets.siriusb.tileentities.TileEntitySiriusBDungeonSpawner;
import stevekung.mods.moreplanets.planets.siriusb.tileentities.TileEntitySiriusBTreasureChest;
import stevekung.mods.moreplanets.planets.venus.tileentities.TileEntityVenusAncientChest;
import stevekung.mods.moreplanets.planets.venus.tileentities.TileEntityVenusTreasureChest;

public class MPTileEntities
{
	public static void init()
	{
		MPTileEntities.registerTileEntities();
	}

	private static void registerTileEntities()
	{
		// Diona
		GameRegistry.registerTileEntity(TileEntityDionaTreasureChest.class, "DionaTreasureChest");
		GameRegistry.registerTileEntity(TileEntityDionaDungeonSpawner.class, "DionaDungeonSpawner");
		GameRegistry.registerTileEntity(TileEntityDionaAncientChest.class, "DionaAncientChest");

		// Polongnius
		GameRegistry.registerTileEntity(TileEntityPolongniusTreasureChest.class, "PolongniusTreasureChest");
		GameRegistry.registerTileEntity(TileEntityUltraVioletSolarPanel.class, "UltraVioletSolarPanel");
		GameRegistry.registerTileEntity(TileEntityPolongniusAncientChest.class, "PolongniusAncientChest");
		GameRegistry.registerTileEntity(TileEntityPolongniusDungeonSpawner.class, "PolongniusDungeonSpawner");
		GameRegistry.registerTileEntity(TileEntityUltraVioletFake.class, "UltraVioletSolarFake");

		// Nibiru
		GameRegistry.registerTileEntity(TileEntityNibiruTreasureChest.class, "NibiruTreasureChest");
		GameRegistry.registerTileEntity(TileEntityNibiruAncientChest.class, "NibiruAncientChest");
		GameRegistry.registerTileEntity(TileEntityPowerCrystalGenerator.class, "PowerCrystalGenerator");
		GameRegistry.registerTileEntity(TileEntityNibiruDungeonSpawner.class, "NibiruDungeonSpawner");

		// Koentus
		GameRegistry.registerTileEntity(TileEntityKoentusTreasureChest.class, "KoentusTreasureChest");
		GameRegistry.registerTileEntity(TileEntityEledosEgg.class, "EledosEgg");
		GameRegistry.registerTileEntity(TileEntityKoentusAncientChest.class, "KoentusAncientChest");
		GameRegistry.registerTileEntity(TileEntityKoentusDungeonSpawner.class, "KoentusDungeonSpawner");

		// Fronos
		GameRegistry.registerTileEntity(TileEntityFronosTreasureChest.class, "FronosTreasureChest");
		GameRegistry.registerTileEntity(TileEntityCandyExtractor.class, "CandyExtractor");
		GameRegistry.registerTileEntity(TileEntityFronosAncientChest.class, "FronosAncientChest");
		GameRegistry.registerTileEntity(TileEntityFronosDungeonSpawner.class, "FronosDungeonSpawner");
		GameRegistry.registerTileEntity(TileEntityMineralWaterGenerator.class, "MineralWaterGenerator");

		// Kapteyn B
		GameRegistry.registerTileEntity(TileEntityKapteynBTreasureChest.class, "KapteynBTreasureChest");
		GameRegistry.registerTileEntity(TileEntityKapteynBAncientChest.class, "KapteynBAncientChest");
		GameRegistry.registerTileEntity(TileEntityKapteynBDungeonSpawner.class, "KapteynBDungeonSpawner");
		GameRegistry.registerTileEntity(TileEntityUraniumWaste.class, "UraniumWaste");
		GameRegistry.registerTileEntity(TileEntityIcyPoisonCrystal.class, "IcyPoisonCrystal");

		// Sirius B
		GameRegistry.registerTileEntity(TileEntitySiriusBTreasureChest.class, "SiriusBTreasureChest");
		GameRegistry.registerTileEntity(TileEntitySiriusBAncientChest.class, "SiriusBAncientChest");
		GameRegistry.registerTileEntity(TileEntitySiriusBDungeonSpawner.class, "SiriusBDungeonSpawner");

		// Mercury
		GameRegistry.registerTileEntity(TileEntityMercuryDungeonSpawner.class, "MercuryDungeonSpawner");
		GameRegistry.registerTileEntity(TileEntityMercuryAncientChest.class, "MercuryAncientChest");
		GameRegistry.registerTileEntity(TileEntityMercuryTreasureChest.class, "MercuryTreasureChest");

		// Venus
		GameRegistry.registerTileEntity(TileEntityVenusAncientChest.class, "VenusAncientChest");
		GameRegistry.registerTileEntity(TileEntityVenusTreasureChest.class, "VenusTreasureChest");

		// Pluto
		GameRegistry.registerTileEntity(TileEntityPlutoAncientChest.class, "PlutoAncientChest");
		GameRegistry.registerTileEntity(TileEntityPlutoTreasureChest.class, "PlutoTreasureChest");
	}
}