/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.IBoss;
import micdoodle8.mods.galacticraft.core.network.PacketSimple;
import micdoodle8.mods.galacticraft.core.network.PacketSimple.EnumSimplePacket;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDungeonSpawner;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.entities.IEntityLivingPlanet;
import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.core.init.MPPotions;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruTreasureChest;

public class EntityEvolvedInfectedSpiderBoss extends EntityMob implements IEntityBreathable, IBossDisplayData, IBoss, IEntityLivingPlanet
{
	protected long ticks = 0;
	private TileEntityDungeonSpawner spawner;

	public Entity targetEntity;
	public int deathTicks = 0;

	public int entitiesWithin;
	public int entitiesWithinLast;

	private Vector3 roomCoords;
	private Vector3 roomSize;

	public EntityEvolvedInfectedSpiderBoss(World world)
	{
		super(world);
		this.setSize(2.4F, 1.9F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.field_175455_a);
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(4, new AISpiderAttack(EntityPlayer.class));
		this.tasks.addTask(4, new AISpiderAttack(EntityIronGolem.class));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(2, new AISpiderTarget(EntityPlayer.class));
		this.targetTasks.addTask(3, new AISpiderTarget(EntityIronGolem.class));
	}

	/*public EntityEvolvedInfectedSpiderBoss(World world, Vector3 vec) TODO
	{
		this(world);
		this.setPosition(vec.x, vec.y, vec.z);
	}*/

	@Override
	protected PathNavigate func_175447_b(World world)
	{
		return new PathNavigateClimber(this, world);
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition moving)
	{
		return new ItemStack(MPItems.spawn_egg_mp, 1, 1011);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(350.0F * ConfigManagerCore.dungeonBossHealthMod);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.800000011920929D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
	}

	@Override
	public boolean isInWater()
	{
		return false;
	}

	@Override
	public boolean handleWaterMovement()
	{
		return false;
	}

	@Override
	public void knockBack(Entity entity, float knock, double x, double z) {}

	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	protected String getLivingSound()
	{
		return "mob.spider.say";
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.spider.say";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.spider.death";
	}

