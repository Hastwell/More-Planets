/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.renderer.entities;

import micdoodle8.mods.galacticraft.api.prefab.entity.EntitySpaceshipBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.model.ModelRocketMP;

@SideOnly(Side.CLIENT)
public class RenderRocketMP extends Render
{
	private ResourceLocation resource;
	private String texture;

	public RenderRocketMP(RenderManager render, String texture)
	{
		super(render);
		this.texture = texture;
		this.resource = new ResourceLocation("moreplanets:textures/entity/rocket/" + this.texture + ".png");
		this.shadowSize = 2F;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.resource;
	}

	public void renderSpaceship(EntitySpaceshipBase entity, double x, double y, double z, float par8, float partialTicks)
	{
		GlStateManager.pushMatrix();
		float var24 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
		float var25 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks;
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.rotate(180.0F - par8, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-var24, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(-var25, 0.0F, 1.0F, 0.0F);
		float var28 = entity.rollAmplitude - partialTicks;
		float var30 = entity.shipDamage - partialTicks;

		if (var30 < 0.0F)
		{
			var30 = 0.0F;
		}
		if (var28 > 0.0F)
		{
			float i = entity.getLaunched() ? (5 - MathHelper.floor_double(entity.timeUntilLaunch / 85)) / 10F : 0.3F;
			GlStateManager.rotate(MathHelper.sin(var28) * var28 * i * partialTicks, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(MathHelper.sin(var28) * var28 * i * partialTicks, 1.0F, 0.0F, 1.0F);
		}
		this.bindTexture(this.resource);
		GlStateManager.scale(-1.0F, -1.0F, 1.0F);
		new ModelRocketMP().render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GlStateManager.popMatrix();
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float par8, float partialTicks)
	{
		this.renderSpaceship((EntitySpaceshipBase)entity, x, y, z, par8, partialTicks);
	}
}