/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.items;

import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.ISchematicItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;

public class ItemTier5RocketSchematic extends ItemMorePlanets implements ISchematicItem
{
	public ItemTier5RocketSchematic(String name)
	{
		super();
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if (player.worldObj.isRemote)
		{
			list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("schematic.tier5.rocket.name"));
		}
	}
}