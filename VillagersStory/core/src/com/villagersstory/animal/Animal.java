package com.villagersstory.animal;

import com.badlogic.gdx.graphics.Texture;

public interface Animal {
	/*public void makeSound() {
		System.out.println("make animal sound");
	}*/
	public void makeSound();
	public void walk();
	public Texture getAnimal();
	public void setWalkDirection(String direction);
	public void stand();
	public void setStandDirection(String direction);

}
