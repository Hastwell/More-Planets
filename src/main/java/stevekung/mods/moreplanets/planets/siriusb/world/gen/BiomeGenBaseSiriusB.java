/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.world.gen;

import net.minecraft.world.biome.BiomeGenBase;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.world.biome.BiomeGenBaseMP;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusBlaze;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusCreeper;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusMagmaCube;

public class BiomeGenBaseSiriusB extends BiomeGenBaseMP
{
    public BiomeGenBaseSiriusB()
    {
        super(ConfigManagerMP.idBasePlanetBiome);
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySiriusBlaze.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySiriusCreeper.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySiriusMagmaCube.class, 100, 4, 4));
    }
}