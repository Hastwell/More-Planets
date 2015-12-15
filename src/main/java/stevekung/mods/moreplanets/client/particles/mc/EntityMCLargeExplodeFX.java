/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.particles.mc;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityMCLargeExplodeFX extends EntityFX
{
    private ResourceLocation field_110127_a = new ResourceLocation("textures/entity/explosion.png");
    private int field_70581_a;
    private int field_70584_aq;
    private TextureManager theRenderEngine;
    private float field_70582_as;

    public EntityMCLargeExplodeFX(TextureManager texture, World world, double x, double y, double z, double moX, double moY, double moZ)
    {
        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
        this.theRenderEngine = texture;
        this.field_70584_aq = 6 + this.rand.nextInt(4);
        this.particleRed = this.particleGreen = this.particleBlue = this.rand.nextFloat() * 0.6F + 0.4F;
        this.field_70582_as = 1.0F - (float)moX * 0.5F;
    }

    @Override
    public void func_180434_a(WorldRenderer worldRender, Entity entity, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_)
    {
        int i = (int)((this.field_70581_a + p_180434_3_) * 15.0F / this.field_70584_aq);

        if (i <= 15)
        {
            this.theRenderEngine.bindTexture(this.field_110127_a);
            float f6 = i % 4 / 4.0F;
            float f7 = f6 + 0.24975F;
            float f8 = i / 4 / 4.0F;
            float f9 = f8 + 0.24975F;
            float f10 = 2.0F * this.field_70582_as;
            float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * p_180434_3_ - interpPosX);
            float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * p_180434_3_ - interpPosY);
            float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * p_180434_3_ - interpPosZ);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableLighting();
            RenderHelper.disableStandardItemLighting();
            worldRender.startDrawingQuads();
            worldRender.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, 1.0F);
            worldRender.setNormal(0.0F, 1.0F, 0.0F);
            worldRender.setBrightness(240);
            worldRender.addVertexWithUV(f11 - p_180434_4_ * f10 - p_180434_7_ * f10, f12 - p_180434_5_ * f10, f13 - p_180434_6_ * f10 - p_180434_8_ * f10, f7, f9);
            worldRender.addVertexWithUV(f11 - p_180434_4_ * f10 + p_180434_7_ * f10, f12 + p_180434_5_ * f10, f13 - p_180434_6_ * f10 + p_180434_8_ * f10, f7, f8);
            worldRender.addVertexWithUV(f11 + p_180434_4_ * f10 + p_180434_7_ * f10, f12 + p_180434_5_ * f10, f13 + p_180434_6_ * f10 + p_180434_8_ * f10, f6, f8);
            worldRender.addVertexWithUV(f11 + p_180434_4_ * f10 - p_180434_7_ * f10, f12 - p_180434_5_ * f10, f13 + p_180434_6_ * f10 - p_180434_8_ * f10, f6, f9);
            Tessellator.getInstance().draw();
            GlStateManager.doPolygonOffset(0.0F, 0.0F);
            GlStateManager.enableLighting();
        }
    }

    @Override
    public int getBrightnessForRender(float light)
    {
        return 61680;
    }

    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.field_70581_a;

        if (this.field_70581_a == this.field_70584_aq)
        {
            this.setDead();
        }
    }

    @Override
    public int getFXLayer()
    {
        return 3;
    }
}