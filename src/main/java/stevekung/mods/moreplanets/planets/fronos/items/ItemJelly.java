/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.items.ItemFoodMP;

public class ItemJelly extends ItemFoodMP
{
	public ItemJelly(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setHasSubtypes(true);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.EAT;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemStack, World world, EntityPlayer player)
	{
		--itemStack.stackSize;
		world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(itemStack, world, player);
		player.getFoodStats().addStats(this, itemStack);
		return itemStack;
	}

	@Override
	public int getHealAmount(ItemStack itemStack)
	{
		return 4;
	}

	@Override
	public float getSaturationModifier(ItemStack itemStack)
	{
		return 0.35F;
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "grape_jelly", "raspberry_jelly", "strawberry_jelly", "berry_jelly", "lime_jelly", "orange_jelly", "green_jelly", "lemon_jelly" };
	}

	@Override
	protected boolean reverseName()
	{
		return true;
	}
}