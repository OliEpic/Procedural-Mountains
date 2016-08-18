package com.madpixelgames.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.madpixelgames.main.Main;

public class DesktopLauncher {
	
	public static void main (String[] args) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Mountain Range";
		config.width = 640;
		config.height = 480;
		config.resizable = false;
		
		new LwjglApplication(new Main(), config);
	
	}

}
