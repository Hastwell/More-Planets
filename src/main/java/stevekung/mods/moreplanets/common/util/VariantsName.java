/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

public class VariantsName
{
	private String[] name;
	private ItemDescription desc;
	private boolean reverse;

	public VariantsName(String... name)
	{
		this.name = name;
	}

	public VariantsName(boolean reverseName, String... name)
	{
		this.name = name;
		this.reverse = reverseName;
	}

	public VariantsName(ItemDescription desc, String... name)
	{
		this.name = name;
		this.desc = desc;
	}

	public VariantsName(ItemDescription desc)
	{
		this.desc = desc;
	}

	public String[] getStringList()
	{
		return this.name;
	}

	public ItemDescription getItemDescription()
	{
		return this.desc;
	}

	public boolean isReverseName()
	{
		return this.reverse;
	}
}