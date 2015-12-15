/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelStarfish extends ModelBase
{
    ModelRenderer star1;
    ModelRenderer star2;
    ModelRenderer star3;
    ModelRenderer star4;
    ModelRenderer star5;
    ModelRenderer starbit1;
    ModelRenderer starbit2;
    ModelRenderer starbit3;
    ModelRenderer starbit4;
    ModelRenderer starbit5;
    ModelRenderer starbase;

    public ModelStarfish()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.star1 = new ModelRenderer(this, 0, 0);
        this.star1.addBox(0F, 0F, 0F, 2, 1, 2);
        this.star1.setRotationPoint(-3.5F, 23F, -3.5F);

        this.star2 = new ModelRenderer(this, 0, 0);
        this.star2.addBox(0F, 0F, 0F, 2, 1, 2);
        this.star2.setRotationPoint(2.5F, 23F, 0.5F);

        this.star3 = new ModelRenderer(this, 0, 0);
        this.star3.addBox(0F, 0F, 0F, 2, 1, 2);
        this.star3.setRotationPoint(1.5F, 23F, -3.5F);

        this.star4 = new ModelRenderer(this, 0, 0);
        this.star4.addBox(0F, 0F, 0F, 2, 1, 2);
        this.star4.setRotationPoint(-4.5F, 23F, 0.5F);

        this.star5 = new ModelRenderer(this, 0, 0);
        this.star5.addBox(0F, 0F, 0F, 2, 1, 2);
        this.star5.setRotationPoint(-1F, 23F, 2.5F);

        this.starbit1 = new ModelRenderer(this, 0, 0);
        this.starbit1.addBox(0F, 0F, 0F, 1, 1, 1);
        this.starbit1.setRotationPoint(-5.5F, 23F, 1F);

        this.starbit2 = new ModelRenderer(this, 0, 0);
        this.starbit2.addBox(0F, 0F, 0F, 1, 1, 1);
        this.starbit2.setRotationPoint(4.5F, 23F, 1F);

        this.starbit3 = new ModelRenderer(this, 0, 0);
        this.starbit3.addBox(0F, 0F, 0F, 1, 1, 1);
        this.starbit3.setRotationPoint(3F, 23F, -4F);

        this.starbit4 = new ModelRenderer(this, 0, 0);
        this.starbit4.addBox(0F, 0F, 0F, 1, 1, 1);
        this.starbit4.setRotationPoint(-4F, 23F, -4F);

        this.starbit5 = new ModelRenderer(this, 0, 0);
        this.starbit5.addBox(0F, 0F, 0F, 1, 1, 1);
        this.starbit5.setRotationPoint(-0.5F, 23F, 4.5F);

        this.starbase = new ModelRenderer(this, 24, 0);
        this.starbase.addBox(-3F, 0F, -3F, 6, 1, 6);
        this.starbase.setRotationPoint(0F, 23F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        if (this.isChild)
        {
            GlStateManager.pushMatrix();
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 24.0F * f5, 0.0F);
            this.star1.render(f5);
            this.star2.render(f5);
            this.star3.render(f5);
            this.star4.render(f5);
            this.star5.render(f5);
            this.starbit1.render(f5);
            this.starbit2.render(f5);
            this.starbit3.render(f5);
            this.starbit4.render(f5);
            this.starbit5.render(f5);
            this.starbase.render(f5);
            GlStateManager.popMatrix();
        }
        else
        {
            this.star1.render(f5);
            this.star2.render(f5);
            this.star3.render(f5);
            this.star4.render(f5);
            this.star5.render(f5);
            this.starbit1.render(f5);
            this.starbit2.render(f5);
            this.starbit3.render(f5);
            this.starbit4.render(f5);
            this.starbit5.render(f5);
            this.starbase.render(f5);
        }
    }
}