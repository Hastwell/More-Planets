/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.client.render.tileentities;

import java.awt.Color;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.BlockIcyPoisonCrystal;
import stevekung.mods.moreplanets.planets.kapteynb.client.model.ModelIcyPoisonCrystal;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityIcyPoisonCrystal;

public class TileEntityIcyPoisonCrystalRenderer extends TileEntitySpecialRenderer<TileEntityIcyPoisonCrystal>
{
    private ModelIcyPoisonCrystal model = new ModelIcyPoisonCrystal();

    @Override
    public void renderTileEntityAt(TileEntityIcyPoisonCrystal tile, double x, double y, double z, float partialTicks, int destroyStage)
    {
        Random rand = new Random(tile.getPos().getX() + tile.getPos().getY() * tile.getPos().getZ());
        this.bindTexture(new ResourceLocation("moreplanets:textures/model/icy_poison_crystal.png"));

        for (int i = 0; i < 6; i++)
        {
            int color = BlockIcyPoisonCrystal.colors[i];

            for (int spike = 0; spike < 6; spike++)
            {
                int angle1 = rand.nextInt(36) + 72 * spike;
                int angle2 = 15 + rand.nextInt(15);
                EntityPlayer player = Minecraft.getMinecraft().thePlayer;
                float shade = MathHelper.sin((player.ticksExisted + rand.nextInt(2)) / (5.0F + rand.nextFloat())) * 0.100F + 1.022F;
                Color c = new Color(color);
                float r = c.getRed() / 180.0F;
                float g = c.getGreen() / 180.0F;
                float b = c.getBlue() / 180.0F;
                GlStateManager.pushMatrix();
                GlStateManager.enableNormalize();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 771);

                if (tile.facing == 0)
                {
                    GlStateManager.translate(x + 0.5F, y + 1.3F, z + 0.5F);
                    GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
                }
                else if (tile.facing == 1)
                {
                    GlStateManager.translate(x + 0.5F, y - 0.3F, z + 0.5F);
                }
                else if (tile.facing == 2)
                {
                    GlStateManager.translate(x + 0.5F, y + 0.5F, z + 1.3F);
                    GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
                }
                else if (tile.facing == 3)
                {
                    GlStateManager.translate(x + 0.5F, y + 0.5F, z - 0.3F);
                    GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
                }
                else if (tile.facing == 4)
                {
                    GlStateManager.translate(x + 1.3F, y + 0.5F, z + 0.5F);
                    GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                }
                else if (tile.facing == 5)
                {
                    GlStateManager.translate(x - 0.3F, y + 0.5F, z + 0.5F);
                    GlStateManager.rotate(-90.0F, 0.0F, 0.0F, 1.0F);
                }

                GlStateManager.rotate(angle1, 0.1F, 1.0F, 0.0F);
                GlStateManager.rotate(angle2, 1.0F, 0.0F, 0.0F);
                GlStateManager.scale((0.15F + rand.nextFloat() * 0.075F) * 1.1F, (0.5F + rand.nextFloat() * 0.1F) * 1.1F, (0.15F + rand.nextFloat() * 0.05F) * 1.1F);
                int var19 = (int)(215.0F * shade);
                int var20 = var19 % 65536;
                int var21 = var19 / 65536;
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, var20 / 1.0F, var21 / 1.0F);
                GlStateManager.color(r, g, b, 1.0F);
                this.model.render();
                GlStateManager.scale(1.0F, 1.0F, 1.0F);
                GlStateManager.disableBlend();
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                GlStateManager.popMatrix();
            }
        }
    }
}