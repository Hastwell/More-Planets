/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.renderer.entities.layers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.model.ModelEvolvedWitch;
import stevekung.mods.moreplanets.client.renderer.entities.RenderEvolvedWitch;
import stevekung.mods.moreplanets.common.entities.EntityEvolvedWitch;

@SideOnly(Side.CLIENT)
public class LayerHeldItemEvolvedWitch implements LayerRenderer
{
	private RenderEvolvedWitch render;

	public LayerHeldItemEvolvedWitch(RenderEvolvedWitch render)
	{
		this.render = render;
	}

	public void func_177143_a(EntityEvolvedWitch p_177143_1_, float p_177143_2_, float p_177143_3_, float p_177143_4_, float p_177143_5_, float p_177143_6_, float p_177143_7_, float p_177143_8_)
	{
		ItemStack itemstack = p_177143_1_.getHeldItem();

		if (itemstack != null)
		{
			GlStateManager.color(1.0F, 1.0F, 1.0F);
			GlStateManager.pushMatrix();

			if (this.render.getMainModel().isChild)
			{
				GlStateManager.translate(0.0F, 0.625F, 0.0F);
				GlStateManager.rotate(-20.0F, -1.0F, 0.0F, 0.0F);
				float f7 = 0.5F;
				GlStateManager.scale(f7, f7, f7);
			}

			((ModelEvolvedWitch)this.render.getMainModel()).villagerNose.postRender(0.0625F);
			GlStateManager.translate(-0.0625F, 0.53125F, 0.21875F);
			Item item = itemstack.getItem();
			Minecraft minecraft = Minecraft.getMinecraft();
			float f8;

			if (item instanceof ItemBlock && minecraft.getBlockRendererDispatcher().isRenderTypeChest(Block.getBlockFromItem(item), itemstack.getMetadata()))
			{
				GlStateManager.translate(0.0F, 0.1875F, -0.3125F);
				GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
				GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
				f8 = 0.375F;
				GlStateManager.scale(f8, -f8, f8);
			}
			else if (item == Items.bow)
			{
				GlStateManager.translate(0.0F, 0.125F, 0.3125F);
				GlStateManager.rotate(-20.0F, 0.0F, 1.0F, 0.0F);
				f8 = 0.625F;
				GlStateManager.scale(f8, -f8, f8);
				GlStateManager.rotate(-100.0F, 1.0F, 0.0F, 0.0F);
				GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
			}
			else if (item.isFull3D())
			{
				if (item.shouldRotateAroundWhenRendering())
				{
					GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
					GlStateManager.translate(0.0F, -0.125F, 0.0F);
				}
				this.render.func_82422_c();
				f8 = 0.625F;
				GlStateManager.scale(f8, -f8, f8);
				GlStateManager.rotate(-100.0F, 1.0F, 0.0F, 0.0F);
				GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
			}
			else
			{
				GlStateManager.translate(0.25F, 0.1875F, -0.1875F);
				f8 = 0.375F;
				GlStateManager.scale(f8, f8, f8);
				GlStateManager.rotate(60.0F, 0.0F, 0.0F, 1.0F);
				GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
				GlStateManager.rotate(20.0F, 0.0F, 0.0F, 1.0F);
			}
			GlStateManager.rotate(-15.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(40.0F, 0.0F, 0.0F, 1.0F);
			minecraft.getItemRenderer().renderItem(p_177143_1_, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON);
			GlStateManager.popMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures()
	{
		return false;
	}

	@Override
	public void doRenderLayer(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_)
	{
		this.func_177143_a((EntityEvolvedWitch)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
	}
}