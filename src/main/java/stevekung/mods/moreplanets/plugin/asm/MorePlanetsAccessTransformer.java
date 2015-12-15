package stevekung.mods.moreplanets.plugin.asm;

import java.io.IOException;

import cpw.mods.fml.common.asm.transformers.AccessTransformer;

public class MorePlanetsAccessTransformer extends AccessTransformer
{
    public MorePlanetsAccessTransformer() throws IOException
    {
        super("moreplanets_at.cfg");
    }
}