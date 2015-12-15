/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.client.render.entities;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.fronos.client.model.ModelTomato;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.layers.LayerTomato;

@SideOnly(Side.CLIENT)
public class RenderTomato extends RenderLiving
{
    private ResourceLocation tomatoTextures = new ResourceLocation("moreplanets:textures/entity/tomato.png");

    public RenderTomato(RenderManager render)
    {
        super(render, new ModelTomato(), 0.75F);
        this.addLayer(new LayerTomato(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.tomatoTextures;
    }
}