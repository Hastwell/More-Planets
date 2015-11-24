/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen;

import stevekung.mods.moreplanets.common.world.biome.BiomeGenBaseMartianMoon;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerMartianMoon extends WorldChunkManagerSpace
{
	@Override
	public BiomeGenBase getBiome()
	{
		return BiomeGenBaseMartianMoon.martianMoon;
	}
}