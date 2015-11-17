/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.renderer.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.model.ModelEvolvedWitch;
import stevekung.mods.moreplanets.client.renderer.entities.layers.LayerHeldItemEvolvedWitch;
import stevekung.mods.moreplanets.common.entities.EntityEvolvedWitch;

@SideOnly(Side.CLIENT)
public class RenderEvolvedWitch extends RenderLiving
{
	private ResourceLocation witchTextures = new ResourceLocation("moreplanets:textures/entity/evolved_witch.png");

	public RenderEvolvedWitch(RenderManager render)
	{
		super(render, new ModelEvolvedWitch(), 0.5F);
		this.addLayer(new LayerHeldItemEvolvedWitch(this));
	}

	public void func_180590_a(EntityEvolvedWitch p_180590_1_, double p_180590_2_, double p_180590_4_, double p_180590_6_, float p_180590_8_, float p_180590_9_)
	{
		((ModelEvolvedWitch)this.mainModel).field_82900_g = p_180590_1_.getHeldItem() != null;
		super.doRender(p_180590_1_, p_180590_2_, p_180590_4_, p_180590_6_, p_180590_8_, p_180590_9_);
	}

	@Override
	public void func_82422_c()
	{
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	@Override
	public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks)
	{
		this.func_180590_a((EntityEvolvedWitch)entity, x, y, z, p_76986_8_, partialTicks);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
	{
		float f1 = 0.9375F;
		GlStateManager.scale(f1, f1, f1);
	}

	@Override
	public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks)
	{
		this.func_180590_a((EntityEvolvedWitch)entity, x, y, z, p_76986_8_, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.witchTextures;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
	{
		this.func_180590_a((EntityEvolvedWitch)entity, x, y, z, p_76986_8_, partialTicks);
	}
}