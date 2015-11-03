/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.items;

import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.ISchematicItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;

public class ItemTier4RocketSchematic extends ItemMorePlanets implements ISchematicItem
{
	public ItemTier4RocketSchematic(String name)
	{
		super();
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
	{
		if (player.worldObj.isRemote)
		{
			list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("schematic.tier4.rocket.name"));
		}
	}
}