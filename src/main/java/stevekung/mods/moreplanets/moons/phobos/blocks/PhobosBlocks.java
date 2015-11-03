/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.phobos.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.moons.phobos.itemblocks.ItemBlockPhobos;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class PhobosBlocks
{
	public static Block phobos_block;

	public static void init()
	{
		// Init
		PhobosBlocks.phobos_block = new BlockPhobos("phobos_block");

		// Register
		CommonRegisterHelper.registerBlock(PhobosBlocks.phobos_block, ItemBlockPhobos.class);

		// Set harvest level
		PhobosBlocks.phobos_block.setHarvestLevel("pickaxe", 0);

		// Register ore dictionary
		OreDictionary.registerOre("oreTin", new ItemStack(PhobosBlocks.phobos_block, 1, 4));
		OreDictionary.registerOre("oreCopper", new ItemStack(PhobosBlocks.phobos_block, 1, 5));
		OreDictionary.registerOre("oreIron", new ItemStack(PhobosBlocks.phobos_block, 1, 6));
		OreDictionary.registerOre("oreDesh", new ItemStack(PhobosBlocks.phobos_block, 1, 7));
	}
}