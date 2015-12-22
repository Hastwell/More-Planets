/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.client.render.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.planets.diona.client.model.ModelDionaCreeperBoss;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.layers.LayerDionaCreeperBossCharge;
import stevekung.mods.moreplanets.planets.diona.entities.EntityDionaCreeperBoss;

public class RenderDionaCreeperBoss extends RenderLiving<EntityDionaCreeperBoss>
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/diona_minion_creeper.png");

    public RenderDionaCreeperBoss(RenderManager render)
    {
        super(render, new ModelDionaCreeperBoss(), 1.0F);
        this.addLayer(new LayerDionaCreeperBossCharge(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDionaCreeperBoss entity)
    {
        return this.texture;
    }

    @Override
    public void doRender(EntityDionaCreeperBoss entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        BossStatus.setBossStatus((IBossDisplayData)entity, false);
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityDionaCreeperBoss entity, float partialTickTime)
    {
        GlStateManager.translate(0.0F, 0.5F, 0.0F);
        GlStateManager.scale(3.8F, 3.8F, 3.8F);
    }
}