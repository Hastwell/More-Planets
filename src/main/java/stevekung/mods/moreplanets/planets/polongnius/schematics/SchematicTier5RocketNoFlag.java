/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.schematics;

import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.planets.polongnius.client.gui.GuiSchematicTier5RocketNoFlag;
import stevekung.mods.moreplanets.planets.polongnius.inventory.container.ContainerSchematicTier5RocketNoFlag;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;

public class SchematicTier5RocketNoFlag implements ISchematicPage
{
	@Override
	public int getPageID()
	{
		return ConfigManagerMP.idSchematicTier5RocketNoFlag;
	}

	@Override
	public int getGuiID()
	{
		return ConfigManagerMP.idGuiSchematicTier5RocketNoFlag;
	}

	@Override
	public ItemStack getRequiredItem()
	{
		return new ItemStack(PolongniusItems.tier_5_rocket_schematic, 1, 1);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getResultScreen(EntityPlayer player, BlockPos pos)
	{
		return new GuiSchematicTier5RocketNoFlag(player.inventory, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public Container getResultContainer(EntityPlayer player, BlockPos pos)
	{
		return new ContainerSchematicTier5RocketNoFlag(player.inventory, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public int compareTo(ISchematicPage page)
	{
		if (this.getPageID() > page.getPageID())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}