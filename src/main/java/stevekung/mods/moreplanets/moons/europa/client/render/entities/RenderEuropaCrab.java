/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.client.render.entities;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.moons.europa.client.model.ModelEuropaCrab;
import stevekung.mods.moreplanets.moons.europa.client.render.entities.layer.LayerEuropaCrabEyes;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaCrab;

@SideOnly(Side.CLIENT)
public class RenderEuropaCrab extends RenderLiving
{
	private ResourceLocation textures1 = new ResourceLocation("moreplanets:textures/entity/europa_crab.png");
	private ResourceLocation textures2 = new ResourceLocation("moreplanets:textures/entity/black_europa_crab.png");
	private ResourceLocation textures3 = new ResourceLocation("moreplanets:textures/entity/europa_crab_glow.png");

	public RenderEuropaCrab(RenderManager render)
	{
		super(render, new ModelEuropaCrab(), 0.3F);
		this.addLayer(new LayerEuropaCrabEyes(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		EntityEuropaCrab crab = (EntityEuropaCrab)entity;

		switch (crab.getCrabType())
		{
		case 0:
		default:
			return this.textures1;
		case 1:
			return this.textures2;
		case 2:
			return this.textures3;
		case 3:
			return this.textures3;
		}
	}
}