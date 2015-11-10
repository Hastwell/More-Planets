package stevekung.mods.moreplanets.common.blocks;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public class BlockFenceMP extends BlockFence
{
	public BlockFenceMP(String name)
	{
		super(Material.wood);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeWood);
		this.setUnlocalizedName(name);
	}

	public BlockFenceMP(Material material)
	{
		super(material);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return MorePlanetsCore.mpBlocksTab;
	}
}