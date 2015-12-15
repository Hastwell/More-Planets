/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.client.render.entities.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.diona.client.model.ModelDionaCreeperMinion;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.RenderDionaCreeperMinion;
import stevekung.mods.moreplanets.planets.diona.entities.EntityDionaCreeperMinion;

@SideOnly(Side.CLIENT)
public class LayerDionaCreeperMinionCharge implements LayerRenderer
{
    private ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation("moreplanets:textures/entity/creeper_shield.png");
    private RenderDionaCreeperMinion creeperRenderer;
    private ModelDionaCreeperMinion creeperModel = new ModelDionaCreeperMinion(2.0F);

    public LayerDionaCreeperMinionCharge(RenderDionaCreeperMinion render)
    {
        this.creeperRenderer = render;
    }

    public void doRenderLayer(EntityDionaCreeperMinion entity, float par2, float par3, float par4, float par5, float par6, float par7, float par8)
    {
        if (entity.getPowered())
        {
            GlStateManager.depthMask(!entity.isInvisible());
            this.creeperRenderer.bindTexture(this.LIGHTNING_TEXTURE);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            float f7 = entity.ticksExisted + par4;
            GlStateManager.translate(f7 * 0.01F, f7 * 0.01F, 0.0F);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();
            float f8 = 0.5F;
            GlStateManager.color(f8, f8, f8, 1.0F);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(1, 1);
            this.creeperModel.setModelAttributes(this.creeperRenderer.getMainModel());
            this.creeperModel.render(entity, par2, par3, par5, par6, par7, par8);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
        }
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return false;
    }

    @Override
    public void doRenderLayer(EntityLivingBase entity, float par2, float par3, float par4, float par5, float par6, float par7, float par8)
    {
        this.doRenderLayer((EntityDionaCreeperMinion)entity, par2, par3, par4, par5, par6, par7, par8);
    }
}