/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.client.render.entities.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.RenderEvolvedEnderman;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;

@SideOnly(Side.CLIENT)
public class LayerEvolvedEndermanEyes implements LayerRenderer<EntityEvolvedEnderman>
{
    private ResourceLocation eyesTexture = new ResourceLocation("moreplanets:textures/entity/evolved_enderman/evolved_enderman_eyes.png");
    private RenderEvolvedEnderman render;

    public LayerEvolvedEndermanEyes(RenderEvolvedEnderman render)
    {
        this.render = render;
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return false;
    }

    @Override
    public void doRenderLayer(EntityEvolvedEnderman entity, float par2, float par3, float partialTicks, float par5, float par6, float par7, float scale)
    {
        this.render.bindTexture(this.eyesTexture);
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