package stevekung.mods.moreplanets.core.todo;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.client.model.ModelPlayerGC;
import micdoodle8.mods.galacticraft.core.client.render.entities.RenderPlayerGC;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.wrappers.PlayerGearData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.Loader;

public class RenderPlayerMP extends RenderPlayerGC
{
	public static ModelBiped modelThermalPadding;
	public static ModelBiped modelThermalPaddingHelmet;
	private static ResourceLocation thermalPaddingTexture0;
	private static ResourceLocation thermalPaddingTexture1;
	private static Boolean isSmartRenderLoaded = null;

	static
	{
		modelThermalPadding = new ModelPlayerGC(0.25F);
		modelThermalPaddingHelmet = new ModelPlayerGC(0.9F);
	}

	public RenderPlayerMP()
	{
		super();
		this.mainModel = new ModelPlayerGC(0.0F);
		this.modelBipedMain = (ModelPlayerGC) this.mainModel;
		this.modelArmorChestplate = new ModelPlayerGC(1.0F);
		this.modelArmor = new ModelPlayerGC(0.5F);
		RenderPlayerMP.thermalPaddingTexture0 = new ResourceLocation("galacticraftasteroids", "textures/misc/thermalPadding_0.png");
		RenderPlayerMP.thermalPaddingTexture1 = new ResourceLocation("galacticraftasteroids", "textures/misc/thermalPadding_1.png");
	}

	public static void renderModelS(RendererLivingEntity inst, EntityLivingBase living, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		if (inst instanceof RenderPlayer)
		{
			RenderPlayer thisInst = (RenderPlayer)inst;

			if (isSmartRenderLoaded == null)
			{
				isSmartRenderLoaded = Loader.isModLoaded("SmartRender");
			}

			if (RenderPlayerMP.thermalPaddingTexture0 != null && !isSmartRenderLoaded)
			{
				PlayerGearData gearData = ClientProxyCore.playerItemData.get(living.getCommandSenderName());

				if (gearData != null)
				{
					ModelBiped modelBiped;

					for (int i = 0; i < 4; ++i)
					{
						if (i == 0)
						{
							modelBiped = modelThermalPaddingHelmet;
						}
						else
						{
							modelBiped = modelThermalPadding;
						}

						int padding = gearData.getThermalPadding(i);

						if (padding >= 0 && !living.isInvisible())
						{
							GL11.glColor4f(1, 1, 1, 1);
							Minecraft.getMinecraft().renderEngine.bindTexture(RenderPlayerMP.thermalPaddingTexture1);
							modelBiped.bipedHead.showModel = i == 0;
							modelBiped.bipedHeadwear.showModel = i == 0;
							modelBiped.bipedBody.showModel = i == 1 || i == 2;
							modelBiped.bipedRightArm.showModel = i == 1;
							modelBiped.bipedLeftArm.showModel = i == 1;
							modelBiped.bipedRightLeg.showModel = i == 2 || i == 3;
							modelBiped.bipedLeftLeg.showModel = i == 2 || i == 3;
							modelBiped.onGround = thisInst.mainModel.onGround;
							modelBiped.isRiding = thisInst.mainModel.isRiding;
							modelBiped.isChild = thisInst.mainModel.isChild;

							if (thisInst.mainModel instanceof ModelBiped)
							{
								modelBiped.heldItemLeft = ((ModelBiped) thisInst.mainModel).heldItemLeft;
								modelBiped.heldItemRight = ((ModelBiped) thisInst.mainModel).heldItemRight;
								modelBiped.isSneak = ((ModelBiped) thisInst.mainModel).isSneak;
								modelBiped.aimedBow = ((ModelBiped) thisInst.mainModel).aimedBow;
							}

							modelBiped.setLivingAnimations(living, par2, par3, 0.0F);
							modelBiped.render(living, par2, par3, par4, par5, par6, par7);

							// Start alpha render
							GL11.glDisable(GL11.GL_LIGHTING);
							Minecraft.getMinecraft().renderEngine.bindTexture(RenderPlayerMP.thermalPaddingTexture0);
							GL11.glEnable(GL11.GL_ALPHA_TEST);
							GL11.glEnable(GL11.GL_BLEND);
							GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
							GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
							float time = living.ticksExisted / 10.0F;
							float sTime = (float) Math.sin(time) * 0.5F + 0.5F;

							float r = 0.2F * sTime;
							float g = 1.0F * sTime;
							float b = 0.2F * sTime;

							if (living.worldObj.provider instanceof IGalacticraftWorldProvider)
							{
								float modifier = ((IGalacticraftWorldProvider) living.worldObj.provider).getThermalLevelModifier();

								if (modifier > 0)
								{
									b = g;
									g = r;
								}
								else if (modifier < 0)
								{
									r = g;
									g = b;
								}
							}

							GL11.glColor4f(r, g, b, 0.4F * sTime);
							modelBiped.render(living, par2, par3, par4, par5, par6, par7);
							GL11.glDisable(GL11.GL_BLEND);
							GL11.glEnable(GL11.GL_ALPHA_TEST);
							GL11.glColor4f(1, 1, 1, 1);
							GL11.glEnable(GL11.GL_LIGHTING);
						}
					}
				}
			}
		}
	}
}