/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.event;

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
import net.minecraft.block.BlockColored;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
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
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.achievement.AchievementsMP;
import stevekung.mods.moreplanets.core.config.ConfigManagerMP;
import stevekung.mods.moreplanets.core.entities.IEntityLivingPlanet;
import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.core.init.MPPotions;
import stevekung.mods.moreplanets.core.util.DamageSourceMP;
import stevekung.mods.moreplanets.core.world.ILightningStorm;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.europa.items.EuropaItems;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.moons.io.items.IoItems;
import stevekung.mods.moreplanets.moons.koentus.blocks.BlockCrystalSapling;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.moons.koentus.dimension.IKoentusMeteor;
import stevekung.mods.moreplanets.moons.koentus.dimension.WorldProviderKoentus;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusMeteor;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.moreplanets.planets.diona.items.tools.DionaToolsItems;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosSapling;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityGrappy;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.fronos.items.ItemCandyBow;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.dimension.IIceCrystalMeteor;
import stevekung.mods.moreplanets.planets.kapteynb.entities.EntityIceCrystalMeteor;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.mercury.items.MercuryItems;
import stevekung.mods.moreplanets.planets.nibiru.blocks.BlockNibiruSapling;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;
import stevekung.mods.moreplanets.planets.nibiru.dimension.WorldProviderNibiru;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityInfectedZombie;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.pluto.dimension.WorldProviderPluto;
import stevekung.mods.moreplanets.planets.pluto.items.PlutoItems;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.polongnius.dimension.IPolongniusMeteor;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityPolongniusMeteor;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import stevekung.mods.moreplanets.planets.polongnius.items.armor.PolongniusArmorItems;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.siriusb.dimension.WorldProviderSiriusB;
import stevekung.mods.moreplanets.planets.siriusb.items.SiriusBItems;
import stevekung.mods.moreplanets.planets.venus.items.ItemJetpack;
import stevekung.mods.moreplanets.planets.venus.items.VenusItems;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MorePlanetEvents
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
			if (event.entityLiving.worldObj.isAirBlock((int)event.entityLiving.posX, (int)event.entityLiving.posY, (int)event.entityLiving.posZ))
			{
				if (KapteynBBlocks.icy_poison_crystal.canPlaceBlockAt(event.entityLiving.worldObj, (int)event.entityLiving.posX, (int)event.entityLiving.posY, (int)event.entityLiving.posZ))
				{
					if (event.entityLiving.worldObj.rand.nextInt(50) == 0)
					{
						event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX, (int)event.entityLiving.posY, (int)event.entityLiving.posZ, KapteynBBlocks.icy_poison_crystal);
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
		EntityClientPlayerMP player = mc.thePlayer;

		if (Side.CLIENT != null)
		{
			if (player != null && world != null)
			{
				if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == VenusItems.jetpack)
				{
					boolean flag = player.capabilities.isCreativeMode;

					if (!flag && player.inventory.hasItem(Items.coal))
					{
						if (mc.gameSettings.keyBindJump.getIsKeyPressed())
						{
							((ItemJetpack)player.inventory.armorItemInSlot(2).getItem()).setJetpackKeyDown(true);
							player.motionY = 0.5D;
							world.spawnParticle("largesmoke", player.posX, player.posY - 1, player.posZ, 0, -1.0D, 0);
						}
						else if (!mc.gameSettings.keyBindJump.getIsKeyPressed())
						{
							((ItemJetpack)player.inventory.armorItemInSlot(2).getItem()).setJetpackKeyDown(false);
						}

						if (!player.onGround)
						{
							if (mc.gameSettings.keyBindSneak.getIsKeyPressed())
							{
								player.motionY *= 0.85D;
								world.spawnParticle("largesmoke", player.posX, player.posY - 1, player.posZ, 0, -2.0D, 0);
								((ItemJetpack)player.inventory.armorItemInSlot(2).getItem()).setJetpackKeySneak(true);
							}
							else if (!mc.gameSettings.keyBindSneak.getIsKeyPressed())
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
						if (mc.gameSettings.keyBindJump.getIsKeyPressed())
						{
							player.motionY = 0.5D;
							world.spawnParticle("largesmoke", player.posX, player.posY - 1, player.posZ, 0, -1.0D, 0);
						}
						if (!player.onGround)
						{
							if (mc.gameSettings.keyBindSneak.getIsKeyPressed())
							{
								player.motionY *= 0.85D;
								world.spawnParticle("largesmoke", player.posX, player.posY - 1, player.posZ, 0, -2.0D, 0);
							}
						}
					}
				}
			}
		}
	}

	/*@SideOnly(Side.SERVER)
	private void useJetpack()
	{
		MorePlanetsCore.packetPipeline.sendToServer(new PacketUpdateItem());
		MPLog.info("Send packet");
	}*/

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
					event.distance *= 0.1F;
				}
				else if (world.provider instanceof WorldProviderSiriusB)
				{
					event.distance *= 0.45F;
				}
				event.distance *= 0.4F;
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onFOVUpdate(FOVUpdateEvent event)
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
			if (event.celestialBody == MorePlanetsCore.polongnius)
			{
				mc.renderEngine.bindTexture(new ResourceLocation("polongnius:textures/gui/celestialbodies/polongnius_ring.png"));
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
			if (item == DionaItems.tier4_rocket_schematic && meta == 1)
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
		int x = event.x;
		int z = event.z;

		if (event.block == NibiruBlocks.nibiru_sapling)
		{
			event.setResult(Result.ALLOW);

			if (!event.world.isRemote)
			{
				if (event.world.rand.nextFloat() < 0.45D)
				{
					((BlockNibiruSapling)NibiruBlocks.nibiru_sapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
				}
			}
		}
		else if (event.block == KoentusBlocks.crystal_sapling)
		{
			event.setResult(Result.ALLOW);

			if (!event.world.isRemote)
			{
				if (event.world.rand.nextFloat() < 0.45D)
				{
					((BlockCrystalSapling)KoentusBlocks.crystal_sapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
				}
			}
		}
		else if (event.block == FronosBlocks.fronos_sapling)
		{
			event.setResult(Result.ALLOW);

			if (!event.world.isRemote)
			{
				if (event.world.rand.nextFloat() < 0.45D)
				{
					((BlockFronosSapling)FronosBlocks.fronos_sapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
				}
			}
		}
		else if (event.block == FronosBlocks.fronos_grass)
		{
			int var14 = event.y + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += event.world.rand.nextInt(3) - 1;
					var14 += (event.world.rand.nextInt(3) - 1) * event.world.rand.nextInt(3) / 2;
					z += event.world.rand.nextInt(3) - 1;
				}
				if (event.world.getBlock(x, var14, z).isAir(event.world, x, var14, z))
				{
					if (FronosBlocks.fronos_tall_grass.canReplace(event.world, x, var14, z, 0, new ItemStack(FronosBlocks.fronos_tall_grass, 1, rand.nextInt(3))))
					{
						event.setResult(Result.ALLOW);

						if (!event.world.isRemote)
						{
							event.world.setBlock(x, var14, z, FronosBlocks.fronos_tall_grass, rand.nextInt(3), 2);
						}
					}
				}
			}
		}
		else if (event.block == FronosBlocks.pink_grass)
		{
			int var14 = event.y + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += event.world.rand.nextInt(3) - 1;
					var14 += (event.world.rand.nextInt(3) - 1) * event.world.rand.nextInt(3) / 2;
					z += event.world.rand.nextInt(3) - 1;
				}
				if (event.world.getBlock(x, var14, z).isAir(event.world, x, var14, z))
				{
					if (FronosBlocks.fronos_tall_grass.canReplace(event.world, x, var14, z, 0, new ItemStack(FronosBlocks.fronos_tall_grass, 1, rand.nextInt(3) + 3)))
					{
						event.setResult(Result.ALLOW);

						if (!event.world.isRemote)
						{
							event.world.setBlock(x, var14, z, FronosBlocks.fronos_tall_grass, rand.nextInt(3) + 3, 2);
						}
					}
				}
			}
		}
		else if (event.block == FronosBlocks.purple_grass)
		{
			int var14 = event.y + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += event.world.rand.nextInt(3) - 1;
					var14 += (event.world.rand.nextInt(3) - 1) * event.world.rand.nextInt(3) / 2;
					z += event.world.rand.nextInt(3) - 1;
				}
				if (event.world.getBlock(x, var14, z).isAir(event.world, x, var14, z))
				{
					if (FronosBlocks.fronos_tall_grass.canReplace(event.world, x, var14, z, 0, new ItemStack(FronosBlocks.fronos_tall_grass, 1, rand.nextInt(3) + 6)))
					{
						event.setResult(Result.ALLOW);

						if (!event.world.isRemote)
						{
							event.world.setBlock(x, var14, z, FronosBlocks.fronos_tall_grass, rand.nextInt(3) + 6, 2);
						}
					}
				}
			}
		}
		else if (event.block == FronosBlocks.plains_grass)
		{
			int var14 = event.y + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += event.world.rand.nextInt(3) - 1;
					var14 += (event.world.rand.nextInt(3) - 1) * event.world.rand.nextInt(3) / 2;
					z += event.world.rand.nextInt(3) - 1;
				}
				if (event.world.getBlock(x, var14, z).isAir(event.world, x, var14, z))
				{
					if (FronosBlocks.fronos_tall_grass.canReplace(event.world, x, var14, z, 0, new ItemStack(FronosBlocks.fronos_tall_grass, 1, rand.nextInt(3) + 9)))
					{
						event.setResult(Result.ALLOW);

						if (!event.world.isRemote)
						{
							event.world.setBlock(x, var14, z, FronosBlocks.fronos_tall_grass, rand.nextInt(3) + 9, 2);
						}
					}
				}
			}
		}
		else if (event.block == FronosBlocks.golden_grass)
		{
			int var14 = event.y + 1;

			for (int i1 = 0; i1 < 128; ++i1)
			{
				for (int i2 = 0; i2 < i1 / 16; ++i2)
				{
					x += event.world.rand.nextInt(3) - 1;
					var14 += (event.world.rand.nextInt(3) - 1) * event.world.rand.nextInt(3) / 2;
					z += event.world.rand.nextInt(3) - 1;
				}
				if (event.world.getBlock(x, var14, z).isAir(event.world, x, var14, z))
				{
					if (FronosBlocks.fronos_tall_grass.canReplace(event.world, x, var14, z, 0, new ItemStack(FronosBlocks.fronos_tall_grass, 1, rand.nextInt(3) + 12)))
					{
						event.setResult(Result.ALLOW);

						if (!event.world.isRemote)
						{
							event.world.setBlock(x, var14, z, FronosBlocks.fronos_tall_grass, rand.nextInt(3) + 12, 2);
						}
					}
				}
			}
		}
		else if (event.block == FronosBlocks.glass_gem_corn1)
		{
			int y = event.y;

			if (event.world.getBlock(x, y + 1, z).isAir(event.world, x, y + 1, z) && event.world.getBlock(x, y + 2, z).isAir(event.world, x, y + 2, z))
			{
				event.setResult(Result.ALLOW);

				if (!event.world.isRemote)
				{
					if (rand.nextInt(3) == 0)
					{
						event.world.setBlock(x, y, z, FronosBlocks.glass_gem_corn1, 1, 2);
						event.world.setBlock(x, y + 1, z, FronosBlocks.glass_gem_corn2, rand.nextInt(3) + 1, 2);
						event.world.setBlock(x, y + 2, z, FronosBlocks.glass_gem_corn3, 0, 2);
					}
				}
			}
		}
		else if (event.block == FronosBlocks.glass_gem_corn2)
		{
			int y = event.y;

			if (event.world.getBlock(x, y + 1, z).isAir(event.world, x, y + 1, z))
			{
				event.setResult(Result.ALLOW);

				if (!event.world.isRemote)
				{
					if (event.block == FronosBlocks.glass_gem_corn2 && event.world.getBlockMetadata(x, y, z) == 0)
					{
						if (rand.nextInt(2) == 0)
						{
							event.world.setBlock(x, y, z, FronosBlocks.glass_gem_corn2, 1, 2);
							event.world.setBlock(x, y + 1, z, FronosBlocks.glass_gem_corn3, 0, 2);
						}
					}
				}
			}
			if (event.block == FronosBlocks.glass_gem_corn2 && event.world.getBlockMetadata(x, y, z) == 1)
			{
				event.setResult(Result.ALLOW);

				if (!event.world.isRemote)
				{
					if (rand.nextInt(2) == 0)
					{
						event.world.setBlock(x, y, z, FronosBlocks.glass_gem_corn2, rand.nextInt(2) + 1, 2);
					}
				}
			}
			if (event.block == FronosBlocks.glass_gem_corn2 && event.world.getBlockMetadata(x, y, z) == 2)
			{
				event.setResult(Result.ALLOW);

				if (!event.world.isRemote)
				{
					if (rand.nextInt(2) == 0)
					{
						event.world.setBlock(x, y, z, FronosBlocks.glass_gem_corn2, 3, 2);
					}
				}
			}
		}
		else if (event.block == FronosBlocks.dandelion)
		{
			int y = event.y;

			if (event.block == FronosBlocks.dandelion && event.world.getBlockMetadata(x, y, z) == 0)
			{
				event.setResult(Result.ALLOW);

				if (!event.world.isRemote)
				{
					if (rand.nextInt(2) == 0)
					{
						event.world.setBlock(x, y, z, FronosBlocks.dandelion, 3, 2);
					}
				}
			}
			if (event.block == FronosBlocks.dandelion && event.world.getBlockMetadata(x, y, z) == 1)
			{
				event.setResult(Result.ALLOW);

				if (!event.world.isRemote)
				{
					if (rand.nextInt(2) == 0)
					{
						event.world.setBlock(x, y, z, FronosBlocks.dandelion, 4, 2);
					}
				}
			}
			if (event.block == FronosBlocks.dandelion && event.world.getBlockMetadata(x, y, z) == 2)
			{
				event.setResult(Result.ALLOW);

				if (!event.world.isRemote)
				{
					if (rand.nextInt(2) == 0)
					{
						event.world.setBlock(x, y, z, FronosBlocks.dandelion, 5, 2);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		EntityLivingBase entity = event.entityLiving;
		World world = entity.worldObj;

		// Potion tick
		if (entity.isPotionActive(MPPotions.infected_gas))
		{
			if (entity.ticksExisted % 35 == 0)
			{
				entity.attackEntityFrom(DamageSourceMP.infectedGas, 1.0F + entity.getActivePotionEffect(MPPotions.infected_gas).getAmplifier());
			}
			if (entity.getActivePotionEffect(MPPotions.infected_gas).getDuration() == 0)
			{
				entity.removePotionEffect(MPPotions.infected_gas.id);
				return;
			}
		}
		else if (entity.isPotionActive(MPPotions.chemical))
		{
			if (entity.ticksExisted % 8 == 0)
			{
				entity.attackEntityFrom(DamageSourceMP.chemical, 1.0F + entity.getActivePotionEffect(MPPotions.chemical).getAmplifier());
			}
			if (entity.getActivePotionEffect(MPPotions.chemical).getDuration() == 0)
			{
				entity.removePotionEffect(MPPotions.chemical.id);
				return;
			}
		}
		else if (entity.isPotionActive(MPPotions.electro_magnetic_pulse))
		{
			if (!entity.worldObj.isRemote)
			{
				entity.motionX = 0.0F;
				entity.motionY = -1.0F;
				entity.motionZ = 0.0F;
			}
			if (entity.getActivePotionEffect(MPPotions.electro_magnetic_pulse).getDuration() == 0)
			{
				entity.removePotionEffect(MPPotions.electro_magnetic_pulse.id);
				return;
			}
		}
		else if (entity.isPotionActive(MPPotions.icy_poison))
		{
			entity.attackEntityFrom(DamageSourceMP.icy_poison, 1.0F + entity.getActivePotionEffect(MPPotions.icy_poison).getAmplifier());

			if (entity.getActivePotionEffect(MPPotions.icy_poison).getDuration() == 0)
			{
				entity.removePotionEffect(MPPotions.icy_poison.id);
				return;
			}
		}

		if (entity instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP) entity;

			if (world.provider instanceof WorldProviderMars)
			{
				if (world.getWorldTime() == 7000L)
				{
					EntityItem item = new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(MPItems.feces));
					item.delayBeforeCanPickup = 10;
					world.playSoundAtEntity(player, "mob.chicken.plop", 0.75F, (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F + 0.6F);
					world.spawnEntityInWorld(item);
				}
				if (world.getWorldTime() == 12000L)
				{
					EntityItem item = new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(MPItems.feces));
					item.delayBeforeCanPickup = 10;
					world.playSoundAtEntity(player, "mob.chicken.plop", 0.75F, (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F + 0.6F);
					world.spawnEntityInWorld(item);
				}
			}
			if (world.provider instanceof IKoentusMeteor && FMLCommonHandler.instance().getEffectiveSide() != Side.CLIENT)
			{
				if (((IKoentusMeteor) world.provider).getKoentusMeteorFrequency() > 0)
				{
					int f = (int) (((IKoentusMeteor) world.provider).getKoentusMeteorFrequency() * 1000D);

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

							EntityKoentusMeteor meteor = new EntityKoentusMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 1);

							if (!world.isRemote)
							{
								world.spawnEntityInWorld(meteor);
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

							EntityKoentusMeteor meteor = new EntityKoentusMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 6);

							if (!world.isRemote)
							{
								world.spawnEntityInWorld(meteor);
							}
						}
					}
				}
			}
			if (world.provider instanceof IPolongniusMeteor && FMLCommonHandler.instance().getEffectiveSide() != Side.CLIENT)
			{
				if (((IPolongniusMeteor) world.provider).getPolongniusMeteorFrequency() > 0)
				{
					int f = (int) (((IPolongniusMeteor) world.provider).getPolongniusMeteorFrequency() * 1000D);

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

							EntityPolongniusMeteor meteor = new EntityPolongniusMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 1);

							if (!world.isRemote)
							{
								world.spawnEntityInWorld(meteor);
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

							EntityPolongniusMeteor meteor = new EntityPolongniusMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 6);

							if (!world.isRemote)
							{
								world.spawnEntityInWorld(meteor);
							}
						}
					}
				}
			}
			if (world.provider instanceof IIceCrystalMeteor && FMLCommonHandler.instance().getEffectiveSide() != Side.CLIENT)
			{
				if (((IIceCrystalMeteor) world.provider).getIceCrystalMeteorFrequency() > 0)
				{
					int f = (int) (((IIceCrystalMeteor) world.provider).getIceCrystalMeteorFrequency() * 1000D);

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

							EntityIceCrystalMeteor meteor = new EntityIceCrystalMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 1);

							if (!world.isRemote)
							{
								world.spawnEntityInWorld(meteor);
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

							EntityIceCrystalMeteor meteor = new EntityIceCrystalMeteor(world, player.posX + x, player.posY + y, player.posZ + z, motX - 2.5D, 0, motZ - 2.5D, 6);

							if (!world.isRemote)
							{
								world.spawnEntityInWorld(meteor);
							}
						}
					}
				}
			}
			if (world.provider instanceof ILightningStorm && FMLCommonHandler.instance().getEffectiveSide() != Side.CLIENT)
			{
				if (((ILightningStorm)world.provider).getLightningStormFrequency() > 0)
				{
					int f = (int)(((ILightningStorm)world.provider).getLightningStormFrequency() * 1000D);

					if (world.rand.nextInt(f) == 0)
					{
						EntityPlayer closestPlayer = world.getClosestPlayerToEntity(player, 100);

						if (closestPlayer == null || closestPlayer.getEntityId() <= player.getEntityId())
						{
							double x = player.posX + world.rand.nextInt(10) - 5;
							double y = player.posY + world.rand.nextInt(10) + 10;
							double z = player.posZ + world.rand.nextInt(10) - 5;
							EntityLightningBolt lightning = new EntityLightningBolt(world, x, y, z);

							if (!world.isRemote)
							{
								world.spawnEntityInWorld(lightning);
							}
						}
					}

					if (world.rand.nextInt(f * 3) == 0)
					{
						EntityPlayer closestPlayer = world.getClosestPlayerToEntity(player, 100);

						if (closestPlayer == null || closestPlayer.getEntityId() <= player.getEntityId())
						{
							double x = player.posX + world.rand.nextInt(10) - 5;
							double y = player.posY + world.rand.nextInt(10) + 10;
							double z = player.posZ + world.rand.nextInt(10) - 5;
							EntityLightningBolt lightning = new EntityLightningBolt(world, x, y, z);

							if (!world.isRemote)
							{
								for (int i = 0; i < 3; i++)
								{
									world.spawnEntityInWorld(lightning);
								}
							}
						}
					}
				}
			}
		}

		// Nibiru planet
		if (entity.worldObj.provider instanceof WorldProviderNibiru)
		{
			if (!(entity instanceof EntityPlayer))
			{
				if (entity.ticksExisted % 100 == 0 && (!(entity instanceof IEntityLivingPlanet) || !(entity.worldObj.provider.dimensionId == ((IEntityLivingPlanet)entity).canLivingInDimension().dimID)) && !(entity.getClass() == EntityEvolvedZombie.class || entity.getClass() == EntityEvolvedSpider.class || entity.getClass() == EntityEvolvedSkeleton.class || entity.getClass() == EntityEvolvedCreeper.class || entity.getClass() == EntityEvolvedEnderman.class))
				{
					if (!ConfigManagerMP.disableInfectedGas)
					{
						entity.addPotionEffect(new PotionEffect(MPPotions.infected_gas.id, 80));
					}
				}
			}
			if (entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)entity;
				InventoryPlayer inventory = player.inventory;
				IInventoryGC inv = AccessInventoryGC.getGCInventoryForPlayer((EntityPlayerMP) player);
				boolean armor1 = inv.getStackInSlot(6) != null && inv.getStackInSlot(6).getItem() == MPItems.tier_2_thermal_padding && inv.getStackInSlot(6).getItemDamage() == 0;
				boolean armor2 = inventory.armorInventory[1] != null && inventory.armorInventory[1].getItem() == PolongniusArmorItems.purple_crystal_leggings;
				boolean armor3 = inventory.armorInventory[2] != null && inventory.armorInventory[2].getItem() == PolongniusArmorItems.purple_crystal_chestplate;
				boolean armor4 = inventory.armorInventory[3] != null && inventory.armorInventory[3].getItem() == PolongniusArmorItems.purple_crystal_helmet;
				boolean fullArmor = armor1 && armor2 && armor3 && armor4;

				if (ConfigManagerMP.disableInfectedGas)
				{
					if (player.isPotionActive(MPPotions.infected_gas.id) && fullArmor)
					{
						player.removePotionEffect(MPPotions.infected_gas.id);
					}
				}
				if (!ConfigManagerMP.disableInfectedGas)
				{
					if (!fullArmor)
					{
						if (!player.capabilities.isCreativeMode)
						{
							if (player.ticksExisted % 200 == 0)
							{
								player.addPotionEffect(new PotionEffect(MPPotions.infected_gas.id, 80));
							}
						}
					}
					else
					{
						player.removePotionEffect(MPPotions.infected_gas.id);
					}
				}
				if (player.isPotionActive(MPPotions.infected_gas.id))
				{
					if (player.ticksExisted % 2000 == 0)
					{
						player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + StatCollector.translateToLocal("message.warning.infected.gas")));
					}
				}
			}
		}
		// Sirius planet
		else if (entity.worldObj.provider instanceof WorldProviderSiriusB)
		{
			if (!(entity instanceof EntityPlayer))
			{
				if (entity.ticksExisted % 100 == 0 && (!(entity instanceof IEntityLivingPlanet) || !(entity.worldObj.provider.dimensionId == ((IEntityLivingPlanet)entity).canLivingInDimension().dimID)))
				{
					entity.setFire(50);
				}
			}
		}
	}

	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		World world = event.world;
		MovingObjectPosition pos = event.target;
		Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);
		int meta = world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ);

		if (block == KapteynBBlocks.frozen_water && meta == 0)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			event.result = new ItemStack(KapteynBItems.frozen_water_bucket);
			event.setResult(Result.ALLOW);
		}
		else if (block == PolongniusBlocks.cheese_of_milk && meta == 0)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			event.result = new ItemStack(PolongniusItems.cheese_of_milk_bucket);
			event.setResult(Result.ALLOW);
		}
		else if (block == FronosBlocks.coconut_milk && meta == 0)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			event.result = new ItemStack(FronosItems.fronos_bucket, 1, 0);
			event.setResult(Result.ALLOW);
		}
		else if (block == FronosBlocks.mineral_water && meta == 0)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			event.result = new ItemStack(FronosItems.fronos_bucket, 1, 1);
			event.setResult(Result.ALLOW);
		}
		else if (block == FronosBlocks.ovantine && meta == 0)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			event.result = new ItemStack(FronosItems.fronos_bucket, 1, 2);
			event.setResult(Result.ALLOW);
		}
		else if (block == FronosBlocks.tea && meta == 0)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			event.result = new ItemStack(FronosItems.fronos_bucket, 1, 3);
			event.setResult(Result.ALLOW);
		}
		else if (block == FronosBlocks.caramel && meta == 3)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			event.result = new ItemStack(FronosItems.fronos_bucket, 1, 4);
			event.setResult(Result.ALLOW);
		}
		else if (block == SiriusBBlocks.sirius_lava && meta == 0)
		{
			if (event.current.getItem() == Items.bucket)
			{
				event.setCanceled(true);
			}
			else
			{
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				event.result = new ItemStack(SiriusBItems.sirius_lava_bucket);
				event.setResult(Result.ALLOW);
			}
		}
		else if (block == IoBlocks.io_lava)
		{
			if (event.current.getItem() == Items.bucket)
			{
				event.setCanceled(true);
			}
			else
			{
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				event.result = new ItemStack(IoItems.io_lava_bucket);
				event.setResult(Result.ALLOW);
			}
		}
		else if (block == IoBlocks.liquid_red_sulfur)
		{
			if (event.current.getItem() == Items.bucket)
			{
				event.setCanceled(true);
			}
			else
			{
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				event.result = new ItemStack(IoItems.liquid_red_sulfur_bucket);
				event.setResult(Result.ALLOW);
			}
		}
		else if (block == IoBlocks.liquid_yellow_sulfur)
		{
			if (event.current.getItem() == Items.bucket)
			{
				event.setCanceled(true);
			}
			else
			{
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				event.result = new ItemStack(IoItems.liquid_yellow_sulfur_bucket);
				event.setResult(Result.ALLOW);
			}
		}
		else if (block == IoBlocks.liquid_orange_sulfur)
		{
			if (event.current.getItem() == Items.bucket)
			{
				event.setCanceled(true);
			}
			else
			{
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				event.result = new ItemStack(IoItems.liquid_orange_sulfur_bucket);
				event.setResult(Result.ALLOW);
			}
		}
		else if (block == IoBlocks.liquid_brown_sulfur)
		{
			if (event.current.getItem() == Items.bucket)
			{
				event.setCanceled(true);
			}
			else
			{
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				event.result = new ItemStack(IoItems.liquid_brown_sulfur_bucket);
				event.setResult(Result.ALLOW);
			}
		}
		else if (block == IoBlocks.io_black_lava)
		{
			if (event.current.getItem() == Items.bucket)
			{
				event.setCanceled(true);
			}
			else
			{
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				event.result = new ItemStack(IoItems.io_black_lava_bucket);
				event.setResult(Result.ALLOW);
			}
		}
		else if (block == PlutoBlocks.liquid_methane)
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
		else if (block == MercuryBlocks.dirty_water)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			event.result = new ItemStack(MercuryItems.dirty_water_bucket);
			event.setResult(Result.ALLOW);
		}
		else if (block == EuropaBlocks.europa_water)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			event.result = new ItemStack(EuropaItems.europa_water_bucket);
			event.setResult(Result.ALLOW);
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
				int color = BlockColored.func_150032_b(meta);

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

	public static void getActivateInfectedGas(EntityPlayer player)
	{
		IInventoryGC inv = AccessInventoryGC.getGCInventoryForPlayer((EntityPlayerMP) player);
		boolean armor1 = player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].getItem() == PolongniusArmorItems.purple_crystal_boots;
		boolean armor2 = player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].getItem() == PolongniusArmorItems.purple_crystal_leggings;
		boolean armor3 = player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() == PolongniusArmorItems.purple_crystal_chestplate;
		boolean armor4 = player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].getItem() == PolongniusArmorItems.purple_crystal_helmet;
		boolean fullArmor = armor1 && armor2 && armor3 && armor4;

		if (ConfigManagerMP.disableInfectedGas && !fullArmor)
		{
			player.addPotionEffect(new PotionEffect(MPPotions.infected_gas.id, 80));
		}
	}
}