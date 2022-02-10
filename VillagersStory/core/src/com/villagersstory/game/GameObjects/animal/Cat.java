package com.villagersstory.game.GameObjects.animal;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.villagersstory.game.GameClock;
import com.villagersstory.game.VillagerStory;

public class Cat extends Animal{

	public Cat() {
		//super.game=game;
		//initialise textures
			Texture standRight=new Texture(Gdx.files.internal("cat/cat_right_stand.png"));
			Texture walkRight1=new Texture(Gdx.files.internal("cat/cat_right_walk_1.png"));
			Texture walkRight2=new Texture(Gdx.files.internal("cat/cat_right_walk_2.png"));
			Texture standLeft=new Texture(Gdx.files.internal("cat/cat_left_stand.png"));
			Texture walkLeft1=new Texture(Gdx.files.internal("cat/cat_left_walk_1.png"));
			Texture walkLeft2=new Texture(Gdx.files.internal("cat/cat_left_walk_2.png"));
			Texture standUp=new Texture(Gdx.files.internal("cat/cat_up_stand.png"));
			Texture walkUp1=new Texture(Gdx.files.internal("cat/cat_up_walk_1.png"));
			Texture walkUp2=new Texture(Gdx.files.internal("cat/cat_up_walk_2.png"));
			Texture standDown=new Texture(Gdx.files.internal("cat/cat_down_stand.png"));
			Texture walkDown1=new Texture(Gdx.files.internal("cat/cat_down_walk_1.png"));
			Texture walkDown2=new Texture(Gdx.files.internal("cat/cat_down_walk_2.png"));
				
			moveRightTextures.add(walkRight1);
			moveRightTextures.add(standRight);
			moveRightTextures.add(walkRight2);
			moveRightTextures.add(standRight);
			
			moveLeftTextures.add(walkLeft1);
			moveLeftTextures.add(standLeft);
			moveLeftTextures.add(walkLeft2);
			moveLeftTextures.add(standLeft);
			
			moveUpTextures.add(walkUp1);
			moveUpTextures.add(standUp);
			moveUpTextures.add(walkUp2);
			moveUpTextures.add(standUp);
			
			moveDownTextures.add(walkDown1);
			moveDownTextures.add(standDown);
			moveDownTextures.add(walkDown2);
			moveDownTextures.add(standDown);
			
			standDownTextures.add(standDown);
			standLeftTextures.add(standLeft);
			standUpTextures.add(standUp);
			standRightTextures.add(standRight);

			height=30;
			width=30;
			speed=2;
	}

	public void display() {
		System.out.println("its a cat");
	}
}
