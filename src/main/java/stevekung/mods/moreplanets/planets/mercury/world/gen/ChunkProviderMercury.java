/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.mercury.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import stevekung.mods.moreplanets.common.world.biome.BiomeGenBaseMP;
import stevekung.mods.moreplanets.common.world.gen.ChunkProviderBaseMP;
import stevekung.mods.moreplanets.common.world.gen.MapGenCavesMP;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;

public class ChunkProviderMercury extends ChunkProviderBaseMP
{
    private BiomeDecoratorMercury biomeDecorator = new BiomeDecoratorMercury();
    private BiomeGenBase[] biomesForGeneration = { BiomeGenBaseMercury.basePlanetBiome };
    private MapGenCavesMP caveGenerator = new MapGenCavesMP(MercuryBlocks.mercury_block, this.getBlockMetadata());
    //private MapGenDungeon dungeonGenerator = new MapGenDungeon(MercuryBlocks.mercury_block, 11, 8, 16, 4);

    public ChunkProviderMercury(World world, long seed, boolean genFeature)
    {
        super(world, seed, genFeature);
        /*this.dungeonGenerator.otherRooms.add(new RoomEmptyMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsMercury(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsMercury(null, 0, 0, 0, null));
        this.dungeonGenerator.treasureRooms.add(new RoomTreasureEmptyMP(null, 0, 0, 0, null));
        this.dungeonGenerator.bossRooms.add(new RoomBossMercury(null, 0, 0, 0, null));*/
    }

    @Override
    public Chunk provideChunk(int chunkX, int chunkZ)
    {
        ChunkPrimer primer = new ChunkPrimer();
        this.rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        this.generateTerrain(chunkX, chunkZ, primer);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
        this.createCraters(chunkX, chunkZ, primer);
        this.replaceBlocksForBiome(chunkX, chunkZ, primer, this.biomesForGeneration);
        this.caveGenerator.generate(this, this.worldObj, chunkX, chunkZ, primer);
        //this.dungeonGenerator.generateUsingArrays(this.worldObj, this.worldObj.getSeed(), chunkX * 16, 25, chunkZ * 16, chunkX, chunkZ, primer);
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
        //this.dungeonGenerator.handleTileEntities(this.rand);
        this.biomeDecorator.decorate(this.worldObj, this.rand, BiomeGenBaseMP.basePlanetBiome, pos);
        BlockFalling.fallInstantly = false;
    }

    @Override
    protected String getName()
    {
        return "Mercury";
    }

    @Override
    protected Block getBaseBlock()
    {
        return MercuryBlocks.mercury_block;
    }

    @Override
    protected int[] getBlockMetadata()
    {
        return new int[] { 0, 1, 2 };
    }
}