/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.world.gen;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.util.BlockPos;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.common.world.biome.BiomeDecoratorMP;
import stevekung.mods.moreplanets.common.world.gen.feature.WorldGenLiquidLakes;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;

public class BiomeDecoratorKapteynB extends BiomeDecoratorMP
{
	private WorldGenerator dirtGen;
	private WorldGenerator nameriumGen;
	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator frozenIronGen;
	private WorldGenerator uraniumGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator iceGen;
	private WorldGenerator dirtyIceGen;
	private WorldGenerator rockyGen;

	public BiomeDecoratorKapteynB()
	{
		this.nameriumGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 6, 4, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.frozenIronGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 7, 5, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.uraniumGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 7, 6, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.tinGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 7, 7, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.copperGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 7, 8, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.redstoneGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 7, 9, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.dirtGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 32, 1, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.rockyGen = new WorldGenMinableMeta(KapteynBBlocks.rocky_solid_water, 8, 0, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.iceGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_ice, 8, 0, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.dirtyIceGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_ice, 8, 1, true, KapteynBBlocks.kapteyn_b_block, 2);
	}

	@Override
	protected void generateOres()
	{
		this.generateOre(24, this.copperGen, 0, 75);
		this.generateOre(22, this.tinGen, 0, 60);
		this.generateOre(8, this.redstoneGen, 0, 16);
		this.generateOre(20, this.dirtGen, 0, 256);
		this.generateOre(8, this.nameriumGen, 16, 32);
		this.generateOre(15, this.frozenIronGen, 12, 32);
		this.generateOre(12, this.uraniumGen, 0, 64);
		this.generateOre(15, this.iceGen, 0, 256);
		this.generateOre(10, this.dirtyIceGen, 0, 256);
		this.generateOre(12, this.rockyGen, 0, 128);

		for (int i = 0; i < 1; ++i)
		{
			if (this.randomGenerator.nextInt(10) == 0)
			{
				int x = this.randomGenerator.nextInt(16) + 8;
				int y = this.randomGenerator.nextInt(32 - 16) + 16;
				int z = this.randomGenerator.nextInt(16) + 8;
				new WorldGenLiquidLakes(KapteynBBlocks.frozen_water).generate(this.currentWorld, this.randomGenerator, new BlockPos(x, y, z));
			}
		}
	}
}