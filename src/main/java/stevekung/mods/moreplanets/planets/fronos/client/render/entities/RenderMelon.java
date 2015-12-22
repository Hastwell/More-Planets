/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.client.render.entities;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.fronos.client.model.ModelMelon;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityMelon;

@SideOnly(Side.CLIENT)
public class RenderMelon extends RenderLiving<EntityMelon>
{
    private ResourceLocation melonTextures = new ResourceLocation("moreplanets:textures/entity/melon.png");

    public RenderMelon(RenderManager render)
    {
        super(render, new ModelMelon(), 1.0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMelon entity)
    {
        return this.melonTextures;
    }
}