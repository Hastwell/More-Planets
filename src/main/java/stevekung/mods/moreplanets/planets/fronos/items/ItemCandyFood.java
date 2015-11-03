/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.items;

import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.items.ItemFoodMP;

public class ItemCandyFood extends ItemFoodMP
{
	private int[] foodHunger = new int[] {
			2,
			5,
			4
	};
	private float[] foodSaturation = new float[] {
			0.2F,
			0.6F,
			0.3F
	};

	public ItemCandyFood(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setHasSubtypes(true);
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
		return new String[] { "ovaltine_powder", "chocolate_bars", "caramel" };
	}
}