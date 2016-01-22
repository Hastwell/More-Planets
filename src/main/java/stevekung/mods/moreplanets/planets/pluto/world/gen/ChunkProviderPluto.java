/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.world.gen;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
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
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.pluto.entities.EntityPlutoAlien;
import stevekung.mods.moreplanets.planets.pluto.world.gen.dungeon.RoomBossPluto;
import stevekung.mods.moreplanets.planets.pluto.world.gen.dungeon.RoomChestsPluto;
import stevekung.mods.moreplanets.planets.pluto.world.gen.dungeon.RoomTreasurePluto;

public class ChunkProviderPluto extends ChunkProviderBaseMP
{
    private BiomeDecoratorPluto biomeDecorator = new BiomeDecoratorPluto();
    private BiomeGenBase[] biomesForGeneration = { BiomeGenBaseMP.basePlanetBiome };
    private MapGenCavesMP caveGenerator = new MapGenCavesMP(PlutoBlocks.pluto_block, this.getBlockMetadata());
    private MapGenDungeon dungeonGenerator = new MapGenDungeon(PlutoBlocks.pluto_block, 8, 8, 16, 4);

    public ChunkProviderPluto(World world, long seed, boolean genFeature)
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
        this.dungeonGenerator.otherRooms.add(new RoomChestsPluto(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsPluto(null, 0, 0, 0, null));
        this.dungeonGenerator.bossRooms.add(new RoomBossPluto(null, 0, 0, 0, null));
        this.dungeonGenerator.treasureRooms.add(new RoomTreasurePluto(null, 0, 0, 0, null));
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
        BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(pos.add(16, 0, 16));
        this.rand.setSeed(this.worldObj.getSeed());
        long var7 = this.rand.nextLong() / 2L * 2L + 1L;
        long var9 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(chunkX * var7 + chunkZ * var9 ^ this.worldObj.getSeed());
        this.dungeonGenerator.handleTileEntities(this.rand);
        this.biomeDecorator.decorate(this.worldObj, this.rand, biome, pos);

        for (int i = 0; i < 8; ++i)
        {
            new WorldGenSpaceDungeons(PlutoBlocks.pluto_ancient_chest, PlutoBlocks.pluto_block, MPBlocks.space_mossy_cobblestone, 9).generate(this.worldObj, this.rand, pos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(256), this.rand.nextInt(16) + 8));
        }
        for (int k1 = 0; k1 < 16; ++k1)
        {
            for (int l1 = 0; l1 < 16; ++l1)
            {
                pos = pos.add(8, 0, 8);

                if (this.worldObj.canSnowAt(this.worldObj.getPrecipitationHeight(pos.add(k1, 0, l1)), true))
                {
                    this.worldObj.setBlockState(this.worldObj.getPrecipitationHeight(pos.add(k1, 0, l1)), EuropaBlocks.europa_snow_layer.getDefaultState(), 2);
                }
            }
        }
        BlockFalling.fallInstantly = false;
    }

    @Override
    public List func_177458_a(EnumCreatureType type, BlockPos pos)
    {
        if (type == EnumCreatureType.MONSTER)
        {
            List monsters = new ArrayList();
            monsters.add(new SpawnListEntry(EntityPlutoAlien.class, 50, 4, 4));
            return monsters;
        }
        return super.func_177458_a(type, pos);
    }

    @Override
    protected String getName()
    {
        return "Pluto";
    }

    @Override
    protected Block getBaseBlock()
    {
        return PlutoBlocks.pluto_block;
    }

    @Override
    protected int[] getBlockMetadata()
    {
        return new int[] { 0, 1, 2 };
    }
}