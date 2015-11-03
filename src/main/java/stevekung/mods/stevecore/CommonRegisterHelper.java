/*******************************************************************************
 * Copyright 2015 SteveKunG - Steve's Core
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.stevecore;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonRegisterHelper
{
	static int entityIDs = 0;

	public static void registerBlock(Block block)
	{
		if (Loader.isModLoaded("GalacticraftCore") && Loader.isModLoaded("MorePlanets"))
		{
			try
			{
				GameRegistry.registerBlock(block, (Class)Class.forName("micdoodle8.mods.galacticraft.core.items.ItemBlockGC"), block.getUnlocalizedName().substring(5));
			}
			catch (ClassNotFoundException e)
			{
				throw new RuntimeException("Could not find Galacticraft ItemBlockGC class. Something wrong?");
			}
		}
		else
		{
			GameRegistry.registerBlock(block, ItemBlock.class, block.getUnlocalizedName().substring(5));
		}
	}

	public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlock)
	{
		GameRegistry.registerBlock(block, itemBlock, block.getUnlocalizedName().substring(5));
	}

	public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlock, Object... objectFromItemBlock)
	{
		GameRegistry.registerBlock(block, itemBlock, block.getUnlocalizedName().substring(5), objectFromItemBlock);
	}

	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}

	public static void registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
	}

	public static void registerNonMobEntity(Class<? extends Entity> entity, String name, Object mod, boolean sendVelocityUpdate)
	{
		EntityRegistry.registerModEntity(entity, name, entityIDs++, mod, 256, 1, sendVelocityUpdate);
	}

	public static void registerFluidContainer(Fluid fluid, ItemStack filledContainer, ItemStack emptyContainer)
	{
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(new FluidStack(fluid, FluidContainerRegistry.BUCKET_VOLUME), filledContainer, emptyContainer));
	}

	public static void setFireBurn(Block block, int encouragement, int flammibility)
	{
		Blocks.fire.setFireInfo(block, encouragement, flammibility);
	}
}