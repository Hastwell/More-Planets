/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.items.ItemFoodMP;

public class ItemFronosFood extends ItemFoodMP
{
	private int[] foodHunger = new int[] {
			4,
			4,
			3,
			6,
			4,
			4,
			4,
			4,
			4,
			5,
			2,
			4,
			5,
			6,
			6,
			4
	};
	private float[] foodSaturation = new float[] {
			0.25F,
			0.25F,
			0.15F,
			0.35F,
			0.45F,
			0.45F,
			0.45F,
			0.45F,
			0.45F,
			0.5F,
			0.15F,
			0.45F,
			0.4F,
			0.6F,
			0.55F,
			0.45F,
	};

	public ItemFronosFood(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setHasSubtypes(true);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemStack, World world, EntityPlayer player)
	{
		super.onItemUseFinish(itemStack, world, player);
		int meta = itemStack.getItemDamage();

		if (meta >= 4 && meta <= 8 || meta >= 11 && meta <= 15)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(Items.bowl)))
			{
				player.dropPlayerItemWithRandomChoice(new ItemStack(Items.bowl), false);
			}
		}
		return itemStack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack)
	{
		if (itemStack.getItemDamage() == 10)
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
		return new String[] { "strawberry", "berry", "marshmallow", "cooked_marshmallow", "vanilla_ice_cream", "chocolate_ice_cream", "strawberry_ice_cream", "strawberry_cloud_ice_cream", "orange_ice_cream", "golden_bread", "little_sun_flower_seeds", "tea_ice_cream", "berry_salad", "sky_mushroom_stew", "rainbow_cloud_ice_cream", "lemon_ice_cream" };
	}
}