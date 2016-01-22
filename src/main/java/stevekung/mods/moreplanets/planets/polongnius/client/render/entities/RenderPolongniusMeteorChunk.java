/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.client.render.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.client.objmodel.AdvancedModelLoader;
import stevekung.mods.moreplanets.client.objmodel.IModelCustom;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityPolongniusMeteorChunk;

public class RenderPolongniusMeteorChunk extends Render<EntityPolongniusMeteorChunk>
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/polongnius_meteor_chunk.png");
    private IModelCustom meteorChunkModel = AdvancedModelLoader.loadModel(new ResourceLocation("galacticraftcore:models/meteorChunk.obj"));

    public RenderPolongniusMeteorChunk(RenderManager render)
    {
        super(render);
        this.shadowSize = 0.1F;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPolongniusMeteorChunk entity)
    {
        return this.texture;
    }

    @Override
    public void doRender(EntityPolongniusMeteorChunk entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        float var24 = entity.rotationPitch;
        float var24b = entity.rotationYaw;
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.scale(0.3F, 0.3F, 0.3F);
        GlStateManager.rotate(var24b, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(var24, 0.0F, 0.0F, 1.0F);
        this.bindTexture(this.texture);
        this.meteorChunkModel.renderAll();
        GlStateManager.popMatrix();
    }
}