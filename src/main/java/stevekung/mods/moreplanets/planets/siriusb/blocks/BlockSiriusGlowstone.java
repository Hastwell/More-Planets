/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.blocks;

import java.util.Random;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.planets.siriusb.items.SiriusBItems;

public class BlockSiriusGlowstone extends BlockBaseMP
{
    public static PropertyBool IMMUNE = PropertyBool.create("immune_to_explosion");

    public BlockSiriusGlowstone(String name)
    {
        super(Material.glass);
        this.setHardness(0.3F);
        this.setLightLevel(1.0F);
        this.setStepSound(soundTypeGlass);
        this.setDefaultState(this.getDefaultState().withProperty(IMMUNE, false));
        this.setUnlocalizedName(name);
    }

    @Override
    public int quantityDropped(Random rand)
    {
        return 2 + rand.nextInt(3);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return SiriusBItems.sirius_glowstone_dust;
    }

    @Override
    public MapColor getMapColor(IBlockState state)
    {
        return MapColor.diamondColor;
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity entity, Explosion explosion)
    {
        int meta = this.getMetaFromState(world.getBlockState(pos));

        if (meta == 1)
        {
            return 100.0F;
        }
        return super.getExplosionResistance(world, pos, entity, explosion);
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { IMMUNE });
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(IMMUNE, Boolean.valueOf((meta & 1) == 1));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Boolean)state.getValue(IMMUNE)).booleanValue() ? 1 : 0;
    }
}