package net.lunatic.client.management.gui.menus;

import net.lunatic.client.Lunatic;
import net.lunatic.client.management.gui.menus.utils.GuiMenuButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class LunaticMainMenu extends GuiScreen {
	
	private ResourceLocation background = new ResourceLocation("lunatic/menus/mainmenu/background/backgroundmountain.png");
	
	@Override
	public void initGui() {
		Lunatic.INSTANCE.discordRP.update("Playing Lunatic | 1.8.8", "");
		String strSSP = I18n.format("Singleplayer");
        String strSMP = I18n.format("Multiplayer");
        String strOptions = I18n.format("Options");
        String strQuit = I18n.format("Exit");
        String strAccounts = "Accounts";
        int initHeight = this.height / 2 - 50;
        int objHeight = 50;
        int objWidth = 50;
        int xMid = width / 2 - 55;
        buttonList.add(new GuiMenuButton(0, xMid - 60, initHeight, objWidth, objHeight, strSSP));
        buttonList.add(new GuiMenuButton(1, xMid - 0, initHeight, objWidth, objHeight, strSMP));
        buttonList.add(new GuiMenuButton(2, xMid + 60, initHeight, objWidth, objHeight, strOptions));
        buttonList.add(new GuiMenuButton(3, xMid - 35, initHeight + 75, objWidth, objHeight, strAccounts));
        buttonList.add(new GuiMenuButton(4, xMid + 35, initHeight + 75, objWidth, objHeight, strQuit));
	}
	
	private float currentX, targetX, currentY, targetY;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        int w = sr.getScaledWidth();
        int h = sr.getScaledHeight();
        GlStateManager.pushMatrix();
        float xDiff = ((mouseX - sr.getScaledWidth() / 2) - currentX) / sr.getScaleFactor();
        float yDiff = ((mouseY - sr.getScaledHeight() / 2) - currentY) / sr.getScaleFactor();
        mouseY += 2;
        float slide = 2;
        currentX += xDiff * 0.3F;
        currentY += yDiff * 0.3F;
        GlStateManager.translate(currentX / 100, currentY / 100, 0);
		mc.getTextureManager().bindTexture(background);
        drawScaledCustomSizeModalRect(-10, -10, 0, 0, w + 20, h + 20, w + 20, h + 20, w + 20, h + 20);
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.popMatrix();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		 if (button.id == 0) {
             mc.displayGuiScreen(new GuiSelectWorld(this));
         } else if (button.id == 1) {
             mc.displayGuiScreen(new GuiMultiplayer(this));
         } else if (button.id == 2) {
             mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
         } else if (button.id == 3) {
             //mc.displayGuiScreen(new GuiAltManager());
         } else if (button.id == 4) {
             mc.shutdown();
         }
	}
}
