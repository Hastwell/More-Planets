/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;

public class EnumItemUtil
{
    public static enum Tier4ItemType
    {
        NOSE_CONE(0),
        T4_PLATE(1),
        T4_ENGINE(2),
        T4_BOOSTER(3),
        T5_ENGINE(4),
        T5_BOOSTER(5);

        private int meta;

        private Tier4ItemType(int meta)
        {
            this.meta = meta;
        }

        public ItemStack getItemStack()
        {
            return new ItemStack(DionaItems.tier_4_rocket_module, 1, this.meta);
        }
    }
}