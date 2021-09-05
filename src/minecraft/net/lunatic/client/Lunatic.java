package net.lunatic.client;

import javax.swing.JOptionPane;

import org.lwjgl.opengl.Display;

import net.lunatic.client.management.discord.DiscordRP;
import net.lunatic.client.management.event.EventManager;
import net.lunatic.client.management.module.ModuleManager;

public class Lunatic {
	
	public static Lunatic INSTANCE = new Lunatic();
	
	public ModuleManager moduleManager = new ModuleManager();
	public EventManager eventManager = new EventManager();
	public DiscordRP discordRP = new DiscordRP();
	
	public String lunaticName = "Lunatic";
	public String version = "1.0.0";
	public String build = "1";
	
	public String lunaticUser;
	
	public void loadLunatic() {
		
		lunaticUser = JOptionPane.showInputDialog(null, "Input your name");
		
		moduleManager = new ModuleManager();
		eventManager = new EventManager();
		
		discordRP.start();
		
		Display.setTitle(lunaticName + " | Version: " + version + " | User: " + lunaticUser);
	}
	
	public void unloadLunatic() {
		discordRP.shutdown();
	}

}
