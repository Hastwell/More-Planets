/*******************************************************************************
 * Copyright 2015 SteveKunG - Steve's Core
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.stevecore;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.block.statemap.StateMap.Builder;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public enum EnumStateMapper
{
    FENCE_GATE(new Builder().addPropertiesToIgnore(new IProperty[] {BlockFenceGate.POWERED}).build()),
    DOOR(new Builder().addPropertiesToIgnore(new IProperty[] {BlockDoor.POWERED}).build()),
    FLUID_LEVEL(new Builder().addPropertiesToIgnore(new IProperty[] {BlockFluidBase.LEVEL}).build()),
    LIQUID_LEVEL(new Builder().addPropertiesToIgnore(new IProperty[] {BlockLiquid.LEVEL}).build()),
    FIRE(new Builder().addPropertiesToIgnore(new IProperty[] {BlockFire.AGE}).build()),
    TNT(new Builder().addPropertiesToIgnore(new IProperty[] {BlockStateHelper.EXPLODE}).build()),
    LEAVES(new Builder().addPropertiesToIgnore(new IProperty[] {BlockStateHelper.CHECK_DECAY, BlockStateHelper.DECAYABLE}).build()),

    ;StateMap builder;

    private EnumStateMapper(StateMap builder)
    {
        this.builder = builder;
    }
}