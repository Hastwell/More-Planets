/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;

import stevekung.mods.moreplanets.common.util.VariantsName;

public class ItemInformation extends ItemMorePlanets
{
    private VariantsName variants;

    public ItemInformation(String name, VariantsName variants)
    {
        super();
        this.variants = variants;
        this.setUnlocalizedName(name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
    {
        this.variants.getItemDescription().addDescription(itemStack, list, Keyboard.isKeyDown(Keyboard.KEY_LSHIFT));
    }
}