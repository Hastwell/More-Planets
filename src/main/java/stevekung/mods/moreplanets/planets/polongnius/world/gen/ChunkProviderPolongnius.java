/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.world.gen;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import stevekung.mods.moreplanets.common.world.biome.BiomeGenBaseMP;
import stevekung.mods.moreplanets.common.world.gen.ChunkProviderBaseMP;
import stevekung.mods.moreplanets.common.world.gen.MapGenCavesMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomEmptyMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomSpawnerMP;
import stevekung.mods.moreplanets.common.world.gen.feature.WorldGenSpaceDungeons;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityCheeseCow;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityCheeseSlime;
import stevekung.mods.moreplanets.planets.polongnius.world.gen.dungeon.RoomBossPolongnius;
import stevekung.mods.moreplanets.planets.polongnius.world.gen.dungeon.RoomChestsPolongnius;
import stevekung.mods.moreplanets.planets.polongnius.world.gen.dungeon.RoomTreasurePolongnius;

public class ChunkProviderPolongnius extends ChunkProviderBaseMP
{
    private BiomeDecoratorPolongnius biomeDecorator = new BiomeDecoratorPolongnius();
    private BiomeGenBase[] biomesForGeneration = { BiomeGenBaseMP.basePlanetBiome };
    private MapGenCavesMP caveGenerator = new MapGenCavesMP(PolongniusBlocks.polongnius_block, this.getBlockMetadata());
    private MapGenDungeon dungeonGenerator = new MapGenDungeon(PolongniusBlocks.polongnius_block, 13, 8, 24, 4);
    private MapGenDungeon dungeonGenerator2 = new MapGenDungeon(PolongniusBlocks.polongnius_block, 14, 8, 24, 4);

    public ChunkProviderPolongnius(World world, long seed, boolean genFeature)
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
        this.dungeonGenerator.otherRooms.add(new RoomChestsPolongnius(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsPolongnius(null, 0, 0, 0, null));
        this.dungeonGenerator.bossRooms.add(new RoomBossPolongnius(null, 0, 0, 0, null));
        this.dungeonGenerator.treasureRooms.add(new RoomTreasurePolongnius(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomEmptyMP(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomChestsPolongnius(null, 0, 0, 0, null));
        this.dungeonGenerator2.otherRooms.add(new RoomChestsPolongnius(null, 0, 0, 0, null));
        this.dungeonGenerator2.bossRooms.add(new RoomBossPolongnius(null, 0, 0, 0, null));
        this.dungeonGenerator2.treasureRooms.add(new RoomTreasurePolongnius(null, 0, 0, 0, null));
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
        this.dungeonGenerator.generateUsingArrays(this.worldObj, this.worldObj.getSeed(), chunkX * 16, 25, chunkZ * 16, chunkX, chunkZ, primer);
        this.dungeonGenerator2.generateUsingArrays(this.worldObj, this.worldObj.getSeed(), chunkX * 16, 25, chunkZ * 16, chunkX, chunkZ, primer);
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
        this.dungeonGenerator2.handleTileEntities(this.rand);
        this.biomeDecorator.decorate(this.worldObj, this.rand, BiomeGenBaseMP.basePlanetBiome, pos);

        for (int i = 0; i < 8; ++i)
        {
            new WorldGenSpaceDungeons(PolongniusBlocks.polongnius_ancient_chest, PolongniusBlocks.polongnius_block, MPBlocks.space_mossy_cobblestone, 1).generate(this.worldObj, this.rand, pos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(256), this.rand.nextInt(16) + 8));
        }
        BlockFalling.fallInstantly = false;
    }

    @Override
    public List func_177458_a(EnumCreatureType type, BlockPos pos)
    {
        if (type == EnumCreatureType.MONSTER)
        {
            List monsters = new ArrayList();
            monsters.add(new BiomeGenBase.SpawnListEntry(EntityCheeseSlime.class, 15, 2, 4));
            return monsters;
        }
        else if (type == EnumCreatureType.CREATURE)
        {
            List creatures = new ArrayList();
            creatures.add(new BiomeGenBase.SpawnListEntry(EntityCheeseCow.class, 8, 4, 4));
            return creatures;
        }
        return super.func_177458_a(type, pos);
    }

    @Override
    protected String getName()
    {
        return "Polongnius";
    }

    @Override
    protected Block getBaseBlock()
    {
        return PolongniusBlocks.polongnius_block;
    }

    @Override
    protected int[] getBlockMetadata()
    {
        return new int[] { 0, 1, 2 };
    }

    @Override
    protected int getCraterChance()
    {
        return 600;
    }
}