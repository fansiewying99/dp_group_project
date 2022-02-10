package com.villagersstory.game.GameObjects.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.villagersstory.game.VillagerStory;
import com.villagersstory.game.GameObjects.GameObject;

public abstract class Animal {
	protected MoveBehaviour moveBehaviour;
	protected Random rand = new Random();

    protected int width;
    protected int height;
    protected int speed;
    protected boolean isNoBound=false;
    protected int direction = rand.nextInt(4);
    
    final List<Texture> moveRightTextures=new ArrayList<>();
   	final List<Texture> moveLeftTextures=new ArrayList<>();
   	final List<Texture> moveUpTextures=new ArrayList<>();
   	final List<Texture> moveDownTextures=new ArrayList<>();
   	
   	final List<Texture> standRightTextures=new ArrayList<>();
   	final List<Texture> standLeftTextures=new ArrayList<>();
   	final List<Texture> standUpTextures=new ArrayList<>();
   	final List<Texture> standDownTextures=new ArrayList<>();
    
	public Animal() {
		
	}
	
	public void performMove() {
		moveBehaviour.move();
	}

	public void setMoveBehaviour(VillagerStory game, String movement) {
		int currentLocationX=0;
		int currentLocationY=0;
		if(moveBehaviour==null) {
			currentLocationX=rand.nextInt(1280);
			currentLocationY=(rand.nextInt(540));
		}else {
			currentLocationX=moveBehaviour.getLocationX();
			currentLocationY=moveBehaviour.getLocationY();
		}

		if(movement=="walk") {
			moveBehaviour=new Walk(game, moveRightTextures, moveLeftTextures, moveUpTextures, moveDownTextures, width, height, speed);
		}else if(movement=="run") {
			moveBehaviour=new Run(game, moveRightTextures, moveLeftTextures, moveUpTextures, moveDownTextures, width, height, speed);
		}else if(movement=="stand") {
			moveBehaviour=new Stand(game, standRightTextures, standLeftTextures, standUpTextures, standDownTextures, width, height);
		}

		moveBehaviour.setLocationX(currentLocationX);
		moveBehaviour.setLocationY(currentLocationY);
	}
	public void setNoBound(boolean isNoBound) {
		this.isNoBound=isNoBound;
	}
	public void setLocationX(int x) {
		moveBehaviour.setLocationX(x);
	}
	public void setLocationY(int y) {
		moveBehaviour.setLocationY(y);
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getCurrentMoveBehaviour() {
		return moveBehaviour.getCurrentMoveBehaviour();
	}
}
