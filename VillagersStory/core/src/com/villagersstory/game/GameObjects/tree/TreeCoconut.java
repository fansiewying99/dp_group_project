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


    public Texture combineTextures(Texture texture1, Texture texture2) {
        if(!texture1.getTextureData().isPrepared())
            texture1.getTextureData().prepare();
        Pixmap pixmap1 = texture1.getTextureData().consumePixmap();
        if(!texture2.getTextureData().isPrepared())
            texture2.getTextureData().prepare();
        Pixmap pixmap2 = texture2.getTextureData().consumePixmap();
//        pixmap1.drawPixmap(pixmap2, 0, 0);

        //randomized location of leaves
        int x = (pixmap1.getWidth() / 2) - rand.nextInt((pixmap1.getWidth() / 4) - pixmap2.getWidth());
        int y = (pixmap1.getHeight() / 2) - rand.nextInt((pixmap1.getHeight() / 2) - pixmap2.getHeight());
//        int x = 0;
//        int y = 0;

        pixmap1.drawPixmap(pixmap2, x, y);
        Texture textureResult = new Texture(pixmap1);

        pixmap1.dispose();//must dispose
        pixmap2.dispose();

//        textureResult.getTextureData().disposePixmap();
        return textureResult;
    }
}
