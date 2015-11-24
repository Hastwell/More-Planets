/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.biome;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class BiomeDecoratorMP extends BiomeDecorator
{
	@Override
	public void decorate(World world, Random rand, BiomeGenBase biome, BlockPos pos)
	{
		this.currentWorld = world;
		this.randomGenerator = rand;
		this.field_180294_c = pos;
		this.generateOres();
		this.currentWorld = null;
		this.randomGenerator = null;
	}

	@Override
	protected abstract void generateOres();

	protected void generateOre(int amount, WorldGenerator worldGen, int minY, int maxY)
	{
		for (int i = 0; i < amount; ++i)
		{
			BlockPos blockpos = this.field_180294_c.add(this.randomGenerator.nextInt(16), this.randomGenerator.nextInt(maxY) + this.randomGenerator.nextInt(maxY) + minY - maxY, this.randomGenerator.nextInt(16));
			worldGen.generate(this.currentWorld, this.randomGenerator, blockpos);
		}
	}
}