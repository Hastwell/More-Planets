package stevekung.mods.moreplanets.asteroids.darkasteroids.world.gen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.DarkAsteroidBlocks;

public class BiomeDecoratorDarkAsteroids extends BiomeDecoratorSpace
{
	private World world;
	private WorldGenerator sandGen;
	private WorldGenerator sandGen1;
	private WorldGenerator sandGen2;

	public BiomeDecoratorDarkAsteroids()
	{
		// Block,NumberOfBlock,Meta,IsMeta,FillBlock,FillMeta
		this.sandGen = new WorldGenMinableMeta(DarkAsteroidBlocks.dark_asteroid_quicksand, 8, 0, true, DarkAsteroidBlocks.dark_asteroid_rock, 0);
		this.sandGen1 = new WorldGenMinableMeta(DarkAsteroidBlocks.dark_asteroid_quicksand, 8, 0, true, DarkAsteroidBlocks.dark_asteroid_rock, 1);
		this.sandGen2 = new WorldGenMinableMeta(DarkAsteroidBlocks.dark_asteroid_quicksand, 8, 0, true, DarkAsteroidBlocks.dark_asteroid_rock, 2);
	}

	@Override
	protected void setCurrentWorld(World world)
	{
		this.world = world;
	}

	@Override
	protected World getCurrentWorld()
	{
		return this.world;
	}

	@Override
	protected void decorate()
	{
		//MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.world, this.rand, this.chunkX, this.chunkZ));
		this.generateOre(16, this.sandGen, 0, 255);
		this.generateOre(16, this.sandGen1, 0, 255);
		this.generateOre(16, this.sandGen2, 0, 255);
		//MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.world, this.rand, this.chunkX, this.chunkZ));
	}
}