/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import stevekung.mods.moreplanets.planets.diona.entities.EntitySpaceWolf;

public class EntitySpawnerUtil
{
	public static void init()
	{
		EntitySpawnPlacementRegistry.setPlacementType(EntitySpaceWolf.class, SpawnPlacementType.ON_GROUND);
	}
}