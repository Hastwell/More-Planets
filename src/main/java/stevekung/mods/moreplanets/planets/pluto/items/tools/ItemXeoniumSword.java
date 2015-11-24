/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.items.tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricSwordMP;

public class ItemXeoniumSword extends ItemElectricSwordMP
{
	public ItemXeoniumSword(String name, ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName(name);
	}

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase living, EntityLivingBase holder)
	{
		if (this.getElectricityStored(itemStack) != 0.0F)
		{
			living.addPotionEffect(new PotionEffect(Potion.confusion.id, 200));
		}
		return super.hitEntity(itemStack, living, holder);
	}

	@Override
	public float getMaxElectricityStored(ItemStack itemStack)
	{
		return 20000.0F;
	}
}