package net.lunatic.client.management.hud;

public interface IRendererConfig {
	void save(ScreenPosition paramScreenPosition);
  
	ScreenPosition load();
}
