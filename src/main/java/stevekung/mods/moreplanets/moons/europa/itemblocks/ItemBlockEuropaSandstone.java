package stevekung.mods.moreplanets.moons.europa.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockBaseMP;

public class ItemBlockEuropaSandstone extends ItemBlockBaseMP
{
	public ItemBlockEuropaSandstone(Block block)
	{
		super(block);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "europa_sandstone", "chiseled_europa_sandstone", "smooth_europa_sandstone" };
	}
}