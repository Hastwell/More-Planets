/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.items.ItemBaseMP;
import stevekung.mods.moreplanets.planets.fronos.entities.projectiles.EntityCreamBall;

public class ItemCreamBall extends ItemBaseMP
{
	public ItemCreamBall(String name)
	{
		super();
		this.setMaxStackSize(16);
		this.setUnlocalizedName(name);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (!player.capabilities.isCreativeMode)
		{
			--itemStack.stackSize;
		}
		if (!world.isRemote)
		{
			world.spawnEntityInWorld(new EntityCreamBall(world, player, itemStack.getItemDamage()));
		}
		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
		return itemStack;
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "vanilla_cream_ball", "chocolate_cream_ball", "strawberry_cream_ball", "orange_cream_ball", "tea_cream_ball", "lemon_cream_ball" };
	}
}