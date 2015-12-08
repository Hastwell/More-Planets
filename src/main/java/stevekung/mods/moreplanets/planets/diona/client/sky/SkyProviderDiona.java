/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.client.sky;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.client.SkyProviderBaseMP;

public class SkyProviderDiona extends SkyProviderBaseMP
{
	private ResourceLocation siriusTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/sirius.png");
	private ResourceLocation polongniusTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/polongnius.png");
	private ResourceLocation koentusTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/koentus.png");

	public SkyProviderDiona(IGalacticraftWorldProvider provider)
	{
		super();
		this.sunSize = 17.5F * provider.getSolarSize();
	}

	@Override
	protected void renderPlanetInSky(float partialTicks, WorldClient world, Minecraft mc)
	{
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		float size;

		GlStateManager.enableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.blendFunc(770, 771);
		GlStateManager.disableTexture2D();
		GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);
		size = 11.0F / 3.5F;
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertex(-size, 99.9D, -size);
		worldrenderer.addVertex(size, 99.9D, -size);
		worldrenderer.addVertex(size, 99.9D, size);
		worldrenderer.addVertex(-size, 99.9D, size);
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

		// Sirius
		GlStateManager.disableTexture2D();
		GlStateManager.blendFunc(770, 1);
		GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);

		// Some blanking to conceal the stars
		size = this.sunSize / 3.5F;
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertex(-size, 99.9D, -size);
		worldrenderer.addVertex(size, 99.9D, -size);
		worldrenderer.addVertex(size, 99.9D, size);
		worldrenderer.addVertex(-size, 99.9D, size);
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		size = this.sunSize + 7;
		mc.renderEngine.bindTexture(this.siriusTexture);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-size, 100.0D, -size, 0.0D, 0.0D);
		worldrenderer.addVertexWithUV(size, 100.0D, -size, 1.0D, 0.0D);
		worldrenderer.addVertexWithUV(size, 100.0D, size, 1.0D, 1.0D);
		worldrenderer.addVertexWithUV(-size, 100.0D, size, 0.0D, 1.0D);
		tessellator.draw();

		GlStateManager.disableBlend();

		// Polongnius
		size = 1.2F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(40.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		mc.renderEngine.bindTexture(this.polongniusTexture);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-size, -100.0D, size, 0, 1);
		worldrenderer.addVertexWithUV(size, -100.0D, size, 1, 1);
		worldrenderer.addVertexWithUV(size, -100.0D, -size, 1, 0);
		worldrenderer.addVertexWithUV(-size, -100.0D, -size, 0, 0);
		tessellator.draw();

		// Koentus
		size = 2.5F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(-750F, 20.0F, 10.0F, 10.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		mc.renderEngine.bindTexture(this.koentusTexture);
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
		return new double[] { 50000D, 150D, 100D };
	}

	@Override
	protected float[] getStarBrightness()
	{
		return new float[] { 1.0F, 0.25F };
	}

	@Override
	protected boolean useDefaultStarBrightness()
	{
		return false;
	}
}