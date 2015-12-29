/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.asteroids.darkasteroids.client.EntityAlienSplashFX;
import stevekung.mods.moreplanets.client.particles.EntityGreenRedstoneFX;
import stevekung.mods.moreplanets.client.particles.EntityLiquidDripFX;
import stevekung.mods.moreplanets.client.particles.mc.EntityMCExplodeFX;
import stevekung.mods.moreplanets.client.particles.mc.EntityMCHugeExplodeFX;
import stevekung.mods.moreplanets.moons.koentus.client.particles.EntityKoentusMeteorSmokeFX;
import stevekung.mods.moreplanets.moons.koentus.client.particles.EntityWhiteCrystalSmokeFX;
import stevekung.mods.moreplanets.planets.diona.client.particles.EntityBluePortalFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityBlueFlameFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityCavernOysterFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityCoconutMilkFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityGoldenGrassFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityGoldenSmokeFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityJungleIrisFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityMineralWaterFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityOrangeDandelionFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityOvantineSmokeFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityPinkDandelionFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityPurpleDandelionFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityPurpleSpikeFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityTeaFluidFX;
import stevekung.mods.moreplanets.planets.kapteynb.client.particles.EntityGeyserFX;
import stevekung.mods.moreplanets.planets.kapteynb.client.particles.EntityUraniumSmokeFX;
import stevekung.mods.moreplanets.planets.nibiru.client.particles.EntityGeneratorSmokeFX;
import stevekung.mods.moreplanets.planets.nibiru.client.particles.EntityInfectedSporeFX;
import stevekung.mods.moreplanets.planets.pluto.client.particles.EntityXeoniumSmokeFX;
import stevekung.mods.moreplanets.planets.polongnius.client.particles.EntityCheeseBubbleFX;
import stevekung.mods.moreplanets.planets.siriusb.client.particles.EntitySiriusFlameFX;
import stevekung.mods.moreplanets.planets.siriusb.client.particles.EntitySiriusLavaFX;
import stevekung.mods.moreplanets.planets.venus.client.particles.EntityVenusSmokeFX;

@SideOnly(Side.CLIENT)
public class EffectHandlerMP
{
    public static void spawnParticle(EnumParticleTypesMP type, double x, double y, double z, double motionX, double motionY, double motionZ)
    {
        EntityFX entityfx = null;
        Minecraft mc = Minecraft.getMinecraft();
        int i = mc.gameSettings.particleSetting;
        double d6 = mc.getRenderViewEntity().posX - x;
        double d7 = mc.getRenderViewEntity().posY - y;
        double d8 = mc.getRenderViewEntity().posZ - z;
        double d9 = 16.0D;

        if (i == 1 && mc.theWorld.rand.nextInt(3) == 0)
        {
            i = 2;
        }
        if (d6 * d6 + d7 * d7 + d8 * d8 > d9 * d9)
        {
            return;
        }
        else if (i > 1)
        {
            return;
        }

        if (type == EnumParticleTypesMP.KOENTUS_METEOR_SMOKE)
        {
            entityfx = new EntityKoentusMeteorSmokeFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
        }
        else if (type == EnumParticleTypesMP.CAVERN_OYSTER)
        {
            entityfx = new EntityCavernOysterFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
        }
        else if (type == EnumParticleTypesMP.INFECTED_SPORE)
        {
            entityfx = new EntityInfectedSporeFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
        }
        else if (type == EnumParticleTypesMP.BLUE_PORTAL)
        {
            entityfx = new EntityBluePortalFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
        }
        else if (type == EnumParticleTypesMP.JUNGLE_IRIS)
        {
            entityfx = new EntityJungleIrisFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
        }
        else if (type == EnumParticleTypesMP.FROZEN_WATER_GEYSER)
        {
            entityfx = new EntityGeyserFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
        }
        //        else if (type == EnumParticleTypesMP.MC_NORMAL_SMOKE)
        //        {
        //            entityfx = new EntityMCSmokeFX(mc.theWorld, x, y, z, motionX, motionY, motionZ, 1.0F);
        //        }
        //        else if (type == EnumParticleTypesMP.MC_LARGE_SMOKE)
        //        {
        //            entityfx = new EntityMCSmokeFX(mc.theWorld, x, y, z, motionX, motionY, motionZ, 2.5F);
        //        }
        else if (type == EnumParticleTypesMP.MC_EXPLOSION_NORMAL)
        {
            entityfx = new EntityMCExplodeFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
        }
        //        else if (type == EnumParticleTypesMP.MC_EXPLOSION_LARGE)
        //        {
        //            entityfx = new EntityMCLargeExplodeFX(Minecraft.getMinecraft().getTextureManager(), mc.theWorld, x, y, z, motionX, motionY, motionZ);
        //        }
        else if (type == EnumParticleTypesMP.ALIEN_SPLASH)
        {
            entityfx = new EntityAlienSplashFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
        }
        mc.effectRenderer.addEffect(entityfx);
    }

