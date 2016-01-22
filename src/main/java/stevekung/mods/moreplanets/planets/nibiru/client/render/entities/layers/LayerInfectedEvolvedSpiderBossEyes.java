/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.client.render.entities.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.nibiru.client.render.entities.RenderInfectedEvolvedSpiderBoss;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityEvolvedInfectedSpiderBoss;

@SideOnly(Side.CLIENT)
public class LayerInfectedEvolvedSpiderBossEyes implements LayerRenderer<EntityEvolvedInfectedSpiderBoss>
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/infected_spider_eyes.png");
    private RenderInfectedEvolvedSpiderBoss render;

    public LayerInfectedEvolvedSpiderBossEyes(RenderInfectedEvolvedSpiderBoss render)
    {
        this.render = render;
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return false;
    }

    @Override
    public void doRenderLayer(EntityEvolvedInfectedSpiderBoss entity, float par2, float par3, float partialTicks, float par5, float par6, float par7, float scale)
    {
        this.render.bindTexture(this.texture);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(1, 1);

        if (entity.isInvisible())
        {
            GlStateManager.depthMask(false);
        }
        else
        {
            GlStateManager.depthMask(true);
        }
        char c0 = 61680;
        int i = c0 % 65536;
        int j = c0 / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, i / 1.0F, j / 1.0F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.render.getMainModel().render(entity, par2, par3, par5, par6, par7, scale);
        int k = entity.getBrightnessForRender(partialTicks);
        i = k % 65536;
        j = k / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, i / 1.0F, j / 1.0F);
        this.render.func_177105_a(entity, partialTicks);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }
}