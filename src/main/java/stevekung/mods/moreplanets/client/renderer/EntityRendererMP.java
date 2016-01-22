/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import stevekung.mods.moreplanets.asteroids.darkasteroids.client.render.entities.RenderDarkAsteroid;
import stevekung.mods.moreplanets.asteroids.darkasteroids.entities.EntityDarkAsteroid;
import stevekung.mods.moreplanets.client.objmodel.AdvancedModelLoader;
import stevekung.mods.moreplanets.client.objmodel.IModelCustom;
import stevekung.mods.moreplanets.client.renderer.entities.RenderEvolvedWitch;
import stevekung.mods.moreplanets.client.renderer.entities.RenderRocketMP;
import stevekung.mods.moreplanets.common.entities.EntityEvolvedWitch;
import stevekung.mods.moreplanets.moons.europa.client.render.entities.RenderEuropaCrab;
import stevekung.mods.moreplanets.moons.europa.client.render.entities.RenderEuropaGuardian;
import stevekung.mods.moreplanets.moons.europa.client.render.entities.RenderEuropaSquid;
import stevekung.mods.moreplanets.moons.europa.client.render.entities.RenderEuropaWaterBomb;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaCrab;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaGuardian;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaSquid;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaWaterBomb;
import stevekung.mods.moreplanets.moons.koentus.client.render.entities.RenderKoentusMeteor;
import stevekung.mods.moreplanets.moons.koentus.client.render.entities.RenderKoentusMeteorChunk;
import stevekung.mods.moreplanets.moons.koentus.client.render.entities.RenderKoentusSludgeling;
import stevekung.mods.moreplanets.moons.koentus.client.render.entities.RenderKoentusianVillager;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusMeteor;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusMeteorChunk;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusSludgeling;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusianVillager;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.RenderDionaCreeperBoss;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.RenderDionaCreeperMinion;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.RenderDustSludgeling;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.RenderEvolvedEnderman;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.RenderFronisiumTNT;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.RenderSpaceWolf;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.projectiles.RenderLaserMP;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.projectiles.RenderProjectileFronisiumTNT;
import stevekung.mods.moreplanets.planets.diona.entities.EntityDionaCreeperBoss;
import stevekung.mods.moreplanets.planets.diona.entities.EntityDionaCreeperMinion;
import stevekung.mods.moreplanets.planets.diona.entities.EntityDustSludgeling;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;
import stevekung.mods.moreplanets.planets.diona.entities.EntityFronisiumTNT;
import stevekung.mods.moreplanets.planets.diona.entities.EntitySpaceWolf;
import stevekung.mods.moreplanets.planets.diona.entities.EntityTier4Rocket;
import stevekung.mods.moreplanets.planets.diona.entities.projectiles.EntityLaserMP;
import stevekung.mods.moreplanets.planets.diona.entities.projectiles.EntityProjectileFronisiumTNT;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderBearry;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderBerry;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderCreamCat;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderCreamGolem;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderCreamSlime;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderFronosVillager;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderGrappy;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderJellySlime;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderJellySlimePet;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderKiwi;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderLemonDuck;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderMarshmallow;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderMelon;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderMilkCow;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderPoisonArrow;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderStarfish;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderStrawberryChicken;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderTier7Rocket;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderTomato;
import stevekung.mods.moreplanets.planets.fronos.client.render.projectile.RenderCreamBall;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityBearry;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityBerry;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityCreamCat;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityCreamGolem;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityCreamSlime;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityFronosVillager;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityGrappy;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityJellySlime;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityJellySlimePet;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityKiwi;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityLemonDuck;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityMarshmallow;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityMelon;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityMilkCow;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityStarfish;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityStrawberryChicken;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityTier7Rocket;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityTomato;
import stevekung.mods.moreplanets.planets.fronos.entities.projectiles.EntityCreamBall;
import stevekung.mods.moreplanets.planets.fronos.entities.projectiles.EntityPoisonArrow;
import stevekung.mods.moreplanets.planets.kapteynb.client.render.entities.RenderFrozenSludgeling;
import stevekung.mods.moreplanets.planets.kapteynb.client.render.entities.RenderIceCrystalMeteor;
import stevekung.mods.moreplanets.planets.kapteynb.client.render.entities.RenderIceCrystalMeteorChunk;
import stevekung.mods.moreplanets.planets.kapteynb.client.render.entities.RenderTier8Rocket;
import stevekung.mods.moreplanets.planets.kapteynb.client.render.entities.RenderUraniumBomb;
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityFrozenSludgeling;
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityIceCrystalMeteor;
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityIceCrystalMeteorChunk;
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityTier8Rocket;
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityUraniumBomb;
import stevekung.mods.moreplanets.planets.nibiru.client.render.entities.RenderGiantWorm;
import stevekung.mods.moreplanets.planets.nibiru.client.render.entities.RenderInfectedEvolvedSpiderBoss;
import stevekung.mods.moreplanets.planets.nibiru.client.render.entities.RenderInfectedWorm;
import stevekung.mods.moreplanets.planets.nibiru.client.render.entities.RenderInfectedZombie;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityEvolvedInfectedSpiderBoss;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityGiantWorm;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityInfectedWorm;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityInfectedZombie;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityTier6Rocket;
import stevekung.mods.moreplanets.planets.pluto.client.render.entities.RenderPlutoAlien;
import stevekung.mods.moreplanets.planets.pluto.entities.EntityPlutoAlien;
import stevekung.mods.moreplanets.planets.polongnius.client.render.entities.RenderCheeseCow;
import stevekung.mods.moreplanets.planets.polongnius.client.render.entities.RenderCheeseCubeBoss;
import stevekung.mods.moreplanets.planets.polongnius.client.render.entities.RenderCheeseSlime;
import stevekung.mods.moreplanets.planets.polongnius.client.render.entities.RenderCheeseSpore;
import stevekung.mods.moreplanets.planets.polongnius.client.render.entities.RenderPolongniusMeteor;
import stevekung.mods.moreplanets.planets.polongnius.client.render.entities.RenderPolongniusMeteorChunk;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityCheeseCow;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityCheeseCubeEyeBoss;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityCheeseSlime;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityPolongniusMeteor;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityPolongniusMeteorChunk;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityTier5Rocket;
import stevekung.mods.moreplanets.planets.polongnius.entities.projectiles.EntityCheeseSpore;
import stevekung.mods.moreplanets.planets.siriusb.client.render.entities.RenderEvolvedSiriusBlazeBoss;
import stevekung.mods.moreplanets.planets.siriusb.client.render.entities.RenderSiriusBlaze;
import stevekung.mods.moreplanets.planets.siriusb.client.render.entities.RenderSiriusCreeper;
import stevekung.mods.moreplanets.planets.siriusb.client.render.entities.RenderSiriusMagmaCube;
import stevekung.mods.moreplanets.planets.siriusb.client.render.entities.projectiles.RenderLargeSiriusFireball;
import stevekung.mods.moreplanets.planets.siriusb.client.render.entities.projectiles.RenderSmallSiriusFireball;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntityEvolvedSiriusBlazeBoss;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusBlaze;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusCreeper;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusMagmaCube;
import stevekung.mods.moreplanets.planets.siriusb.entities.projectiles.EntityLargeSiriusFireball;
import stevekung.mods.moreplanets.planets.siriusb.entities.projectiles.EntitySmallSiriusFireball;
import stevekung.mods.moreplanets.planets.venus.client.render.entities.RenderVenusianBlaze;
import stevekung.mods.moreplanets.planets.venus.client.render.entities.RenderVenusianSlime;
import stevekung.mods.moreplanets.planets.venus.client.render.entities.RenderVenusianVillager;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianBlaze;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianSlime;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianVillager;

