package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import gra.gra;

/**
 * Glowny obiekt LibGDX do uruchomienia gry na PC
 */
public class DesktopLauncher {
	/**
	 * Glowna metoda odpowiedzialna za konfiguracje podstawowych paramentrow LibGDX oraz programu
	 * @param arg parametry startowe
	 */
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(999);
		config.setTitle("Snake");
		config.setWindowIcon("logo.png");
		config.setWindowedMode(800, 600);
		config.setResizable(false);
		new Lwjgl3Application(new gra(), config);
	}
}
