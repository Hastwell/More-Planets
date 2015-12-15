/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets ASM
 * 
 * Credit to : micdoodle8
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.plugin.asm;

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
        meta.url = "http://minecraftforum.net/forums/thread/2358057";
        meta.description = "";
        meta.authorList = Arrays.asList("SteveKunG");
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
        deps.add(VersionParser.parseVersionReference("required-after:Forge@[11.14.4.1577,)"));
        return deps;
    }

    @Override
    public VersionRange acceptableMinecraftVersionRange()
    {
        return VersionParser.parseRange("[1.8]");
    }
}