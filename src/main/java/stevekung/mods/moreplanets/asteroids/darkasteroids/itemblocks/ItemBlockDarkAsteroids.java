package stevekung.mods.moreplanets.asteroids.darkasteroids.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.core.itemblocks.ItemBlockBaseMP;

public class ItemBlockDarkAsteroids extends ItemBlockBaseMP
{
	public ItemBlockDarkAsteroids(Block block)
	{
		super(block);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "surface_rock", "sub_surface_rock", "rock", "cobblestone", "tin_ore", "copper_ore", "iron_ore", "desh_ore" };
	}
}