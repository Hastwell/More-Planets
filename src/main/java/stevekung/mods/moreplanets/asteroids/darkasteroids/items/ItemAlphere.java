package stevekung.mods.moreplanets.asteroids.darkasteroids.items;

import stevekung.mods.moreplanets.common.items.IPowerCrystal;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;

public class ItemAlphere extends ItemMorePlanets implements IPowerCrystal
{
	public ItemAlphere(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	public boolean isPowerCrystal(int meta)
	{
		return true;
	}

	@Override
	public int getPowerCrystalBurnTime(int meta)
	{
		return 650;
	}
}