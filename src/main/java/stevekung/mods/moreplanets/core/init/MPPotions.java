/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.init;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.planets.diona.potion.EMPEffect;
import stevekung.mods.moreplanets.planets.kapteynb.potion.ChemicalEffect;
import stevekung.mods.moreplanets.planets.kapteynb.potion.IcyPoisonEffect;
import stevekung.mods.moreplanets.planets.nibiru.potion.InfectedGasEffect;

public class MPPotions
{
    public static Potion infected_gas;
    public static Potion chemical;
    public static Potion electro_magnetic_pulse;
    public static Potion icy_poison;

    public static void init()
    {
        MPPotions.intializePotions();
        MPLog.debug("Register Potions");
    }

    private static void intializePotions()
    {
        MPPotions.infected_gas = new InfectedGasEffect(ConfigManagerMP.idPotionInfectedGas, -4502242).setPotionName("potion.infected.gas");
        MPPotions.chemical = new ChemicalEffect(ConfigManagerMP.idPotionChemical, -16718336).setPotionName("potion.chemical");
        MPPotions.electro_magnetic_pulse = new EMPEffect(ConfigManagerMP.idPotionEMP, -14258727).setPotionName("potion.emp").registerPotionAttributeModifier(SharedMonsterAttributes.movementSpeed, "45166E8E-7CE8-4030-940E-514C1F160890", -2.5D, 2);
        MPPotions.icy_poison = new IcyPoisonEffect(ConfigManagerMP.idPotionIcyPoison, -6564921).setPotionName("potion.icy_poison").registerPotionAttributeModifier(SharedMonsterAttributes.movementSpeed, "9623E0072-7CE8-4030-940E-514C1F160890", -0.20000000596046448D, 2);
    }
}