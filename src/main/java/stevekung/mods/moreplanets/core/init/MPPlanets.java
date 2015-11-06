/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.init;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.dimension.TeleportTypeMP;
import stevekung.mods.moreplanets.common.dimension.TeleportTypeOrbitMP;
import stevekung.mods.moreplanets.common.spacestation.jupiter.WorldProviderJupiterOrbit;
import stevekung.mods.moreplanets.common.spacestation.mars.WorldProviderMarsOrbit;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.common.util.MorePlanetsRegistry;
import stevekung.mods.moreplanets.moons.deimos.dimension.WorldProviderDeimos;
import stevekung.mods.moreplanets.moons.koentus.dimension.WorldProviderKoentus;
import stevekung.mods.moreplanets.moons.phobos.dimension.WorldProviderPhobos;
import stevekung.mods.moreplanets.planets.diona.dimension.WorldProviderDiona;
import stevekung.mods.moreplanets.planets.fronos.dimension.WorldProviderFronos;
import stevekung.mods.moreplanets.planets.kapteynb.dimension.WorldProviderKapteynB;
import stevekung.mods.moreplanets.planets.mercury.dimension.WorldProviderMercury;
import stevekung.mods.moreplanets.planets.nibiru.dimension.WorldProviderNibiru;
import stevekung.mods.moreplanets.planets.pluto.dimension.WorldProviderPluto;
import stevekung.mods.moreplanets.planets.polongnius.dimension.WorldProviderPolongnius;
import stevekung.mods.moreplanets.planets.siriusb.dimension.WorldProviderSiriusB;
import stevekung.mods.moreplanets.planets.venus.dimension.WorldProviderVenus;

public class MPPlanets
{
	public static Planet diona;
	public static Planet polongnius;
	public static Planet nibiru;
	public static Planet fronos;
	public static Planet kapteynB;
	public static Planet siriusB;
	public static Planet mercury;
	public static Planet venus;
	public static Planet pluto;
	public static Planet jupiter;
	public static Moon koentus;
	public static Moon phobos;
	public static Moon deimos;
	public static Moon io;
	public static Star sirius;
	public static Star kapteyn;
	public static SolarSystem siriusSolarSystem;
	public static SolarSystem kapteynBSolarSystem;
	public static Satellite marsSpaceStation;
	public static Satellite jupiterSpaceStation;
	public static Satellite kapteynBSpaceStation;

	public static void init()
	{
		TeleportTypeMP teleport = new TeleportTypeMP();

		// Init Solar Systems
		MPPlanets.siriusSolarSystem = new SolarSystem("sirius", "milkyWay").setMapPosition(new Vector3(1.25F, 1.5F, 0.0F));
		MPPlanets.sirius = MorePlanetsRegistry.createStar("sirius", MPPlanets.siriusSolarSystem, new ResourceLocation("moreplanets:textures/gui/celestialbodies/sirius_celestial.png"));
		MPPlanets.siriusSolarSystem.setMainStar(MPPlanets.sirius);

		MPPlanets.kapteynBSolarSystem = new SolarSystem("kapteyn", "milkyWay").setMapPosition(new Vector3(-1.5F, 0.8F, 0.0F));
		MPPlanets.kapteyn = MorePlanetsRegistry.createStar("kapteyn", MPPlanets.kapteynBSolarSystem, new ResourceLocation("moreplanets:textures/gui/celestialbodies/kapteyn_star_celestial.png"));
		MPPlanets.kapteynBSolarSystem.setMainStar(MPPlanets.kapteyn);

		// Init Planets
		MPPlanets.diona = MorePlanetsRegistry.createPlanet("diona", MPPlanets.siriusSolarSystem, 8.7446F, 5.0F, 13.7685F, 0.876F, 4, new ResourceLocation("moreplanets:textures/gui/celestialbodies/diona.png"));
		MPPlanets.diona.setDimensionInfo(ConfigManagerMP.idDimensionDiona, WorldProviderDiona.class);
		MPPlanets.diona.atmosphereComponent(IAtmosphericGas.CO2);

		MPPlanets.polongnius = MorePlanetsRegistry.createPlanet("polongnius", MPPlanets.siriusSolarSystem, 12.2478F, 4.25F, 76.4168F, 1.465F, 5, new ResourceLocation("moreplanets:textures/gui/celestialbodies/polongnius.png"));
		MPPlanets.polongnius.setDimensionInfo(ConfigManagerMP.idDimensionPolongnius, WorldProviderPolongnius.class);
		MPPlanets.polongnius.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON);

