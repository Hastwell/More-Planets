/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.deimos.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import stevekung.mods.moreplanets.common.world.biome.BiomeGenBaseMartianMoon;
import stevekung.mods.moreplanets.common.world.gen.ChunkProviderBaseMP;
import stevekung.mods.moreplanets.common.world.gen.MapGenCavesMP;
import stevekung.mods.moreplanets.common.world.gen.village.MapGenMartianVillage;
import stevekung.mods.moreplanets.moons.deimos.blocks.DeimosBlocks;

public class ChunkProviderDeimos extends ChunkProviderBaseMP
{
	private BiomeDecoratorDeimos biomeDecorator = new BiomeDecoratorDeimos();
	private BiomeGenBase[] biomesForGeneration = { BiomeGenBaseMartianMoon.martianMoon };
	private MapGenCavesMP caveGenerator = new MapGenCavesMP(DeimosBlocks.deimos_block, this.getBlockMetadata());
	private MapGenMartianVillage villageGenerator = new MapGenMartianVillage();

	public ChunkProviderDeimos(World world, long seed, boolean genFeature)
	{
		super(world, seed, genFeature);
	}

	@Override
	public Chunk provideChunk(int chunkX, int chunkZ)
	{
		ChunkPrimer primer = new ChunkPrimer();
		this.rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
		this.generateTerrain(chunkX, chunkZ, primer);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.createCraters(chunkX, chunkZ, primer);
		this.func_180517_a(chunkX, chunkZ, primer, this.biomesForGeneration);
		this.caveGenerator.func_175792_a(this, this.worldObj, chunkX, chunkZ, primer);
		Chunk chunk = new Chunk(this.worldObj, primer, chunkX, chunkZ);
		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public void populate(IChunkProvider chunk, int chunkX, int chunkZ)
	{
		BlockFalling.fallInstantly = true;
		int x = chunkX * 16;
		int z = chunkZ * 16;
		BlockPos pos = new BlockPos(x, 0, z);
		this.worldObj.getBiomeGenForCoords(pos.add(16, 0, 16));
		this.rand.setSeed(this.worldObj.getSeed());
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.villageGenerator.func_175794_a(this.worldObj, this.rand, new ChunkCoordIntPair(chunkX, chunkZ));
		this.rand.setSeed(chunkX * var7 + chunkZ * var9 ^ this.worldObj.getSeed());
		this.biomeDecorator.decorate(this.worldObj, this.rand, BiomeGenBaseMartianMoon.martianMoon, pos);
		BlockFalling.fallInstantly = false;
	}

	@Override
	public void recreateStructures(Chunk chunk, int chunkX, int chunkZ)
	{
		this.villageGenerator.func_175792_a(this, this.worldObj, chunkX, chunkZ, (ChunkPrimer) null);
	}

	@Override
	protected String getName()
	{
		return "Deimos";
	}

	@Override
	protected Block getBaseBlock()
	{
		return DeimosBlocks.deimos_block;
	}

	@Override
	protected int[] getBlockMetadata()
	{
		return new int[] { 0, 1, 2 };
	}
}