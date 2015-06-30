/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.items;

import stevekung.mods.moreplanets.common.items.ItemBaseMP;

public class ItemLaserAmmo extends ItemBaseMP
{
	public ItemLaserAmmo(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "normal_laser_ammo", "hyper_laser_ammo", "emp_laser_ammo", "uranium_laser_ammo", "icy_poison_laser_ammo" };
	}

	@Override
	protected boolean reverseName()
	{
		return true;
	}
}