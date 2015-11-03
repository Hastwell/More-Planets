/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.tileentities;

import micdoodle8.mods.galacticraft.core.util.OxygenUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class TileEntityIcyPoisonCrystal extends TileEntity implements IUpdatePlayerListBox
{
	public int facing;

	public TileEntityIcyPoisonCrystal()
	{
		this.facing = 1;
	}

	@Override
	public void update()
	{
		if (!this.worldObj.isRemote)
		{
			if (OxygenUtil.inOxygenBubble(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ()))
			{
				this.worldObj.createExplosion(null, this.pos.getX(), this.pos.getY(), this.pos.getZ(), 2.0F, true);
			}
			if (this.worldObj.provider.getDimensionId() == 0)
			{
				if (this.worldObj.rand.nextInt(100) == 0)
				{
					this.worldObj.createExplosion(null, this.pos.getX(), this.pos.getY(), this.pos.getZ(), 2.0F, true);
				}
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.facing = nbt.getInteger("Facing");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger("Facing", this.facing);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(this.pos, -999, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public boolean canRenderBreaking()
	{
		return true;
	}
}