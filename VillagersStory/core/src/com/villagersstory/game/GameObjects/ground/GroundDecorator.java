package com.villagersstory.game.GameObjects.ground;

import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GroundGrid;
import com.villagersstory.game.VillagerStory;

public abstract class GroundDecorator implements Ground {
	int width=1280, height=600;
    int tileSize = 32;
	protected GroundGrid ground;
	VillagerStory game;
	Texture[][] grid;
	public GroundDecorator(VillagerStory game, GroundGrid ground) {
		this.ground=ground;
		this.game=game;
		grid=ground.getGrid();
	}
	@Override
	public void create() {
		//create default
		for(int i=0; i< height/tileSize; i++) {
		    for (int j = 0; j < width /tileSize; j++) {
		        game.batch.draw(grid[i][j], j*tileSize, i*tileSize, tileSize, tileSize);
		    }
        }
	}
}
