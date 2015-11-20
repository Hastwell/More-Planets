/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.tileentities;

import java.util.List;

import micdoodle8.mods.galacticraft.core.entities.IBoss;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDungeonSpawner;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class TileEntityDungeonSpawnerMP extends TileEntityDungeonSpawner
{
	private List<Class<? extends EntityLiving>> disableList;

	public TileEntityDungeonSpawnerMP(Class<? extends IBoss> boss, List<Class<? extends EntityLiving>> list)
	{
		super(boss);
		this.disableList = list;
	}

	@Override
	public List<Class<? extends EntityLiving>> getDisabledCreatures()
	{
		return this.disableList;
	}

	@Override
	public void playSpawnSound(Entity entity)
	{
		this.worldObj.playSoundAtEntity(entity, "galacticraftcore:ambience.scaryscape", 9.0F, 1.4F);
	}
}