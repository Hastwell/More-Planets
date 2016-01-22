/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.client.render.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.diona.client.model.ModelLaser;
import stevekung.mods.moreplanets.planets.diona.entities.projectiles.EntityLaserMP;

@SideOnly(Side.CLIENT)
public class RenderLaserMP extends Render<EntityLaserMP>
{
    private ModelBase model = new ModelLaser();

    public RenderLaserMP(RenderManager render)
    {
        super(render);
    }

    @Override
    public void doRender(EntityLaserMP entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.bindEntityTexture(entity);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLaserMP entity)
    {
        ResourceLocation res = null;

        switch (entity.getLaserType())
        {
        case 0:
        default:
            res = new ResourceLocation("moreplanets:textures/entity/projectiles/laser/laser.png");
            break;
        case 1:
            res = new ResourceLocation("moreplanets:textures/entity/projectiles/laser/hyper.png");
            break;
        case 2:
            res = new ResourceLocation("moreplanets:textures/entity/projectiles/laser/emp.png");
            break;
        case 3:
            res = new ResourceLocation("moreplanets:textures/entity/projectiles/laser/uranium.png");
            break;
        case 4:
            res = new ResourceLocation("moreplanets:textures/entity/projectiles/laser/icy_poison.png");
            break;
        }
        return res;
    }
}