/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.renderer.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.model.ModelEvolvedWitch;
import stevekung.mods.moreplanets.client.renderer.entities.layers.LayerHeldItemEvolvedWitch;
import stevekung.mods.moreplanets.common.entities.EntityEvolvedWitch;

@SideOnly(Side.CLIENT)
public class RenderEvolvedWitch extends RenderLiving<EntityEvolvedWitch>
{
    private ResourceLocation witchTextures = new ResourceLocation("moreplanets:textures/entity/evolved_witch.png");

    public RenderEvolvedWitch(RenderManager render)
    {
        super(render, new ModelEvolvedWitch(), 0.5F);
        this.addLayer(new LayerHeldItemEvolvedWitch(this));
    }

    @Override
    public void transformHeldFull3DItemLayer()
    {
        GlStateManager.translate(0.0F, 0.1875F, 0.0F);
    }

    @Override
    public void doRender(EntityEvolvedWitch entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        ((ModelEvolvedWitch)this.mainModel).field_82900_g = entity.getHeldItem() != null;
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityEvolvedWitch entity, float partialTickTime)
    {
        float f1 = 0.9375F;
        GlStateManager.scale(f1, f1, f1);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEvolvedWitch entity)
    {
        return this.witchTextures;
    }
}