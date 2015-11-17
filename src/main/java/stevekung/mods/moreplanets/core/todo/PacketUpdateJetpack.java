package stevekung.mods.moreplanets.core.todo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import micdoodle8.mods.galacticraft.core.network.IPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.planets.venus.items.ItemJetpack;
import stevekung.mods.moreplanets.planets.venus.items.VenusItems;

public class PacketUpdateJetpack implements IPacket
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
			boolean flag = player.capabilities.isCreativeMode;
			ItemJetpack jetpack = (ItemJetpack) player.inventory.armorItemInSlot(2).getItem();
			ItemStack itemStack = player.inventory.armorItemInSlot(2);

			if (!flag && jetpack.getElectricityStored(itemStack) != 0.0F)
			{
				if (jetpack.getJetpackKeyDown())
				{
					jetpack.setElectricity(itemStack, jetpack.getElectricityStored(itemStack) - 1.0F);
				}
			}
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
		if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == VenusItems.jetpack)
		{
			boolean flag = player.capabilities.isCreativeMode;
			ItemJetpack jetpack = (ItemJetpack) player.inventory.armorItemInSlot(2).getItem();
			ItemStack itemStack = player.inventory.armorItemInSlot(2);

			if (!flag && jetpack.getElectricityStored(itemStack) != 0.0F)
			{
				if (jetpack.getJetpackKeyDown())
				{
					jetpack.setElectricity(itemStack, jetpack.getElectricityStored(itemStack) - 1.0F);
				}
			}
		}
	}
}