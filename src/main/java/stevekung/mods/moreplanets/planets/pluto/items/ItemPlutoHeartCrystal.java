/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;

public class ItemPlutoHeartCrystal extends ItemMorePlanets
{
	public ItemPlutoHeartCrystal(String name)
	{
		super();
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
		this.setMaxDamage(5);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (!(player.getAbsorptionAmount() >= 1.0F))
		{
			player.setAbsorptionAmount(80.0F);
			itemStack.damageItem(1, player);
		}
		return itemStack;
	}
}