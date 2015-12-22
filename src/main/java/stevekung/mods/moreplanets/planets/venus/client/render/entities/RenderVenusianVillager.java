/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.client.render.entities;

import micdoodle8.mods.galacticraft.core.client.model.ModelAlienVillager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianVillager;

@SideOnly(Side.CLIENT)
public class RenderVenusianVillager extends RenderLiving<EntityVenusianVillager>
{
    private ResourceLocation villagerTexture = new ResourceLocation("moreplanets:textures/entity/venusian_villager.png");

    public RenderVenusianVillager(RenderManager render)
    {
        super(render, new ModelAlienVillager(0.0F), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityVenusianVillager entity, float partialTickTime)
    {
        float f1 = 0.9375F;

        if (entity.getGrowingAge() < 0)
        {
            f1 = (float) (f1 * 0.5D);
            this.shadowSize = 0.25F;
        }
        else
        {
            this.shadowSize = 0.5F;
        }
        GlStateManager.scale(f1, f1, f1);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityVenusianVillager entity)
    {
        return this.villagerTexture;
    }
}