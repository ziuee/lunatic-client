package net.lunatic.client.management.hud.mods.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.lunatic.client.management.hud.ScreenPosition;
import net.lunatic.client.management.hud.mods.ModDraggable;

public class ModTime extends ModDraggable {

	public int FPS = mc.debugFPS;
	
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("FPS:     ");
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		String pattern = "hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String time = simpleDateFormat.format(new Date());
		fr.drawStringWithShadow(time, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
	}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		FPS = mc.debugFPS;
		String pattern = "hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String time = simpleDateFormat.format(new Date());
		fr.drawStringWithShadow(time + "", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
	}
}
