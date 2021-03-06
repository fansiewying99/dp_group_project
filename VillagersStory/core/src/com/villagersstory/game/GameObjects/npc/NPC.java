package com.villagersstory.game.GameObjects.npc;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.villagersstory.game.GameObjects.GameObject;

import java.util.Random;

public abstract class NPC extends GameObject {
    public TextureRegion img;
    public int imgWidth;
    public int imgHeight;
    protected Random rand = new Random();
    protected int direction = rand.nextInt(4); //false = x

    protected void checkBounds(){ //world bounds 1280x540
        if(locationX<0)
            direction = 0;
        else if(locationX>1280)
            direction = 1;
        else if(locationY<0)
            direction = 2;
        else if(locationY>540)
            direction = 3;
    }
    //Template Method
    public void move(){
        checkBounds();
        walk();  // primitive method
    }
    abstract protected void walk();

    public abstract void setSpeed(double v);
}
