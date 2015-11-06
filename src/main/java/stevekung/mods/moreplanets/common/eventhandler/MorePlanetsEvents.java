/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.eventhandler;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.event.client.CelestialBodyRenderEvent;
import micdoodle8.mods.galacticraft.api.inventory.AccessInventoryGC;
import micdoodle8.mods.galacticraft.api.inventory.IInventoryGC;
import micdoodle8.mods.galacticraft.core.client.gui.screen.GuiCelestialSelection;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.planets.mars.dimension.WorldProviderMars;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.ZombieEvent.SummonAidEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.achievement.AchievementsMP;
import stevekung.mods.moreplanets.common.blocks.BlockSaplingMP;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.entities.IEntityLivingPlanet;
import stevekung.mods.moreplanets.common.util.DamageSourceMP;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.common.world.ILightningStorm;
import stevekung.mods.moreplanets.common.world.IMeteorType;
import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.core.init.MPPlanets;
import stevekung.mods.moreplanets.core.init.MPPotions;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.europa.items.EuropaItems;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.moons.io.items.IoItems;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.moons.koentus.dimension.WorldProviderKoentus;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusMeteor;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.moreplanets.planets.diona.items.tools.DionaToolsItems;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockDandelion;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockGlassGemCorn;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityGrappy;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.fronos.items.ItemCandyBow;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityIceCrystalMeteor;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;
import stevekung.mods.moreplanets.planets.kapteynb.items.armor.KapteynBArmorItems;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.mercury.items.MercuryItems;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;
import stevekung.mods.moreplanets.planets.nibiru.dimension.WorldProviderNibiru;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityInfectedZombie;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.pluto.dimension.WorldProviderPluto;
import stevekung.mods.moreplanets.planets.pluto.items.PlutoItems;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityPolongniusMeteor;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.siriusb.dimension.WorldProviderSiriusB;
import stevekung.mods.moreplanets.planets.siriusb.items.SiriusBItems;
import stevekung.mods.moreplanets.planets.venus.items.ItemJetpack;
import stevekung.mods.moreplanets.planets.venus.items.VenusItems;

