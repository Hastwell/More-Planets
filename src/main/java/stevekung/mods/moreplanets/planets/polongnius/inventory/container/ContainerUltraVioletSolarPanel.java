/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.inventory.container;

import micdoodle8.mods.galacticraft.api.item.IItemElectric;
import micdoodle8.mods.galacticraft.core.inventory.SlotSpecific;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityUltraVioletSolarPanel;

public class ContainerUltraVioletSolarPanel extends Container
{
    private TileEntityUltraVioletSolarPanel tileEntity;

    public ContainerUltraVioletSolarPanel(InventoryPlayer invPlayer, TileEntityUltraVioletSolarPanel solarGen)
    {
        this.tileEntity = solarGen;
        this.addSlotToContainer(new SlotSpecific(solarGen, 0, 152, 83, IItemElectric.class));
        int var6;
        int var7;

        for (var6 = 0; var6 < 3; ++var6)
        {
            for (var7 = 0; var7 < 9; ++var7)
            {
                this.addSlotToContainer(new Slot(invPlayer, var7 + var6 * 9 + 9, 8 + var7 * 18, 51 + 68 + var6 * 18));
            }
        }

        for (var6 = 0; var6 < 9; ++var6)
        {
            this.addSlotToContainer(new Slot(invPlayer, var6, 8 + var6 * 18, 61 + 116));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.tileEntity.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot)
    {
        ItemStack itemStack = null;
        Slot var4 = this.inventorySlots.get(slot);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            itemStack = var5.copy();

            if (slot < 27)
            {
                if (!this.mergeItemStack(var5, 27, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var5, 0, 27, false))
            {
                return null;
            }

            if (var5.stackSize == 0)
            {
                var4.putStack((ItemStack) null);
            }
            else
            {
                var4.onSlotChanged();
            }
        }
        return itemStack;
    }
}