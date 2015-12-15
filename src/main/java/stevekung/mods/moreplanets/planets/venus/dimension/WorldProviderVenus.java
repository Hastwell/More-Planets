/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.dimension;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.dimension.WorldProviderMP;
import stevekung.mods.moreplanets.common.world.ILightningStorm;
import stevekung.mods.moreplanets.common.world.gen.WorldChunkManagerPlanetBase;
import stevekung.mods.moreplanets.core.init.MPPlanets;
import stevekung.mods.moreplanets.planets.venus.world.gen.ChunkProviderVenus;

public class WorldProviderVenus extends WorldProviderMP implements ILightningStorm
{
    private double solarMultiplier = -1D;

    @Override
    public Vector3 getFogColor()
    {
        float f = 1.0F - this.getStarBrightness(1.0F);
        return new Vector3(109F / 255F * f, 86F / 255F * f, 45F / 255F * f);
    }

    @Override
    public Vector3 getSkyColor()
    {
        float f = 1.0F - this.getStarBrightness(1.0F);
        return new Vector3(180 / 255F * f, 134 / 255F * f, 59 / 255F * f);
    }

    @Override
    public long getDayLength()
    {
        return 5832000L;
    }

    @Override
    public Class<? extends IChunkProvider> getChunkProviderClass()
    {
        return ChunkProviderVenus.class;
    }

    @Override
    public Class<? extends WorldChunkManager> getWorldChunkManagerClass()
    {
        return WorldChunkManagerPlanetBase.class;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float bright)
    {
        float f1 = this.worldObj.getCelestialAngle(bright);
        float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if (f2 > 1.0F)
        {
            f2 = 0.7F;
        }
        return f2 * f2 * 0.5F + 0.3F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getSunBrightness(float bright)
    {
        float f1 = this.worldObj.getCelestialAngle(1.0F);
        float f2 = 1.25F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        f2 = 1.2F - f2;
        return f2 * 1.0F;
    }

    @Override
    public double getSolarEnergyMultiplier()
    {
        if (this.solarMultiplier < 0D)
        {
            double s = this.getSolarSize();
            this.solarMultiplier = s * s * s;
        }
        return this.solarMultiplier;
    }

    @Override
    public float getGravity()
    {
        return 0.058F;
    }

    @Override
    public double getMeteorFrequency()
    {
        return 100.0D;
    }

    @Override
    public boolean canSpaceshipTierPass(int tier)
    {
        return tier >= 3;
    }

    @Override
    public float getFallDamageModifier()
    {
        return 0.38F;
    }

    @Override
    public float getSoundVolReductionAmount()
    {
        return 5.0F;
    }

    @Override
    public CelestialBody getCelestialBody()
    {
        return MPPlanets.venus;
    }

    @Override
    public boolean hasBreathableAtmosphere()
    {
        return false;
    }

    @Override
    public float getThermalLevelModifier()
    {
        return -1.0F;
    }

    @Override
    public float getWindLevel()
    {
        return 0.3F;
    }

    @Override
    public double getUltraVioletEnergyMultiplie()
    {
        return 30.0D;
    }

    @Override
    public double getLightningStormFrequency()
    {
        return 1.5D;
    }

    @Override
    public String getInternalNameSuffix()
    {
        return "_venus";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getCloudHeight()
    {
        return 128.0F;
    }
}