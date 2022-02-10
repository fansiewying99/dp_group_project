package com.villagersstory.game.GameObjects.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameClock;
import com.villagersstory.game.VillagerStory;
import com.villagersstory.game.GameObjects.GameObject;

public class Walk extends GameObject implements MoveBehaviour{
	
	VillagerStory game;
	private List<Texture> moveRightTextures=new ArrayList<>();
	private List<Texture> moveLeftTextures=new ArrayList<>();
	private List<Texture> moveUpTextures=new ArrayList<>();
	private List<Texture> moveDownTextures=new ArrayList<>();
	private int width;
	private int height;
	private boolean isNoBound;
	Random rand = new Random();
	private int textureIndex;
	private final float initWait;
	private float wait;
	GameClock clock = GameClock.getInstance();
	private int startTick = 0;
	private int endTick=startTick+40;
	private double speed = 1;
	private int direction = rand.nextInt(4);
	
	public Walk(VillagerStory game, List<Texture> moveRightTextures, 
			List<Texture> moveLeftTextures, 
			List<Texture> moveUpTextures, 
			List<Texture> moveDownTextures,
			int width,
			int height,
			int speed) {
		this.game=game;
		this.moveRightTextures=moveRightTextures;
		this.moveLeftTextures=moveLeftTextures;
		this.moveUpTextures=moveUpTextures;
		this.moveDownTextures=moveDownTextures;
		this.width=width;
		this.height=height;
		this.speed=this.speed*speed;
		
		if(image==null)
			image=moveDownTextures.get(1);
		locationX=rand.nextInt(1280);
		locationY=rand.nextInt(540);
		textureIndex=0;
		
		initWait=20;
		wait=initWait;
		
	}
	
	private void checkBounds(){ //world bounds 1280x540
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
	public void move() {
		if(endTick>=clock.tick) {
			if(!this.isNoBound) {
				checkBounds();
			}
            switch(direction) {
                case(0): //right
                	if(wait<=0) {
	                	setImage(moveRightTextures);
	                    locationX += speed;
	                    wait=initWait;
                	}else if(wait>0) {
                		wait-=speed;
                	}
                    break;
                case(1): //left
                	if(wait<=0) {
                		setImage(moveLeftTextures);
	                    locationX -= speed;
	                    wait=initWait;
                	}else if(wait>0) {
                		wait-=speed;
                	}
                    break;
                case(2): //up
                	if(wait<=0) {
                		setImage(moveUpTextures);
	                    locationY += speed;
	                    wait=initWait;
		        	}else if(wait>0) {
		        		wait-=speed;
		        	}
                    break;
                case(3): //down
                	if(wait<=0) {
                		setImage(moveDownTextures);
	                    locationY -= speed;
	                    wait=initWait;
		        	}else if(wait>0) {
		        		wait-=speed;
		        	}
                    break;
            }
		}
        else {
			
            startTick = clock.tick;
            endTick = startTick + 1;

            direction = rand.nextInt(4);
        }
		game.batch.draw(getImage(), getLocationX(), getLocationY(), width, height);
	}

	private Texture getImage() {
		return super.image;
	}
	private void setImage(List <Texture> textures) {
		if(textureIndex < textures.size()-1) {
			textureIndex+=1;	
		}
		else
			textureIndex=0;
		image=textures.get(textureIndex);
	}
	@Override
	public void setLocationY(int y) {
		locationY=y;
	}
	@Override
	public void setLocationX(int x) {
		locationX=x;
	}
	@Override
	public int getLocationY() {
		return locationY;
	}
	@Override
	public int getLocationX() {
		return locationX;
	}
	@Override
	public List<Texture> getMoveRightTextures() {
		return moveRightTextures;
	}
	@Override
	public void setMoveRightTextures(List<Texture> moveRightTextures) {
		this.moveRightTextures = moveRightTextures;
	}
	@Override
	public List<Texture> getMoveLeftTextures() {
		return moveLeftTextures;
	}
	@Override
	public void setMoveLeftTextures(List<Texture> moveLeftTextures) {
		this.moveLeftTextures = moveLeftTextures;
	}
	@Override
	public List<Texture> getMoveUpTextures() {
		return moveUpTextures;
	}
	@Override
	public void setMoveUpTextures(List<Texture> moveUpTextures) {
		this.moveUpTextures = moveUpTextures;
	}
	@Override
	public List<Texture> getMoveDownTextures() {
		return moveDownTextures;
	}
	@Override
	public void setMoveDownTextures(List<Texture> moveDownTextures) {
		this.moveDownTextures = moveDownTextures;
	}
	@Override
	public String getCurrentMoveBehaviour() {
		return "walk";
	}

	@Override
	public void setNoBound(boolean isNoBound) {
		this.isNoBound=isNoBound;
	}
}
