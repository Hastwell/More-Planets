/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.io.world.gen.dungeon;

import java.util.ArrayList;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonBoundingBox;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonRoom;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.common.ChestGenHooks;

public class RoomChestsIo extends DungeonRoom
{
	int sizeX;
	int sizeY;
	int sizeZ;

	private ArrayList<BlockPos> chests = new ArrayList<BlockPos>();

	public RoomChestsIo(MapGenDungeon dungeon, int x, int y, int z, EnumFacing facing)
	{
		super(dungeon, x, y, z, facing);

		if (this.worldObj != null)
		{
			Random rand = new Random(this.worldObj.getSeed() * x * y * 57 * z);
			this.sizeX = rand.nextInt(5) + 6;
			this.sizeY = rand.nextInt(2) + 7;
			this.sizeZ = rand.nextInt(5) + 6;
		}
	}

	@Override
	public void generate(ChunkPrimer chunk, int cx, int cz)
	{
		for (int i = this.posX - 1; i <= this.posX + this.sizeX; i++)
		{
			for (int j = this.posY - 1; j <= this.posY + this.sizeY; j++)
			{
				for (int k = this.posZ - 1; k <= this.posZ + this.sizeZ; k++)
				{
					if (i == this.posX - 1 || i == this.posX + this.sizeX || j == this.posY - 1 || j == this.posY + this.sizeY || k == this.posZ - 1 || k == this.posZ + this.sizeZ)
					{
						this.placeBlock(chunk, i, j, k, cx, cz, this.dungeonInstance.DUNGEON_WALL_ID, this.dungeonInstance.DUNGEON_WALL_META);
					}
					else
					{
						this.placeBlock(chunk, i, j, k, cx, cz, Blocks.air, 0);
					}
				}
			}
		}

		int hx = (this.posX + this.posX + this.sizeX) / 2;
		int hz = (this.posZ + this.posZ + this.sizeZ) / 2;

		if (this.placeBlock(chunk, hx, this.posY, hz, cx, cz, Blocks.chest, 0))
		{
			this.chests.add(new BlockPos(hx, this.posY, hz));
		}
	}

	@Override
	public DungeonBoundingBox getBoundingBox()
	{
		return new DungeonBoundingBox(this.posX, this.posZ, this.posX + this.sizeX, this.posZ + this.sizeZ);
	}

	@Override
	protected DungeonRoom makeRoom(MapGenDungeon dungeon, int x, int y, int z, EnumFacing facing)
	{
		return new RoomChestsIo(dungeon, x, y, z, facing);
	}

	@Override
	protected void handleTileEntities(Random rand)
	{
		if (!this.chests.isEmpty())
		{
			this.worldObj.setBlockState(this.chests.get(0), Blocks.chest.getDefaultState(), 2);
			TileEntityChest chest = (TileEntityChest) this.worldObj.getTileEntity(this.chests.get(0));

			if (chest != null)
			{
				for (int i = 0; i < chest.getSizeInventory(); i++)
				{
					chest.setInventorySlotContents(i, null);
				}
				ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
				WeightedRandomChestContent.generateChestContents(rand, info.getItems(rand), chest, info.getCount(rand));
			}
			this.chests.clear();
		}
	}
}