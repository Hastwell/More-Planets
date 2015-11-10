/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.client.gui;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
import micdoodle8.mods.galacticraft.core.client.gui.element.GuiElementInfoRegion;
import micdoodle8.mods.galacticraft.core.energy.EnergyDisplayHelper;
import micdoodle8.mods.galacticraft.core.network.PacketSimple;
import micdoodle8.mods.galacticraft.core.network.PacketSimple.EnumSimplePacket;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.planets.polongnius.inventory.container.ContainerUltraVioletSolarPanel;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityUltraVioletSolarPanel;

public class GuiUltraVioletSolarPanel extends GuiContainerGC
{
	private ResourceLocation solarGuiTexture = new ResourceLocation("moreplanets:textures/gui/ultra_violet_solar_panel.png");
	private TileEntityUltraVioletSolarPanel tileEntity;
	private GuiButton buttonEnableSolar;
	private GuiElementInfoRegion electricInfoRegion = new GuiElementInfoRegion((this.width - this.xSize) / 2 + 107, (this.height - this.ySize) / 2 + 101, 56, 9, new ArrayList<String>(), this.width, this.height, this);

	public GuiUltraVioletSolarPanel(InventoryPlayer invPlayer, TileEntityUltraVioletSolarPanel solarPanel)
	{
		super(new ContainerUltraVioletSolarPanel(invPlayer, solarPanel));
		this.tileEntity = solarPanel;
		this.ySize = 201;
		this.xSize = 176;
	}

