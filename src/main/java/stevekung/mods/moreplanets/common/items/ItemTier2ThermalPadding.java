/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.items;

import java.util.List;

import micdoodle8.mods.galacticraft.api.item.IItemThermal;
import micdoodle8.mods.galacticraft.planets.asteroids.items.ItemThermalPadding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;

public class ItemTier2ThermalPadding extends ItemBaseMP implements IItemThermal
{
	public ItemTier2ThermalPadding(String name)
	{
		super();
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return MorePlanetsCore.mpArmorTab;
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "tier_2_thermal_helmet", "tier_2_thermal_chestplate", "tier_2_thermal_leggings", "tier_2_thermal_boots" };
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack)
	{
		return StatCollector.translateToLocal("item." + ItemThermalPadding.names[itemStack.getItemDamage()] + ".name");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
	{
		if (player.worldObj.isRemote)
		{
			list.add(StatCollector.translateToLocal("item.tier2.desc"));
			list.add("Ability : Immune to Infected Gas");
		}
	}

	@Override
	public int getThermalStrength()
	{
		return 3;
	}

	@Override
	public boolean isValidForSlot(ItemStack itemStack, int armorSlot)
	{
		return itemStack.getItemDamage() == armorSlot;
	}

	@Override
	public boolean onEntityItemUpdate(EntityItem item)
	{
		World world = item.worldObj;
		List<EntityItem> item1 = world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.fromBounds(item.posX, item.posY, item.posZ, item.posX + 1, item.posY + 1, item.posZ + 1));
		int meta = item.getEntityItem().getItemDamage();

		if (item.worldObj.getBlockState(new BlockPos((int)Math.floor(item.posX), (int)Math.floor(item.posY), (int)Math.floor(item.posZ))) == KapteynBBlocks.frozen_water.getDefaultState())
		{
			if (meta == 0)
			{
				if (item1.get(0).getEntityItem().getItem() == KapteynBItems.kapteyn_b_item && item1.get(0).getEntityItem().getItemDamage() == 5 && item1.get(0).getEntityItem().stackSize >= 16)
				{
					item.setEntityItemStack(new ItemStack(MPItems.tier_3_thermal_padding, 1, 0));
					item1.get(0).setEntityItemStack(new ItemStack(KapteynBItems.kapteyn_b_item, item1.get(0).getEntityItem().stackSize - 16, 5));
				}
			}
			if (meta == 1)
			{
				if (item1.get(0).getEntityItem().getItem() == KapteynBItems.kapteyn_b_item && item1.get(0).getEntityItem().getItemDamage() == 5 && item1.get(0).getEntityItem().stackSize >= 20)
				{
					item.setEntityItemStack(new ItemStack(MPItems.tier_3_thermal_padding, 1, 1));
					item1.get(0).setEntityItemStack(new ItemStack(KapteynBItems.kapteyn_b_item, item1.get(0).getEntityItem().stackSize - 20, 5));
				}
			}
			if (meta == 2)
			{
				if (item1.get(0).getEntityItem().getItem() == KapteynBItems.kapteyn_b_item && item1.get(0).getEntityItem().getItemDamage() == 5 && item1.get(0).getEntityItem().stackSize >= 18)
				{
					item.setEntityItemStack(new ItemStack(MPItems.tier_3_thermal_padding, 1, 2));
					item1.get(0).setEntityItemStack(new ItemStack(KapteynBItems.kapteyn_b_item, item1.get(0).getEntityItem().stackSize - 18, 5));
				}
			}
			if (meta == 3)
			{
				if (item1.get(0).getEntityItem().getItem() == KapteynBItems.kapteyn_b_item && item1.get(0).getEntityItem().getItemDamage() == 5 && item1.get(0).getEntityItem().stackSize >= 12)
				{
					item.setEntityItemStack(new ItemStack(MPItems.tier_3_thermal_padding, 1, 3));
					item1.get(0).setEntityItemStack(new ItemStack(KapteynBItems.kapteyn_b_item, item1.get(0).getEntityItem().stackSize - 12, 5));
				}
			}
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int layer)
	{
		return layer == 0 ? super.getColorFromItemStack(itemStack, layer) : 0;//TODO
	}
}