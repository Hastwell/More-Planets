/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.items.armor;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.items.armor.ItemBreathableArmor;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;

public class ArmorBreathableIceCrystal extends ItemBreathableArmor
{
	public ArmorBreathableIceCrystal(String name, ArmorMaterial material, int render, int type)
	{
		super(material, render, type);
		this.setUnlocalizedName(name);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == KapteynBArmorItems.breathable_ice_crystal_helmet)
		{
			return "moreplanets:textures/model/armor/breathable_ice_crystal.png";
		}
		return null;
	}

	@Override
	protected Item getRepairItems()
	{
		return KapteynBItems.kapteyn_b_item;
	}

	@Override
	protected int getRepairItemsMetadata()
	{
		return 5;
	}

	@Override
	protected EnumGearType getGearType()
	{
		return EnumGearType.HELMET;
	}

	@Override
	protected Item getBreathableArmor()
	{
		return KapteynBArmorItems.breathable_ice_crystal_helmet;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack itemStack)
	{
		if (!itemStack.isItemEnchanted())
		{
			if (itemStack.getItem() == this)
			{
				itemStack.addEnchantment(Enchantment.aquaAffinity, 1);
				itemStack.addEnchantment(Enchantment.respiration, 3);
			}
		}
		return true;
	}
}