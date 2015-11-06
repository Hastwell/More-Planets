package stevekung.mods.moreplanets.core.todo;

import static stevekung.mods.moreplanets.planets.venus.items.ItemJetpack.tick;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import micdoodle8.mods.galacticraft.core.network.IPacket;
import net.minecraft.entity.player.EntityPlayer;
import stevekung.mods.moreplanets.core.util.MPLog;
import stevekung.mods.moreplanets.planets.venus.items.ItemJetpack;
import stevekung.mods.moreplanets.planets.venus.items.VenusItems;

public class PacketUpdateItem implements IPacket
{
	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {}

	@Override
	public void handleClientSide(EntityPlayer player)
	{
		if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == VenusItems.jetpack)
		{
			//if (!flag && player.inventory.hasItem(Items.coal))
			{
				if (((ItemJetpack)player.inventory.armorItemInSlot(2).getItem()).getJetpackKeyDown()) {
					tick++;
				}
				if (ItemJetpack.tick >= 999)
				{
					player.inventory.armorItemInSlot(2).getTagCompound().setInteger("JetpackTick", tick);
				}
				MPLog.info("" + tick);
			}
			/*else if (flag)
			{
				return;
			}*/
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
		if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == VenusItems.jetpack)
		{
			//if (!flag && player.inventory.hasItem(Items.coal))
			{
				if (((ItemJetpack)player.inventory.armorItemInSlot(2).getItem()).getJetpackKeyDown()) {
					if (ItemJetpack.tick >= 999)
					{
						MPLog.info("Test server");
					}
				}
			}
			/*else if (flag)
			{
				return;
			}*/
		}
	}
}