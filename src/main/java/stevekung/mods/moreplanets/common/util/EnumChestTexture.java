/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

public enum EnumChestTexture
{
	DIONA,
	POLONGNIUS,
	NIBIRU,
	KOENTUS,
	FRONOS,
	KAPTEYN_B,
	SIRIUS_B,
	MERCURY,
	VENUS,
	PLUTO;

	@Override
	public String toString()
	{
		return this.name().toLowerCase();
	}
}