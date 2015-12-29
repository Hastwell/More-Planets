package stevekung.mods.moreplanets.plugin.asm;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

@TransformerExclusions(value = { "stevekung.mods.moreplanets.plugin.asm" })
@MCVersion(value = "1.7.10")
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
        return null;//TODO "stevekung.mods.moreplanets.plugin.asm.MorePlanetsModContainer"
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
        return "stevekung.mods.moreplanets.plugin.asm.MorePlanetsAccessTransformer";
    }
}