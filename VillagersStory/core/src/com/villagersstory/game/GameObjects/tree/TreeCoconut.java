package com.villagersstory.game.GameObjects.tree;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.villagersstory.game.GameObjects.GameObject;

import java.util.ArrayList;
import java.util.Random;

public class TreeCoconut extends GameObject implements Tree{
    String imgFile = "tree/tree_coconut.png";
    Random rand = new Random();
    ArrayList<Fruit> fruits = new ArrayList<>();

    public TreeCoconut() {
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
        fruits.add(new Coconut(locationX, locationY));
    }

    @Override
    public void reactWind() {
    }

    @Override
    public ArrayList<Fruit> dropFruit() {
        return fruits;
    }
}
