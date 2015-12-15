package stevekung.mods.moreplanets.plugin.asm;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

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
        return "stevekung.mods.moreplanets.plugin.asm.MorePlanetsAccessTransformer";
    }
}