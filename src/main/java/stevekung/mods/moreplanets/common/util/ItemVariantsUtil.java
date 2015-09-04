/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.moons.europa.items.EuropaItems;
import stevekung.mods.moreplanets.moons.koentus.items.KoentusItems;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;
import stevekung.mods.moreplanets.planets.mercury.items.MercuryItems;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;
import stevekung.mods.moreplanets.planets.pluto.items.PlutoItems;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import stevekung.mods.moreplanets.planets.siriusb.items.SiriusBItems;
import stevekung.mods.moreplanets.planets.venus.items.VenusItems;
import stevekung.mods.stevecore.RegisterHelper;

public class ItemVariantsUtil
{
	public static void registerItemVariants()
	{
		RegisterHelper.registerVariantsName(DionaItems.diona_item, new String[] { "moreplanets:quontonium_ingot", "moreplanets:fronisium_ingot", "moreplanets:compressed_quontonium", "moreplanets:compressed_fronisium", "moreplanets:tier_5_heavy_duty_plate", "moreplanets:red_canvas", "moreplanets:white_canvas", "moreplanets:blue_canvas", "moreplanets:thai_canvas_bottom", "moreplanets:thai_canvas_top", "moreplanets:quontonium_stick", "moreplanets:fronisium_stick", "moreplanets:green_redstone_torch" });
		RegisterHelper.registerVariantsName(DionaItems.tier_4_rocket_schematic, new String[] { "moreplanets:tier_4_rocket_schematic", "moreplanets:tier_4_rocket_schematic_no_flag" });
		RegisterHelper.registerVariantsName(DionaItems.tier_4_rocket_module, new String[] { "moreplanets:tier_4_nose_cone", "moreplanets:tier_4_heavy_duty_plate", "moreplanets:tier_4_rocket_engine", "moreplanets:tier_4_booster", "moreplanets:tier_4_nose_cone_no_flag", "moreplanets:tier_5_rocket_engine", "moreplanets:tier_5_booster" });
		RegisterHelper.registerVariantsName(DionaItems.laser_ammo, new String[] { "moreplanets:normal_laser_ammo", "moreplanets:hyper_laser_ammo", "moreplanets:emp_laser_ammo", "moreplanets:uranium_laser_ammo", "moreplanets:icy_poison_laser_ammo" });
		RegisterHelper.registerVariantsName(FronosItems.fronos_food, new String[] { "moreplanets:strawberry", "moreplanets:berry", "moreplanets:marshmallow", "moreplanets:cooked_marshmallow", "moreplanets:vanilla_ice_cream", "moreplanets:chocolate_ice_cream", "moreplanets:strawberry_ice_cream", "moreplanets:strawberry_cloud_ice_cream", "moreplanets:orange_ice_cream", "moreplanets:golden_bread", "moreplanets:little_sun_flower_seeds", "moreplanets:tea_ice_cream", "moreplanets:berry_salad", "moreplanets:sky_mushroom_stew", "moreplanets:rainbow_cloud_ice_cream", "moreplanets:lemon_ice_cream" });
		RegisterHelper.registerVariantsName(FronosItems.candy_food, new String[] { "moreplanets:ovaltine_powder", "moreplanets:chocolate_bars", "moreplanets:caramel" });
		RegisterHelper.registerVariantsName(FronosItems.candy_cane, new String[] { "moreplanets:pink_candy_cane_item", "moreplanets:orange_candy_cane_item", "moreplanets:green_candy_cane_item", "moreplanets:yellow_candy_cane_item", "moreplanets:light_blue_candy_cane_item", "moreplanets:blue_candy_cane_item", "moreplanets:red_candy_cane_item", "moreplanets:purple_candy_cane_item" });
		RegisterHelper.registerVariantsName(FronosItems.fronos_fruits, new String[] { "moreplanets:kiwi", "moreplanets:lemon" });
		RegisterHelper.registerVariantsName(FronosItems.jelly, new String[] { "moreplanets:grape_jelly", "moreplanets:raspberry_jelly", "moreplanets:strawberry_jelly", "moreplanets:berry_jelly", "moreplanets:lime_jelly", "moreplanets:orange_jelly", "moreplanets:green_jelly", "moreplanets:lemon_jelly" });
		RegisterHelper.registerVariantsName(FronosItems.fruits_juice, new String[] { "moreplanets:strawberry_juice", "moreplanets:berry_juice", "moreplanets:kiwi_juice", "moreplanets:lemon_juice" });
		RegisterHelper.registerVariantsName(FronosItems.cream_ball, new String[] { "moreplanets:vanilla_cream_ball", "moreplanets:chocolate_cream_ball", "moreplanets:strawberry_cream_ball", "moreplanets:orange_cream_ball", "moreplanets:tea_cream_ball", "moreplanets:lemon_cream_ball" });
		RegisterHelper.registerVariantsName(FronosItems.pearl, new String[] { "moreplanets:cream_pearl", "moreplanets:cavern_pearl" });
		RegisterHelper.registerVariantsName(FronosItems.cream_golem, new String[] { "moreplanets:vanilla_cream_golem", "moreplanets:chocolate_cream_golem", "moreplanets:strawberry_cream_golem", "moreplanets:orange_cream_golem", "moreplanets:tea_cream_golem", "moreplanets:lemon_cream_golem" });
		RegisterHelper.registerVariantsName(FronosItems.fronos_item, new String[] { "moreplanets:mineral_crystal", "moreplanets:mineral_pieces", "moreplanets:black_diamond", "moreplanets:iridium_ingot", "moreplanets:compressed_black_diamond", "moreplanets:compressed_iridium", "moreplanets:golden_wheat", "moreplanets:fronos_rock_item", "moreplanets:strawberry_feather", "moreplanets:cheese_string" });
		RegisterHelper.registerVariantsName(FronosItems.tier_8_rocket_module, new String[] { "moreplanets:tier_8_rocket_engine", "moreplanets:tier_8_booster", "moreplanets:tier_8_heavy_duty_plate" });
		RegisterHelper.registerVariantsName(FronosItems.candy_bow, new String[] { "moreplanets:candy_bow", "moreplanets:candy_bow_pulling_0", "moreplanets:candy_bow_pulling_1", "moreplanets:candy_bow_pulling_2" });
		RegisterHelper.registerVariantsName(FronosItems.cup, new String[] { "moreplanets:empty_cup", "moreplanets:mineral_water_cup", "moreplanets:ovaltine_cup", "moreplanets:coconut_milk_cup", "moreplanets:cheese_of_milk_cup", "moreplanets:tea_cup", "moreplanets:caramel_cup" });
		RegisterHelper.registerVariantsName(KoentusItems.koentus_item, new String[] { "moreplanets:white_crystal", "moreplanets:emp_shard", "moreplanets:becterial_fossil", "moreplanets:raw_koentus_meteoric_iron", "moreplanets:koentus_meteoric_iron_ingot", "moreplanets:compressed_white_crystal", "moreplanets:compressed_koentus_meteoric_iron" });
		RegisterHelper.registerVariantsName(NibiruItems.nibiru_item, new String[] { "moreplanets:red_gem", "moreplanets:norium_ingot", "moreplanets:compressed_red_gem", "moreplanets:compressed_norium", "moreplanets:red_gem_stick", "moreplanets:norium_stick" });
		RegisterHelper.registerVariantsName(NibiruItems.space_fruits, new String[] { "moreplanets:space_apple", "moreplanets:space_orange", "moreplanets:orange_juice" });
		RegisterHelper.registerVariantsName(NibiruItems.tier_6_rocket_schematic, new String[] { "moreplanets:tier_6_rocket_schematic", "moreplanets:tier_6_rocket_schematic_no_flag" });
		RegisterHelper.registerVariantsName(NibiruItems.tier_7_rocket_module, new String[] { "moreplanets:tier_7_rocket_engine", "moreplanets:tier_7_booster", "moreplanets:tier_7_heavy_duty_plate", "moreplanets:tier_7_rocket_fin", "moreplanets:tier_7_nose_cone" });
		RegisterHelper.registerVariantsName(PolongniusItems.polongnius_item, new String[] { "moreplanets:flonium", "moreplanets:purple_crystal", "moreplanets:raw_polongnius_meteoric_iron", "moreplanets:raw_palladium", "moreplanets:polongnius_meteoric_iron_ingot", "moreplanets:palladium_ingot", "moreplanets:compressed_polongnius_meteoric_iron", "moreplanets:compressed_palladium", "moreplanets:polongnius_meteoric_iron_stick", "moreplanets:palladium_stick", "moreplanets:cheese_leather", "moreplanets:cheese_spore" });
		RegisterHelper.registerVariantsName(PolongniusItems.purple_crystal_solar_module, new String[] { "moreplanets:purple_crystal_wafer", "moreplanets:purple_crystal_solar_wafer", "moreplanets:purple_crystal_solar_single", "moreplanets:purple_crystal_solar_panel" });
		RegisterHelper.registerVariantsName(PolongniusItems.tier_5_rocket_schematic, new String[] { "moreplanets:tier_5_rocket_schematic", "moreplanets:tier_5_rocket_schematic_no_flag" });
		RegisterHelper.registerVariantsName(PolongniusItems.tier_6_rocket_module, new String[] { "moreplanets:tier_6_rocket_engine", "moreplanets:tier_6_booster", "moreplanets:tier_6_heavy_duty_plate" });
		RegisterHelper.registerVariantsName(PolongniusItems.cheese_food, new String[] { "moreplanets:cheese_of_milk_curd", "moreplanets:raw_cheese_beef", "moreplanets:cooked_cheese_beef" });
		RegisterHelper.registerVariantsName(KapteynBItems.kapteyn_b_item, new String[] { "moreplanets:frozen_iron_ingot", "moreplanets:uranium_gem", "moreplanets:compressed_frozen_iron", "moreplanets:uranium_stick", "moreplanets:frozen_iron_stick", "moreplanets:ice_crystal_shard" });
		RegisterHelper.registerVariantsName(SiriusBItems.sirius_b_item, new String[] { "moreplanets:small_diamond_pieces", "moreplanets:large_diamond_pieces", "moreplanets:sulfur_dust", "moreplanets:sulfur_ingot", "moreplanets:compressed_sulfur", "moreplanets:sulfur_stick" });
		RegisterHelper.registerVariantsName(MercuryItems.mercury_item, new String[] { "moreplanets:metallic_shard", "moreplanets:raw_metal_meteoric_iron", "moreplanets:metallic_ingot", "moreplanets:metal_meteoric_iron_ingot", "moreplanets:compressed_metallic", "moreplanets:compressed_metal_meteoric_iron", "moreplanets:gravity_core", "moreplanets:gravity_controller" });
		RegisterHelper.registerVariantsName(VenusItems.venus_item, new String[] { "moreplanets:lead_ingot" });
		RegisterHelper.registerVariantsName(PlutoItems.pluto_item, new String[] { "moreplanets:xeonium_gem" });
		RegisterHelper.registerVariantsName(PlutoItems.space_potato, new String[] { "moreplanets:space_potato", "moreplanets:baked_space_potato" });
		RegisterHelper.registerVariantsName(MPItems.spawn_egg_mp, new String[] { "moreplanets:spawn_egg_mp" });
		RegisterHelper.registerVariantsName(EuropaItems.europa_prismarine, new String[] { "moreplanets:europa_prismarine_shard", "moreplanets:europa_prismarine_crystals" });
	}
}