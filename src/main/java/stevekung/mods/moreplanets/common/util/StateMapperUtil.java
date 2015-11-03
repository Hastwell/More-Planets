/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap.Builder;
import stevekung.mods.moreplanets.common.blocks.BlockLeavesMP;
import stevekung.mods.moreplanets.moons.europa.blocks.BlockEuropaWaterBomb;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.planets.diona.blocks.BlockFronisiumTNT;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.BlockUraniumBomb;
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
		ClientRegisterHelper.registerBlockWithStateMapper(DionaBlocks.fronisium_tnt, new Builder().addPropertiesToIgnore(new IProperty[] {BlockFronisiumTNT.EXPLODE}).build());
		ClientRegisterHelper.registerBlockWithStateMapper(NibiruBlocks.ancient_dark_fence_gate, EnumStateMapper.FENCE_GATE);
		ClientRegisterHelper.registerBlockWithStateMapper(NibiruBlocks.orange_fence_gate, EnumStateMapper.FENCE_GATE);
		ClientRegisterHelper.registerBlockWithStateMapper(NibiruBlocks.ancient_dark_leaves, new Builder().addPropertiesToIgnore(new IProperty[] {BlockLeavesMP.CHECK_DECAY, BlockLeavesMP.DECAYABLE}).build());
		ClientRegisterHelper.registerBlockWithStateMapper(NibiruBlocks.orange_leaves, new Builder().addPropertiesToIgnore(new IProperty[] {BlockLeavesMP.CHECK_DECAY, BlockLeavesMP.DECAYABLE}).build());
		ClientRegisterHelper.registerBlockWithStateMapper(NibiruBlocks.ancient_dark_door, EnumStateMapper.DOOR);
		ClientRegisterHelper.registerBlockWithStateMapper(NibiruBlocks.orange_door, EnumStateMapper.DOOR);
		ClientRegisterHelper.registerBlockWithStateMapper(KoentusBlocks.crystal_fence_gate, EnumStateMapper.FENCE_GATE);
		ClientRegisterHelper.registerBlockWithStateMapper(KoentusBlocks.crystal_leaves, new Builder().addPropertiesToIgnore(new IProperty[] {BlockLeavesMP.CHECK_DECAY, BlockLeavesMP.DECAYABLE}).build());
		ClientRegisterHelper.registerBlockWithStateMapper(KoentusBlocks.crystal_door_block, EnumStateMapper.DOOR);
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.fronos_colorized_leaves, new Builder().addPropertiesToIgnore(new IProperty[] {BlockLeavesMP.CHECK_DECAY, BlockLeavesMP.DECAYABLE}).build());
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.fronos_leaves, new Builder().addPropertiesToIgnore(new IProperty[] {BlockLeavesMP.CHECK_DECAY, BlockLeavesMP.DECAYABLE}).build());
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.coconut_fence_gate, EnumStateMapper.FENCE_GATE);
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.maple_fence_gate, EnumStateMapper.FENCE_GATE);
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.fronos_coral, EnumStateMapper.LIQUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.coconut_door_block, EnumStateMapper.DOOR);
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.maple_door_block, EnumStateMapper.DOOR);
		ClientRegisterHelper.registerBlockWithStateMapper(KapteynBBlocks.uranium_bomb, new Builder().addPropertiesToIgnore(new IProperty[] {BlockUraniumBomb.EXPLODE}).build());
		ClientRegisterHelper.registerBlockWithStateMapper(SiriusBBlocks.sirius_fire, EnumStateMapper.FIRE);
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.coconut_milk, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.mineral_water, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.ovaltine, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.caramel, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(FronosBlocks.tea, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(PolongniusBlocks.cheese_of_milk, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(KapteynBBlocks.frozen_water, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(SiriusBBlocks.sirius_lava, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(IoBlocks.io_lava, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(IoBlocks.black_io_lava, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(IoBlocks.red_liquid_sulfur, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(IoBlocks.yellow_liquid_sulfur, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(IoBlocks.orange_liquid_sulfur, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(IoBlocks.brown_liquid_sulfur, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(MercuryBlocks.dirty_water, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(PlutoBlocks.liquid_methane, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(PlutoBlocks.liquid_nitrogen, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(EuropaBlocks.europa_water, EnumStateMapper.FLUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(EuropaBlocks.europa_leaves, new Builder().addPropertiesToIgnore(new IProperty[] {BlockLeavesMP.CHECK_DECAY, BlockLeavesMP.DECAYABLE}).build());
		ClientRegisterHelper.registerBlockWithStateMapper(EuropaBlocks.europa_sapling, EnumStateMapper.LIQUID_LEVEL);
		ClientRegisterHelper.registerBlockWithStateMapper(EuropaBlocks.europa_door_block, EnumStateMapper.DOOR);
		ClientRegisterHelper.registerBlockWithStateMapper(EuropaBlocks.europa_fence_gate, EnumStateMapper.FENCE_GATE);
		ClientRegisterHelper.registerBlockWithStateMapper(EuropaBlocks.europa_water_bomb, new Builder().addPropertiesToIgnore(new IProperty[] {BlockEuropaWaterBomb.EXPLODE}).build());
	}
}