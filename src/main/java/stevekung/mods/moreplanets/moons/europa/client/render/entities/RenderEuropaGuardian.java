/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.client.render.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import stevekung.mods.moreplanets.moons.europa.client.model.ModelEuropaGuardian;
import stevekung.mods.moreplanets.moons.europa.client.render.entities.layer.LayerEuropaGuardianEyes;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaGuardian;

@SideOnly(Side.CLIENT)
public class RenderEuropaGuardian extends RenderLiving<EntityEuropaGuardian>
{
    private ResourceLocation mainTexture = new ResourceLocation("moreplanets:textures/entity/europa_guardian.png");
    private ResourceLocation elderTexture = new ResourceLocation("moreplanets:textures/entity/europa_guardian_elder.png");
    private ResourceLocation beamTexture = new ResourceLocation("textures/entity/guardian_beam.png");
    int field_177115_a;

    public RenderEuropaGuardian(RenderManager render)
    {
        super(render, new ModelEuropaGuardian(), 0.5F);
        this.addLayer(new LayerEuropaGuardianEyes(this));
        this.field_177115_a = 54;
    }

    @Override
    public boolean shouldRender(EntityEuropaGuardian entity, ICamera camera, double camX, double camY, double camZ)
    {
        if (super.shouldRender(entity, camera, camX, camY, camZ))
        {
            return true;
        }
        else
        {
            if (entity.hasTargetedEntity())
            {
                EntityLivingBase entitylivingbase = entity.getTargetedEntity();

                if (entitylivingbase != null)
                {
                    Vec3 vec3 = this.func_177110_a(entitylivingbase, entitylivingbase.height * 0.5D, 1.0F);
                    Vec3 vec31 = this.func_177110_a(entity, entity.getEyeHeight(), 1.0F);

                    if (camera.isBoundingBoxInFrustum(AxisAlignedBB.fromBounds(vec31.xCoord, vec31.yCoord, vec31.zCoord, vec3.xCoord, vec3.yCoord, vec3.zCoord)))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private Vec3 func_177110_a(EntityLivingBase entity, double p_177110_2_, float partialTicks)
    {
        double d1 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * partialTicks;
        double d2 = p_177110_2_ + entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * partialTicks;
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * partialTicks;
        return new Vec3(d1, d2, d3);
    }

    @Override
    protected void preRenderCallback(EntityEuropaGuardian entity, float partialTickTime)
    {
        if (entity.isElder())
        {
            GlStateManager.scale(2.5F, 2.5F, 2.5F);
        }
    }

    @Override
    public void doRender(EntityEuropaGuardian entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        if (this.field_177115_a != 54)
        {
            this.mainModel = new ModelEuropaGuardian();
            this.field_177115_a = 54;
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        EntityLivingBase entitylivingbase = entity.getTargetedEntity();

        if (entitylivingbase != null)
        {
            float f2 = entity.func_175477_p(partialTicks);
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            this.bindTexture(this.beamTexture);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
            float f3 = 240.0F;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, f3, f3);
            GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
            float f4 = entity.worldObj.getTotalWorldTime() + partialTicks;
            float f5 = f4 * 0.5F % 1.0F;
            float f6 = entity.getEyeHeight();
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)x, (float)y + f6, (float)z);
            Vec3 vec3 = this.func_177110_a(entitylivingbase, entitylivingbase.height * 0.5D, partialTicks);
            Vec3 vec31 = this.func_177110_a(entity, f6, partialTicks);
            Vec3 vec32 = vec3.subtract(vec31);
            double d3 = vec32.lengthVector() + 1.0D;
            vec32 = vec32.normalize();
            float f7 = (float)Math.acos(vec32.yCoord);
            float f8 = (float)Math.atan2(vec32.zCoord, vec32.xCoord);
            GlStateManager.rotate(((float)Math.PI / 2F + -f8) * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(f7 * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
            byte b0 = 1;
            double d4 = f4 * 0.05D * (1.0D - (b0 & 1) * 2.5D);
            worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            float f9 = f2 * f2;
            double d5 = b0 * 0.2D;
            double d6 = d5 * 1.41D;
            double d7 = 0.0D + Math.cos(d4 + 2.356194490192345D) * d6;
            double d8 = 0.0D + Math.sin(d4 + 2.356194490192345D) * d6;
            double d9 = 0.0D + Math.cos(d4 + Math.PI / 4D) * d6;
            double d10 = 0.0D + Math.sin(d4 + Math.PI / 4D) * d6;
            double d11 = 0.0D + Math.cos(d4 + 3.9269908169872414D) * d6;
            double d12 = 0.0D + Math.sin(d4 + 3.9269908169872414D) * d6;
            double d13 = 0.0D + Math.cos(d4 + 5.497787143782138D) * d6;
            double d14 = 0.0D + Math.sin(d4 + 5.497787143782138D) * d6;
            double d15 = 0.0D + Math.cos(d4 + Math.PI) * d5;
            double d16 = 0.0D + Math.sin(d4 + Math.PI) * d5;
            double d17 = 0.0D + Math.cos(d4 + 0.0D) * d5;
            double d18 = 0.0D + Math.sin(d4 + 0.0D) * d5;
            double d19 = 0.0D + Math.cos(d4 + Math.PI / 2D) * d5;
            double d20 = 0.0D + Math.sin(d4 + Math.PI / 2D) * d5;
            double d21 = 0.0D + Math.cos(d4 + Math.PI * 3D / 2D) * d5;
            double d22 = 0.0D + Math.sin(d4 + Math.PI * 3D / 2D) * d5;
            double d23 = 0.0D;
            double d24 = 0.4999D;
            double d25 = -1.0F + f5;
            double d26 = d3 * (0.5D / d5) + d25;
            double d27 = 0.0D;

            if (entity.isElder())
            {
                worldrenderer.pos(d15, d3, d16).tex(d24, d26).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
                worldrenderer.pos(d15, 0.0D, d16).tex(d24, d25).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
                worldrenderer.pos(d17, 0.0D, d18).tex(d23, d25).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
                worldrenderer.pos(d17, d3, d18).tex(d23, d26).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
                worldrenderer.pos(d19, d3, d20).tex(d24, d26).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
                worldrenderer.pos(d19, 0.0D, d20).tex(d24, d25).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
                worldrenderer.pos(d21, 0.0D, d22).tex(d23, d25).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
                worldrenderer.pos(d21, d3, d22).tex(d23, d26).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
            }
            else
            {
                worldrenderer.pos(d15, d3, d16).tex(d24, d26).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
                worldrenderer.pos(d15, 0.0D, d16).tex(d24, d25).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
                worldrenderer.pos(d17, 0.0D, d18).tex(d23, d25).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
                worldrenderer.pos(d17, d3, d18).tex(d23, d26).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
                worldrenderer.pos(d19, d3, d20).tex(d24, d26).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
                worldrenderer.pos(d19, 0.0D, d20).tex(d24, d25).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
                worldrenderer.pos(d21, 0.0D, d22).tex(d23, d25).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
                worldrenderer.pos(d21, d3, d22).tex(d23, d26).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
            }

            if (entity.ticksExisted % 2 == 0)
            {
                d27 = 0.5D;
            }

            if (entity.isElder())
            {
                worldrenderer.pos(d7, d3, d8).tex(0.5D, d27 + 0.5D).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
                worldrenderer.pos(d9, d3, d10).tex(1.0D, d27 + 0.5D).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
                worldrenderer.pos(d13, d3, d14).tex(1.0D, d27).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
                worldrenderer.pos(d11, d3, d12).tex(0.5D, d27).color(150 + (int)(f9 * 240.0F), 32 + (int)(f9 * 25.0F), 190 - (int)(f9 * 240.0F), 255).endVertex();
            }
            else
            {
                worldrenderer.pos(d7, d3, d8).tex(0.5D, d27 + 0.5D).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
                worldrenderer.pos(d9, d3, d10).tex(1.0D, d27 + 0.5D).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
                worldrenderer.pos(d13, d3, d14).tex(1.0D, d27).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
                worldrenderer.pos(d11, d3, d12).tex(0.5D, d27).color(255 + (int)(f9 * 1.0F - 128 * 2.0F), 82 + (int)(f9 * 255.0F), 60, 255).endVertex();
            }
            tessellator.draw();
            GlStateManager.enableLighting();
            GlStateManager.enableCull();
            GlStateManager.enableBlend();
            GlStateManager.popMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEuropaGuardian entity)
    {
        return entity.isElder() ? this.elderTexture : this.mainTexture;
    }
}