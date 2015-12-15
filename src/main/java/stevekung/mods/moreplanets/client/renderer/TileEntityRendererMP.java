/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.renderer;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import stevekung.mods.moreplanets.client.renderer.tileentities.TileEntityAncientChestRenderer;
import stevekung.mods.moreplanets.client.renderer.tileentities.TileEntityTreasureChestRendererMP;
import stevekung.mods.moreplanets.common.util.EnumChestTexture;
import stevekung.mods.moreplanets.moons.koentus.tileentities.TileEntityKoentusAncientChest;
import stevekung.mods.moreplanets.planets.diona.tileentities.TileEntityDionaAncientChest;
import stevekung.mods.moreplanets.planets.diona.tileentities.TileEntityDionaTreasureChest;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityFronosAncientChest;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityFronosTreasureChest;
import stevekung.mods.moreplanets.planets.kapteynb.client.render.tileentities.TileEntityIcyPoisonCrystalRenderer;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityIcyPoisonCrystal;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityKapteynBAncientChest;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityKapteynBTreasureChest;
import stevekung.mods.moreplanets.planets.mercury.tileentities.TileEntityMercuryAncientChest;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruAncientChest;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruTreasureChest;
import stevekung.mods.moreplanets.planets.pluto.tileentities.TileEntityPlutoAncientChest;
import stevekung.mods.moreplanets.planets.pluto.tileentities.TileEntityPlutoTreasureChest;
import stevekung.mods.moreplanets.planets.polongnius.client.render.tileentities.TileEntityUltraVioletSolarPanelRenderer;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityPolongniusAncientChest;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityPolongniusTreasureChest;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityUltraVioletSolarPanel;
import stevekung.mods.moreplanets.planets.siriusb.tileentities.TileEntitySiriusBAncientChest;
import stevekung.mods.moreplanets.planets.siriusb.tileentities.TileEntitySiriusBTreasureChest;
import stevekung.mods.moreplanets.planets.venus.tileentities.TileEntityVenusAncientChest;

public class TileEntityRendererMP
{
    public static void registerTileEntityRenderers()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDionaTreasureChest.class, new TileEntityTreasureChestRendererMP(EnumChestTexture.DIONA));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPolongniusTreasureChest.class, new TileEntityTreasureChestRendererMP(EnumChestTexture.POLONGNIUS));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNibiruTreasureChest.class, new TileEntityTreasureChestRendererMP(EnumChestTexture.NIBIRU));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFronosTreasureChest.class, new TileEntityTreasureChestRendererMP(EnumChestTexture.FRONOS));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKapteynBTreasureChest.class, new TileEntityTreasureChestRendererMP(EnumChestTexture.KAPTEYN_B));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySiriusBTreasureChest.class, new TileEntityTreasureChestRendererMP(EnumChestTexture.SIRIUS_B));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlutoTreasureChest.class, new TileEntityTreasureChestRendererMP(EnumChestTexture.PLUTO));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDionaAncientChest.class, new TileEntityAncientChestRenderer(EnumChestTexture.DIONA));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPolongniusAncientChest.class, new TileEntityAncientChestRenderer(EnumChestTexture.POLONGNIUS));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNibiruAncientChest.class, new TileEntityAncientChestRenderer(EnumChestTexture.NIBIRU));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKoentusAncientChest.class, new TileEntityAncientChestRenderer(EnumChestTexture.KOENTUS));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFronosAncientChest.class, new TileEntityAncientChestRenderer(EnumChestTexture.FRONOS));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKapteynBAncientChest.class, new TileEntityAncientChestRenderer(EnumChestTexture.KAPTEYN_B));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySiriusBAncientChest.class, new TileEntityAncientChestRenderer(EnumChestTexture.SIRIUS_B));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMercuryAncientChest.class, new TileEntityAncientChestRenderer(EnumChestTexture.MERCURY));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVenusAncientChest.class, new TileEntityAncientChestRenderer(EnumChestTexture.VENUS));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlutoAncientChest.class, new TileEntityAncientChestRenderer(EnumChestTexture.PLUTO));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUltraVioletSolarPanel.class, new TileEntityUltraVioletSolarPanelRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIcyPoisonCrystal.class, new TileEntityIcyPoisonCrystalRenderer());
    }
}