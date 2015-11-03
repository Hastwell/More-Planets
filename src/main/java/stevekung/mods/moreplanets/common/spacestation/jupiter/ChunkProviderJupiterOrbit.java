package stevekung.mods.moreplanets.common.spacestation.jupiter;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.tile.IMultiBlock;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;

public class ChunkProviderJupiterOrbit extends ChunkProviderGenerate
{
	private Random rand;
	private World worldObj;

	public ChunkProviderJupiterOrbit(World world, long seed, boolean genFeature)
	{
		super(world, seed, genFeature, "");
		this.rand = new Random(seed);
		this.worldObj = world;
	}

	@Override
	public boolean unloadQueuedChunks()
	{
		return false;
	}

	@Override
	public int getLoadedChunkCount()
	{
		return 0;
	}

	@Override
	public boolean saveChunks(boolean save, IProgressUpdate update)
	{
		return true;
	}

	@Override
	public boolean canSave()
	{
		return true;
	}

	@Override
	public Chunk provideChunk(int x, int z)
	{
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.rand.setSeed(x * 341873128712L + z * 132897987541L);
		Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
		byte[] biomesArray = chunk.getBiomeArray();

		for (int i = 0; i < biomesArray.length; ++i)
		{
			biomesArray[i] = (byte) 213;
		}
		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public boolean chunkExists(int x, int z)
	{
		return true;
	}

	@Override
	public void populate(IChunkProvider chunkProvider, int chunkX, int chunkZ)
	{
		BlockFalling.fallInstantly = true;
		int x = chunkX * 16;
		int z = chunkZ * 16;
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(chunkX * i1 + chunkZ * j1 ^ this.worldObj.getSeed());

		if (x == 0 && z == 0)
		{
			BlockPos pos = new BlockPos(x, 64, z);
			BlockPos pos1 = new BlockPos(x, 69, z);
			BlockPos pos2 = new BlockPos(x, 69, z + 3);
			BlockPos pos3 = new BlockPos(x, 69, z - 3);
			this.worldObj.setBlockState(pos, GCBlocks.spaceStationBase.getDefaultState(), 3);
			this.worldObj.setBlockState(pos1, PolongniusBlocks.ultra_violet_solar_panel.getDefaultState(), 3);
			this.worldObj.setBlockState(pos2, PolongniusBlocks.ultra_violet_solar_panel.getDefaultState(), 3);
			this.worldObj.setBlockState(pos3, PolongniusBlocks.ultra_violet_solar_panel.getDefaultState(), 3);
			TileEntity tile = this.worldObj.getTileEntity(pos);
			TileEntity tile1 = this.worldObj.getTileEntity(pos1);
			TileEntity tile2 = this.worldObj.getTileEntity(pos2);
			TileEntity tile3 = this.worldObj.getTileEntity(pos3);

			if (tile instanceof IMultiBlock)
			{
				((IMultiBlock)tile).onCreate(this.worldObj, pos);
			}
			if (tile1 instanceof IMultiBlock)
			{
				((IMultiBlock)tile1).onCreate(this.worldObj, pos1);
			}
			if (tile2 instanceof IMultiBlock)
			{
				((IMultiBlock)tile2).onCreate(this.worldObj, pos2);
			}
			if (tile3 instanceof IMultiBlock)
			{
				((IMultiBlock)tile3).onCreate(this.worldObj, pos3);
			}
			new WorldGenJupiterSpaceStation().generate(this.worldObj, this.rand, new BlockPos(x - 10, 62, z - 3));
		}
		BlockFalling.fallInstantly = false;
	}

	@Override
	public String makeString()
	{
		return "JupiterOrbitLevelSource";
	}

	@Override
	public List<?> func_177458_a(EnumCreatureType type, BlockPos pos)
	{
		return null;
	}
}