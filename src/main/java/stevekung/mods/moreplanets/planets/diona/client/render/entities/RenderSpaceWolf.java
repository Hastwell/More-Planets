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
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.diona.client.model.ModelSpaceWolf;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.layers.LayerSpaceWolfCollar;
import stevekung.mods.moreplanets.planets.diona.entities.EntitySpaceWolf;

@SideOnly(Side.CLIENT)
public class RenderSpaceWolf extends RenderLiving<EntitySpaceWolf>
{
    private ResourceLocation wolfTextures = new ResourceLocation("moreplanets:textures/entity/space_wolf/space_wolf.png");
    private ResourceLocation tamedWolfTextures = new ResourceLocation("moreplanets:textures/entity/space_wolf/space_wolf_tamed.png");
    private ResourceLocation anrgyWolfTextures = new ResourceLocation("moreplanets:textures/entity/space_wolf/space_wolf_angry.png");

    public RenderSpaceWolf(RenderManager render)
    {
        super(render, new ModelSpaceWolf(), 0.5F);
        this.addLayer(new LayerSpaceWolfCollar(this));
    }

    @Override
    protected float handleRotationFloat(EntitySpaceWolf entity, float partialTicks)
    {
        return entity.getTailRotation();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySpaceWolf entity)
    {
        return entity.isTamed() ? this.tamedWolfTextures : entity.isAngry() ? this.anrgyWolfTextures : this.wolfTextures;
    }

    @Override
    public void doRender(EntitySpaceWolf entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        if (entity.isWolfWet())
        {
            float f2 = entity.getBrightness(partialTicks) * entity.getShadingWhileWet(partialTicks);
            GlStateManager.color(f2, f2, f2);
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}