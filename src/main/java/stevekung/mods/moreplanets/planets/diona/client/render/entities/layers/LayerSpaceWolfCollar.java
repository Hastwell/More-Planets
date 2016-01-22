/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.client.render.entities.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.RenderSpaceWolf;
import stevekung.mods.moreplanets.planets.diona.entities.EntitySpaceWolf;

@SideOnly(Side.CLIENT)
public class LayerSpaceWolfCollar implements LayerRenderer<EntitySpaceWolf>
{
    private ResourceLocation collarTexture = new ResourceLocation("moreplanets:textures/entity/space_wolf/space_wolf_collar.png");
    private RenderSpaceWolf render;

    public LayerSpaceWolfCollar(RenderSpaceWolf render)
    {
        this.render = render;
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return true;
    }

    @Override
    public void doRenderLayer(EntitySpaceWolf entity, float par2, float par3, float partialTicks, float par5, float par6, float par7, float scale)
    {
        if (entity.isTamed() && !entity.isInvisible())
        {
            this.render.bindTexture(this.collarTexture);
            EnumDyeColor enumdyecolor = EnumDyeColor.byMetadata(entity.getCollarColor().getMetadata());
            float[] afloat = EntitySheep.func_175513_a(enumdyecolor);
            GlStateManager.color(afloat[0], afloat[1], afloat[2]);
            this.render.getMainModel().render(entity, par2, par3, partialTicks, par5, par6, par7);
        }
    }
}