/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class InventoryRocketSchematic implements IInventory
{
    private ItemStack[] stackList;
    private int inventoryWidth;
    private Container container;

    public InventoryRocketSchematic(Container container)
    {
        this.stackList = new ItemStack[22];
        this.container = container;
        this.inventoryWidth = 5;
    }

    @Override
    public int getSizeInventory()
    {
        return this.stackList.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return slot >= this.getSizeInventory() ? null : this.stackList[slot];
    }

    public ItemStack getStackInRowAndColumn(int par1, int par2)
    {
        if (par1 >= 0 && par1 < this.inventoryWidth)
        {
            int var3 = par1 + par2 * this.inventoryWidth;

            if (var3 >= 22)
            {
                return null;
            }
            return this.getStackInSlot(var3);
        }
        else
        {
            return null;
        }
    }

    @Override
    public String getCommandSenderName()
    {
        return "container.crafting";
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (this.stackList[slot] != null)
        {
            ItemStack stack = this.stackList[slot];
            this.stackList[slot] = null;
            return stack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack decrStackSize(int slot, int size)
    {
        if (this.stackList[slot] != null)
        {
            ItemStack itemStack;

            if (this.stackList[slot].stackSize <= size)
            {
                itemStack = this.stackList[slot];
                this.stackList[slot] = null;
                this.container.onCraftMatrixChanged(this);
                return itemStack;
            }
            else
            {
                itemStack = this.stackList[slot].splitStack(size);

                if (this.stackList[slot].stackSize == 0)
                {
                    this.stackList[slot] = null;
                }
                this.container.onCraftMatrixChanged(this);
                return itemStack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        this.stackList[slot] = itemStack;
        this.container.onCraftMatrixChanged(this);
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty() {}

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {}

    @Override
    public void closeInventory(EntityPlayer player) {}

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack)
    {
        return false;
    }

    @Override
    public IChatComponent getDisplayName()
    {
        return new ChatComponentText(this.getCommandSenderName());
    }

    @Override
    public int getField(int id)
    {
        return 0;
    }

    @Override
    public void setField(int id, int value) {}

    @Override
    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void clear() {}
}