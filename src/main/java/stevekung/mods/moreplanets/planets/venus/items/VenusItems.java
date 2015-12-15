/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.items.ItemMultiVariant;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class VenusItems
{
    public static Item venus_item;
    public static Item sulfur_battery;
    public static Item jetpack;

    public static ArmorMaterial jetpackArmor = EnumHelper.addArmorMaterial("jetpack", "jetpack", 0, new int[] { 0, 0, 0, 0 }, 0);

    public static void init()
    {
        // Init
        VenusItems.venus_item = new ItemMultiVariant("venus_item", new VariantsName("lead_ingot"));
        VenusItems.sulfur_battery = new ItemSulfurBattery("sulfur_battery");
        VenusItems.jetpack = new ItemJetpack("jetpack", VenusItems.jetpackArmor, 7, 1);

        // Register
        CommonRegisterHelper.registerItem(VenusItems.venus_item);
        CommonRegisterHelper.registerItem(VenusItems.sulfur_battery);
        CommonRegisterHelper.registerItem(VenusItems.jetpack);

        // Register ore dictionary
        OreDictionary.registerOre("ingotLead", new ItemStack(VenusItems.venus_item, 1, 0));
    }
}