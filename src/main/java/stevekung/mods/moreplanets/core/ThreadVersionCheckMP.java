/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent.Serializer;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.util.MPLog;

public class ThreadVersionCheckMP extends Thread
{
    private int count = 0;
    private String URL = "http://minecraftforum.net/forums/thread/2358057";

    public static int remoteMajVer;
    public static int remoteMinVer;
    public static int remoteBuildVer;

    public ThreadVersionCheckMP()
    {
        super("More Planets Version Check Thread");
    }

    @Override
    public void run()
    {
        Side sideToCheck = FMLCommonHandler.instance().getSide();

        if (sideToCheck == null || !ConfigManagerMP.enableVersionCheck)
        {
            return;
        }

        while (this.count < 3 && remoteBuildVer == 0)
        {
            try
            {
                URL url = new URL("https://raw.githubusercontent.com/SteveKunG/More-Planets/1.8.9/version.txt");
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.addRequestProperty("User-Agent", "Mozilla/4.76");
                BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
                String str;
                String str2[] = null;

                while ((str = in.readLine()) != null)
                {
                    if (str.contains("Version"))
                    {
                        str = str.replace("Version=", "");
                        str2 = str.split("#");

                        if (str2.length == 3)
                        {
                            remoteMajVer = Integer.parseInt(str2[0]);
                            remoteMinVer = Integer.parseInt(str2[1]);
                            remoteBuildVer = Integer.parseInt(str2[2]);
                        }

                        if (remoteMajVer > MorePlanetsCore.major_version || remoteMajVer == MorePlanetsCore.major_version && remoteMinVer > MorePlanetsCore.minor_version || remoteMajVer == MorePlanetsCore.major_version && remoteMinVer == MorePlanetsCore.minor_version && remoteBuildVer > MorePlanetsCore.build_version)
                        {
                            Thread.sleep(5000);

                            if (sideToCheck.equals(Side.CLIENT))
                            {
                                Minecraft.getMinecraft().thePlayer.addChatMessage(Serializer.jsonToComponent("[{\"text\":\"New version available for \",\"extra\":[{\"text\":\"" + EnumChatFormatting.AQUA + "More Planets!\"},{\"text\":\"" + EnumChatFormatting.GREEN + " v" + String.valueOf(remoteMajVer) + "." + String.valueOf(remoteMinVer) + "." + String.valueOf(remoteBuildVer) + " \"},{\"text\":\"" + EnumChatFormatting.RED + "[CLICK HERE]\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"" + EnumChatFormatting.YELLOW + "Download Latest Version\"},\"clickEvent\":{\"action\":\"open_url\",\"value\":\"" + this.URL + "\"}}]}]"));
                            }
                            else if (sideToCheck.equals(Side.SERVER))
                            {
                                MPLog.info("New version available! v" + String.valueOf(remoteMajVer) + "." + String.valueOf(remoteMinVer) + "." + String.valueOf(remoteBuildVer) + " ");
                            }
                        }
                    }
                }
            }
            catch (Exception e) {}

            if (remoteBuildVer == 0)
            {
                try
                {
                    MPLog.error(StatCollector.translateToLocal("mp.failed.name"));
                    Thread.sleep(15000);
                }
                catch (InterruptedException e) {}
            }
            else
            {
                MPLog.info(StatCollector.translateToLocal("mp.success.name") + " " + remoteMajVer + "." + remoteMinVer + "." + remoteBuildVer);
            }
            this.count++;
        }
    }
}