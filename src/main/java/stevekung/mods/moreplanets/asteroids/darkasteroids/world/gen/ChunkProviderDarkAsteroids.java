/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.world.gen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.vector.BlockVec3;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.core.perlin.NoiseModule;
import micdoodle8.mods.galacticraft.core.perlin.generator.Billowed;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.world.gen.SpecialAsteroidBlock;
import micdoodle8.mods.galacticraft.planets.asteroids.world.gen.SpecialAsteroidBlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.DarkAsteroidBlocks;
import stevekung.mods.moreplanets.asteroids.darkasteroids.dimension.WorldProviderDarkAsteroids;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;

public class ChunkProviderDarkAsteroids extends ChunkProviderGenerate
{
	Block ASTEROID_STONE = DarkAsteroidBlocks.dark_asteroid_rock;
	byte ASTEROID_STONE_META_0 = 0;
	byte ASTEROID_STONE_META_1 = 1;
	byte ASTEROID_STONE_META_2 = 2;

	Block DIRT = Blocks.dirt;
	byte DIRT_META = 0;
	Block GRASS = Blocks.grass;
	byte GRASS_META = 0;
	Block LIGHT = Blocks.glowstone;
	byte LIGHT_META = 0;

	Block LAVA = Blocks.lava;
	byte LAVA_META = 0;
	Block WATER = Blocks.water;
	byte WATER_META = 0;

	private Random rand;
	private World worldObj;

	private NoiseModule asteroidDensity;
	private NoiseModule asteroidTurbulance;
	private NoiseModule asteroidSkewX;
	private NoiseModule asteroidSkewY;
	private NoiseModule asteroidSkewZ;

	private SpecialAsteroidBlockHandler coreHandler;
	private SpecialAsteroidBlockHandler shellHandler;

	private static int CHUNK_SIZE_X = 16;
	private static int CHUNK_SIZE_Y = 256;
	private static int CHUNK_SIZE_Z = 16;

	private static int MAX_ASTEROID_RADIUS = 20;
	private static int MIN_ASTEROID_RADIUS = 5;
	private static int MAX_ASTEROID_SKEW = 8;

	private static int MIN_ASTEROID_Y = 48;
	private static int MAX_ASTEROID_Y = ChunkProviderDarkAsteroids.CHUNK_SIZE_Y - 48;

	private static int ASTEROID_CHANCE = 800; //About 1 / n chance per XZ pair
	private static int ASTEROID_SHELL_CHANCE = 2; //1 / n chance per asteroid

	private static int MIN_BLOCKS_PER_CHUNK = 50;
	private static int MAX_BLOCKS_PER_CHUNK = 200;

	private static int ALUMINUM_CHANCE = 250;
	private static int ILMENITE_CHANCE = 400;
	private static int IRON_CHANCE = 300;
	private static int METEORIC_IRON_CHANCE = 450;

	private static int NOISE_OFFSET_SIZE = 256;

	private static float MIN_HOLLOW_SIZE = .6F;
	private static float MAX_HOLLOW_SIZE = .8F;
	private static int HOLLOW_CHANCE = 10; //1 / n chance per asteroid
	private static int MIN_RADIUS_FOR_HOLLOW = 15;

	//Per chunk per asteroid
	private static int TREE_CHANCE = 2;
	private static int TALL_GRASS_CHANCE = 2;
	private static int FLOWER_CHANCE = 2;
	private static int WATER_CHANCE = 2;
	private static int LAVA_CHANCE = 2;
	private static int GLOWSTONE_CHANCE = 20;

	private ArrayList<AsteroidData> largeAsteroids = new ArrayList<AsteroidData>();
	private static HashSet<BlockVec3> chunksDone = new HashSet<BlockVec3>();
	private int largeAsteroidsLastChunkX;
	private int largeAsteroidsLastChunkZ;

