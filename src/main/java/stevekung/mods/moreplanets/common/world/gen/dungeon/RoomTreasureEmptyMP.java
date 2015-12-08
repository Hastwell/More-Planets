/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen.dungeon;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonBoundingBox;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonRoom;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.chunk.ChunkPrimer;

public class RoomTreasureEmptyMP extends DungeonRoom
{
	int sizeX;
	int sizeZ;

	public RoomTreasureEmptyMP(MapGenDungeon dungeon, int posX, int posY, int posZ, EnumFacing entranceDir)
	{
		super(dungeon, posX, posY, posZ, entranceDir);

		if (this.worldObj != null)
		{
			Random rand = new Random(this.worldObj.getSeed() * posX * posY * 57 * posZ);
			this.sizeX = rand.nextInt(6) + 7;
			this.sizeZ = rand.nextInt(6) + 7;
		}
	}

	@Override
	public void generate(ChunkPrimer chunk, int cx, int cz) {}

	@Override
	public DungeonBoundingBox getBoundingBox()
	{
		return new DungeonBoundingBox(this.posX, this.posZ, this.posX + this.sizeX, this.posZ + this.sizeZ);
	}

	@Override
	protected DungeonRoom makeRoom(MapGenDungeon dungeon, int x, int y, int z, EnumFacing dir)
	{
		return new RoomTreasureEmptyMP(dungeon, x, y, z, dir);
	}

	@Override
	protected void handleTileEntities(Random rand) {}
}