/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core;

import java.io.File;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import net.minecraft.block.Block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import stevekung.mods.moreplanets.client.handler.GuiEventHandler;
import stevekung.mods.moreplanets.client.handler.PlanetFogHandler;
import stevekung.mods.moreplanets.client.handler.SkyProviderHandler;
import stevekung.mods.moreplanets.common.achievement.AchievementsMP;
import stevekung.mods.moreplanets.common.command.CommandHomePlanet;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.eventhandler.MorePlanetsEvents;
import stevekung.mods.moreplanets.common.integration.DispenserRegistryMP;
import stevekung.mods.moreplanets.common.integration.TreeCapitatorIntegrationMP;
import stevekung.mods.moreplanets.common.network.meteor.MeteorClientHandler;
import stevekung.mods.moreplanets.common.network.meteor.MeteorClientMessage;
import stevekung.mods.moreplanets.common.network.meteor.MeteorServerHandler;
import stevekung.mods.moreplanets.common.network.meteor.MeteorServerMessage;
import stevekung.mods.moreplanets.common.recipe.CraftingManagerMP;
import stevekung.mods.moreplanets.common.sounds.SoundTypeSmallSlime;
import stevekung.mods.moreplanets.common.util.EntitySpawnerUtil;
import stevekung.mods.moreplanets.common.util.FurnaceFuelMP;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.common.util.MorePlanetsRegistry;
import stevekung.mods.moreplanets.core.init.MPArmors;
import stevekung.mods.moreplanets.core.init.MPBiomes;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.core.init.MPEntities;
import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.core.init.MPPlanets;
import stevekung.mods.moreplanets.core.init.MPPotions;
import stevekung.mods.moreplanets.core.init.MPTileEntities;
import stevekung.mods.moreplanets.core.init.MPTools;
import stevekung.mods.moreplanets.core.proxy.CommonProxyMP;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.moreplanets.planets.diona.schematic.SchematicTier4Rocket;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.fronos.items.armor.FronosArmorItems;
import stevekung.mods.moreplanets.planets.fronos.schematics.SchematicTier7Rocket;
import stevekung.mods.moreplanets.planets.kapteynb.items.tools.KapteynBToolsItems;
import stevekung.mods.moreplanets.planets.kapteynb.schematics.SchematicTier8Rocket;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;
import stevekung.mods.moreplanets.planets.nibiru.schematics.SchematicTier6Rocket;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import stevekung.mods.moreplanets.planets.polongnius.schematics.SchematicTier5Rocket;
import stevekung.mods.stevecore.CommonRegisterHelper;

@Mod(modid = MorePlanetsCore.MOD_ID, name = MorePlanetsCore.NAME, version = MorePlanetsCore.VERSION, dependencies = /*"required-after:GalacticraftCore; required-after:GalacticraftMars;*/" after:Forge@[11.15.0.1622,);", guiFactory = "stevekung.mods.moreplanets.common.config.ConfigGuiFactoryMP")//TODO required-after:Micdoodlecore;
public class MorePlanetsCore
{
    public static final String NAME = "More Planets";
    public static final String MOD_ID = "MorePlanets";
    public static final String VERSION = MorePlanetsCore.major_version + "." + MorePlanetsCore.minor_version + "." + MorePlanetsCore.build_version;

    public static final int major_version = 2;
    public static final int minor_version = 0;
    public static final int build_version = 0;

    @SidedProxy(clientSide = "stevekung.mods.moreplanets.core.proxy.ClientProxyMP", serverSide = "stevekung.mods.moreplanets.core.proxy.CommonProxyMP")
    public static CommonProxyMP proxy;

    @Instance(MorePlanetsCore.MOD_ID)
    public static MorePlanetsCore INSTANCE;

    public static CreativeTabs mpBlocksTab;
    public static CreativeTabs mpItemsTab;
    public static CreativeTabs mpToolsTab;
    public static CreativeTabs mpArmorTab;

