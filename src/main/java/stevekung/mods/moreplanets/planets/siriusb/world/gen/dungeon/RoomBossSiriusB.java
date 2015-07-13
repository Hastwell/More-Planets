/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.world.gen.dungeon;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDungeonSpawner;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonBoundingBox;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonRoom;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.chunk.ChunkPrimer;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.siriusb.tileentities.TileEntitySiriusBDungeonSpawner;

public class RoomBossSiriusB extends DungeonRoom
{
	public int sizeX;
	public int sizeY;
	public int sizeZ;
	Random rand;
	BlockPos spawnerCoords;

	public RoomBossSiriusB(MapGenDungeon dungeon, int x, int y, int z, EnumFacing facing)
	{
		super(dungeon, x, y, z, facing);

		if (this.worldObj != null)
		{
			this.rand = new Random(this.worldObj.getSeed() * x * y * 57 * z);
			this.sizeX = 24;
			this.sizeY = 11;
			this.sizeZ = 24;
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
						if (j == this.posY - 1 && (i <= this.posX + 1 || i >= this.posX + this.sizeX - 2 || k == this.posZ + 1 || k == this.posZ + this.sizeZ - 2) && this.rand.nextInt(4) == 0)
						{
							this.placeBlock(chunk, i, j, k, cx, cz, SiriusBBlocks.sirius_glowstone, 0);
						}
						else
						{
							this.placeBlock(chunk, i, j, k, cx, cz, this.dungeonInstance.DUNGEON_WALL_ID, this.dungeonInstance.DUNGEON_WALL_META);
						}
					}
					else if (j == this.posY && (i <= this.posX + 1 || i >= this.posX + this.sizeX - 2 || k == this.posZ + 1 || k == this.posZ + this.sizeZ - 2) && this.rand.nextInt(6) == 0)
					{
						this.placeBlock(chunk, i, j, k, cx, cz, SiriusBBlocks.sirius_blaze_egg, 0);
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
		this.spawnerCoords = new BlockPos(hx, this.posY + 2, hz);
	}

	@Override
	public DungeonBoundingBox getBoundingBox()
	{
		return new DungeonBoundingBox(this.posX, this.posZ, this.posX + this.sizeX, this.posZ + this.sizeZ);
	}

	@Override
	protected DungeonRoom makeRoom(MapGenDungeon dungeon, int x, int y, int z, EnumFacing facing)
	{
		return new RoomBossSiriusB(dungeon, x, y, z, facing);
	}

	@Override
	protected void handleTileEntities(Random rand)
	{
		if (this.spawnerCoords == null)
		{
			return;
		}

		this.worldObj.setBlockState(this.spawnerCoords, SiriusBBlocks.sirius_b_block.getDefaultState(), 3);//TODO Boss Dungeon Spawner
		TileEntity tile = this.worldObj.getTileEntity(this.spawnerCoords);

		if (tile == null || !(tile instanceof TileEntitySiriusBDungeonSpawner))
		{
			TileEntityDungeonSpawner spawner = new TileEntitySiriusBDungeonSpawner();
			spawner.setRoom(new Vector3(this.posX, this.posY, this.posZ), new Vector3(this.sizeX, this.sizeY, this.sizeZ));
			this.worldObj.setTileEntity(this.spawnerCoords, spawner);
		}
		else if (tile instanceof TileEntityDungeonSpawner)
		{
			((TileEntityDungeonSpawner) tile).setRoom(new Vector3(this.posX, this.posY, this.posZ), new Vector3(this.sizeX, this.sizeY, this.sizeZ));
		}
	}
}