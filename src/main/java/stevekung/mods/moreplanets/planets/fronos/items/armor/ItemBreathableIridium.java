/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.items.armor.ItemBreathableArmor;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;

public class ItemBreathableIridium extends ItemBreathableArmor
{
	public ItemBreathableIridium(String name, ArmorMaterial material, int render, int type)
	{
		super(material, render, type);
		this.setUnlocalizedName(name);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == FronosArmorItems.breathable_iridium_helmet)
		{
			return "moreplanets:textures/model/armor/breathable_iridium.png";
		}
		return null;
	}

	@Override
	protected Item getRepairItems()
	{
		return FronosItems.fronos_item;
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
		return FronosArmorItems.breathable_iridium_helmet;
	}
}