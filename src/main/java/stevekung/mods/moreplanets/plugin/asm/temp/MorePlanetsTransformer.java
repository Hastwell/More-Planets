package stevekung.mods.moreplanets.plugin.asm.temp;

import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;
import net.minecraftforge.fml.common.versioning.VersionParser;
import net.minecraftforge.fml.relauncher.FMLInjectionData;
import net.minecraftforge.fml.relauncher.FMLRelaunchLog;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

import org.apache.logging.log4j.Level;
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

@TransformerExclusions(value = { "stevekung.mods.moreplanets.plugin.asm" })
public class MorePlanetsTransformer implements IClassTransformer
{
	HashMap<String, ObfuscationEntry> nodemap = new HashMap<String, ObfuscationEntry>();
	private boolean deobfuscated = true;
	private DefaultArtifactVersion mcVersion;

	private String nameItemRenderer;
	private String nameRendererLivingEntity;

	private static String KEY_CLASS_ENTITY_LIVING = "entityLivingClass";
	private static String KEY_CLASS_ITEM_RENDERER = "itemRendererClass";
	private static String KEY_CLASS_RENDERER_LIVING_ENTITY = "rendererLivingEntity";
	private static String KEY_METHOD_RENDER_OVERLAYS = "renderOverlaysMethod";
	private static String KEY_METHOD_RENDER_MODEL = "renderModel";
	
	private static String IBLOCKSTATE_NAME;
	private static String BLOCK_MODEL_SHAPES_NAME;
	private static String METHOD_GET_TEXTURE_NAME = "getTexture";
	private static String TEXTURE_ATLAS_SPRITE_NAME;

	private static String CLASS_CLIENT_PROXY_MAIN = "stevekung/mods/moreplanets/core/proxy/ClientProxyMP";
	private static String CLASS_RENDER_PLAYER_MP = "stevekung/mods/moreplanets/core/todo/RenderPlayerMP";
	private static String BLOCK_TEXTURE_HELPER_NAME = "stevekung/mods/moreplanets/plugin/asm/BlockTextureHelper";

	private static int operationCount = 0;
	private static int injectionCount = 0;

	public MorePlanetsTransformer()
	{
		this.mcVersion = new DefaultArtifactVersion((String) FMLInjectionData.data()[4]);

		try
		{
			this.deobfuscated = Launch.classLoader.getClassBytes("net.minecraft.world.World") != null;
		}
		catch (Exception e) {}

		if (this.mcVersionMatches("[1.8]"))
		{
			this.nodemap.put(MorePlanetsTransformer.KEY_CLASS_ENTITY_LIVING, new ObfuscationEntry("net/minecraft/entity/EntityLivingBase", "xm"));
			this.nodemap.put(MorePlanetsTransformer.KEY_CLASS_ITEM_RENDERER, new ObfuscationEntry("net/minecraft/client/renderer/ItemRenderer", "cki"));
			this.nodemap.put(MorePlanetsTransformer.KEY_CLASS_RENDERER_LIVING_ENTITY, new ObfuscationEntry("net/minecraft/client/renderer/entity/RendererLivingEntity", "cqv"));
			
			this.nodemap.put(MorePlanetsTransformer.IBLOCKSTATE_NAME, new ObfuscationEntry("net/minecraft/block/state/IBlockState", "bec"));
			this.nodemap.put(MorePlanetsTransformer.BLOCK_MODEL_SHAPES_NAME, new ObfuscationEntry("net/minecraft/client/renderer/BlockModelShapes", "clc"));
			this.nodemap.put(MorePlanetsTransformer.TEXTURE_ATLAS_SPRITE_NAME, new ObfuscationEntry("net/minecraft/client/renderer/texture/TextureAtlasSprite", "cue"));

			this.nodemap.put(MorePlanetsTransformer.KEY_METHOD_RENDER_OVERLAYS, new MethodObfuscationEntry("renderOverlays", "b", "(F)V"));
			this.nodemap.put(MorePlanetsTransformer.KEY_METHOD_RENDER_MODEL, new MethodObfuscationEntry("renderModel", "a", "(L" + this.getNameDynamic(MorePlanetsTransformer.KEY_CLASS_ENTITY_LIVING) + ";FFFFFF)V"));
			this.nodemap.put(MorePlanetsTransformer.METHOD_GET_TEXTURE_NAME, new MethodObfuscationEntry(METHOD_GET_TEXTURE_NAME, "a"));
		}
	}

	@Override
	public byte[] transform(String name, String transformedName, byte[] bytes)
	{
		if (this.deobfuscated)
		{
			this.populateNamesDeObf();
		}
		else
		{
			this.populateNamesObf();
		}

		String testName = name.replace('.', '/');

		if (testName.length() <= 3 || this.deobfuscated)
		{
			return this.transformVanilla(testName, bytes);
		}
		this.transformBlockTexture(name, bytes);
		return bytes;
	}

