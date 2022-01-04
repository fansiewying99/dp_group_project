package com.villagersstory.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameClock;

import java.util.ArrayList;
import java.util.Random;

public class NPC extends GameObject{
    Random rand = new Random();
    ArrayList<Integer> movement = new ArrayList<>();
    GameClock clock = GameClock.getInstance();
    double speed = 1;
    int direction = 0; //false = x

    int startTick = 0;
    int endTick=startTick+1;

    public NPC(String imgFile) {
        image = new Texture(Gdx.files.internal(imgFile));
    }
    public String move(){
        checkBounds();
        while(endTick>=clock.tick) {
            switch(direction) {
//                Gdx.graphics.getDeltaTime()
                case(0):
                    locationX += speed;
                    break;
                case(1):
                    locationX -= speed;
                    break;
                case(2):
                    locationY += speed;
                    break;
                case(3):
                    locationY -= speed;
                    break;
            }
            System.out.println(startTick+" "+endTick);
            return null;
        }
        startTick = clock.tick;
        endTick = startTick + 1;

        direction = rand.nextInt(4);
        return null;
    }
    public void checkBounds(){
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
