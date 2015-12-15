package stevekung.mods.moreplanets.planets.pluto.render.entities;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import stevekung.mods.moreplanets.planets.pluto.entities.EntityPlutoDog;
import stevekung.mods.moreplanets.planets.pluto.model.ModelPlutoDog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlutoDog extends RenderLiving
{
    private ResourceLocation wolfTextures = new ResourceLocation("textures/entity/wolf/wolf.png");
    private ResourceLocation tamedWolfTextures = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
    private ResourceLocation anrgyWolfTextures = new ResourceLocation("textures/entity/wolf/wolf_angry.png");
    private ResourceLocation wolfCollarTextures = new ResourceLocation("textures/entity/wolf/wolf_collar.png");

    public RenderPlutoDog()
    {
        super(new ModelPlutoDog(), 0.5F);
        this.setRenderPassModel(new ModelPlutoDog());
    }

    protected float handleRotationFloat(EntityPlutoDog p_77044_1_, float p_77044_2_)
    {
        return p_77044_1_.getTailRotation();
    }

    protected int shouldRenderPass(EntityPlutoDog p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ == 0 && p_77032_1_.getWolfShaking())
        {
            float f1 = p_77032_1_.getBrightness(p_77032_3_) * p_77032_1_.getShadingWhileShaking(p_77032_3_);
            this.bindTexture(this.wolfTextures);
            GL11.glColor3f(f1, f1, f1);
            return 1;
        }
        else if (p_77032_2_ == 1 && p_77032_1_.isTamed())
        {
            this.bindTexture(this.wolfCollarTextures);
            int j = p_77032_1_.getCollarColor();
            GL11.glColor3f(EntitySheep.fleeceColorTable[j][0], EntitySheep.fleeceColorTable[j][1], EntitySheep.fleeceColorTable[j][2]);
            return 1;
        }
        else
        {
            return -1;
        }
    }

    protected ResourceLocation getEntityTexture(EntityPlutoDog p_110775_1_)
    {
        return p_110775_1_.isTamed() ? this.tamedWolfTextures : p_110775_1_.isAngry() ? this.anrgyWolfTextures : this.wolfTextures;
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityPlutoDog)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    @Override
    protected float handleRotationFloat(EntityLivingBase p_77044_1_, float p_77044_2_)
    {
        return this.handleRotationFloat((EntityPlutoDog)p_77044_1_, p_77044_2_);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityPlutoDog)p_110775_1_);
    }
}