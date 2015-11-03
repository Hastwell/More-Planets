package stevekung.mods.moreplanets.moons.europa.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMorePlanets;
import stevekung.mods.moreplanets.moons.europa.blocks.BlockEuropaLog;

public class ItemBlockEuropaLog extends ItemBlockMorePlanets
{
	public ItemBlockEuropaLog(Block block)
	{
		super(block);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta & 3;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return super.getUnlocalizedName() + "." + BlockEuropaLog.BlockType.byMetadata(itemStack.getMetadata()).getUnlocalizedName();
	}
}