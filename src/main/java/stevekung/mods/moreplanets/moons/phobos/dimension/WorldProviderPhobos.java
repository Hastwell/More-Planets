/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.phobos.dimension;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.dimension.WorldProviderMP;
import stevekung.mods.moreplanets.common.world.gen.WorldChunkManagerMartianMoon;
import stevekung.mods.moreplanets.core.init.MPPlanets;
import stevekung.mods.moreplanets.moons.phobos.world.gen.ChunkProviderPhobos;

public class WorldProviderPhobos extends WorldProviderMP
{
	@Override
	public Vector3 getFogColor()
	{
		return new Vector3(0, 0, 0);
	}

	@Override
	public Vector3 getSkyColor()
	{
		return new Vector3(0, 0, 0);
	}

	@Override
	public long getDayLength()
	{
		return 9180L;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass()
	{
		return ChunkProviderPhobos.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass()
	{
		return WorldChunkManagerMartianMoon.class;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float bright)
	{
		float var2 = this.worldObj.getCelestialAngle(bright);
		float var3 = 1.0F - (MathHelper.cos(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

		if (var3 < 0.0F)
		{
			var3 = 0.0F;
		}
		if (var3 > 1.0F)
		{
			var3 = 1.0F;
		}
		return var3 * var3 * 0.5F;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getSunBrightness(float bright)
	{
		float f1 = this.worldObj.getCelestialAngle(1.0F);
		float f2 = 0.85F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);

		if (f2 < 0.0F)
		{
			f2 = 0.0F;
		}
		if (f2 > 1.0F)
		{
			f2 = 1.0F;
		}
		f2 = 1.0F - f2;
		return f2 * 1.0F;
	}

	@Override
	public double getSolarEnergyMultiplier()
	{
		return 6.0D;
	}

	@Override
	public float getGravity()
	{
		return 0.060F;
	}

	@Override
	public double getMeteorFrequency()
	{
		return 5.5D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier)
	{
		return tier >= 2;
	}

	@Override
	public float getFallDamageModifier()
	{
		return 0.30F;
	}

	@Override
	public float getSoundVolReductionAmount()
	{
		return 10.0F;
	}

	@Override
	public CelestialBody getCelestialBody()
	{
		return MPPlanets.phobos;
	}

	@Override
	public boolean hasBreathableAtmosphere()
	{
		return false;
	}

	@Override
	public float getThermalLevelModifier()
	{
		if (this.isDaytime())
		{
			return 0.75F;
		}
		else
		{
			return -1.0F;
		}
	}

	@Override
	public float getWindLevel()
	{
		return 0.0F;
	}

	@Override
	public double getUltraVioletEnergyMultiplie()
	{
		return 5.0D;
	}

	@Override
	public String getInternalNameSuffix()
	{
		return "_phobos";
	}
}