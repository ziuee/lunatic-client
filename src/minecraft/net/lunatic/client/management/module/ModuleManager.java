package net.lunatic.client.management.module;

import java.util.ArrayList;

public class ModuleManager {

	public ArrayList<Module> modules = new ArrayList<Module>();
	
	public ModuleManager() {
		
	}
	
	public ArrayList<Module> getModules() {
		return modules;
	}
	
	public Module getModule(String name) {
		return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}
	public ArrayList<Module> getModulesInCategory(Category categoryIn){
		ArrayList<Module> mods = new ArrayList<Module>();
		for(Module m : modules) {
			if(m.getCategory() == categoryIn)
				mods.add(m);
		}
		return mods;
	}
}
