/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world;

import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderGenerate;

public class ChunkProviderNull extends ChunkProviderGenerate
{
	public ChunkProviderNull(World world, long seed, boolean genFeature)
	{
		super(world, seed, genFeature, "");
	}
}