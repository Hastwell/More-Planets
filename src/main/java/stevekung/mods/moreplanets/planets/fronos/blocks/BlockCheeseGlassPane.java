/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCheeseGlassPane extends BlockPane
{
	public BlockCheeseGlassPane(String name)
	{
		super("fronos:cheese_glass", "fronos:cheese_glass_pane", Material.glass, false);
		this.setStepSound(Block.soundTypeGlass);
		this.setBlockName(name);
		this.setHardness(0.3F);
	}

	@Override
	public int getRenderType()
	{
		return 41;
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return MorePlanetsCore.mpBlocksTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}

	@Override
	public boolean canPaneConnectTo(IBlockAccess world, int x, int y, int z, ForgeDirection dir)
	{
		Block block = world.getBlock(x, y, z);
		return block == FronosBlocks.cheese_glass || block == MPBlocks.tinted_glass || super.canPaneConnectTo(world, x, y, z, dir);
	}
}