package stevekung.mods.moreplanets.plugin.asm.temp;

import java.util.Map;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

@TransformerExclusions(value = { "stevekung.mods.moreplanets.plugin.asm" })
public class MorePlanetsPlugin implements IFMLLoadingPlugin
{
	@Override
	public String[] getASMTransformerClass()
	{
		return new String[] { "stevekung.mods.moreplanets.plugin.asm.MorePlanetsTransformer" };
	}

	@Override
	public String getModContainerClass()
	{
		return "stevekung.mods.moreplanets.plugin.asm.MorePlanetsModContainer";
	}

	@Override
	public String getSetupClass()
	{
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {}

	@Override
	public String getAccessTransformerClass()
	{
		boolean deobfuscated = true;

		try
		{
			deobfuscated = Launch.classLoader.getClassBytes("net.minecraft.world.World") != null;
		}
		catch (Exception e) {}

		if (deobfuscated)
		{
			return "stevekung.mods.moreplanets.plugin.asm.MorePlanetsAccessTransformerDeObf";
		}
		return "stevekung.mods.moreplanets.plugin.asm.MorePlanetsAccessTransformer";
	}
}