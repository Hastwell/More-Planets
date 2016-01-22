package stevekung.mods.moreplanets.asteroids.darkasteroids.client.render.entities;

import micdoodle8.mods.galacticraft.core.client.model.ModelEvolvedCreeper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import stevekung.mods.moreplanets.asteroids.darkasteroids.entities.EntityEvolvedDarkCreeper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEvolvedDarkCreeper extends RenderCreeper
{
    private ResourceLocation creeperTexture = new ResourceLocation("mpcore:textures/model/evolved_dark_creeper.png");
    private ResourceLocation creeperEyesTexture = new ResourceLocation("mpcore:textures/model/evolved_dark_creeper_eyes.png");
    private ResourceLocation powerTexture = new ResourceLocation("galacticraftcore:textures/model/power.png");
    private ModelBase creeperModel = new ModelEvolvedCreeper(0.2F);

    public RenderEvolvedDarkCreeper()
    {
        super();
        this.mainModel = new ModelEvolvedCreeper(0.2F);
        this.setRenderPassModel(this.creeperModel);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.creeperTexture;
    }

    protected void updateCreeperScale(EntityEvolvedDarkCreeper entity, float partialTicks)
    {
        float var4 = entity.getCreeperFlashIntensity(partialTicks);
        float var5 = 1.0F + MathHelper.sin(var4 * 100.0F) * var4 * 0.01F;

        if (var4 < 0.0F)
        {
            var4 = 0.0F;
        }
        if (var4 > 1.0F)
        {
            var4 = 1.0F;
        }
        var4 *= var4;
        var4 *= var4;
        float var6 = (1.0F + var4 * 0.4F) * var5;
        float var7 = (1.0F + var4 * 0.1F) / var5;
        GL11.glScalef(0.2F + var6, 0.2F + var7, 0.2F + var6);
    }

    protected int updateCreeperColorMultiplier(EntityEvolvedDarkCreeper entity, float partialTicks)
    {
        float var5 = entity.getCreeperFlashIntensity(partialTicks);

        if ((int) (var5 * 10.0F) % 2 == 0)
        {
            return 0;
        }
        else
        {
            int var6 = (int) (var5 * 0.2F * 255.0F);

            if (var6 < 0)
            {
                var6 = 0;
            }
            if (var6 > 255)
            {
                var6 = 255;
            }
            short var7 = 255;
            short var8 = 255;
            short var9 = 255;
            return var6 << 24 | var7 << 16 | var8 << 8 | var9;
        }
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTicks)
    {
        this.updateCreeperScale((EntityEvolvedDarkCreeper)entity, partialTicks);
    }

    @Override
    protected int getColorMultiplier(EntityLivingBase entity, float par2, float partialTicks)
    {
        return this.updateCreeperColorMultiplier((EntityEvolvedDarkCreeper)entity, partialTicks);
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase entity, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ != 0)
        {
            return -1;
        }
        else
        {
            this.bindTexture(this.creeperEyesTexture);
            float f1 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDisable(GL11.GL_LIGHTING);

            if (entity.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }
            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }

    @Override
    protected int inheritRenderPass(EntityLivingBase entity, int par2, float par3)
    {
        return this.shouldRenderPass(entity, par2, par3);
    }
}