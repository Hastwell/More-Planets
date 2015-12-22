/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.client.render.entities;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.polongnius.client.render.entities.layers.LayerCheeseSlimeGel;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityCheeseSlime;

@SideOnly(Side.CLIENT)
public class RenderCheeseSlime extends RenderLiving<EntityCheeseSlime>
{
    private ResourceLocation slimeTextures = new ResourceLocation("moreplanets:textures/entity/cheese_slime.png");

    public RenderCheeseSlime(RenderManager render)
    {
        super(render, new ModelSlime(16), 0.25F);
        this.addLayer(new LayerCheeseSlimeGel(this));
    }

    @Override
    public void doRender(EntityCheeseSlime entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.shadowSize = 0.25F * entity.getSlimeSize();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityCheeseSlime entity, float partialTickTime)
    {
        float f1 = entity.getSlimeSize();
        float f2 = (entity.prevSquishFactor + (entity.squishFactor - entity.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCheeseSlime entity)
    {
        return this.slimeTextures;
    }
}