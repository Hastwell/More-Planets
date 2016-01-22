/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.items;

import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.items.ItemFoodMP2;

public class ItemCrystalApple extends ItemFoodMP2
{
    public ItemCrystalApple(String name)
    {
        super();
        this.setUnlocalizedName(name);
    }

    @Override
    public int getHealAmount(ItemStack itemStack)
    {
        return 5;
    }

    @Override
    public float getSaturationModifier(ItemStack itemStack)
    {
        return 1.0F;
    }
}