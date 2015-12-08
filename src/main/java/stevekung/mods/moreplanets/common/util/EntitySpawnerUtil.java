/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;

public class EntitySpawnerUtil
{
	public static void init()
	{
		EntitySpawnPlacementRegistry.setPlacementType(EntityEvolvedCreeper.class, SpawnPlacementType.ON_GROUND);
		EntitySpawnPlacementRegistry.setPlacementType(EntityEvolvedSkeleton.class, SpawnPlacementType.ON_GROUND);
		EntitySpawnPlacementRegistry.setPlacementType(EntityEvolvedZombie.class, SpawnPlacementType.ON_GROUND);
		EntitySpawnPlacementRegistry.setPlacementType(EntityEvolvedSpider.class, SpawnPlacementType.ON_GROUND);
	}
}