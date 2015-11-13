/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.achievement;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.moreplanets.planets.diona.items.tools.DionaToolsItems;

public class AchievementsMP
{
	public static Achievement getTier4Schematic;
	public static Achievement reachDiona;
	public static Achievement mineDionaOre;
	public static Achievement getSpacePick;
	public static Achievement laserGun;
	public static Achievement tameSpaceWolf;

	public static void init()
	{
		//par x, y
		AchievementsMP.getTier4Schematic = new Achievement("achievement.mp.getT4", "mp.getT4", 0, 0, new ItemStack(DionaItems.tier_4_rocket, 1, 10), null).setIndependent().func_180788_c();
		AchievementsMP.reachDiona = new Achievement("achievement.mp.reachDiona", "mp.reachDiona", 1, 2, new ItemStack(MPItems.achievement_temp, 1, 0), AchievementsMP.getTier4Schematic).func_180788_c();
		AchievementsMP.mineDionaOre = new Achievement("achievement.mp.mineDionaOre", "mp.mineDionaOre", 4, 3, new ItemStack(DionaBlocks.diona_block, 1, 4), AchievementsMP.reachDiona).func_180788_c();
		AchievementsMP.getSpacePick = new Achievement("achievement.mp.getSpacePick", "mp.getSpacePick", 4, 1, new ItemStack(DionaToolsItems.quontonium_pickaxe), AchievementsMP.mineDionaOre).func_180788_c();
		AchievementsMP.laserGun = new Achievement("achievement.mp.laserGun", "mp.laserGun", 4, 5, new ItemStack(DionaItems.laser_gun), AchievementsMP.mineDionaOre).setSpecial().func_180788_c();
		AchievementsMP.tameSpaceWolf = new Achievement("achievement.mp.tameSpaceWolf", "mp.tameSpaceWolf", -2, 4, new ItemStack(Items.bone), AchievementsMP.reachDiona).func_180788_c();

		AchievementPage.registerAchievementPage(new AchievementPage("More Planets", AchievementsMP.getTier4Schematic, AchievementsMP.reachDiona, AchievementsMP.mineDionaOre, AchievementsMP.getSpacePick, AchievementsMP.laserGun, AchievementsMP.tameSpaceWolf));
	}
}