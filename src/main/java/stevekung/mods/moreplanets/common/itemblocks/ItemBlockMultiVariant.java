/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.util.VariantsName;

public class ItemBlockMultiVariant extends ItemBlockBaseMP
{
	private String[] name;
	private boolean reverse;

	public ItemBlockMultiVariant(Block block, VariantsName name)
	{
		super(block);
		this.name = name.getStringList();
		this.reverse = name.isReverseName();
	}

	@Override
	protected String[] getBlockVariantsName()
	{
		return this.name;
	}

	@Override
	protected boolean reverseName()
	{
		return this.reverse;
	}
}