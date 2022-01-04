package com.villagersstory.road;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.VillagerStory;

public class StraightRoad implements Road{
	VillagerStory game;
	Texture road=new Texture(Gdx.files.internal("../core/assets/Dirt1.png"));
	int xunit;
	int yunit;
	int length;
	int width;
	String layout;

	
	public StraightRoad(VillagerStory game, String layout, int width, int length, int xunit, int yunit) {
		this.game=game;
		this.xunit=xunit;
		this.yunit=yunit;
		this.layout=layout;
		this.length=length;
		this.width=width;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		//System.out.println("create Straight road");
		int xtemp=xunit*40;
		int ytemp=yunit*40;
		if(layout.equals("horizontal")) {
			for(int i=1; i<=length; i++) {
				for(int j=1; j<=width;j++) {
					game.batch.draw(road, xtemp, ytemp, 40, 40);
					ytemp+=40;
				}
				ytemp=yunit*40;
				xtemp+=40;
			}
		}
		else if(layout.equals("vertical")) {
			for(int i=1; i<=length; i++) {
				for(int j=1; j<=width;j++) {
					game.batch.draw(road, xtemp, ytemp, 40, 40);
					xtemp+=40;
				}
				game.batch.draw(road, xtemp, ytemp, 40, 40);
				xtemp=xunit*40;
				ytemp+=40;
			}
		}
		else {
			System.out.println("layout invalid");
		}
	}

}
