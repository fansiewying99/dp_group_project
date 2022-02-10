package com.villagersstory.game.GameObjects.ground;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GroundGrid;
import com.villagersstory.game.VillagerStory;

public class PuddleGround extends GroundDecorator{
	Random rand = new Random();
	Texture [] puddles = {new Texture(Gdx.files.internal("ground/puddle1.png")),
			new Texture(Gdx.files.internal("ground/puddle2.png")),
			new Texture(Gdx.files.internal("ground/puddle3.png")),
			new Texture(Gdx.files.internal("ground/puddle4.png")),
			new Texture(Gdx.files.internal("ground/puddle5.png"))};
    Texture [][] puddlePosition;
	
	public PuddleGround(VillagerStory game, GroundGrid ground) {
		super(game, ground);
		puddlePosition=new Texture[height/tileSize][width/tileSize];
		for(int i=0; i<height/tileSize; i++){
            for(int j=0; j<width/tileSize; j++){
                //chance to spawn leaves
                int chance = rand.nextInt(50);
                if(chance == 0)//10% chance of spawning
                	puddlePosition[i][j] = puddles[rand.nextInt(puddles.length)];
            }
        }
	}
	@Override
	public void create() {
		//create puddle
		for(int i=0; i< height/tileSize; i++) {
		    for (int j = 0; j < width /tileSize; j++) {
		        game.batch.draw(grid[i][j], j*tileSize, i*tileSize, tileSize, tileSize);
		        
                if(puddlePosition[i][j] != null)
                	game.batch.draw(puddlePosition[i][j], j*tileSize, i*tileSize, tileSize, tileSize);
		    }
        }
	}
}
