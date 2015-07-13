/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.world.gen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.moons.koentus.world.gen.feature.WorldGenKoentusRockSpires;

public class BiomeDecoratorKoentus extends BiomeDecoratorSpace
{
	private World world;

	private WorldGenerator dirtGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator whiteCrystalGen;
	private WorldGenerator empGen;
	private WorldGenerator fossilGen;
	private WorldGenerator iceGen;
	private WorldGenerator glowIceGen;
	private WorldGenerator rockSpiresGen;

	private int rockSpiresPerChunk;

	public BiomeDecoratorKoentus()
	{
		// Block,NumberOfBlock,Meta,IsMeta,FillBlock,FillMeta
		this.dirtGen = new WorldGenMinableMeta(KoentusBlocks.koentus_block, 32, 1, true, KoentusBlocks.koentus_block, 2);
		this.tinGen = new WorldGenMinableMeta(KoentusBlocks.koentus_block, 8, 4, true, KoentusBlocks.koentus_block, 2);
		this.copperGen = new WorldGenMinableMeta(KoentusBlocks.koentus_block, 8, 5, true, KoentusBlocks.koentus_block, 2);
		this.whiteCrystalGen = new WorldGenMinableMeta(KoentusBlocks.koentus_block, 4, 6, true, KoentusBlocks.koentus_block, 2);
		this.empGen = new WorldGenMinableMeta(KoentusBlocks.koentus_block, 4, 7, true, KoentusBlocks.koentus_block, 2);
		this.fossilGen = new WorldGenMinableMeta(KoentusBlocks.koentus_block, 1, 8, true, KoentusBlocks.koentus_block, 2);
		this.iceGen = new WorldGenMinableMeta(KoentusBlocks.koentus_ice, 16, 0, true, KoentusBlocks.koentus_block, 2);
		this.glowIceGen = new WorldGenMinableMeta(KoentusBlocks.koentus_ice, 16, 1, true, KoentusBlocks.koentus_block, 2);
		this.rockSpiresGen = new WorldGenKoentusRockSpires(KoentusBlocks.koentus_block.getDefaultState());

		this.rockSpiresPerChunk = 4;
	}

	@Override
	public void decorate()
	{
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.world, this.rand, this.pos));

		int i;
		int x;
		int y;
		int z;

		this.generateOre(16, this.tinGen, 0, 64);
		this.generateOre(16, this.copperGen, 0, 64);
		this.generateOre(32, this.dirtGen, 0, 255);
		this.generateOre(10, this.whiteCrystalGen, 0, 32);
		this.generateOre(10, this.empGen, 0, 32);
		this.generateOre(12, this.fossilGen, 24, 48);
		this.generateOre(24, this.iceGen, 0, 255);
		this.generateOre(24, this.glowIceGen, 0, 255);

		for (i = 0; i < this.rockSpiresPerChunk; ++i)
		{
			x = this.rand.nextInt(16) + 8;
			y = this.rand.nextInt(256);
			z = this.rand.nextInt(16) + 8;
			this.rockSpiresGen.generate(this.world, this.rand, new BlockPos(x, y, z));
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.world, this.rand, this.pos));
	}

	@Override
	protected void setCurrentWorld(World world)
	{
		this.world = world;
	}

	@Override
	protected World getCurrentWorld()
	{
		return this.world;
	}
}