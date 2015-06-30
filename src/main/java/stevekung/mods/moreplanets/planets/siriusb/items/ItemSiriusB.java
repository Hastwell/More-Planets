/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.items;

import stevekung.mods.moreplanets.common.items.ItemBaseMP;

public class ItemSiriusB extends ItemBaseMP
{
	public ItemSiriusB(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "small_diamond_pieces", "large_diamond_pieces", "sulfur_dust", "sulfur_ingot", "compressed_sulfur", "sulfur_stick" };
	}
}