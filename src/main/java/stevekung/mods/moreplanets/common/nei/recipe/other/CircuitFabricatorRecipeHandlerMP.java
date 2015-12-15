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
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class CircuitFabricatorRecipeHandlerMP extends TemplateRecipeHandler
{
    private static HashMap<HashMap<Integer, PositionedStack>, PositionedStack> circuitFabricatorRecipes = new HashMap<HashMap<Integer, PositionedStack>, PositionedStack>();
    private ResourceLocation circuitFabricatorTexture = new ResourceLocation("galacticraftcore:textures/gui/circuitFabricator.png");
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

    @Override
    public void drawBackground(int i)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GuiDraw.changeTexture(this.circuitFabricatorTexture);
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
    public void loadTransferRects() {}

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
            return this.input;
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
    public void drawForeground(int recipe) {}

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