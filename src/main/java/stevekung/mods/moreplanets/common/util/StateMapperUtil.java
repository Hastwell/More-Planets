/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.DarkAsteroidBlocks;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.stevecore.ClientRegisterHelper;
import stevekung.mods.stevecore.EnumStateMapper;

public class StateMapperUtil
{
    public static void registerStateMapper()
    {
        ClientRegisterHelper.registerStateMapper(DionaBlocks.fronisium_tnt, EnumStateMapper.TNT);
        ClientRegisterHelper.registerStateMapper(NibiruBlocks.ancient_dark_fence_gate, EnumStateMapper.FENCE_GATE);
        ClientRegisterHelper.registerStateMapper(NibiruBlocks.orange_fence_gate, EnumStateMapper.FENCE_GATE);
        ClientRegisterHelper.registerStateMapper(NibiruBlocks.nibiru_leaves, EnumStateMapper.LEAVES);
        ClientRegisterHelper.registerStateMapper(NibiruBlocks.ancient_dark_door_block, EnumStateMapper.DOOR);
        ClientRegisterHelper.registerStateMapper(NibiruBlocks.orange_door_block, EnumStateMapper.DOOR);
        ClientRegisterHelper.registerStateMapper(KoentusBlocks.crystal_fence_gate, EnumStateMapper.FENCE_GATE);
        ClientRegisterHelper.registerStateMapper(KoentusBlocks.crystal_leaves, EnumStateMapper.LEAVES);
        ClientRegisterHelper.registerStateMapper(KoentusBlocks.crystal_door_block, EnumStateMapper.DOOR);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.fronos_colorized_leaves, EnumStateMapper.LEAVES);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.fronos_leaves, EnumStateMapper.LEAVES);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.coconut_fence_gate, EnumStateMapper.FENCE_GATE);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.maple_fence_gate, EnumStateMapper.FENCE_GATE);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.fronos_coral, EnumStateMapper.LIQUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.coconut_door_block, EnumStateMapper.DOOR);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.maple_door_block, EnumStateMapper.DOOR);
        ClientRegisterHelper.registerStateMapper(KapteynBBlocks.uranium_bomb, EnumStateMapper.TNT);
        ClientRegisterHelper.registerStateMapper(SiriusBBlocks.sirius_fire, EnumStateMapper.FIRE);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.coconut_milk, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.mineral_water, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.ovaltine, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.caramel, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(FronosBlocks.tea, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(PolongniusBlocks.cheese_of_milk, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(KapteynBBlocks.frozen_water, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(SiriusBBlocks.sirius_lava, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(IoBlocks.io_lava, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(IoBlocks.black_io_lava, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(IoBlocks.red_liquid_sulfur, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(IoBlocks.yellow_liquid_sulfur, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(IoBlocks.orange_liquid_sulfur, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(IoBlocks.brown_liquid_sulfur, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(MercuryBlocks.dirty_water, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(PlutoBlocks.liquid_methane, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(PlutoBlocks.liquid_nitrogen, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(EuropaBlocks.europa_water, EnumStateMapper.FLUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(EuropaBlocks.europa_leaves, EnumStateMapper.LEAVES);
        ClientRegisterHelper.registerStateMapper(EuropaBlocks.europa_sapling, EnumStateMapper.LIQUID_LEVEL);
        ClientRegisterHelper.registerStateMapper(EuropaBlocks.europa_door_block, EnumStateMapper.DOOR);
        ClientRegisterHelper.registerStateMapper(EuropaBlocks.europa_fence_gate, EnumStateMapper.FENCE_GATE);
        ClientRegisterHelper.registerStateMapper(EuropaBlocks.europa_water_bomb, EnumStateMapper.TNT);
        ClientRegisterHelper.registerStateMapper(DarkAsteroidBlocks.alien_leaves, EnumStateMapper.LEAVES);
    }
}