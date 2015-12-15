/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.world.gen;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureStart;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaGuardian;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class StructureEuropaOceanMonument extends MapGenStructure
{
    private int field_175800_f;
    private int field_175801_g;
    public static List field_175802_d = Arrays.asList(new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean, BiomeGenBase.river, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver});
    private static List field_175803_h = Lists.newArrayList();

    public StructureEuropaOceanMonument()
    {
        this.field_175800_f = 32;
        this.field_175801_g = 5;
    }

    public StructureEuropaOceanMonument(Map map)
    {
        this();
        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();

            if (((String)entry.getKey()).equals("spacing"))
            {
                this.field_175800_f = MathHelper.parseIntWithDefaultAndMax((String)entry.getValue(), this.field_175800_f, 1);
            }
            else if (((String)entry.getKey()).equals("separation"))
            {
                this.field_175801_g = MathHelper.parseIntWithDefaultAndMax((String)entry.getValue(), this.field_175801_g, 1);
            }
        }
    }

    @Override
    public String getStructureName()
    {
        return "EuropaMonument";
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)
    {
        int k = chunkX;
        int l = chunkZ;

        if (chunkX < 0)
        {
            chunkX -= this.field_175800_f - 1;
        }
        if (chunkZ < 0)
        {
            chunkZ -= this.field_175800_f - 1;
        }

        int i1 = chunkX / this.field_175800_f;
        int j1 = chunkZ / this.field_175800_f;
        Random random = this.worldObj.setRandomSeed(i1, j1, 10387313);
        i1 *= this.field_175800_f;
        j1 *= this.field_175800_f;
        i1 += (random.nextInt(this.field_175800_f - this.field_175801_g) + random.nextInt(this.field_175800_f - this.field_175801_g)) / 2;
        j1 += (random.nextInt(this.field_175800_f - this.field_175801_g) + random.nextInt(this.field_175800_f - this.field_175801_g)) / 2;

        if (k == i1 && l == j1)
        {
            if (this.worldObj.getWorldChunkManager().func_180300_a(new BlockPos(k * 16 + 8, 64, l * 16 + 8), (BiomeGenBase)null) != BiomeGenBase.deepOcean)
            {
                return false;
            }

            boolean flag = this.worldObj.getWorldChunkManager().areBiomesViable(k * 16 + 8, l * 16 + 8, 29, field_175802_d);

            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ)
    {
        MPLog.debug("Generating Europa Ocean Monument at x : %s, z : %s", chunkX * 16, chunkZ * 16);
        return new StructureEuropaOceanMonument.StartMonument(this.worldObj, this.rand, chunkX, chunkZ);
    }

    public List func_175799_b()
    {
        return field_175803_h;
    }

    static
    {
        field_175803_h.add(new SpawnListEntry(EntityEuropaGuardian.class, 1, 2, 4));
    }

    public static class StartMonument extends StructureStart
    {
        private Set field_175791_c = Sets.newHashSet();
        private boolean field_175790_d;

        public StartMonument() {}

        public StartMonument(World world, Random rand, int chunkX, int chunkZ)
        {
            super(chunkX, chunkZ);
            this.func_175789_b(world, rand, chunkX, chunkZ);
        }

        private void func_175789_b(World world, Random rand, int chunkX, int chunkZ)
        {
            rand.setSeed(world.getSeed());
            long k = rand.nextLong();
            long l = rand.nextLong();
            long i1 = chunkX * k;
            long j1 = chunkZ * l;
            rand.setSeed(i1 ^ j1 ^ world.getSeed());
            int k1 = chunkX * 16 + 8 - 29;
            int l1 = chunkZ * 16 + 8 - 29;
            EnumFacing enumfacing = EnumFacing.Plane.HORIZONTAL.random(rand);
            this.components.add(new StructureEuropaOceanMonumentPieces.MonumentBuilding(rand, k1, l1, enumfacing));
            this.updateBoundingBox();
            this.field_175790_d = true;
        }

        @Override
        public void generateStructure(World world, Random rand, StructureBoundingBox box)
        {
            if (!this.field_175790_d)
            {
                this.components.clear();
                this.func_175789_b(world, rand, this.func_143019_e(), this.func_143018_f());
            }
            super.generateStructure(world, rand, box);
        }

        @Override
        public boolean func_175788_a(ChunkCoordIntPair chunk)
        {
            return this.field_175791_c.contains(chunk) ? false : super.func_175788_a(chunk);
        }

        @Override
        public void func_175787_b(ChunkCoordIntPair chunk)
        {
            super.func_175787_b(chunk);
            this.field_175791_c.add(chunk);
        }

        @Override
        public void func_143022_a(NBTTagCompound nbt)
        {
            super.func_143022_a(nbt);
            NBTTagList nbttaglist = new NBTTagList();
            Iterator iterator = this.field_175791_c.iterator();

            while (iterator.hasNext())
            {
                ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setInteger("X", chunkcoordintpair.chunkXPos);
                nbttagcompound1.setInteger("Z", chunkcoordintpair.chunkZPos);
                nbttaglist.appendTag(nbttagcompound1);
            }
            nbt.setTag("Processed", nbttaglist);
        }

        @Override
        public void func_143017_b(NBTTagCompound nbt)
        {
            super.func_143017_b(nbt);

            if (nbt.hasKey("Processed", 9))
            {
                NBTTagList nbttaglist = nbt.getTagList("Processed", 10);

                for (int i = 0; i < nbttaglist.tagCount(); ++i)
                {
                    NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
                    this.field_175791_c.add(new ChunkCoordIntPair(nbttagcompound1.getInteger("X"), nbttagcompound1.getInteger("Z")));
                }
            }
        }
    }
}