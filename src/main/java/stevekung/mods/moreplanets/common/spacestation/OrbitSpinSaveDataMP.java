package stevekung.mods.moreplanets.common.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import stevekung.mods.moreplanets.common.spacestation.mars.WorldProviderMarsOrbit;

public class OrbitSpinSaveDataMP extends WorldSavedData
{
	public static String saveDataID = "MPSpinData";
	public NBTTagCompound datacompound;
	private NBTTagCompound alldata;
	private int dim = 0;

	public OrbitSpinSaveDataMP(String s)
	{
		super(OrbitSpinSaveDataMP.saveDataID);
		this.datacompound = new NBTTagCompound();
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		this.alldata = nbt;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		if (this.dim != 0)
		{
			nbt.setTag("" + this.dim, this.datacompound);
		}
	}

	public static OrbitSpinSaveDataMP initWorldData(World world)
	{
		OrbitSpinSaveDataMP worldData = (OrbitSpinSaveDataMP) world.loadItemData(OrbitSpinSaveDataMP.class, OrbitSpinSaveDataMP.saveDataID);

		if (worldData == null)
		{
			worldData = new OrbitSpinSaveDataMP("");
			world.setItemData(OrbitSpinSaveDataMP.saveDataID, worldData);

			if (world.provider instanceof WorldProviderMarsOrbit)
			{
				worldData.dim = world.provider.getDimensionId();
				((WorldProviderMarsOrbit)world.provider).writeToNBT(worldData.datacompound);
			}
			worldData.markDirty();
		}
		else if (world.provider instanceof WorldProviderMarsOrbit)
		{
			worldData.dim = world.provider.getDimensionId();
			worldData.datacompound = null;

			if (worldData.alldata != null)
			{
				worldData.datacompound = worldData.alldata.getCompoundTag("" + worldData.dim);
			}
			if (worldData.datacompound == null)
			{
				worldData.datacompound = new NBTTagCompound();
			}
		}
		return worldData;
	}
}