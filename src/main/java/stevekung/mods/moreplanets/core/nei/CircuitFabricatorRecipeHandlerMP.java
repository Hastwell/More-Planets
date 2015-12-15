/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * Credit to Galacticraft
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.nei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class CircuitFabricatorRecipeHandlerMP extends TemplateRecipeHandler
{
    private static ResourceLocation circuitFabricatorTexture = new ResourceLocation("galacticraftcore:textures/gui/circuitFabricator.png");
    int ticksPassed;

    public String getRecipeId()
    {
        return "galacticraft.circuits";
    }

    @Override
    public int recipiesPerPage()
    {
        return 1;
    }

    public Set<Entry<ArrayList<PositionedStack>, PositionedStack>> getRecipes()
    {
        HashMap<ArrayList<PositionedStack>, PositionedStack> recipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();

        for (Entry<HashMap<Integer, PositionedStack>, PositionedStack> stack : NEIMorePlanetsConfig.getCircuitFabricatorRecipes())
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

    @Override
    public void drawBackground(int i)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GuiDraw.changeTexture(CircuitFabricatorRecipeHandlerMP.circuitFabricatorTexture);
        GuiDraw.drawTexturedModalRect(-2, 9, 3, 4, 168, 64);
        GuiDraw.drawTexturedModalRect(68, 73, 73, 68, 96, 35);
        GuiDraw.drawTexturedModalRect(83, 25, 176, 17 + 10 * (Math.min(this.ticksPassed % 70, 51) / 3 % 3), Math.min(this.ticksPassed % 70, 51), 10);
    }

    @Override
    public void onUpdate()
    {
        this.ticksPassed += 1;
        super.onUpdate();
    }

    @Override
    public void loadTransferRects()
    {
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if (outputId.equals(this.getRecipeId()))
        {
            for (Map.Entry<ArrayList<PositionedStack>, PositionedStack> irecipe : this.getRecipes())
            {
                this.arecipes.add(new CachedCircuitRecipe(irecipe));
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
                this.arecipes.add(new CachedCircuitRecipe(irecipe));
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
                    this.arecipes.add(new CachedCircuitRecipe(irecipe));
                    break;
                }
            }
        }
    }

    @Override
    public ArrayList<PositionedStack> getIngredientStacks(int recipe)
    {
        return (ArrayList<PositionedStack>) this.arecipes.get(recipe).getIngredients();
    }

    @Override
    public PositionedStack getResultStack(int recipe)
    {
        if (this.ticksPassed % 70 >= 51)
        {
            return this.arecipes.get(recipe).getResult();
        }
        return null;
    }

    public class CachedCircuitRecipe extends TemplateRecipeHandler.CachedRecipe
    {
        public ArrayList<PositionedStack> input;
        public PositionedStack output;

        @Override
        public ArrayList<PositionedStack> getIngredients()
        {
            return (ArrayList<PositionedStack>) this.getCycledIngredients(CircuitFabricatorRecipeHandlerMP.this.cycleticks / 20, this.input);
        }

        @Override
        public PositionedStack getResult()
        {
            return this.output;
        }

        public CachedCircuitRecipe(ArrayList<PositionedStack> pstack1, PositionedStack pstack2)
        {
            super();
            this.input = pstack1;
            this.output = pstack2;
        }

        public CachedCircuitRecipe(Map.Entry<ArrayList<PositionedStack>, PositionedStack> recipe)
        {
            this(recipe.getKey(), recipe.getValue());
        }
    }

    @Override
    public String getRecipeName()
    {
        return "Circuit Fabricator";
    }

    @Override
    public String getGuiTexture()
    {
        return "galacticraftcore:textures/gui/circuitFabricator.png";
    }

    @Override
    public void drawForeground(int recipe)
    {
    }
}