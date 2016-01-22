/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.tileentities;

import micdoodle8.mods.galacticraft.core.util.OxygenUtil;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityIceCrystalMeteor extends TileEntity implements IUpdatePlayerListBox
{
    @Override
    public void update()
    {
        if (!this.worldObj.isRemote)
        {
            if (OxygenUtil.inOxygenBubble(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ()) || OxygenUtil.isInOxygenBlock(this.worldObj, AxisAlignedBB.fromBounds(this.pos.getX(), this.pos.getY(), this.pos.getZ(), this.pos.getX(), this.pos.getY(), this.pos.getZ())))
            {
                this.worldObj.createExplosion(null, this.pos.getX(), this.pos.getY(), this.pos.getZ(), 2.0F, true);
            }
            if (this.worldObj.provider.getDimensionId() == 0 || !OxygenUtil.noAtmosphericCombustion(this.worldObj.provider))
            {
                if (this.worldObj.rand.nextInt(100) == 0)
                {
                    this.worldObj.createExplosion(null, this.pos.getX(), this.pos.getY(), this.pos.getZ(), 2.0F, true);
                }
            }
        }
    }
}