package com.villagersstory.animal;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.VillagerStory;

public class Bird {
	final VillagerStory game;
	private final float initTimer;
	private final float maxY;
	private final float maxX;
	private float timer;
	Texture current=new Texture(Gdx.files.internal("../core/assets/dragon_back_fly_1.png"));
	private float y;
	private float x;
	List<Texture> textures=new ArrayList<>();
	int textureIndex=0;
	private String direction;
	
	public Bird(VillagerStory game, String direction) {
		this.game=game;
		this.direction=direction;
		
		maxY=720;
		maxX=1280;
		initTimer=10;
		timer=initTimer;
		y=0;
		x=0;
    }
	
	public void fly() {
		if(direction.equals("up")) {
			Texture fly1=new Texture(Gdx.files.internal("../core/assets/dragon_back_fly_1.png"));
			Texture fly2=new Texture(Gdx.files.internal("../core/assets/dragon_back_fly_2.png"));
			Texture fly3=new Texture(Gdx.files.internal("../core/assets/dragon_back_fly_3.png"));
			
			textures.add(fly1);
			textures.add(fly2);
			textures.add(fly3);
			flyUp();
		}
		else if(direction.equals("down")) {
			flyDown();
		}
		else if(direction.equals("left")) {
			flyUp();
		}
		else if(direction.equals("right")) {
			flyUp();
		}
	}
	
	public void setFlyDirection(String dir) {
		this.direction=dir;
	}
	
	public void flyUp() {
		// TODO Auto-generated method stub
		//System.out.println("meow");
		if (timer>0){
			game.batch.draw(current, 200, y, 200, 200);
			timer-=1;
		}
		else if (timer==0) {
			getAnimal();
			if(y<=maxY) {
				y += 10;
			}
			else {
				y=0;
			}
			timer=initTimer;
		}
	}
	
	public void flyDown() {
		// TODO Auto-generated method stub
		//System.out.println("meow");
		if (timer>0){
			game.batch.draw(current, 200, y, 200, 200);
			timer-=1;
		}
		else if (timer==0) {
			getAnimal();
			if(y>=0) {
				y -= 10;
			}
			else {
				y=maxY;
			}
			timer=initTimer;
		}
	}
	
	public Texture getAnimal() {
		if(textureIndex < textures.size()-1) {
			textureIndex+=1;	
		}
		
		else
			textureIndex=0;
		current=textures.get(textureIndex);
		
		return current;
	}

}
