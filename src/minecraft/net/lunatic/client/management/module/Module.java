package net.lunatic.client.management.module;

import net.lunatic.client.Lunatic;
import net.minecraft.client.Minecraft;

public class Module {
	public static Minecraft mc = Minecraft.getMinecraft();
	public String name, displayName;
	protected boolean toggled;
	private Category category;
	private int key;
	
	public Module(String name, int key, Category category) {
		this.name = name;
		this.key = key;
		this.category = category;
	}
	
	public void onEnable() {
		Lunatic.INSTANCE.eventManager.register(this);
	}
	
	public void onDisable() {
		Lunatic.INSTANCE.eventManager.unregister(this);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public boolean isToggled() {
		return toggled;
	}
	
	public String getDisplayName() {
		return displayName == null ? name : displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	
	public void setToggled(boolean toggle) {
		this.toggle();
		//this.toggleLagBack();
		if (toggle) {
			this.onEnable();
			this.toggled = true;
		} else {
			this.onDisable();
			this.toggled = false;
		}
	}
}
