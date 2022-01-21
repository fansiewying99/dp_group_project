package com.villagersstory.game.GameObjects.animal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameClock;
import com.villagersstory.game.VillagerStory;
import com.villagersstory.game.GameObjects.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Dog extends GameObject implements Animal{

    Random rand = new Random();
    ArrayList<Integer> movement = new ArrayList<>();
    GameClock clock = GameClock.getInstance();
    double speed = 1;
	double oriSpeed = 1;
    int direction = 0; //false = x

    int startTick = 0;
    int endTick=startTick+1;
    
    private final float initWait;
	private float wait;
    
    int textureIndex=0;
    
    
    final List<Texture> walkRightTextures=new ArrayList<>();
	final List<Texture> walkLeftTextures=new ArrayList<>();
	final List<Texture> walkUpTextures=new ArrayList<>();
	final List<Texture> walkDownTextures=new ArrayList<>();
	final Texture standRight;
	final Texture standLeft;
	final Texture standUp;
	final Texture standDown;

    public Dog() {
    	
        //image = new Texture(Gdx.files.internal(imgFile));
    	
    	
    	//initialise textures
		standRight=new Texture(Gdx.files.internal("dog/dog_right_stand.png"));
		Texture walkRight1=new Texture(Gdx.files.internal("dog/dog_right_walk_1.png"));
		Texture walkRight2=new Texture(Gdx.files.internal("dog/dog_right_walk_2.png"));
		standLeft=new Texture(Gdx.files.internal("dog/dog_left_stand.png"));
		Texture walkLeft1=new Texture(Gdx.files.internal("dog/dog_left_walk_1.png"));
		Texture walkLeft2=new Texture(Gdx.files.internal("dog/dog_left_walk_2.png"));
		standUp=new Texture(Gdx.files.internal("dog/dog_up_stand.png"));
		Texture walkUp1=new Texture(Gdx.files.internal("dog/dog_up_walk_1.png"));
		Texture walkUp2=new Texture(Gdx.files.internal("dog/dog_up_walk_2.png"));
		standDown=new Texture(Gdx.files.internal("dog/dog_down_stand.png"));
		Texture walkDown1=new Texture(Gdx.files.internal("dog/dog_down_walk_1.png"));
		Texture walkDown2=new Texture(Gdx.files.internal("dog/dog_down_walk_2.png"));
		
		walkRightTextures.add(walkRight1);
		walkRightTextures.add(walkRight2);
		walkLeftTextures.add(walkLeft1);
		walkLeftTextures.add(walkLeft2);
		walkUpTextures.add(walkUp1);
		walkUpTextures.add(walkUp2);
		walkDownTextures.add(walkDown1);
		walkDownTextures.add(walkDown2);
		
		image=standDown;
		
		initWait=10;
		wait=initWait;
    }
    
    @Override
    public void walk(){
        checkBounds();
        if(endTick>=clock.tick) {
            switch(direction) {
//                Gdx.graphics.getDeltaTime()
                case(0): //right
                	if(wait==0) {
	                	getAnimal(walkRightTextures);
	                    locationX += speed;
	                    wait=initWait;
                	}else if(wait>0) {
                		wait-=1;
                	}
                    break;
                case(1): //left
                	if(wait==0) {
	                	getAnimal(walkLeftTextures);
	                    locationX -= speed;
	                    wait=initWait;
                	}else if(wait>0) {
                		wait-=1;
                	}
                    break;
                case(2): //up
                	if(wait==0) {
	                	getAnimal(walkUpTextures);
	                    locationY += speed;
	                    wait=initWait;
		        	}else if(wait>0) {
		        		wait-=1;
		        	}
                    break;
                case(3): //down
                	if(wait==0) {
	                	getAnimal(walkDownTextures);
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
	@Override
	public int getLocationX() {
		// TODO Auto-generated method stub
		return locationX;
	}
	@Override
	public int getLocationY() {
		// TODO Auto-generated method stub
		return locationY;
	}
	@Override
	public void setLocationX(int x) {
		// TODO Auto-generated method stub
		locationX=x;
	}
	@Override
	public void setLocationY(int y) {
		// TODO Auto-generated method stub
		locationY=y;
	}
	@Override
	public Texture getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public String animalName() {
		// TODO Auto-generated method stub
		return "Cat";
	}

	@Override
	public void setSpeed(double multiplier) {
		speed = oriSpeed * multiplier;
	}
}
