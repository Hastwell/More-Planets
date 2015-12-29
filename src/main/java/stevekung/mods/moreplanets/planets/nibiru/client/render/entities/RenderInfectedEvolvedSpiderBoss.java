/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.client.render.entities;

import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.nibiru.client.render.entities.layers.LayerInfectedEvolvedSpiderBossEyes;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityEvolvedInfectedSpiderBoss;

@SideOnly(Side.CLIENT)
public class RenderInfectedEvolvedSpiderBoss extends RenderLiving<EntityEvolvedInfectedSpiderBoss>
{
    private ResourceLocation spiderTextures = new ResourceLocation("moreplanets:textures/entity/infected_spider_boss.png");

    public RenderInfectedEvolvedSpiderBoss(RenderManager render)
    {
        super(render, new ModelSpider(), 1.0F);
        this.addLayer(new LayerInfectedEvolvedSpiderBossEyes(this));
    }

    @Override
    public void doRender(EntityEvolvedInfectedSpiderBoss entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        BossStatus.setBossStatus(entity, false);
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityEvolvedInfectedSpiderBoss entity, float partialTickTime)
    {
        GlStateManager.scale(2.0F, 2.0F, 2.0F);
    }

    @Override
    protected float getDeathMaxRotation(EntityEvolvedInfectedSpiderBoss entity)
    {
        return 180.0F;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEvolvedInfectedSpiderBoss entity)
    {
        return this.spiderTextures;
    }
}