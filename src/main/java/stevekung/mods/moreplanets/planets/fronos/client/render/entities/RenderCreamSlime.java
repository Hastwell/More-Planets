/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.client.render.entities;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.layers.LayerCreamSlimeGel;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityCreamSlime;

@SideOnly(Side.CLIENT)
public class RenderCreamSlime extends RenderLiving<EntityCreamSlime>
{
    private ResourceLocation vanillaCreamSlimeTextures = new ResourceLocation("moreplanets:textures/entity/cream_slime/vanilla.png");
    private ResourceLocation strawberryCreamSlimeTextures = new ResourceLocation("moreplanets:textures/entity/cream_slime/strawberry.png");
    private ResourceLocation orangeCreamSlimeTextures = new ResourceLocation("moreplanets:textures/entity/cream_slime/orange.png");
    private ResourceLocation chocolateCreamSlimeTextures = new ResourceLocation("moreplanets:textures/entity/cream_slime/chocolate.png");
    private ResourceLocation teaCreamSlimeTextures = new ResourceLocation("moreplanets:textures/entity/cream_slime/tea.png");
    private ResourceLocation lemonCreamSlimeTextures = new ResourceLocation("moreplanets:textures/entity/cream_slime/lemon.png");

    public RenderCreamSlime(RenderManager render)
    {
        super(render, new ModelSlime(16), 0.25F);
        this.addLayer(new LayerCreamSlimeGel(this));
    }

    @Override
    protected void preRenderCallback(EntityCreamSlime entity, float partialTickTime)
    {
        float f1 = entity.getSlimeSize();
        float f2 = (entity.prevSquishFactor + (entity.squishFactor - entity.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCreamSlime entity)
    {
        switch (entity.getCreamSlimeType())
        {
        case 0:
        default:
            return this.vanillaCreamSlimeTextures;
        case 1:
            return this.chocolateCreamSlimeTextures;
        case 2:
            return this.strawberryCreamSlimeTextures;
        case 3:
            return this.orangeCreamSlimeTextures;
        case 4:
            return this.teaCreamSlimeTextures;
        case 5:
            return this.lemonCreamSlimeTextures;
        }
    }

    @Override
    public void doRender(EntityCreamSlime entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.shadowSize = 0.25F * entity.getSlimeSize();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}