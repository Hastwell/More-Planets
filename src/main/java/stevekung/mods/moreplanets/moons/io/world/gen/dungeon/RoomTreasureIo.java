/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.io.world.gen.dungeon;

import java.util.HashSet;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonBoundingBox;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonRoom;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.mars.tile.TileEntityTreasureChestMars;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.chunk.ChunkPrimer;

public class RoomTreasureIo extends DungeonRoom
{
	int sizeX;
	int sizeY;
	int sizeZ;

	private HashSet<BlockPos> chests = new HashSet<BlockPos>();

	public RoomTreasureIo(MapGenDungeon dungeon, int x, int y, int z, EnumFacing facing)
	{
		super(dungeon, x, y, z, facing);

		if (this.worldObj != null)
		{
			Random rand = new Random(this.worldObj.getSeed() * x * y * 57 * z);
			this.sizeX = rand.nextInt(6) + 7;
			this.sizeY = rand.nextInt(2) + 8;
			this.sizeZ = rand.nextInt(6) + 7;
		}
	}

	@Override
	public void generate(ChunkPrimer chunk, int cx, int cz)
	{
		for (int i = this.posX - 1; i <= this.posX + this.sizeX; i++)
		{
			for (int k = this.posZ - 1; k <= this.posZ + this.sizeZ; k++)
			{
				for (int j = this.posY - 1; j <= this.posY + this.sizeY; j++)
				{
					if (i == this.posX - 1 || i == this.posX + this.sizeX || j == this.posY - 1 || j == this.posY + this.sizeY || k == this.posZ - 1 || k == this.posZ + this.sizeZ)
					{
						this.placeBlock(chunk, i, j, k, cx, cz, this.dungeonInstance.DUNGEON_WALL_ID, this.dungeonInstance.DUNGEON_WALL_META);
					}
					else
					{
						if ((i == this.posX || i == this.posX + this.sizeX - 1) && (k == this.posZ || k == this.posZ + this.sizeZ - 1))
						{
							this.placeBlock(chunk, i, j, k, cx, cz, Blocks.glowstone, 0);
						}
						else
						{
							this.placeBlock(chunk, i, j, k, cx, cz, Blocks.air, 0);
						}
					}
				}
			}
		}

		int hx = (this.posX + this.posX + this.sizeX) / 2;
		int hz = (this.posZ + this.posZ + this.sizeZ) / 2;

		if (this.placeBlock(chunk, hx, this.posY, hz, cx, cz, MarsBlocks.tier2TreasureChest, 0))
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
		return new RoomTreasureIo(dungeon, x, y, z, facing);
	}

	@Override
	protected void handleTileEntities(Random rand)
	{
		if (!this.chests.isEmpty())
		{
			HashSet<BlockPos> removeList = new HashSet<BlockPos>();

			for (BlockPos coords : this.chests)
			{
				this.worldObj.setBlockState(coords, MarsBlocks.tier2TreasureChest.getDefaultState(), 3);
				this.worldObj.setTileEntity(coords, new TileEntityTreasureChestMars());
				removeList.add(coords);
			}
			this.chests.removeAll(removeList);
		}
	}
}