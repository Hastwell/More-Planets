/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.renderer;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
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
        RenderingRegistry.registerEntityRenderingHandler(EntityDustSludgeling.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderDustSludgeling(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntitySpaceWolf.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderSpaceWolf(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedEnderman.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderEvolvedEnderman(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityDionaCreeperBoss.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderDionaCreeperBoss(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityDionaCreeperMinion.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderDionaCreeperMinion(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCheeseCow.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderCheeseCow(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCheeseSlime.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderCheeseSlime(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCheeseCubeEyeBoss.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderCheeseCubeBoss(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityInfectedWorm.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderInfectedWorm(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityGiantWorm.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderGiantWorm(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityInfectedZombie.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderInfectedZombie(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedInfectedSpiderBoss.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderInfectedEvolvedSpiderBoss(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityKoentusianVillager.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderKoentusianVillager(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityKoentusSludgeling.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderKoentusSludgeling(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityBearry.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderBearry(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityBerry.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderBerry(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityMarshmallow.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderMarshmallow(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityKiwi.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderKiwi(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityJellySlime.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderJellySlime(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityJellySlimePet.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderJellySlimePet(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCreamSlime.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderCreamSlime(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityLemonDuck.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderLemonDuck(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityStarfish.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderStarfish(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityMelon.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderMelon(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityTomato.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderTomato(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityGrappy.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderGrappy(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCreamCat.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderCreamCat(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCreamGolem.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderCreamGolem(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityStrawberryChicken.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderStrawberryChicken(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityFronosVillager.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderFronosVillager(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityFrozenSludgeling.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderFrozenSludgeling(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntitySiriusCreeper.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderSiriusCreeper(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntitySiriusBlaze.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderSiriusBlaze(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntitySiriusMagmaCube.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderSiriusMagmaCube(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedSiriusBlazeBoss.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderEvolvedSiriusBlazeBoss(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityVenusianBlaze.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderVenusianBlaze(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityVenusianSlime.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderVenusianSlime(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityVenusianVillager.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderVenusianVillager(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityEuropaSquid.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderEuropaSquid(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityEuropaGuardian.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderEuropaGuardian(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityEuropaCrab.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderEuropaCrab(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedWitch.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderEvolvedWitch(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityMilkCow.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderMilkCow(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityPlutoAlien.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderPlutoAlien(manager);
            }
        });
    }

    private static void registerNonEntityRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityTier4Rocket.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderRocketMP(manager, "tier_4_rocket");
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityProjectileFronisiumTNT.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderProjectileFronisiumTNT(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityFronisiumTNT.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderFronisiumTNT(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityLaserMP.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderLaserMP(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityTier5Rocket.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderRocketMP(manager, "tier_5_rocket");
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCheeseSpore.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderCheeseSpore(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityPolongniusMeteorChunk.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderPolongniusMeteorChunk(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityPolongniusMeteor.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderPolongniusMeteor(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityTier6Rocket.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderRocketMP(manager, "tier_6_rocket");
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityKoentusMeteorChunk.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderKoentusMeteorChunk(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityKoentusMeteor.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderKoentusMeteor(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCreamBall.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderCreamBall(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityPoisonArrow.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderPoisonArrow(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityTier7Rocket.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderTier7Rocket(manager, EntityRendererMP.tier3RocketModel, "moreplanets", "tier_7_rocket");
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityUraniumBomb.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderUraniumBomb(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityTier8Rocket.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderTier8Rocket(manager, EntityRendererMP.tier3RocketModel, "moreplanets", "tier_8_rocket");
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityIceCrystalMeteor.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderIceCrystalMeteor(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntitySmallSiriusFireball.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderSmallSiriusFireball(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityLargeSiriusFireball.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderLargeSiriusFireball(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityEuropaWaterBomb.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderEuropaWaterBomb(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityDarkAsteroid.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderDarkAsteroid(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityIceCrystalMeteorChunk.class, new IRenderFactory()
        {
            @Override
            public Render createRenderFor(RenderManager manager)
            {
                return new RenderIceCrystalMeteorChunk(manager);
            }
        });
    }
}