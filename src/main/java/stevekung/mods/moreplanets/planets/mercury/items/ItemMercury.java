/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.mercury.items;

import stevekung.mods.moreplanets.common.items.ItemBaseMP;

public class ItemMercury extends ItemBaseMP
{
	public ItemMercury(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "metallic_shard", "raw_metal_meteoric_iron", "metallic_ingot", "metal_meteoric_iron_ingot", "compressed_metallic", "compressed_metal_meteoric_iron", "gravity_core", "gravity_controller" };
	}
}