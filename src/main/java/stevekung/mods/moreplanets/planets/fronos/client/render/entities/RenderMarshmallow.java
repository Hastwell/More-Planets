/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.client.render.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.fronos.client.model.ModelMarshmallow;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityMarshmallow;

@SideOnly(Side.CLIENT)
public class RenderMarshmallow extends RenderLiving
{
    private ResourceLocation marshmallowTextures = new ResourceLocation("moreplanets:textures/entity/marshmallow.png");

    public RenderMarshmallow(RenderManager render)
    {
        super(render, new ModelMarshmallow(), 0.35F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.marshmallowTextures;
    }

    @Override
    public void preRenderCallback(EntityLivingBase living, float par2)
    {
        if (((EntityMarshmallow)living).isSitting())
        {
            GlStateManager.scale(0.8F, 0.8F, 0.8F);
        }
    }
}