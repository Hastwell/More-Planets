/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.client.render.entities;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.fronos.client.render.entities.layers.LayerJellySlimePetGel;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityJellySlimePet;

@SideOnly(Side.CLIENT)
public class RenderJellySlimePet extends RenderLiving<EntityJellySlimePet>
{
    private ResourceLocation strawberrySlimeTextures = new ResourceLocation("moreplanets:textures/entity/jelly_slime/strawberry.png");
    private ResourceLocation berrySlimeTextures = new ResourceLocation("moreplanets:textures/entity/jelly_slime/berry.png");
    private ResourceLocation raspberrySlimeTextures = new ResourceLocation("moreplanets:textures/entity/jelly_slime/raspberry.png");
    private ResourceLocation orangeSlimeTextures = new ResourceLocation("moreplanets:textures/entity/jelly_slime/orange.png");
    private ResourceLocation grapeSlimeTextures = new ResourceLocation("moreplanets:textures/entity/jelly_slime/grape.png");
    private ResourceLocation limeSlimeTextures = new ResourceLocation("moreplanets:textures/entity/jelly_slime/lime.png");
    private ResourceLocation greenSlimeTextures = new ResourceLocation("moreplanets:textures/entity/jelly_slime/green.png");
    private ResourceLocation lemonSlimeTextures = new ResourceLocation("moreplanets:textures/entity/jelly_slime/lemon.png");

    public RenderJellySlimePet(RenderManager render)
    {
        super(render, new ModelSlime(16), 0.25F);
        this.addLayer(new LayerJellySlimePetGel(this));
    }

    @Override
    protected void preRenderCallback(EntityJellySlimePet entity, float partialTickTime)
    {
        float f1 = 1;
        float f2 = (entity.prevSquishFactor + (entity.squishFactor - entity.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityJellySlimePet entity)
    {
        switch (entity.getJellySlimeType())
        {
        case 0:
        default:
            return this.grapeSlimeTextures;
        case 1:
            return this.raspberrySlimeTextures;
        case 2:
            return this.strawberrySlimeTextures;
        case 3:
            return this.berrySlimeTextures;
        case 4:
            return this.limeSlimeTextures;
        case 5:
            return this.orangeSlimeTextures;
        case 6:
            return this.greenSlimeTextures;
        case 7:
            return this.lemonSlimeTextures;
        }
    }
}