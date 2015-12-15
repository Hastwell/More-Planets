/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.objmodel;

import java.util.Map;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.util.MPLog;

import com.google.common.collect.Maps;

@SideOnly(Side.CLIENT)
public class AdvancedModelLoader
{
    private static Map<String, IModelCustomLoader> instances = Maps.newHashMap();

    public static void registerModelHandler(IModelCustomLoader modelHandler)
    {
        for (String suffix : modelHandler.getSuffixes())
        {
            instances.put(suffix, modelHandler);
        }
    }

    public static IModelCustom loadModel(ResourceLocation resource)
    {
        String name = resource.getResourcePath();
        int i = name.lastIndexOf('.');

        if (i == -1)
        {
            MPLog.error("The resource name %s is not valid", resource);
            throw new ModelFormatException("The resource name is not valid");
        }

        String suffix = name.substring(i+1);
        IModelCustomLoader loader = instances.get(suffix);

        if (loader == null)
        {
            MPLog.error("The resource name %s is not supported", resource);
            throw new ModelFormatException("The resource name is not supported");
        }
        return loader.loadInstance(resource);
    }

    static
    {
        AdvancedModelLoader.registerModelHandler(new ObjModelLoader());
    }
}