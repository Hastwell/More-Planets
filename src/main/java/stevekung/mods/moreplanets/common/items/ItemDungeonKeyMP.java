/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.items;

import micdoodle8.mods.galacticraft.api.item.IKeyItem;
import net.minecraft.item.ItemStack;

public class ItemDungeonKeyMP extends ItemMorePlanets implements IKeyItem
{
    private int tier;

    public ItemDungeonKeyMP(String name, int tier)
    {
        super();
        this.tier = tier;
        this.setMaxStackSize(1);
        this.setUnlocalizedName(name);
    }

    @Override
    public int getTier(ItemStack itemStack)
    {
        return this.tier;
    }
}