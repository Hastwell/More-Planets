/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.init;

import java.util.HashMap;
import java.util.LinkedHashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry.EntityRegistration;
import stevekung.mods.moreplanets.asteroids.darkasteroids.entities.EntityDarkAsteroid;
import stevekung.mods.moreplanets.common.entities.EntityEvolvedWitch;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaCrab;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaGuardian;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaSquid;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaWaterBomb;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusMeteor;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusMeteorChunk;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusSludgeling;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusianVillager;
import stevekung.mods.moreplanets.planets.diona.entities.EntityDionaCreeperBoss;
import stevekung.mods.moreplanets.planets.diona.entities.EntityDionaCreeperMinion;
import stevekung.mods.moreplanets.planets.diona.entities.EntityDustSludgeling;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;
import stevekung.mods.moreplanets.planets.diona.entities.EntityFronisiumTNT;
import stevekung.mods.moreplanets.planets.diona.entities.EntitySpaceWolf;
import stevekung.mods.moreplanets.planets.diona.entities.EntityTier4Rocket;
import stevekung.mods.moreplanets.planets.diona.entities.projectiles.EntityLaserMP;
import stevekung.mods.moreplanets.planets.diona.entities.projectiles.EntityProjectileFronisiumTNT;
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
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityFrozenSludgeling;
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityIceCrystalMeteor;
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityTier8Rocket;
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityUraniumBomb;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityEvolvedInfectedSpiderBoss;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityGiantWorm;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityInfectedWorm;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityInfectedZombie;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityTier6Rocket;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityCheeseCow;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityCheeseCubeEyeBoss;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityCheeseSlime;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityPolongniusMeteor;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityPolongniusMeteorChunk;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityTier5Rocket;
import stevekung.mods.moreplanets.planets.polongnius.entities.projectiles.EntityCheeseSpore;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntityEvolvedSiriusBlazeBoss;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusBlaze;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusCreeper;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusMagmaCube;
import stevekung.mods.moreplanets.planets.siriusb.entities.projectiles.EntityLargeSiriusFireball;
import stevekung.mods.moreplanets.planets.siriusb.entities.projectiles.EntitySmallSiriusFireball;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianBlaze;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianSlime;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianVillager;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class MPEntities
{
    public static HashMap<Integer, EntityEggInfo> entityEggs = new LinkedHashMap();

    public static void init()
    {
        MPEntities.registerEntities();
        MPEntities.registerNonMobEntities();
        MPLog.debug("Register Entities");
    }

    private static void registerEntities()
    {
        MPEntities.registerEntity(EntitySpaceWolf.class, "SpaceWolf", 0, 14144467, 13545366, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityEvolvedEnderman.class, "EvolvedEnderman", 1, 1447446, 0, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityDustSludgeling.class, "DustSludgeling", 2, -4144960, -8355712, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityDionaCreeperBoss.class, "DionaCreeperBoss", 3, -8355712, -16726874, null);
        MPEntities.registerEntity(EntityDionaCreeperMinion.class, "DionaCreeperMinion", 4, -8355712, -9269647, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityCheeseCow.class, "CheeseCow", 5, -19712, -6985197, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityCheeseSlime.class, "CheeseSlime", 6, -14848, -8323, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityCheeseCubeEyeBoss.class, "CheeseCubeBoss", 7, -14848, -4259830, null);
        MPEntities.registerEntity(EntityInfectedWorm.class, "InfectedWorm", 8, -5160639, -7131345, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityGiantWorm.class, "GiantWorm", 9, -2060769, -1413099, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityInfectedZombie.class, "InfectedZombie", 10, -7520229, -2060769, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityEvolvedInfectedSpiderBoss.class, "EvolvedInfectedSpiderBoss", 11, -6796279, -13369498, null);
        MPEntities.registerEntity(EntityKoentusianVillager.class, "KoentusianVillager", 12, -16777040, -16744320, null);
        MPEntities.registerEntity(EntityKoentusSludgeling.class, "KoentusSludgeling", 13, -16777040, -16777031, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityBearry.class, "Bearry", 14, -391882, -16744448, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityBerry.class, "Berry", 15, -11403100, -10157878, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityMarshmallow.class, "Marshmallow", 16, -2631721, -1052689, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityKiwi.class, "Kiwi", 17, -8608972, -8031948, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityJellySlime.class, "JellySlime", 18, -2005303, -2208060, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityCreamSlime.class, "CreamSlime", 19, -4176, -1827, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityLemonDuck.class, "LemonDuck", 20, -2558710, -3804404, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityStarfish.class, "SpaceStarfish", 21, -3433, -7883, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityMelon.class, "Melon", 22, -26833, -11618715, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityTomato.class, "Tomato", 23, -3538944, -3066352, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityGrappy.class, "Grappy", 24, -4737025, -4144960, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityCreamCat.class, "CreamCat", 25, -3655, -6004, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityCreamGolem.class, "CreamGolem", 26, -3655, -6004, null);
        MPEntities.registerEntity(EntityStrawberryChicken.class, "StrawberryChicken", 27, -12545, -20225, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityFronosVillager.class, "FronosVillager", 28, -5476528, -4144960, null);
        MPEntities.registerEntity(EntityFrozenSludgeling.class, "FrozenSludgeling", 29, -4996406, -2038040, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntitySiriusCreeper.class, "SiriusCreeper", 30, -4259841, 0, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntitySiriusBlaze.class, "SiriusBlaze", 31, -4390913, -6758433, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntitySiriusMagmaCube.class, "SiriusMagmaCube", 32, -12163225, -5769739, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityEvolvedSiriusBlazeBoss.class, "EvolvedSiriusBlazeBoss", 33, -4390913, -892881, null);
        MPEntities.registerEntity(EntityVenusianBlaze.class, "VenusianBlaze", 34, -27809, -45282, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityVenusianSlime.class, "VenusianSlime", 35, -262144, -205056, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityVenusianVillager.class, "VenusianVillager", 36, -13875061, -4875400, null);
        MPEntities.registerEntity(EntityEuropaSquid.class, "EuropaSquid", 37, -12425324, -6163201, SpawnPlacementType.IN_WATER);
        MPEntities.registerEntity(EntityEuropaGuardian.class, "EuropaGuardian", 38, -9010279, -12268469, SpawnPlacementType.IN_WATER);
        MPEntities.registerEntity(EntityEuropaCrab.class, "EuropaCrab", 39, -11574413, -12167066, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityJellySlimePet.class, "JellySlimePet", 40, -2005303, -2208060, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityEvolvedWitch.class, "EvolvedWitch", 41, 3407872, 5349438, SpawnPlacementType.ON_GROUND);
        MPEntities.registerEntity(EntityMilkCow.class, "MilkCow", 42, -13487566, -657931, SpawnPlacementType.ON_GROUND);
    }

    private static void registerNonMobEntities()
    {
        CommonRegisterHelper.registerNonMobEntity(EntityTier4Rocket.class, "Tier4Rocket", MorePlanetsCore.INSTANCE, false);
        CommonRegisterHelper.registerNonMobEntity(EntityProjectileFronisiumTNT.class, "ProjectileFronisiumTNT", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityFronisiumTNT.class, "FronisiumTNT", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityLaserMP.class, "ProjectileLaser", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityTier5Rocket.class, "Tier5Rocket", MorePlanetsCore.INSTANCE, false);
        CommonRegisterHelper.registerNonMobEntity(EntityCheeseSpore.class, "CheeseSpore", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityPolongniusMeteorChunk.class, "PolongniusMeteorChunk", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityPolongniusMeteor.class, "PolongniusMeteor", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityTier6Rocket.class, "Tier6Rocket", MorePlanetsCore.INSTANCE, false);
        CommonRegisterHelper.registerNonMobEntity(EntityKoentusMeteorChunk.class, "KoentusMeteorChunk", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityKoentusMeteor.class, "KoentusMeteor", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityCreamBall.class, "CreamBall", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityPoisonArrow.class, "PoisonArrow", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityTier7Rocket.class, "Tier7Rocket", MorePlanetsCore.INSTANCE, false);
        CommonRegisterHelper.registerNonMobEntity(EntitySmallSiriusFireball.class, "SmallSiriusFireball", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityLargeSiriusFireball.class, "LargeSiriusFireball", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityUraniumBomb.class, "UraniumBomb", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityIceCrystalMeteor.class, "IceCrystalMeteor", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityTier8Rocket.class, "Tier8Rocket", MorePlanetsCore.INSTANCE, false);
        CommonRegisterHelper.registerNonMobEntity(EntityEuropaWaterBomb.class, "EuropaWaterBomb", MorePlanetsCore.INSTANCE, true);
        CommonRegisterHelper.registerNonMobEntity(EntityDarkAsteroid.class, "DarkAsteroid", MorePlanetsCore.INSTANCE, true);
    }

    private static void registerEntity(Class<? extends Entity> entity, String name, int id, int backgroundEggColour, int foregroundEggColour, SpawnPlacementType type)
    {
        id = id + 1000;
        EntityRegistry.registerModEntity(entity, name, id, MorePlanetsCore.INSTANCE, 64, 3, true);

        if (type != null)
        {
            EntitySpawnPlacementRegistry.setPlacementType(entity, type);
            MPLog.debug("Register spawn placement type of %s, %s", name, type.toString());
        }
        entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, backgroundEggColour, foregroundEggColour));
    }

    public static String getStringFromID(int id)
    {
        EntityRegistration regis = EntityRegistry.instance().lookupModSpawn(FMLCommonHandler.instance().findContainerFor(MorePlanetsCore.INSTANCE), id);

        if (regis != null)
        {
            return regis.getEntityName();
        }
        return null;
    }

    public static Entity createEntityByID(int id, World world)
    {
        Entity entity = null;

        try
        {
            EntityRegistration regis = EntityRegistry.instance().lookupModSpawn(FMLCommonHandler.instance().findContainerFor(MorePlanetsCore.INSTANCE), id);
            Class<?> clazz = regis.getEntityClass();

            if (clazz != null)
            {
                entity = (Entity)clazz.getConstructor(new Class[] { World.class }).newInstance(new Object[] { world });
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (entity == null)
        {
            MPLog.error("Skipping Entity with id " + id);
        }
        return entity;
    }
}