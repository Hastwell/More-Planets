///*******************************************************************************
// * Copyright 2015 SteveKunG - More Planets Mod
// *
// * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
// * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
// ******************************************************************************/
//
//package stevekung.mods.moreplanets.client.particles.mc;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.particle.EntityFX;
//import net.minecraft.client.renderer.WorldRenderer;
//import net.minecraft.entity.Entity;
//import net.minecraft.init.Blocks;
//import net.minecraft.item.Item;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//@SideOnly(Side.CLIENT)
//public class EntityMCBreakingFX extends EntityFX
//{
//    protected EntityMCBreakingFX(World world, double x, double y, double z, double moX, double moY, double moZ, Item item, int meta)
//    {
//        this(world, x, y, z, item, meta);
//        this.motionX *= 0.10000000149011612D;
//        this.motionY *= 0.10000000149011612D;
//        this.motionZ *= 0.10000000149011612D;
//        this.motionX += moX;
//        this.motionY += moY;
//        this.motionZ += moZ;
//    }
//
//    public EntityMCBreakingFX(World world, double x, double y, double z, Item item, int meta)
//    {
//        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
//        this.func_180435_a(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(item, meta));
//        this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
//        this.particleGravity = Blocks.snow.blockParticleGravity;
//        this.particleScale /= 2.0F;
//    }
//
//    @Override
//    public int getFXLayer()
//    {
//        return 1;
//    }
//
//    @Override
//    public void func_180434_a(WorldRenderer worldRender, Entity entity, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_)
//    {
//        float f6 = (this.particleTextureIndexX + this.particleTextureJitterX / 4.0F) / 16.0F;
//        float f7 = f6 + 0.015609375F;
//        float f8 = (this.particleTextureIndexY + this.particleTextureJitterY / 4.0F) / 16.0F;
//        float f9 = f8 + 0.015609375F;
//        float f10 = 0.1F * this.particleScale;
//
//        if (this.particleIcon != null)
//        {
//            f6 = this.particleIcon.getInterpolatedU(this.particleTextureJitterX / 4.0F * 16.0F);
//            f7 = this.particleIcon.getInterpolatedU((this.particleTextureJitterX + 1.0F) / 4.0F * 16.0F);
//            f8 = this.particleIcon.getInterpolatedV(this.particleTextureJitterY / 4.0F * 16.0F);
//            f9 = this.particleIcon.getInterpolatedV((this.particleTextureJitterY + 1.0F) / 4.0F * 16.0F);
//        }
//        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * p_180434_3_ - interpPosX);
//        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * p_180434_3_ - interpPosY);
//        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * p_180434_3_ - interpPosZ);
//        worldRender.setColorOpaque_F(this.particleRed, this.particleGreen, this.particleBlue);
//        worldRender.addVertexWithUV(f11 - p_180434_4_ * f10 - p_180434_7_ * f10, f12 - p_180434_5_ * f10, f13 - p_180434_6_ * f10 - p_180434_8_ * f10, f6, f9);
//        worldRender.addVertexWithUV(f11 - p_180434_4_ * f10 + p_180434_7_ * f10, f12 + p_180434_5_ * f10, f13 - p_180434_6_ * f10 + p_180434_8_ * f10, f6, f8);
//        worldRender.addVertexWithUV(f11 + p_180434_4_ * f10 + p_180434_7_ * f10, f12 + p_180434_5_ * f10, f13 + p_180434_6_ * f10 + p_180434_8_ * f10, f7, f8);
//        worldRender.addVertexWithUV(f11 + p_180434_4_ * f10 - p_180434_7_ * f10, f12 - p_180434_5_ * f10, f13 + p_180434_6_ * f10 - p_180434_8_ * f10, f7, f9);
//    }
//}