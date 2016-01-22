/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.client.render.entities;

import micdoodle8.mods.galacticraft.core.client.model.ModelAlienVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.moons.koentus.entities.EntityKoentusianVillager;

@SideOnly(Side.CLIENT)
public class RenderKoentusianVillager extends RenderLiving<EntityKoentusianVillager>
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/koentusian_villager.png");

    public RenderKoentusianVillager(RenderManager render)
    {
        super(render, new ModelAlienVillager(0.0F), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityKoentusianVillager entity)
    {
        return this.texture;
    }
}