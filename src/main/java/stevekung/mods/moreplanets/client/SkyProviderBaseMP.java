/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

public abstract class SkyProviderBaseMP extends IRenderHandler
{
    protected int starList;
    protected int glSkyList;
    protected int glSkyList2;
    protected float sunSize;

    public SkyProviderBaseMP()
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        int displayLists = GLAllocation.generateDisplayLists(3);
        this.starList = displayLists;
        this.glSkyList = displayLists + 1;
        this.glSkyList2 = displayLists + 2;

        GlStateManager.pushMatrix();
        GL11.glNewList(this.starList, GL11.GL_COMPILE);
        this.renderStars();
        GL11.glEndList();
        GlStateManager.popMatrix();

        this.glSkyList = this.starList + 1;
        GL11.glNewList(this.glSkyList, GL11.GL_COMPILE);
        byte byte2 = 64;
        int i = 256 / byte2 + 2;
        float f = 16F;

        for (int j = -byte2 * i; j <= byte2 * i; j += byte2)
        {
            for (int l = -byte2 * i; l <= byte2 * i; l += byte2)
            {
                worldrenderer.startDrawingQuads();
                worldrenderer.addVertex(j + 0, f, l + 0);
                worldrenderer.addVertex(j + byte2, f, l + 0);
                worldrenderer.addVertex(j + byte2, f, l + byte2);
                worldrenderer.addVertex(j + 0, f, l + byte2);
                tessellator.draw();
            }
        }
        GL11.glEndList();

        this.glSkyList2 = this.starList + 2;
        GL11.glNewList(this.glSkyList2, GL11.GL_COMPILE);
        f = -16F;
        worldrenderer.startDrawingQuads();

