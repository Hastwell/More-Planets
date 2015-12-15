package stevekung.mods.moreplanets.plugin.asm;

import java.util.HashMap;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;

import org.apache.logging.log4j.Level;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.common.versioning.VersionParser;
import cpw.mods.fml.relauncher.FMLInjectionData;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

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

    private static String CLASS_CLIENT_PROXY_MAIN = "stevekung/mods/moreplanets/core/proxy/ClientProxyMP";
    private static String CLASS_RENDER_PLAYER_MP = "stevekung/mods/moreplanets/core/todo/RenderPlayerMP";

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

        if (this.mcVersionMatches("[1.7.10]"))
        {
            this.nodemap.put(MorePlanetsTransformer.KEY_CLASS_ENTITY_LIVING, new ObfuscationEntry("net/minecraft/entity/EntityLivingBase", "sv"));
            this.nodemap.put(MorePlanetsTransformer.KEY_CLASS_ITEM_RENDERER, new ObfuscationEntry("net/minecraft/client/renderer/ItemRenderer", "bly"));
            this.nodemap.put(MorePlanetsTransformer.KEY_CLASS_RENDERER_LIVING_ENTITY, new ObfuscationEntry("net/minecraft/client/renderer/entity/RendererLivingEntity", "boh"));

            this.nodemap.put(MorePlanetsTransformer.KEY_METHOD_RENDER_OVERLAYS, new MethodObfuscationEntry("renderOverlays", "b", "(F)V"));
            this.nodemap.put(MorePlanetsTransformer.KEY_METHOD_RENDER_MODEL, new MethodObfuscationEntry("renderModel", "a", "(L" + this.getNameDynamic(MorePlanetsTransformer.KEY_CLASS_ENTITY_LIVING) + ";FFFFFF)V"));
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
        else if (testName.equals(this.nameRendererLivingEntity)) //TODO Custom Thermal Armor rendering
        {
            return this.transformRendererLivingEntity(bytes);
        }
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

                if (glEnable instanceof MethodInsnNode && ((MethodInsnNode) glEnable).name.equals("glEnable"))
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
}