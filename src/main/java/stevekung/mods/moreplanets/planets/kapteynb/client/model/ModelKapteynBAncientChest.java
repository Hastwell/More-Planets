/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.client.model;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelKapteynBAncientChest extends ModelChest
{
    @Override
    public void renderAll()
    {
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        this.chestKnob.rotateAngleX = this.chestLid.rotateAngleX;
        this.chestLid.render(0.0625F);
        this.chestKnob.render(0.0625F);
        this.chestBelow.render(0.0625F);
        GlStateManager.disableBlend();
    }
}