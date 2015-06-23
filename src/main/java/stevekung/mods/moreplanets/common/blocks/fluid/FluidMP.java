/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.blocks.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidMP extends Fluid
{
	public FluidMP(String name)
	{
		super(name, new ResourceLocation("moreplanets:blocks/" + name.replace("_fluid", "") + "_still"), new ResourceLocation("moreplanets:blocks/" + name.replace("_fluid", "") + "_flowing"));
	}

	public FluidMP(String name, String still, String flowing)
	{
		super(name, new ResourceLocation(still), new ResourceLocation(flowing));
	}
}