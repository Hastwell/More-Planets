package stevekung.mods.moreplanets.plugin.asm.temp;

import java.io.IOException;

import net.minecraftforge.fml.common.asm.transformers.AccessTransformer;

public class MorePlanetsAccessTransformer extends AccessTransformer
{
	public MorePlanetsAccessTransformer() throws IOException
	{
		super("moreplanets_at.cfg");
	}
}