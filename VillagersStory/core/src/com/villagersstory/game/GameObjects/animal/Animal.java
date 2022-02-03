package com.villagersstory.game.GameObjects.animal;

public abstract class Animal {
	MoveBehaviour movebehaviour;
	public Animal() {
		
	}
	public void display() {
		System.out.println("its moving");
	}
	public void performMove(MoveBehaviour mb) {
		this.movebehaviour=mb;
	}
}
