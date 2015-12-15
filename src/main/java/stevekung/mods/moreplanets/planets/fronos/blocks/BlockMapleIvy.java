/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.BlockVineMP;
import stevekung.mods.moreplanets.common.entities.IImmuneMapleIvy;

public class BlockMapleIvy extends BlockVineMP
{
    public BlockMapleIvy(String name)
    {
        super();
        this.setUnlocalizedName(name);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
        if (entity instanceof EntityLivingBase)
        {
            if (!(entity instanceof IImmuneMapleIvy) || !((IImmuneMapleIvy)entity).canLivingInIvy())
            {
                if (world.rand.nextInt(2000) == 0)
                {
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 120));
                }
            }
        }
    }
}