public class EntityRendererMP
{
    private static IModelCustom tier3RocketModel = AdvancedModelLoader.loadModel(new ResourceLocation("galacticraftasteroids:models/tier3rocket.obj"));

    public static void init()
    {
        EntityRendererMP.registerEntityRenderers();
        EntityRendererMP.registerNonEntityRenderers();
    }

    private static void registerEntityRenderers()
    {
        RenderManager render = Minecraft.getMinecraft().getRenderManager();

        RenderingRegistry.registerEntityRenderingHandler(EntityDustSludgeling.class, new RenderDustSludgeling(render));
        RenderingRegistry.registerEntityRenderingHandler(EntitySpaceWolf.class, new RenderSpaceWolf(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedEnderman.class, new RenderEvolvedEnderman(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityDionaCreeperBoss.class, new RenderDionaCreeperBoss(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityDionaCreeperMinion.class, new RenderDionaCreeperMinion(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityCheeseCow.class, new RenderCheeseCow(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityCheeseSlime.class, new RenderCheeseSlime(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityCheeseCubeEyeBoss.class, new RenderCheeseCubeBoss(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityInfectedWorm.class, new RenderInfectedWorm(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityGiantWorm.class, new RenderGiantWorm(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityInfectedZombie.class, new RenderInfectedZombie(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedInfectedSpiderBoss.class, new RenderInfectedEvolvedSpiderBoss(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityKoentusianVillager.class, new RenderKoentusianVillager(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityKoentusSludgeling.class, new RenderKoentusSludgeling(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityBearry.class, new RenderBearry(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityBerry.class, new RenderBerry(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityMarshmallow.class, new RenderMarshmallow(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityKiwi.class, new RenderKiwi(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityJellySlime.class, new RenderJellySlime(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityJellySlimePet.class, new RenderJellySlimePet(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityCreamSlime.class, new RenderCreamSlime(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityLemonDuck.class, new RenderLemonDuck(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityStarfish.class, new RenderStarfish(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityMelon.class, new RenderMelon(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityTomato.class, new RenderTomato(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityGrappy.class, new RenderGrappy(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityCreamCat.class, new RenderCreamCat(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityCreamGolem.class, new RenderCreamGolem(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityStrawberryChicken.class, new RenderStrawberryChicken(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityFronosVillager.class, new RenderFronosVillager(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityFrozenSludgeling.class, new RenderFrozenSludgeling(render));

        RenderingRegistry.registerEntityRenderingHandler(EntitySiriusCreeper.class, new RenderSiriusCreeper(render));
        RenderingRegistry.registerEntityRenderingHandler(EntitySiriusBlaze.class, new RenderSiriusBlaze(render));
        RenderingRegistry.registerEntityRenderingHandler(EntitySiriusMagmaCube.class, new RenderSiriusMagmaCube(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedSiriusBlazeBoss.class, new RenderEvolvedSiriusBlazeBoss(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityVenusianBlaze.class, new RenderVenusianBlaze(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityVenusianSlime.class, new RenderVenusianSlime(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityVenusianVillager.class, new RenderVenusianVillager(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityEuropaSquid.class, new RenderEuropaSquid(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityEuropaGuardian.class, new RenderEuropaGuardian(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityEuropaCrab.class, new RenderEuropaCrab(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedWitch.class, new RenderEvolvedWitch(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityMilkCow.class, new RenderMilkCow(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityPlutoAlien.class, new RenderPlutoAlien(render));
    }

    private static void registerNonEntityRenderers()
    {
        RenderManager render = Minecraft.getMinecraft().getRenderManager();

        RenderingRegistry.registerEntityRenderingHandler(EntityTier4Rocket.class, new RenderRocketMP(render, "tier_4_rocket"));
        RenderingRegistry.registerEntityRenderingHandler(EntityProjectileFronisiumTNT.class, new RenderProjectileFronisiumTNT(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityFronisiumTNT.class, new RenderFronisiumTNT(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityLaserMP.class, new RenderLaserMP(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityTier5Rocket.class, new RenderRocketMP(render, "tier_5_rocket"));
        RenderingRegistry.registerEntityRenderingHandler(EntityCheeseSpore.class, new RenderCheeseSpore(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityPolongniusMeteorChunk.class, new RenderPolongniusMeteorChunk(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityPolongniusMeteor.class, new RenderPolongniusMeteor(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityTier6Rocket.class, new RenderRocketMP(render, "tier_6_rocket"));

        RenderingRegistry.registerEntityRenderingHandler(EntityKoentusMeteorChunk.class, new RenderKoentusMeteorChunk(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityKoentusMeteor.class, new RenderKoentusMeteor(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityCreamBall.class, new RenderCreamBall(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityPoisonArrow.class, new RenderPoisonArrow(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityTier7Rocket.class, new RenderTier7Rocket(render, EntityRendererMP.tier3RocketModel, "moreplanets", "tier_7_rocket"));

        RenderingRegistry.registerEntityRenderingHandler(EntityUraniumBomb.class, new RenderUraniumBomb(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityTier8Rocket.class, new RenderTier8Rocket(render, EntityRendererMP.tier3RocketModel, "moreplanets", "tier_8_rocket"));
        RenderingRegistry.registerEntityRenderingHandler(EntityIceCrystalMeteor.class, new RenderIceCrystalMeteor(render));

        RenderingRegistry.registerEntityRenderingHandler(EntitySmallSiriusFireball.class, new RenderSmallSiriusFireball(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityLargeSiriusFireball.class, new RenderLargeSiriusFireball(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityEuropaWaterBomb.class, new RenderEuropaWaterBomb(render));

        RenderingRegistry.registerEntityRenderingHandler(EntityDarkAsteroid.class, new RenderDarkAsteroid(render));
        RenderingRegistry.registerEntityRenderingHandler(EntityIceCrystalMeteorChunk.class, new RenderIceCrystalMeteorChunk(render));
    }
}