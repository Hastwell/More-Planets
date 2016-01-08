/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * Credit to Galacticraft
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.nei.recipe.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.nei.CircuitFabricatorRecipeHandler;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import codechicken.nei.PositionedStack;

public class CircuitFabricatorRecipeHandlerMP extends CircuitFabricatorRecipeHandler
{
    private static HashMap<HashMap<Integer, PositionedStack>, PositionedStack> circuitFabricatorRecipes = new HashMap<HashMap<Integer, PositionedStack>, PositionedStack>();

    @Override
    public Set<Entry<ArrayList<PositionedStack>, PositionedStack>> getRecipes()
    {
        HashMap<ArrayList<PositionedStack>, PositionedStack> recipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();

        for (Entry<HashMap<Integer, PositionedStack>, PositionedStack> stack : getCircuitFabricatorRecipes())
        {
            ArrayList<PositionedStack> inputStacks = new ArrayList<PositionedStack>();

            for (Map.Entry<Integer, PositionedStack> input : stack.getKey().entrySet())
            {
                inputStacks.add(input.getValue());
            }
            recipes.put(inputStacks, stack.getValue());
        }
        return recipes.entrySet();
    }

    private static void registerCircuitFabricatorRecipe(HashMap<Integer, PositionedStack> input, PositionedStack output)
    {
        circuitFabricatorRecipes.put(input, output);
    }

    private static Set<Entry<HashMap<Integer, PositionedStack>, PositionedStack>> getCircuitFabricatorRecipes()
    {
        return circuitFabricatorRecipes.entrySet();
    }

    public static void registerRecipes()
    {
        CircuitFabricatorRecipeHandlerMP.addPurpleCrystalWaferRecipes();
        CircuitFabricatorRecipeHandlerMP.addPurpleCrystalSolarWaferRecipes();
    }

    private static void addPurpleCrystalWaferRecipes()
    {
        HashMap<Integer, PositionedStack> input1 = new HashMap<Integer, PositionedStack>();
        int siliconCount = OreDictionary.getOres(ConfigManagerCore.otherModsSilicon).size();
        ItemStack[] silicons = new ItemStack[siliconCount + 1];
        silicons[0] = new ItemStack(GCItems.basicItem, 1, 2);

        for (int j = 0; j < siliconCount; j++)
        {
            silicons[j + 1] = OreDictionary.getOres("itemSilicon").get(j);
        }

        input1.put(0, new PositionedStack(new ItemStack(PolongniusItems.polongnius_item, 1, 1), 10, 22));
        input1.put(1, new PositionedStack(silicons, 69, 51));
        input1.put(2, new PositionedStack(silicons, 69, 69));
        input1.put(3, new PositionedStack(new ItemStack(Items.redstone), 117, 51));
        input1.put(4, new PositionedStack(new ItemStack(Items.repeater), 140, 25));
        registerCircuitFabricatorRecipe(input1, new PositionedStack(new ItemStack(PolongniusItems.purple_crystal_solar_module, ConfigManagerCore.quickMode ? 2 : 1, 0), 147, 91));
    }

    private static void addPurpleCrystalSolarWaferRecipes()
    {
        HashMap<Integer, PositionedStack> input1 = new HashMap<Integer, PositionedStack>();
        int siliconCount = OreDictionary.getOres(ConfigManagerCore.otherModsSilicon).size();
        ItemStack[] silicons = new ItemStack[siliconCount + 1];
        silicons[0] = new ItemStack(GCItems.basicItem, 1, 2);

        for (int j = 0; j < siliconCount; j++)
        {
            silicons[j + 1] = OreDictionary.getOres("itemSilicon").get(j);
        }

        input1.put(0, new PositionedStack(new ItemStack(Items.diamond), 10, 22));
        input1.put(1, new PositionedStack(silicons, 69, 51));
        input1.put(2, new PositionedStack(silicons, 69, 69));
        input1.put(3, new PositionedStack(new ItemStack(Items.redstone), 117, 51));
        input1.put(4, new PositionedStack(new ItemStack(PolongniusItems.polongnius_item, 1, 1), 140, 25));
        registerCircuitFabricatorRecipe(input1, new PositionedStack(new ItemStack(PolongniusItems.purple_crystal_solar_module, 9, 1), 147, 91));
    }
}