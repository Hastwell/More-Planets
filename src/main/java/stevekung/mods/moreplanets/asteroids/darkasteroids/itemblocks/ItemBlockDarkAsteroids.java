/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockBaseMP;

public class ItemBlockDarkAsteroids extends ItemBlockBaseMP
{
	public ItemBlockDarkAsteroids(Block block)
	{
		super(block);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "rock", "rock", "rock", "aluminum_ore", "ilmenite_ore", "iron_ore", "meteoric_iron_ore", "silicon_ore", "diamond_ore", "emerald_ore", "lapis_ore" };
	}
}