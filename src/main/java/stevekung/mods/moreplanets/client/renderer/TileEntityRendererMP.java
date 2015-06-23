/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.renderer;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import stevekung.mods.moreplanets.moons.koentus.client.render.tileentities.TileEntityKoentusAncientChestRenderer;
import stevekung.mods.moreplanets.moons.koentus.tileentities.TileEntityKoentusAncientChest;
import stevekung.mods.moreplanets.planets.diona.client.render.tileentities.TileEntityDionaAncientChestRenderer;
import stevekung.mods.moreplanets.planets.diona.tileentities.TileEntityDionaAncientChest;
import stevekung.mods.moreplanets.planets.fronos.client.render.tileentities.TileEntityFronosAncientChestRenderer;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityFronosAncientChest;
import stevekung.mods.moreplanets.planets.kapteynb.client.render.tileentities.TileEntityIcyPoisonCrystalRenderer;
import stevekung.mods.moreplanets.planets.kapteynb.client.render.tileentities.TileEntityKapteynBAncientChestRenderer;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityIcyPoisonCrystal;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityKapteynBAncientChest;
import stevekung.mods.moreplanets.planets.mercury.client.render.tileentities.TileEntityMercuryAncientChestRenderer;
import stevekung.mods.moreplanets.planets.mercury.tileentities.TileEntityMercuryAncientChest;
import stevekung.mods.moreplanets.planets.nibiru.client.render.tileentities.TileEntityNibiruAncientChestRenderer;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruAncientChest;
import stevekung.mods.moreplanets.planets.pluto.client.render.tileentities.TileEntityPlutoAncientChestRenderer;
import stevekung.mods.moreplanets.planets.pluto.tileentities.TileEntityPlutoAncientChest;
import stevekung.mods.moreplanets.planets.polongnius.client.render.tileentities.TileEntityPolongniusAncientChestRenderer;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityPolongniusAncientChest;
import stevekung.mods.moreplanets.planets.siriusb.client.render.tileentities.TileEntitySiriusBAncientChestRenderer;
import stevekung.mods.moreplanets.planets.siriusb.tileentities.TileEntitySiriusBAncientChest;
import stevekung.mods.moreplanets.planets.venus.client.render.tileentities.TileEntityVenusAncientChestRenderer;
import stevekung.mods.moreplanets.planets.venus.tileentities.TileEntityVenusAncientChest;

public class TileEntityRendererMP
{
	public static void registerTileEntityRenderers()
	{
		//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDionaTreasureChest.class, new TileEntityDionaTreasureChestRenderer());
		//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPolongniusTreasureChest.class, new TileEntityPolongniusTreasureChestRenderer());
		//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNibiruTreasureChest.class, new TileEntityNibiruTreasureChestRenderer());
		//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKoentusTreasureChest.class, new TileEntityKoentusTreasureChestRenderer());
		//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFronosTreasureChest.class, new TileEntityFronosTreasureChestRenderer());
		//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKapteynBTreasureChest.class, new TileEntityKapteynBTreasureChestRenderer());
		//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySiriusBTreasureChest.class, new TileEntitySiriusBTreasureChestRenderer());
		//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMercuryTreasureChest.class, new TileEntityMercuryTreasureChestRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDionaAncientChest.class, new TileEntityDionaAncientChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPolongniusAncientChest.class, new TileEntityPolongniusAncientChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNibiruAncientChest.class, new TileEntityNibiruAncientChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKoentusAncientChest.class, new TileEntityKoentusAncientChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFronosAncientChest.class, new TileEntityFronosAncientChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKapteynBAncientChest.class, new TileEntityKapteynBAncientChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySiriusBAncientChest.class, new TileEntitySiriusBAncientChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMercuryAncientChest.class, new TileEntityMercuryAncientChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVenusAncientChest.class, new TileEntityVenusAncientChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlutoAncientChest.class, new TileEntityPlutoAncientChestRenderer());

		//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUltraVioletSolarPanel.class, new TileEntityUltraVioletSolarPanelRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIcyPoisonCrystal.class, new TileEntityIcyPoisonCrystalRenderer());
	}
}