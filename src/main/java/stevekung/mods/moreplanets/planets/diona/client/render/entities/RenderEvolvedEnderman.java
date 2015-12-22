/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.client.render.entities;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.diona.client.model.ModelEvolvedEnderman;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.layers.LayerEvolvedEndermanEyes;
import stevekung.mods.moreplanets.planets.diona.client.render.entities.layers.LayerEvolvedEndermanHeldBlock;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;

@SideOnly(Side.CLIENT)
public class RenderEvolvedEnderman extends RenderLiving<EntityEvolvedEnderman>
{
    private ResourceLocation endermanTextures = new ResourceLocation("moreplanets:textures/entity/evolved_enderman/evolved_enderman.png");
    private ModelEvolvedEnderman endermanModel;
    private Random rnd = new Random();

    public RenderEvolvedEnderman(RenderManager render)
    {
        super(render, new ModelEvolvedEnderman(), 0.5F);
        this.endermanModel = (ModelEvolvedEnderman)super.mainModel;
        this.addLayer(new LayerEvolvedEndermanEyes(this));
        this.addLayer(new LayerEvolvedEndermanHeldBlock(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEvolvedEnderman entity)
    {
        return this.endermanTextures;
    }

    @Override
    public void doRender(EntityEvolvedEnderman entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.endermanModel.isCarrying = entity.getHeldBlockState().getBlock().getMaterial() != Material.air;
        this.endermanModel.isAttacking = entity.isScreaming();

        if (entity.isScreaming())
        {
            double d3 = 0.02D;
            x += this.rnd.nextGaussian() * d3;
            z += this.rnd.nextGaussian() * d3;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}