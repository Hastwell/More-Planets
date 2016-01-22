/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.spacestation.jupiter;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderOrbit;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.world.IUltraVioletLevel;
import stevekung.mods.moreplanets.core.init.MPPlanets;

public class WorldProviderJupiterOrbit extends WorldProviderOrbit implements IUltraVioletLevel
{
    private float angularVelocityRadians = 0F;
    private float skyAngularVelocity = (float) (this.angularVelocityRadians * 180 / Math.PI);

    @Override
    public CelestialBody getCelestialBody()
    {
        return MPPlanets.jupiterSpaceStation;
    }

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
    public boolean canRainOrSnow()
    {
        return false;
    }

    @Override
    public boolean hasSunset()
    {
        return false;
    }

    @Override
    public long getDayLength()
    {
        return 0;
    }

    @Override
    public float calculateCelestialAngle(long par1, float par3)
    {
        return 0.1975F;
    }

    @Override
    public boolean shouldForceRespawn()
    {
        return !ConfigManagerCore.forceOverworldRespawn;
    }

    @Override
    public Class<? extends IChunkProvider> getChunkProviderClass()
    {
        return ChunkProviderJupiterOrbit.class;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getSunBrightness(float par1)
    {
        float f1 = this.worldObj.getCelestialAngle(1.0F);
        float f2 = 0.45F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        f2 = 1.0F - f2;
        return f2 * 0.7F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1)
    {
        return 1.0F;
    }

    @Override
    public boolean isSkyColored()
    {
        return false;
    }

    @Override
    public double getHorizon()
    {
        return 44.0D;
    }

    @Override
    public int getAverageGroundLevel()
    {
        return 44;
    }

    @Override
    public boolean isSurfaceWorld()
    {
        return true;
    }

    @Override
    public boolean canCoordinateBeSpawn(int x, int z)
    {
        return true;
    }

    @Override
    public String getDimensionName()
    {
        return "Space Station " + this.spaceStationDimensionID;
    }

    @Override
    public boolean canSnowAt(BlockPos pos, boolean checkLight)
    {
        return false;
    }

    @Override
    public float getGravity()
    {
        return 0.075F;
    }

    @Override
    public boolean hasBreathableAtmosphere()
    {
        return false;
    }

    @Override
    public double getMeteorFrequency()
    {
        return 0;
    }

    @Override
    public double getFuelUsageMultiplier()
    {
        return 0.75D;
    }

    @Override
    public String getPlanetToOrbit()
    {
        return "planet.jupiter";
    }

    @Override
    public int getYCoordToTeleportToPlanet()
    {
        return -1000;
    }

    @Override
    public String getSaveFolder()
    {
        return "DIM_SPACESTATION" + this.spaceStationDimensionID;
    }

    @Override
    public double getSolarEnergyMultiplier()
    {
        return ConfigManagerCore.spaceStationEnergyScalar - 1.0D;
    }

    @Override
    public double getYCoordinateToTeleport()
    {
        return 1200;
    }

    @Override
    public boolean canSpaceshipTierPass(int tier)
    {
        return tier > 0;
    }

    @Override
    public float getFallDamageModifier()
    {
        return 0.4F;
    }

    @Override
    public float getSoundVolReductionAmount()
    {
        return 50.0F;
    }

    /**
     * Sets the spin rate for the dimension in radians per tick For example,
     * 0.031415 would be 1/200 revolution per tick So that would be 1 revolution
     * every 10 seconds
     */
    @Override
    public void setSpinRate(float angle)
    {
        super.setSpinRate(angle);
        this.angularVelocityRadians = angle;
        this.skyAngularVelocity = angle * 180F / 3.1415927F;

        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
        {
            this.updateSkyProviderSpinRate();
        }
    }

    @SideOnly(Side.CLIENT)
    private void updateSkyProviderSpinRate()
    {
        IRenderHandler sky = this.getSkyRenderer();

        if (sky instanceof SkyProviderJupiterOrbit)
        {
            ((SkyProviderJupiterOrbit) sky).spinDeltaPerTick = this.skyAngularVelocity;
        }
    }

    @Override
    public void setSpinRate(float angle, boolean firing)
    {
        super.setSpinRate(angle, firing);
        this.angularVelocityRadians = angle;
        this.skyAngularVelocity = angle * 180F / 3.1415927F;
        IRenderHandler sky = this.getSkyRenderer();

        if (sky instanceof SkyProviderJupiterOrbit)
        {
            ((SkyProviderJupiterOrbit) sky).spinDeltaPerTick = this.skyAngularVelocity;
        }
        this.thrustersFiring = firing;
    }

    @Override
    public float getThermalLevelModifier()
    {
        return 0;
    }

    @Override
    public float getWindLevel()
    {
        return 0.1F;
    }

    @Override
    public double getUltraVioletEnergyMultiplie()
    {
        return 2.0D;
    }
}