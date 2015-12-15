/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.nei;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.nei.recipe.other.CandyExtractorFuelRecipeHandler;
import stevekung.mods.moreplanets.common.nei.recipe.other.CandyExtractorRecipeHandler;
import stevekung.mods.moreplanets.common.nei.recipe.other.CircuitFabricatorRecipeHandlerMP;
import stevekung.mods.moreplanets.common.nei.recipe.rocket.Tier4RocketRecipeHandlerMP;
import stevekung.mods.moreplanets.common.nei.recipe.rocket.Tier5RocketRecipeHandlerMP;
import stevekung.mods.moreplanets.common.nei.recipe.rocket.Tier6RocketRecipeHandlerMP;
import stevekung.mods.moreplanets.common.nei.recipe.rocket.Tier7RocketRecipeHandlerMP;
import stevekung.mods.moreplanets.common.nei.recipe.rocket.Tier8RocketRecipeHandlerMP;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.core.init.MPItems;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class NEIMorePlanetsConfig implements IConfigureNEI
{
    @Override
    public void loadConfig()
    {
        NEIMorePlanetsConfig.registerRecipeHandler(new Tier4RocketRecipeHandlerMP());
        NEIMorePlanetsConfig.registerRecipeHandler(new Tier5RocketRecipeHandlerMP());
        NEIMorePlanetsConfig.registerRecipeHandler(new Tier6RocketRecipeHandlerMP());
        NEIMorePlanetsConfig.registerRecipeHandler(new Tier7RocketRecipeHandlerMP());
        NEIMorePlanetsConfig.registerRecipeHandler(new Tier8RocketRecipeHandlerMP());
        NEIMorePlanetsConfig.registerRecipeHandler(new CircuitFabricatorRecipeHandlerMP());
        NEIMorePlanetsConfig.registerRecipeHandler(new CandyExtractorRecipeHandler());
        NEIMorePlanetsConfig.registerRecipeHandler(new CandyExtractorFuelRecipeHandler());

        Tier4RocketRecipeHandlerMP.addRocketRecipes();
        Tier5RocketRecipeHandlerMP.addRocketRecipes();
        Tier6RocketRecipeHandlerMP.addRocketRecipes();
        Tier7RocketRecipeHandlerMP.addRocketRecipes();
        Tier8RocketRecipeHandlerMP.addRocketRecipes();
        CircuitFabricatorRecipeHandlerMP.registerRecipes();

        this.registerAPI();
    }

    @Override
    public String getName()
    {
        return "More Planets NEI Plugin";
    }

    @Override
    public String getVersion()
    {
        return MorePlanetsCore.VERSION;
    }

    private void registerAPI()
    {
        for (Block block : MPBlocks.hideBlockList)
        {
            API.hideItem(new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
            MPLog.debug("Register NEI Hide Block : %s", GameData.getBlockRegistry().getNameForObject(block).toString());
        }
        for (Item item : MPItems.hideItemList)
        {
            API.hideItem(new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE));
            MPLog.debug("Register NEI Hide Item : %s", GameData.getItemRegistry().getNameForObject(item).toString());
        }
        for (Block block : MPBlocks.highlightBlockList)
        {
            API.registerHighlightIdentifier(block, new NEIHighlightHandlerMP());
            MPLog.debug("Register NEI Highlight : %s", GameData.getBlockRegistry().getNameForObject(block).toString());
        }
    }

    private static void registerRecipeHandler(TemplateRecipeHandler handler)
    {
        GuiUsageRecipe.registerUsageHandler(handler);
        GuiCraftingRecipe.registerRecipeHandler(handler);
        MPLog.debug("Register NEI Recipe : %s", handler.getClass().getSimpleName());
    }
}