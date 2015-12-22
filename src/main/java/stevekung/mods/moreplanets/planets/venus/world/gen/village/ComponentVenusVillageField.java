/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.world.gen.village;

import java.util.List;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVenusVillageField extends ComponentVenusVillage
{
    private int averageGroundLevel = -1;

    public ComponentVenusVillageField() {}

    public ComponentVenusVillageField(ComponentVenusVillageStartPiece component, int type, StructureBoundingBox box, EnumFacing facing)
    {
        super(component, type);
        this.coordBaseMode = facing;
        this.boundingBox = box;
    }

    @Override
    protected void writeStructureToNBT(NBTTagCompound nbt)
    {
        super.writeStructureToNBT(nbt);
        nbt.setInteger("AvgGroundLevel", this.averageGroundLevel);
    }

    @Override
    protected void readStructureFromNBT(NBTTagCompound nbt)
    {
        super.readStructureFromNBT(nbt);
        this.averageGroundLevel = nbt.getInteger("AvgGroundLevel");
    }

    @SuppressWarnings("rawtypes")
    public static ComponentVenusVillageField func_74900_a(ComponentVenusVillageStartPiece component, List list, int x, int y, int z, EnumFacing facing, int type)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 13, 4, 9, facing);
        return StructureComponent.findIntersecting(list, var8) == null ? new ComponentVenusVillageField(component, type, var8, facing) : null;
    }

    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox box)
    {
        if (this.averageGroundLevel < 0)
        {
            this.averageGroundLevel = this.getAverageGroundLevel(world, box);

            if (this.averageGroundLevel < 0)
            {
                return true;
            }
            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 4 - 1, 0);
        }

        this.fillWithBlocks(world, box, 0, 1, 0, 12, 4, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
        this.fillWithBlocks(world, box, 1, 0, 1, 2, 0, 7, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
        this.fillWithBlocks(world, box, 4, 0, 1, 5, 0, 7, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
        this.fillWithBlocks(world, box, 7, 0, 1, 8, 0, 7, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
        this.fillWithBlocks(world, box, 10, 0, 1, 11, 0, 7, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
        this.fillWithBlocks(world, box, 0, 0, 0, 0, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.fillWithBlocks(world, box, 6, 0, 0, 6, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.fillWithBlocks(world, box, 12, 0, 0, 12, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.fillWithBlocks(world, box, 1, 0, 0, 11, 0, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.fillWithBlocks(world, box, 1, 0, 8, 11, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.fillWithBlocks(world, box, 3, 0, 1, 3, 0, 7, Blocks.flowing_water.getDefaultState(), Blocks.flowing_water.getDefaultState(), false);
        this.fillWithBlocks(world, box, 9, 0, 1, 9, 0, 7, Blocks.flowing_water.getDefaultState(), Blocks.flowing_water.getDefaultState(), false);
        int var4;

        for (var4 = 1; var4 <= 7; ++var4)
        {
            for (int i = 1; i < 12; i++)
            {
                if (i % 3 == 0)
                {
                }
                else
                {
                    if (rand.nextInt(3) == 0)
                    {
                        this.setBlockState(world, Blocks.sapling.getStateFromMeta(rand.nextInt(4)), i, 1, var4, box);
                    }
                }
            }
        }

        for (var4 = 0; var4 < 9; ++var4)
        {
            for (int var5 = 0; var5 < 13; ++var5)
            {
                this.clearCurrentPositionBlocksUpwards(world, var5, 4, var4, box);
                this.replaceAirAndLiquidDownwards(world, Blocks.dirt.getDefaultState(), var5, -1, var4, box);
            }
        }
        return true;
    }
}