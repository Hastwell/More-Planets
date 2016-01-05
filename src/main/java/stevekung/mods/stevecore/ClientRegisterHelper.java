/*******************************************************************************
 * Copyright 2015 SteveKunG - Steve's Core
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.stevecore;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientRegisterHelper
{
    public static void registerVariantsName(Item item, String... variant)
    {
        for (String name : variant)
        {
            ModelBakery.registerItemVariants(item, new ModelResourceLocation(name, "inventory"));
        }
    }

    public static void registerVariantsName(Block block, String... variant)
    {
        ClientRegisterHelper.registerVariantsName(Item.getItemFromBlock(block), variant);
    }

    public static void registerVariantNameWithDyeColor(Block block, String folder)
    {
        ClientRegisterHelper.registerVariantsName(block, "white_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "orange_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "magenta_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "light_blue_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "yellow_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "lime_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "pink_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "gray_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "silver_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "cyan_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "purple_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "blue_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "brown_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "green_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "red_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(block, "black_" + block.getUnlocalizedName().substring(5), folder);
    }

    public static void registerVariantNameWithDyeColor(Item item, String folder)
    {
        ClientRegisterHelper.registerVariantsName(item, "white_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "orange_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "magenta_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "light_blue_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "yellow_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "lime_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "pink_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "gray_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "silver_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "cyan_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "purple_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "blue_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "brown_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "green_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "red_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerVariantsName(item, "black_" + item.getUnlocalizedName().substring(5), folder);
    }

    public static void registerModelRender(Block block, int meta, String variantName, String folder)
    {
        ClientRegisterHelper.registerModelRender(Item.getItemFromBlock(block), meta, variantName, folder);
    }

    public static void registerModelRender(Block block, String variantName, String folder)
    {
        ClientRegisterHelper.registerModelRender(Item.getItemFromBlock(block), 0, variantName, folder);
    }

    public static void registerModelRender(Item item, int meta, String variantName, String folder)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(folder + ":" + variantName, "inventory"));
    }

    public static void registerModelRender(Item item, ItemMeshDefinition itemMesh)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, itemMesh);
    }

    public static void registerModelRender(Block block, ItemMeshDefinition itemMesh)
    {
        ClientRegisterHelper.registerModelRender(Item.getItemFromBlock(block), itemMesh);
    }

    public static void registerModelRender(Item item, String variantName, String folder)
    {
        ClientRegisterHelper.registerModelRender(item, 0, variantName, folder);
    }

    public static void registerModelRenderWithDyeColor(Block block, String folder)
    {
        ClientRegisterHelper.registerModelRender(block, 0, "white_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 1, "orange_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 2, "magenta_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 3, "light_blue_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 4, "yellow_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 5, "lime_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 6, "pink_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 7, "gray_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 8, "silver_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 9, "cyan_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 10, "purple_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 11, "blue_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 12, "brown_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 13, "green_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 14, "red_" + block.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(block, 15, "black_" + block.getUnlocalizedName().substring(5), folder);
    }

    public static void registerModelRenderWithDyeColor(Item item, String folder)
    {
        ClientRegisterHelper.registerModelRender(item, 0, "white_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 1, "orange_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 2, "magenta_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 3, "light_blue_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 4, "yellow_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 5, "lime_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 6, "pink_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 7, "gray_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 8, "silver_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 9, "cyan_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 10, "purple_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 11, "blue_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 12, "brown_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 13, "green_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 14, "red_" + item.getUnlocalizedName().substring(5), folder);
        ClientRegisterHelper.registerModelRender(item, 15, "black_" + item.getUnlocalizedName().substring(5), folder);
    }

    public static void registerStateMapper(Block block, EnumStateMapper mapper)
    {
        Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().registerBlockWithStateMapper(block, mapper.builder);
    }

    public static TextureAtlasSprite registerBlockTexture(String texture)
    {
        return Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelManager().getTextureMap().getAtlasSprite(texture);
    }

    public static TextureAtlasSprite getParticleTexture(IBlockState state)
    {
        return Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(state).getParticleTexture();
    }

    private static void registerVariantsName(Block block, String variant, String folder)
    {
        ClientRegisterHelper.registerVariantsName(Item.getItemFromBlock(block), variant, folder);
    }

    private static void registerVariantsName(Item item, String variant, String folder)
    {
        ModelBakery.registerItemVariants(item, new ModelResourceLocation(folder + ":" + variant, "inventory"));
    }
}