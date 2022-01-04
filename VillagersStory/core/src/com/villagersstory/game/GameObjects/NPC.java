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
    int speed = 60;
    int direction = 0; //false = x

    int startTick = 0;
    int endTick=startTick+3;

    public NPC(String imgFile) {
        image = new Texture(Gdx.files.internal(imgFile));
    }
    public String move(){
        while(endTick>=clock.tick) {
            switch(direction) {
                case(0):
                    locationX += speed * Gdx.graphics.getDeltaTime();
                    break;
                case(1):
                    locationY += speed * Gdx.graphics.getDeltaTime();
                    break;
                case(2):
                    locationX -= speed * Gdx.graphics.getDeltaTime();
                    break;
                case(3):
                    locationY -= speed * Gdx.graphics.getDeltaTime();
                    break;
            }
            System.out.println(startTick+" "+endTick);
            return null;
        }
        startTick = clock.tick;
        endTick = startTick + 3;

        direction = rand.nextInt(4);
        return null;
    }
}
