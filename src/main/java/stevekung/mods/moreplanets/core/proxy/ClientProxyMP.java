/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.proxy;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import org.lwjgl.opengl.GL11;

import stevekung.mods.moreplanets.client.particles.EntityLiquidDripFX;
import stevekung.mods.moreplanets.client.particles.mc.EntityMCBreakingFX;
import stevekung.mods.moreplanets.client.particles.mc.EntityMCExplodeFX;
import stevekung.mods.moreplanets.client.particles.mc.EntityMCHugeExplodeFX;
import stevekung.mods.moreplanets.client.particles.mc.EntityMCLargeExplodeFX;
import stevekung.mods.moreplanets.client.particles.mc.EntityMCSmokeFX;
import stevekung.mods.moreplanets.client.renderer.EntityRendererMP;
import stevekung.mods.moreplanets.client.renderer.ModelRendererMP;
import stevekung.mods.moreplanets.client.renderer.TileEntityItemStackRendererMP;
import stevekung.mods.moreplanets.client.renderer.TileEntityRendererMP;
import stevekung.mods.moreplanets.common.util.BlockVariantsUtil;
import stevekung.mods.moreplanets.common.util.ItemVariantsUtil;
import stevekung.mods.moreplanets.common.util.StateMapperUtil;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.koentus.client.particles.EntityKoentusMeteorSmokeFX;
import stevekung.mods.moreplanets.moons.koentus.client.particles.EntityWhiteCrystalSmokeFX;
import stevekung.mods.moreplanets.planets.diona.client.particles.EntityBluePortalFX;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityBlueFlameFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityCavernOysterFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityCoconutMilkFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityGoldenGrassFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityGoldenSmokeFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityJungleIrisFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityMineralWaterFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityOrangeDandelionFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityOvantineSmokeFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityPinkDandelionFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityPurpleDandelionFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityPurpleSpikeFX;
import stevekung.mods.moreplanets.planets.fronos.client.particles.EntityTeaFluidFX;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.client.particles.EntityGeyserFX;
import stevekung.mods.moreplanets.planets.kapteynb.client.particles.EntityUraniumSmokeFX;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.nibiru.client.particles.EntityGeneratorSmokeFX;
import stevekung.mods.moreplanets.planets.nibiru.client.particles.EntityInfectedSporeFX;
import stevekung.mods.moreplanets.planets.pluto.client.particles.EntityXeoniumSmokeFX;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.polongnius.client.particles.EntityCheeseBubbleFX;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import stevekung.mods.moreplanets.planets.siriusb.client.particles.EntitySiriusFlameFX;
import stevekung.mods.moreplanets.planets.siriusb.client.particles.EntitySiriusLavaFX;
import stevekung.mods.moreplanets.planets.venus.client.model.ModelJetpack;
import stevekung.mods.moreplanets.planets.venus.client.particles.EntityVenusSmokeFX;
import stevekung.mods.moreplanets.planets.venus.items.VenusItems;

public class ClientProxyMP extends CommonProxyMP
{
	public static Map<Item, ModelBiped> jetpackModel = new HashMap<Item, ModelBiped>();
	private static ResourceLocation cheeseOfMilk = new ResourceLocation("moreplanets:textures/overlay/cheese_of_milk.png");
	private static ResourceLocation coconutMilk = new ResourceLocation("moreplanets:textures/overlay/coconut_milk.png");
	private static ResourceLocation mineralWater = new ResourceLocation("moreplanets:textures/overlay/mineral_water.png");
	private static ResourceLocation ovaltine = new ResourceLocation("moreplanets:textures/overlay/ovaltine.png");
	private static ResourceLocation tea = new ResourceLocation("moreplanets:textures/overlay/tea.png");
	private static ResourceLocation caramel = new ResourceLocation("moreplanets:textures/overlay/caramel.png");
	private static ResourceLocation frozenWater = new ResourceLocation("moreplanets:textures/overlay/frozen_water.png");
	private static ResourceLocation dirtyWater = new ResourceLocation("moreplanets:textures/overlay/dirty_water.png");
	private static ResourceLocation europaWater = new ResourceLocation("moreplanets:textures/overlay/europa_water.png");

