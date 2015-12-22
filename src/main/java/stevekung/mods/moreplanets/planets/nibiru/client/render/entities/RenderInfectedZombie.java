/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.client.render.entities;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerVillagerArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityInfectedZombie;

import com.google.common.collect.Lists;

@SideOnly(Side.CLIENT)
public class RenderInfectedZombie extends RenderBiped<EntityInfectedZombie>
{
    private ResourceLocation zombieTextures = new ResourceLocation("moreplanets:textures/entity/infected_zombie.png");
    private ModelBiped field_82434_o;
    private List field_177121_n;
    private List field_177122_o;

    public RenderInfectedZombie(RenderManager render)
    {
        super(render, new ModelZombie(), 0.5F, 1.0F);
        this.layerRenderers.get(0);
        this.field_82434_o = this.modelBipedMain;
        this.addLayer(new LayerHeldItem(this));
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this)
        {
            @Override
            protected void initArmor()
            {
                this.field_177189_c = new ModelZombie(0.5F, true);
                this.field_177186_d = new ModelZombie(1.0F, true);
            }
        };
        this.addLayer(layerbipedarmor);
        this.field_177122_o = Lists.newArrayList(this.layerRenderers);
        this.removeLayer(layerbipedarmor);
        this.addLayer(new LayerVillagerArmor(this));
        this.field_177121_n = Lists.newArrayList(this.layerRenderers);
    }

    @Override
    protected void rotateCorpse(EntityInfectedZombie entity, float p_77043_2_, float p_77043_3_, float partialTicks)
    {
        if (entity.isConverting())
        {
            p_77043_3_ += (float)(Math.cos(entity.ticksExisted * 3.25D) * Math.PI * 0.25D);
        }
        super.rotateCorpse(entity, p_77043_2_, p_77043_3_, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityInfectedZombie entity)
    {
        return this.zombieTextures;
    }

    @Override
    public void doRender(EntityInfectedZombie entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.mainModel = this.field_82434_o;
        this.layerRenderers = this.field_177122_o;
        this.modelBipedMain = (ModelBiped)this.mainModel;
    }
}