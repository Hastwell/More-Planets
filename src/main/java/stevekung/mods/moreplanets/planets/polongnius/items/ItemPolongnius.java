/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.items;

import stevekung.mods.moreplanets.common.items.ItemBaseMP;

public class ItemPolongnius extends ItemBaseMP
{
	public ItemPolongnius(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "flonium", "purple_crystal", "raw_polongnius_meteoric_iron", "raw_palladium", "polongnius_meteoric_iron_ingot", "palladium_ingot", "compressed_polongnius_meteoric_iron", "compressed_palladium", "polongnius_meteoric_iron_stick", "palladium_stick", "cheese_leather", "cheese_spore" };
	}
}