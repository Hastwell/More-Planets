/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.eventhandler;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SkyProviderEventHandler
{
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onSkyRendererTick(ClientTickEvent event)
	{
		/*Minecraft minecraft = FMLClientHandler.instance().getClient();
		WorldClient world = minecraft.theWorld;

		if (world != null)
		{
			if (Loader.isModLoaded("GalacticraftMars"))
			{
				if (world.provider instanceof WorldProviderMars)
				{
					if (world.provider.getSkyRenderer() instanceof SkyProviderMars)
					{
						world.provider.setSkyRenderer(new SkyProviderMarsMP((IGalacticraftWorldProvider) world.provider));
					}
				}
			}

			if (world.provider instanceof WorldProviderDiona)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderDiona((IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderPolongnius)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderPolongnius((IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderNibiru)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderNibiru((IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderFronos)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderFronos((IGalacticraftWorldProvider) world.provider));
				}
			}
			else if (world.provider instanceof WorldProviderKoentus)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderKoentus((IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderKapteynB)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderKapteynB((IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderSiriusB)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderSiriusB((IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderMercury)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderMercury((IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderPhobos)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderPhobos((IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderDeimos)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderDeimos((IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
		}*/
	}
}