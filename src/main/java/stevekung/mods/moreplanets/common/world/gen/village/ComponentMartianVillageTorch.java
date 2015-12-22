/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen.village;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import net.minecraft.block.BlockTorch;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import stevekung.mods.moreplanets.common.blocks.other.BlockChondriteRock;
import stevekung.mods.moreplanets.core.init.MPBlocks;

public class ComponentMartianVillageTorch extends ComponentMartianVillage
{
    private int averageGroundLevel = -1;

    public ComponentMartianVillageTorch() {}

    public ComponentMartianVillageTorch(ComponentMartianVillageStartPiece component, int type, StructureBoundingBox box, EnumFacing facing)
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
    public static StructureBoundingBox func_74904_a(List list, int x, int y, int z, EnumFacing facing)
    {
        StructureBoundingBox var7 = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 3, 4, 2, facing);
        return StructureComponent.findIntersecting(list, var7) != null ? null : var7;
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
        this.fillWithBlocks(world, box, 0, 0, 0, 2, 3, 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
        this.setBlockState(world, Blocks.oak_fence.getDefaultState(), 1, 0, 0, box);
        this.setBlockState(world, Blocks.oak_fence.getDefaultState(), 1, 1, 0, box);
        this.setBlockState(world, Blocks.oak_fence.getDefaultState(), 1, 2, 0, box);
        this.setBlockState(world, MPBlocks.chondrite_rock.getDefaultState().withProperty(BlockChondriteRock.VARIANT, BlockChondriteRock.BlockType.chondrite_stone_brick), 1, 3, 0, box);
        boolean flag = this.coordBaseMode == EnumFacing.EAST || this.coordBaseMode == EnumFacing.NORTH;
        this.setBlockState(world, GCBlocks.glowstoneTorch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateY()), flag ? 2 : 0, 3, 0, box);
        this.setBlockState(world, GCBlocks.glowstoneTorch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 1, 3, 1, box);
        this.setBlockState(world, GCBlocks.glowstoneTorch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateYCCW()), flag ? 0 : 2, 3, 0, box);
        this.setBlockState(world, GCBlocks.glowstoneTorch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.getOpposite()), 1, 3, -1, box);
        return true;
    }
}