/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.init;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.common.world.biome.BiomeGenBaseMartianMoon;
import stevekung.mods.moreplanets.moons.koentus.world.gen.BiomeGenBaseKoentus;
import stevekung.mods.moreplanets.planets.diona.world.gen.BiomeGenBaseDiona;
import stevekung.mods.moreplanets.planets.fronos.world.gen.biome.BiomeGenBaseFronos;
import stevekung.mods.moreplanets.planets.kapteynb.world.gen.BiomeGenBaseKapteynB;
import stevekung.mods.moreplanets.planets.mercury.world.gen.BiomeGenBaseMercury;
import stevekung.mods.moreplanets.planets.nibiru.world.gen.BiomeGenBaseNibiru;
import stevekung.mods.moreplanets.planets.pluto.world.gen.BiomeGenBasePluto;
import stevekung.mods.moreplanets.planets.polongnius.world.gen.BiomeGenBasePolongnius;
import stevekung.mods.moreplanets.planets.siriusb.world.gen.BiomeGenBaseSiriusB;
import stevekung.mods.moreplanets.planets.venus.world.gen.BiomeGenBaseVenus;

public class MPBiomes
{
    public static void init()
    {
        BiomeDictionary.registerBiomeType(BiomeGenBaseDiona.basePlanetBiome, Type.COLD, Type.DRY, Type.DEAD);
        BiomeDictionary.registerBiomeType(BiomeGenBasePolongnius.baseMoonBiome, Type.HOT, Type.DRY, Type.DEAD);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.grassyPlains, Type.LUSH, Type.PLAINS);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.goldenField, Type.LUSH, Type.PLAINS);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.coconutForest, Type.FOREST);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.mapleForest, Type.FOREST);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.purpleMapleForest, Type.FOREST);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.candyLand, Type.MAGICAL);
        MPLog.debug("Register Biome Types");
    }
}