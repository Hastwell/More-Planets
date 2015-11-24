/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen.village;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentMartianVillageField2 extends ComponentMartianVillage
{
	private int averageGroundLevel = -1;

	private Block cropTypeA;
	private Block cropTypeB;
	private Block cropTypeC;
	private Block cropTypeD;

	public ComponentMartianVillageField2() {}

	public ComponentMartianVillageField2(ComponentMartianVillageStartPiece component, int type, Random rand, StructureBoundingBox box, EnumFacing facing)
	{
		super(component, type);
		this.coordBaseMode = facing;
		this.boundingBox = box;
		this.cropTypeA = this.getRandomCrop(rand);
		this.cropTypeB = this.getRandomCrop(rand);
		this.cropTypeC = this.getRandomCrop(rand);
		this.cropTypeD = this.getRandomCrop(rand);
	}

	@Override
	protected void writeStructureToNBT(NBTTagCompound nbt)
	{
		super.writeStructureToNBT(nbt);
		nbt.setInteger("AvgGroundLevel", this.averageGroundLevel);
		nbt.setInteger("CropTypeA", Block.getIdFromBlock(this.cropTypeA));
		nbt.setInteger("CropTypeB", Block.getIdFromBlock(this.cropTypeB));
		nbt.setInteger("CropTypeC", Block.getIdFromBlock(this.cropTypeC));
		nbt.setInteger("CropTypeD", Block.getIdFromBlock(this.cropTypeD));
	}

	@Override
	protected void readStructureFromNBT(NBTTagCompound nbt)
	{
		super.readStructureFromNBT(nbt);
		this.averageGroundLevel = nbt.getInteger("AvgGroundLevel");
		this.cropTypeA = Block.getBlockById(nbt.getInteger("CropTypeA"));
		this.cropTypeB = Block.getBlockById(nbt.getInteger("CropTypeB"));
		this.cropTypeC = Block.getBlockById(nbt.getInteger("CropTypeC"));
		this.cropTypeD = Block.getBlockById(nbt.getInteger("CropTypeD"));
	}

	private Block getRandomCrop(Random rand)
	{
		switch (rand.nextInt(5))
		{
		case 0:
			return Blocks.carrots;
		case 1:
			return Blocks.potatoes;
		default:
			return Blocks.wheat;
		}
	}

	@SuppressWarnings("rawtypes")
	public static ComponentMartianVillageField2 func_74900_a(ComponentMartianVillageStartPiece component, List list, Random rand, int x, int y, int z, EnumFacing facing, int type)
	{
		StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(x, y, z, 0, 0, 0, 13, 4, 9, facing);
		return ComponentMartianVillage.canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(list, structureboundingbox) == null ? new ComponentMartianVillageField2(component, type, rand, structureboundingbox, facing) : null;
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
		this.func_175804_a(world, box, 1, 0, 1, 2, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
		this.func_175804_a(world, box, 4, 0, 1, 5, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
		this.func_175804_a(world, box, 7, 0, 1, 8, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
		this.func_175804_a(world, box, 10, 0, 1, 11, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
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
			this.func_175808_b(world, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(rand, 2, 7)), 1, 1, i, box);
			this.func_175808_b(world, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(rand, 2, 7)), 2, 1, i, box);
			this.func_175808_b(world, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(rand, 2, 7)), 4, 1, i, box);
			this.func_175808_b(world, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(rand, 2, 7)), 5, 1, i, box);
			this.func_175808_b(world, this.cropTypeC.getStateFromMeta(MathHelper.getRandomIntegerInRange(rand, 2, 7)), 7, 1, i, box);
			this.func_175808_b(world, this.cropTypeC.getStateFromMeta(MathHelper.getRandomIntegerInRange(rand, 2, 7)), 8, 1, i, box);
			this.func_175808_b(world, this.cropTypeD.getStateFromMeta(MathHelper.getRandomIntegerInRange(rand, 2, 7)), 10, 1, i, box);
			this.func_175808_b(world, this.cropTypeD.getStateFromMeta(MathHelper.getRandomIntegerInRange(rand, 2, 7)), 11, 1, i, box);
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