/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.world.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomEmptyMP;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityBearry;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityBerry;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityCreamCat;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityCreamSlime;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityGrappy;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityJellySlime;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityKiwi;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityLemonDuck;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityMarshmallow;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityMelon;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityStarfish;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityStrawberryChicken;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityTomato;
import stevekung.mods.moreplanets.planets.fronos.world.gen.dungeon.RoomBossFronos;
import stevekung.mods.moreplanets.planets.fronos.world.gen.dungeon.RoomChestsFronos;
import stevekung.mods.moreplanets.planets.fronos.world.gen.dungeon.RoomSpawnerFronos;
import stevekung.mods.moreplanets.planets.fronos.world.gen.dungeon.RoomTreasureFronos;

public class ChunkProviderFronos extends ChunkProviderGenerate
{
	private Random rand;
	private NoiseGeneratorOctaves noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	private World worldObj;
	private double[] stoneNoise;
	private MapGenCaveFronos caveGenerator;
	private MapGenCavernFronos cavernGenerator;
	public BiomeDecoratorFronosOre biomedecoratorplanet = new BiomeDecoratorFronosOre();
	private MapGenFronosVillage villageGenerator = new MapGenFronosVillage();
	private MapGenFronosRavine ravineGenerator = new MapGenFronosRavine();
	private BiomeGenBase[] biomesForGeneration;
	double[] noise3;
	double[] noise1;
	double[] noise2;
	double[] noise5;
	double[] noise6;
	float[] squareTable;
	private NoiseGeneratorOctaves field_147431_j;
	private NoiseGeneratorOctaves field_147432_k;
	private NoiseGeneratorOctaves field_147429_l;
	private NoiseGeneratorPerlin field_147430_m;
	private double[] terrainCalcs;
	private float[] parabolicField;
	double[] field_147427_d;
	double[] field_147428_e;
	double[] field_147425_f;
	double[] field_147426_g;
	int[][] field_73219_j = new int[32][32];