		MPPlanets.nibiru = MorePlanetsRegistry.createPlanet("nibiru", MPPlanets.siriusSolarSystem, 52.4341F, 3.75F, 71.6582F, 4.678F, 6, new ResourceLocation("moreplanets:textures/gui/celestialbodies/nibiru.png"));
		MPPlanets.nibiru.setDimensionInfo(ConfigManagerMP.idDimensionNibiru, WorldProviderNibiru.class);
		MPPlanets.nibiru.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.HELIUM);

		MPPlanets.fronos = MorePlanetsRegistry.createPlanet("fronos", MPPlanets.siriusSolarSystem, 1.2762F, 2.5F, 1 / 0.05F, 0.5316F, 7, new ResourceLocation("moreplanets:textures/gui/celestialbodies/fronos.png"));
		MPPlanets.fronos.setDimensionInfo(ConfigManagerMP.idDimensionFronos, WorldProviderFronos.class);
		MPPlanets.fronos.atmosphereComponent(IAtmosphericGas.OXYGEN).atmosphereComponent(IAtmosphericGas.WATER).atmosphereComponent(IAtmosphericGas.NITROGEN).atmosphereComponent(IAtmosphericGas.HYDROGEN);

		MPPlanets.kapteynB = MorePlanetsRegistry.createPlanet("kapteynB", MPPlanets.kapteynBSolarSystem, 1 / 2.0F, 1.0F, 1.9746F, 3.7654F, 7, new ResourceLocation("moreplanets:textures/gui/celestialbodies/kapteyn_b.png"));
		MPPlanets.kapteynB.setDimensionInfo(ConfigManagerMP.idDimensionKapteynB, WorldProviderKapteynB.class);
		MPPlanets.kapteynB.atmosphereComponent(IAtmosphericGas.NITROGEN).atmosphereComponent(IAtmosphericGas.WATER).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.HYDROGEN);

		MPPlanets.siriusB = MorePlanetsRegistry.createPlanet("siriusB", MPPlanets.siriusSolarSystem, 100.0F, 0.1F, 46.5F, 0.125F, 8, new ResourceLocation("moreplanets:textures/gui/celestialbodies/sirius_b.png"));
		MPPlanets.siriusB.setDimensionInfo(ConfigManagerMP.idDimensionSiriusB, WorldProviderSiriusB.class);
		MPPlanets.siriusB.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM);

		if (ConfigManagerMP.enableMercuryPlanet)
		{
			MPPlanets.mercury = MorePlanetsRegistry.createPlanet("mercury", GalacticraftCore.solarSystemSol, 1.45F, 0.5F, 0.24096385542168674698795180722892F, 0.5319F, 4, new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/mercury.png"));
			MPPlanets.mercury.setDimensionInfo(ConfigManagerMP.idDimensionMercury, WorldProviderMercury.class);
			MPPlanets.mercury.atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.OXYGEN);
		}
		if (ConfigManagerMP.enableVenusPlanet)
		{
			MPPlanets.venus = MorePlanetsRegistry.createPlanet("venus", GalacticraftCore.solarSystemSol, 2.0F, 0.75F, 0.6152793F, 0.0F, 3, new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/venus.png"));
			MPPlanets.venus.setDimensionInfo(ConfigManagerMP.idDimensionVenus, WorldProviderVenus.class);
			MPPlanets.venus.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.NITROGEN).atmosphereComponent(IAtmosphericGas.ARGON);
		}
		if (ConfigManagerMP.enableJupiterPlanet)
		{
			MPPlanets.jupiter = MorePlanetsRegistry.createPlanet("jupiter", GalacticraftCore.solarSystemSol, 2.3F, 1.5F, 11.861993428258488499452354874042F, 0.5319F, -1, new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/jupiter.png"));
			MPPlanets.jupiter.setDimensionInfo(ConfigManagerMP.idDimensionJupiter, WorldProviderPluto.class);
			MPPlanets.jupiter.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/jupiter.png"));
		}
		if (ConfigManagerMP.enablePlutoPlanet)
		{
			MPPlanets.pluto = MorePlanetsRegistry.createPlanet("pluto", GalacticraftCore.solarSystemSol, 2.0F, 2.5F, 194.84119F, 0.0F, 5, new ResourceLocation("moreplanets:textures/gui/celestialbodies/pluto.png"));
			MPPlanets.pluto.setDimensionInfo(ConfigManagerMP.idDimensionPluto, WorldProviderPluto.class);
			MPPlanets.pluto.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.NITROGEN);
		}

		// Init Moons
		MPPlanets.koentus = MorePlanetsRegistry.createMoon("koentus", MPPlanets.diona, 2.436F, 9.5F, 1 / 0.01F, 0.3867F, 4, new ResourceLocation("moreplanets:textures/gui/celestialbodies/koentus.png"));
		MPPlanets.koentus.setDimensionInfo(ConfigManagerMP.idDimensionKoentus, WorldProviderKoentus.class);
		MPPlanets.koentus.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.NITROGEN).atmosphereComponent(IAtmosphericGas.HELIUM);

		if (ConfigManagerMP.enablePhobosMoon)
		{
			MPPlanets.phobos = MorePlanetsRegistry.createMoon("phobos", MarsModule.planetMars, 4.25F, 10.0F, 1 / 0.01F, 0.3867F, 2, new ResourceLocation("moreplanets:textures/gui/celestialbodies/phobos.png"));
			MPPlanets.phobos.setDimensionInfo(ConfigManagerMP.idDimensionPhobos, WorldProviderPhobos.class);
		}
		if (ConfigManagerMP.enableDeimosMoon)
		{
			MPPlanets.deimos = MorePlanetsRegistry.createMoon("deimos", MarsModule.planetMars, 2.25F, 15.0F, 1 / 0.01F, 0.3867F, 2, new ResourceLocation("moreplanets:textures/gui/celestialbodies/deimos.png"));
			MPPlanets.deimos.setDimensionInfo(ConfigManagerMP.idDimensionDeimos, WorldProviderDeimos.class);
		}

		// Init Space Stations
		if (ConfigManagerMP.enableJupiterSpaceStation)
		{
			MPPlanets.jupiterSpaceStation = MorePlanetsRegistry.createSatellite("jupiterMP", MPPlanets.jupiter, 0.25F, 9.0F, 1 / 0.05F, 0.2667F, 4, new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
			MPPlanets.jupiterSpaceStation.setDimensionInfo(ConfigManagerMP.idDimensionJupiterSpaceStation, ConfigManagerMP.idDimensionStaticJupiterSpaceStation, WorldProviderJupiterOrbit.class);
		}
		if (ConfigManagerMP.enableMarsSpaceStation)
		{
			MPPlanets.marsSpaceStation = MorePlanetsRegistry.createSatellite("marsMP", MarsModule.planetMars, 0.25F, 12.5F, 1 / 0.05F, 0.2667F, 2, new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
			MPPlanets.marsSpaceStation.setDimensionInfo(ConfigManagerMP.idDimensionMarsSpaceStation, ConfigManagerMP.idDimensionStaticMarsSpaceStation, WorldProviderMarsOrbit.class);
		}

		// Register
		GalaxyRegistry.registerSolarSystem(MPPlanets.siriusSolarSystem);
		GalaxyRegistry.registerSolarSystem(MPPlanets.kapteynBSolarSystem);

		GalaxyRegistry.registerPlanet(MPPlanets.diona);
		GalaxyRegistry.registerPlanet(MPPlanets.polongnius);
		GalaxyRegistry.registerPlanet(MPPlanets.nibiru);
		GalaxyRegistry.registerPlanet(MPPlanets.fronos);
		GalaxyRegistry.registerPlanet(MPPlanets.kapteynB);
		GalaxyRegistry.registerPlanet(MPPlanets.siriusB);

		GalaxyRegistry.registerMoon(MPPlanets.koentus);

		if (ConfigManagerMP.enableJupiterSpaceStation) { GalaxyRegistry.registerSatellite(MPPlanets.jupiterSpaceStation); }
		if (ConfigManagerMP.enableMarsSpaceStation) { GalaxyRegistry.registerSatellite(MPPlanets.marsSpaceStation); }

		if (ConfigManagerMP.enableMercuryPlanet) { GalaxyRegistry.registerPlanet(MPPlanets.mercury); }
		if (ConfigManagerMP.enableVenusPlanet) { GalaxyRegistry.registerPlanet(MPPlanets.venus); }
		if (ConfigManagerMP.enablePlutoPlanet) { GalaxyRegistry.registerPlanet(MPPlanets.pluto); }
		if (ConfigManagerMP.enableJupiterPlanet) { GalaxyRegistry.registerPlanet(MPPlanets.jupiter); }

		if (ConfigManagerMP.enablePhobosMoon) { GalaxyRegistry.registerMoon(MPPlanets.deimos); }
		if (ConfigManagerMP.enableDeimosMoon) { GalaxyRegistry.registerMoon(MPPlanets.phobos); }

		if (ConfigManagerMP.enableJupiterSpaceStation) { MorePlanetsRegistry.registerProvider(ConfigManagerMP.idDimensionJupiterSpaceStation, ConfigManagerMP.idDimensionStaticJupiterSpaceStation, WorldProviderJupiterOrbit.class); }
		if (ConfigManagerMP.enableMarsSpaceStation) { MorePlanetsRegistry.registerProvider(ConfigManagerMP.idDimensionMarsSpaceStation, ConfigManagerMP.idDimensionStaticMarsSpaceStation, WorldProviderMarsOrbit.class); }

		GalacticraftRegistry.registerTeleportType(WorldProviderDiona.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderPolongnius.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderNibiru.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderKoentus.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderFronos.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderKapteynB.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderSiriusB.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderMercury.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderVenus.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderPluto.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderDeimos.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderPhobos.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderJupiterOrbit.class, new TeleportTypeOrbitMP());
		GalacticraftRegistry.registerTeleportType(WorldProviderMarsOrbit.class, new TeleportTypeOrbitMP());

		GalacticraftRegistry.registerRocketGui(WorldProviderDiona.class, new ResourceLocation("moreplanets:textures/gui/rocket/diona.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderPolongnius.class, new ResourceLocation("moreplanets:textures/gui/rocket/polongnius.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderNibiru.class, new ResourceLocation("moreplanets:textures/gui/rocket/nibiru.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderKoentus.class, new ResourceLocation("moreplanets:textures/gui/rocket/koentus.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderFronos.class, new ResourceLocation("moreplanets:textures/gui/rocket/fronos.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderKapteynB.class, new ResourceLocation("moreplanets:textures/gui/rocket/kapteyn_b.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderSiriusB.class, new ResourceLocation("moreplanets:textures/gui/rocket/sirius_b.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderMercury.class, new ResourceLocation("moreplanets:textures/gui/rocket/mercury.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderVenus.class, new ResourceLocation("moreplanets:textures/gui/rocket/venus.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderPluto.class, new ResourceLocation("moreplanets:textures/gui/rocket/pluto.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderDeimos.class, new ResourceLocation("moreplanets:textures/gui/rocket/deimos.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderPhobos.class, new ResourceLocation("moreplanets:textures/gui/rocket/phobos.png"));

		MPLog.debug("Register Planets/Moons");
	}
}