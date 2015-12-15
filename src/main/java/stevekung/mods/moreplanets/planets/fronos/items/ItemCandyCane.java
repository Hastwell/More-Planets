/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.items;

import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.items.ItemFoodMP;

public class ItemCandyCane extends ItemFoodMP
{
    public ItemCandyCane(String name)
    {
        super();
        this.setUnlocalizedName(name);
        this.setHasSubtypes(true);
    }

    @Override
    protected String[] getItemVariantsName()
    {
        return new String[] { "pink_candy_cane_item", "orange_candy_cane_item", "green_candy_cane_item", "yellow_candy_cane_item", "light_blue_candy_cane_item", "blue_candy_cane_item", "red_candy_cane_item", "purple_candy_cane_item" };
    }

    @Override
    public int getHealAmount(ItemStack itemStack)
    {
        return 4;
    }

    @Override
    public float getSaturationModifier(ItemStack itemStack)
    {
        return 0.6F;
    }
}