/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.client.render.tileentities;

import micdoodle8.mods.galacticraft.core.client.model.block.ModelSolarPanel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityUltraVioletSolarPanel;

public class TileEntityUltraVioletSolarPanelRenderer extends TileEntitySpecialRenderer
{
	private ResourceLocation texture = new ResourceLocation("moreplanets:textures/model/ultra_violet_solar_panel.png");
	public ModelSolarPanel model = new ModelSolarPanel();

	@Override
	public void renderTileEntityAt(TileEntity tile, double par2, double par4, double par6, float var8, int tick)
	{
		TileEntityUltraVioletSolarPanel panel = (TileEntityUltraVioletSolarPanel)tile;

		if (tile.getBlockType() == PolongniusBlocks.ultra_violet_solar_panel)
		{
			this.bindTexture(this.texture);
		}

		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.translate((float) par2, (float) par4, (float) par6);
		GlStateManager.translate(0.5F, 1.0F, 0.5F);
		this.model.renderPole();
		GlStateManager.translate(0.0F, 1.5F, 0.0F);
		GlStateManager.rotate(180.0F, 0, 0, 1);
		GlStateManager.rotate(-90.0F, 0, 1, 0);
		float celestialAngle = (panel.getWorld().getCelestialAngle(1.0F) - 0.784690560F) * 360.0F;
		float celestialAngle2 = panel.getWorld().getCelestialAngle(1.0F) * 360.0F;
		GlStateManager.rotate(panel.currentAngle - (celestialAngle - celestialAngle2), 1.0F, 0.0F, 0.0F);
		this.model.renderPanel();
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	}
}