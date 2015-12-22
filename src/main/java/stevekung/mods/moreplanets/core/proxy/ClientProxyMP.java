/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.proxy;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import stevekung.mods.moreplanets.client.EffectHandlerMP;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.client.renderer.EntityRendererMP;
import stevekung.mods.moreplanets.client.renderer.ModelRendererMP;
import stevekung.mods.moreplanets.client.renderer.TileEntityItemStackRendererMP;
import stevekung.mods.moreplanets.client.renderer.TileEntityRendererMP;
import stevekung.mods.moreplanets.common.util.BlockVariantsUtil;
import stevekung.mods.moreplanets.common.util.ItemVariantsUtil;
import stevekung.mods.moreplanets.common.util.StateMapperUtil;
import stevekung.mods.moreplanets.planets.venus.client.model.ModelJetpack;
import stevekung.mods.moreplanets.planets.venus.items.VenusItems;

public class ClientProxyMP extends CommonProxyMP
{
    public static Map<Item, ModelBiped> jetpackModel = new HashMap<Item, ModelBiped>();

    @Override
    public void registerRenderer()
    {
        TileEntityItemStackRenderer.instance = new TileEntityItemStackRendererMP();

        EntityRendererMP.init();
        TileEntityRendererMP.registerTileEntityRenderers();
        ModelRendererMP.registerModelRender();
        StateMapperUtil.registerStateMapper();
        BlockVariantsUtil.registerBlockVariants();
        ItemVariantsUtil.registerItemVariants();

        ModelJetpack jetpack = new ModelJetpack(0.75F);
        jetpackModel.put(VenusItems.jetpack, jetpack);
    }

    @Override
    public void spawnParticle(EnumParticleTypesMP type, double x, double y, double z, double motionX, double motionY, double motionZ)
    {
        EffectHandlerMP.spawnParticle(type, x, y, z, motionX, motionY, motionZ);
    }

    @Override
    public void spawnParticle(EnumParticleTypesMP type, double x, double y, double z)
    {
        EffectHandlerMP.spawnParticle(type, x, y, z);
    }

    @Override
    public void resetPlayerFloatingTick(EntityPlayer player)
    {
        if (player instanceof EntityPlayerMP)
        {
            ObfuscationReflectionHelper.setPrivateValue(NetHandlerPlayServer.class, ((EntityPlayerMP)player).playerNetServerHandler, Integer.valueOf(0), new String[] { "field_147365_f", "floatingTickCount" });
        }
    }
}