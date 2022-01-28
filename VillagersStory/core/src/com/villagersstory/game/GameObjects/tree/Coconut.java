package com.villagersstory.game.GameObjects.tree;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameObjects.GameObject;

import java.util.Random;

public class Coconut extends GameObject implements Fruit{
    Random rand = new Random();
    Texture image = new Texture(Gdx.files.internal("tree/coconut.png"));

    public Coconut(int treeX, int treeY){
        width = 16;
        height = 16;
//        locationX = (treeX / 2) - rand.nextInt((treeX / 4) - width);
//        locationY = (treeY / 2) - rand.nextInt((treeY / 2) - height);
        locationX = treeX + (128 / 4) + rand.nextInt((128 / 2) );
        locationY = treeY + (128 / 2) + rand.nextInt((128 / 4));
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
}
