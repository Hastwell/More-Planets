/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.world.gen.blazepit;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.StructureComponentGC;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentSiriusBlazePitStairway extends StructureComponentGC
{
	protected ComponentSiriusBlazePitStairway(int type, int x, int y, int z)
	{
		super(type);
		this.boundingBox = new StructureBoundingBox(Math.min(x - 5, x - 2), Math.min(y - 20, y - 20), Math.min(z - 5, z - 2), Math.max(x - 5, x - 2), Math.max(y, y), Math.max(z - 5, z - 2));
	}

	@Override
	public void buildComponent(StructureComponent component, List list, Random rand) {}

	@Override
	public boolean addComponentParts(World world, Random rand, StructureBoundingBox box)
	{
		int x1 = this.getBoundingBox().minX;
		int y1 = this.getBoundingBox().minY;
		int z1 = this.getBoundingBox().minZ;
		int x2 = this.getBoundingBox().maxX;
		int y2 = this.getBoundingBox().maxY;
		int z2 = this.getBoundingBox().maxZ;
		this.func_175804_a(world, box, x1, y1, z1, x2, y2, z2, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
		this.func_175804_a(world, box, x1 + 1, y1, z1 + 1, x2 - 1, y2, z2 - 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
		return true;
	}

	@Override
	protected void writeStructureToNBT(NBTTagCompound nbt) {}

	@Override
	protected void readStructureFromNBT(NBTTagCompound nbt) {}
}