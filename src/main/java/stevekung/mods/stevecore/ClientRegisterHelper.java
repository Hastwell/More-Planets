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
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientRegisterHelper
{
	public static void registerVariantsName(Item item, String[] variant)
	{
		ModelBakery.addVariantName(item, variant);
	}

	public static void registerVariantsName(Block block, String[] variant)
	{
		ClientRegisterHelper.registerVariantsName(Item.getItemFromBlock(block), variant);
	}

	public static void registerVariantNameWithDyeColor(Block block, String folder)
	{
		ClientRegisterHelper.registerVariantsName(block, "white_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "orange_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "magenta_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "light_blue_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "yellow_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "lime_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "pink_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "gray_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "silver_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "cyan_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "purple_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "blue_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "brown_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "green_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "red_" + getBlockName(block), folder);
		ClientRegisterHelper.registerVariantsName(block, "black_" + getBlockName(block), folder);
	}

	public static void registerVariantNameWithDyeColor(Item item, String folder)
	{
		ClientRegisterHelper.registerVariantsName(item, "white_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "orange_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "magenta_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "light_blue_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "yellow_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "lime_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "pink_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "gray_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "silver_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "cyan_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "purple_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "blue_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "brown_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "green_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "red_" + getItemName(item), folder);
		ClientRegisterHelper.registerVariantsName(item, "black_" + getItemName(item), folder);
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
		ClientRegisterHelper.registerModelRender(block, 0, "white_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 1, "orange_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 2, "magenta_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 3, "light_blue_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 4, "yellow_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 5, "lime_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 6, "pink_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 7, "gray_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 8, "silver_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 9, "cyan_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 10, "purple_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 11, "blue_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 12, "brown_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 13, "green_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 14, "red_" + getBlockName(block), folder);
		ClientRegisterHelper.registerModelRender(block, 15, "black_" + getBlockName(block), folder);
	}

	public static void registerModelRenderWithDyeColor(Item item, String folder)
	{
		ClientRegisterHelper.registerModelRender(item, 0, "white_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 1, "orange_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 2, "magenta_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 3, "light_blue_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 4, "yellow_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 5, "lime_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 6, "pink_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 7, "gray_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 8, "silver_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 9, "cyan_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 10, "purple_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 11, "blue_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 12, "brown_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 13, "green_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 14, "red_" + getItemName(item), folder);
		ClientRegisterHelper.registerModelRender(item, 15, "black_" + getItemName(item), folder);
	}

	public static void registerStateMapper(Block block, EnumStateMapper mapper)
	{
		ClientRegisterHelper.registerStateMapper(block, mapper.builder);
	}

	public static void registerStateMapper(Block block, IStateMapper mapper)
	{
		Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().registerBlockWithStateMapper(block, mapper);
	}

	public static TextureAtlasSprite registerBlockTexture(String texture)
	{
		return Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelManager().getTextureMap().getAtlasSprite(texture);
	}

	public static TextureAtlasSprite getTexture(IBlockState state)
	{
		return Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(state).getTexture();
	}

	private static String getBlockName(Block block)
	{
		return block.getUnlocalizedName().substring(5);
	}

	private static String getItemName(Item item)
	{
		return item.getUnlocalizedName().substring(5);
	}

	private static void registerVariantsName(Block block, String variant, String folder)
	{
		ClientRegisterHelper.registerVariantsName(Item.getItemFromBlock(block), variant, folder);
	}

	private static void registerVariantsName(Item item, String variant, String folder)
	{
		ModelBakery.addVariantName(item, folder + ":" + variant);
	}
}