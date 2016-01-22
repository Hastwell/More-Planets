/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.client.render.entities;

import micdoodle8.mods.galacticraft.core.client.model.ModelMeteor;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.polongnius.entities.EntityPolongniusMeteor;

@SideOnly(Side.CLIENT)
public class RenderPolongniusMeteor extends Render<EntityPolongniusMeteor>
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/polongnius_meteor.png");
    private ModelMeteor modelMeteor = new ModelMeteor();

    public RenderPolongniusMeteor(RenderManager render)
    {
        super(render);
        this.shadowSize = 1F;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPolongniusMeteor entity)
    {
        return this.texture;
    }

    @Override
    public void doRender(EntityPolongniusMeteor entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x, (float) y, (float) z);
        GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entityYaw, 1.0F, 0.0F, 0.0F);
        float f = entity.getSize();
        GlStateManager.scale(f / 2, f / 2, f / 2);
        this.bindEntityTexture(entity);
        this.modelMeteor.render(entity, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.1F);
        GlStateManager.popMatrix();
    }
}