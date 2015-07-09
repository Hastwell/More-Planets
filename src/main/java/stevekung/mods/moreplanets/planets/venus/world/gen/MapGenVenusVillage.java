/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.world.gen;

import java.util.Random;

import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraftforge.fml.common.FMLLog;
import stevekung.mods.moreplanets.planets.venus.world.gen.village.ComponentVenusVillageField;
import stevekung.mods.moreplanets.planets.venus.world.gen.village.ComponentVenusVillageField2;
import stevekung.mods.moreplanets.planets.venus.world.gen.village.ComponentVenusVillageHouse;
import stevekung.mods.moreplanets.planets.venus.world.gen.village.ComponentVenusVillageHut;
import stevekung.mods.moreplanets.planets.venus.world.gen.village.ComponentVenusVillagePathGen;
import stevekung.mods.moreplanets.planets.venus.world.gen.village.ComponentVenusVillageRoadPiece;
import stevekung.mods.moreplanets.planets.venus.world.gen.village.ComponentVenusVillageStartPiece;
import stevekung.mods.moreplanets.planets.venus.world.gen.village.ComponentVenusVillageTorch;
import stevekung.mods.moreplanets.planets.venus.world.gen.village.StructureVenusVillageStart;

public class MapGenVenusVillage extends MapGenStructure
{
	private int terrainType;

	static
	{
		MapGenStructureIO.registerStructure(StructureVenusVillageStart.class, "VenusVillage");
		MapGenStructureIO.registerStructureComponent(ComponentVenusVillageField.class, "VenusField1");
		MapGenStructureIO.registerStructureComponent(ComponentVenusVillageField2.class, "VenusField2");
		MapGenStructureIO.registerStructureComponent(ComponentVenusVillageHouse.class, "VenusHouse");
		MapGenStructureIO.registerStructureComponent(ComponentVenusVillageRoadPiece.class, "VenusRoadPiece");
		MapGenStructureIO.registerStructureComponent(ComponentVenusVillagePathGen.class, "VenusPath");
		MapGenStructureIO.registerStructureComponent(ComponentVenusVillageTorch.class, "VenusTorch");
		MapGenStructureIO.registerStructureComponent(ComponentVenusVillageStartPiece.class, "VenusWell");
		MapGenStructureIO.registerStructureComponent(ComponentVenusVillageHut.class, "VenusHut");
	}

	public MapGenVenusVillage()
	{
		this.terrainType = 0;
	}

	@Override
	protected boolean canSpawnStructureAtCoords(int i, int j)
	{
		byte numChunks = 32;
		byte offsetChunks = 8;
		int oldi = i;
		int oldj = j;

		if (i < 0)
		{
			i -= numChunks - 1;
		}
		if (j < 0)
		{
			j -= numChunks - 1;
		}

		int randX = i / numChunks;
		int randZ = j / numChunks;
		Random var7 = this.worldObj.setRandomSeed(i, j, 10387312);
		randX *= numChunks;
		randZ *= numChunks;
		randX += var7.nextInt(numChunks - offsetChunks);
		randZ += var7.nextInt(numChunks - offsetChunks);
		return oldi == randX && oldj == randZ;
	}

	@Override
	protected StructureStart getStructureStart(int par1, int par2)
	{
		FMLLog.info("Generating Venus Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVenusVillageStart(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String getStructureName()
	{
		return "VenusVillage";
	}
}