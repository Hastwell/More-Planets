/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.client.render.entities;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.venus.client.render.entities.layers.LayerVenusianSlimeGel;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianSlime;

@SideOnly(Side.CLIENT)
public class RenderVenusianSlime extends RenderLiving<EntityVenusianSlime>
{
    private ResourceLocation slimeTextures = new ResourceLocation("moreplanets:textures/entity/venusian_slime.png");

    public RenderVenusianSlime(RenderManager render)
    {
        super(render, new ModelSlime(16), 0.25F);
        this.addLayer(new LayerVenusianSlimeGel(this));
    }

    @Override
    public void doRender(EntityVenusianSlime entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.shadowSize = 0.25F * entity.getSlimeSize();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityVenusianSlime entity, float partialTickTime)
    {
        float f1 = entity.getSlimeSize();
        float f2 = (entity.prevSquishFactor + (entity.squishFactor - entity.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityVenusianSlime entity)
    {
        return this.slimeTextures;
    }
}