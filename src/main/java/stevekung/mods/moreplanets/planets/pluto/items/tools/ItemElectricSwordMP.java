/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.items.tools;

import java.util.List;

import micdoodle8.mods.galacticraft.api.item.ElectricItemHelper;
import micdoodle8.mods.galacticraft.api.item.IItemElectric;
import micdoodle8.mods.galacticraft.core.energy.EnergyConfigHandler;
import micdoodle8.mods.galacticraft.core.energy.EnergyDisplayHelper;
import micdoodle8.mods.galacticraft.core.items.ItemBatteryInfinite;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.miccore.Annotations.AltForVersion;
import micdoodle8.mods.miccore.Annotations.RuntimeInterface;
import micdoodle8.mods.miccore.Annotations.VersionSpecific;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;
import net.minecraftforge.fml.common.versioning.VersionParser;
import net.minecraftforge.fml.relauncher.FMLInjectionData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public abstract class ItemElectricSwordMP extends ItemSword implements IItemElectric
{
	//private static Object itemManagerIC2;
	public float transferMax;
	private DefaultArtifactVersion mcVersion = null;

	public ItemElectricSwordMP(ToolMaterial material)
	{
		super(material);
		this.setMaxDamage(100);
		this.setNoRepair();
		this.setMaxTransfer();

		this.mcVersion = new DefaultArtifactVersion((String) FMLInjectionData.data()[4]);

		if (EnergyConfigHandler.isIndustrialCraft2Loaded())
		{
			if (VersionParser.parseRange("[1.7.2]").containsVersion(this.mcVersion))
			{
				//itemManagerIC2 = new ElectricItemManagerIC2();
			}
			else
			{
				//itemManagerIC2 = new ElectricItemManagerIC2_1710();
			}
		}
	}

	protected void setMaxTransfer()
	{
		this.transferMax = 200;
	}

	@Override
	public float getStrVsBlock(ItemStack itemStack, Block block)
	{
		if (this.getElectricityStored(itemStack) == 0.0F)
		{
			return 0.0F;
		}
		return super.getStrVsBlock(itemStack, block);
	}

	@Override
	public float getDigSpeed(ItemStack itemStack, IBlockState state)
	{
		if (this.getElectricityStored(itemStack) == 0.0F)
		{
			return 0.5F;
		}
		return super.getDigSpeed(itemStack, state);
	}

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase living, EntityLivingBase holder)
	{
		if (this.getElectricityStored(itemStack) != 0.0F)
		{
			this.setElectricity(itemStack, this.getElectricityStored(itemStack) - 10.5F);
			return true;
		}
		return false;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, BlockPos pos, EntityLivingBase player)
	{
		if (block.getBlockHardness(world, pos) != 0.0D)
		{
			if (this.getElectricityStored(itemStack) != 0.0F)
			{
				this.setElectricity(itemStack, this.getElectricityStored(itemStack) - 10.0F);
			}
		}
		return true;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemStack)
	{
		if (this.getElectricityStored(itemStack) != 0.0F)
		{
			return EnumAction.BLOCK;
		}
		return EnumAction.NONE;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack)
	{
		if (this.getElectricityStored(itemStack) != 0.0F)
		{
			return 72000;
		}
		return 0;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (this.getElectricityStored(itemStack) != 0.0F)
		{
			player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
			return itemStack;
		}
		return itemStack;
	}

	@Override
	public Multimap getAttributeModifiers(ItemStack itemStack)
	{
		if (this.getElectricityStored(itemStack) != 0.0F)
		{
			return super.getAttributeModifiers(itemStack);
		}
		return HashMultimap.create();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
	{
		EnumChatFormatting color = null;
		float joules = this.getElectricityStored(itemStack);

		if (joules <= this.getMaxElectricityStored(itemStack) / 3)
		{
			color = EnumChatFormatting.DARK_RED;
		}
		else if (joules > this.getMaxElectricityStored(itemStack) * 2 / 3)
		{
			color = EnumChatFormatting.DARK_GREEN;
		}
		else
		{
			color = EnumChatFormatting.GOLD;
		}
		list.add(color + EnergyDisplayHelper.getEnergyDisplayS(joules) + "/" + EnergyDisplayHelper.getEnergyDisplayS(this.getMaxElectricityStored(itemStack)));
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
	{
		this.setElectricity(itemStack, 0);
	}

	@Override
	public float recharge(ItemStack itemStack, float energy, boolean doReceive)
	{
		float rejectedElectricity = Math.max(this.getElectricityStored(itemStack) + energy - this.getMaxElectricityStored(itemStack), 0);
		float energyToReceive = energy - rejectedElectricity;

		if (energyToReceive > this.transferMax)
		{
			rejectedElectricity += energyToReceive - this.transferMax;
			energyToReceive = this.transferMax;
		}
		if (doReceive)
		{
			this.setElectricity(itemStack, this.getElectricityStored(itemStack) + energyToReceive);
		}
		return energyToReceive;
	}

	@Override
	public float discharge(ItemStack itemStack, float energy, boolean doTransfer)
	{
		float energyToTransfer = Math.min(Math.min(this.getElectricityStored(itemStack), energy), this.transferMax);

		if (doTransfer)
		{
			this.setElectricity(itemStack, this.getElectricityStored(itemStack) - energyToTransfer);
		}
		return energyToTransfer;
	}

	@Override
	public int getTierGC(ItemStack itemStack)
	{
		return 1;
	}

	@Override
	public void setElectricity(ItemStack itemStack, float joules)
	{
		if (itemStack.getTagCompound() == null)
		{
			itemStack.setTagCompound(new NBTTagCompound());
		}
		float electricityStored = Math.max(Math.min(joules, this.getMaxElectricityStored(itemStack)), 0);
		itemStack.getTagCompound().setFloat("electricity", electricityStored);
		itemStack.setItemDamage((int) (100 - electricityStored / this.getMaxElectricityStored(itemStack) * 100));
	}

	@Override
	public float getTransfer(ItemStack itemStack)
	{
		return Math.min(this.transferMax, this.getMaxElectricityStored(itemStack) - this.getElectricityStored(itemStack));
	}

	@Override
	public float getElectricityStored(ItemStack itemStack)
	{
		if (itemStack.getTagCompound() == null)
		{
			itemStack.setTagCompound(new NBTTagCompound());
		}

		float energyStored = 0f;

		if (itemStack.getTagCompound().hasKey("electricity"))
		{
			NBTBase obj = itemStack.getTagCompound().getTag("electricity");

			if (obj instanceof NBTTagDouble)
			{
				energyStored = ((NBTTagDouble) obj).getFloat();
			}
			else if (obj instanceof NBTTagFloat)
			{
				energyStored = ((NBTTagFloat) obj).getFloat();
			}
		}
		itemStack.setItemDamage((int) (100 - energyStored / this.getMaxElectricityStored(itemStack) * 100));
		return energyStored;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
	{
		list.add(ElectricItemHelper.getUncharged(new ItemStack(this)));
		list.add(ElectricItemHelper.getWithCharge(new ItemStack(this), this.getMaxElectricityStored(new ItemStack(this))));
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return MorePlanetsCore.mpToolsTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack)
	{
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStack2)
	{
		return false;
	}

	@RuntimeInterface(clazz = "mekanism.api.energy.IEnergizedItem", modID = "Mekanism")
	public double getEnergy(ItemStack itemStack)
	{
		return this.getElectricityStored(itemStack) * EnergyConfigHandler.TO_MEKANISM_RATIO;
	}

	@RuntimeInterface(clazz = "mekanism.api.energy.IEnergizedItem", modID = "Mekanism")
	public void setEnergy(ItemStack itemStack, double amount)
	{
		this.setElectricity(itemStack, (float) amount * EnergyConfigHandler.MEKANISM_RATIO);
	}

	@RuntimeInterface(clazz = "mekanism.api.energy.IEnergizedItem", modID = "Mekanism")
	public double getMaxEnergy(ItemStack itemStack)
	{
		return this.getMaxElectricityStored(itemStack) * EnergyConfigHandler.TO_MEKANISM_RATIO;
	}

	@RuntimeInterface(clazz = "mekanism.api.energy.IEnergizedItem", modID = "Mekanism")
	public double getMaxTransfer(ItemStack itemStack)
	{
		return this.transferMax * EnergyConfigHandler.TO_MEKANISM_RATIO;
	}

	@RuntimeInterface(clazz = "mekanism.api.energy.IEnergizedItem", modID = "Mekanism")
	public boolean canReceive(ItemStack itemStack)
	{
		return itemStack != null && !(itemStack.getItem() instanceof ItemBatteryInfinite);
	}

	/*@RuntimeInterface(clazz = "ic2.api.item.ISpecialElectricItem", modID = "IC2")
	public IElectricItemManager getManager(ItemStack itemstack)
	{
		return (IElectricItemManager)itemManagerIC2;
	}*/

	@RuntimeInterface(clazz = "ic2.api.item.ISpecialElectricItem", modID = "IC2")
	public boolean canProvideEnergy(ItemStack itemStack)
	{
		return true;
	}

	@RuntimeInterface(clazz = "ic2.api.item.ISpecialElectricItem", modID = "IC2")
	public Item getChargedItem(ItemStack itemStack)
	{
		return itemStack.getItem();
	}

	@RuntimeInterface(clazz = "ic2.api.item.ISpecialElectricItem", modID = "IC2")
	public Item getEmptyItem(ItemStack itemStack)
	{
		return itemStack.getItem();
	}

	@RuntimeInterface(clazz = "ic2.api.item.ISpecialElectricItem", modID = "IC2")
	public int getTier(ItemStack itemStack)
	{
		return 1;
	}

	@VersionSpecific(version = "[1.7.10]")
	@RuntimeInterface(clazz = "ic2.api.item.ISpecialElectricItem", modID = "IC2")
	public double getMaxCharge(ItemStack itemStack)
	{
		return this.getMaxElectricityStored(itemStack) / EnergyConfigHandler.IC2_RATIO;
	}

	@AltForVersion(version = "[1.7.2]")
	@RuntimeInterface(clazz = "ic2.api.item.ISpecialElectricItem", modID = "IC2")
	public int getMaxChargeB(ItemStack itemStack)
	{
		return (int) (this.getMaxElectricityStored(itemStack) / EnergyConfigHandler.IC2_RATIO);
	}

	@VersionSpecific(version = "[1.7.10]")
	@RuntimeInterface(clazz = "ic2.api.item.ISpecialElectricItem", modID = "IC2")
	public double getTransferLimit(ItemStack itemStack)
	{
		return this.transferMax * EnergyConfigHandler.TO_IC2_RATIO;
	}

	@VersionSpecific(version = "[1.7.2]")
	@RuntimeInterface(clazz = "ic2.api.item.ISpecialElectricItem", modID = "IC2")
	public int getTransferLimitB(ItemStack itemStack)
	{
		return (int) (this.transferMax * EnergyConfigHandler.TO_IC2_RATIO);
	}
}