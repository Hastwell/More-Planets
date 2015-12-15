/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.network.meteor;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Vec3;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import stevekung.mods.moreplanets.common.util.MPLog;

public class MeteorClientHandler implements IMessageHandler<MeteorClientMessage, IMessage>
{
    @Override
    public IMessage onMessage(final MeteorClientMessage message, MessageContext ctx)
    {
        if (ctx.side != Side.CLIENT)
        {
            MPLog.error("NetworkMessageToClient received on wrong side:" + ctx.side);
            return null;
        }
        if (!message.isMessageValid())
        {
            MPLog.error("NetworkMessageToClient was invalid" + message.toString());
            return null;
        }

        Minecraft.getMinecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                MeteorClientHandler.this.processMessage(Minecraft.getMinecraft().theWorld, message);
            }
        });
        return null;
    }

    void processMessage(WorldClient worldClient, MeteorClientMessage message)
    {
        Random rand = new Random();

        for (int i = 0; i < 100; ++i)
        {
            Vec3 targetCoordinates = message.getTargetCoordinates();
            double spawnXpos = targetCoordinates.xCoord + (2 * rand.nextDouble() - 1) * 1.5D;
            double spawnYpos = targetCoordinates.yCoord;
            double spawnZpos = targetCoordinates.zCoord + (2 * rand.nextDouble() - 1) * 1.5D;
            worldClient.spawnParticle(EnumParticleTypes.SPELL_INSTANT, spawnXpos, spawnYpos, spawnZpos, 0, 0, 0);
        }
        return;
    }
}