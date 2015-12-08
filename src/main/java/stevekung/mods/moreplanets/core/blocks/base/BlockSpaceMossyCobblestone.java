/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.blocks.base;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSpaceMossyCobblestone extends BlockBaseMP
{
	private IIcon[] mossyBlockIcon;

	public BlockSpaceMossyCobblestone(String name)
	{
		super(Material.rock);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
		this.setBlockName(name);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.mossyBlockIcon = new IIcon[16];
		this.mossyBlockIcon[0] = par1IconRegister.registerIcon("mpcore:diona_mossy_cobblestone");
		this.mossyBlockIcon[1] = par1IconRegister.registerIcon("mpcore:polongnius_mossy_cobblestone");
		this.mossyBlockIcon[2] = par1IconRegister.registerIcon("mpcore:nibiru_mossy_cobblestone");
		this.mossyBlockIcon[3] = par1IconRegister.registerIcon("mpcore:koentus_mossy_cobblestone");
		this.mossyBlockIcon[4] = par1IconRegister.registerIcon("mpcore:kapteynb_mossy_cobblestone");
		this.mossyBlockIcon[5] = par1IconRegister.registerIcon("mpcore:siriusb_mossy_cobblestone");
		this.mossyBlockIcon[6] = par1IconRegister.registerIcon("mpcore:diona_mossy_cobblestone");
		this.mossyBlockIcon[7] = par1IconRegister.registerIcon("mpcore:diona_mossy_cobblestone");
		this.mossyBlockIcon[8] = par1IconRegister.registerIcon("mpcore:diona_mossy_cobblestone");
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.mossyBlockIcon[meta];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < 10; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
}