package com.villagersstory.game.GameObjects.animal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.VillagerStory;

public class Dragon extends Animal {

	public Dragon() {
		Texture flyRight1=new Texture(Gdx.files.internal("dragon/dragon_right_fly_1.png"));
		Texture flyRight2=new Texture(Gdx.files.internal("dragon/dragon_right_fly_2.png"));
		Texture flyRight3=new Texture(Gdx.files.internal("dragon/dragon_right_fly_3.png"));
		Texture flyLeft1=new Texture(Gdx.files.internal("dragon/dragon_left_fly_1.png"));
		Texture flyLeft2=new Texture(Gdx.files.internal("dragon/dragon_left_fly_2.png"));
		Texture flyLeft3=new Texture(Gdx.files.internal("dragon/dragon_left_fly_3.png"));
		Texture flyUp1=new Texture(Gdx.files.internal("dragon/dragon_up_fly_1.png"));
		Texture flyUp2=new Texture(Gdx.files.internal("dragon/dragon_up_fly_2.png"));
		Texture flyUp3=new Texture(Gdx.files.internal("dragon/dragon_up_fly_3.png"));
		Texture flyDown1=new Texture(Gdx.files.internal("dragon/dragon_down_fly_1.png"));
		Texture flyDown2=new Texture(Gdx.files.internal("dragon/dragon_down_fly_2.png"));
		Texture flyDown3=new Texture(Gdx.files.internal("dragon/dragon_down_fly_3.png"));
			
		moveRightTextures.add(flyRight1);
		moveRightTextures.add(flyRight2);
		moveRightTextures.add(flyRight2);
		moveRightTextures.add(flyRight2);
		moveRightTextures.add(flyRight2);
		moveRightTextures.add(flyRight3);
		
		moveLeftTextures.add(flyLeft1);
		moveLeftTextures.add(flyLeft2);
		moveLeftTextures.add(flyLeft2);
		moveLeftTextures.add(flyLeft2);
		moveLeftTextures.add(flyLeft2);
		moveLeftTextures.add(flyLeft3);
		
		moveUpTextures.add(flyUp1);
		moveUpTextures.add(flyUp2);
		moveUpTextures.add(flyUp2);
		moveUpTextures.add(flyUp2);
		moveUpTextures.add(flyUp2);
		moveUpTextures.add(flyUp3);
		
		moveDownTextures.add(flyDown1);
		moveDownTextures.add(flyDown2);
		moveDownTextures.add(flyDown2);
		moveDownTextures.add(flyDown2);
		moveDownTextures.add(flyDown2);
		moveDownTextures.add(flyDown3);
		
		height=150;
		width=150;
		speed=3;
	}
	@Override
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
			moveBehaviour=new Walk(game, moveRightTextures, moveLeftTextures, moveUpTextures, 
					moveDownTextures, width, height, speed);
		}else if(movement=="run") {
			moveBehaviour=new Run(game, moveRightTextures, moveLeftTextures, moveUpTextures, 
					moveDownTextures, width, height, speed);
		}else if(movement=="stand") {
			if(moveBehaviour.getCurrentMoveBehaviour()=="walk")
				moveBehaviour=new Walk(game, moveRightTextures, moveLeftTextures, moveUpTextures, 
						moveDownTextures, width, height, speed);
			else if(moveBehaviour.getCurrentMoveBehaviour()=="run")
				moveBehaviour=new Run(game, moveRightTextures, moveLeftTextures, moveUpTextures, 
						moveDownTextures, width, height, speed);
		}
		moveBehaviour.setNoBound(true);
		moveBehaviour.setLocationX(currentLocationX);
		moveBehaviour.setLocationY(currentLocationY);
	}
	public void display() {
		System.out.println("its a dragon");
	}
}
