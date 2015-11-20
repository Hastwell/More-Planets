/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.deimos.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.moons.deimos.itemblocks.ItemBlockDeimos;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class DeimosBlocks
{
	public static Block deimos_block;

	public static void init()
	{
		// Init
		DeimosBlocks.deimos_block = new BlockDeimos("deimos_block");

		// Register
		CommonRegisterHelper.registerBlock(DeimosBlocks.deimos_block, ItemBlockDeimos.class);

		// Set harvest level
		CommonRegisterHelper.setBlockHarvestLevel(DeimosBlocks.deimos_block, "pickaxe", 0);

		// Register ore dictionary
		OreDictionary.registerOre("oreTin", new ItemStack(DeimosBlocks.deimos_block, 1, 4));
		OreDictionary.registerOre("oreCopper", new ItemStack(DeimosBlocks.deimos_block, 1, 5));
		OreDictionary.registerOre("oreIron", new ItemStack(DeimosBlocks.deimos_block, 1, 6));
		OreDictionary.registerOre("oreDesh", new ItemStack(DeimosBlocks.deimos_block, 1, 7));
	}
}