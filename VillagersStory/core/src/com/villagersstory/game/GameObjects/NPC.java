package com.villagersstory.game.GameObjects;

import java.util.Random;

public class NPC extends GameObject{

    protected Random rand = new Random();
    protected int direction = rand.nextInt(4); //false = x

    public void checkBounds(){ //world bounds 1280x540
        if(locationX<0)
            direction = 0;
        else if(locationX>1280)
            direction = 1;
        else if(locationY<0)
            direction = 2;
        else if(locationY>540)
            direction = 3;
    }
}
