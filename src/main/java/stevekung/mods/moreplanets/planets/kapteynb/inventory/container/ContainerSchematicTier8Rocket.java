/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.inventory.container;

import micdoodle8.mods.galacticraft.core.inventory.SlotRocketBenchResult;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.inventory.InventoryRocketSchematic;
import stevekung.mods.moreplanets.planets.kapteynb.inventory.slot.SlotSchematicTier8Rocket;
import stevekung.mods.moreplanets.planets.kapteynb.recipe.Tier8RocketRecipes;

public class ContainerSchematicTier8Rocket extends Container
{
    public InventoryRocketSchematic craftMatrix = new InventoryRocketSchematic(this);
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;

    public ContainerSchematicTier8Rocket(InventoryPlayer par1InventoryPlayer, int x, int y, int z)
    {
        int change = 27;
        this.worldObj = par1InventoryPlayer.player.worldObj;
        this.addSlotToContainer(new SlotRocketBenchResult(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 142, 18 + 69 + change));
        int var6;
        int var7;

        // Cone
        this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 1, 48, -8 + change, x, y, z, par1InventoryPlayer.player));

        // Body
        for (var6 = 0; var6 < 5; ++var6)
        {
            this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 2 + var6, 39, -6 + var6 * 18 + 16 + change, x, y, z, par1InventoryPlayer.player));
        }

        // Body Right
        for (var6 = 0; var6 < 5; ++var6)
        {
            this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 7 + var6, 57, -6 + var6 * 18 + 16 + change, x, y, z, par1InventoryPlayer.player));
        }

        // Left fins
        this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 12, 21, 64 + change, x, y, z, par1InventoryPlayer.player));
        this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 13, 21, 82 + change, x, y, z, par1InventoryPlayer.player));
        this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 14, 21, 100 + change, x, y, z, par1InventoryPlayer.player));

        // Engine
        this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 15, 48, 100 + change, x, y, z, par1InventoryPlayer.player));

        // Right fins
        this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 16, 75, 64 + change, x, y, z, par1InventoryPlayer.player));
        this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 17, 75, 82 + change, x, y, z, par1InventoryPlayer.player));
        this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 18, 75, 100 + change, x, y, z, par1InventoryPlayer.player));

        // Addons
        for (int var8 = 0; var8 < 3; var8++)
        {
            this.addSlotToContainer(new SlotSchematicTier8Rocket(this.craftMatrix, 19 + var8, 93 + var8 * 26, -15 + change, x, y, z, par1InventoryPlayer.player));
        }

        // Player inv:

        for (var6 = 0; var6 < 3; ++var6)
        {
            for (var7 = 0; var7 < 9; ++var7)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var7 + var6 * 9 + 9, 8 + var7 * 18, 129 + var6 * 18 + change));
            }
        }

        for (var6 = 0; var6 < 9; ++var6)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var6, 8 + var6 * 18, 18 + 169 + change));
        }
        this.onCraftMatrixChanged(this.craftMatrix);
    }

    @Override
    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        super.onContainerClosed(par1EntityPlayer);

        if (!this.worldObj.isRemote)
        {
            for (int var2 = 1; var2 < this.craftMatrix.getSizeInventory(); ++var2)
            {
                ItemStack var3 = this.craftMatrix.removeStackFromSlot(var2);

                if (var3 != null)
                {
                    par1EntityPlayer.entityDropItem(var3, 0.0F);
                }
            }
        }
    }

    @Override
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        this.craftResult.setInventorySlotContents(0, Tier8RocketRecipes.findMatchingTier8RocketRecipe(this.craftMatrix));
    }

    @Override
    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par1)
    {
        ItemStack var2 = null;
        Slot var3 = this.inventorySlots.get(par1);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();
            boolean done = false;

            if (par1 <= 21)
            {
                if (!this.mergeItemStack(var4, 22, 58, false))
                {
                    return null;
                }

                if (par1 == 0)
                {
                    var3.onSlotChange(var4, var2);
                }
            }
            else
            {
                for (int i = 1; i < 19; i++)
                {
                    Slot testSlot = this.inventorySlots.get(i);

                    if (!testSlot.getHasStack() && testSlot.isItemValid(var2))
                    {
                        if (!this.mergeOneItem(var4, i, i + 1, false))
                        {
                            return null;
                        }
                        done = true;
                        break;
                    }
                }

                if (!done)
                {
                    if (var2.getItem() == Item.getItemFromBlock(Blocks.chest) && !this.inventorySlots.get(19).getHasStack())
                    {
                        if (!this.mergeOneItem(var4, 19, 20, false))
                        {
                            return null;
                        }
                    }
                    else if (var2.getItem() == Item.getItemFromBlock(Blocks.chest) && !this.inventorySlots.get(20).getHasStack())
                    {
                        if (!this.mergeOneItem(var4, 20, 21, false))
                        {
                            return null;
                        }
                    }
                    else if (var2.getItem() == Item.getItemFromBlock(Blocks.chest) && !this.inventorySlots.get(21).getHasStack())
                    {
                        if (!this.mergeOneItem(var4, 21, 22, false))
                        {
                            return null;
                        }
                    }
                    else if (par1 >= 22 && par1 < 49)
                    {
                        if (!this.mergeItemStack(var4, 49, 58, false))
                        {
                            return null;
                        }
                    }
                    else if (par1 >= 49 && par1 < 58)
                    {
                        if (!this.mergeItemStack(var4, 22, 49, false))
                        {
                            return null;
                        }
                    }
                    else if (!this.mergeItemStack(var4, 22, 58, false))
                    {
                        return null;
                    }
                }
            }
            if (var4.stackSize == 0)
            {
                var3.putStack((ItemStack) null);
            }
            else
            {
                var3.onSlotChanged();
            }

            if (var4.stackSize == var2.stackSize)
            {
                return null;
            }
            var3.onPickupFromSlot(par1EntityPlayer, var4);
        }
        return var2;
    }

    protected boolean mergeOneItem(ItemStack par1ItemStack, int par2, int par3, boolean par4)
    {
        boolean flag1 = false;

        if (par1ItemStack.stackSize > 0)
        {
            Slot slot;
            ItemStack slotStack;

            for (int k = par2; k < par3; k++)
            {
                slot = this.inventorySlots.get(k);
                slotStack = slot.getStack();

                if (slotStack == null)
                {
                    ItemStack stackOneItem = par1ItemStack.copy();
                    stackOneItem.stackSize = 1;
                    par1ItemStack.stackSize--;
                    slot.putStack(stackOneItem);
                    slot.onSlotChanged();
                    flag1 = true;
                    break;
                }
            }
        }
        return flag1;
    }
}