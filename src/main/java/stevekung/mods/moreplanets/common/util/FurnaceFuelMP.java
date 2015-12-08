/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.DarkAsteroidBlocks;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.europa.items.EuropaItems;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.moons.koentus.items.KoentusItems;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;

public class FurnaceFuelMP implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		Item item = itemStack.getItem();

		if (item == this.getBlock(NibiruBlocks.nibiru_sapling) || item == this.getBlock(KoentusBlocks.crystal_sapling) || item == this.getBlock(FronosBlocks.fronos_sapling) || item == this.getBlock(EuropaBlocks.europa_sapling) || item == this.getBlock(DarkAsteroidBlocks.alien_sapling))
		{
			return 100;
		}
		if (item == NibiruItems.ancient_dark_door || item == NibiruItems.orange_door || item == KoentusItems.crystal_door || item == FronosItems.coconut_door || item == FronosItems.maple_door || item == EuropaItems.europa_door)
		{
			return 150;
		}
		return 0;
	}

	private Item getBlock(Block block)
	{
		return Item.getItemFromBlock(block);
	}
}