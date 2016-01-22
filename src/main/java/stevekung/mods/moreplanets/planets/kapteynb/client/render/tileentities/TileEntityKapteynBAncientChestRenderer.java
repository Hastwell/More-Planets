/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.client.render.tileentities;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.util.CalendarHelper;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.BlockKapteynBAncientChest;
import stevekung.mods.moreplanets.planets.kapteynb.client.model.ModelKapteynBAncientChest;
import stevekung.mods.moreplanets.planets.kapteynb.client.model.ModelKapteynBLargeAncientChest;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityKapteynBAncientChest;

@SideOnly(Side.CLIENT)
public class TileEntityKapteynBAncientChestRenderer extends TileEntitySpecialRenderer
{
    private ResourceLocation textureChristmasDouble;
    private ResourceLocation textureChristmas;
    private ResourceLocation textureNormalDouble;
    private ResourceLocation textureNormal;
    private ResourceLocation morePlanetsChestNormal;
    private ResourceLocation morePlanetsLargeChestNormal;

    private ModelKapteynBAncientChest simpleChest = new ModelKapteynBAncientChest();
    private ModelKapteynBLargeAncientChest largeChest = new ModelKapteynBLargeAncientChest();

    public TileEntityKapteynBAncientChestRenderer()
    {
        this.textureChristmasDouble = new ResourceLocation("textures/entity/chest/christmas_double.png");
        this.textureChristmas = new ResourceLocation("textures/entity/chest/christmas.png");
        this.textureNormalDouble = new ResourceLocation("moreplanets:textures/model/kapteyn_b_ancient_chest_double.png");
        this.textureNormal = new ResourceLocation("moreplanets:textures/model/kapteyn_b_ancient_chest.png");
        this.morePlanetsChestNormal = new ResourceLocation("moreplanets:textures/model/stevekung_chest.png");
        this.morePlanetsLargeChestNormal = new ResourceLocation("moreplanets:textures/model/stevekung_chest_double.png");
    }

    public void func_180538_a(TileEntityKapteynBAncientChest chest, double p_180538_2_, double p_180538_4_, double p_180538_6_, float p_180538_8_, int p_180538_9_)
    {
        int meta;

        if (!chest.hasWorldObj())
        {
            meta = 0;
        }
        else
        {
            Block block = chest.getBlockType();
            meta = chest.getBlockMetadata();

            if (block instanceof BlockKapteynBAncientChest && meta == 0)
            {
                ((BlockKapteynBAncientChest)block).checkForSurroundingChests(chest.getWorld(), chest.getPos(), chest.getWorld().getBlockState(chest.getPos()));
                meta = chest.getBlockMetadata();
            }
            chest.checkForAdjacentChests();
        }

        if (chest.adjacentChestZNeg == null && chest.adjacentChestXNeg == null)
        {
            ModelKapteynBAncientChest modelchest;

            if (chest.adjacentChestXPos == null && chest.adjacentChestZPos == null)
            {
                modelchest = this.simpleChest;

                if (p_180538_9_ >= 0)
                {
                    this.bindTexture(DESTROY_STAGES[p_180538_9_]);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(4.0F, 4.0F, 1.0F);
                    GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
                    GlStateManager.matrixMode(5888);
                }
                else if (CalendarHelper.isChristmasDay())
                {
                    this.bindTexture(this.textureChristmas);
                }
                else if (CalendarHelper.isMorePlanetsBirthDay())
                {
                    this.bindTexture(this.morePlanetsChestNormal);
                }
                else
                {
                    this.bindTexture(this.textureNormal);
                }
            }
            else
            {
                modelchest = this.largeChest;

                if (p_180538_9_ >= 0)
                {
                    this.bindTexture(DESTROY_STAGES[p_180538_9_]);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(8.0F, 4.0F, 1.0F);
                    GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
                    GlStateManager.matrixMode(5888);
                }
                else if (CalendarHelper.isChristmasDay())
                {
                    this.bindTexture(this.textureChristmasDouble);
                }
                else if (CalendarHelper.isMorePlanetsBirthDay())
                {
                    this.bindTexture(this.morePlanetsLargeChestNormal);
                }
                else
                {
                    this.bindTexture(this.textureNormalDouble);
                }
            }

            GlStateManager.pushMatrix();
            GlStateManager.enableRescaleNormal();

            if (p_180538_9_ < 0)
            {
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            }

            GlStateManager.translate((float)p_180538_2_, (float)p_180538_4_ + 1.0F, (float)p_180538_6_ + 1.0F);
            GlStateManager.scale(1.0F, -1.0F, -1.0F);
            GlStateManager.translate(0.5F, 0.5F, 0.5F);
            short short1 = 0;

            if (meta == 2)
            {
                short1 = 180;
            }
            if (meta == 3)
            {
                short1 = 0;
            }
            if (meta == 4)
            {
                short1 = 90;
            }
            if (meta == 5)
            {
                short1 = -90;
            }

            if (meta == 2 && chest.adjacentChestXPos != null)
            {
                GlStateManager.translate(1.0F, 0.0F, 0.0F);
            }
            if (meta == 5 && chest.adjacentChestZPos != null)
            {
                GlStateManager.translate(0.0F, 0.0F, -1.0F);
            }

            GlStateManager.rotate(short1, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(-0.5F, -0.5F, -0.5F);
            float f1 = chest.prevLidAngle + (chest.lidAngle - chest.prevLidAngle) * p_180538_8_;
            float f2;

            if (chest.adjacentChestZNeg != null)
            {
                f2 = chest.adjacentChestZNeg.prevLidAngle + (chest.adjacentChestZNeg.lidAngle - chest.adjacentChestZNeg.prevLidAngle) * p_180538_8_;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            if (chest.adjacentChestXNeg != null)
            {
                f2 = chest.adjacentChestXNeg.prevLidAngle + (chest.adjacentChestXNeg.lidAngle - chest.adjacentChestXNeg.prevLidAngle) * p_180538_8_;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            modelchest.chestLid.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
            modelchest.renderAll();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

            if (p_180538_9_ >= 0)
            {
                GlStateManager.matrixMode(5890);
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5888);
            }
        }
    }

    @Override
    public void renderTileEntityAt(TileEntity tile, double posX, double posZ, double p_180535_6_, float p_180535_8_, int p_180535_9_)
    {
        this.func_180538_a((TileEntityKapteynBAncientChest)tile, posX, posZ, p_180535_6_, p_180535_8_, p_180535_9_);
    }
}