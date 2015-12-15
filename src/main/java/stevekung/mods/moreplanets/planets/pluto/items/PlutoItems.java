/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class PlutoItems
{
    public static Item pluto_item;
    public static Item space_potato;
    public static Item xeonium_dust;
    public static Item gravity_boots;
    public static Item pluto_heart_crystal;

    public static ArmorMaterial gravity = EnumHelper.addArmorMaterial("gravity", "gravity", 0, new int[] { 0, 0, 0, 0 }, 0);

    public static void init()
    {
        // Init
        PlutoItems.pluto_item = new ItemPluto("pluto_item");
        PlutoItems.xeonium_dust = new ItemMorePlanets("xeonium_dust");
        PlutoItems.space_potato = new ItemSpacePotato("space_potato");
        PlutoItems.pluto_heart_crystal = new ItemPlutoHeartCrystal("pluto_heart_crystal_item");
        PlutoItems.gravity_boots = new ItemGravityBoots("gravity_boots", PlutoItems.gravity, 7, 3);

        // Register
        CommonRegisterHelper.registerItem(PlutoItems.pluto_item);
        CommonRegisterHelper.registerItem(PlutoItems.xeonium_dust);
        CommonRegisterHelper.registerItem(PlutoItems.space_potato);
        CommonRegisterHelper.registerItem(PlutoItems.pluto_heart_crystal);
        CommonRegisterHelper.registerItem(PlutoItems.gravity_boots);
    }
}