package stevekung.mods.moreplanets.planets.fronos.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSlabMP;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockDoubleFronosSandstoneSlab;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosSandstoneSlab;

public class ItemBlockFronosSandstoneSlab extends ItemBlockSlabMP
{
	public ItemBlockFronosSandstoneSlab(Block block, BlockFronosSandstoneSlab singleSlab, BlockDoubleFronosSandstoneSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "fronos_sandstone", "white_sandstone", "cheese_sandstone" };
	}
}