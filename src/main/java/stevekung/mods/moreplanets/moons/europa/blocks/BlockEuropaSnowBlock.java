package stevekung.mods.moreplanets.moons.europa.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.core.blocks.base.BlockBaseMP;

public class BlockEuropaSnowBlock extends BlockBaseMP
{
	public BlockEuropaSnowBlock(String name)
	{
		super(Material.craftedSnow);
		this.setTickRandomly(true);
		this.setBlockName(name);
		this.setHardness(0.2F);
		this.setStepSound(soundTypeSnow);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return Items.snowball;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 4;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (world.getSavedLightValue(EnumSkyBlock.Block, x, y, z) > 11)
		{
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
		}
	}
}