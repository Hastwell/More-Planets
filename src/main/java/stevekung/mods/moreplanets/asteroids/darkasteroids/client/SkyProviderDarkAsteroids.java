/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.client;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.client.SkyProviderBaseMP;

public class SkyProviderDarkAsteroids extends SkyProviderBaseMP
{
    //private ResourceLocation overworldTexture = new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/earth.png");
    private ResourceLocation sunTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/dark_star.png");

    public SkyProviderDarkAsteroids(IGalacticraftWorldProvider provider)
    {
        super();
        this.sunSize = 17.5F * provider.getSolarSize();
    }

    @Override
    protected void renderPlanetInSky(float partialTicks, WorldClient world, Minecraft mc)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();

        // Dark Star
        GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.blendFunc(770, 771);
        GlStateManager.disableTexture2D();
        GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);
        float size = this.sunSize / 5.8F;
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(-size, 90.0D, -size).endVertex();
        worldrenderer.pos(size, 90.0D, -size).endVertex();
        worldrenderer.pos(size, 90.0D, size).endVertex();
        worldrenderer.pos(-size, 90.0D, size).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.blendFunc(770, 1);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        size = this.sunSize / 1.8F;
        mc.renderEngine.bindTexture(this.sunTexture);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(-size, 90.0D, -size).endVertex();
        worldrenderer.pos(size, 90.0D, -size).endVertex();
        worldrenderer.pos(size, 90.0D, size).endVertex();
        worldrenderer.pos(-size, 90.0D, size).endVertex();
        tessellator.draw();

        // Render planet??
        /*size = 0.5F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(40.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.overworldTexture);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-size, -100.0D, size, 0, 1);
		worldrenderer.addVertexWithUV(size, -100.0D, size, 1, 1);
		worldrenderer.addVertexWithUV(size, -100.0D, -size, 1, 0);
		worldrenderer.addVertexWithUV(-size, -100.0D, -size, 0, 0);
		tessellator.draw();*/
    }

    @Override
    protected double[] getMaxStarCount()
    {
        return new double[] { 50000D, 75D, 65D };
    }

    @Override
    protected float[] getStarBrightness()
    {
        return new float[] { 0.4F, 0.2F };
    }

    @Override
    protected boolean useDefaultStarBrightness()
    {
        return false;
    }
}