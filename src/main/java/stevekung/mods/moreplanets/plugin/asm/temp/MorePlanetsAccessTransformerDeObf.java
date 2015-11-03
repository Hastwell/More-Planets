package stevekung.mods.moreplanets.plugin.asm.temp;

import java.io.IOException;

import net.minecraftforge.fml.common.asm.transformers.AccessTransformer;

public class MorePlanetsAccessTransformerDeObf extends AccessTransformer
{
	public MorePlanetsAccessTransformerDeObf() throws IOException
	{
		super("moreplanets_at.deobf");
	}
}