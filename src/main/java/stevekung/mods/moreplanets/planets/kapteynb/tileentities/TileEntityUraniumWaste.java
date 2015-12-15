/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.BlockUraniumWaste;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;

public class TileEntityUraniumWaste extends TileEntity implements IUpdatePlayerListBox
{
    public int radiationLevel = 10000;

    @Override
    public void update()
    {
        if (!this.worldObj.isRemote && this.radiationLevel > 0)
        {
            this.radiationLevel--;
        }
        if (this.radiationLevel == 0)
        {
            this.worldObj.setBlockState(this.pos, KapteynBBlocks.uranium_waste.getDefaultState().withProperty(BlockUraniumWaste.VARIANT, BlockUraniumWaste.BlockType.inactive_uranium_waste), 3);
        }
    }

    public int getRadiationLevel()
    {
        return this.radiationLevel;
    }

    public void setRadiationLevel(int radLevel)
    {
        this.radiationLevel = radLevel;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.radiationLevel = nbt.getInteger("RadiationLevel");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("RadiationLevel", this.radiationLevel);
    }
}