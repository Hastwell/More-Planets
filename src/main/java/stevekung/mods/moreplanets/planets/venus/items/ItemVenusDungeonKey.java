/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.items;

import micdoodle8.mods.galacticraft.api.item.IKeyItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.core.items.ItemMorePlanet;

@Deprecated //Removed in 1.8
public class ItemVenusDungeonKey extends ItemMorePlanet implements IKeyItem
{
    public ItemVenusDungeonKey(String name)
    {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(name);
        this.setTextureName("mpcore:blank");
    }

    @Override
    public int getTier(ItemStack keyStack)
    {
        return 3;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return null;
    }
}