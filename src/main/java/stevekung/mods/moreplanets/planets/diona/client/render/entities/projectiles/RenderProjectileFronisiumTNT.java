/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.client.render.entities.projectiles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;

public class RenderProjectileFronisiumTNT extends Render
{
    private BlockRendererDispatcher renderBlocks = Minecraft.getMinecraft().getBlockRendererDispatcher();

    public RenderProjectileFronisiumTNT(RenderManager render)
    {
        super(render);
        this.shadowSize = 0.5F;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float par8, float par9)
    {
        BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
        this.bindTexture(TextureMap.locationBlocksTexture);
        GlStateManager.enableCull();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x - 0.5D, (float) y, (float) z + 0.5D);
        blockrendererdispatcher.renderBlockBrightness(DionaBlocks.fronisium_tnt.getDefaultState(), 1.0F);
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return TextureMap.locationBlocksTexture;
    }
}