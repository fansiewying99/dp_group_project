package com.villagersstory.game.GameObjects.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameClock;
import com.villagersstory.game.VillagerStory;
import com.villagersstory.game.GameObjects.GameObject;

public class Stand extends GameObject implements MoveBehaviour{
	VillagerStory game;
	protected List<Texture> moveRightTextures=new ArrayList<>();
	protected List<Texture> moveLeftTextures=new ArrayList<>();
	protected List<Texture> moveUpTextures=new ArrayList<>();
	protected List<Texture> moveDownTextures=new ArrayList<>();
	protected int width;
	protected int height;
	Random rand = new Random();
	int textureIndex;
	private final float initWait;
	private float wait;
	GameClock clock = GameClock.getInstance();
	int startTick = 0;
    int endTick=startTick+10;
    double speed = 1;
    int direction = rand.nextInt(4);
	
	public Stand(VillagerStory game, List<Texture> standRightTextures, 
			List<Texture> standLeftTextures, 
			List<Texture> standUpTextures, 
			List<Texture> standDownTextures,
			int width,
			int height) {
		this.game=game;
		this.moveRightTextures=standRightTextures;
		this.moveLeftTextures=standLeftTextures;
		this.moveUpTextures=standUpTextures;
		this.moveDownTextures=standDownTextures;
		this.width=width;
		this.height=height;

		if(image==null)
			image=standDownTextures.get(0);
		locationX=rand.nextInt(1280);
		locationY=rand.nextInt(540);
		textureIndex=0;
		
		initWait=20;
		wait=initWait;
	}

	@Override
	public void move() {
		if(endTick>=clock.tick) {
            switch(direction) {
                case(0): //right
                	if(wait==0) {
	                	setImage(moveRightTextures);
	                    wait=initWait;
                	}else if(wait>0) {
                		wait-=speed;
                	}
                    break;
                case(1): //left
                	if(wait==0) {
                		setImage(moveLeftTextures);
	                    wait=initWait;
                	}else if(wait>0) {
                		wait-=speed;
                	}
                    break;
                case(2): //up
                	if(wait==0) {
                		setImage(moveUpTextures);
	                    wait=initWait;
		        	}else if(wait>0) {
		        		wait-=speed;
		        	}
                    break;
                case(3): //down
                	if(wait==0) {
                		setImage(moveDownTextures);
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
	
	public Texture getImage() {
		return super.image;
	}
	public void setImage(List <Texture> textures) {
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
		// TODO Auto-generated method stub
		return "stand";
	}

	@Override
	public void setNoBound(boolean isNoBound) {
		// TODO Auto-generated method stub
		
	}
}
