package stevekung.mods.moreplanets.core.items;

import java.util.List;

import micdoodle8.mods.galacticraft.api.item.IItemThermal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTier2ThermalPadding extends ItemMorePlanet implements IItemThermal
{
	public static String[] names = { "thermalHelm", "thermalChestplate", "thermalLeggings", "thermalBoots", "thermalHelm0", "thermalChestplate0", "thermalLeggings0", "thermalBoots0" };
	protected IIcon[] icons = new IIcon[ItemTier2ThermalPadding.names.length];

	public ItemTier2ThermalPadding(String name)
	{
		super();
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		if (this.icons.length > meta)
		{
			return this.icons[meta];
		}
		return super.getIconFromDamage(meta);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int damage, int pass)
	{
		if (pass == 1)
		{
			if (this.icons.length > damage + 4)
			{
				return this.icons[damage + 4];
			}
		}
		return this.getIconFromDamage(damage);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		int i = 0;

		for (String name : ItemTier2ThermalPadding.names)
		{
			this.icons[i++] = iconRegister.registerIcon("mpcore:" + name);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < 4; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		if (this.icons.length > par1ItemStack.getItemDamage())
		{
			return this.getUnlocalizedName() + "." + names[par1ItemStack.getItemDamage()];
		}
		return "unnamed";
	}

	@Override
	public int getThermalStrength()
	{
		return 2;
	}

	@Override
	public boolean isValidForSlot(ItemStack stack, int armorSlot)
	{
		return stack.getItemDamage() == armorSlot;
	}
}