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
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityUltraVioletSolarPanel;

public class TileEntityUltraVioletSolarPanelRenderer extends TileEntitySpecialRenderer<TileEntityUltraVioletSolarPanel>
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/model/ultra_violet_solar_panel.png");
    private ModelSolarPanel model = new ModelSolarPanel();

    @Override
    public void renderTileEntityAt(TileEntityUltraVioletSolarPanel tile, double x, double y, double z, float partialTicks, int destroyStage)
    {
        this.bindTexture(this.texture);
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.translate(0.5F, 1.0F, 0.5F);
        this.model.renderPole();
        GlStateManager.translate(0.0F, 1.5F, 0.0F);
        GlStateManager.rotate(180.0F, 0, 0, 1);
        GlStateManager.rotate(-90.0F, 0, 1, 0);
        float celestialAngle = (tile.getWorld().getCelestialAngle(1.0F) - 0.784690560F) * 360.0F;
        float celestialAngle2 = tile.getWorld().getCelestialAngle(1.0F) * 360.0F;
        GlStateManager.rotate(tile.currentAngle - (celestialAngle - celestialAngle2), 1.0F, 0.0F, 0.0F);
        this.model.renderPanel();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }
}