/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.inventory.slot;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.PacketSimple;
import micdoodle8.mods.galacticraft.core.network.PacketSimple.EnumSimplePacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;

public class SlotSchematicTier7Rocket extends Slot
{
    private int index;
    private int x, y, z;
    private EntityPlayer player;

    public SlotSchematicTier7Rocket(IInventory par2IInventory, int par3, int par4, int par5, int x, int y, int z, EntityPlayer player)
    {
        super(par2IInventory, par3, par4, par5);
        this.index = par3;
        this.x = x;
        this.y = y;
        this.z = z;
        this.player = player;
    }

    @Override
    public void onSlotChanged()
    {
        if (this.player instanceof EntityPlayerMP)
        {
            for (int var12 = 0; var12 < this.player.worldObj.playerEntities.size(); ++var12)
            {
                EntityPlayerMP var13 = (EntityPlayerMP) this.player.worldObj.playerEntities.get(var12);

                if (var13.dimension == this.player.worldObj.provider.getDimensionId())
                {
                    double var14 = this.x - var13.posX;
                    double var16 = this.y - var13.posY;
                    double var18 = this.z - var13.posZ;

                    if (var14 * var14 + var16 * var16 + var18 * var18 < 20 * 20)
                    {
                        GalacticraftCore.packetPipeline.sendTo(new PacketSimple(EnumSimplePacket.C_SPAWN_SPARK_PARTICLES, new Object[] { this.x, this.y, this.z }), var13);
                    }
                }
            }
        }
    }

    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        int meta = itemStack.getItemDamage();

        switch (this.index)
        {
        case 1:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 4;//Nose Cone
        case 2:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 2;
        case 3:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 2;
        case 4:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 2;
        case 5:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 2;
        case 6:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 2;
        case 7:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 2;
        case 8:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 2;
        case 9:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 2;
        case 10:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 2;
        case 11:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 2;//Plate
        case 12:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 1;//Booster
        case 13:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 3;
        case 14:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 3;
        case 15:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 0;//Engine
        case 16:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 1;
        case 17:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 3;
        case 18:
            return itemStack.getItem() == NibiruItems.tier_7_rocket_module && meta == 3;
        case 19:
            return true;
        case 20:
            return true;
        case 21:
            return true;
        }
        return false;
    }

    @Override
    public int getSlotStackLimit()
    {
        return 1;
    }
}