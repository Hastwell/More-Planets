/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.items;

import stevekung.mods.moreplanets.common.items.ItemBaseMP;

public class ItemNibiru extends ItemBaseMP
{
	public ItemNibiru(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "red_gem", "norium_ingot", "compressed_red_gem", "compressed_norium", "red_gem_stick", "norium_stick" };
	}
}