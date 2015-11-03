package stevekung.mods.moreplanets.plugin.asm;

import net.minecraftforge.fml.relauncher.FMLRelaunchLog;

import org.apache.logging.log4j.Level;

public class Logger
{
	public static void info(String message)
	{
		FMLRelaunchLog.log("More Planets ASM", Level.INFO, message);
	}

	public static void error(String message)
	{
		FMLRelaunchLog.log("More Planets ASM", Level.ERROR, message);
	}

	public static void warning(String message)
	{
		FMLRelaunchLog.log("More Planets ASM", Level.WARN, message);
	}

	public static void info(String message, Object... obj)
	{
		FMLRelaunchLog.log("More Planets ASM", Level.INFO, message, obj);
	}

	public static void error(String message, Object... obj)
	{
		FMLRelaunchLog.log("More Planets ASM", Level.ERROR, message, obj);
	}

	public static void warning(String message, Object... obj)
	{
		FMLRelaunchLog.log("More Planets ASM", Level.WARN, message, obj);
	}
}