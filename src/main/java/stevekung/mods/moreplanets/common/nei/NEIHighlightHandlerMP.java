/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.nei;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.DarkAsteroidsBlocks;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.moons.deimos.blocks.DeimosBlocks;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.moons.koentus.items.KoentusItems;
import stevekung.mods.moreplanets.moons.phobos.blocks.PhobosBlocks;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;
import codechicken.nei.api.IHighlightHandler;
import codechicken.nei.api.ItemInfo.Layout;

public class NEIHighlightHandlerMP implements IHighlightHandler
{
	@Override
	public List<String> handleTextData(ItemStack stack, World world, EntityPlayer player, MovingObjectPosition moving, List<String> currenttip, Layout layout)
	{
		return currenttip;
	}

	@Override
	public ItemStack identifyHighlight(World world, EntityPlayer player, MovingObjectPosition moving)
	{
		Block block = world.getBlockState(moving.getBlockPos()).getBlock();
		int meta = block.getMetaFromState(world.getBlockState(moving.getBlockPos()));

		if (block == MPBlocks.double_stone_slab_1)
		{
			return new ItemStack(MPBlocks.half_stone_slab_1, 1, meta);
		}
		if (block == MPBlocks.double_stone_slab_2)
		{
			return new ItemStack(MPBlocks.half_stone_slab_2, 1, meta);
		}
		if (block == MPBlocks.double_wooden_slab_1)
		{
			return new ItemStack(MPBlocks.half_wooden_slab_1, 1, meta);
		}
		if (block == MPBlocks.double_dungeon_brick_slab_1)
		{
			return new ItemStack(MPBlocks.half_dungeon_brick_slab_1, 1, meta);
		}
		if (block == DionaBlocks.diona_block)
		{
			return new ItemStack(DionaBlocks.diona_block, 1, meta);
		}
		if (block == PolongniusBlocks.polongnius_block)
		{
			return new ItemStack(PolongniusBlocks.polongnius_block, 1, meta);
		}
		if (block == NibiruBlocks.nibiru_block)
		{
			return new ItemStack(NibiruBlocks.nibiru_block, 1, meta);
		}
		if (block == NibiruBlocks.ancient_dark_leaves)
		{
			return new ItemStack(NibiruBlocks.ancient_dark_leaves, 1, meta & 3);
		}
		if (block == NibiruBlocks.orange_leaves)
		{
			return new ItemStack(NibiruBlocks.orange_leaves, 1, meta & 3);
		}
		if (block == KoentusBlocks.koentus_block)
		{
			return new ItemStack(KoentusBlocks.koentus_block, 1, meta);
		}
		if (block == KoentusBlocks.koentus_ice)
		{
			return new ItemStack(KoentusBlocks.koentus_ice, 1, meta);
		}
		if (block == FronosBlocks.fronos_block)
		{
			return new ItemStack(FronosBlocks.fronos_block, 1, meta);
		}
		if (block == FronosBlocks.frosted_cake)
		{
			return new ItemStack(FronosBlocks.frosted_cake, 1, meta);
		}
		if (block == FronosBlocks.fronos_leaves)
		{
			return new ItemStack(FronosBlocks.fronos_leaves, 1, meta & 3);
		}
		if (block == FronosBlocks.fronos_tall_grass)
		{
			return new ItemStack(FronosBlocks.fronos_tall_grass, 1, meta);
		}
		if (block == FronosBlocks.golden_crops)
		{
			return new ItemStack(FronosItems.golden_seeds);
		}
		if (block == KapteynBBlocks.kapteyn_b_block)
		{
			return new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, meta);
		}
		if (block == KapteynBBlocks.kapteyn_b_ice)
		{
			return new ItemStack(KapteynBBlocks.kapteyn_b_ice, 1, meta);
		}
		if (block == KapteynBBlocks.uranium_waste)
		{
			return new ItemStack(KapteynBBlocks.uranium_waste, 1, meta);
		}
		if (block == KapteynBBlocks.icy_poison_crystal)
		{
			return new ItemStack(KapteynBBlocks.icy_poison_crystal);
		}
		if (block == SiriusBBlocks.sirius_b_block)
		{
			return new ItemStack(SiriusBBlocks.sirius_b_block, 1, meta);
		}
		if (block == MercuryBlocks.mercury_block)
		{
			return new ItemStack(MercuryBlocks.mercury_block, 1, meta);
		}
		if (block == VenusBlocks.venus_block)
		{
			return new ItemStack(VenusBlocks.venus_block, 1, meta);
		}
		if (block == PlutoBlocks.pluto_block)
		{
			return new ItemStack(PlutoBlocks.pluto_block, 1, meta);
		}
		if (block == EuropaBlocks.europa_sea_lantern)
		{
			return new ItemStack(EuropaBlocks.europa_sea_lantern);
		}
		if (block == FronosBlocks.fronos_sandstone)
		{
			return new ItemStack(FronosBlocks.fronos_sandstone, 1, meta);
		}
		if (block == PolongniusBlocks.ultra_violet_solar_fake)
		{
			return new ItemStack(PolongniusBlocks.ultra_violet_solar_panel);
		}
		if (block == DeimosBlocks.deimos_block)
		{
			return new ItemStack(DeimosBlocks.deimos_block, 1, meta);
		}
		if (block == FronosBlocks.fronos_farmland)
		{
			return new ItemStack(FronosBlocks.fronos_dirt);
		}
		if (block == KapteynBBlocks.fallen_ice_crystal_meteor)
		{
			return new ItemStack(KapteynBBlocks.fallen_ice_crystal_meteor);
		}
		if (block == PhobosBlocks.phobos_block)
		{
			return new ItemStack(PhobosBlocks.phobos_block, 1, meta);
		}
		if (block == IoBlocks.io_block)
		{
			return new ItemStack(IoBlocks.io_block, 1, meta);
		}
		if (block == NibiruBlocks.infected_farmland)
		{
			return new ItemStack(NibiruBlocks.infected_dirt);
		}
		if (block == KoentusBlocks.crystal_farmland)
		{
			return new ItemStack(KoentusBlocks.crystal_dirt);
		}
		if (block == NibiruBlocks.ancient_dark_door)
		{
			return new ItemStack(NibiruItems.ancient_dark_door);
		}
		if (block == NibiruBlocks.orange_door)
		{
			return new ItemStack(NibiruItems.orange_door);
		}
		if (block == FronosBlocks.coconut_door_block)
		{
			return new ItemStack(FronosItems.coconut_door);
		}
		if (block == FronosBlocks.maple_door_block)
		{
			return new ItemStack(FronosItems.maple_door);
		}
		if (block == KoentusBlocks.crystal_door_block)
		{
			return new ItemStack(KoentusItems.crystal_door);
		}
		if (block == DarkAsteroidsBlocks.dark_asteroid_rock)
		{
			return new ItemStack(DarkAsteroidsBlocks.dark_asteroid_rock, 1, meta);
		}
		if (block == KoentusBlocks.crystal_cocoa)
		{
			return new ItemStack(KoentusItems.crystal_cocoa);
		}
		return null;
	}
}