    public static void spawnParticle(EnumParticleTypesMP type, double x, double y, double z)
    {
        EntityFX entityfx = null;
        Minecraft mc = Minecraft.getMinecraft();
        int i = mc.gameSettings.particleSetting;
        double d6 = mc.getRenderViewEntity().posX - x;
        double d7 = mc.getRenderViewEntity().posY - y;
        double d8 = mc.getRenderViewEntity().posZ - z;
        double d9 = 16.0D;

        if (i == 1 && mc.theWorld.rand.nextInt(3) == 0)
        {
            i = 2;
        }
        if (d6 * d6 + d7 * d7 + d8 * d8 > d9 * d9)
        {
            return;
        }
        else if (i > 1)
        {
            return;
        }

        if (type == EnumParticleTypesMP.KOENTUS_SLUDGE_DRIP)
        {
            entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.0F, 0.1F, 0.5F, 0.9F, false);
        }
        else if (type == EnumParticleTypesMP.COCONUT_MILK_DRIP)
        {
            entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 1.0F, 1.0F, 1.0F, 0.9F, false);
        }
        else if (type == EnumParticleTypesMP.MINERAL_WATER_DRIP)
        {
            entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.4F, 0.7F, 0.8F, 0.6F, false);
        }
        else if (type == EnumParticleTypesMP.OVALTINE_DRIP)
        {
            entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.65F, 0.4F, 0.25F, 0.9F, false);
        }
        else if (type == EnumParticleTypesMP.CHEESE_OF_MILK_DRIP)
        {
            entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 1.0F, 0.85F, 0.5F, 0.4F, false);
        }
        else if (type == EnumParticleTypesMP.FROZEN_WATER_DRIP)
        {
            entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.55F, 0.6F, 0.8F, 0.6F, false);
        }
        else if (type == EnumParticleTypesMP.TEA_DRIP)
        {
            entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.25F, 0.5F, 0.15F, 0.7F, false);
        }
        else if (type == EnumParticleTypesMP.CARAMEL_DRIP)
        {
            entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.8F, 0.5F, 0.4F, 0.9F, false);
        }
        else if (type == EnumParticleTypesMP.SIRIUS_LAVA_DRIP)
        {
            entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.8F, 4.95F, 5.0F, 1.0F, true);
        }
        else if (type == EnumParticleTypesMP.BLACK_LAVA_DRIP)
        {
            entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.1F, 0.1F, 0.1F, 1.0F, true);
        }
        //        else if (type == EnumParticleTypesMP.CHEESE_SLIME)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, PolongniusItems.cheese_slimeball, 0);
        //        }
        //        else if (type == EnumParticleTypesMP.VANILLA_CREAM_BALL)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 0);
        //        }
        //        else if (type == EnumParticleTypesMP.CHOCOLATE_CREAM_BALL)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 1);
        //        }
        //        else if (type == EnumParticleTypesMP.STRAWBERRY_CREAM_BALL)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 2);
        //        }
        //        else if (type == EnumParticleTypesMP.ORANGE_CREAM_BALL)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 3);
        //        }
        //        else if (type == EnumParticleTypesMP.TEA_CREAM_BALL)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 4);
        //        }
        //        else if (type == EnumParticleTypesMP.LEMON_CREAM_BALL)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 5);
        //        }
        //        else if (type == EnumParticleTypesMP.GRAPE_JELLY)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 0);
        //        }
        //        else if (type == EnumParticleTypesMP.RASPBERRY_JELLY)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 1);
        //        }
        //        else if (type == EnumParticleTypesMP.STRAWBERRY_JELLY)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 2);
        //        }
        //        else if (type == EnumParticleTypesMP.BERRY_JELLY)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 3);
        //        }
        //        else if (type == EnumParticleTypesMP.LIME_JELLY)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 4);
        //        }
        //        else if (type == EnumParticleTypesMP.ORANGE_JELLY)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 5);
        //        }
        //        else if (type == EnumParticleTypesMP.GREEN_JELLY)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 6);
        //        }
        //        else if (type == EnumParticleTypesMP.LEMON_JELLY)
        //        {
        //            entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 7);
        //        }
        else if (type == EnumParticleTypesMP.ORANGE_DANDELION)
        {
            entityfx = new EntityOrangeDandelionFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.PURPLE_DANDELION)
        {
            entityfx = new EntityPinkDandelionFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.PURPLE_DANDELION)
        {
            entityfx = new EntityPurpleDandelionFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.CHEESE_OF_MILK_BUBBLE)
        {
            entityfx = new EntityCheeseBubbleFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.WHITE_CRYSTAL_SMOKE)
        {
            entityfx = new EntityWhiteCrystalSmokeFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.ICHORIUS_SMOKE)
        {
            entityfx = new EntityGeneratorSmokeFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.PURPLE_SPIKE)
        {
            entityfx = new EntityPurpleSpikeFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.COCONUT_MILK)
        {
            entityfx = new EntityCoconutMilkFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.MINERAL_WATER)
        {
            entityfx = new EntityMineralWaterFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.OVALTINE)
        {
            entityfx = new EntityOvantineSmokeFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.TEA)
        {
            entityfx = new EntityTeaFluidFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.SIRIUS_LAVA)
        {
            entityfx = new EntitySiriusLavaFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.GOLDEN_DUST)
        {
            entityfx = new EntityGoldenGrassFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.GOLDEN_SMOKE)
        {
            entityfx = new EntityGoldenSmokeFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.URANIUM_SMOKE)
        {
            entityfx = new EntityUraniumSmokeFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.SIRIUS_FLAME)
        {
            entityfx = new EntitySiriusFlameFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.BLUE_FLAME)
        {
            entityfx = new EntityBlueFlameFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.VENUS_SMOKE)
        {
            entityfx = new EntityVenusSmokeFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.XEONIUM_SMOKE)
        {
            entityfx = new EntityXeoniumSmokeFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.MC_EXPLOSION_HUGE)
        {
            entityfx = new EntityMCHugeExplodeFX(mc.theWorld, x, y, z);
        }
        else if (type == EnumParticleTypesMP.GREEN_SMOKE)
        {
            entityfx = new EntityGreenRedstoneFX(mc.theWorld, x, y, z);
        }
        mc.effectRenderer.addEffect(entityfx);
    }
}