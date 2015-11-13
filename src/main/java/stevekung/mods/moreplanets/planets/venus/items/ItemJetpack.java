/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.proxy.ClientProxyMP;

public class ItemJetpack extends ItemElectricArmorMP
{
	private int tick;
	private boolean keyDown;
	private boolean keySneak;

	public ItemJetpack(String name, ArmorMaterial material, int type, int render)
	{
		super(material, type, render);
		this.setUnlocalizedName(name);
	}

	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type)
	{
		if (itemStack.getItem() == this)
		{
			return "moreplanets:textures/model/jetpack.png";
		}
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase living, ItemStack itemStack, int slot)
	{
		ModelBiped armorModel = ClientProxyMP.jetpackModel.get(this);

		if (armorModel != null)
		{
			armorModel.bipedHead.showModel = slot == 0;

			if (living.isSneaking())
			{
				armorModel.isSneak = true;
			}
			else
			{
				armorModel.isSneak = false;
			}
		}
		return armorModel;
	}

	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean selected)
	{
		if (!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
		}
		itemStack.getTagCompound().setInteger("JetpackTick", this.tick);
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
		}
		itemStack.getTagCompound().setInteger("JetpackTick", this.tick);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		boolean flag = player.capabilities.isCreativeMode;

		if (itemStack.getItem() == this)
		{
			if (flag || player.inventory.hasItem(Items.coal))
			{
				if (this.getJetpackKeyDown() == true)
				{
					this.tick++;

					if (this.tick >= 1000)
					{
						if (!world.isRemote && !flag)
						{
							player.inventory.consumeInventoryItem(Items.coal);
						}
						if (this.tick >= 1001)
						{
							this.tick = 0;
						}
					}
				}
				if (this.getJetpackKeySneak() == true)
				{
					this.tick++;

					if (this.tick >= 1000)
					{
						if (!world.isRemote && !flag)
						{
							player.inventory.consumeInventoryItem(Items.coal);
						}
						if (this.tick >= 1001)
						{
							this.tick = 0;
						}
					}
				}
			}
			MorePlanetsCore.proxy.resetPlayerFloatingTick(player);
		}
	}

	@Override
	protected Item getRepairItems()
	{
		return null;
	}

	@Override
	protected int getRepairItemsMetadata()
	{
		return -1;
	}

	public void setJetpackKeyDown(boolean bool)
	{
		this.keyDown = bool;
	}

	private boolean getJetpackKeyDown()
	{
		return this.keyDown;
	}

	public void setJetpackKeySneak(boolean bool)
	{
		this.keySneak = bool;
	}

	private boolean getJetpackKeySneak()
	{
		return this.keySneak;
	}

	@Override
	public float getMaxElectricityStored(ItemStack itemStack)
	{
		return 100000.0F;
	}
}