/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public class BlockStairsMP extends BlockStairs
{
	public BlockStairsMP(IBlockState material, String name, String sound, String type, float hardness)
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setHardness(hardness);

		if (sound == "wood")
		{
			this.setStepSound(soundTypeWood);
		}
		if (sound == "glass")
		{
			this.setStepSound(soundTypeGlass);
		}
		if (type == "sirius")
		{
			this.setLightLevel(1.0F);
		}
		this.useNeighborBrightness = true;
	}

	public BlockStairsMP(IBlockState material, String name, float hardness)
	{
		this(material, name, null, null, hardness);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return MorePlanetsCore.mpBlocksTab;
	}
}