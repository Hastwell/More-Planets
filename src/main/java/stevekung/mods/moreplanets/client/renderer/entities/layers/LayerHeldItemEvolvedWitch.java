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
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
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
public class LayerHeldItemEvolvedWitch implements LayerRenderer<EntityEvolvedWitch>
{
    private RenderEvolvedWitch render;

    public LayerHeldItemEvolvedWitch(RenderEvolvedWitch render)
    {
        this.render = render;
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return false;
    }

    @Override
    public void doRenderLayer(EntityEvolvedWitch entity, float par2, float par3, float partialTicks, float par5, float par6, float par7, float scale)
    {
        ItemStack itemstack = entity.getHeldItem();

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
            Minecraft mc = Minecraft.getMinecraft();
            float f8;

            if (item instanceof ItemBlock && mc.getBlockRendererDispatcher().isRenderTypeChest(Block.getBlockFromItem(item), itemstack.getMetadata()))
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
                this.render.transformHeldFull3DItemLayer();
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
            mc.getItemRenderer().renderItem(entity, itemstack, TransformType.THIRD_PERSON);
            GlStateManager.popMatrix();
        }
    }
}