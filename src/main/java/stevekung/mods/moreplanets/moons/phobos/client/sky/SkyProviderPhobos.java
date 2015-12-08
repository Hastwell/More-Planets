/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.phobos.client.sky;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.client.SkyProviderBaseMP;

public class SkyProviderPhobos extends SkyProviderBaseMP
{
	private ResourceLocation sunTexture = new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/sun.png");
	private ResourceLocation marsTexture = new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/mars.png");
	private ResourceLocation deimosTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/deimos.png");

	public SkyProviderPhobos(IGalacticraftWorldProvider provider)
	{
		super();
		this.sunSize = 17.5F * provider.getSolarSize();
	}

	@Override
	protected void renderPlanetInSky(float partialTicks, WorldClient world, Minecraft mc)
	{
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();

		// Sun
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.blendFunc(770, 771);
		GlStateManager.disableTexture2D();
		GlStateManager.blendFunc(770, 1);
		GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.enableTexture2D();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		float size = this.sunSize + 2.6F;
		mc.renderEngine.bindTexture(this.sunTexture);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-size, 100.0D, -size, 0.0D, 0.0D);
		worldrenderer.addVertexWithUV(size, 100.0D, -size, 1.0D, 0.0D);
		worldrenderer.addVertexWithUV(size, 100.0D, size, 1.0D, 1.0D);
		worldrenderer.addVertexWithUV(-size, 100.0D, size, 0.0D, 1.0D);
		tessellator.draw();

		GlStateManager.disableBlend();

		// Mars
		size = 15.0F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(0.0F, 5.0F, 0.0F, 0.0F);
		GlStateManager.rotate(-32F, -100.0F, -20.0F, 180.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		mc.renderEngine.bindTexture(this.marsTexture);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-size, -100.0D, size, 0, 1);
		worldrenderer.addVertexWithUV(size, -100.0D, size, 1, 1);
		worldrenderer.addVertexWithUV(size, -100.0D, -size, 1, 0);
		worldrenderer.addVertexWithUV(-size, -100.0D, -size, 0, 0);
		tessellator.draw();

		// Deimos
		size = 1.2F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(-600F, 20.0F, 10.0F, 10.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 10.0F, 0.0F, 0.0F);
		mc.renderEngine.bindTexture(this.deimosTexture);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-size, -100.0D, size, 0, 1);
		worldrenderer.addVertexWithUV(size, -100.0D, size, 1, 1);
		worldrenderer.addVertexWithUV(size, -100.0D, -size, 1, 0);
		worldrenderer.addVertexWithUV(-size, -100.0D, -size, 0, 0);
		tessellator.draw();
	}

	@Override
	protected double[] getMaxStarCount()
	{
		return new double[] { 50000D, 100D, 150D };
	}

	@Override
	protected float[] getStarBrightness()
	{
		return new float[] { 0.4F, 0.7F };
	}

	@Override
	protected boolean useDefaultStarBrightness()
	{
		return false;
	}
}