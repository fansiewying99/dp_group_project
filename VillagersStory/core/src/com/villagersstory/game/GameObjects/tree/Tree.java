package com.villagersstory.game.GameObjects.tree;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public interface Tree {
    Texture getImage();
    int getLocationX();
    int getLocationY();
    void setLocationX(int locationX);
    void setLocationY(int locationY);
    void generate();
    void reactWind();
    ArrayList<Fruit>  dropFruit();
}