	@Override
	public void registerRenderer()
	{
		TileEntityItemStackRenderer.instance = new TileEntityItemStackRendererMP();

		EntityRendererMP.init();
		TileEntityRendererMP.registerTileEntityRenderers();
		ModelRendererMP.registerModelRender();
		StateMapperUtil.registerStateMapper();
		BlockVariantsUtil.registerBlockVariants();
		ItemVariantsUtil.registerItemVariants();

		ModelJetpack jetpack = new ModelJetpack(0.75F);
		jetpackModel.put(VenusItems.jetpack, jetpack);
	}

	@Override
	public void spawnMotionParticle(ParticleTypesMP type, double x, double y, double z, double motionX, double motionY, double motionZ)
	{
		EntityFX entityfx = null;
		Minecraft mc = Minecraft.getMinecraft();

		if (type == ParticleTypesMP.KOENTUS_METEOR_SMOKE)
		{
			entityfx = new EntityKoentusMeteorSmokeFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
		}
		else if (type == ParticleTypesMP.CAVERN_OYSTER)
		{
			entityfx = new EntityCavernOysterFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
		}
		else if (type == ParticleTypesMP.INFECTED_SPORE)
		{
			entityfx = new EntityInfectedSporeFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
		}
		else if (type == ParticleTypesMP.BLUE_PORTAL)
		{
			entityfx = new EntityBluePortalFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
		}
		else if (type == ParticleTypesMP.JUNGLE_IRIS)
		{
			entityfx = new EntityJungleIrisFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
		}
		else if (type == ParticleTypesMP.FROZEN_WATER_GEYSER)
		{
			entityfx = new EntityGeyserFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
		}
		else if (type == ParticleTypesMP.MC_NORMAL_SMOKE)
		{
			entityfx = new EntityMCSmokeFX(mc.theWorld, x, y, z, motionX, motionY, motionZ, 1.0F);
		}
		else if (type == ParticleTypesMP.MC_LARGE_SMOKE)
		{
			entityfx = new EntityMCSmokeFX(mc.theWorld, x, y, z, motionX, motionY, motionZ, 2.5F);
		}
		else if (type == ParticleTypesMP.MC_EXPLOSION_NORMAL)
		{
			entityfx = new EntityMCExplodeFX(mc.theWorld, x, y, z, motionX, motionY, motionZ);
		}
		else if (type == ParticleTypesMP.MC_EXPLOSION_LARGE)
		{
			entityfx = new EntityMCLargeExplodeFX(Minecraft.getMinecraft().getTextureManager(), mc.theWorld, x, y, z, motionX, motionY, motionZ);
		}
		mc.effectRenderer.addEffect(entityfx);
	}

