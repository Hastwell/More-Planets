/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.items.armor;

import micdoodle8.mods.galacticraft.api.item.IBreathableArmor.EnumGearType;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.items.armor.ItemBreathableArmor;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;

public class ArmorBreathableNorium extends ItemBreathableArmor
{
	public ArmorBreathableNorium(String name, ArmorMaterial material, int render, int type)
	{
		super(material, render, type);
		this.setUnlocalizedName(name);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == NibiruArmorItems.breathable_norium_helmet)
		{
			return "moreplanets:textures/model/armor/breathable_norium_1.png";
		}
		return null;
	}

	@Override
	protected Item getRepairItems()
	{
		return NibiruItems.nibiru_item;
	}

	@Override
	protected int getRepairItemsMetadata()
	{
		return 3;
	}

	@Override
	protected EnumGearType getGearType()
	{
		return EnumGearType.HELMET;
	}

	@Override
	protected Item getBreathableArmor()
	{
		return NibiruArmorItems.breathable_norium_helmet;
	}
}