	@Override
	protected void playStepSound(BlockPos pos, Block block)
	{
		this.playSound("mob.spider.step", 0.15F, 1.0F);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (!this.worldObj.isRemote)
		{
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onDeathUpdate()
	{
		++this.deathTicks;

		if (this.deathTicks >= 180 && this.deathTicks <= 200)
		{
			float f = (this.rand.nextFloat() - 0.5F) * 1.5F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 1.5F;
			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + f, this.posY + 2.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
		}

		int i;
		int j;

		if (!this.worldObj.isRemote)
		{
			if (this.deathTicks >= 180 && this.deathTicks % 5 == 0)
			{
				GalacticraftCore.packetPipeline.sendToAllAround(new PacketSimple(EnumSimplePacket.C_PLAY_SOUND_EXPLODE, new Object[] {}), new TargetPoint(this.worldObj.provider.getDimensionId(), this.posX, this.posY, this.posZ, 40.0D));
			}

			if (this.deathTicks > 150 && this.deathTicks % 5 == 0)
			{
				i = 30;

				while (i > 0)
				{
					j = EntityXPOrb.getXPSplit(i);
					i -= j;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
				}
			}

			if (this.deathTicks == 1)
			{
				GalacticraftCore.packetPipeline.sendToAllAround(new PacketSimple(EnumSimplePacket.C_PLAY_SOUND_BOSS_DEATH, new Object[] {}), new TargetPoint(this.worldObj.provider.getDimensionId(), this.posX, this.posY, this.posZ, 40.0D));
			}
		}

		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;

		if (this.deathTicks == 200 && !this.worldObj.isRemote)
		{
			i = 20;

			while (i > 0)
			{
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
			}

			if (!this.worldObj.isRemote)
			{
				for (TileEntity tile : new ArrayList<TileEntity>(this.worldObj.loadedTileEntityList))
				{
					if (tile instanceof TileEntityNibiruTreasureChest)
					{
						double d3 = tile.getPos().getX() + 0.5D - this.posX;
						double d4 = tile.getPos().getY() + 0.5D - this.posY;
						double d5 = tile.getPos().getZ() + 0.5D - this.posZ;
						double dSq = d3 * d3 + d4 * d4 + d5 * d5;
						TileEntityNibiruTreasureChest chest = (TileEntityNibiruTreasureChest) tile;

						if (dSq < 10000)
						{
							if (!chest.locked)
							{
								chest.locked = true;
							}

							for (int k = 0; k < chest.getSizeInventory(); k++)
							{
								chest.setInventorySlotContents(k, null);
							}

							ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);

							WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest, info.getCount(this.rand));
							WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest, info.getCount(this.rand));

							ItemStack schematic = this.getGuaranteedLoot(this.rand);
							int slot = this.rand.nextInt(chest.getSizeInventory());
							chest.setInventorySlotContents(slot, schematic);
							break;
						}
					}
				}
			}

			this.entityDropItem(new ItemStack(NibiruItems.nibiru_dungeon_key, 1, 0), 0.5F);
			super.setDead();

			if (this.spawner != null)
			{
				this.spawner.isBossDefeated = true;
				this.spawner.boss = null;
				this.spawner.spawned = false;
			}
		}
	}

	@Override
	public double getMountedYOffset()
	{
		return 0.0D;
	}

	@Override
	public void setDead()
	{
		if (this.spawner != null)
		{
			this.spawner.isBossDefeated = false;
			this.spawner.boss = null;
			this.spawner.spawned = false;
		}
		super.setDead();
	}

	@Override
	public void onLivingUpdate()
	{
		if (this.ticks >= Long.MAX_VALUE)
		{
			this.ticks = 1;
		}

		this.ticks++;

		if (!this.worldObj.isRemote && this.getHealth() <= 150.0F * ConfigManagerCore.dungeonBossHealthMod / 2)
		{
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		}

		EntityPlayer player = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 20.0);

		if (player != null && !player.equals(this.targetEntity))
		{
			if (this.getDistanceSqToEntity(player) < 400.0D)
			{
				this.getNavigator().getPathToEntityLiving(player);
				this.targetEntity = player;
			}
		}
		else
		{
			this.targetEntity = null;
		}

		if (this.roomCoords != null && this.roomSize != null)
		{
			@SuppressWarnings("unchecked")
			List<Entity> entitiesWithin = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.fromBounds(this.roomCoords.intX() - 1, this.roomCoords.intY() - 1, this.roomCoords.intZ() - 1, this.roomCoords.intX() + this.roomSize.intX(), this.roomCoords.intY() + this.roomSize.intY(), this.roomCoords.intZ() + this.roomSize.intZ()));

			this.entitiesWithin = entitiesWithin.size();

			if (this.entitiesWithin == 0 && this.entitiesWithinLast != 0)
			{
				@SuppressWarnings("unchecked")
				List<EntityPlayer> entitiesWithin2 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.fromBounds(this.roomCoords.intX() - 11, this.roomCoords.intY() - 11, this.roomCoords.intZ() - 11, this.roomCoords.intX() + this.roomSize.intX() + 10, this.roomCoords.intY() + this.roomSize.intY() + 10, this.roomCoords.intZ() + this.roomSize.intZ() + 10));

				for (EntityPlayer p : entitiesWithin2)
				{
					p.addChatMessage(new ChatComponentText(GCCoreUtil.translate("gui.skeletonBoss.message")));
				}

				this.setDead();

				if (this.spawner != null)
				{
					this.spawner.playerCheated = true;
				}
				return;
			}
			this.entitiesWithinLast = this.entitiesWithin;
		}
		super.onLivingUpdate();
	}

	@Override
	protected void dropFewItems(boolean drop, int fortune)
	{
		super.dropFewItems(drop, fortune);

		if (drop && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + fortune) > 0))
		{
			this.dropItem(Items.spider_eye, 1);
			this.dropItem(Items.string, 3);
		}
	}

	@Override
	public boolean isOnLadder()
	{
		return this.isBesideClimbableBlock();
	}

	@Override
	public void setInWeb() {}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.ARTHROPOD;
	}

	@Override
	public EntityItem entityDropItem(ItemStack par1ItemStack, float par2)
	{
		EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY + par2, this.posZ, par1ItemStack);
		entityitem.motionY = -2.0D;
		entityitem.setDefaultPickupDelay();

		if (this.captureDrops)
		{
			this.capturedDrops.add(entityitem);
		}
		else
		{
			this.worldObj.spawnEntityInWorld(entityitem);
		}
		return entityitem;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	public boolean isBesideClimbableBlock()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void setBesideClimbableBlock(boolean bool)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (bool)
		{
			b0 = (byte)(b0 | 1);
		}
		else
		{
			b0 &= -2;
		}
		this.dataWatcher.updateObject(16, Byte.valueOf(b0));
	}

	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		if (super.attackEntityAsMob(entity))
		{
			if (entity instanceof EntityLivingBase)
			{
				byte b0 = 4;

				if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL)
				{
					b0 = 7;
				}
				else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD)
				{
					b0 = 15;
				}
				if (b0 > 0)
				{
					((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MPPotions.infected_gas.id, b0 * 20, 0));
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public float getEyeHeight()
	{
		return 0.65F;
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potion)
	{
		int i = potion.getPotionID();

		if (i == MPPotions.infected_gas.id)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean canBreath()
	{
		return true;
	}

	public ItemStack getGuaranteedLoot(Random rand)
	{
		List<ItemStack> stackList = GalacticraftRegistry.getDungeonLoot(5);
		return stackList.get(rand.nextInt(stackList.size())).copy();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);

		if (this.roomCoords != null)
		{
			nbt.setDouble("roomCoordsX", this.roomCoords.x);
			nbt.setDouble("roomCoordsY", this.roomCoords.y);
			nbt.setDouble("roomCoordsZ", this.roomCoords.z);
			nbt.setDouble("roomSizeX", this.roomSize.x);
			nbt.setDouble("roomSizeY", this.roomSize.y);
			nbt.setDouble("roomSizeZ", this.roomSize.z);
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		this.roomCoords = new Vector3();
		this.roomCoords.x = nbt.getDouble("roomCoordsX");
		this.roomCoords.y = nbt.getDouble("roomCoordsY");
		this.roomCoords.z = nbt.getDouble("roomCoordsZ");
		this.roomSize = new Vector3();
		this.roomSize.x = nbt.getDouble("roomSizeX");
		this.roomSize.y = nbt.getDouble("roomSizeY");
		this.roomSize.z = nbt.getDouble("roomSizeZ");
	}

	@Override
	public void setRoom(Vector3 roomCoords, Vector3 roomSize)
	{
		this.roomCoords = roomCoords;
		this.roomSize = roomSize;
	}

	@Override
	public void onBossSpawned(TileEntityDungeonSpawner spawner)
	{
		this.spawner = spawner;
	}

	@Override
	public int canLivingInDimension()
	{
		return ConfigManagerMP.idDimensionSiriusB;
	}

	class AISpiderAttack extends EntityAIAttackOnCollide
	{
		public AISpiderAttack(Class p_i45819_2_)
		{
			super(EntityEvolvedInfectedSpiderBoss.this, p_i45819_2_, 1.0D, true);
		}

		@Override
		public boolean continueExecuting()
		{
			float f = this.attacker.getBrightness(1.0F);

			if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0)
			{
				this.attacker.setAttackTarget((EntityLivingBase)null);
				return false;
			}
			else
			{
				return super.continueExecuting();
			}
		}

		@Override
		protected double func_179512_a(EntityLivingBase p_179512_1_)
		{
			return 4.0F + p_179512_1_.width;
		}
	}

	class AISpiderTarget extends EntityAINearestAttackableTarget
	{
		public AISpiderTarget(Class p_i45818_2_)
		{
			super(EntityEvolvedInfectedSpiderBoss.this, p_i45818_2_, true);
		}

		@Override
		public boolean shouldExecute()
		{
			float f = this.taskOwner.getBrightness(1.0F);
			return f >= 0.5F ? false : super.shouldExecute();
		}
	}
}