	private void populateNamesDeObf()
	{
		this.nameItemRenderer = this.getName(MorePlanetsTransformer.KEY_CLASS_ITEM_RENDERER);
		this.nameRendererLivingEntity = this.getName(MorePlanetsTransformer.KEY_CLASS_RENDERER_LIVING_ENTITY);
	}

	private void populateNamesObf()
	{
		this.nameItemRenderer = this.nodemap.get(MorePlanetsTransformer.KEY_CLASS_ITEM_RENDERER).obfuscatedName;
		this.nameRendererLivingEntity = this.nodemap.get(MorePlanetsTransformer.KEY_CLASS_RENDERER_LIVING_ENTITY).obfuscatedName;
	}

	private byte[] transformVanilla(String testName, byte[] bytes)
	{
		if (testName.equals(this.nameItemRenderer))
		{
			return this.transformItemRenderer(bytes);
		}
		/*else if (testName.equals(this.nameRendererLivingEntity)) TODO Custom Thermal Armor rendering
		{
			return this.transformRendererLivingEntity(bytes);
		}*/
		return bytes;
	}

	public byte[] transformItemRenderer(byte[] bytes)
	{
		ClassNode node = this.startInjection(bytes);
		MorePlanetsTransformer.operationCount = 1;
		MethodNode renderOverlaysMethod = this.getMethod(node, MorePlanetsTransformer.KEY_METHOD_RENDER_OVERLAYS);

		if (renderOverlaysMethod != null)
		{
			for (int count = 0; count < renderOverlaysMethod.instructions.size(); count++)
			{
				AbstractInsnNode glEnable = renderOverlaysMethod.instructions.get(count);

				if (glEnable instanceof MethodInsnNode && ((MethodInsnNode) glEnable).name.equals("enableBlend"))
				{
					InsnList toAdd = new InsnList();
					toAdd.add(new VarInsnNode(Opcodes.FLOAD, 1));
					toAdd.add(new MethodInsnNode(Opcodes.INVOKESTATIC, MorePlanetsTransformer.CLASS_CLIENT_PROXY_MAIN, "renderFluidOverlays", "(F)V", false));
					renderOverlaysMethod.instructions.insertBefore(glEnable, toAdd);
					MorePlanetsTransformer.injectionCount++;
					break;
				}
			}
		}
		return this.finishInjection(node);
	}
	
	public byte[] transformBlockTexture(String name, byte[] bytes)
	{
		ClassNode classNode = this.startInjection(bytes);
		MorePlanetsTransformer.operationCount = 1;

		if (name.equals(BLOCK_MODEL_SHAPES_NAME.replace("/", ".")))
		{
			MethodNode renderMethodNode = this.getMethodNode(classNode, METHOD_GET_TEXTURE_NAME, "(L" + IBLOCKSTATE_NAME + ";)L" + TEXTURE_ATLAS_SPRITE_NAME + ";");
			InsnList instructions = new InsnList();
			instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
			instructions.add(new MethodInsnNode(Opcodes.INVOKESTATIC, BLOCK_TEXTURE_HELPER_NAME, "getTexture", "(L" + IBLOCKSTATE_NAME + ";)L" + TEXTURE_ATLAS_SPRITE_NAME + ";", false));
			instructions.add(new InsnNode(Opcodes.ARETURN));
			renderMethodNode.instructions.insertBefore(this.getInsertionPoint(renderMethodNode, "getTexture()"), instructions);
			//Logger.info(MorePlanetsTransformer.obfuscated ? "Successfully patched into clc" : "Successfully patched into " + BLOCK_MODEL_SHAPES_NAME);
		}
		return this.finishInjection(classNode);
	}

