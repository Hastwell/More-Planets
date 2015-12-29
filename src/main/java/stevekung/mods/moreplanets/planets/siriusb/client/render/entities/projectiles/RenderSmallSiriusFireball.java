/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.client.render.entities.projectiles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.siriusb.entities.projectiles.EntitySmallSiriusFireball;
import stevekung.mods.moreplanets.planets.siriusb.items.SiriusBItems;

@SideOnly(Side.CLIENT)
public class RenderSmallSiriusFireball extends Render
{
    public RenderSmallSiriusFireball(RenderManager render)
    {
        super(render);
    }

    public void doRender(EntitySmallSiriusFireball entity, double x, double y, double z, float par5, float partialTicks)
    {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(entity);
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        float f2 = 0.5F;
        GlStateManager.scale(f2 / 1.0F, f2 / 1.0F, f2 / 1.0F);
        TextureAtlasSprite textureatlassprite = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(SiriusBItems.sirius_fire_charge);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        float f3 = textureatlassprite.getMinU();
        float f4 = textureatlassprite.getMaxU();
        float f5 = textureatlassprite.getMinV();
        float f6 = textureatlassprite.getMaxV();
        GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181710_j);
        worldrenderer.func_181662_b(-0.5D, -0.25D, 0.0D).func_181673_a(f3, f6).func_181663_c(0.0F, 1.0F, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0.5D, -0.25D, 0.0D).func_181673_a(f4, f6).func_181663_c(0.0F, 1.0F, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0.5D, 0.75D, 0.0D).func_181673_a(f4, f5).func_181663_c(0.0F, 1.0F, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(-0.5D, 0.75D, 0.0D).func_181673_a(f3, f5).func_181663_c(0.0F, 1.0F, 0.0F).func_181675_d();
        tessellator.draw();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, par5, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return TextureMap.locationBlocksTexture;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float par5, float partialTicks)
    {
        this.doRender((EntitySmallSiriusFireball)entity, x, y, z, par5, partialTicks);
    }
}