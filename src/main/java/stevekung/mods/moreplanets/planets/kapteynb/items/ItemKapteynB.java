/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.items;

import stevekung.mods.moreplanets.common.items.IPowerCrystal;
import stevekung.mods.moreplanets.common.items.ItemBaseMP;

public class ItemKapteynB extends ItemBaseMP implements IPowerCrystal
{
    public ItemKapteynB(String name)
    {
        super();
        this.setUnlocalizedName(name);
    }

    @Override
    protected String[] getItemVariantsName()
    {
        return new String[] { "frozen_iron_ingot", "uranium_gem", "compressed_frozen_iron", "uranium_stick", "frozen_iron_stick", "ice_crystal_shard" };
    }

    @Override
    public boolean isPowerCrystal(int meta)
    {
        return meta == 1 || meta == 5;
    }

    @Override
    public int getPowerCrystalBurnTime(int meta)
    {
        return meta == 1 ? 16000 : meta == 5 ? 6400 : 0;
    }
}