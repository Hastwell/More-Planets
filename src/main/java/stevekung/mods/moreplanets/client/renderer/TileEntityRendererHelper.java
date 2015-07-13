/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.moons.koentus.tileentities.TileEntityKoentusAncientChest;
import stevekung.mods.moreplanets.moons.koentus.tileentities.TileEntityKoentusTreasureChest;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.diona.tileentities.TileEntityDionaAncientChest;
import stevekung.mods.moreplanets.planets.diona.tileentities.TileEntityDionaTreasureChest;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityFronosAncientChest;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityFronosTreasureChest;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityIcyPoisonCrystal;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityKapteynBAncientChest;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityKapteynBTreasureChest;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.mercury.tileentities.TileEntityMercuryAncientChest;
import stevekung.mods.moreplanets.planets.mercury.tileentities.TileEntityMercuryTreasureChest;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruAncientChest;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruTreasureChest;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.pluto.tileentities.TileEntityPlutoAncientChest;
import stevekung.mods.moreplanets.planets.pluto.tileentities.TileEntityPlutoTreasureChest;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityPolongniusAncientChest;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityPolongniusTreasureChest;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.siriusb.tileentities.TileEntitySiriusBAncientChest;
import stevekung.mods.moreplanets.planets.siriusb.tileentities.TileEntitySiriusBTreasureChest;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;
import stevekung.mods.moreplanets.planets.venus.tileentities.TileEntityVenusAncientChest;
import stevekung.mods.moreplanets.planets.venus.tileentities.TileEntityVenusTreasureChest;

@SideOnly(Side.CLIENT)
public class TileEntityRendererHelper extends TileEntityItemStackRenderer
{
	@Override
	public void renderByItem(ItemStack itemStack)
	{
		Block block = Block.getBlockFromItem(itemStack.getItem());

		if (block == DionaBlocks.diona_ancient_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityDionaAncientChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == DionaBlocks.diona_treasure_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityDionaTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == PolongniusBlocks.polongnius_ancient_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPolongniusAncientChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == PolongniusBlocks.polongnius_treasure_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPolongniusTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == NibiruBlocks.nibiru_ancient_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityNibiruAncientChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == NibiruBlocks.nibiru_treasure_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityNibiruTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == KoentusBlocks.koentus_ancient_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityKoentusAncientChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == KoentusBlocks.koentus_treasure_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityKoentusTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == FronosBlocks.fronos_ancient_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityFronosAncientChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == FronosBlocks.fronos_treasure_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityFronosTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == KapteynBBlocks.kapteyn_b_ancient_chest)
		{
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(770, 771);
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityKapteynBAncientChest(), 0.0D, 0.0D, 0.0D, 0.0F);
			GlStateManager.disableBlend();
		}
		else if (block == KapteynBBlocks.kapteyn_b_treasure_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityKapteynBTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == SiriusBBlocks.sirius_b_ancient_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntitySiriusBAncientChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == SiriusBBlocks.sirius_b_treasure_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntitySiriusBTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == MercuryBlocks.mercury_ancient_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityMercuryAncientChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == MercuryBlocks.mercury_treasure_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityMercuryTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == VenusBlocks.venus_ancient_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityVenusAncientChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == VenusBlocks.venus_treasure_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityVenusTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == PlutoBlocks.pluto_ancient_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPlutoAncientChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == PlutoBlocks.pluto_treasure_chest)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPlutoTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else if (block == KapteynBBlocks.icy_poison_crystal)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityIcyPoisonCrystal(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		else
		{
			super.renderByItem(itemStack);
		}
	}
}