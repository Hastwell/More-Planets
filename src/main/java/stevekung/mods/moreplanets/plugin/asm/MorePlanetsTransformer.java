/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.plugin.asm;

import java.io.IOException;
import java.util.Iterator;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class MorePlanetsTransformer implements IClassTransformer
{
	private boolean foundOnce = false;
	private static boolean obfuscated;
	private static String IBLOCKSTATE_NAME;
	private static String BLOCK_MODEL_SHAPES_NAME;
	private static String METHOD_GET_TEXTURE_NAME;
	private static String TEXTURE_ATLAS_SPRITE_NAME;
	private static String BLOCK_TEXTURE_HELPER_NAME;

	static
	{
		boolean obfuscated = true;

		try
		{
			obfuscated = Launch.classLoader.getClassBytes("net.minecraft.world.World") == null;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		MorePlanetsTransformer.obfuscated = obfuscated;
		IBLOCKSTATE_NAME = obfuscated ? "bec" : "net/minecraft/block/state/IBlockState";
		BLOCK_MODEL_SHAPES_NAME = obfuscated ? "clc" : "net/minecraft/client/renderer/BlockModelShapes";
		METHOD_GET_TEXTURE_NAME = obfuscated ? "a" : "getTexture";
		TEXTURE_ATLAS_SPRITE_NAME = obfuscated ? "cue" : "net/minecraft/client/renderer/texture/TextureAtlasSprite";
		BLOCK_TEXTURE_HELPER_NAME = "stevekung/mods/moreplanets/plugin/asm/BlockTextureHelper";
	}

	@Override
	public byte[] transform(String name, String transformedName, byte[] clazz)
	{
		ClassNode classNode = this.getClassNode(clazz);

		if (name.equals(BLOCK_MODEL_SHAPES_NAME.replace("/", ".")))
		{
			MethodNode renderMethodNode = this.getMethodNode(classNode, METHOD_GET_TEXTURE_NAME, "(L" + IBLOCKSTATE_NAME + ";)L" + TEXTURE_ATLAS_SPRITE_NAME + ";");
			InsnList instructions = new InsnList();
			instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
			instructions.add(new MethodInsnNode(Opcodes.INVOKESTATIC, BLOCK_TEXTURE_HELPER_NAME, "getTexture", "(L" + IBLOCKSTATE_NAME + ";)L" + TEXTURE_ATLAS_SPRITE_NAME + ";", false));
			instructions.add(new InsnNode(Opcodes.ARETURN));
			renderMethodNode.instructions.insertBefore(this.getInsertionPoint(renderMethodNode, "getTexture()"), instructions);
			Logger.info(MorePlanetsTransformer.obfuscated ? "Successfully patched into clc" : "Successfully patched into " + BLOCK_MODEL_SHAPES_NAME);
			return this.getBytes(classNode, 0);
		}
		return clazz;
	}

	private AbstractInsnNode getInsertionPoint(MethodNode methodNode, String name)
	{
		Iterator<AbstractInsnNode> iterator = methodNode.instructions.iterator();
		AbstractInsnNode returnNode = null;

		while (iterator.hasNext())
		{
			AbstractInsnNode currentNode = iterator.next();

			if (currentNode.getOpcode() == Opcodes.INVOKEINTERFACE && !this.foundOnce)
			{
				this.foundOnce = true;
			}
			if (currentNode.getOpcode() == Opcodes.INVOKEINTERFACE && this.foundOnce)
			{
				returnNode = currentNode.getPrevious();
			}
		}
		if (returnNode != null)
		{
			return returnNode;
		}
		throw new RuntimeException("Couldn't find the insertion point for " + name);
	}

	private ClassNode getClassNode(byte[] classBytes)
	{
		ClassReader reader = new ClassReader(classBytes);
		ClassNode node = new ClassNode();
		reader.accept(node, 0);
		return node;
	}

	private byte[] getBytes(ClassNode classNode, int flag)
	{
		ClassWriter writer = new ClassWriter(flag);
		classNode.accept(writer);
		return writer.toByteArray();
	}

	private MethodNode getMethodNode(ClassNode classNode, String methodName, String desc)
	{
		for (MethodNode method : classNode.methods)
		{
			if (method.name.equals(methodName) && method.desc.equals(desc))
			{
				return method;
			}
		}
		throw new RuntimeException(methodName + " doesn't exist in " + classNode.name + "!");
	}
}