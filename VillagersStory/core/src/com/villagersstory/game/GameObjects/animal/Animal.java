package com.villagersstory.game.GameObjects.animal;

import com.badlogic.gdx.graphics.Texture;

public interface Animal {
	Texture getImage();
	int getLocationX();
	int getLocationY();
	void setLocationX(int x);
	void setLocationY(int y);

	String animalName();
	void setSpeed(double multiplier);
}
