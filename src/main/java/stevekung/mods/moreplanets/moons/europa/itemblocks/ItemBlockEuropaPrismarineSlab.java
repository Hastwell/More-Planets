package stevekung.mods.moreplanets.moons.europa.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSlabMP;
import stevekung.mods.moreplanets.moons.europa.blocks.BlockDoubleEuropaPrismarineSlab;
import stevekung.mods.moreplanets.moons.europa.blocks.BlockEuropaPrismarineSlab;

public class ItemBlockEuropaPrismarineSlab extends ItemBlockSlabMP
{
	public ItemBlockEuropaPrismarineSlab(Block block, BlockEuropaPrismarineSlab singleSlab, BlockDoubleEuropaPrismarineSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab);
		this.setHasSubtypes(true);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "europa_prismarine", "europa_prismarine_brick", "dark_europa_prismarine" };
	}
}