    public static SoundType soundTypeSmallSlime = new SoundTypeSmallSlime();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigManagerMP.init(new File(event.getModConfigurationDirectory(), "MorePlanets.cfg"));
        MPLog.debug("Enable Debug Logging");

        MPPotions.init();
        MPBlocks.init();
        MPItems.init();
        MPArmors.init();
        MPTools.init();
        MPBiomes.init();

        CommonRegisterHelper.registerForgeEvent(new MorePlanetsEvents());
        CommonRegisterHelper.registerForgeEvent(new SkyProviderHandler());
        CommonRegisterHelper.registerForgeEvent(new PlanetFogHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MPPlanets.init();
        MPEntities.init();
        TreeCapitatorIntegrationMP.init();
        AchievementsMP.init();
        EntitySpawnerUtil.init();
        CommonRegisterHelper.registerGUIHandler(this, new GuiEventHandler());

        MorePlanetsCore.mpBlocksTab = CommonRegisterHelper.createCreativeTabs("MorePlanetsBlocks", new ItemStack(MercuryBlocks.mercury_block, 1, 11));
        MorePlanetsCore.mpItemsTab = CommonRegisterHelper.createCreativeTabs("MorePlanetsItems", new ItemStack(DionaItems.laser_gun));
        MorePlanetsCore.mpToolsTab = CommonRegisterHelper.createCreativeTabs("MorePlanetsTools", new ItemStack(KapteynBToolsItems.uranium_pickaxe));
        MorePlanetsCore.mpArmorTab = CommonRegisterHelper.createCreativeTabs("MorePlanetsArmor", new ItemStack(FronosArmorItems.iridium_helmet));

        MorePlanetsRegistry.registerSchematic(new SchematicTier4Rocket());
        MorePlanetsRegistry.registerSchematic(new SchematicTier5Rocket());
        MorePlanetsRegistry.registerSchematic(new SchematicTier6Rocket());
        MorePlanetsRegistry.registerSchematic(new SchematicTier7Rocket());
        MorePlanetsRegistry.registerSchematic(new SchematicTier8Rocket());

        MorePlanetsRegistry.registerDungeonLoot(GalacticraftCore.moonMoon, new ItemStack(DionaItems.tier_4_rocket_schematic));
        MorePlanetsRegistry.registerDungeonLoot(MPPlanets.diona, new ItemStack(PolongniusItems.tier_5_rocket_schematic));
        MorePlanetsRegistry.registerDungeonLoot(MPPlanets.polongnius, new ItemStack(NibiruItems.tier_6_rocket_schematic));
        MorePlanetsRegistry.registerDungeonLoot(MPPlanets.nibiru, new ItemStack(FronosItems.tier_7_rocket_schematic));
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        MPTileEntities.init();
        MorePlanetsCore.proxy.registerRenderer();
        CommonRegisterHelper.registerFuelHandler(new FurnaceFuelMP());

        CraftingManagerMP.init();
        DispenserRegistryMP.init();

        MorePlanetsRegistry.registerMessageHandler(MeteorServerHandler.class, MeteorServerMessage.class, 0, Side.SERVER);
        MorePlanetsRegistry.registerMessageHandler(MeteorClientHandler.class, MeteorClientMessage.class, 1, Side.CLIENT);

        if (ConfigManagerMP.enableMarsSpaceStation) { MorePlanetsRegistry.registerSpaceStation(MPPlanets.marsSpaceStation, MarsModule.planetMars, CraftingManagerMP.getMarsSpaceStationRecipe()); }
        if (ConfigManagerMP.enableJupiterSpaceStation) { MorePlanetsRegistry.registerSpaceStation(MPPlanets.jupiterSpaceStation, MPPlanets.jupiter, CraftingManagerMP.getJupiterSpaceStationRecipe()); }
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandHomePlanet());
    }

    @EventHandler
    public void serverStarted(FMLServerStartedEvent event)
    {
        new Thread(new ThreadVersionCheckMP()).start();
    }

    public static boolean isObfuscatedEnvironment()
    {
        try
        {
            Blocks.class.getField("air");
            return true;
        }
        catch (Throwable e) {}
        return false;
    }
}