package stevekung.mods.moreplanets.asteroids.darkasteroids.world.gen;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.DarkAsteroidBlocks;
import stevekung.mods.moreplanets.common.world.biome.BiomeDecoratorMP;

public class BiomeDecoratorDarkAsteroids extends BiomeDecoratorMP
{
	private WorldGenerator sandGen;
	private WorldGenerator sandGen1;
	private WorldGenerator sandGen2;

	public BiomeDecoratorDarkAsteroids()
	{
		this.sandGen = new WorldGenMinableMeta(DarkAsteroidBlocks.dark_asteroid_quicksand, 8, 0, true, DarkAsteroidBlocks.dark_asteroid_rock, 0);
		this.sandGen1 = new WorldGenMinableMeta(DarkAsteroidBlocks.dark_asteroid_quicksand, 8, 0, true, DarkAsteroidBlocks.dark_asteroid_rock, 1);
		this.sandGen2 = new WorldGenMinableMeta(DarkAsteroidBlocks.dark_asteroid_quicksand, 8, 0, true, DarkAsteroidBlocks.dark_asteroid_rock, 2);
	}

	@Override
	protected void generateOres()
	{
		this.generateOre(16, this.sandGen, 0, 256);
		this.generateOre(16, this.sandGen1, 0, 256);
		this.generateOre(16, this.sandGen2, 0, 256);
	}
}