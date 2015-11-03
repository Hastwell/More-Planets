package stevekung.mods.moreplanets.moons.europa.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSlabMP;
import stevekung.mods.moreplanets.moons.europa.blocks.BlockDoubleEuropaSandstoneSlab;
import stevekung.mods.moreplanets.moons.europa.blocks.BlockEuropaSandstoneSlab;

public class ItemBlockEuropaSandstoneSlab extends ItemBlockSlabMP
{
	public ItemBlockEuropaSandstoneSlab(Block block, BlockEuropaSandstoneSlab singleSlab, BlockDoubleEuropaSandstoneSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab);
		this.setHasSubtypes(false);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "europa_sandstone" };
	}
}