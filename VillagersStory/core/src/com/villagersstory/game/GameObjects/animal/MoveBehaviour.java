package com.villagersstory.game.GameObjects.animal;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;

public interface MoveBehaviour  {
	public void move();
	public void setLocationY(int y);
	public void setLocationX(int x);
	public int getLocationY();
	public int getLocationX();
	public List<Texture> getMoveRightTextures();
	public void setMoveRightTextures(List<Texture> moveRightTextures);
	public List<Texture> getMoveLeftTextures();
	public void setMoveLeftTextures(List<Texture> moveLeftTextures);
	public List<Texture> getMoveUpTextures();
	public void setMoveUpTextures(List<Texture> moveUpTextures);
	public List<Texture> getMoveDownTextures();
	public void setMoveDownTextures(List<Texture> moveDownTextures);
	public String getCurrentMoveBehaviour();
	public void setNoBound(boolean isNoBound);
}
