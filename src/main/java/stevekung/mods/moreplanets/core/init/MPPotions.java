/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.init;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.planets.diona.potion.EMPEffect;
import stevekung.mods.moreplanets.planets.kapteynb.potion.ChemicalEffect;
import stevekung.mods.moreplanets.planets.kapteynb.potion.IceCrystalEffect;
import stevekung.mods.moreplanets.planets.nibiru.potion.InfectedGasEffect;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class MPPotions
{
	public static Potion infected_gas;
	public static Potion chemical;
	public static Potion electro_magnetic_pulse;
	public static Potion icy_poison;

	public static void init()
	{
		MPPotions.intializePotions();
	}

	private static void intializePotions()
	{
		MPPotions.infected_gas = new InfectedGasEffect(true, -4502242).setPotionName("potion.infected.gas");
		MPPotions.chemical = new ChemicalEffect(true, -16718336).setPotionName("potion.chemical");
		MPPotions.electro_magnetic_pulse = new EMPEffect(true, -14258727).setPotionName("potion.emp").func_111184_a(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4030-940E-514C1F160890", -2.5D, 2);
		MPPotions.icy_poison = new IceCrystalEffect(true, -6564921).setPotionName("potion.icy_poison").func_111184_a(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.20000000596046448D, 2);
	}

	public static int getNextPotionID()
	{
		int n = Potion.potionTypes.length;

		for (int i = 1; i < n; i++)
		{
			if (Potion.potionTypes[i] == null)
			{
				return i;
			}
		}

		if (n >= 128)
		{
			MorePlanetsCore.severe("Cannot create potions, you might have to remove some mods (Potion Array is full!)");
		}

		Potion[] expandedPotionTypes = new Potion[n + 1];
		System.arraycopy(Potion.potionTypes, 0, expandedPotionTypes, 0, n);
		Field field = ReflectionHelper.findField(Potion.class, ObfuscationReflectionHelper.remapFieldNames(Potion.class.getName(), "potionTypes", "field_76425_a"));

		try
		{
			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
			field.set(null, expandedPotionTypes);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		return n;
	}
}