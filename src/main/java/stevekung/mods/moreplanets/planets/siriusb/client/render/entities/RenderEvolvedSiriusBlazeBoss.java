/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.client.render.entities;

import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.planets.siriusb.client.render.entities.layers.LayerSiriusBlazeBoss;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntityEvolvedSiriusBlazeBoss;

public class RenderEvolvedSiriusBlazeBoss extends RenderLiving<EntityEvolvedSiriusBlazeBoss>
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/evolved_sirius_blaze_boss.png");

    public RenderEvolvedSiriusBlazeBoss(RenderManager render)
    {
        super(render, new ModelBlaze(), 0.5F);
        this.addLayer(new LayerSiriusBlazeBoss(this));
    }

    @Override
    public void doRender(EntityEvolvedSiriusBlazeBoss entity, double x, double y, double z, float entityYaw, float partialTickTime)
    {
        BossStatus.setBossStatus(entity, false);
        super.doRender(entity, x, y, z, entityYaw, partialTickTime);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEvolvedSiriusBlazeBoss entity)
    {
        return this.texture;
    }

    @Override
    protected void preRenderCallback(EntityEvolvedSiriusBlazeBoss entity, float partialTickTime)
    {
        GlStateManager.scale(4.0F, 4.0F, 4.0F);
    }
}