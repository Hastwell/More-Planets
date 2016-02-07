/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.items.tools;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.core.init.MPPotions;
import stevekung.mods.moreplanets.core.items.tools.ItemElectricHoeMP;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;

public class ItemUraniumHoe extends ItemElectricHoeMP
{
    public ItemUraniumHoe(String name, ToolMaterial material)
    {
        super(name, material, 25000.0F, null);
        this.setUnlocalizedName(name);
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entity, EntityLivingBase entity2)
    {
        if (this.getElectricityStored(itemStack) != 0.0F)
        {
            this.setElectricity(itemStack, this.getElectricityStored(itemStack) - 10.5F);
            entity.addPotionEffect(new PotionEffect(MPPotions.chemical.id, 60));
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
    {
        list.add(EnumChatFormatting.GRAY + "Ice Crystal Tool Upgrade Required : 7");
        super.addInformation(itemStack, player, list, advanced);
    }

    @Override
    public boolean onEntityItemUpdate(EntityItem item)
    {
        World world = item.worldObj;
        List<EntityItem> item1 = world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(item.posX, item.posY, item.posZ, item.posX + 1, item.posY + 1, item.posZ + 1));

        if (item.worldObj.getBlock((int)Math.floor(item.posX), (int)Math.floor(item.posY), (int)Math.floor(item.posZ)) == KapteynBBlocks.frozen_water)
        {
            if (item1.get(0).getEntityItem().getItem() == KapteynBItems.kapteyn_b_item && item1.get(0).getEntityItem().getItemDamage() == 5 && item1.get(0).getEntityItem().stackSize >= 7)
            {
                item.setEntityItemStack(new ItemStack(KapteynBToolsItems.ice_crystal_hoe));
                item1.get(0).setEntityItemStack(new ItemStack(KapteynBItems.kapteyn_b_item, item1.get(0).getEntityItem().stackSize - 7, 5));
            }
        }
        return false;
    }
}