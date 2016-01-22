/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.ICustomBlockProperty;
import stevekung.mods.moreplanets.common.entities.ai.EntityAITemptMP;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;

public class EntityMilkCow extends EntityCow
{
    public EntityMilkCow(World world)
    {
        super(world);
        this.tasks.addTask(3, new EntityAITemptMP(this, 1.25D, new ItemStack(FronosItems.fronos_item, 1, 6), false));
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack)
    {
        return super.isBreedingItem(itemStack) || itemStack.getItem() == FronosItems.fronos_item && itemStack.getItemDamage() == 6;
    }

    @Override
    public boolean getCanSpawnHere()
    {
        return this.worldObj.getBlockState(this.getPosition().down()).getBlock() instanceof ICustomBlockProperty && ((ICustomBlockProperty)this.worldObj.getBlockState(this.getPosition().down()).getBlock()).getProperty() == 0;
    }

    @Override
    public EntityMilkCow createChild(EntityAgeable entity)
    {
        return new EntityMilkCow(this.worldObj);
    }
}