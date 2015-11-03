/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.world.gen;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;
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
		// Block,NumberOfBlock,Meta,IsMeta,FillBlock,FillMeta
		this.nameriumGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 4, 4, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.frozenIronGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 8, 5, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.uraniumGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 8, 6, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.tinGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 8, 7, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.copperGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 8, 8, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.redstoneGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 8, 9, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.dirtGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_block, 32, 1, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.rockyGen = new WorldGenMinableMeta(KapteynBBlocks.rocky_solid_water, 8, 0, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.iceGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_ice, 12, 0, true, KapteynBBlocks.kapteyn_b_block, 2);
		this.dirtyIceGen = new WorldGenMinableMeta(KapteynBBlocks.kapteyn_b_ice, 12, 1, true, KapteynBBlocks.kapteyn_b_block, 2);
	}

	@Override
	public void decorate(World world, Random rand, BiomeGenBase biome, BlockPos pos)
	{
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.randomGenerator, this.field_180294_c));

		this.generateOre(16, this.copperGen, 0, 64);
		this.generateOre(16, this.tinGen, 0, 64);
		this.generateOre(12, this.redstoneGen, 0, 16);
		this.generateOre(32, this.dirtGen, 0, 255);
		this.generateOre(12, this.nameriumGen, 0, 32);
		this.generateOre(16, this.frozenIronGen, 24, 32);
		this.generateOre(10, this.uraniumGen, 0, 64);
		this.generateOre(24, this.iceGen, 0, 255);
		this.generateOre(24, this.dirtyIceGen, 0, 255);
		this.generateOre(24, this.rockyGen, 0, 128);

		for (int i = 0; this.getGen(EventType.LAKE_WATER) && i < 1; ++i)
		{
			if (this.randomGenerator.nextInt(10) == 0)
			{
				int x = this.randomGenerator.nextInt(16) + 8;
				int y = this.randomGenerator.nextInt(32 - 16) + 16;
				int z = this.randomGenerator.nextInt(16) + 8;
				new WorldGenLiquidLakes(KapteynBBlocks.frozen_water).generate(this.currentWorld, this.randomGenerator, new BlockPos(x, y, z));
			}
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.randomGenerator, this.field_180294_c));
	}

	private boolean getGen(EventType event)
	{
		return TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.field_180294_c, event);
	}
}