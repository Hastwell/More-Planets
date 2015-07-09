/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.client.render.entities;

import micdoodle8.mods.galacticraft.core.client.objload.AdvancedModelLoader;
import micdoodle8.mods.galacticraft.core.client.objload.IModelCustom;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityPolongniusMeteorChunk;

public class RenderPolongniusMeteorChunk extends Render
{
	private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/polongnius_meteor_chunk.png");
	private IModelCustom meteorChunkModel = AdvancedModelLoader.loadModel(new ResourceLocation("galacticraftcore:models/meteorChunk.obj"));

	public RenderPolongniusMeteorChunk(RenderManager render)
	{
		super(render);
		this.shadowSize = 0.1F;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.texture;
	}

	public void renderMeteorChunk(EntityPolongniusMeteorChunk entity, double par2, double par4, double par6, float par8, float par9)
	{
		GlStateManager.pushMatrix();
		float var24 = entity.rotationPitch;
		float var24b = entity.rotationYaw;
		GlStateManager.translate((float) par2, (float) par4, (float) par6);
		GlStateManager.scale(0.3F, 0.3F, 0.3F);
		GlStateManager.rotate(var24b, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(var24, 0.0F, 0.0F, 1.0F);
		this.bindTexture(this.texture);
		this.meteorChunkModel.renderAll();
		GlStateManager.popMatrix();
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderMeteorChunk((EntityPolongniusMeteorChunk) par1Entity, par2, par4, par6, par8, par9);
	}
}