/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.biome;

import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorMP extends BiomeDecorator
{
	protected void generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY)
	{
		for (int i = 0; i < amountPerChunk; ++i)
		{
			int x = this.randomGenerator.nextInt(16) + 8;
			int y = this.randomGenerator.nextInt(maxY - minY) + minY;
			int z = this.randomGenerator.nextInt(16) + 8;
			worldGenerator.generate(this.currentWorld, this.randomGenerator, new BlockPos(x, y, z));
		}
	}
}