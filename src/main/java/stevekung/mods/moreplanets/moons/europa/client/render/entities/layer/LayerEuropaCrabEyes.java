/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.client.render.entities.layer;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.moons.europa.client.render.entities.RenderEuropaCrab;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaCrab;

@SideOnly(Side.CLIENT)
public class LayerEuropaCrabEyes implements LayerRenderer
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/europa_crab_glowing.png");
    private ResourceLocation texture1 = new ResourceLocation("moreplanets:textures/entity/europa_crab_glowing_chemical.png");
    private RenderEuropaCrab render;

    public LayerEuropaCrabEyes(RenderEuropaCrab render)
    {
        this.render = render;
    }

    public void func_177201_a(EntityEuropaCrab entity, float p_177201_2_, float p_177201_3_, float p_177201_4_, float p_177201_5_, float p_177201_6_, float p_177201_7_, float p_177201_8_)
    {
        ResourceLocation res = null;

        if (entity.getCrabType() == 2)
        {
            res = this.texture;
        }
        else if (entity.getCrabType() == 3)
        {
            res = this.texture1;
        }
        this.render.bindTexture(res);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(1, 1);
        GlStateManager.disableLighting();

        if (entity.isInvisible())
        {
            GlStateManager.depthMask(false);
        }
        else
        {
            GlStateManager.depthMask(true);
        }

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.render.getMainModel().render(entity, p_177201_2_, p_177201_3_, p_177201_5_, p_177201_6_, p_177201_7_, p_177201_8_);
        this.render.func_177105_a(entity, p_177201_4_);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return false;
    }

    @Override
    public void doRenderLayer(EntityLivingBase entity, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_)
    {
        if (((EntityEuropaCrab)entity).getCrabType() >= 2)
        {
            this.func_177201_a((EntityEuropaCrab)entity, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
        }
        return;
    }
}