	private MapGenDungeon dungeonGenerator = new MapGenDungeon(FronosBlocks.fronos_block, 14, 8, 24, 4);
	{
		this.dungeonGenerator.otherRooms.add(new RoomEmptyMP(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomChestsFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomChestsFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.bossRooms.add(new RoomBossFronos(null, 0, 0, 0, null));
		this.dungeonGenerator.treasureRooms.add(new RoomTreasureFronos(null, 0, 0, 0, null));
	}

	public ChunkProviderFronos(World world, long seed, boolean genFeature)
	{
		super(world, seed, genFeature, "");
		this.stoneNoise = new double[256];
		this.caveGenerator = new MapGenCaveFronos();
		this.cavernGenerator = new MapGenCavernFronos();
		this.worldObj = world;
		this.rand = new Random(seed);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
		this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
		this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
		this.terrainCalcs = new double[825];
		this.parabolicField = new float[25];

		for (int j = -2; j <= 2; j++)
		{
			for (int k = -2; k <= 2; k++)
			{
				float f = 10.0F / MathHelper.sqrt_float(j * j + k * k + 0.2F);
				this.parabolicField[j + 2 + (k + 2) * 5] = f;
			}
		}
	}

	@Override
	public Chunk provideChunk(int x, int z)
	{
		ChunkPrimer primer = new ChunkPrimer();
		this.rand.setSeed(x * 341873128712L + z * 132897987541L);
		this.generateTerrain(x, z, primer);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		this.func_180517_a(x, z, primer, this.biomesForGeneration);
		this.caveGenerator.generate(this, this.worldObj, x, z, primer);
		this.cavernGenerator.generate(this, this.worldObj, x, z, primer);
		this.ravineGenerator.func_175792_a(this, this.worldObj, x, z, primer);
		this.dungeonGenerator.generateUsingArrays(this.worldObj, this.worldObj.getSeed(), x * 16, 30, z * 16, x, z, primer);

		Chunk chunk = new Chunk(this.worldObj, primer, x, z);
		byte[] chunkBiomes = chunk.getBiomeArray();

		for (int i = 0; i < chunkBiomes.length; i++)
		{
			chunkBiomes[i] = (byte)this.biomesForGeneration[i].biomeID;
		}
		chunk.generateSkylightMap();
		return chunk;
	}

	public void generateTerrain(int chunkX, int chunkZ, ChunkPrimer chunk)
	{
		byte seaLevel = 63;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
		this.makeLandPerBiome2(chunkX * 4, 0, chunkZ * 4);

		for (int k = 0; k < 4; k++)
		{
			int l = k * 5;
			int i1 = (k + 1) * 5;

			for (int j1 = 0; j1 < 4; j1++)
			{
				int k1 = (l + j1) * 33;
				int l1 = (l + j1 + 1) * 33;
				int i2 = (i1 + j1) * 33;
				int j2 = (i1 + j1 + 1) * 33;

				for (int k2 = 0; k2 < 32; k2++)
				{
					double d0 = 0.125D;
					double d1 = this.terrainCalcs[k1 + k2];
					double d2 = this.terrainCalcs[l1 + k2];
					double d3 = this.terrainCalcs[i2 + k2];
					double d4 = this.terrainCalcs[j2 + k2];
					double d5 = (this.terrainCalcs[k1 + k2 + 1] - d1) * d0;
					double d6 = (this.terrainCalcs[l1 + k2 + 1] - d2) * d0;
					double d7 = (this.terrainCalcs[i2 + k2 + 1] - d3) * d0;
					double d8 = (this.terrainCalcs[j2 + k2 + 1] - d4) * d0;

					for (int l2 = 0; l2 < 8; l2++)
					{
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for (int i3 = 0; i3 < 4; ++i3)
						{
							int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
							short short1 = 256;
							j3 -= short1;
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double d15 = d10 - d16;

							for (int k3 = 0; k3 < 4; ++k3)
							{
								if ((d15 += d16) > 0.0D)
								{
									chunk.setBlockState(j3 += short1, FronosBlocks.fronos_block.getDefaultState());
								}
								else if (k2 * 8 + l2 < seaLevel)
								{
									chunk.setBlockState(j3 += short1, Blocks.water.getDefaultState());
								}
								else
								{
									chunk.setBlockState(j3 += short1, Blocks.air.getDefaultState());
								}
							}
							d10 += d12;
							d11 += d13;
						}
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}

	private void makeLandPerBiome2(int x, int zero, int z)
	{
		this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
		this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, x, zero, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, x, zero, z, 5, 33, 5, 684.41200000000003D, 684.41200000000003D, 684.41200000000003D);
		this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, x, zero, z, 5, 33, 5, 684.41200000000003D, 684.41200000000003D, 684.41200000000003D);
		int terrainIndex = 0;
		int noiseIndex = 0;

		for (int ax = 0; ax < 5; ax++)
		{
			for (int az = 0; az < 5; az++)
			{
				float totalVariation = 0.0F;
				float totalHeight = 0.0F;
				float totalFactor = 0.0F;
				byte two = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[ax + 2 + (az + 2) * 10];

				for (int ox = -two; ox <= two; ox++)
				{
					for (int oz = -two; oz <= two; oz++)
					{
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[ax + ox + 2 + (az + oz + 2) * 10];
						float rootHeight = this.settings.biomeDepthOffSet + biomegenbase1.minHeight * this.settings.biomeDepthWeight;
						float heightVariation = this.settings.biomeScaleOffset + biomegenbase1.maxHeight * this.settings.biomeScaleWeight;
						float heightFactor = this.parabolicField[ox + 2 + (oz + 2) * 5] / (rootHeight + 2.0F);

						if (biomegenbase1.minHeight > biomegenbase.minHeight)
						{
							heightFactor /= 2.0F;
						}
						totalVariation += heightVariation * heightFactor;
						totalHeight += rootHeight * heightFactor;
						totalFactor += heightFactor;
					}
				}
				totalVariation /= totalFactor;
				totalHeight /= totalFactor;
				totalVariation = totalVariation * 0.9F + 0.1F;
				totalHeight = (totalHeight * 4.0F - 1.0F) / 8.0F;
				double terrainNoise = this.field_147426_g[noiseIndex] / 8000.0D;

				if (terrainNoise < 0.0D)
				{
					terrainNoise = -terrainNoise * 0.3D;
				}

				terrainNoise = terrainNoise * 3.0D - 2.0D;

				if (terrainNoise < 0.0D)
				{
					terrainNoise /= 2.0D;

					if (terrainNoise < -1.0D)
					{
						terrainNoise = -1.0D;
					}
					terrainNoise /= 1.4D;
					terrainNoise /= 2.0D;
				}
				else
				{
					if (terrainNoise > 1.0D)
					{
						terrainNoise = 1.0D;
					}
					terrainNoise /= 8.0D;
				}
				noiseIndex++;
				double heightCalc = totalHeight;
				double variationCalc = totalVariation;
				heightCalc += terrainNoise * 0.2D;
				heightCalc = heightCalc * 8.5D / 8.0D;
				double d5 = 8.5D + heightCalc * 4.0D;

				for (int ay = 0; ay < 33; ay++)
				{
					double d6 = (ay - d5) * 12.0D * 128.0D / 256.0D / variationCalc;

					if (d6 < 0.0D)
					{
						d6 *= 4.0D;
					}
					double d7 = this.field_147428_e[terrainIndex] / 512.0D;
					double d8 = this.field_147425_f[terrainIndex] / 512.0D;
					double d9 = (this.field_147427_d[terrainIndex] / 10.0D + 1.0D) / 2.0D;
					double terrainCalc = MathHelper.denormalizeClamp(d7, d8, d9) - d6;

					if (ay > 29)
					{
						double d11 = (ay - 29) / 3.0F;
						terrainCalc = terrainCalc * (1.0D - d11) + -10.0D * d11;
					}
					this.terrainCalcs[terrainIndex] = terrainCalc;
					terrainIndex++;
				}
			}
		}
	}

	@Override
	public void func_180517_a(int chunkX, int chunkZ, ChunkPrimer chunk, BiomeGenBase[] biomeGen)
	{
		double d0 = 0.03125D;
		this.stoneNoise = this.field_147430_m.func_151599_a(this.stoneNoise, chunkX * 16, chunkZ * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

		for (int z = 0; z < 16; z++)
		{
			for (int x = 0; x < 16; x++)
			{
				BiomeGenBase biomegenbase = biomeGen[x + z * 16];
				biomegenbase.genTerrainBlocks(this.worldObj, this.rand, chunk, chunkX * 16 + z, chunkZ * 16 + x, this.stoneNoise[x + z * 16]);
			}
		}
	}

	@Override
	public boolean chunkExists(int x, int z)
	{
		return true;
	}

	@Override
	public void populate(IChunkProvider chunk, int x, int z)
	{
		BlockFalling.fallInstantly = true;
		int k = x * 16;
		int l = z * 16;
		BlockPos blockpos = new BlockPos(k, 0, l);
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(blockpos.add(16, 0, 16));
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(x * i1 + z * j1 ^ this.worldObj.getSeed());
		biomegenbase.decorate(this.worldObj, this.rand, new BlockPos(k, 0, l));
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
		BlockFalling.fallInstantly = false;
	}

	public void decoratePlanet(World world, Random rand, int x, int z)
	{
		this.biomedecoratorplanet.decorate(world, rand, x, z);
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
		return "FronosLevelSource";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List func_177458_a(EnumCreatureType type, BlockPos pos)
	{
		if (type == EnumCreatureType.MONSTER)
		{
			List monsters = new ArrayList();

			if (!ConfigManagerMP.allowMobCreatureSpawningOnFronos)
			{
				monsters.add(new SpawnListEntry(EntityEvolvedZombie.class, 100, 4, 4));
				monsters.add(new SpawnListEntry(EntityEvolvedSpider.class, 100, 4, 4));
				monsters.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 100, 4, 4));
				monsters.add(new SpawnListEntry(EntityEvolvedCreeper.class, 100, 4, 4));
				monsters.add(new SpawnListEntry(EntityEvolvedEnderman.class, 100, 1, 4));
			}
			else
			{
				monsters.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
				monsters.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
				monsters.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
				monsters.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
				monsters.add(new SpawnListEntry(EntityEnderman.class, 100, 1, 4));
				monsters.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));
			}
			monsters.add(new SpawnListEntry(EntityCreamSlime.class, 100, 4, 4));
			monsters.add(new SpawnListEntry(EntityJellySlime.class, 100, 4, 4));
			return monsters;
		}
		else if (type == EnumCreatureType.CREATURE)
		{
			List creatures = new ArrayList();
			creatures.add(new SpawnListEntry(EntityBearry.class, 8, 4, 4));
			creatures.add(new SpawnListEntry(EntityBerry.class, 8, 4, 4));
			creatures.add(new SpawnListEntry(EntityMarshmallow.class, 8, 4, 4));
			creatures.add(new SpawnListEntry(EntityKiwi.class, 8, 4, 4));
			creatures.add(new SpawnListEntry(EntityLemonDuck.class, 8, 4, 4));
			creatures.add(new SpawnListEntry(EntityTomato.class, 8, 4, 4));
			creatures.add(new SpawnListEntry(EntityMelon.class, 8, 4, 4));
			creatures.add(new SpawnListEntry(EntityGrappy.class, 12, 4, 4));
			creatures.add(new SpawnListEntry(EntityCreamCat.class, 2, 2, 2));
			creatures.add(new SpawnListEntry(EntityStrawberryChicken.class, 10, 4, 4));
			creatures.add(new SpawnListEntry(EntityStarfish.class, 8, 4, 4));

			if (ConfigManagerMP.allowMobCreatureSpawningOnFronos == true)
			{
				creatures.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
				creatures.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
				creatures.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
				creatures.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
			}
			else
			{
				return null;
			}
			return creatures;
		}
		else if (type == EnumCreatureType.WATER_CREATURE)
		{
			List waterCreatures = new ArrayList();
			waterCreatures.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
			return waterCreatures;
		}
		return null;
	}

	@Override
	public int getLoadedChunkCount()
	{
		return 0;
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z)
	{
		this.villageGenerator.func_175792_a(this, this.worldObj, x, z, (ChunkPrimer) null);
	}

	@Override
	public boolean unloadQueuedChunks()
	{
		return false;
	}

	@Override
	public void saveExtraData() {}

	@Override
	public BlockPos getStrongholdGen(World world, String string, BlockPos pos)
	{
		return null;
	}
}