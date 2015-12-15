/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.items.ItemFoodMP2;

public class ItemEuropaApple extends ItemFoodMP2
{
    public ItemEuropaApple(String name)
    {
        super();
        this.setUnlocalizedName(name);
    }

    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (!world.isRemote)
        {
            player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 36000, 3));
            player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 18000, 0));
        }
    }

    @Override
    public int getHealAmount(ItemStack itemStack)
    {
        return 4;
    }

    @Override
    public float getSaturationModifier(ItemStack itemStack)
    {
        return 1.5F;
    }
}