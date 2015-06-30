/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.items;

import stevekung.mods.moreplanets.common.items.IPowerCrystal;
import stevekung.mods.moreplanets.common.items.ItemBaseMP;

public class ItemPluto extends ItemBaseMP implements IPowerCrystal
{
	public ItemPluto(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "xeonium_gem" };
	}

	@Override
	public boolean isPowerCrystal(int meta)
	{
		return true;
	}

	@Override
	public int getPowerCrystalBurnTime(int meta)
	{
		return 3600;
	}
}