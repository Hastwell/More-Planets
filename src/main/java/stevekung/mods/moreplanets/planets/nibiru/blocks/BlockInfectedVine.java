/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.BlockVineMP;
import stevekung.mods.moreplanets.common.eventhandler.MorePlanetsEvents;
import stevekung.mods.moreplanets.common.util.DamageSourceMP;
import stevekung.mods.moreplanets.planets.nibiru.entities.EntityInfectedWorm;

public class BlockInfectedVine extends BlockVineMP
{
    public BlockInfectedVine(String name)
    {
        super();
        this.setUnlocalizedName(name);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
        if (!world.isRemote && entity instanceof EntityLivingBase)
        {
            if (entity instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer) entity;
                InventoryPlayer inventory = player.inventory;
                boolean boots = inventory.armorInventory[0] != null && inventory.armorInventory[0].getItem() instanceof ItemArmor && ((ItemArmor)inventory.armorInventory[0].getItem()).armorType == 3;
                boolean leggings = inventory.armorInventory[1] != null && inventory.armorInventory[1].getItem() instanceof ItemArmor && ((ItemArmor)inventory.armorInventory[1].getItem()).armorType == 2;
                boolean chestplate = inventory.armorInventory[2] != null && inventory.armorInventory[2].getItem() instanceof ItemArmor && ((ItemArmor)inventory.armorInventory[2].getItem()).armorType == 1;
                boolean helmet = inventory.armorInventory[3] != null && inventory.armorInventory[3].getItem() instanceof ItemArmor && ((ItemArmor)inventory.armorInventory[3].getItem()).armorType == 0;
                boolean full = helmet && chestplate && leggings && boots;

                if (player.capabilities.isCreativeMode)
                {
                    return;
                }
                if (!full)
                {
                    player.attackEntityFrom(DamageSourceMP.infected_vine, (int) (4.0D * 0.1 + 1.0D));
                    player.addPotionEffect(new PotionEffect(Potion.poison.id, 50, 1));
                }
                if (world.rand.nextInt(1000) == 0 && !full && !player.capabilities.isCreativeMode)
                {
                    if (!world.isRemote)
                    {
                        EntityInfectedWorm worm = new EntityInfectedWorm(world);
                        worm.setLocationAndAngles(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 0.0F, 0.0F);
                        world.spawnEntityInWorld(worm);
                    }
                }
            }
            else
            {
                ((EntityLivingBase)entity).attackEntityFrom(DamageSourceMP.infected_vine, (int) (4.0D * 0.1 + 1.0D));
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 50, 1));
            }
        }
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tile)
    {
        super.harvestBlock(world, player, pos, state, tile);
        MorePlanetsEvents.addInfectedGas(player);
    }
}