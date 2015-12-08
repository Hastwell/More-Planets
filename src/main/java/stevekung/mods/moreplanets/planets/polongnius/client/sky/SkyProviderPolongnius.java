/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.client.sky;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.client.SkyProviderBaseMP;

public class SkyProviderPolongnius extends SkyProviderBaseMP
{
	private ResourceLocation siriusTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/sirius.png");
	private ResourceLocation dionaTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/diona.png");
	private ResourceLocation nibiruTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/nibiru.png");

	public SkyProviderPolongnius(IGalacticraftWorldProvider provider)
	{
		super();
		this.sunSize = 17.5F * provider.getSolarSize();
	}

	@Override
	protected void renderPlanetInSky(float partialTicks, WorldClient world, Minecraft mc)
	{
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		float f6;
		float f7;
		float f8;
		float f10;
		float f18 = world.getStarBrightness(partialTicks);
		float[] afloat = new float[4];
		GlStateManager.disableTexture2D();
		GlStateManager.shadeModel(7425);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		afloat[0] = 0 / 255.0F;
		afloat[1] = 225 / 255.0F;
		afloat[2] = 255 / 255.0F;
		afloat[3] = 0.4F;
		f6 = afloat[0];
		f7 = afloat[1];
		f8 = afloat[2];
		f18 = 1.0F - f18;

		worldrenderer.startDrawing(6);
		worldrenderer.setColorRGBA_F(f6 * f18, f7 * f18, f8 * f18, afloat[3] * 2 / f18);
		worldrenderer.addVertex(0.0D, 100.0D, 0.0D);
		worldrenderer.setColorRGBA_F(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F);

		// Render sun aura
		f10 = 14.0F;
		worldrenderer.addVertex(-f10, 100.0D, -f10);
		worldrenderer.addVertex(0, 100.0D, (double) -f10 * 1.5F);
		worldrenderer.addVertex(f10, 100.0D, -f10);
		worldrenderer.addVertex((double) f10 * 1.5F, 100.0D, 0);
		worldrenderer.addVertex(f10, 100.0D, f10);
		worldrenderer.addVertex(0, 100.0D, (double) f10 * 1.5F);
		worldrenderer.addVertex(-f10, 100.0D, f10);
		worldrenderer.addVertex((double) -f10 * 1.5F, 100.0D, 0);
		worldrenderer.addVertex(-f10, 100.0D, -f10);

		tessellator.draw();
		worldrenderer.startDrawing(6);
		worldrenderer.setColorRGBA_F(f6 * f18, f7 * f18, f8 * f18, afloat[3] * f18);
		worldrenderer.addVertex(0.0D, 100.0D, 0.0D);
		worldrenderer.setColorRGBA_F(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F);

		// Render larger sun aura
		f10 = 30.0F;
		worldrenderer.addVertex(-f10, 100.0D, -f10);
		worldrenderer.addVertex(0, 100.0D, (double) -f10 * 1.5F);
		worldrenderer.addVertex(f10, 100.0D, -f10);
		worldrenderer.addVertex((double) f10 * 1.5F, 100.0D, 0);
		worldrenderer.addVertex(f10, 100.0D, f10);
		worldrenderer.addVertex(0, 100.0D, (double) f10 * 1.5F);
		worldrenderer.addVertex(-f10, 100.0D, f10);
		worldrenderer.addVertex((double) -f10 * 1.5F, 100.0D, 0);
		worldrenderer.addVertex(-f10, 100.0D, -f10);
		tessellator.draw();
		GlStateManager.popMatrix();
		GlStateManager.shadeModel(7424);
		GlStateManager.enableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);

		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.blendFunc(770, 771);
		GlStateManager.disableTexture2D();
		GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);
		f10 = 9.5F / 3.5F;
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertex(-f10, 99.9D, -f10);
		worldrenderer.addVertex(f10, 99.9D, -f10);
		worldrenderer.addVertex(f10, 99.9D, f10);
		worldrenderer.addVertex(-f10, 99.9D, f10);
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

		// Render Sirius
		GlStateManager.disableTexture2D();
		GlStateManager.blendFunc(770, 1);
		GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);

		//Some blanking to conceal the stars
		f10 = this.sunSize / 3.5F;
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertex(-f10, 99.9D, -f10);
		worldrenderer.addVertex(f10, 99.9D, -f10);
		worldrenderer.addVertex(f10, 99.9D, f10);
		worldrenderer.addVertex(-f10, 99.9D, f10);
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		f10 = this.sunSize + 7;
		mc.renderEngine.bindTexture(this.siriusTexture);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-f10, 100.0D, -f10, 0.0D, 0.0D);
		worldrenderer.addVertexWithUV(f10, 100.0D, -f10, 1.0D, 0.0D);
		worldrenderer.addVertexWithUV(f10, 100.0D, f10, 1.0D, 1.0D);
		worldrenderer.addVertexWithUV(-f10, 100.0D, f10, 0.0D, 1.0D);
		tessellator.draw();

		// Render Diona
		f10 = 0.75F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(0.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(220F, 1.0F, -0.3F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		mc.renderEngine.bindTexture(this.dionaTexture);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-f10, -100.0D, f10, 0, 1);
		worldrenderer.addVertexWithUV(f10, -100.0D, f10, 1, 1);
		worldrenderer.addVertexWithUV(f10, -100.0D, -f10, 1, 0);
		worldrenderer.addVertexWithUV(-f10, -100.0D, -f10, 0, 0);
		tessellator.draw();

		// Render Nibiru
		f10 = 3.8F;
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(-30.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(-10.0F, 1.0F, 0.5F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		mc.renderEngine.bindTexture(this.nibiruTexture);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-f10, -100.0D, f10, 0, 1);
		worldrenderer.addVertexWithUV(f10, -100.0D, f10, 1, 1);
		worldrenderer.addVertexWithUV(f10, -100.0D, -f10, 1, 0);
		worldrenderer.addVertexWithUV(-f10, -100.0D, -f10, 0, 0);
		tessellator.draw();
	}

	@Override
	protected double[] getMaxStarCount()
	{
		return new double[] { 50000D, 150D, 130D };
	}

	@Override
	protected float[] getStarBrightness()
	{
		return new float[] { 0.3F, 0.3F };
	}

	@Override
	protected boolean useDefaultStarBrightness()
	{
		return false;
	}
}