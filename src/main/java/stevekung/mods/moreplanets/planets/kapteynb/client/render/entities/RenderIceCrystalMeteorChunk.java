/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.client.render.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.objmodel.AdvancedModelLoader;
import stevekung.mods.moreplanets.client.objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderIceCrystalMeteorChunk extends Render
{
    private ResourceLocation meteorChunkTexture = new ResourceLocation("moreplanets:textures/entity/ice_crystal_meteor_chunk.png");
    private IModelCustom meteorChunkModel = AdvancedModelLoader.loadModel(new ResourceLocation("galacticraftcore:models/meteorChunk.obj"));

    public RenderIceCrystalMeteorChunk(RenderManager render)
    {
        super(render);
        this.shadowSize = 0.1F;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.meteorChunkTexture;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        float var24 = entity.rotationPitch;
        float var24b = entity.rotationYaw;
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.scale(0.3F, 0.3F, 0.3F);
        GlStateManager.rotate(var24b, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(var24, 0.0F, 0.0F, 1.0F);
        this.bindTexture(this.meteorChunkTexture);
        this.meteorChunkModel.renderAll();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
}