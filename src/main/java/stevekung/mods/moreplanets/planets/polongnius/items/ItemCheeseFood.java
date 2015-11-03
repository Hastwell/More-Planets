/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.items;

import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.items.ItemFoodMP;

public class ItemCheeseFood extends ItemFoodMP
{
	private int[] foodHunger = new int[] {
			3,
			3,
			8
	};
	private float[] foodSaturation = new float[] {
			0.35F,
			0.2F,
			0.8F
	};

	public ItemCheeseFood(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack)
	{
		if (itemStack.getItemDamage() == 0)
		{
			return 8;
		}
		return 32;
	}

	@Override
	public int getHealAmount(ItemStack itemStack)
	{
		return this.foodHunger[itemStack.getItemDamage()];
	}

	@Override
	public float getSaturationModifier(ItemStack itemStack)
	{
		return this.foodSaturation[itemStack.getItemDamage()];
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "cheese_of_milk_curd", "raw_cheese_beef", "cooked_cheese_beef", };
	}
}