	@Override
	protected void actionPerformed(GuiButton gui)
	{
		switch (gui.id)
		{
		case 0:
			GalacticraftCore.packetPipeline.sendToServer(new PacketSimple(EnumSimplePacket.S_UPDATE_DISABLEABLE_BUTTON, new Object[] { this.tileEntity.getPos().getX(), this.tileEntity.getPos().getY(), this.tileEntity.getPos().getZ(), 0 }));
			break;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		super.initGui();
		List<String> electricityDesc = new ArrayList<String>();
		electricityDesc.add(GCCoreUtil.translate("gui.energyStorage.desc.0"));
		electricityDesc.add(EnumChatFormatting.YELLOW + GCCoreUtil.translate("gui.energyStorage.desc.1") + ((int) Math.floor(this.tileEntity.getEnergyStoredGC()) + " / " + (int) Math.floor(this.tileEntity.getMaxEnergyStoredGC())));
		this.electricInfoRegion.tooltipStrings = electricityDesc;
		this.electricInfoRegion.xPosition = (this.width - this.xSize) / 2 + 96;
		this.electricInfoRegion.yPosition = (this.height - this.ySize) / 2 + 24;
		this.electricInfoRegion.parentWidth = this.width;
		this.electricInfoRegion.parentHeight = this.height;
		this.infoRegions.add(this.electricInfoRegion);
		List<String> batterySlotDesc = new ArrayList<String>();
		batterySlotDesc.add(GCCoreUtil.translate("gui.batterySlot.desc.0"));
		batterySlotDesc.add(GCCoreUtil.translate("gui.batterySlot.desc.1"));
		this.infoRegions.add(new GuiElementInfoRegion((this.width - this.xSize) / 2 + 151, (this.height - this.ySize) / 2 + 82, 18, 18, batterySlotDesc, this.width, this.height, this));
		List<String> sunGenDesc = new ArrayList<String>();
		float sunVisible = Math.round(this.tileEntity.solarStrength / 9.0F * 1000) / 10.0F;
		sunGenDesc.add(this.tileEntity.solarStrength > 0 ? EnumChatFormatting.DARK_PURPLE + GCCoreUtil.translate("gui.status.starVisible.name") + ": " + sunVisible + "%" : EnumChatFormatting.DARK_RED + GCCoreUtil.translate("gui.status.star.blockedfully.name"));
		this.infoRegions.add(new GuiElementInfoRegion((this.width - this.xSize) / 2 + 47, (this.height - this.ySize) / 2 + 20, 18, 18, sunGenDesc, this.width, this.height, this));
		this.buttonList.add(this.buttonEnableSolar = new GuiButton(0, this.width / 2 - 36, this.height / 2 - 19, 72, 20, GCCoreUtil.translate("gui.button.enable.name")));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		int offsetY = 35;
		this.buttonEnableSolar.enabled = this.tileEntity.disableCooldown == 0;
		this.buttonEnableSolar.displayString = !this.tileEntity.getDisabled(0) ? GCCoreUtil.translate("gui.button.disable.name") : GCCoreUtil.translate("gui.button.enable.name");
		String displayString = this.tileEntity.getName();
		this.fontRendererObj.drawString(displayString, this.xSize / 2 - this.fontRendererObj.getStringWidth(displayString) / 2, 7, 4210752);
		displayString = GCCoreUtil.translate("gui.message.status.name") + ": " + this.getStatus();
		this.fontRendererObj.drawString(displayString, this.xSize / 2 - this.fontRendererObj.getStringWidth(displayString) / 2, 45 + 23 - 46 + offsetY, 4210752);
		displayString = GCCoreUtil.translate("gui.message.generating.name") + ": " + (this.tileEntity.generateWatts > 0 ? EnergyDisplayHelper.getEnergyDisplayS(this.tileEntity.generateWatts) + "/t" : GCCoreUtil.translate("gui.status.notGenerating.name"));
		this.fontRendererObj.drawString(displayString, this.xSize / 2 - this.fontRendererObj.getStringWidth(displayString) / 2, 34 + 23 - 46 + offsetY, 4210752);
		float boost = Math.round((this.tileEntity.getSolarBoost() - 1) * 1000) / 10.0F;
		displayString = GCCoreUtil.translate("gui.message.environment.name") + ": " + boost + "%";
		this.fontRendererObj.drawString(displayString, this.xSize / 2 - this.fontRendererObj.getStringWidth(displayString) / 2, 56 + 23 - 46 + offsetY, 4210752);
		this.fontRendererObj.drawString(GCCoreUtil.translate("container.inventory"), 8, this.ySize - 94, 4210752);
	}

	private String getStatus()
	{
		if (this.tileEntity.getDisabled(0))
		{
			return EnumChatFormatting.GOLD + GCCoreUtil.translate("gui.status.disabled.name");
		}
		if (!this.tileEntity.getWorld().isDaytime())
		{
			return EnumChatFormatting.DARK_RED + GCCoreUtil.translate("gui.status.star.blockedfully.name");
		}
		if (this.tileEntity.getWorld().isRaining() || this.tileEntity.getWorld().isThundering())
		{
			return EnumChatFormatting.DARK_RED + GCCoreUtil.translate("gui.status.raining.name");
		}
		if (this.tileEntity.solarStrength == 0)
		{
			return EnumChatFormatting.DARK_RED + GCCoreUtil.translate("gui.status.star.blockedfully.name");
		}
		if (this.tileEntity.solarStrength < 9)
		{
			return EnumChatFormatting.DARK_RED + GCCoreUtil.translate("gui.status.star.blockedpartial.name");
		}
		if (this.tileEntity.generateWatts > 0)
		{
			return EnumChatFormatting.DARK_GREEN + GCCoreUtil.translate("gui.status.collectingenergy.name");
		}
		return EnumChatFormatting.GOLD + GCCoreUtil.translate("gui.status.unknown.name");
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(this.solarGuiTexture);
		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);

		List<String> electricityDesc = new ArrayList<String>();
		EnergyDisplayHelper.getEnergyDisplayTooltip(this.tileEntity.getEnergyStoredGC(), this.tileEntity.getMaxEnergyStoredGC(), electricityDesc);
		this.electricInfoRegion.tooltipStrings = electricityDesc;

		if (this.tileEntity.getEnergyStoredGC() > 0)
		{
			this.drawTexturedModalRect(var5 + 83, var6 + 24, 176, 0, 11, 10);
		}
		if (this.tileEntity.solarStrength > 0)
		{
			this.drawTexturedModalRect(var5 + 48, var6 + 21, 176, 10, 16, 16);
		}
		this.drawTexturedModalRect(var5 + 97, var6 + 25, 187, 0, Math.min(this.tileEntity.getScaledElecticalLevel(54), 54), 7);
	}
}