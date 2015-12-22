/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.command;

import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.WorldServer;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.player.MPPlayerStats;
import stevekung.mods.moreplanets.common.util.WorldUtilMP;

public class CommandHomePlanet extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return MinecraftServer.getServer().isSinglePlayer() || super.canCommandSenderUseCommand(sender);
    }

    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return "/" + this.getCommandName();
    }

    @Override
    public String getCommandName()
    {
        return "homeplanettp";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] length) throws CommandException
    {
        EntityPlayerMP playerBase = PlayerUtil.getPlayerBaseServerFromPlayerUsername(sender.getCommandSenderName(), true);
        MPPlayerStats stats = MPPlayerStats.get(playerBase);

        if (length.length < 1)
        {
            if (!stats.usingHomePlanetCommand)
            {
                MinecraftServer server = MinecraftServer.getServer();
                WorldServer worldserver = server.worldServerForDimension(server.worldServers[0].provider.getDimensionId());

                if (ConfigManagerMP.homePlanetName == null || ConfigManagerMP.homePlanetName == "planet.")
                {
                    throw new WrongUsageException(StatCollector.translateToLocal("commands.homeplanettp.confignull"));
                }
                else
                {
                    int dimID = WorldUtil.getProviderForName(ConfigManagerMP.homePlanetName).getDimensionId();
                    WorldUtilMP.setHomePlanetDimension(playerBase, dimID, worldserver);
                    stats.usingHomePlanetCommand = true;
                    CommandBase.notifyOperators(sender, this, "commands.homeplanettp.success", new Object[] { playerBase.getGameProfile().getName(), StatCollector.translateToLocal(ConfigManagerMP.homePlanetName) });
                }
            }
            else
            {
                throw new WrongUsageException(StatCollector.translateToLocalFormatted("commands.homeplanettp.alreadyuse", playerBase.getGameProfile().getName()));
            }
        }
        else
        {
            throw new WrongUsageException(StatCollector.translateToLocalFormatted("commands.dimensiontp.tooMany", this.getCommandUsage(sender)), new Object[0]);
        }
    }
}