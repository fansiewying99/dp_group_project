package com.villagersstory.animal;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.villagersstory.game.VillagerStory;

public class Cat extends Actor implements Animal {
	Texture current=new Texture(Gdx.files.internal("../core/assets/cat_right_stand.png"));
	private float x;
	final VillagerStory game;
	private final float maxX;
	private boolean isMovingRight=true;
	private final float initTimer;
	private float timer;
	List<Texture> textures=new ArrayList<>();
	int textureIndex=0;
	
	public Cat(VillagerStory game) {
		this.game=game;
		Texture stand=new Texture(Gdx.files.internal("../core/assets/cat_right_stand.png"));
		Texture walk1=new Texture(Gdx.files.internal("../core/assets/cat_right_walk_1.png"));
		Texture walk2=new Texture(Gdx.files.internal("../core/assets/cat_right_walk_2.png"));
		
		//textures.add(stand);
		textures.add(walk1);
		textures.add(walk2);
		maxX=200;
		initTimer=10;
		timer=initTimer;
        //current = getAnimal();
        //x = 0.0f;
    }
	
	/*@Override
    public void act(float delta) {
        super.act(delta);
    }
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl20.glClearColor(0, 1, 0, 0);
        batch.draw(current, x, 200);
        x += 4.5f;
    }*/
	
	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("meow");
		/*FileHandle dirHandle;

		dirHandle = Gdx.files.internal("../core/assets");
		
		for (FileHandle entry: dirHandle.list()) {
			System.out.println(entry);
		}*/
		   
	}
	//Texture texture = new Texture(Gdx.files.internal("../core/assets/cat_right_stand.png"));
    //float actorX = 0, actorY = 0;
    /*public MyActor(){
        addListener(new InputListener(){//Receive events
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button){//Check your run and jump buttons
            //...
        }
    }*/
    /*@Override
    public void draw(Batch batch, float alpha){//Draw it
        batch.draw(texture,actorX,actorY);
    }
    @Override
    public void act(float delta){//Update it
    }*/
	
	@Override
	public void walk() { //walkRight
		// TODO Auto-generated method stub
		//System.out.println("meow");
		if (timer>0){
			game.batch.draw(current, x, 0, 40, 40);
			timer-=1;
			
		}
		else if (timer==0) {
			getAnimal();
			if(x<maxX && isMovingRight) {
				x += 5;
			}
			else if(x==0) {
				isMovingRight=true;
			}
			else if(x==maxX) {
				isMovingRight=false;
				x-=5;
			}
			else {
				x-=5;
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

	@Override
	public void setWalkDirection(String direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStandDirection(String direction) {
		// TODO Auto-generated method stub
		
	}
	
}
