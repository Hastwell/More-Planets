/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.client.render.entities;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.objmodel.IModelCustom;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityTier7Rocket;

@SideOnly(Side.CLIENT)
public class RenderTier7Rocket extends Render<EntityTier7Rocket>
{
    private ResourceLocation rocketTexture;
    protected IModelCustom rocketModelObj;

    public RenderTier7Rocket(RenderManager render, IModelCustom spaceshipModel, String textureDomain, String texture)
    {
        super(render);
        this.rocketModelObj = spaceshipModel;
        this.rocketTexture = new ResourceLocation(textureDomain, "textures/model/" + texture + ".png");
        this.shadowSize = 2F;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTier7Rocket entity)
    {
        return this.rocketTexture;
    }

    @Override
    public void doRender(EntityTier7Rocket entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        float var24 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks + 180;
        GlStateManager.translate((float) x, (float) y - 0.4F, (float) z);
        GlStateManager.rotate(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-var24, 0.0F, 0.0F, 1.0F);
        float var28 = entity.rollAmplitude / 3 - partialTicks;
        float var30 = entity.shipDamage - partialTicks;

        if (var30 < 0.0F)
        {
            var30 = 0.0F;
        }
        if (var28 > 0.0F)
        {
            float i = entity.getLaunched() ? (5 - MathHelper.floor_double(entity.timeUntilLaunch / 85)) / 10F : 0.3F;
            GlStateManager.rotate(MathHelper.sin(var28) * var28 * i * partialTicks, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(MathHelper.sin(var28) * var28 * i * partialTicks, 1.0F, 0.0F, 1.0F);
        }

        this.bindEntityTexture(entity);
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        this.rocketModelObj.renderOnly("Boosters", "Rocket");
        Vector3 teamColor = ClientUtil.updateTeamColor(FMLClientHandler.instance().getClient().thePlayer.getGameProfile().getName(), true);

        if (teamColor != null)
        {
            GlStateManager.color(teamColor.floatX(), teamColor.floatY(), teamColor.floatZ());
        }

        this.rocketModelObj.renderPart("NoseCone");

        if (FMLClientHandler.instance().getClient().thePlayer.ticksExisted / 10 % 2 < 1)
        {
            GlStateManager.color(1, 0, 0);
        }
        else
        {
            GlStateManager.color(0, 1, 0);
        }

        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        this.rocketModelObj.renderPart("Cube");
        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.color(1, 1, 1);
        GlStateManager.popMatrix();
    }
}