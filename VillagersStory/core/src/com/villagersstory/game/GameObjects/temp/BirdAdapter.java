package com.villagersstory.game.GameObjects.temp;

import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameObjects.npc.NPC;

public class BirdAdapter extends NPC implements Animal{
	private final Bird bird;
	
	public BirdAdapter(Bird bird)
    {
        this.bird = bird;
    }


	
	@Override
	public int getLocationX() {
		// TODO Auto-generated method stub
		return bird.locationX;
	}
	@Override
	public int getLocationY() {
		// TODO Auto-generated method stub
		return bird.locationY;
	}
	@Override
	public void setLocationX(int x) {
		// TODO Auto-generated method stub
		bird.locationX=x;
	}
	@Override
	public void setLocationY(int y) {
		// TODO Auto-generated method stub
		bird.locationY=y;
	}
	@Override
	public Texture getImage() {
		// TODO Auto-generated method stub
		return bird.image;
	}


	//@Override
    public void fly(){
    	bird.fly();
    }


	@Override
	public String animalName() {
		// TODO Auto-generated method stub
		return bird.animalName();
	}


	@Override
	protected void walk() {

	}
	@Override
	public void setSpeed(double multiplier) {
		bird.setSpeed(multiplier);
	}
}
