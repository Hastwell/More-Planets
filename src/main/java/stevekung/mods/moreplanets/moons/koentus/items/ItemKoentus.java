/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.items;

import stevekung.mods.moreplanets.common.items.ItemBaseMP;

public class ItemKoentus extends ItemBaseMP
{
	public ItemKoentus(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "white_crystal", "emp_shard", "becterial_fossil", "raw_koentus_meteoric_iron", "koentus_meteoric_iron_ingot", "compressed_white_crystal", "compressed_koentus_meteoric_iron" };
	}
}