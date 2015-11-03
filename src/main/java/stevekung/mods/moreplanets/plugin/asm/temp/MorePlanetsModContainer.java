package stevekung.mods.moreplanets.plugin.asm.temp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.VersionParser;
import net.minecraftforge.fml.common.versioning.VersionRange;

import com.google.common.eventbus.EventBus;

public class MorePlanetsModContainer extends DummyModContainer
{
	public MorePlanetsModContainer()
	{
		super(new ModMetadata());
		ModMetadata meta = this.getMetadata();
		meta.modId = "MorePlanetsASM";
		meta.name = "More Planets Core";
		meta.updateUrl = "http://minecraftforum.net/forums/thread/2358057";
		meta.description = "";
		meta.authorList = Arrays.asList("SteveKunG");
		meta.url = "http://minecraftforum.net/forums/thread/2358057";
		meta.credits = "to micdoodle8";
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		bus.register(this);
		return true;
	}

	@Override
	public List<ArtifactVersion> getDependencies()
	{
		LinkedList<ArtifactVersion> deps = new LinkedList<ArtifactVersion>();
		deps.add(VersionParser.parseVersionReference("required-after:Forge@[10.13.2.1291,)"));
		return deps;
	}

	@Override
	public VersionRange acceptableMinecraftVersionRange()
	{
		return VersionParser.parseRange("[1.7.2], [1.7.10]");
	}
}