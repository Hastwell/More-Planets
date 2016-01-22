/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.world.gen;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import stevekung.mods.moreplanets.common.world.biome.BiomeGenBaseMP;
import stevekung.mods.moreplanets.common.world.gen.ChunkProviderHillsBaseMP;
import stevekung.mods.moreplanets.common.world.gen.MapGenCavesMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomEmptyMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomSpawnerMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomTreasureEmptyMP;
import stevekung.mods.moreplanets.common.world.gen.feature.WorldGenSpaceDungeons;
import stevekung.mods.moreplanets.common.world.gen.feature.WorldGenSplashBlock;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianBlaze;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianSlime;
import stevekung.mods.moreplanets.planets.venus.world.gen.dungeon.RoomBossVenus;
import stevekung.mods.moreplanets.planets.venus.world.gen.dungeon.RoomChestsVenus;

public class ChunkProviderVenus extends ChunkProviderHillsBaseMP
{
    private BiomeDecoratorVenus biomeDecorator = new BiomeDecoratorVenus();
    private BiomeGenBase[] biomesForGeneration = { BiomeGenBaseMP.basePlanetBiome };
    private MapGenCavesMP caveGenerator = new MapGenCavesMP(VenusBlocks.venus_block, this.getBlockMetadata());
    private MapGenVenusRavine ravineGenerator = new MapGenVenusRavine();
    private MapGenVenusVillage villageGenerator = new MapGenVenusVillage();
    private MapGenDungeon dungeonGenerator = new MapGenDungeon(VenusBlocks.venus_block, 14, 8, 24, 4);

    public ChunkProviderVenus(World world, long seed, boolean genFeature)
    {
        super(world, seed, genFeature);
        this.dungeonGenerator.otherRooms.add(new RoomEmptyMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsVenus(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsVenus(null, 0, 0, 0, null));
        this.dungeonGenerator.treasureRooms.add(new RoomTreasureEmptyMP(null, 0, 0, 0, null));
        this.dungeonGenerator.bossRooms.add(new RoomBossVenus(null, 0, 0, 0, null));
    }

    @Override
    public Chunk provideChunk(int chunkX, int chunkZ)
    {
        ChunkPrimer primer = new ChunkPrimer();
        this.rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        this.generateTerrain(chunkX, chunkZ, primer);
        this.createCraters(chunkX, chunkZ, primer);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
        this.func_180517_a(chunkX, chunkZ, primer, this.biomesForGeneration);
        this.caveGenerator.func_175792_a(this, this.worldObj, chunkX, chunkZ, primer);
        this.ravineGenerator.func_175792_a(this, this.worldObj, chunkX, chunkZ, primer);
        this.dungeonGenerator.generateUsingArrays(this.worldObj, this.worldObj.getSeed(), chunkX * 16, 30, chunkZ * 16, chunkX, chunkZ, primer);
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
        this.rand.setSeed(chunkX * var7 + chunkZ * var9 ^ this.worldObj.getSeed());
        this.dungeonGenerator.handleTileEntities(this.rand);
        this.biomeDecorator.decorate(this.worldObj, this.rand, BiomeGenBaseMP.basePlanetBiome, pos);
        this.villageGenerator.func_175794_a(this.worldObj, this.rand, new ChunkCoordIntPair(chunkX, chunkZ));

        for (int i = 0; i < 4; i++)
        {
            if (this.rand.nextInt(5) == 0)
            {
                new WorldGenSplashBlock(VenusBlocks.venus_smoke_geyser, 0, VenusBlocks.venus_block, 0).generate(this.worldObj, this.rand, pos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(256 - 16) + 16, this.rand.nextInt(16) + 8));
            }
        }
        for (int i = 0; i < 8; ++i)
        {
            new WorldGenSpaceDungeons(VenusBlocks.venus_ancient_chest, VenusBlocks.venus_block, MPBlocks.space_mossy_cobblestone, 7).generate(this.worldObj, this.rand, pos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(256), this.rand.nextInt(16) + 8));
        }
        BlockFalling.fallInstantly = false;
    }

    @Override
    public void recreateStructures(Chunk chunk, int x, int z)
    {
        this.villageGenerator.func_175792_a(this, this.worldObj, x, z, (ChunkPrimer) null);
    }

    @Override
    public List func_177458_a(EnumCreatureType type, BlockPos pos)
    {
        if (type == EnumCreatureType.MONSTER)
        {
            List monsters = new ArrayList();
            monsters.add(new BiomeGenBase.SpawnListEntry(EntityVenusianSlime.class, 50, 4, 4));
            monsters.add(new BiomeGenBase.SpawnListEntry(EntityVenusianBlaze.class, 100, 4, 4));
            return monsters;
        }
        return super.func_177458_a(type, pos);
    }

    @Override
    protected String getName()
    {
        return "Venus";
    }

    @Override
    protected Block getBaseBlock()
    {
        return VenusBlocks.venus_block;
    }

    @Override
    protected int[] getBlockMetadata()
    {
        return new int[] { 0, 1, 2 };
    }

    @Override
    protected int getCraterChance()
    {
        return 1000;
    }

    @Override
    protected int getTerrainHeight()
    {
        return 86;
    }

    @Override
    protected double[] getMountainHeightList()
    {
        return new double[] { 18, 36, 120, 64, 6, 10, 10 };
    }
}