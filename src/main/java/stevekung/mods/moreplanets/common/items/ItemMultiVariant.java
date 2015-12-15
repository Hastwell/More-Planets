/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.items;

import stevekung.mods.moreplanets.common.util.VariantsName;

public class ItemMultiVariant extends ItemBaseMP
{
    private String[] nameList;
    private boolean reverse;

    public ItemMultiVariant(String name, VariantsName variants)
    {
        super();
        this.nameList = variants.getStringList();
        this.reverse = variants.isReverseName();
        this.setUnlocalizedName(name);
    }

    @Override
    protected String[] getItemVariantsName()
    {
        return this.nameList;
    }

    @Override
    protected boolean reverseName()
    {
        return this.reverse;
    }
}