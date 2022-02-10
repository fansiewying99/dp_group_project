package com.villagersstory.game.GameObjects.ground;

import com.villagersstory.game.GroundGrid;
import com.villagersstory.game.VillagerStory;

public class NormalGround extends GroundDecorator{
	GroundGrid ground;
	VillagerStory game;
	
	public NormalGround(VillagerStory game, GroundGrid ground) {
		super(game, ground);
	}
}
