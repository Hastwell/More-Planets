/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen.village;

import java.util.List;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentMartianVillageField extends ComponentMartianVillage
{
    private int averageGroundLevel = -1;

    public ComponentMartianVillageField() {}

    public ComponentMartianVillageField(ComponentMartianVillageStartPiece component, int type, StructureBoundingBox box, EnumFacing facing)
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
    public static ComponentMartianVillageField func_74900_a(ComponentMartianVillageStartPiece component, List list, Random par2Random, int x, int y, int z, EnumFacing facing, int type)
    {
        StructureBoundingBox box = StructureBoundingBox.func_175897_a(x, y, z, 0, 0, 0, 13, 4, 9, facing);
        return ComponentMartianVillage.canVillageGoDeeper(box) && StructureComponent.findIntersecting(list, box) == null ? new ComponentMartianVillageField(component, type, box, facing) : null;
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

        this.func_175804_a(world, box, 0, 1, 0, 12, 4, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
        this.func_175804_a(world, box, 1, 0, 1, 2, 0, 7, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
        this.func_175804_a(world, box, 4, 0, 1, 5, 0, 7, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
        this.func_175804_a(world, box, 7, 0, 1, 8, 0, 7, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
        this.func_175804_a(world, box, 10, 0, 1, 11, 0, 7, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
        this.func_175804_a(world, box, 0, 0, 0, 0, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.func_175804_a(world, box, 6, 0, 0, 6, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.func_175804_a(world, box, 12, 0, 0, 12, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.func_175804_a(world, box, 1, 0, 0, 11, 0, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.func_175804_a(world, box, 1, 0, 8, 11, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.func_175804_a(world, box, 3, 0, 1, 3, 0, 7, Blocks.flowing_water.getDefaultState(), Blocks.flowing_water.getDefaultState(), false);
        this.func_175804_a(world, box, 9, 0, 1, 9, 0, 7, Blocks.flowing_water.getDefaultState(), Blocks.flowing_water.getDefaultState(), false);
        int i;

        for (i = 1; i <= 7; ++i)
        {
            for (int o = 1; o < 12; o++)
            {
                if (rand.nextInt(3) == 0)
                {
                    this.func_175808_b(world, Blocks.sapling.getStateFromMeta(rand.nextInt(4)), o, 1, i, box);
                }
            }
        }

        for (i = 0; i < 9; ++i)
        {
            for (int j = 0; j < 13; ++j)
            {
                this.clearCurrentPositionBlocksUpwards(world, j, 4, i, box);
                this.func_175811_a(world, Blocks.dirt.getDefaultState(), j, -1, i, box);
            }
        }
        return true;
    }
}