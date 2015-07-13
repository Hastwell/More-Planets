/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen.village;

import java.util.Random;

import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraftforge.fml.common.FMLLog;

public class MapGenMartianVillage extends MapGenStructure
{
	private int terrainType;

	static
	{
		MapGenStructureIO.registerStructure(StructureMartianVillageStart.class, "MartianVillage");
		MapGenStructureIO.registerStructureComponent(ComponentMartianVillageField.class, "MartianField1");
		MapGenStructureIO.registerStructureComponent(ComponentMartianVillageField2.class, "MartianField2");
		MapGenStructureIO.registerStructureComponent(ComponentMartianVillageHouse.class, "MartianHouse");
		MapGenStructureIO.registerStructureComponent(ComponentMartianVillageRoadPiece.class, "MartianRoadPiece");
		MapGenStructureIO.registerStructureComponent(ComponentMartianVillagePathGen.class, "MartianPath");
		MapGenStructureIO.registerStructureComponent(ComponentMartianVillageTorch.class, "MartianTorch");
		MapGenStructureIO.registerStructureComponent(ComponentMartianVillageStartPiece.class, "MartianWell");
		MapGenStructureIO.registerStructureComponent(ComponentMartianVillageHut.class, "MartianHut");
	}

	public MapGenMartianVillage()
	{
		this.terrainType = 0;
	}

	@Override
	protected boolean canSpawnStructureAtCoords(int x, int z)
	{
		byte numChunks = 32;
		byte offsetChunks = 8;
		int oldi = x;
		int oldj = z;

		if (x < 0)
		{
			x -= numChunks - 1;
		}
		if (z < 0)
		{
			z -= numChunks - 1;
		}
		int randX = x / numChunks;
		int randZ = z / numChunks;
		Random var7 = this.worldObj.setRandomSeed(x, z, 10387312);
		randX *= numChunks;
		randZ *= numChunks;
		randX += var7.nextInt(numChunks - offsetChunks);
		randZ += var7.nextInt(numChunks - offsetChunks);
		return oldi == randX && oldj == randZ;
	}

	@Override
	protected StructureStart getStructureStart(int x, int z)
	{
		FMLLog.info("Generating Martian Village at x" + x * 16 + " z" + z * 16);
		return new StructureMartianVillageStart(this.worldObj, this.rand, x, z, this.terrainType);
	}

	@Override
	public String getStructureName()
	{
		return "MartianVillage";
	}
}