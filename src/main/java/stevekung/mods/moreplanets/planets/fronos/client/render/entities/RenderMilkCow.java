/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.client.render.entities;

import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityMilkCow;

@SideOnly(Side.CLIENT)
public class RenderMilkCow extends RenderLiving<EntityMilkCow>
{
    private ResourceLocation textures = new ResourceLocation("moreplanets:textures/entity/milk_cow.png");

    public RenderMilkCow(RenderManager render)
    {
        super(render, new ModelCow(), 0.7F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMilkCow entity)
    {
        return this.textures;
    }
}