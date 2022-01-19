package com.villagersstory.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class VillagerStory extends Game {

	SpriteBatch batch;
	BitmapFont font;

	// Singleton Pattern
	// Static instance
	private  static VillagerStory instance = null;

	// Static method to set the singleton instance
	private static boolean setInstance(VillagerStory newInstance) {
		if(instance != null)
			return false;

		instance = newInstance;
		return true;
	}

	// Static method to create instance of Singleton class
	public static VillagerStory getInstance() {
		if (instance == null)
			instance = new VillagerStory();

		return instance;
	}

	VillagerStory(){
		// Set the singleton instance on construction
		setInstance(this);
	}

	public void create() {
		batch = new SpriteBatch();
		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}