package com.villagersstory.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.villagersstory.game.VillagerStory;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Villager Story";
		config.width = 1280;
		config.height = 720;
		config.foregroundFPS = 60;

		new LwjglApplication(new VillagerStory(), config);
	}
}
