package stevekung.mods.moreplanets.plugin.asm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.VersionParser;
import cpw.mods.fml.common.versioning.VersionRange;

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
        meta.credits = "Credit ASM to micdoodle8";
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
        return VersionParser.parseRange("[1.7.10]");
    }
}