package com.villagersstory.game.GameObjects.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameClock;
import com.villagersstory.game.GameObjects.GameObject;

public class Bird extends GameObject{
	Random rand = new Random();
    ArrayList<Integer> movement = new ArrayList<>();
    GameClock clock = GameClock.getInstance();
    double speed = 5;
    int direction = 0; //false = x

    int startTick = 0;
    int endTick=startTick+1;
    
    private final float initWait;
	private float wait;
    
    int textureIndex=0;
    
	 List<Texture> flyRightTextures=new ArrayList<>();
	 List<Texture> flyLeftTextures=new ArrayList<>();
	final List<Texture> flyUpTextures=new ArrayList<>();
	 List<Texture> flyDownTextures=new ArrayList<>();
	//final Texture standRight;
	//final Texture standLeft;
	//final Texture standUp;
	//final Texture standDown;
	
	public Bird() {
		Texture flyRight1=new Texture(Gdx.files.internal("../core/assets/dragon_up_fly_1.png"));
		Texture flyRight2=new Texture(Gdx.files.internal("../core/assets/dragon_up_fly_2.png"));
		Texture flyRight3=new Texture(Gdx.files.internal("../core/assets/dragon_up_fly_3.png"));
		
		flyUpTextures.add(flyRight1);
		flyUpTextures.add(flyRight2);
		flyUpTextures.add(flyRight3);
		flyRightTextures=flyUpTextures;
		flyLeftTextures= flyUpTextures;
		flyDownTextures=flyUpTextures;
		
		image=flyRight1;
		
		initWait=10;
		wait=initWait;
				
	}
	
	public void checkBounds(){ //world bounds 1280x540
        if(locationX<0)
            direction = 0;
        else if(locationX>1280)
            direction = 1;
        else if(locationY<0)
            direction = 2;
        else if(locationY>540)
            direction = 3;
    }
	
	public void fly(){
        checkBounds();
        if(endTick>=clock.tick) {
            switch(direction) {
//                Gdx.graphics.getDeltaTime()
                case(0): //right
                	if(wait==0) {
                		getAnimal(flyRightTextures);
                        locationX += speed;
	                    wait=initWait;
                	}else if(wait>0) {
                		wait-=1;
                	}
                    break;
                case(1): //left
                	if(wait==0) {
	                	getAnimal(flyLeftTextures);
	                    locationX -= speed;
	                    wait=initWait;
		        	}else if(wait>0) {
		        		wait-=1;
		        	}
                    break;
                case(2): //up
                	if(wait==0) {
	                	getAnimal(flyUpTextures);
	                    locationY += speed;
	                    wait=initWait;
		        	}else if(wait>0) {
		        		wait-=1;
		        	}
                    break;
                case(3): //down
                	if(wait==0) {
	                	getAnimal(flyDownTextures);
	                    locationY -= speed;
	                    wait=initWait;
		        	}else if(wait>0) {
		        		wait-=1;
		        	}
                    break;
            }
        }
        else {
            startTick = clock.tick;
            endTick = startTick + 1;

            direction = rand.nextInt(4);
        }
    }
	
	public Texture getAnimal(List <Texture> textures) {
		//List <Texture> textures=walkRightTextures;
		if(textureIndex < textures.size()-1) {
			textureIndex+=1;	
		}
		
		else
			textureIndex=0;
		image=textures.get(textureIndex);
		
		return image;
	}
	
	String animalName() {
		return "Bird";
	}
}
