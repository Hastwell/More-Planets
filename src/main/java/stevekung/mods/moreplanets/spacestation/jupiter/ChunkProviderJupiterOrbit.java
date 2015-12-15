/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.spacestation.jupiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.core.tile.IMultiBlock;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import stevekung.mods.moreplanets.common.entities.EntityEvolvedWitch;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;
import stevekung.mods.moreplanets.spacestation.BiomeGenBaseOrbitMP;

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
    public Chunk provideChunk(int chunkX, int chunkZ)
    {
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        Chunk chunk = new Chunk(this.worldObj, chunkprimer, chunkX, chunkZ);
        byte[] biomesArray = chunk.getBiomeArray();

        for (int i = 0; i < biomesArray.length; ++i)
        {
            biomesArray[i] = (byte) BiomeGenBaseOrbitMP.spaceStation.biomeID;
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
            BlockPos pos1 = new BlockPos(x, 64, z);
            BlockPos pos2 = new BlockPos(x, 69, z);
            BlockPos pos3 = new BlockPos(x, 69, z + 3);
            BlockPos pos4 = new BlockPos(x, 69, z - 3);
            BlockPos pos5 = new BlockPos(x - 3, 69, z);
            BlockPos pos6 = new BlockPos(x - 2, 69, z);
            this.worldObj.setBlockState(pos1, GCBlocks.spaceStationBase.getDefaultState(), 3);
            this.worldObj.setBlockState(pos2, GCBlocks.solarPanel.getStateFromMeta(7), 3);
            this.worldObj.setBlockState(pos3, GCBlocks.solarPanel.getStateFromMeta(7), 3);
            this.worldObj.setBlockState(pos4, GCBlocks.solarPanel.getStateFromMeta(7), 3);
            this.worldObj.setBlockState(pos5, GCBlocks.machineTiered.getStateFromMeta(10), 3);
            this.worldObj.setBlockState(pos6, GCBlocks.aluminumWire.getStateFromMeta(1), 3);

            for (int z1 = -3; z1 < 4; z1++)
            {
                this.worldObj.setBlockState(new BlockPos(x - 1, 69, z1), GCBlocks.aluminumWire.getStateFromMeta(1), 3);
            }

            TileEntity tile = this.worldObj.getTileEntity(pos1);
            TileEntity tile1 = this.worldObj.getTileEntity(pos2);
            TileEntity tile2 = this.worldObj.getTileEntity(pos3);
            TileEntity tile3 = this.worldObj.getTileEntity(pos4);

            if (tile instanceof IMultiBlock)
            {
                ((IMultiBlock)tile).onCreate(this.worldObj, pos1);
            }
            if (tile1 instanceof IMultiBlock)
            {
                ((IMultiBlock)tile1).onCreate(this.worldObj, pos2);
            }
            if (tile2 instanceof IMultiBlock)
            {
                ((IMultiBlock)tile2).onCreate(this.worldObj, pos3);
            }
            if (tile3 instanceof IMultiBlock)
            {
                ((IMultiBlock)tile3).onCreate(this.worldObj, pos4);
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
            monsters.add(new SpawnListEntry(EntityEvolvedWitch.class, 10, 1, 4));
            return monsters;
        }
        return null;
    }
}