        for (int k = -byte2 * i; k <= byte2 * i; k += byte2)
        {
            for (int i1 = -byte2 * i; i1 <= byte2 * i; i1 += byte2)
            {
                worldrenderer.addVertex(k + byte2, f, i1 + 0);
                worldrenderer.addVertex(k + 0, f, i1 + 0);
                worldrenderer.addVertex(k + 0, f, i1 + byte2);
                worldrenderer.addVertex(k + byte2, f, i1 + byte2);
            }
        }
        tessellator.draw();
        GL11.glEndList();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void render(float partialTicks, WorldClient world, Minecraft mc)
    {
        Vec3 vec3 = world.getSkyColor(mc.getRenderViewEntity(), partialTicks);
        float red = (float)vec3.xCoord;
        float green = (float)vec3.yCoord;
        float blue = (float)vec3.zCoord;

        GlStateManager.disableTexture2D();
        GlStateManager.disableRescaleNormal();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.color(red, green, blue);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.depthMask(false);
        GlStateManager.enableFog();
        GlStateManager.color(red, green, blue);
        GlStateManager.callList(this.glSkyList);
        GlStateManager.disableFog();
        GlStateManager.disableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        RenderHelper.disableStandardItemLighting();
        float star = world.getStarBrightness(partialTicks);
        float[] custom = this.getStarBrightness();

        if (star > 0.0F)
        {
            GlStateManager.pushMatrix();
            GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(-19.0F, 0, 1.0F, 0);

            if (this.useDefaultStarBrightness() && this.getStarBrightness() == null)
            {
                GlStateManager.color(star, star, star, star);
            }
            else
            {
                GlStateManager.color(custom[0], custom[0], custom[0], custom[1] * world.getStarBrightness(partialTicks) / 0.25F);
            }
            GlStateManager.callList(this.starList);
            GlStateManager.popMatrix();
        }

        GlStateManager.pushMatrix();
        this.renderPlanetInSky(partialTicks, world, mc);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableFog();
        GlStateManager.popMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.color(0.0F, 0.0F, 0.0F);
        double playerEyes = mc.thePlayer.getPositionEyes(partialTicks).yCoord - world.getHorizon();

        if (playerEyes < 0.0D)
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 12.0F, 0.0F);
            GlStateManager.callList(this.glSkyList2);
            GlStateManager.popMatrix();
            float f = -((float)(playerEyes + 65.0D));
            worldrenderer.startDrawingQuads();
            worldrenderer.setColorRGBA_I(0, 255);
            worldrenderer.addVertex(-1.0D, f, 1.0D);
            worldrenderer.addVertex(1.0D, f, 1.0D);
            worldrenderer.addVertex(1.0D, -1.0D, 1.0D);
            worldrenderer.addVertex(-1.0D, -1.0D, 1.0D);
            worldrenderer.addVertex(-1.0D, -1.0D, -1.0D);
            worldrenderer.addVertex(1.0D, -1.0D, -1.0D);
            worldrenderer.addVertex(1.0D, f, -1.0D);
            worldrenderer.addVertex(-1.0D, f, -1.0D);
            worldrenderer.addVertex(1.0D, -1.0D, -1.0D);
            worldrenderer.addVertex(1.0D, -1.0D, 1.0D);
            worldrenderer.addVertex(1.0D, f, 1.0D);
            worldrenderer.addVertex(1.0D, f, -1.0D);
            worldrenderer.addVertex(-1.0D, f, -1.0D);
            worldrenderer.addVertex(-1.0D, f, 1.0D);
            worldrenderer.addVertex(-1.0D, -1.0D, 1.0D);
            worldrenderer.addVertex(-1.0D, -1.0D, -1.0D);
            worldrenderer.addVertex(-1.0D, -1.0D, -1.0D);
            worldrenderer.addVertex(-1.0D, -1.0D, 1.0D);
            worldrenderer.addVertex(1.0D, -1.0D, 1.0D);
            worldrenderer.addVertex(1.0D, -1.0D, -1.0D);
            tessellator.draw();
        }
        GlStateManager.color(red, green, blue);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0F, -((float)(playerEyes - 16.0D)), 0.0F);
        GlStateManager.callList(this.glSkyList2);
        GlStateManager.popMatrix();
        GlStateManager.enableTexture2D();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        GlStateManager.disableFog();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.depthMask(true);
    }

    private void renderStars()
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        Random rand = new Random(10842L);
        worldrenderer.startDrawingQuads();

        for (int starIndex = 0; starIndex < (ConfigManagerCore.moreStars ? this.getMaxStarCount()[0] : 6000); ++starIndex)
        {
            double d0 = rand.nextFloat() * 2.0F - 1.0F;
            double d1 = rand.nextFloat() * 2.0F - 1.0F;
            double d2 = rand.nextFloat() * 2.0F - 1.0F;
            double d3 = 0.15F + rand.nextFloat() * 0.1F;
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;

            if (d4 < 1.0D && d4 > 0.01D)
            {
                d4 = 1.0D / Math.sqrt(d4);
                d0 *= d4;
                d1 *= d4;
                d2 *= d4;
                double d5 = d0 * (ConfigManagerCore.moreStars ? rand.nextDouble() * this.getMaxStarCount()[1] + this.getMaxStarCount()[2] : 100.0D);
                double d6 = d1 * (ConfigManagerCore.moreStars ? rand.nextDouble() * this.getMaxStarCount()[1] + this.getMaxStarCount()[2] : 100.0D);
                double d7 = d2 * (ConfigManagerCore.moreStars ? rand.nextDouble() * this.getMaxStarCount()[1] + this.getMaxStarCount()[2] : 100.0D);
                double d8 = Math.atan2(d0, d2);
                double d9 = Math.sin(d8);
                double d10 = Math.cos(d8);
                double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
                double d12 = Math.sin(d11);
                double d13 = Math.cos(d11);
                double d14 = rand.nextDouble() * Math.PI * 2.0D;
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                for (int j = 0; j < 4; ++j)
                {
                    double d18 = ((j & 2) - 1) * d3;
                    double d19 = ((j + 1 & 2) - 1) * d3;
                    double d21 = d18 * d16 - d19 * d15;
                    double d22 = d19 * d16 + d18 * d15;
                    double d23 = d21 * d12 + 0.0D * d13;
                    double d24 = 0.0D * d12 - d21 * d13;
                    double d25 = d24 * d9 - d22 * d10;
                    double d26 = d22 * d9 + d24 * d10;
                    worldrenderer.addVertex(d5 + d25, d6 + d23, d7 + d26);
                }
            }
        }
        tessellator.draw();
    }

    protected abstract void renderPlanetInSky(float partialTicks, WorldClient world, Minecraft mc);
    protected abstract double[] getMaxStarCount();
    protected abstract float[] getStarBrightness();
    protected abstract boolean useDefaultStarBrightness();
}