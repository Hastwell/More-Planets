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
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.moons.europa.client.render.entities.RenderEuropaGuardian;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaGuardian;

@SideOnly(Side.CLIENT)
public class LayerEuropaGuardianEyes implements LayerRenderer<EntityEuropaGuardian>
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/europa_guardian_eyes.png");
    private ResourceLocation texture2 = new ResourceLocation("moreplanets:textures/entity/europa_guardian_elder_eyes.png");
    private RenderEuropaGuardian render;

    public LayerEuropaGuardianEyes(RenderEuropaGuardian render)
    {
        this.render = render;
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return false;
    }

    @Override
    public void doRenderLayer(EntityEuropaGuardian entity, float par2, float par3, float partialTicks, float par5, float par6, float par7, float scale)
    {
        if (!entity.isElder())
        {
            this.render.bindTexture(this.texture);
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
            this.render.getMainModel().render(entity, par2, par3, par5, par6, par7, scale);
            this.render.func_177105_a(entity, partialTicks);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
        }
        else
        {
            this.render.bindTexture(this.texture2);
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
            this.render.getMainModel().render(entity, par2, par3, par5, par6, par7, scale);
            this.render.func_177105_a(entity, partialTicks);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
        }
    }
}