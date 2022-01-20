package com.villagersstory.game.GameObjects.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameClock;
import com.villagersstory.game.GameObjects.GameObject;
import com.villagersstory.game.GameObjects.NPC;

public class Bird extends NPC {
    ArrayList<Integer> movement = new ArrayList<>();
    GameClock clock = GameClock.getInstance();
    double speed = 5;

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
		Texture flyUp1=new Texture(Gdx.files.internal("dragon/dragon_up_fly_1.png"));
		Texture flyUp2=new Texture(Gdx.files.internal("dragon/dragon_up_fly_2.png"));
		Texture flyUp3=new Texture(Gdx.files.internal("dragon/dragon_up_fly_3.png"));
		Texture flyRight1=new Texture(Gdx.files.internal("dragon/dragon_right_fly_1.png"));
		Texture flyRight2=new Texture(Gdx.files.internal("dragon/dragon_right_fly_2.png"));
		Texture flyRight3=new Texture(Gdx.files.internal("dragon/dragon_right_fly_3.png"));
		Texture flyLeft1=new Texture(Gdx.files.internal("dragon/dragon_left_fly_1.png"));
		Texture flyLeft2=new Texture(Gdx.files.internal("dragon/dragon_left_fly_2.png"));
		Texture flyLeft3=new Texture(Gdx.files.internal("dragon/dragon_left_fly_3.png"));
		Texture flyDown1=new Texture(Gdx.files.internal("dragon/dragon_down_fly_1.png"));
		Texture flyDown2=new Texture(Gdx.files.internal("dragon/dragon_down_fly_2.png"));
		Texture flyDown3=new Texture(Gdx.files.internal("dragon/dragon_down_fly_3.png"));
		
		flyUpTextures.add(flyUp1);
		flyUpTextures.add(flyUp2);
		flyUpTextures.add(flyUp3);
		flyRightTextures.add(flyRight1);
		flyRightTextures.add(flyRight2);
		flyRightTextures.add(flyRight3);
		flyLeftTextures.add(flyLeft1);
		flyLeftTextures.add(flyLeft2);
		flyLeftTextures.add(flyLeft3);
		
		flyDownTextures.add(flyDown1);
		flyDownTextures.add(flyDown2);
		flyDownTextures.add(flyDown3);
		
		image=flyRight1;
		
		initWait=10;
		wait=initWait;
				
	}

	@Override
	protected void walk(){
		fly();
	}
	public void fly(){

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
