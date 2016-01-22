/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.client.render.entities.layers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosCoral;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.RenderTomato;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityTomato;

@SideOnly(Side.CLIENT)
public class LayerTomato implements LayerRenderer<EntityTomato>
{
    private RenderTomato render;

    public LayerTomato(RenderTomato render)
    {
        this.render = render;
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return true;
    }

    @Override
    public void doRenderLayer(EntityTomato entity, float par2, float par3, float partialTicks, float par5, float par6, float par7, float scale)
    {
        if (!entity.isChild() && !entity.isInvisible())
        {
            BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
            this.render.bindTexture(TextureMap.locationBlocksTexture);
            GlStateManager.enableCull();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 0.125F, 0.0F);
            GlStateManager.rotate(180.0F, 180.0F, 1.0F, 0.0F);
            GlStateManager.translate(-0.5F, -0.5F, 0.5F);
            blockrendererdispatcher.renderBlockBrightness(FronosBlocks.fronos_coral.getDefaultState().withProperty(BlockFronosCoral.VARIANT, BlockFronosCoral.BlockType.colunus_coral), 1.0F);
            GlStateManager.popMatrix();
            GlStateManager.disableCull();
        }
    }
}