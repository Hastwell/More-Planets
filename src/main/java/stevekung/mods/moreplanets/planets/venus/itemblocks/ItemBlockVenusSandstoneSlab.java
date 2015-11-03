package stevekung.mods.moreplanets.planets.venus.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSlabMP;
import stevekung.mods.moreplanets.planets.venus.blocks.BlockDoubleVenusSandstoneSlab;
import stevekung.mods.moreplanets.planets.venus.blocks.BlockVenusSandstoneSlab;

public class ItemBlockVenusSandstoneSlab extends ItemBlockSlabMP
{
	public ItemBlockVenusSandstoneSlab(Block block, BlockVenusSandstoneSlab singleSlab, BlockDoubleVenusSandstoneSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab);
		this.setHasSubtypes(false);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "venus_sandstone" };
	}
}