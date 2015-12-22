/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.client.sky;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.client.SkyProviderBaseMP;

public class SkyProviderSiriusB extends SkyProviderBaseMP
{
    private ResourceLocation siriusTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/sirius.png");
    private ResourceLocation fronosTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/fronos.png");

    public SkyProviderSiriusB(IGalacticraftWorldProvider provider)
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
        afloat[3] = 0.5F;
        f6 = afloat[0];
        f7 = afloat[1];
        f8 = afloat[2];

        f18 = 1.0F - f18;

        worldrenderer.func_181668_a(6, DefaultVertexFormats.field_181706_f);
        worldrenderer.func_181662_b(0.0D, 100.0D, 0.0D).func_181666_a(f6 * f18, f7 * f18, f8 * f18, afloat[3] * 2 / f18).func_181675_d();

        // Render sun aura
        f10 = 150.0F;
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0, 100.0D, (double) -f10 * 1.5F).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b((double) f10 * 1.5F, 100.0D, 0).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0, 100.0D, (double) f10 * 1.5F).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b((double) -f10 * 1.5F, 100.0D, 0).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();

        tessellator.draw();
        worldrenderer.func_181668_a(6, DefaultVertexFormats.field_181706_f);
        worldrenderer.func_181662_b(0.0D, 100.0D, 0.0D).func_181666_a(f6 * f18, f7 * f18, f8 * f18, afloat[3] * f18).func_181675_d();

        // Render larger sun aura
        f10 = 200.0F;
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0, 100.0D, (double) -f10 * 1.5F).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b((double) f10 * 1.5F, 100.0D, 0).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0, 100.0D, (double) f10 * 1.5F).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b((double) -f10 * 1.5F, 100.0D, 0).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        tessellator.draw();
        GlStateManager.popMatrix();
        GlStateManager.shadeModel(7424);
        GlStateManager.enableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);

        GlStateManager.pushMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);

        // Sirius
        GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
        f10 = this.sunSize;
        mc.renderEngine.bindTexture(this.siriusTexture);
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181673_a(0.0D, 0.0D).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, -f10).func_181673_a(1.0D, 0.0D).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, f10).func_181673_a(1.0D, 1.0D).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, f10).func_181673_a(0.0D, 1.0D).func_181675_d();
        tessellator.draw();

        GlStateManager.disableBlend();

        // Fronos
        f10 = 0.35F;
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        GlStateManager.rotate(15.0F, 5.0F, 0.0F, 0.0F);
        GlStateManager.rotate(-32F, -100.0F, -20.0F, 180.0F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
        mc.renderEngine.bindTexture(this.fronosTexture);
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181673_a(0.0D, 0.0D).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, -f10).func_181673_a(1.0D, 0.0D).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, f10).func_181673_a(1.0D, 1.0D).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, f10).func_181673_a(0.0D, 1.0D).func_181675_d();
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