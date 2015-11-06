package stevekung.mods.moreplanets.common.items;

import java.util.List;

import micdoodle8.mods.galacticraft.api.item.IItemThermal;
import micdoodle8.mods.galacticraft.planets.asteroids.items.ItemThermalPadding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public class ItemTier3ThermalPadding extends ItemBaseMP implements IItemThermal
{
	public ItemTier3ThermalPadding(String name)
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
		return new String[] { "thermal_helm", "thermal_chestplate", "thermal_leggings", "thermal_boots" };
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
			list.add(StatCollector.translateToLocal("item.tier3.desc"));
			list.add("Ability : Immune to Infected Gas and Icy Poison");
		}
	}

	@Override
	public int getThermalStrength()
	{
		return 6;
	}

	@Override
	public boolean isValidForSlot(ItemStack itemStack, int armorSlot)
	{
		return itemStack.getItemDamage() == armorSlot;
	}
}