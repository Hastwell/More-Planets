/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.itemblocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMorePlanets;

public class ItemBlockEuropaSapling extends ItemBlockMorePlanets
{
	public ItemBlockEuropaSapling(Block block)
	{
		super(block);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
	{
		if (player.worldObj.isRemote)
		{
			list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("desc.europasapling1.name"));
			list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("desc.europasapling2.name"));
			list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("desc.europasapling3.name"));
		}
	}
}