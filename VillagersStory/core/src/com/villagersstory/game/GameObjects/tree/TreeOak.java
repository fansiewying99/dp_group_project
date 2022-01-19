package com.villagersstory.game.GameObjects.tree;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameObjects.GameObject;

import java.util.ArrayList;

public class TreeOak extends GameObject implements Tree{
    String imgFile = "tree/tree_oak.png";
    public TreeOak() {
        image = new Texture(Gdx.files.internal(imgFile));
    }
    @Override
    public Texture getImage() {
        return image;
    }
    @Override
    public int getLocationX() {
        return locationX;
    }

    @Override
    public int getLocationY() {
        return locationY;
    }

    @Override
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    @Override
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
    @Override
    public void generate() {

    }

    @Override
    public void reactWind() {

    }

    @Override
    public ArrayList<Fruit> dropFruit() {
        return null;
    }
}