public class MorePlanetsEvents
{
	@SubscribeEvent
	public void onZombieSummonAid(SummonAidEvent event)
	{
		if (event.entity instanceof EntityInfectedZombie)
		{
			event.customSummonedAid = new EntityInfectedZombie(event.world);

			if (((EntityLivingBase) event.entity).getRNG().nextFloat() < ((EntityInfectedZombie) event.entity).getEntityAttribute(((EntityInfectedZombie) event.entity).getReinforcementsAttribute()).getAttributeValue())
			{
				event.setResult(Result.ALLOW);
			}
			event.setResult(Result.DENY);
		}
	}

	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
		if (event.entityLiving.isPotionActive(MPPotions.icy_poison))
		{
			if (event.entityLiving.worldObj.isAirBlock(event.entityLiving.getPosition()))
			{
				if (KapteynBBlocks.icy_poison_crystal.canPlaceBlockAt(event.entityLiving.worldObj, event.entityLiving.getPosition()))
				{
					if (event.entityLiving.worldObj.rand.nextInt(50) == 0)
					{
						event.entityLiving.worldObj.setBlockState(event.entityLiving.getPosition(), KapteynBBlocks.icy_poison_crystal.getDefaultState());
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onLivingJump(LivingJumpEvent event)
	{
		if (event.entityLiving.isPotionActive(MPPotions.electro_magnetic_pulse))
		{
			event.entityLiving.motionY -= 1.0D;
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onClientTick(ClientTickEvent event)
	{
		Minecraft mc = Minecraft.getMinecraft();
		WorldClient world = mc.theWorld;
		EntityPlayerSP player = mc.thePlayer;

		if (Side.CLIENT != null)
		{
			if (player != null && world != null)
			{
				if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == VenusItems.jetpack)
				{
					boolean flag = player.capabilities.isCreativeMode;

					if (!flag && player.inventory.hasItem(Items.coal))
					{
						if (mc.gameSettings.keyBindJump.isKeyDown())
						{
							((ItemJetpack)player.inventory.armorItemInSlot(2).getItem()).setJetpackKeyDown(true);
							player.motionY = 0.5D;
							world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY - 1, player.posZ, 0, -1.0D, 0);
						}
						else if (!mc.gameSettings.keyBindJump.isKeyDown())
						{
							((ItemJetpack)player.inventory.armorItemInSlot(2).getItem()).setJetpackKeyDown(false);
						}

						if (!player.onGround)
						{
							if (mc.gameSettings.keyBindSneak.isKeyDown())
							{
								player.motionY *= 0.85D;
								world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY - 1, player.posZ, 0, -2.0D, 0);
								((ItemJetpack)player.inventory.armorItemInSlot(2).getItem()).setJetpackKeySneak(true);
							}
							else if (!mc.gameSettings.keyBindSneak.isKeyDown())
							{
								((ItemJetpack)player.inventory.armorItemInSlot(2).getItem()).setJetpackKeySneak(false);
							}
						}
						else
						{
							((ItemJetpack)player.inventory.armorItemInSlot(2).getItem()).setJetpackKeySneak(false);
						}
					}
					if (flag)
					{
						if (mc.gameSettings.keyBindJump.isKeyDown())
						{
							player.motionY = 0.5D;
							world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY - 1, player.posZ, 0, -1.0D, 0);
						}
						if (!player.onGround)
						{
							if (mc.gameSettings.keyBindSneak.isKeyDown())
							{
								player.motionY *= 0.85D;
								world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY - 1, player.posZ, 0, -2.0D, 0);
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event)
	{
		World world = event.entityLiving.worldObj;

		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;

			if (player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() == VenusItems.jetpack)
			{
				event.distance = 0.0F;
				event.setCanceled(true);
				return;
			}
			if (player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].getItem() == PlutoItems.gravity_boots)
			{
				if (world.provider instanceof WorldProviderKoentus || world.provider instanceof WorldProviderPluto)
				{
					event.distance = 0.1F;
				}
				else if (world.provider instanceof WorldProviderSiriusB)
				{
					event.distance = 0.76F;
				}
				event.distance *= 0.4F;
			}
		}
	}

	@SubscribeEvent
	public void fovUpdate(FOVUpdateEvent event)
	{
		if (event.entity.isUsingItem() && event.entity.getItemInUse().getItem() instanceof ItemCandyBow)
		{
			int i = event.entity.getItemInUseDuration();
			float f = i / 20.0F;

			if (f > 1.0F)
			{
				f = 1.0F;
			}
			else
			{
				f *= f;
			}
			event.newfov *= 1.0F - f * 0.15F;
		}
	}

	@SubscribeEvent
	public void onRenderPlanet(CelestialBodyRenderEvent.Post event)
	{
		Minecraft mc = Minecraft.getMinecraft();

		if (mc.currentScreen instanceof GuiCelestialSelection)
		{
			if (event.celestialBody == MPPlanets.polongnius)
			{
				mc.renderEngine.bindTexture(new ResourceLocation("moreplanets:textures/gui/celestialbodies/polongnius_ring.png"));
				float size = GuiCelestialSelection.getWidthForCelestialBodyStatic(event.celestialBody) / 6.0F;
				((GuiCelestialSelection)mc.currentScreen).drawTexturedModalRect(-7.5F * size, -1.75F * size, 15.0F * size, 3.5F * size, 0, 0, 30, 7, false, false, 30, 7);
			}
		}
	}

	@SubscribeEvent
	public void onPickupItem(EntityItemPickupEvent event)
	{
		ItemStack itemStack = event.item.getEntityItem();
		Item item = itemStack.getItem();
		int meta = itemStack.getItemDamage();

		if (event.entityPlayer.inventory.addItemStackToInventory(itemStack))
		{
			if (item == DionaItems.tier_4_rocket_schematic)
			{
				event.entityPlayer.triggerAchievement(AchievementsMP.getTier4Schematic);
			}
			if (item == Item.getItemFromBlock(DionaBlocks.diona_block) && (meta == 4 || meta == 5))
			{
				event.entityPlayer.triggerAchievement(AchievementsMP.mineDionaOre);
			}
			event.entityPlayer.onItemPickup(event.item, itemStack.stackSize);
		}
	}

	@SubscribeEvent
	public void onChangeDimension(PlayerChangedDimensionEvent event)
	{
		if (event.toDim == ConfigManagerMP.idDimensionDiona)
		{
			event.player.triggerAchievement(AchievementsMP.reachDiona);
		}
	}

	@SubscribeEvent
	public void onCraftItem(ItemCraftedEvent event)
	{
		Item item = event.crafting.getItem();

		if (item == DionaToolsItems.quontonium_pickaxe || item == DionaToolsItems.fronisium_pickaxe)
		{
			event.player.triggerAchievement(AchievementsMP.getSpacePick);
		}
		if (item == DionaItems.laser_gun)
		{
			event.player.triggerAchievement(AchievementsMP.laserGun);
		}
	}

	@SubscribeEvent
	public void onUseBonemeal(BonemealEvent event)
	{
		Random rand = event.world.rand;
		BlockPos pos = event.pos;
		Block block = event.block.getBlock();
		World world = event.world;
		int x = pos.getX();
		int z = pos.getZ();

		this.glowSapling(event, world, NibiruBlocks.nibiru_sapling);
		this.glowSapling(event, world, KoentusBlocks.crystal_sapling);
		this.glowSapling(event, world, FronosBlocks.fronos_sapling);

		this.glowTallGrass(event, rand, x, z, FronosBlocks.fronos_grass, FronosBlocks.fronos_tall_grass, 3, 0, true);
		this.glowTallGrass(event, rand, x, z, FronosBlocks.pink_grass, FronosBlocks.fronos_tall_grass, 3, 3, true);
		this.glowTallGrass(event, rand, x, z, FronosBlocks.purple_grass, FronosBlocks.fronos_tall_grass, 3, 6, true);
		this.glowTallGrass(event, rand, x, z, FronosBlocks.plains_grass, FronosBlocks.fronos_tall_grass, 3, 9, true);
		this.glowTallGrass(event, rand, x, z, FronosBlocks.golden_grass, FronosBlocks.fronos_tall_grass, 3, 12, true);


		/*if (block == NibiruBlocks.nibiru_sapling)
		{
			event.setResult(Result.ALLOW);

			if (!world.isRemote)
			{
				if (world.rand.nextFloat() < 0.45D)
				{
					((BlockNibiruSapling)NibiruBlocks.nibiru_sapling).grow(world, world.rand, event.pos, event.block);
				}
			}
		}
		else if (block == KoentusBlocks.crystal_sapling)
		{
			event.setResult(Result.ALLOW);

			if (!world.isRemote)
			{
				if (world.rand.nextFloat() < 0.45D)
				{
					((BlockCrystalSapling)KoentusBlocks.crystal_sapling).grow(world, world.rand, event.pos, event.block);
				}
			}
		}
		else if (block == FronosBlocks.fronos_sapling)
		{
			event.setResult(Result.ALLOW);

			if (!world.isRemote)
			{
				if (world.rand.nextFloat() < 0.45D)
				{
					((BlockFronosSapling)FronosBlocks.fronos_sapling).grow(world, world.rand, event.pos, event.block);
				}
			}
		}
		else if (block == FronosBlocks.fronos_grass)
		{
			int var14 = pos.getY() + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += world.rand.nextInt(3) - 1;
					var14 += (world.rand.nextInt(3) - 1) * world.rand.nextInt(3) / 2;
					z += world.rand.nextInt(3) - 1;
				}

				BlockPos pos1 = new BlockPos(x, var14, z);

				if (world.getBlockState(pos1).getBlock().isAir(world, pos1))
				{
					if (FronosBlocks.fronos_tall_grass.canReplace(world, pos1, EnumFacing.UP, new ItemStack(FronosBlocks.fronos_tall_grass, 1, rand.nextInt(3))))
					{
						event.setResult(Result.ALLOW);

						if (!world.isRemote)
						{
							world.setBlockState(pos1, FronosBlocks.fronos_tall_grass.getStateFromMeta(rand.nextInt(3)), 2);
						}
					}
				}
			}
		}
		else if (block == FronosBlocks.pink_grass)
		{
			int var14 = pos.getY() + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += world.rand.nextInt(3) - 1;
					var14 += (world.rand.nextInt(3) - 1) * world.rand.nextInt(3) / 2;
					z += world.rand.nextInt(3) - 1;
				}

				BlockPos pos1 = new BlockPos(x, var14, z);

				if (world.getBlockState(pos1).getBlock().isAir(world, pos1))
				{
					if (FronosBlocks.fronos_tall_grass.canReplace(world, pos1, EnumFacing.UP, new ItemStack(FronosBlocks.fronos_tall_grass, 1, rand.nextInt(3) + 3)))
					{
						event.setResult(Result.ALLOW);

						if (!world.isRemote)
						{
							world.setBlockState(pos1, FronosBlocks.fronos_tall_grass.getStateFromMeta(rand.nextInt(3) + 3), 2);
						}
					}
				}
			}
		}
		else if (block == FronosBlocks.purple_grass)
		{
			int var14 = pos.getY() + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += world.rand.nextInt(3) - 1;
					var14 += (world.rand.nextInt(3) - 1) * world.rand.nextInt(3) / 2;
					z += world.rand.nextInt(3) - 1;
				}

				BlockPos pos1 = new BlockPos(x, var14, z);

				if (world.getBlockState(pos1).getBlock().isAir(world, pos1))
				{
					if (FronosBlocks.fronos_tall_grass.canReplace(world, pos1, EnumFacing.UP, new ItemStack(FronosBlocks.fronos_tall_grass, 1, rand.nextInt(3) + 6)))
					{
						event.setResult(Result.ALLOW);

						if (!world.isRemote)
						{
							world.setBlockState(pos1, FronosBlocks.fronos_tall_grass.getStateFromMeta(rand.nextInt(3) + 6), 2);
						}
					}
				}
			}
		}
		else if (block == FronosBlocks.plains_grass)
		{
			int var14 = pos.getY() + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += world.rand.nextInt(3) - 1;
					var14 += (world.rand.nextInt(3) - 1) * world.rand.nextInt(3) / 2;
					z += world.rand.nextInt(3) - 1;
				}

				BlockPos pos1 = new BlockPos(x, var14, z);

				if (world.getBlockState(pos1).getBlock().isAir(world, pos1))
				{
					if (FronosBlocks.fronos_tall_grass.canReplace(world, pos1, EnumFacing.UP, new ItemStack(FronosBlocks.fronos_tall_grass, 1, rand.nextInt(3) + 9)))
					{
						event.setResult(Result.ALLOW);

						if (!world.isRemote)
						{
							world.setBlockState(pos1, FronosBlocks.fronos_tall_grass.getStateFromMeta(rand.nextInt(3) + 9), 2);
						}
					}
				}
			}
		}
		else if (block == FronosBlocks.golden_grass)
		{
			int var14 = pos.getY() + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += world.rand.nextInt(3) - 1;
					var14 += (world.rand.nextInt(3) - 1) * world.rand.nextInt(3) / 2;
					z += world.rand.nextInt(3) - 1;
				}

				BlockPos pos1 = new BlockPos(x, var14, z);

				if (world.getBlockState(pos1).getBlock().isAir(world, pos1))
				{
					if (FronosBlocks.fronos_tall_grass.canReplace(world, pos1, EnumFacing.UP, new ItemStack(FronosBlocks.fronos_tall_grass, 1, rand.nextInt(3) + 12)))
					{
						event.setResult(Result.ALLOW);

						if (!world.isRemote)
						{
							world.setBlockState(pos1, FronosBlocks.fronos_tall_grass.getStateFromMeta(rand.nextInt(3) + 12), 2);
						}
					}
				}
			}
		}
		else */if (event.block == FronosBlocks.glass_gem_corn.getDefaultState())
		{
			if (world.getBlockState(pos.up()).getBlock().isAir(world, pos.up()) && world.getBlockState(pos.up(2)).getBlock().isAir(world, pos.up(2)))
			{
				event.setResult(Result.ALLOW);

				if (!world.isRemote)
				{
					if (rand.nextInt(3) == 0)
					{
						world.setBlockState(pos, FronosBlocks.glass_gem_corn.getDefaultState().withProperty(BlockGlassGemCorn.STAGE, BlockGlassGemCorn.BlockType.state_bottom2), 2);
						world.setBlockState(pos.up(), FronosBlocks.glass_gem_corn.getDefaultState().withProperty(BlockGlassGemCorn.STAGE, BlockGlassGemCorn.BlockType.state_middle1), 2);
						world.setBlockState(pos.up(2), FronosBlocks.glass_gem_corn.getDefaultState().withProperty(BlockGlassGemCorn.STAGE, BlockGlassGemCorn.BlockType.state_top1), 2);
					}
				}
			}
		}
		else if (event.block == FronosBlocks.glass_gem_corn.getDefaultState().withProperty(BlockGlassGemCorn.STAGE, BlockGlassGemCorn.BlockType.state_middle1))
		{
			event.setResult(Result.ALLOW);

			if (!world.isRemote)
			{
				if (rand.nextInt(2) == 0)
				{
					world.setBlockState(pos, FronosBlocks.glass_gem_corn.getStateFromMeta(rand.nextInt(2) + 4), 2);
				}
			}
		}
		else if (event.block == FronosBlocks.glass_gem_corn.getDefaultState().withProperty(BlockGlassGemCorn.STAGE, BlockGlassGemCorn.BlockType.state_middle2))
		{
			event.setResult(Result.ALLOW);

			if (!world.isRemote)
			{
				if (rand.nextInt(1) == 0)
				{
					world.setBlockState(pos, FronosBlocks.glass_gem_corn.getStateFromMeta(5), 2);
				}
			}
		}
		else if (block == FronosBlocks.fronos_dandelion)
		{
			if (event.block == FronosBlocks.fronos_dandelion.getDefaultState().withProperty(BlockDandelion.VARIANT, BlockDandelion.BlockType.young_orange_dandelion))
			{
				event.setResult(Result.ALLOW);

				if (!world.isRemote)
				{
					if (rand.nextInt(2) == 0)
					{
						world.setBlockState(pos, FronosBlocks.fronos_dandelion.getDefaultState().withProperty(BlockDandelion.VARIANT, BlockDandelion.BlockType.orange_dandelion), 2);
					}
				}
			}
			if (event.block == FronosBlocks.fronos_dandelion.getDefaultState().withProperty(BlockDandelion.VARIANT, BlockDandelion.BlockType.young_pink_dandelion))
			{
				event.setResult(Result.ALLOW);

				if (!world.isRemote)
				{
					if (rand.nextInt(2) == 0)
					{
						world.setBlockState(pos, FronosBlocks.fronos_dandelion.getDefaultState().withProperty(BlockDandelion.VARIANT, BlockDandelion.BlockType.pink_dandelion), 2);
					}
				}
			}
			if (event.block == FronosBlocks.fronos_dandelion.getDefaultState().withProperty(BlockDandelion.VARIANT, BlockDandelion.BlockType.young_purple_dandelion))
			{
				event.setResult(Result.ALLOW);

				if (!world.isRemote)
				{
					if (rand.nextInt(2) == 0)
					{
						world.setBlockState(pos, FronosBlocks.fronos_dandelion.getDefaultState().withProperty(BlockDandelion.VARIANT, BlockDandelion.BlockType.purple_dandelion), 2);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		EntityLivingBase living = event.entityLiving;
		World world = living.worldObj;

		if (living instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP)living;

			this.spawnFeces(world, player);
			this.doInfectedGasForEntity(world, living, player);
			this.doSiriusFire(world, living);
			this.removeIcyPoison(player);

			if (world.provider instanceof IMeteorType)
			{
				this.spawnMeteor(world, player, (IMeteorType)world.provider);
			}
			else if (world.provider instanceof ILightningStorm)
			{
				this.spawnLightningBolt(world, player);
			}
			if ((player.isPotionActive(MPPotions.infected_gas.id) || player.isPotionActive(MPPotions.icy_poison.id)) && MorePlanetsEvents.getTier3ThermalArmor(player))
			{
				player.removePotionEffect(MPPotions.infected_gas.id);
				player.removePotionEffect(MPPotions.icy_poison.id);
			}
		}
		this.potionTick(living);
	}

	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		World world = event.world;
		BlockPos pos = event.target.getBlockPos();
		Block block = world.getBlockState(pos).getBlock();

		MorePlanetsEvents.registerBucket(event, world, pos, KapteynBBlocks.frozen_water, new ItemStack(KapteynBItems.frozen_water_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, PolongniusBlocks.cheese_of_milk, new ItemStack(PolongniusItems.cheese_of_milk_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, FronosBlocks.coconut_milk, new ItemStack(FronosItems.coconut_milk_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, FronosBlocks.mineral_water, new ItemStack(FronosItems.mineral_water_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, FronosBlocks.ovaltine, new ItemStack(FronosItems.ovaltine_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, FronosBlocks.tea, new ItemStack(FronosItems.tea_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, FronosBlocks.caramel, new ItemStack(FronosItems.caramel_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, SiriusBBlocks.sirius_lava, new ItemStack(SiriusBItems.sirius_lava_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, IoBlocks.io_lava, new ItemStack(IoItems.io_lava_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, IoBlocks.red_liquid_sulfur, new ItemStack(IoItems.red_liquid_sulfur_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, IoBlocks.yellow_liquid_sulfur, new ItemStack(IoItems.yellow_liquid_sulfur_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, IoBlocks.orange_liquid_sulfur, new ItemStack(IoItems.orange_liquid_sulfur_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, IoBlocks.brown_liquid_sulfur, new ItemStack(IoItems.brown_liquid_sulfur_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, IoBlocks.black_io_lava, new ItemStack(IoItems.black_io_lava_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, MercuryBlocks.dirty_water, new ItemStack(MercuryItems.dirty_water_bucket), false);
		MorePlanetsEvents.registerBucket(event, world, pos, EuropaBlocks.europa_water, new ItemStack(EuropaItems.europa_water_bucket), false);

		if (block == PlutoBlocks.liquid_methane)
		{
			if (event.current.getItem() == Items.bucket)
			{
				event.setCanceled(true);
			}
			else
			{
				//world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				//event.result = new ItemStack(IoItems.liquid_brown_sulfur_bucket);
				//event.setResult(Result.ALLOW);
			}
		}
		else if (block == PlutoBlocks.liquid_nitrogen)
		{
			if (event.current.getItem() == Items.bucket)
			{
				event.setCanceled(true);
			}
			else
			{
				//world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				//event.result = new ItemStack(IoItems.liquid_brown_sulfur_bucket);
				//event.setResult(Result.ALLOW);
			}
		}
	}

	@SubscribeEvent
	public void interactEntityWithDye(EntityInteractEvent event)
	{
		ItemStack itemstack = event.entityPlayer.getCurrentEquippedItem();
		Entity entity = event.target;

		if (itemstack != null)
		{
			int meta = itemstack.getItemDamage() & 15;

			if (itemstack.getItem() == Items.dye && meta >= 0)
			{
				EnumDyeColor color = EnumDyeColor.byDyeDamage(meta);

				if (entity instanceof EntityGrappy)
				{
					EntityGrappy grappy = (EntityGrappy)entity;

					if (!grappy.getSheared() && grappy.getFleeceColor() != color)
					{
						grappy.setFleeceColor(color);

						if (!event.entityPlayer.capabilities.isCreativeMode)
						{
							--itemstack.stackSize;
						}
					}
					event.setResult(Result.ALLOW);
				}
			}
		}
	}

	private void potionTick(EntityLivingBase living)
	{
		if (living.isPotionActive(MPPotions.infected_gas))
		{
			if (living.ticksExisted % 35 == 0)
			{
				living.attackEntityFrom(DamageSourceMP.infected_gas, 1.0F + living.getActivePotionEffect(MPPotions.infected_gas).getAmplifier());
			}
			if (living.getActivePotionEffect(MPPotions.infected_gas).getDuration() == 0)
			{
				living.removePotionEffect(MPPotions.infected_gas.id);
			}
		}
		else if (living.isPotionActive(MPPotions.chemical))
		{
			if (living.ticksExisted % 8 == 0)
			{
				living.attackEntityFrom(DamageSourceMP.chemical, 1.0F + living.getActivePotionEffect(MPPotions.chemical).getAmplifier());
			}
			if (living.getActivePotionEffect(MPPotions.chemical).getDuration() == 0)
			{
				living.removePotionEffect(MPPotions.chemical.id);
			}
		}
		else if (living.isPotionActive(MPPotions.electro_magnetic_pulse))
		{
			if (!living.worldObj.isRemote)
			{
				living.motionX = 0.0F;
				living.motionY = -1.0F;
				living.motionZ = 0.0F;
			}
			if (living.getActivePotionEffect(MPPotions.electro_magnetic_pulse).getDuration() == 0)
			{
				living.removePotionEffect(MPPotions.electro_magnetic_pulse.id);
			}
		}
		else if (living.isPotionActive(MPPotions.icy_poison))
		{
			living.attackEntityFrom(DamageSourceMP.icy_poison, 1.0F + living.getActivePotionEffect(MPPotions.icy_poison).getAmplifier());

			if (living.getActivePotionEffect(MPPotions.icy_poison).getDuration() == 0)
			{
				living.removePotionEffect(MPPotions.icy_poison.id);
			}
		}
	}

	private void spawnFeces(World world, EntityPlayerMP player)
	{
		if (world.provider instanceof WorldProviderMars)
		{
			if (world.getWorldTime() == 7000L)
			{
				EntityItem item = new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(MPItems.feces));
				item.setDefaultPickupDelay();
				world.playSoundAtEntity(player, "mob.chicken.plop", 0.75F, (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F + 0.6F);
				world.spawnEntityInWorld(item);
			}
			if (world.getWorldTime() == 12000L)
			{
				EntityItem item = new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(MPItems.feces));
				item.setDefaultPickupDelay();
				world.playSoundAtEntity(player, "mob.chicken.plop", 0.75F, (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F + 0.6F);
				world.spawnEntityInWorld(item);
			}
		}
	}

	private void spawnMeteor(World world, EntityPlayerMP player, IMeteorType type)
	{
		Entity meteor = null;

		if (FMLCommonHandler.instance().getEffectiveSide() != Side.CLIENT)
		{
			if (((IMeteorType)world.provider).getMeteorSpawnFrequency() > 0.0D)
			{
				int f = (int) (((IMeteorType)world.provider).getMeteorSpawnFrequency() * 1000D);

				if (world.rand.nextInt(f) == 0)
				{
					EntityPlayer closestPlayer = world.getClosestPlayerToEntity(player, 100);

					if (closestPlayer == null || closestPlayer.getEntityId() <= player.getEntityId())
					{
						int x, y, z;
						double motX, motZ;
						x = world.rand.nextInt(20) - 10;
						y = world.rand.nextInt(20) + 200;
						z = world.rand.nextInt(20) - 10;
						motX = world.rand.nextDouble() * 5;
						motZ = world.rand.nextDouble() * 5;

						switch (type.getMeteorEventType())
						{
						case 0:
							meteor = new EntityPolongniusMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 1);
							break;
						case 1:
							meteor = new EntityKoentusMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 1);
							break;
						case 2:
							meteor = new EntityIceCrystalMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 1);
							break;
						}

						if (!world.isRemote)
						{
							world.spawnEntityInWorld(meteor);
							MPLog.debug("Spawn %s at %s %s %s", meteor.getClass().getSimpleName(), (int)meteor.posX, (int)meteor.posY, (int)meteor.posZ);
						}
					}
				}
				if (world.rand.nextInt(f * 3) == 0)
				{
					EntityPlayer closestPlayer = world.getClosestPlayerToEntity(player, 100);

					if (closestPlayer == null || closestPlayer.getEntityId() <= player.getEntityId())
					{
						int x, y, z;
						double motX, motZ;
						x = world.rand.nextInt(20) - 10;
						y = world.rand.nextInt(20) + 200;
						z = world.rand.nextInt(20) - 10;
						motX = world.rand.nextDouble() * 5;
						motZ = world.rand.nextDouble() * 5;

						switch (type.getMeteorEventType())
						{
						case 0:
							meteor = new EntityPolongniusMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 1);
							break;
						case 1:
							meteor = new EntityKoentusMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 1);
							break;
						case 2:
							meteor = new EntityIceCrystalMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 1);
							break;
						}

						if (!world.isRemote)
						{
							world.spawnEntityInWorld(meteor);
							MPLog.debug("Spawn %s at %s %s %s", meteor.getClass().getSimpleName(), (int)meteor.posX, (int)meteor.posY, (int)meteor.posZ);
						}
					}
				}
			}
		}
	}

	private void spawnLightningBolt(World world, EntityPlayerMP player)
	{
		if (FMLCommonHandler.instance().getEffectiveSide() != Side.CLIENT)
		{
			if (((ILightningStorm)world.provider).getLightningStormFrequency() > 0.0D)
			{
				int f = (int)(((ILightningStorm)world.provider).getLightningStormFrequency() * 1000D);

				if (world.rand.nextInt(f) == 0)
				{
					EntityPlayer closestPlayer = world.getClosestPlayerToEntity(player, 100);

					if (closestPlayer == null || closestPlayer.getEntityId() <= player.getEntityId())
					{
						double x = player.posX + world.rand.nextInt(25) - 5;
						double y = player.posY + world.rand.nextInt(10);
						double z = player.posZ + world.rand.nextInt(25) - 5;
						EntityLightningBolt lightning = new EntityLightningBolt(world, x, y, z);

						if (!world.isRemote)
						{
							world.spawnEntityInWorld(lightning);
							MPLog.debug("Spawn Bolt at %s %s %s", (int)lightning.posX, (int)lightning.posY, (int)lightning.posZ);
						}
					}
				}
				if (world.rand.nextInt(f * 3) == 0)
				{
					EntityPlayer closestPlayer = world.getClosestPlayerToEntity(player, 100);

					if (closestPlayer == null || closestPlayer.getEntityId() <= player.getEntityId())
					{
						double x = player.posX + world.rand.nextInt(25) - 5;
						double y = player.posY + world.rand.nextInt(10);
						double z = player.posZ + world.rand.nextInt(25) - 5;
						EntityLightningBolt lightning = new EntityLightningBolt(world, x, y, z);

						if (!world.isRemote)
						{
							for (int i = 0; i < 3; i++)
							{
								world.spawnEntityInWorld(lightning);
								MPLog.debug("Spawn Bolt at %s %s %s", (int)lightning.posX, (int)lightning.posY, (int)lightning.posZ);
							}
						}
					}
				}
			}
		}
	}

	private void doInfectedGasForEntity(World world, EntityLivingBase living, EntityPlayerMP player)
	{
		if (world.provider instanceof WorldProviderNibiru)
		{
			if (!(living instanceof EntityPlayerMP))
			{
				if (living.ticksExisted % 100 == 0 && (!(living instanceof IEntityLivingPlanet) || !(world.provider.getDimensionId() == ((IEntityLivingPlanet)living).canLivingInDimension().dimID)) && !(living.getClass() == EntityEvolvedZombie.class || living.getClass() == EntityEvolvedSpider.class || living.getClass() == EntityEvolvedSkeleton.class || living.getClass() == EntityEvolvedCreeper.class || living.getClass() == EntityEvolvedEnderman.class))
				{
					living.addPotionEffect(new PotionEffect(MPPotions.infected_gas.id, 80));
				}
			}
			if (ConfigManagerMP.disableInfectedGas)
			{
				if (player.isPotionActive(MPPotions.infected_gas.id) && MorePlanetsEvents.getTier2ThermalArmor(player))
				{
					player.removePotionEffect(MPPotions.infected_gas.id);
				}
			}
			else
			{
				if (!MorePlanetsEvents.getTier2ThermalArmor(player))
				{
					if (player.ticksExisted % 200 == 0 && !player.capabilities.isCreativeMode)
					{
						player.addPotionEffect(new PotionEffect(MPPotions.infected_gas.id, 80));
					}
				}
				else
				{
					player.removePotionEffect(MPPotions.infected_gas.id);
				}
			}
		}
		if (player.isPotionActive(MPPotions.infected_gas.id))
		{
			if (player.ticksExisted % 2000 == 0 && !player.capabilities.isCreativeMode)
			{
				player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + StatCollector.translateToLocal("message.warning.infected.gas")));
			}
		}
	}

	private void doSiriusFire(World world, EntityLivingBase living)
	{
		if (world.provider instanceof WorldProviderSiriusB)
		{
			if (!(living instanceof EntityPlayerMP))
			{
				if (living.ticksExisted % 100 == 0 && (!(living instanceof IEntityLivingPlanet) || !(world.provider.getDimensionId() == ((IEntityLivingPlanet)living).canLivingInDimension().dimID)))
				{
					living.setFire(15);
				}
			}
		}
	}

	private void removeIcyPoison(EntityPlayerMP player)
	{
		InventoryPlayer inventory = player.inventory;
		boolean armor1 = inventory.armorInventory[0] != null && inventory.armorInventory[0].getItem() == KapteynBArmorItems.ice_crystal_boots;
		boolean armor2 = inventory.armorInventory[1] != null && inventory.armorInventory[1].getItem() == KapteynBArmorItems.ice_crystal_leggings;
		boolean armor3 = inventory.armorInventory[2] != null && inventory.armorInventory[2].getItem() == KapteynBArmorItems.ice_crystal_chestplate;
		boolean armor4 = inventory.armorInventory[3] != null && inventory.armorInventory[3].getItem() == KapteynBArmorItems.ice_crystal_helmet || inventory.armorInventory[3] != null && inventory.armorInventory[3].getItem() == KapteynBArmorItems.breathable_ice_crystal_helmet;
		boolean fullArmor = armor1 && armor2 && armor3 && armor4;

		if (fullArmor && player.isPotionActive(MPPotions.icy_poison.id))
		{
			player.removePotionEffect(MPPotions.icy_poison.id);
		}
	}

	private void glowSapling(BonemealEvent event, World world, Block block)
	{
		if (event.block == block)
		{
			event.setResult(Result.ALLOW);

			if (!world.isRemote)
			{
				if (world.rand.nextFloat() < 0.45D)
				{
					((BlockSaplingMP)block).grow(world, world.rand, event.pos, event.block);
				}
			}
		}
	}

	private void glowTallGrass(BonemealEvent event, Random rand, int x, int z, Block grass, Block tallGrass, int meta, int randMeta, boolean useRand)
	{
		if (event.block.getBlock() == grass)
		{
			int y = event.pos.getY() + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += rand.nextInt(3) - 1;
					y += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
					z += rand.nextInt(3) - 1;
				}

				BlockPos pos = new BlockPos(x, y, z);

				if (event.world.getBlockState(pos).getBlock().isAir(event.world, pos))
				{
					if (!useRand)
					{
						if (tallGrass.canReplace(event.world, pos, EnumFacing.UP, new ItemStack(tallGrass, 1, meta)))
						{
							event.setResult(Result.ALLOW);

							if (!event.world.isRemote)
							{
								event.world.setBlockState(pos, tallGrass.getStateFromMeta(meta), 2);
							}
						}
					}
					else
					{
						if (tallGrass.canReplace(event.world, pos, EnumFacing.UP, new ItemStack(tallGrass, 1, rand.nextInt(meta) + randMeta)))
						{
							event.setResult(Result.ALLOW);

							if (!event.world.isRemote)
							{
								event.world.setBlockState(pos, tallGrass.getStateFromMeta(rand.nextInt(meta) + randMeta), 2);
							}
						}
					}
				}
			}
		}
	}

	public static void addInfectedGas(EntityPlayer player)
	{
		if (player instanceof EntityPlayerMP)
		{
			EntityPlayerMP playerMP = (EntityPlayerMP)player;

			if (ConfigManagerMP.disableInfectedGas && !MorePlanetsEvents.getTier2ThermalArmor(playerMP))
			{
				playerMP.addPotionEffect(new PotionEffect(MPPotions.infected_gas.id, 80));
			}
		}
	}

	public static boolean getTier2ThermalArmor(EntityPlayerMP player)
	{
		IInventoryGC inv = AccessInventoryGC.getGCInventoryForPlayer(player);
		boolean armor1 = inv.getStackInSlot(6) != null && inv.getStackInSlot(6).getItem() == MPItems.tier_2_thermal_padding && inv.getStackInSlot(6).getItemDamage() == 0;
		boolean armor2 = inv.getStackInSlot(7) != null && inv.getStackInSlot(7).getItem() == MPItems.tier_2_thermal_padding && inv.getStackInSlot(7).getItemDamage() == 1;
		boolean armor3 = inv.getStackInSlot(8) != null && inv.getStackInSlot(8).getItem() == MPItems.tier_2_thermal_padding && inv.getStackInSlot(8).getItemDamage() == 2;
		boolean armor4 = inv.getStackInSlot(9) != null && inv.getStackInSlot(9).getItem() == MPItems.tier_2_thermal_padding && inv.getStackInSlot(9).getItemDamage() == 3;
		return armor1 && armor2 && armor3 && armor4;
	}

	public static boolean getTier3ThermalArmor(EntityPlayerMP player)
	{
		IInventoryGC inv = AccessInventoryGC.getGCInventoryForPlayer(player);
		boolean armor1 = inv.getStackInSlot(6) != null && inv.getStackInSlot(6).getItem() == MPItems.tier_3_thermal_padding && inv.getStackInSlot(6).getItemDamage() == 0;
		boolean armor2 = inv.getStackInSlot(7) != null && inv.getStackInSlot(7).getItem() == MPItems.tier_3_thermal_padding && inv.getStackInSlot(7).getItemDamage() == 1;
		boolean armor3 = inv.getStackInSlot(8) != null && inv.getStackInSlot(8).getItem() == MPItems.tier_3_thermal_padding && inv.getStackInSlot(8).getItemDamage() == 2;
		boolean armor4 = inv.getStackInSlot(9) != null && inv.getStackInSlot(9).getItem() == MPItems.tier_3_thermal_padding && inv.getStackInSlot(9).getItemDamage() == 3;
		return armor1 && armor2 && armor3 && armor4;
	}

	public static boolean getIceCrystalArmor(EntityPlayerMP player)
	{
		InventoryPlayer inventory = player.inventory;
		boolean armor1 = inventory.armorInventory[0] != null && inventory.armorInventory[0].getItem() == KapteynBArmorItems.ice_crystal_boots;
		boolean armor2 = inventory.armorInventory[1] != null && inventory.armorInventory[1].getItem() == KapteynBArmorItems.ice_crystal_leggings;
		boolean armor3 = inventory.armorInventory[2] != null && inventory.armorInventory[2].getItem() == KapteynBArmorItems.ice_crystal_chestplate;
		boolean armor4 = inventory.armorInventory[3] != null && inventory.armorInventory[3].getItem() == KapteynBArmorItems.ice_crystal_helmet || inventory.armorInventory[3] != null && inventory.armorInventory[3].getItem() == KapteynBArmorItems.breathable_ice_crystal_helmet;
		return armor1 && armor2 && armor3 && armor4;
	}

	private static void registerBucket(FillBucketEvent event, World world, BlockPos pos, Block block, ItemStack itemStack, boolean cancelBucket)
	{
		if (world.getBlockState(pos) == block.getDefaultState())
		{
			if (cancelBucket)
			{
				if (event.current.getItem() == Items.bucket)
				{
					event.setCanceled(true);
				}
			}
			else
			{
				world.setBlockToAir(pos);
				event.result = itemStack;
				event.setResult(Result.ALLOW);
			}
		}
	}
}