	@Override
	public void spawnParticle(ParticleTypesMP type, double x, double y, double z)
	{
		EntityFX entityfx = null;
		Minecraft mc = Minecraft.getMinecraft();

		if (type == ParticleTypesMP.KOENTUS_SLUDGE_DRIP)
		{
			entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.0F, 0.1F, 0.5F, 0.9F, false);
		}
		else if (type == ParticleTypesMP.COCONUT_MILK_DRIP)
		{
			entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 1.0F, 1.0F, 1.0F, 0.9F, false);
		}
		else if (type == ParticleTypesMP.MINERAL_WATER_DRIP)
		{
			entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.4F, 0.7F, 0.8F, 0.6F, false);
		}
		else if (type == ParticleTypesMP.OVALTINE_DRIP)
		{
			entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.65F, 0.4F, 0.25F, 0.9F, false);
		}
		else if (type == ParticleTypesMP.CHEESE_OF_MILK_DRIP)
		{
			entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 1.0F, 0.85F, 0.5F, 0.4F, false);
		}
		else if (type == ParticleTypesMP.FROZEN_WATER_DRIP)
		{
			entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.55F, 0.6F, 0.8F, 0.6F, false);
		}
		else if (type == ParticleTypesMP.TEA_DRIP)
		{
			entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.25F, 0.5F, 0.15F, 0.7F, false);
		}
		else if (type == ParticleTypesMP.CARAMEL_DRIP)
		{
			entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.8F, 0.5F, 0.4F, 0.9F, false);
		}
		else if (type == ParticleTypesMP.SIRIUS_LAVA_DRIP)
		{
			entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.8F, 4.95F, 5.0F, 1.0F, true);
		}
		else if (type == ParticleTypesMP.BLACK_LAVA_DRIP)
		{
			entityfx = new EntityLiquidDripFX(mc.theWorld, x, y, z, 0.1F, 0.1F, 0.1F, 1.0F, true);
		}
		else if (type == ParticleTypesMP.CHEESE_SLIME)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, PolongniusItems.cheese_slimeball, 0);
		}
		else if (type == ParticleTypesMP.VANILLA_CREAM_BALL)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 0);
		}
		else if (type == ParticleTypesMP.CHOCOLATE_CREAM_BALL)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 1);
		}
		else if (type == ParticleTypesMP.STRAWBERRY_CREAM_BALL)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 2);
		}
		else if (type == ParticleTypesMP.ORANGE_CREAM_BALL)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 3);
		}
		else if (type == ParticleTypesMP.TEA_CREAM_BALL)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 4);
		}
		else if (type == ParticleTypesMP.LEMON_CREAM_BALL)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.cream_ball, 5);
		}
		else if (type == ParticleTypesMP.GRAPE_JELLY)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 0);
		}
		else if (type == ParticleTypesMP.RASPBERRY_JELLY)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 1);
		}
		else if (type == ParticleTypesMP.STRAWBERRY_JELLY)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 2);
		}
		else if (type == ParticleTypesMP.BERRY_JELLY)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 3);
		}
		else if (type == ParticleTypesMP.LIME_JELLY)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 4);
		}
		else if (type == ParticleTypesMP.ORANGE_JELLY)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 5);
		}
		else if (type == ParticleTypesMP.GREEN_JELLY)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 6);
		}
		else if (type == ParticleTypesMP.LEMON_JELLY)
		{
			entityfx = new EntityMCBreakingFX(mc.theWorld, x, y, z, FronosItems.jelly, 7);
		}
		else if (type == ParticleTypesMP.ORANGE_DANDELION)
		{
			entityfx = new EntityOrangeDandelionFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.PURPLE_DANDELION)
		{
			entityfx = new EntityPinkDandelionFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.PURPLE_DANDELION)
		{
			entityfx = new EntityPurpleDandelionFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.CHEESE_OF_MILK_BUBBLE)
		{
			entityfx = new EntityCheeseBubbleFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.WHITE_CRYSTAL_SMOKE)
		{
			entityfx = new EntityWhiteCrystalSmokeFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.ICHORIUS_SMOKE)
		{
			entityfx = new EntityGeneratorSmokeFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.PURPLE_SPIKE)
		{
			entityfx = new EntityPurpleSpikeFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.COCONUT_MILK)
		{
			entityfx = new EntityCoconutMilkFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.MINERAL_WATER)
		{
			entityfx = new EntityMineralWaterFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.OVALTINE)
		{
			entityfx = new EntityOvantineSmokeFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.TEA)
		{
			entityfx = new EntityTeaFluidFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.SIRIUS_LAVA)
		{
			entityfx = new EntitySiriusLavaFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.GOLDEN_DUST)
		{
			entityfx = new EntityGoldenGrassFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.GOLDEN_SMOKE)
		{
			entityfx = new EntityGoldenSmokeFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.URANIUM_SMOKE)
		{
			entityfx = new EntityUraniumSmokeFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.SIRIUS_FLAME)
		{
			entityfx = new EntitySiriusFlameFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.BLUE_FLAME)
		{
			entityfx = new EntityBlueFlameFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.VENUS_SMOKE)
		{
			entityfx = new EntityVenusSmokeFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.XEONIUM_SMOKE)
		{
			entityfx = new EntityXeoniumSmokeFX(mc.theWorld, x, y, z);
		}
		else if (type == ParticleTypesMP.MC_EXPLOSION_HUGE)
		{
			entityfx = new EntityMCHugeExplodeFX(mc.theWorld, x, y, z);
		}
		mc.effectRenderer.addEffect(entityfx);
	}

	@Override
	public void resetPlayerFloatingTick(EntityPlayer player)
	{
		if (player instanceof EntityPlayerMP)
		{
			ObfuscationReflectionHelper.setPrivateValue(NetHandlerPlayServer.class, ((EntityPlayerMP)player).playerNetServerHandler, Integer.valueOf(0), new String[] { "field_147365_f", "floatingTickCount" });
		}
	}

	public static void renderFluidOverlays(float partialTicks)
	{
		Minecraft mc = Minecraft.getMinecraft();
		float f1 = mc.thePlayer.getBrightness(partialTicks) / 3.0F;

		if (ClientProxyMP.isInsideOfFluid(PolongniusBlocks.cheese_of_milk_fluid))
		{
			f1 = mc.thePlayer.getBrightness(partialTicks) / 1.0F;
			mc.getTextureManager().bindTexture(cheeseOfMilk);
		}
		else if (ClientProxyMP.isInsideOfFluid(FronosBlocks.coconut_milk_fluid))
		{
			f1 = mc.thePlayer.getBrightness(partialTicks) / 1.0F;
			mc.getTextureManager().bindTexture(coconutMilk);
		}
		else if (ClientProxyMP.isInsideOfFluid(FronosBlocks.mineral_water_fluid))
		{
			f1 = mc.thePlayer.getBrightness(partialTicks) / 0.5F;
			mc.getTextureManager().bindTexture(mineralWater);
		}
		else if (ClientProxyMP.isInsideOfFluid(FronosBlocks.ovaltine_fluid))
		{
			f1 = mc.thePlayer.getBrightness(partialTicks) / 1.0F;
			mc.getTextureManager().bindTexture(ovaltine);
		}
		else if (ClientProxyMP.isInsideOfFluid(FronosBlocks.tea_fluid))
		{
			f1 = mc.thePlayer.getBrightness(partialTicks) / 1.0F;
			mc.getTextureManager().bindTexture(tea);
		}
		else if (ClientProxyMP.isInsideOfFluid(FronosBlocks.caramel_fluid))
		{
			f1 = mc.thePlayer.getBrightness(partialTicks) / 1.0F;
			mc.getTextureManager().bindTexture(caramel);
		}
		else if (ClientProxyMP.isInsideOfFluid(KapteynBBlocks.frozen_water_fluid))
		{
			f1 = mc.thePlayer.getBrightness(partialTicks) / 1.0F;
			mc.getTextureManager().bindTexture(frozenWater);
		}
		else if (ClientProxyMP.isInsideOfFluid(MercuryBlocks.dirty_water_fluid))
		{
			mc.getTextureManager().bindTexture(dirtyWater);
		}
		else if (ClientProxyMP.isInsideOfFluid(EuropaBlocks.europa_water_fluid))
		{
			mc.getTextureManager().bindTexture(europaWater);
		}
		else
		{
			return;
		}

		/*Tessellator tessellator = Tessellator.getInstance();
		GlStateManager.color(f1, f1, f1, 1.0F);
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.pushMatrix();
		float f2 = 4.0F;
		float f3 = -1.0F;
		float f4 = 1.0F;
		float f5 = -1.0F;
		float f6 = 1.0F;
		float f7 = -0.5F;
		float f8 = -mc.thePlayer.rotationYaw / 64.0F;
		float f9 = mc.thePlayer.rotationPitch / 64.0F;
		tessellator.getWorldRenderer().startDrawingQuads();
		tessellator.getWorldRenderer().addVertexWithUV(f3, f5, f7, f2 + f8, f2 + f9);
		tessellator.getWorldRenderer().addVertexWithUV(f4, f5, f7, 0.0F + f8, f2 + f9);
		tessellator.getWorldRenderer().addVertexWithUV(f4, f6, f7, 0.0F + f8, 0.0F + f9);
		tessellator.getWorldRenderer().addVertexWithUV(f3, f6, f7, f2 + f8, 0.0F + f9);
		tessellator.draw();
		GlStateManager.popMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableBlend();*/
		
		Tessellator tessellator = Tessellator.getInstance();
		GL11.glColor4f(f1, f1, f1, 1.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glPushMatrix();
		float f2 = 4.0F;
		float f3 = -1.0F;
		float f4 = 1.0F;
		float f5 = -1.0F;
		float f6 = 1.0F;
		float f7 = -0.5F;
		float f8 = -mc.thePlayer.rotationYaw / 64.0F;
		float f9 = mc.thePlayer.rotationPitch / 64.0F;
		tessellator.getWorldRenderer().startDrawingQuads();
		tessellator.getWorldRenderer().addVertexWithUV(f3, f5, f7, f2 + f8, f2 + f9);
		tessellator.getWorldRenderer().addVertexWithUV(f4, f5, f7, 0.0F + f8, f2 + f9);
		tessellator.getWorldRenderer().addVertexWithUV(f4, f6, f7, 0.0F + f8, 0.0F + f9);
		tessellator.getWorldRenderer().addVertexWithUV(f3, f6, f7, f2 + f8, 0.0F + f9);
		tessellator.draw();
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
	}

	public static boolean isInsideOfFluid(Fluid fluid)
	{
		Minecraft mc = Minecraft.getMinecraft();
		Entity entity = mc.thePlayer;
		double d0 = entity.posY + entity.getEyeHeight();
		int i = MathHelper.floor_double(entity.posX);
		int j = MathHelper.floor_float(MathHelper.floor_double(d0));
		int k = MathHelper.floor_double(entity.posZ);
		Block block = entity.worldObj.getBlockState(new BlockPos(i, j, k)).getBlock();

		if (block != null && block instanceof IFluidBlock && ((IFluidBlock) block).getFluid() != null && ((IFluidBlock) block).getFluid().getName().equals(fluid.getName()))
		{
			double filled = ((IFluidBlock) block).getFilledPercentage(entity.worldObj, new BlockPos(i, j, k));

			if (filled < 0)
			{
				filled *= -1;
				return d0 > j + (1 - filled);
			}
			else
			{
				return d0 < j + filled;
			}
		}
		else
		{
			return false;
		}
	}

	public static enum ParticleTypesMP
	{
		KOENTUS_SLUDGE_DRIP,
		COCONUT_MILK_DRIP,
		MINERAL_WATER_DRIP,
		OVALTINE_DRIP,
		CHEESE_OF_MILK_DRIP,
		FROZEN_WATER_DRIP,
		TEA_DRIP,
		CARAMEL_DRIP,
		SIRIUS_LAVA_DRIP,
		BLACK_LAVA_DRIP,
		CHEESE_SLIME,
		VANILLA_CREAM_BALL,
		CHOCOLATE_CREAM_BALL,
		STRAWBERRY_CREAM_BALL,
		ORANGE_CREAM_BALL,
		TEA_CREAM_BALL,
		LEMON_CREAM_BALL,
		GRAPE_JELLY,
		RASPBERRY_JELLY,
		STRAWBERRY_JELLY,
		BERRY_JELLY,
		LIME_JELLY,
		ORANGE_JELLY,
		GREEN_JELLY,
		LEMON_JELLY,
		ORANGE_DANDELION,
		PINK_DANDELION,
		PURPLE_DANDELION,
		CHEESE_OF_MILK_BUBBLE,
		WHITE_CRYSTAL_SMOKE,
		ICHORIUS_SMOKE,
		PURPLE_SPIKE,
		COCONUT_MILK,
		MINERAL_WATER,
		OVALTINE,
		TEA,
		SIRIUS_LAVA,
		GOLDEN_DUST,
		GOLDEN_SMOKE,
		URANIUM_SMOKE,
		SIRIUS_FLAME,
		BLUE_FLAME,
		KOENTUS_METEOR_SMOKE,
		CAVERN_OYSTER,
		INFECTED_SPORE,
		BLUE_PORTAL,
		JUNGLE_IRIS,
		VENUS_SMOKE,
		FROZEN_WATER_GEYSER,
		XEONIUM_SMOKE,
		MC_NORMAL_SMOKE,
		MC_LARGE_SMOKE,
		MC_EXPLOSION_NORMAL,
		MC_EXPLOSION_LARGE,
		MC_EXPLOSION_HUGE
	}
}