/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import net.minecraftforge.fml.relauncher.FMLRelaunchLog;

import org.apache.logging.log4j.Level;

import stevekung.mods.moreplanets.common.config.ConfigManagerMP;

public class MPLog
{
	public static void info(String message)
	{
		FMLRelaunchLog.log("More Planets", Level.INFO, message);
	}

	public static void error(String message)
	{
		FMLRelaunchLog.log("More Planets", Level.ERROR, message);
	}

	public static void warning(String message)
	{
		FMLRelaunchLog.log("More Planets", Level.WARN, message);
	}

	public static void debug(String message)
	{
		if (ConfigManagerMP.enableDebug)
		{
			FMLRelaunchLog.log("More Planets Debug", Level.INFO, message);
		}
	}

	public static void info(String message, Object... obj)
	{
		FMLRelaunchLog.log("More Planets", Level.INFO, message, obj);
	}

	public static void error(String message, Object... obj)
	{
		FMLRelaunchLog.log("More Planets", Level.ERROR, message, obj);
	}

	public static void warning(String message, Object... obj)
	{
		FMLRelaunchLog.log("More Planets", Level.WARN, message, obj);
	}

	public static void debug(String message, Object... obj)
	{
		if (ConfigManagerMP.enableDebug)
		{
			FMLRelaunchLog.log("More Planets Debug", Level.INFO, message, obj);
		}
	}
}