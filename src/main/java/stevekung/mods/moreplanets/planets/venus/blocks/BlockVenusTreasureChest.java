/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.core.blocks.BlockTreasureChestMP;
import stevekung.mods.moreplanets.core.tileentities.TileEntityTreasureChestMP;
import stevekung.mods.moreplanets.planets.venus.tileentities.TileEntityVenusTreasureChest;

@Deprecated //Removed in 1.8
public class BlockVenusTreasureChest extends BlockTreasureChestMP
{
	public BlockVenusTreasureChest(String name)
	{
		super();
		this.setBlockName(name);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return null;
	}

	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
	{
		TileEntityVenusTreasureChest var7 = (TileEntityVenusTreasureChest) par1World.getTileEntity(par2, par3, par4);

		if (var7 != null)
		{
			for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
			{
				ItemStack var9 = var7.getStackInSlot(var8);

				if (var9 != null)
				{
					float var10 = this.random.nextFloat() * 0.8F + 0.1F;
					float var11 = this.random.nextFloat() * 0.8F + 0.1F;
					EntityItem var14;

					for (float var12 = this.random.nextFloat() * 0.8F + 0.1F; var9.stackSize > 0; par1World.spawnEntityInWorld(var14))
					{
						int var13 = this.random.nextInt(21) + 10;

						if (var13 > var9.stackSize)
						{
							var13 = var9.stackSize;
						}

						var9.stackSize -= var13;
						var14 = new EntityItem(par1World, par2 + var10, par3 + var11, par4 + var12, new ItemStack(var9.getItem(), var13, var9.getItemDamage()));
						float var15 = 0.05F;
						var14.motionX = (float) this.random.nextGaussian() * var15;
						var14.motionY = (float) this.random.nextGaussian() * var15 + 0.2F;
						var14.motionZ = (float) this.random.nextGaussian() * var15;

						if (var9.hasTagCompound())
						{
							var14.getEntityItem().setTagCompound((NBTTagCompound) var9.getTagCompound().copy());
						}
					}
				}
			}
		}
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	@Override
	public String getTextureLocation()
	{
		return "venus:venus_treasure_chest";
	}

	@Override
	public TileEntityTreasureChestMP getTreasureChest()
	{
		return new TileEntityVenusTreasureChest();
	}
}