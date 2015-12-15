package stevekung.mods.moreplanets.core.world;

import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderGenerate;

public class ChunkProviderNull extends ChunkProviderGenerate
{
    public ChunkProviderNull(World world, long seed, boolean genFeature)
    {
        super(world, seed, genFeature);
    }
}