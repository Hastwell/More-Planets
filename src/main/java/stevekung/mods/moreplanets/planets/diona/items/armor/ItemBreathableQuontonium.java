/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.items.armor.ItemBreathableArmor;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;

public class ItemBreathableQuontonium extends ItemBreathableArmor
{
	public ItemBreathableQuontonium(String name, ArmorMaterial material, int render, int type)
	{
		super(material, render, type);
		this.setUnlocalizedName(name);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		if (stack.getItem() == DionaArmorItems.breathable_quontonium_helmet)
		{
			return "moreplanets:textures/model/armor/breathable_quontonium_1.png";
		}
		return null;
	}

	@Override
	protected Item getRepairItems()
	{
		return DionaItems.diona_item;
	}

	@Override
	protected int getRepairItemsMetadata()
	{
		return 2;
	}

	@Override
	protected EnumGearType getGearType()
	{
		return EnumGearType.HELMET;
	}

	@Override
	protected Item getBreathableArmor()
	{
		return DionaArmorItems.breathable_quontonium_helmet;
	}
}