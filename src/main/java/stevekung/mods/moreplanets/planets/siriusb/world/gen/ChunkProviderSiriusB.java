/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.world.gen;

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
import stevekung.mods.moreplanets.common.world.gen.feature.WorldGenSpaceDungeons;
import stevekung.mods.moreplanets.common.world.gen.feature.WorldGenSplashBlock;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusBlaze;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusCreeper;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusMagmaCube;
import stevekung.mods.moreplanets.planets.siriusb.world.gen.dungeon.RoomBossSiriusB;
import stevekung.mods.moreplanets.planets.siriusb.world.gen.dungeon.RoomChestsSiriusB;
import stevekung.mods.moreplanets.planets.siriusb.world.gen.dungeon.RoomSpawnerSiriusB;
import stevekung.mods.moreplanets.planets.siriusb.world.gen.dungeon.RoomTreasureSiriusB;

public class ChunkProviderSiriusB extends ChunkProviderBaseMP
{
    private BiomeDecoratorSiriusB biomeDecorator = new BiomeDecoratorSiriusB();
    private BiomeGenBase[] biomesForGeneration = { BiomeGenBaseMP.basePlanetBiome };
    private MapGenCavesMP caveGenerator = new MapGenCavesMP(SiriusBBlocks.sirius_b_block, this.getBlockMetadata());
    private MapGenDungeon dungeonGenerator = new MapGenDungeon(SiriusBBlocks.sirius_b_block, 9, 8, 24, 4);

    public ChunkProviderSiriusB(World world, long seed, boolean genFeature)
    {
        super(world, seed, genFeature);
        this.dungeonGenerator.otherRooms.add(new RoomEmptyMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.bossRooms.add(new RoomBossSiriusB(null, 0, 0, 0, null));
        this.dungeonGenerator.treasureRooms.add(new RoomTreasureSiriusB(null, 0, 0, 0, null));
    }

    @Override
    public Chunk provideChunk(int chunkX, int chunkZ)
    {
        ChunkPrimer primer = new ChunkPrimer();
        this.rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        this.generateTerrain(chunkX, chunkZ, primer);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
        this.func_180517_a(chunkX, chunkZ, primer, this.biomesForGeneration);
        this.dungeonGenerator.generateUsingArrays(this.worldObj, this.worldObj.getSeed(), chunkX * 16, 25, chunkZ * 16, chunkX, chunkZ, primer);
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
        this.rand.setSeed(chunkX * var7 + chunkZ * var9 ^ this.worldObj.getSeed());
        this.dungeonGenerator.handleTileEntities(this.rand);
        this.biomeDecorator.decorate(this.worldObj, this.rand, BiomeGenBaseMP.basePlanetBiome, pos);

        for (int i = 0; i < 4; i++)
        {
            if (this.rand.nextInt(5) == 0)
            {
                new WorldGenSplashBlock(SiriusBBlocks.sirius_b_block, 7, SiriusBBlocks.sirius_b_block, 0).generate(this.worldObj, this.rand, pos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128 - 16) + 16, this.rand.nextInt(16) + 8));
            }
        }
        for (int i = 0; i < 8; ++i)
        {
            new WorldGenSpaceDungeons(SiriusBBlocks.sirius_b_ancient_chest, SiriusBBlocks.sirius_b_block, MPBlocks.space_mossy_cobblestone, 6).generate(this.worldObj, this.rand, pos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(256), this.rand.nextInt(16) + 8));
        }
        BlockFalling.fallInstantly = false;
    }

    @Override
    public List func_177458_a(EnumCreatureType type, BlockPos pos)
    {
        if (type == EnumCreatureType.MONSTER)
        {
            List monsters = new ArrayList();
            monsters.add(new BiomeGenBase.SpawnListEntry(EntitySiriusBlaze.class, 100, 4, 4));
            monsters.add(new BiomeGenBase.SpawnListEntry(EntitySiriusCreeper.class, 100, 4, 4));
            monsters.add(new BiomeGenBase.SpawnListEntry(EntitySiriusMagmaCube.class, 100, 4, 4));
            return monsters;
        }
        return null;
    }

    @Override
    protected String getName()
    {
        return "SiriusB";
    }

    @Override
    protected Block getBaseBlock()
    {
        return SiriusBBlocks.sirius_b_block;
    }

    @Override
    protected int[] getBlockMetadata()
    {
        return new int[] { 0, 1, 2 };
    }
}