/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.tileentities;

import micdoodle8.mods.galacticraft.core.network.IPacketReceiver;
import micdoodle8.mods.galacticraft.core.tile.IMultiBlock;
import micdoodle8.mods.galacticraft.core.tile.TileEntityAdvanced;
import micdoodle8.mods.miccore.Annotations.NetworkedField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.relauncher.Side;

public class TileEntityUltraVioletFake extends TileEntityAdvanced implements IPacketReceiver
{
	@NetworkedField(targetSide = Side.CLIENT)
	public BlockPos mainBlockPosition;

	public void setMainBlock(BlockPos mainBlock)
	{
		this.mainBlockPosition = mainBlock;

		if (!this.worldObj.isRemote)
		{
			this.worldObj.markBlockForUpdate(this.mainBlockPosition);
		}
	}

	public void onBlockRemoval()
	{
		if (this.mainBlockPosition != null)
		{
			TileEntity tileEntity = this.worldObj.getTileEntity(this.mainBlockPosition);

			if (tileEntity instanceof IMultiBlock)
			{
				IMultiBlock mainBlock = (IMultiBlock) tileEntity;
				mainBlock.onDestroy(this);
			}
		}
	}

	public boolean onBlockActivated(EntityPlayer player)
	{
		if (this.mainBlockPosition != null)
		{
			TileEntity tileEntity = this.worldObj.getTileEntity(this.mainBlockPosition);

			if (tileEntity instanceof IMultiBlock)
			{
				return ((IMultiBlock) tileEntity).onActivated(player);
			}
		}
		return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		NBTTagCompound tag = nbt.getCompoundTag("mainBlockPosition");
		this.mainBlockPosition = new BlockPos(tag.getInteger("x"), tag.getInteger("y"), tag.getInteger("z"));
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);

		if (this.mainBlockPosition != null)
		{
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("x", this.mainBlockPosition.getX());
			tag.setInteger("y", this.mainBlockPosition.getY());
			tag.setInteger("z", this.mainBlockPosition.getZ());
			nbt.setTag("mainBlockPosition", tag);
		}
	}

	@Override
	public double getPacketRange()
	{
		return 30.0D;
	}

	@Override
	public int getPacketCooldown()
	{
		return 50;
	}

	@Override
	public boolean isNetworkedTile()
	{
		return this.mainBlockPosition != null;
	}
}