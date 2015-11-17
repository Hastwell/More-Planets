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

import stevekung.mods.moreplanets.client.EffectHandlerMP;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.client.renderer.EntityRendererMP;
import stevekung.mods.moreplanets.client.renderer.ModelRendererMP;
import stevekung.mods.moreplanets.client.renderer.TileEntityItemStackRendererMP;
import stevekung.mods.moreplanets.client.renderer.TileEntityRendererMP;
import stevekung.mods.moreplanets.common.util.BlockVariantsUtil;
import stevekung.mods.moreplanets.common.util.ItemVariantsUtil;
import stevekung.mods.moreplanets.common.util.StateMapperUtil;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.venus.client.model.ModelJetpack;
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
	public void spawnParticle(EnumParticleTypesMP type, double x, double y, double z, double motionX, double motionY, double motionZ)
	{
		EffectHandlerMP.spawnParticle(type, x, y, z, motionX, motionY, motionZ);
	}

	@Override
	public void spawnParticle(EnumParticleTypesMP type, double x, double y, double z)
	{
		EffectHandlerMP.spawnParticle(type, x, y, z);
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
}