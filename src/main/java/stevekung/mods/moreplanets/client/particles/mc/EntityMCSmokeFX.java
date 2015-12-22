///*******************************************************************************
// * Copyright 2015 SteveKunG - More Planets Mod
// * 
// * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
// * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
// ******************************************************************************/
//
//package stevekung.mods.moreplanets.client.particles.mc;
//
//import net.minecraft.client.particle.EntityFX;
//import net.minecraft.client.renderer.WorldRenderer;
//import net.minecraft.entity.Entity;
//import net.minecraft.util.MathHelper;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//@SideOnly(Side.CLIENT)
//public class EntityMCSmokeFX extends EntityFX
//{
//    float smokeParticleScale;
//
//    public EntityMCSmokeFX(World world, double x, double y, double z, double moX, double moY, double moZ, float size)
//    {
//        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
//        this.motionX *= 0.10000000149011612D;
//        this.motionY *= 0.10000000149011612D;
//        this.motionZ *= 0.10000000149011612D;
//        this.motionX += moX;
//        this.motionY += moY;
//        this.motionZ += moZ;
//        this.particleRed = this.particleGreen = this.particleBlue = (float)(Math.random() * 0.30000001192092896D);
//        this.particleScale *= 0.75F;
//        this.particleScale *= size;
//        this.smokeParticleScale = this.particleScale;
//        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
//        this.particleMaxAge = (int)(this.particleMaxAge * 2.5F);
//        this.noClip = false;
//    }
//
//    @Override
//    public void func_180434_a(WorldRenderer worldRender, Entity entity, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_)
//    {
//        float f6 = (this.particleAge + p_180434_3_) / this.particleMaxAge * 32.0F;
//        f6 = MathHelper.clamp_float(f6, 0.0F, 1.0F);
//        this.particleScale = this.smokeParticleScale * f6;
//        super.func_180434_a(worldRender, entity, p_180434_3_, p_180434_4_, p_180434_5_, p_180434_6_, p_180434_7_, p_180434_8_);
//    }
//
//    @Override
//    public void onUpdate()
//    {
//        this.prevPosX = this.posX;
//        this.prevPosY = this.posY;
//        this.prevPosZ = this.posZ;
//
//        if (this.particleAge++ >= this.particleMaxAge)
//        {
//            this.setDead();
//        }
//
//        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
//        this.motionY += 0.004D;
//        this.moveEntity(this.motionX, this.motionY, this.motionZ);
//
//        if (this.posY == this.prevPosY)
//        {
//            this.motionX *= 1.1D;
//            this.motionZ *= 1.1D;
//        }
//
//        this.motionX *= 0.9599999785423279D;
//        this.motionY *= 0.9599999785423279D;
//        this.motionZ *= 0.9599999785423279D;
//
//        if (this.onGround)
//        {
//            this.motionX *= 0.699999988079071D;
//            this.motionZ *= 0.699999988079071D;
//        }
//    }
//}