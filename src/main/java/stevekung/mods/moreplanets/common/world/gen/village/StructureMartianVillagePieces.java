/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen.village;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureMartianVillagePieces
{
    public static ArrayList<StructureMartianVillagePieceWeight> getStructureVillageWeightedPieceList(Random rand, int par1)
    {
        ArrayList<StructureMartianVillagePieceWeight> var2 = new ArrayList<StructureMartianVillagePieceWeight>();
        var2.add(new StructureMartianVillagePieceWeight(ComponentMartianVillageHut.class, 5, MathHelper.getRandomIntegerInRange(rand, 2 + par1, 5 + par1 * 3)));
        var2.add(new StructureMartianVillagePieceWeight(ComponentMartianVillageField.class, 5, MathHelper.getRandomIntegerInRange(rand, 3 + par1, 5 + par1)));
        var2.add(new StructureMartianVillagePieceWeight(ComponentMartianVillageField2.class, 5, MathHelper.getRandomIntegerInRange(rand, 3 + par1, 5 + par1)));
        var2.add(new StructureMartianVillagePieceWeight(ComponentMartianVillageHouse.class, 5, MathHelper.getRandomIntegerInRange(rand, 3 + par1, 4 + par1 * 2)));

        Iterator<StructureMartianVillagePieceWeight> var3 = var2.iterator();

        while (var3.hasNext())
        {
            if (var3.next().villagePiecesLimit == 0)
            {
                var3.remove();
            }
        }
        return var2;
    }

    private static int func_75079_a(List<StructureMartianVillagePieceWeight> list)
    {
        boolean var1 = false;
        int var2 = 0;
        StructureMartianVillagePieceWeight var4;

        for (Iterator<StructureMartianVillagePieceWeight> var3 = list.iterator(); var3.hasNext(); var2 += var4.villagePieceWeight)
        {
            var4 = var3.next();

            if (var4.villagePiecesLimit > 0 && var4.villagePiecesSpawned < var4.villagePiecesLimit)
            {
                var1 = true;
            }
        }
        return var1 ? var2 : -1;
    }

    private static ComponentMartianVillage func_75083_a(ComponentMartianVillageStartPiece component, StructureMartianVillagePieceWeight weight, List<StructureComponent> list, Random rand, int x, int y, int z, EnumFacing facing, int type)
    {
        Class<?> var9 = weight.villagePieceClass;
        Object var10 = null;

        if (var9 == ComponentMartianVillageHut.class)
        {
            var10 = ComponentMartianVillageHut.func_74908_a(component, list, x, y, z, facing, type);
        }
        else if (var9 == ComponentMartianVillageField.class)
        {
            var10 = ComponentMartianVillageField.func_74900_a(component, list, rand, x, y, z, facing, type);
        }
        else if (var9 == ComponentMartianVillageField2.class)
        {
            var10 = ComponentMartianVillageField2.func_74900_a(component, list, rand, x, y, z, facing, type);
        }
        else if (var9 == ComponentMartianVillageHouse.class)
        {
            var10 = ComponentMartianVillageHouse.func_74921_a(component, list, x, y, z, facing, type);
        }
        return (ComponentMartianVillage) var10;
    }

    private static ComponentMartianVillage getNextVillageComponent(ComponentMartianVillageStartPiece component, List<StructureComponent> list, Random rand, int x, int y, int z, EnumFacing facing, int type)
    {
        int var8 = StructureMartianVillagePieces.func_75079_a(component.structureVillageWeightedPieceList);

        if (var8 <= 0)
        {
            return null;
        }
        else
        {
            int var9 = 0;

            while (var9 < 5)
            {
                ++var9;
                int var10 = rand.nextInt(var8);
                Iterator<StructureMartianVillagePieceWeight> var11 = component.structureVillageWeightedPieceList.iterator();

                while (var11.hasNext())
                {
                    StructureMartianVillagePieceWeight var12 = var11.next();
                    var10 -= var12.villagePieceWeight;

                    if (var10 < 0)
                    {
                        if (!var12.canSpawnMoreVillagePiecesOfType(type) || var12 == component.structVillagePieceWeight && component.structureVillageWeightedPieceList.size() > 1)
                        {
                            break;
                        }

                        ComponentMartianVillage var13 = StructureMartianVillagePieces.func_75083_a(component, var12, list, rand, x, y, z, facing, type);

                        if (var13 != null)
                        {
                            ++var12.villagePiecesSpawned;
                            component.structVillagePieceWeight = var12;

                            if (!var12.canSpawnMoreVillagePieces())
                            {
                                component.structureVillageWeightedPieceList.remove(var12);
                            }
                            return var13;
                        }
                    }
                }
            }

            StructureBoundingBox var14 = ComponentMartianVillageTorch.func_74904_a(list, x, y, z, facing);

            if (var14 != null)
            {
                return new ComponentMartianVillageTorch(component, type, var14, facing);
            }
            else
            {
                return null;
            }
        }
    }

    private static StructureComponent getNextVillageStructureComponent(ComponentMartianVillageStartPiece component, List<StructureComponent> list, Random rand, int x, int y, int z, EnumFacing facing, int type)
    {
        if (type > 50)
        {
            return null;
        }
        else if (Math.abs(x - component.getBoundingBox().minX) <= 112 && Math.abs(z - component.getBoundingBox().minZ) <= 112)
        {
            ComponentMartianVillage var8 = StructureMartianVillagePieces.getNextVillageComponent(component, list, rand, x, y, z, facing, type + 1);

            if (var8 != null)
            {
                list.add(var8);
                component.field_74932_i.add(var8);
                return var8;
            }
            return null;
        }
        else
        {
            return null;
        }
    }

    private static StructureComponent getNextComponentVillagePath(ComponentMartianVillageStartPiece component, List<StructureComponent> list, Random rand, int x, int y, int z, EnumFacing facing, int type)
    {
        if (type > 3 + component.terrainType)
        {
            return null;
        }
        else if (Math.abs(x - component.getBoundingBox().minX) <= 112 && Math.abs(z - component.getBoundingBox().minZ) <= 112)
        {
            StructureBoundingBox var8 = ComponentMartianVillagePathGen.func_74933_a(list, rand, x, y, z, facing);

            if (var8 != null && var8.minY > 10)
            {
                ComponentMartianVillagePathGen var9 = new ComponentMartianVillagePathGen(component, type, var8, facing);
                list.add(var9);
                component.field_74930_j.add(var9);
                return var9;
            }
            return null;
        }
        else
        {
            return null;
        }
    }

    static StructureComponent getNextStructureComponent(ComponentMartianVillageStartPiece component, List<StructureComponent> list, Random rand, int x, int y, int z, EnumFacing facing, int type)
    {
        return StructureMartianVillagePieces.getNextVillageStructureComponent(component, list, rand, x, y, z, facing, type);
    }

    static StructureComponent getNextStructureComponentVillagePath(ComponentMartianVillageStartPiece component, List<StructureComponent> list, Random rand, int x, int y, int z, EnumFacing facing, int type)
    {
        return StructureMartianVillagePieces.getNextComponentVillagePath(component, list, rand, x, y, z, facing, type);
    }
}