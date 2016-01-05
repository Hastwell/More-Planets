/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.client.render.entities;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.DarkAsteroidBlocks;
import stevekung.mods.moreplanets.asteroids.darkasteroids.entities.EntityDarkAsteroid;

public class RenderDarkAsteroid extends Render
{
    public RenderDarkAsteroid(RenderManager render)
    {
        super(render);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTickTime)
    {
        EntityDarkAsteroid asteroid = (EntityDarkAsteroid) entity;
        this.bindTexture(TextureMap.locationBlocksTexture);
        IBlockState iblockstate = DarkAsteroidBlocks.dark_asteroid_rock.getDefaultState();
        Block block = iblockstate.getBlock();
        BlockPos blockpos = new BlockPos(asteroid);
        World world = asteroid.worldObj;

        if (iblockstate != world.getBlockState(blockpos) && block.getRenderType() != -1)
        {
            if (block.getRenderType() == 3)
            {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)x, (float)y, (float)z);
                GlStateManager.rotate(asteroid.rotationPitch, 1, 0, 0);
                GlStateManager.rotate(asteroid.rotationYaw, 0, 1, 0);
                GlStateManager.disableLighting();
                Tessellator tessellator = Tessellator.getInstance();
                WorldRenderer worldrenderer = tessellator.getWorldRenderer();
                worldrenderer.begin(7, DefaultVertexFormats.BLOCK);
                int i = blockpos.getX();
                int j = blockpos.getY();
                int k = blockpos.getZ();
                worldrenderer.setTranslation((-i) - 0.5F, -j, (-k) - 0.5F);
                BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
                IBakedModel ibakedmodel = blockrendererdispatcher.getModelFromBlockState(iblockstate, world, (BlockPos)null);
                blockrendererdispatcher.getBlockModelRenderer().renderModel(world, ibakedmodel, iblockstate, blockpos, worldrenderer, false);
                worldrenderer.setTranslation(0.0D, 0.0D, 0.0D);
                tessellator.draw();
                GlStateManager.enableLighting();
                GlStateManager.popMatrix();
                super.doRender(entity, x, y, z, p_76986_8_, partialTickTime);
            }
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return TextureMap.locationBlocksTexture;
    }
}