	public byte[] transformRendererLivingEntity(byte[] bytes)
	{
		ClassNode node = this.startInjection(bytes);
		MorePlanetsTransformer.operationCount = 1;
		MethodNode method = this.getMethod(node, MorePlanetsTransformer.KEY_METHOD_RENDER_MODEL);

		if (method != null)
		{
			for (int count = 0; count < method.instructions.size(); count++)
			{
				AbstractInsnNode list = method.instructions.get(count);

				if (list.getOpcode() == Opcodes.RETURN)
				{
					AbstractInsnNode nodeAbove = method.instructions.get(count - 2);
					InsnList toAdd = new InsnList();
					toAdd.add(new VarInsnNode(Opcodes.ALOAD, 0));
					toAdd.add(new VarInsnNode(Opcodes.ALOAD, 1));
					toAdd.add(new VarInsnNode(Opcodes.FLOAD, 2));
					toAdd.add(new VarInsnNode(Opcodes.FLOAD, 3));
					toAdd.add(new VarInsnNode(Opcodes.FLOAD, 4));
					toAdd.add(new VarInsnNode(Opcodes.FLOAD, 5));
					toAdd.add(new VarInsnNode(Opcodes.FLOAD, 6));
					toAdd.add(new VarInsnNode(Opcodes.FLOAD, 7));
					toAdd.add(new MethodInsnNode(Opcodes.INVOKESTATIC, MorePlanetsTransformer.CLASS_RENDER_PLAYER_MP, "renderModelS", "(L" + this.getNameDynamic(MorePlanetsTransformer.KEY_CLASS_RENDERER_LIVING_ENTITY) + ";L" + this.getNameDynamic(MorePlanetsTransformer.KEY_CLASS_ENTITY_LIVING) + ";FFFFFF)V", false));
					method.instructions.insertBefore(nodeAbove, toAdd);
					MorePlanetsTransformer.injectionCount++;
					break;
				}
			}
		}
		return this.finishInjection(node);
	}

	public static class ObfuscationEntry
	{
		public String name;
		public String obfuscatedName;

		public ObfuscationEntry(String name, String obfuscatedName)
		{
			this.name = name;
			this.obfuscatedName = obfuscatedName;
		}

		public ObfuscationEntry(String commonName)
		{
			this(commonName, commonName);
		}
	}

	public static class MethodObfuscationEntry extends ObfuscationEntry
	{
		public String methodDesc;

		public MethodObfuscationEntry(String name, String obfuscatedName, String methodDesc)
		{
			super(name, obfuscatedName);
			this.methodDesc = methodDesc;
		}

		public MethodObfuscationEntry(String commonName, String methodDesc)
		{
			this(commonName, commonName, methodDesc);
		}
	}

	private void printResultsAndReset(String nodeName)
	{
		if (MorePlanetsTransformer.operationCount > 0)
		{
			if (MorePlanetsTransformer.injectionCount >= MorePlanetsTransformer.operationCount)
			{
				this.printLog("More Planets successfully injected bytecode into: " + nodeName + " (" + MorePlanetsTransformer.injectionCount + " / " + MorePlanetsTransformer.operationCount + ")");
			}
			else
			{
				FMLRelaunchLog.log("More Planets ASM", Level.ERROR, "Potential problem: More Planets did not complete injection of bytecode into: " + nodeName + " (" + MorePlanetsTransformer.injectionCount + " / " + MorePlanetsTransformer.operationCount + ")");
			}
		}
	}

	private MethodNode getMethod(ClassNode node, String keyName)
	{
		for (MethodNode methodNode : node.methods)
		{
			if (this.methodMatches(keyName, methodNode))
			{
				return methodNode;
			}
		}
		return null;
	}

	private boolean methodMatches(String keyName, MethodNode node)
	{
		return node.name.equals(this.getNameDynamic(keyName)) && node.desc.equals(this.getDescDynamic(keyName));
	}

	public String getName(String keyName)
	{
		return this.nodemap.get(keyName).name;
	}

	public String getObfName(String keyName)
	{
		return this.nodemap.get(keyName).obfuscatedName;
	}

	public String getNameDynamic(String keyName)
	{
		try
		{
			if (this.deobfuscated)
			{
				return this.getName(keyName);
			}
			else
			{
				return this.getObfName(keyName);
			}
		}
		catch (NullPointerException e)
		{
			FMLRelaunchLog.log("More Planets ASM", Level.ERROR, "Could not find key: " + keyName);
			throw e;
		}
	}

	public String getDescDynamic(String keyName)
	{
		return ((MethodObfuscationEntry) this.nodemap.get(keyName)).methodDesc;
	}

	private void printLog(String message)
	{
		FMLRelaunchLog.log("More Planets ASM", Level.INFO, message);
	}

	private ClassNode startInjection(byte[] bytes)
	{
		ClassNode node = new ClassNode();
		ClassReader reader = new ClassReader(bytes);
		reader.accept(node, 0);
		MorePlanetsTransformer.injectionCount = 0;
		MorePlanetsTransformer.operationCount = 0;
		return node;
	}

	private byte[] finishInjection(ClassNode node)
	{
		return this.finishInjection(node, true);
	}

	private byte[] finishInjection(ClassNode node, boolean printToLog)
	{
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		node.accept(writer);

		if (printToLog)
		{
			this.printResultsAndReset(node.name);
		}
		return writer.toByteArray();
	}

	private boolean mcVersionMatches(String testVersion)
	{
		return VersionParser.parseRange(testVersion).containsVersion(this.mcVersion);
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
	
	private boolean foundOnce = false;
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
}