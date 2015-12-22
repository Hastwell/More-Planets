/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.client.render.entities;

import net.minecraft.client.model.ModelSquid;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.moons.europa.client.render.entities.layer.LayerEuropaSquidEyes;
import stevekung.mods.moreplanets.moons.europa.entities.EntityEuropaSquid;

@SideOnly(Side.CLIENT)
public class RenderEuropaSquid extends RenderLiving<EntityEuropaSquid>
{
    private ResourceLocation squidTextures = new ResourceLocation("moreplanets:textures/entity/europa_squid.png");
    private ResourceLocation squidTextures1 = new ResourceLocation("moreplanets:textures/entity/europa_squid_chemical.png");

    public RenderEuropaSquid(RenderManager render)
    {
        super(render, new ModelSquid(), 0.7F);
        this.addLayer(new LayerEuropaSquidEyes(this));
    }

    @Override
    protected float handleRotationFloat(EntityEuropaSquid entity, float partialTicks)
    {
        return entity.lastTentacleAngle + (entity.tentacleAngle - entity.lastTentacleAngle) * partialTicks;
    }

    @Override
    protected void rotateCorpse(EntityEuropaSquid entity, float p_77043_2_, float entityYaw, float partialTicks)
    {
        float f3 = entity.prevSquidPitch + (entity.squidPitch - entity.prevSquidPitch) * partialTicks;
        float f4 = entity.prevSquidYaw + (entity.squidYaw - entity.prevSquidYaw) * partialTicks;
        GlStateManager.translate(0.0F, 0.5F, 0.0F);
        GlStateManager.rotate(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f3, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(f4, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.0F, -1.2F, 0.0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEuropaSquid entity)
    {
        switch (entity.getSquidType())
        {
        case 0:
        default:
            return this.squidTextures;
        case 1:
            return this.squidTextures1;
        }
    }
}