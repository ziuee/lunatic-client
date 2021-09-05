package net.lunatic.client.management.hud.mods;

import net.lunatic.client.Lunatic;
import net.lunatic.client.management.event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Mod {
	
	public boolean isEnabled = true;
	
	protected final Minecraft mc;
	protected final FontRenderer fr;
	protected final Lunatic client;
	
	public Mod() {
		this.mc = Minecraft.getMinecraft();
		this.fr = this.mc.fontRendererObj;
		this.client = Lunatic.INSTANCE;
		
		setEnabled(isEnabled);
	}
	
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
		
		if(isEnabled) {
			EventManager.register(this);
		}else {
			EventManager.unregister(this);
		}
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}

}
