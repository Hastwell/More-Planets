/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.world.gen;

import java.util.Collections;
import java.util.List;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.world.biome.BiomeGenBaseMP;
import stevekung.mods.moreplanets.planets.diona.entities.EntityDionaCreeperMinion;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;
import stevekung.mods.moreplanets.planets.diona.entities.EntitySpaceWolf;

import com.google.common.collect.Lists;

public class BiomeGenBaseDiona extends BiomeGenBaseMP
{
	public static BiomeGenBase diona = new BiomeGenBaseDiona().setBiomeName("Diona");

	public BiomeGenBaseDiona()
	{
		super(ConfigManagerMP.idDionaBiome);
		this.spawnableMonsterList = Lists.newArrayList();
		this.spawnableCreatureList = Lists.newArrayList();
		this.spawnableWaterCreatureList = Lists.newArrayList();
		this.spawnableCaveCreatureList = Lists.newArrayList();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedCreeper.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityDionaCreeperMinion.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntitySpaceWolf.class, 8, 4, 4));
	}

	@Override
	public List getSpawnableList(EnumCreatureType type)
	{
		switch (SwitchEnumCreatureType.field_180275_a[type.ordinal()])
		{
		case 1:
			return this.spawnableMonsterList;
		case 2:
			return this.spawnableCreatureList;
		case 3:
			return this.spawnableWaterCreatureList;
		case 4:
			return this.spawnableCaveCreatureList;
		default:
			return Collections.emptyList();
		}
	}

	static class SwitchEnumCreatureType
	{
		static int[] field_180275_a = new int[EnumCreatureType.values().length];

		static
		{
			try
			{
				field_180275_a[EnumCreatureType.MONSTER.ordinal()] = 1;
			}
			catch (NoSuchFieldError var4)
			{
			}

			try
			{
				field_180275_a[EnumCreatureType.CREATURE.ordinal()] = 2;
			}
			catch (NoSuchFieldError var3)
			{
			}

			try
			{
				field_180275_a[EnumCreatureType.WATER_CREATURE.ordinal()] = 3;
			}
			catch (NoSuchFieldError var2)
			{
			}

			try
			{
				field_180275_a[EnumCreatureType.AMBIENT.ordinal()] = 4;
			}
			catch (NoSuchFieldError var1)
			{
			}
		}
	}
}