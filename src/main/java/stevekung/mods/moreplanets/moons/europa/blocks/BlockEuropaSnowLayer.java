/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.blocks;

import net.minecraft.item.Item;
import stevekung.mods.moreplanets.common.blocks.BlockSnowLayerMP;

public class BlockEuropaSnowLayer extends BlockSnowLayerMP
{
	public BlockEuropaSnowLayer(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	protected Item getItemDropped()
	{
		return null;//TODO Europa Snow Ball
	}

	@Override
	protected int getItemMetadataDropped()
	{
		return 0;
	}
}