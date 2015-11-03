/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;

public class FurnaceFuelMP implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		Item item = itemStack.getItem();

		if (item == Item.getItemFromBlock(NibiruBlocks.nibiru_sapling) || item == Item.getItemFromBlock(KoentusBlocks.crystal_sapling) || item == Item.getItemFromBlock(FronosBlocks.fronos_sapling) || item == Item.getItemFromBlock(EuropaBlocks.europa_sapling))
		{
			return 100;
		}
		return 0;
	}
}