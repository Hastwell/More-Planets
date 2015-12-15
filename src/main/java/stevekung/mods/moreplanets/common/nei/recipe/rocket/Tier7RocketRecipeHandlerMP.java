/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.nei.recipe.rocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.nei.recipe.RocketRecipeHandler;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;

public class Tier7RocketRecipeHandlerMP extends RocketRecipeHandler
{
    private static HashMap<ArrayList<PositionedStack>, PositionedStack> rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();

    public String getRecipeId()
    {
        return "moreplanets.tier7.rocket";
    }

    public Set<Entry<ArrayList<PositionedStack>, PositionedStack>> getRecipes()
    {
        return rocketBenchRecipes.entrySet();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if (outputId.equals(this.getRecipeId()))
        {
            for (Map.Entry<ArrayList<PositionedStack>, PositionedStack> irecipe : this.getRecipes())
            {
                this.arecipes.add(new CachedRocketRecipeMP(irecipe));
            }
        }
        else
        {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result)
    {
        for (Map.Entry<ArrayList<PositionedStack>, PositionedStack> irecipe : this.getRecipes())
        {
            if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getValue().item, result))
            {
                this.arecipes.add(new CachedRocketRecipeMP(irecipe));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        for (Map.Entry<ArrayList<PositionedStack>, PositionedStack> irecipe : this.getRecipes())
        {
            for (PositionedStack pstack : irecipe.getKey())
            {
                if (NEIServerUtils.areStacksSameTypeCrafting(ingredient, pstack.item))
                {
                    this.arecipes.add(new CachedRocketRecipeMP(irecipe));
                    break;
                }
            }
        }
    }

    @Override
    protected String getRocketGuiTexture()
    {
        return "moreplanets:textures/gui/schematics/tier_7_rocket.png";
    }

    public static void addRocketRecipes()
    {
        int changeY = 15;
        ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 4), 45, -8 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 36, -6 + 16 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 36, -6 + 18 + 16 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 36, -6 + 36 + 16 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 36, -6 + 54 + 16 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 36, -6 + 72 + 16 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 54, -6 + 16 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 54, -6 + 18 + 16 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 54, -6 + 36 + 16 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 54, -6 + 54 + 16 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 54, -6 + 72 + 16 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 0), 45, 100 + changeY));//Engine
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 1), 18, 64 + changeY));//Booster
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 1), 72, 64 + changeY));//Booster
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3), 18, 82 + changeY));//Fins
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3), 18, 100 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3), 72, 82 + changeY));
        input1.add(new PositionedStack(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3), 72, 100 + changeY));
        registerRocketBenchRecipe(input1, new PositionedStack(new ItemStack(FronosItems.tier_7_rocket, 1, 0), 139, 87 + changeY));

        ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
        registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(FronosItems.tier_7_rocket, 1, 1), 139, 87 + changeY));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
        registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(FronosItems.tier_7_rocket, 1, 1), 139, 87 + changeY));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
        registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(FronosItems.tier_7_rocket, 1, 1), 139, 87 + changeY));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
        registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(FronosItems.tier_7_rocket, 1, 2), 139, 87 + changeY));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
        registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(FronosItems.tier_7_rocket, 1, 2), 139, 87 + changeY));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
        registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(FronosItems.tier_7_rocket, 1, 2), 139, 87 + changeY));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
        input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
        registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(FronosItems.tier_7_rocket, 1, 3), 139, 87 + changeY));
    }

    private static void registerRocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output)
    {
        rocketBenchRecipes.put(input, output);
    }
}