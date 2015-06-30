/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.items;

import stevekung.mods.moreplanets.common.items.ItemBaseMP;

public class ItemPurpleCrystalSolarModule extends ItemBaseMP
{
	public ItemPurpleCrystalSolarModule(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "purple_crystal_wafer", "purple_crystal_solar_wafer", "purple_crystal_solar_single", "purple_crystal_solar_panel" };
	}
}