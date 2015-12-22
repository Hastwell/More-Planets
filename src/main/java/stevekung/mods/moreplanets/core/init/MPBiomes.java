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
import stevekung.mods.moreplanets.common.world.biome.BiomeGenBaseMP;
import stevekung.mods.moreplanets.planets.fronos.world.gen.biome.BiomeGenBaseFronos;

public class MPBiomes
{
    public static void init()
    {
        BiomeDictionary.registerBiomeType(BiomeGenBaseMP.basePlanetBiome, Type.COLD, Type.DRY, Type.DEAD);
        BiomeDictionary.registerBiomeType(BiomeGenBaseMP.baseMoonBiome, Type.HOT, Type.DRY, Type.DEAD);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.grassyPlains, Type.LUSH, Type.PLAINS);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.goldenField, Type.LUSH, Type.PLAINS);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.coconutForest, Type.FOREST);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.mapleForest, Type.FOREST);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.purpleMapleForest, Type.FOREST);
        BiomeDictionary.registerBiomeType(BiomeGenBaseFronos.candyLand, Type.MAGICAL);
        MPLog.debug("Register Biome Types");
    }
}