/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP.DoorType;
import stevekung.mods.moreplanets.common.items.ItemDoorMP;
import stevekung.mods.moreplanets.common.items.ItemMultiVariant;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class KoentusItems
{
    public static Item koentus_item;
    public static Item koentus_meteor_chunk;
    public static Item crystal_door;
    public static Item crystal_cocoa;

    public static void init()
    {
        // Init
        KoentusItems.koentus_item = new ItemMultiVariant("koentus_item", new VariantsName("white_crystal", "emp_shard", "becterial_fossil", "raw_koentus_meteoric_iron", "koentus_meteoric_iron_ingot", "compressed_white_crystal", "compressed_koentus_meteoric_iron"));
        KoentusItems.koentus_meteor_chunk = new ItemKoentusMeteorChunk("koentus_meteor_chunk");
        KoentusItems.crystal_door = new ItemDoorMP("crystal_door", DoorType.CRYSTAL);
        KoentusItems.crystal_cocoa = new ItemCrystalCocoa("crystal_cocoa");

        // Register
        CommonRegisterHelper.registerItem(KoentusItems.koentus_item);
        CommonRegisterHelper.registerItem(KoentusItems.koentus_meteor_chunk);
        CommonRegisterHelper.registerItem(KoentusItems.crystal_cocoa);
        CommonRegisterHelper.registerItem(KoentusItems.crystal_door);

        // Register ore dictionary
        OreDictionary.registerOre("ingotKoentusMeteoricIron", new ItemStack(KoentusItems.koentus_item, 1, 4));
        OreDictionary.registerOre("compressedKoentusMeteoricIron", new ItemStack(KoentusItems.koentus_item, 1, 6));
        OreDictionary.registerOre("compressedWhiteCrystal", new ItemStack(KoentusItems.koentus_item, 1, 5));
    }
}