	public ChunkProviderDarkAsteroids(World world, long seed, boolean genFeature)
	{
		super(world, seed, genFeature, "");
		this.worldObj = world;
		this.rand = new Random(seed);

		this.asteroidDensity = new Billowed(this.rand.nextLong(), 2, .25F);
		this.asteroidDensity.setFrequency(.009F);
		this.asteroidDensity.amplitude = .6F;

		this.asteroidTurbulance = new Gradient(this.rand.nextLong(), 1, .2F);
		this.asteroidTurbulance.setFrequency(.08F);
		this.asteroidTurbulance.amplitude = .5F;

		this.asteroidSkewX = new Gradient(this.rand.nextLong(), 1, 1);
		this.asteroidSkewX.amplitude = ChunkProviderDarkAsteroids.MAX_ASTEROID_SKEW;
		this.asteroidSkewX.frequencyX = 0.005F;

		this.asteroidSkewY = new Gradient(this.rand.nextLong(), 1, 1);
		this.asteroidSkewY.amplitude = ChunkProviderDarkAsteroids.MAX_ASTEROID_SKEW;
		this.asteroidSkewY.frequencyY = 0.005F;

		this.asteroidSkewZ = new Gradient(this.rand.nextLong(), 1, 1);
		this.asteroidSkewZ.amplitude = ChunkProviderDarkAsteroids.MAX_ASTEROID_SKEW;
		this.asteroidSkewZ.frequencyZ = 0.005F;

		this.coreHandler = new SpecialAsteroidBlockHandler();
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, this.ASTEROID_STONE_META_2, 5, .3));
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, this.ASTEROID_STONE_META_1, 7, .3));
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, this.ASTEROID_STONE_META_0, 11, .25));
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, (byte) 3, 5, .2));//Aluminum
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, (byte) 4, 4, .15));//Ilmenite
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, (byte) 5, 3, .2));//Iron
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, (byte) 7, 2, .15));//Silicon
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, (byte) 6, 2, .13));//Meteoric Iron
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, (byte) 8, 1, .1));//Diamond
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, (byte) 9, 3, .4));//Emerald
		this.coreHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, (byte) 10, 3, .6));//Lapis
		this.coreHandler.addBlock(new SpecialAsteroidBlock(DarkAsteroidBlocks.alphere_ore, (byte) 0, 2, .4));//Alphere
		this.shellHandler = new SpecialAsteroidBlockHandler();
		this.shellHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, this.ASTEROID_STONE_META_1, 3, .15));
		this.shellHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, this.ASTEROID_STONE_META_0, 1, .15));
		this.shellHandler.addBlock(new SpecialAsteroidBlock(this.ASTEROID_STONE, this.ASTEROID_STONE_META_2, 1, .15));
		this.shellHandler.addBlock(new SpecialAsteroidBlock(AsteroidBlocks.blockDenseIce, (byte) 0, 1, .15));
	}

	public void generateTerrain(int chunkX, int chunkZ, ChunkPrimer chunk, boolean flagDataOnly)
	{
		this.largeAsteroids.clear();
		Random random = new Random();
		int asteroidChance = ChunkProviderDarkAsteroids.ASTEROID_CHANCE;
		int rangeY = ChunkProviderDarkAsteroids.MAX_ASTEROID_Y - ChunkProviderDarkAsteroids.MIN_ASTEROID_Y;
		int rangeSize = ChunkProviderDarkAsteroids.MAX_ASTEROID_RADIUS - ChunkProviderDarkAsteroids.MIN_ASTEROID_RADIUS;

		//If there is an asteroid centre nearby, it might need to generate some asteroid parts in this chunk
		for (int i = chunkX - 3; i < chunkX + 3; i++)
		{
			int minX = i * 16;
			int maxX = minX + ChunkProviderDarkAsteroids.CHUNK_SIZE_X;

			for (int k = chunkZ - 3; k < chunkZ + 3; k++)
			{
				int minZ = k * 16;
				int maxZ = minZ + ChunkProviderDarkAsteroids.CHUNK_SIZE_Z;

				//NOTE: IF UPDATING THIS CODE also update addLargeAsteroids() which is the same algorithm
				for (int x = minX; x < maxX; x+=2)
				{
					for (int z = minZ; z < maxZ; z+=2)
					{
						//The next line is called 3136 times per chunk generated.  getNoise is a little slow.
						if (this.randFromPointPos(x, z) < (this.asteroidDensity.getNoise(x, z) + .4) / asteroidChance)
						{
							random.setSeed(x + z * 3067);
							int y = random.nextInt(rangeY) + ChunkProviderDarkAsteroids.MIN_ASTEROID_Y;
							int size = random.nextInt(rangeSize) + ChunkProviderDarkAsteroids.MIN_ASTEROID_RADIUS;

							//Add to the list of asteroids for external use
							((WorldProviderDarkAsteroids) this.worldObj.provider).addAsteroid(x, y, z);
							//Generate the parts of the asteroid which are in this chunk
							this.generateAsteroid(random, x, y, z, chunkX << 4, chunkZ << 4, size, chunk, flagDataOnly);
						}
					}
				}
			}
		}
	}

	private void generateAsteroid(Random rand, int asteroidX, int asteroidY, int asteroidZ, int chunkX, int chunkZ, int size, ChunkPrimer chunk, boolean flagDataOnly)
	{
		SpecialAsteroidBlock core = this.coreHandler.getBlock(rand);
		SpecialAsteroidBlock shell = null;

		if (rand.nextInt(ChunkProviderDarkAsteroids.ASTEROID_SHELL_CHANCE) == 0)
		{
			shell = this.shellHandler.getBlock(rand);
		}

		boolean isHollow = false;
		float hollowSize = rand.nextFloat() * (ChunkProviderDarkAsteroids.MAX_HOLLOW_SIZE - ChunkProviderDarkAsteroids.MIN_HOLLOW_SIZE) + ChunkProviderDarkAsteroids.MIN_HOLLOW_SIZE;

		if (rand.nextInt(ChunkProviderDarkAsteroids.HOLLOW_CHANCE) == 0 && size >= ChunkProviderDarkAsteroids.MIN_RADIUS_FOR_HOLLOW)
		{
			isHollow = true;
			shell = new SpecialAsteroidBlock(AsteroidBlocks.blockDenseIce, (byte) 0, 1, .15);
		}

		int xMin = this.clamp(Math.max(chunkX, asteroidX - size - ChunkProviderDarkAsteroids.MAX_ASTEROID_SKEW - 2) - chunkX, 0, 16);
		int zMin = this.clamp(Math.max(chunkZ, asteroidZ - size - ChunkProviderDarkAsteroids.MAX_ASTEROID_SKEW - 2) - chunkZ, 0, 16);
		int yMin = asteroidY - size - ChunkProviderDarkAsteroids.MAX_ASTEROID_SKEW - 2;
		int yMax = asteroidY + size + ChunkProviderDarkAsteroids.MAX_ASTEROID_SKEW + 2;
		int xMax = this.clamp(Math.min(chunkX + 16, asteroidX + size + ChunkProviderDarkAsteroids.MAX_ASTEROID_SKEW + 2) - chunkX, 0, 16);
		int zMax = this.clamp(Math.min(chunkZ + 16, asteroidZ + size + ChunkProviderDarkAsteroids.MAX_ASTEROID_SKEW + 2) - chunkZ, 0, 16);
		int xSize = xMax - xMin;
		int ySize = yMax - yMin;
		int zSize = zMax - zMin;

		if (xSize <= 0 || ySize <= 0 || zSize <=0)
		{
			return;
		}

		float noiseOffsetX = this.randFromPoint(asteroidX, asteroidY, asteroidZ) * ChunkProviderDarkAsteroids.NOISE_OFFSET_SIZE + chunkX;
		float noiseOffsetY = this.randFromPoint(asteroidX * 7, asteroidY * 11, asteroidZ * 13) * ChunkProviderDarkAsteroids.NOISE_OFFSET_SIZE;
		float noiseOffsetZ = this.randFromPoint(asteroidX * 17, asteroidY * 23, asteroidZ * 29) * ChunkProviderDarkAsteroids.NOISE_OFFSET_SIZE + chunkZ;
		this.setOtherAxisFrequency(1F / (size * 2F / 2F));
		float[] sizeXArray = new float[ySize * zSize];
		float[] sizeZArray = new float[xSize * ySize];
		float[] sizeYArray = new float[xSize * zSize];

		for (int x = 0; x < xSize; x++)
		{
			int xx = x * zSize;
			float xxx = x + noiseOffsetX;

			for (int z = 0; z < zSize; z++)
			{
				sizeYArray[xx + z] = this.asteroidSkewY.getNoise(xxx, z + noiseOffsetZ);
			}
		}

		AsteroidData asteroidData = new AsteroidData(isHollow, sizeYArray, xMin, zMin, xMax, zMax, zSize, size, asteroidY);
		this.largeAsteroids.add(asteroidData);
		this.largeAsteroidsLastChunkX = chunkX;
		this.largeAsteroidsLastChunkZ = chunkZ;

		if (flagDataOnly)
		{
			return;
		}

		for (int y = 0; y < ySize; y++)
		{
			int yy = y * zSize;
			float yyy = y + noiseOffsetY;

			for (int z = 0; z < zSize; z++)
			{
				sizeXArray[yy + z] = this.asteroidSkewX.getNoise(yyy, z + noiseOffsetZ);
			}
		}

		for (int x = 0; x < xSize; x++)
		{
			int xx = x * ySize;
			float xxx = x + noiseOffsetX;

			for (int y = 0; y < ySize; y++)
			{
				sizeZArray[xx + y] = this.asteroidSkewZ.getNoise(xxx, y + noiseOffsetY);
			}
		}

		double shellThickness = 0;
		int terrainY = 0;
		int terrainYY = 0;

		if (shell != null)
		{
			shellThickness = 1.0 - shell.thickness;
		}

		for (int x = xMax - 1; x >= xMin; x--)
		{
			int indexXY = (x - xMin) * ySize - yMin;
			int indexXZ = (x - xMin) * zSize - zMin;
			int distanceX = asteroidX - (x + chunkX);
			int indexBaseX = x * ChunkProviderDarkAsteroids.CHUNK_SIZE_Y << 4;
			float xx = x + chunkX;

			for (int z = zMin; z < zMax; z++)
			{
				if (isHollow)
				{
					float sizeModY = sizeYArray[indexXZ + z];
					terrainY = this.getTerrainHeightFor(sizeModY, asteroidY, size);
					terrainYY = this.getTerrainHeightFor(sizeModY, asteroidY - 1, size);
				}

				float sizeY = size + sizeYArray[indexXZ + z];
				sizeY *= sizeY;
				int distanceZ = asteroidZ - (z + chunkZ);
				int indexBase = indexBaseX | z * ChunkProviderDarkAsteroids.CHUNK_SIZE_Y;
				float zz = z + chunkZ;

				for (int y = yMin; y < yMax; y++)
				{
					float dSizeX = distanceX / (size + sizeXArray[(y - yMin) * zSize + z - zMin]);
					float dSizeZ = distanceZ / (size + sizeZArray[indexXY + y]);
					dSizeX *= dSizeX;
					dSizeZ *= dSizeZ;
					int distanceY = asteroidY - y;
					distanceY *= distanceY;
					float distance = dSizeX + distanceY / sizeY + dSizeZ;
					float distanceAbove = distance;
					distance += this.asteroidTurbulance.getNoise(xx, y, zz);

					if (isHollow && distance <= hollowSize)
					{
						distanceAbove += this.asteroidTurbulance.getNoise(xx, y + 1, zz);

						if (distanceAbove <= 1)
						{
							if (y - 1 == terrainYY)
							{
								int index = indexBase | y + 1;
								chunk.setBlockState(index, this.LIGHT.getStateFromMeta(this.LIGHT_META));
							}
						}
					}

					if (distance <= 1)
					{
						int index = indexBase | y;

						if (isHollow && distance <= hollowSize)
						{
							if (y == terrainY)
							{
								chunk.setBlockState(index, this.GRASS.getStateFromMeta(this.GRASS_META));
							}
							else if (y < terrainY)
							{
								chunk.setBlockState(index, this.DIRT.getStateFromMeta(this.DIRT_META));
							}
							else
							{
								chunk.setBlockState(index, Blocks.air.getDefaultState());
							}
						}
						else if (distance <= core.thickness)
						{
							if (rand.nextBoolean())
							{
								chunk.setBlockState(index, core.block.getStateFromMeta(core.meta));
							}
							else
							{
								chunk.setBlockState(index, this.ASTEROID_STONE.getStateFromMeta(this.ASTEROID_STONE_META_0));
							}
						}
						else if (shell != null && distance >= shellThickness)
						{
							chunk.setBlockState(index, shell.block.getStateFromMeta(shell.meta));
						}
						else
						{
							chunk.setBlockState(index, this.ASTEROID_STONE.getStateFromMeta(this.ASTEROID_STONE_META_1));
						}
					}
				}
			}
		}

		if (isHollow)
		{
			shellThickness = 0;

			if (shell != null)
			{
				shellThickness = 1.0 - shell.thickness;
			}

			for (int x = xMin; x < xMax; x++)
			{
				int indexXY = (x - xMin) * ySize - yMin;
				int indexXZ = (x - xMin) * zSize - zMin;
				int distanceX = asteroidX - (x + chunkX);
				distanceX *= distanceX;
				int indexBaseX = x * ChunkProviderDarkAsteroids.CHUNK_SIZE_Y << 4;

				for (int z = zMin; z < zMax; z++)
				{
					float sizeY = size + sizeYArray[indexXZ + z];
					sizeY *= sizeY;
					int distanceZ = asteroidZ - (z + chunkZ);
					distanceZ *= distanceZ;
					int indexBase = indexBaseX | z * ChunkProviderDarkAsteroids.CHUNK_SIZE_Y;

					for (int y = yMin; y < yMax; y++)
					{
						float sizeX = size + sizeXArray[(y - yMin) * zSize + z - zMin];
						float sizeZ = size + sizeZArray[indexXY + y];
						sizeX *= sizeX;
						sizeZ *= sizeZ;
						int distanceY = asteroidY - y;
						distanceY *= distanceY;
						float distance = distanceX / sizeX + distanceY / sizeY + distanceZ / sizeZ;
						distance += this.asteroidTurbulance.getNoise(x + chunkX, y, z + chunkZ);

						if (distance <= 1)
						{
							int index = indexBase | y;
							int indexAbove = indexBase | y + 1;
							IBlockState state = chunk.getBlockState(index);
							IBlockState stateAbove = chunk.getBlockState(indexAbove);

							if (Blocks.air == stateAbove.getBlock() && (state.getBlock() == this.ASTEROID_STONE || state.getBlock() == this.GRASS))
							{
								if (this.rand.nextInt(GLOWSTONE_CHANCE) == 0)
								{
									chunk.setBlockState(index, this.LIGHT.getStateFromMeta(this.LIGHT_META));
								}
							}
						}
					}
				}
			}
		}
	}

	private void setOtherAxisFrequency(float frequency)
	{
		this.asteroidSkewX.frequencyY = frequency;
		this.asteroidSkewX.frequencyZ = frequency;
		this.asteroidSkewY.frequencyX = frequency;
		this.asteroidSkewY.frequencyZ = frequency;
		this.asteroidSkewZ.frequencyX = frequency;
		this.asteroidSkewZ.frequencyY = frequency;
	}

	private int clamp(int x, int min, int max)
	{
		if (x < min)
		{
			x = min;
		}
		else if (x > max)
		{
			x = max;
		}
		return x;
	}

	private double clamp(double x, double min, double max)
	{
		if (x < min)
		{
			x = min;
		}
		else if (x > max)
		{
			x = max;
		}
		return x;
	}

	private int getTerrainHeightFor(float yMod, int asteroidY, int asteroidSize)
	{
		return (int)(asteroidY - asteroidSize / 4 - -yMod * 1.5);
	}

	private int getTerrainHeightAt(int x, int z, float[] yModArray, int xMin, int zMin, int zSize, int asteroidY, int asteroidSize)
	{
		int index = (x - xMin) * zSize - zMin;

		if (index < yModArray.length && index >= 0)
		{
			float yMod = yModArray[index];
			return this.getTerrainHeightFor(yMod, asteroidY, asteroidSize);
		}
		return 1;
	}

	@Override
	public Chunk provideChunk(int chunkX, int chunkZ)
	{
		ChunkPrimer chunk = new ChunkPrimer();
		this.rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
		this.generateTerrain(chunkX, chunkZ, chunk, false);
		Chunk var4 = new Chunk(this.worldObj, chunk, chunkX, chunkZ);
		byte[] var5 = var4.getBiomeArray();

		for (int var6 = 0; var6 < var5.length; ++var6)
		{
			var5[var6] = (byte) BiomeGenBaseDarkAsteroids.darkAsteroids.biomeID;
		}
		this.generateSkylightMap(var4, chunkX, chunkZ);
		return var4;
	}

	private float randFromPoint(int x, int y, int z)
	{
		int n = x + z * 57 + y * 571;
		n ^= n << 13;
		n = n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff;
		return 1.0F - n / 1073741824.0F;
	}

	private float randFromPoint(int x, int z)
	{
		int n = x + z * 57;
		n ^= n << 13;
		n = n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff;
		return 1.0F - n / 1073741824.0F;
	}

	private float randFromPointPos(int x, int z)
	{
		int n = x + z * 57;
		n ^= n << 13;
		n = n * (n * n * 15731 + 789221) + 1376312589 & 0x3fffffff;
		return 1.0F - n / 1073741824.0F;
	}

	@Override
	public boolean chunkExists(int par1, int par2)
	{
		return true;
	}

	@Override
	public void populate(IChunkProvider chunk, int chunkX, int chunkZ)
	{
		int x = chunkX << 4;
		int z = chunkZ << 4;

		if (!ChunkProviderDarkAsteroids.chunksDone.add(new BlockVec3(x, 0, z)))
		{
			return;
		}

		BlockFalling.fallInstantly = true;
		this.worldObj.getBiomeGenForCoords(new BlockPos(x + 16, 0, z + 16));
		BlockFalling.fallInstantly = false;
		this.rand.setSeed(this.worldObj.getSeed());
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(chunkX * var7 + chunkZ * var9 ^ this.worldObj.getSeed());

		//50:50 chance to include small blocks each chunk
		if (this.rand.nextBoolean())
		{
			double density = this.asteroidDensity.getNoise(chunkX * 16, chunkZ * 16) * 0.54;
			double numOfBlocks = this.clamp(this.randFromPoint(chunkX, chunkZ), .4, 1) * ChunkProviderDarkAsteroids.MAX_BLOCKS_PER_CHUNK * density + ChunkProviderDarkAsteroids.MIN_BLOCKS_PER_CHUNK;
			int y0 = this.rand.nextInt(2);
			Block block;
			int meta;
			int yRange = ChunkProviderDarkAsteroids.MAX_ASTEROID_Y - ChunkProviderDarkAsteroids.MIN_ASTEROID_Y;

			for (int i = 0; i < numOfBlocks; i++)
			{
				int y = this.rand.nextInt(yRange) + ChunkProviderDarkAsteroids.MIN_ASTEROID_Y;

				//50:50 chance vertically as well
				if (y0 == y / 16 % 2)
				{
					int px = x + this.rand.nextInt(ChunkProviderDarkAsteroids.CHUNK_SIZE_X);
					int pz = z + this.rand.nextInt(ChunkProviderDarkAsteroids.CHUNK_SIZE_Z);
					block = this.ASTEROID_STONE;
					meta = this.ASTEROID_STONE_META_1;

					if (this.rand.nextInt(ALUMINUM_CHANCE) == 0)
					{
						meta = 3;
					}
					else if (this.rand.nextInt(ILMENITE_CHANCE) == 0)
					{
						meta = 4;
					}
					else if (this.rand.nextInt(IRON_CHANCE) == 0)
					{
						meta = 5;
					}
					else if (this.rand.nextInt(METEORIC_IRON_CHANCE) == 0)
					{
						meta = 6;
					}

					this.worldObj.setBlockState(new BlockPos(px, y, pz), block.getStateFromMeta(meta), 2);
					int count = 7;

					if (!this.worldObj.getBlockState(new BlockPos(px - 1,  y, pz)).getBlock().isAir(this.worldObj, new BlockPos(px - 1, y, pz)))
					{
						count = 1;
					}
					else if (!this.worldObj.getBlockState(new BlockPos(px - 2,  y, pz)).getBlock().isAir(this.worldObj, new BlockPos(px - 2, y, pz)))
					{
						count = 3;
					}
					else if (!this.worldObj.getBlockState(new BlockPos(px - 3,  y, pz)).getBlock().isAir(this.worldObj, new BlockPos(px - 3,  y, pz)))
					{
						count = 5;
					}
					else if (!this.worldObj.getBlockState(new BlockPos(px - 4,  y, pz)).getBlock().isAir(this.worldObj, new BlockPos(px - 4,  y, pz)))
					{
						count = 6;
					}
					this.worldObj.setLightFor(EnumSkyBlock.BLOCK, new BlockPos(px, y, pz), count);
				}
			}
		}

		if (this.largeAsteroidsLastChunkX != chunkX || this.largeAsteroidsLastChunkZ != chunkZ)
		{
			this.generateTerrain(chunkX, chunkZ, null, true);
		}

		this.rand.setSeed(chunkX * var7 + chunkZ * var9 ^ this.worldObj.getSeed());

		//Look for hollow asteroids to populate
		if (!this.largeAsteroids.isEmpty())
		{
			for (AsteroidData asteroidIndex : this.largeAsteroids)
			{
				if (!asteroidIndex.isHollow)
				{
					continue;
				}

				float[] sizeYArray = asteroidIndex.sizeYArray;
				int xMin = asteroidIndex.xMinArray;
				int zMin = asteroidIndex.zMinArray;
				int zSize = asteroidIndex.zSizeArray;
				int asteroidY = asteroidIndex.asteroidYArray;
				int asteroidSize = asteroidIndex.asteroidSizeArray;

				if (this.rand.nextInt(ChunkProviderDarkAsteroids.TREE_CHANCE) == 0)
				{
					int i = this.rand.nextInt(16) + x + 8;
					int k = this.rand.nextInt(16) + z + 8;
					new WorldGenTrees(false).generate(this.worldObj, this.rand, new BlockPos(i, this.getTerrainHeightAt(i - x, k - z, sizeYArray, xMin, zMin, zSize, asteroidY, asteroidSize), k));
				}
				if (this.rand.nextInt(ChunkProviderDarkAsteroids.TALL_GRASS_CHANCE) == 0)
				{
					int i = this.rand.nextInt(16) + x + 8;
					int k = this.rand.nextInt(16) + z + 8;
					new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS).generate(this.worldObj, this.rand, new BlockPos(i, this.getTerrainHeightAt(i - x, k - z, sizeYArray, xMin, zMin, zSize, asteroidY, asteroidSize), k));
				}
				if (this.rand.nextInt(ChunkProviderDarkAsteroids.FLOWER_CHANCE) == 0)
				{
					int i = this.rand.nextInt(16) + x + 8;
					int k = this.rand.nextInt(16) + z + 8;
					new WorldGenFlowers(Blocks.red_flower, BlockFlower.EnumFlowerType.POPPY).generate(this.worldObj, this.rand, new BlockPos(i, this.getTerrainHeightAt(i - x, k - z, sizeYArray, xMin, zMin, zSize, asteroidY, asteroidSize), k));
				}
				if (this.rand.nextInt(ChunkProviderDarkAsteroids.LAVA_CHANCE) == 0)
				{
					int i = this.rand.nextInt(16) + x + 8;
					int k = this.rand.nextInt(16) + z + 8;
					new WorldGenLakes(this.LAVA).generate(this.worldObj, this.rand, new BlockPos(i, this.getTerrainHeightAt(i - x, k - z, sizeYArray, xMin, zMin, zSize, asteroidY, asteroidSize), k));
				}
				if (this.rand.nextInt(ChunkProviderDarkAsteroids.WATER_CHANCE) == 0)
				{
					int i = this.rand.nextInt(16) + x + 8;
					int k = this.rand.nextInt(16) + z + 8;
					new WorldGenLakes(this.WATER).generate(this.worldObj, this.rand, new BlockPos(i, this.getTerrainHeightAt(i - x, k - z, sizeYArray, xMin, zMin, zSize, asteroidY, asteroidSize), k));
				}
			}
		}

		//Update all block lighting
		for (int xx = 0; xx < 16; xx++)
		{
			int xPos = x + xx;

			for (int zz = 0; zz < 16; zz++)
			{
				int zPos = z + zz;

				//Asteroid at min height 48, size 20, can't have lit blocks below 16
				for (int y = 16; y < 240; y++)
				{
					this.worldObj.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos(xPos, y, zPos));
				}
			}
		}

	}

	public void generateSkylightMap(Chunk chunk, int cx, int cz)
	{
		World w = chunk.getWorld();
		w.getChunkProvider().chunkExists(cx - 1, cz);
		w.getChunkProvider().chunkExists(cx, cz + 1);
		w.getChunkProvider().chunkExists(cx, cz - 1);
		w.getChunkProvider().chunkExists(cx - 1, cz + 1);
		w.getChunkProvider().chunkExists(cx - 1, cz - 1);

		for (int j = 0; j < 16; j++)
		{
			if (chunk.getBlockStorageArray()[j] == null)
			{
				chunk.getBlockStorageArray()[j] = new ExtendedBlockStorage(j, false);
			}
		}

		int i = chunk.getTopFilledSegment();
		int heightMap = chunk.getLowestHeight();
		heightMap = Integer.MAX_VALUE;

		for (int j = 0; j < 16; ++j)
		{
			int k = 0;

			while (k < 16)
			{
				chunk.precipitationHeightMap[j + (k << 4)] = -999;
				int y = i + 15;

				while (true)
				{
					if (y > 0)
					{
						if (chunk.getBlockLightOpacity(new BlockPos(j, y - 1, k)) == 0)
						{
							--y;
							continue;
						}

						chunk.heightMap[k << 4 | j] = y;

						if (y < heightMap)
						{
							heightMap = y;
						}
					}
					++k;
					break;
				}
			}
		}

		for (AsteroidData a : this.largeAsteroids)
		{
			int yMin = a.asteroidYArray - a.asteroidSizeArray;
			int yMax = a.asteroidYArray + a.asteroidSizeArray;
			int xMin = a.xMinArray;

			if (yMin < 0)
			{
				yMin = 0;
			}
			if (yMax > 255)
			{
				yMax = 255;
			}
			if (xMin == 0)
			{
				xMin = 1;
			}

			for (int x = a.xMax - 1; x >= xMin; x--)
			{
				for (int z = a.zMinArray; z < a.zMax; z++)
				{
					for (int y = yMin; y < yMax; y++)
					{
						if (chunk.getBlock(x - 1, y, z).isAir(w, new BlockPos(x - 1, y, z)) && !chunk.getBlock(x, y, z).isAir(w, new BlockPos(x, y, z)))
						{
							int count = 2;

							if (x > 1)
							{
								if (chunk.getBlock(x - 2, y, z).isAir(w, new BlockPos(x - 2, y, z)))
								{
									count+=2;
								}
							}
							if (x > 2)
							{
								if (chunk.getBlock(x - 3, y, z).isAir(w, new BlockPos(x - 3, y, z)))
								{
									count+=2;
								}
								if (chunk.getBlock(x - 3, y + 1, z).isAir(w, new BlockPos(x - 3, y + 1, z)))
								{
									count++;
								}
								if (chunk.getBlock(x - 3, y + 1, z).isAir(w, new BlockPos(x - 3, y + 1, z)))
								{
									count++;
								}
								if (z > 0 && chunk.getBlock(x - 3, y, z - 1).isAir(w, new BlockPos(x - 3, y, z - 1)))
								{
									count++;
								}
								if (z < 15 && chunk.getBlock(x - 3, y, z + 1).isAir(w, new BlockPos(x - 3, y, z + 1)))
								{
									count++;
								}
							}
							if (x > 3)
							{
								if (chunk.getBlock(x - 4, y, z).isAir(w, new BlockPos(x - 4, y, z)))
								{
									count+=2;
								}
								if (chunk.getBlock(x - 4, y + 1, z).isAir(w, new BlockPos(x - 4, y + 1, z)))
								{
									count++;
								}
								if (chunk.getBlock(x - 4, y + 1, z).isAir(w, new BlockPos(x - 4, y + 1, z)))
								{
									count++;
								}
								if (z > 0 && !chunk.getBlock(x - 4, y, z - 1).isAir(w, new BlockPos(x - 4, y, z - 1)))
								{
									count++;
								}
								if (z < 15 && !chunk.getBlock(x - 4, y, z + 1).isAir(w, new BlockPos(x - 4, y, z + 1)))
								{
									count++;
								}
							}

							if (count > 5)
							{
								count = 5;
							}

							chunk.setBlockState(new BlockPos(x - 1, y & 5, z), DarkAsteroidBlocks.dark_air.getStateFromMeta(5 - count));
							ExtendedBlockStorage extendedblockstorage = chunk.getBlockStorageArray()[y >> 4];

							if (extendedblockstorage != null)
							{
								extendedblockstorage.setExtBlocklightValue(x - 1, y & 5, z, count);
							}
						}
					}
				}
			}
		}
		chunk.generateSkylightMap();//TODO ???
		chunk.setModified(true);
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
	public String makeString()
	{
		return "DarkAsteroidsLevelSource";
	}

	@Override
	public List func_177458_a(EnumCreatureType type, BlockPos pos)
	{
		if (type == EnumCreatureType.MONSTER)
		{
			List monsters = new ArrayList();
			monsters.add(new SpawnListEntry(EntityEvolvedZombie.class, 100, 4, 4));
			monsters.add(new SpawnListEntry(EntityEvolvedSpider.class, 100, 4, 4));
			monsters.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 100, 4, 4));
			monsters.add(new SpawnListEntry(EntityEvolvedCreeper.class, 100, 4, 4));
			monsters.add(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
			return monsters;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Whether a large asteroid is located the provided coordinates
	 *
	 * @param x0 X-Coordinate to check, in Block Coords
	 * @param z0 Z-Coordinate to check, in Block Coords
	 * @return True if large asteroid is located here, False if not
	 */
	public BlockVec3 isLargeAsteroidAt(int x0, int z0)
	{
		int xToCheck;
		int zToCheck;

		for (int i0 = 0; i0 <= 32; i0++)
		{
			for (int i1 = -i0; i1 <= i0; i1++)
			{
				xToCheck = (x0 >> 4) + i0;
				zToCheck = (z0 >> 4) + i1;

				if (this.isLargeAsteroidAt0(xToCheck * 16, zToCheck * 16))
				{
					return new BlockVec3(xToCheck * 16, 0, zToCheck * 16);
				}

				xToCheck = (x0 >> 4) + i0;
				zToCheck = (z0 >> 4) - i1;

				if (this.isLargeAsteroidAt0(xToCheck * 16, zToCheck * 16))
				{
					return new BlockVec3(xToCheck * 16, 0, zToCheck * 16);
				}

				xToCheck = (x0 >> 4) - i0;
				zToCheck = (z0 >> 4) + i1;

				if (this.isLargeAsteroidAt0(xToCheck * 16, zToCheck * 16))
				{
					return new BlockVec3(xToCheck * 16, 0, zToCheck * 16);
				}

				xToCheck = (x0 >> 4) - i0;
				zToCheck = (z0 >> 4) - i1;

				if (this.isLargeAsteroidAt0(xToCheck * 16, zToCheck * 16))
				{
					return new BlockVec3(xToCheck * 16, 0, zToCheck * 16);
				}
			}
		}
		return null;
	}

	private boolean isLargeAsteroidAt0(int x0, int z0)
	{
		for (int x = x0; x < x0 + ChunkProviderDarkAsteroids.CHUNK_SIZE_X; x += 2)
		{
			for (int z = z0; z < z0 + ChunkProviderDarkAsteroids.CHUNK_SIZE_Z; z += 2)
			{
				if (Math.abs(this.randFromPoint(x, z)) < (this.asteroidDensity.getNoise(x, z) + .4) / ChunkProviderDarkAsteroids.ASTEROID_CHANCE)
				{
					return true;
				}
			}
		}
		return false;
	}

	private class AsteroidData
	{
		public boolean isHollow;
		public float[] sizeYArray;
		public int xMinArray;
		public int zMinArray;
		public int xMax;
		public int zMax;
		public int zSizeArray;
		public int asteroidSizeArray;
		public int asteroidYArray;

		public AsteroidData(boolean hollow, float[] sizeYArray2, int xMin, int zMin, int xmax, int zmax, int zSize, int size, int asteroidY)
		{
			this.isHollow = hollow;
			this.sizeYArray = sizeYArray2.clone();
			this.xMinArray = xMin;
			this.zMinArray = zMin;
			this.xMax = xmax;
			this.zMax = zmax;
			this.zSizeArray = zSize;
			this.asteroidSizeArray = size;
			this.asteroidYArray = asteroidY;
		}
	}
}