/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.blocks;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.asteroids.darkasteroids.items.DarkAsteroidsItems;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;

public class BlockAlphereOre extends BlockBaseMP implements IDetectableResource
{
    public BlockAlphereOre(String name)
    {
        super(Material.rock);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setUnlocalizedName(name);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return DarkAsteroidsItems.alphere;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random rand)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), rand, fortune))
        {
            int j = rand.nextInt(fortune + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }
            return this.quantityDropped(rand) * (j + 1);
        }
        else
        {
            return this.quantityDropped(rand);
        }
    }

    @Override
    public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
    {
        IBlockState state = world.getBlockState(pos);
        Random rand = world instanceof World ? ((World)world).rand : new Random();

        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            return MathHelper.getRandomIntegerInRange(rand, 3, 7);
        }
        return 0;
    }

    @Override
    public boolean isValueable(IBlockState state)
    {
        return true;
    }
}