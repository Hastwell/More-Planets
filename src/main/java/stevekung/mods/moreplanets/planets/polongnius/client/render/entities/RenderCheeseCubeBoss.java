/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.client.render.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.planets.polongnius.client.model.ModelCheeseCubeEye;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityCheeseCubeEyeBoss;

public class RenderCheeseCubeBoss extends RenderLiving<EntityCheeseCubeEyeBoss>
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/cheese_cube_boss.png");

    public RenderCheeseCubeBoss(RenderManager render)
    {
        super(render, new ModelCheeseCubeEye(), 1.0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCheeseCubeEyeBoss entity)
    {
        return this.texture;
    }

    @Override
    public void doRender(EntityCheeseCubeEyeBoss entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        BossStatus.setBossStatus(entity, false);
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityCheeseCubeEyeBoss entity, float partialTickTime)
    {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
    }
}