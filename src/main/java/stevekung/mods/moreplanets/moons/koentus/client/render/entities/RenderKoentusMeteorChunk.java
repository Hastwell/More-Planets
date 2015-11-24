/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.client.render.entities;

import micdoodle8.mods.galacticraft.core.client.objload.AdvancedModelLoader;
import micdoodle8.mods.galacticraft.core.client.objload.IModelCustom;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusMeteorChunk;

public class RenderKoentusMeteorChunk extends Render
{
	private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/koentus_meteor_chunk.png");
	private IModelCustom meteorChunkModel = AdvancedModelLoader.loadModel(new ResourceLocation("galacticraftcore:models/meteorChunk.obj"));

	public RenderKoentusMeteorChunk(RenderManager render)
	{
		super(render);
		this.shadowSize = 0.1F;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.texture;
	}

	public void renderMeteorChunk(EntityKoentusMeteorChunk entity, double x, double y, double z)
	{
		GlStateManager.pushMatrix();
		float var24 = entity.rotationPitch;
		float var24b = entity.rotationYaw;
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.scale(0.3F, 0.3F, 0.3F);
		GlStateManager.rotate(var24b, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(var24, 0.0F, 0.0F, 1.0F);
		this.bindTexture(this.texture);
		this.meteorChunkModel.renderAll();
		GlStateManager.popMatrix();
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float par8, float par9)
	{
		this.renderMeteorChunk((EntityKoentusMeteorChunk)entity, x, y, z);
	}
}