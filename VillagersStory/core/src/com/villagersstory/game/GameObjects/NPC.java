package com.villagersstory.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameClock;

import java.util.ArrayList;
import java.util.Random;

public class NPC extends GameObject{
    Random rand = new Random();

    ArrayList<Integer> movement = new ArrayList<>();

    ArrayList<Integer> path = new ArrayList<>();

    GameClock clock = GameClock.getInstance();
    double speed = 1;
    int direction = 0; //false = x

    int startTick = 0;
    int endTick=startTick+1;


    public NPC(String imgFile) {
        image = new Texture(Gdx.files.internal(imgFile));
    }
    public void move(){
        checkBounds();
        if(endTick>=clock.tick) {
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

    public float wait;
    public float initWait;

    public NPC(String imgFile) {
        image = new Texture(Gdx.files.internal(imgFile));
        initWait=5;//actual speed control
        wait=initWait;
    }
    public void move(){
        checkBounds();
        if(endTick>=clock.tick) { //tick only changes direction
            switch(direction) {
//                Gdx.graphics.getDeltaTime()
                case(0):
                    if(wait==0) {
                        locationX += speed;
                        wait=initWait;
                    }else if(wait>0) {
                        wait-=1;
                    }
                    break;
                case(1):
                    if(wait==0) {
                        locationX -= speed;
                        wait=initWait;
                    }else if(wait>0) {
                        wait-=1;
                    }
                    break;
                case(2):
                    if(wait==0) {
                        locationY += speed;
                        wait=initWait;
                    }else if(wait>0) {
                        wait-=1;
                    }
                    break;
                case(3):
                    if(wait==0) {
                        locationY -= speed;
                        wait=initWait;
                    }else if(wait>0) {
                        wait-=1;
                    }
                    break;
            }
        }
        else {
            startTick = clock.tick;
            endTick = startTick + 1;

            direction = rand.nextInt(4);
        }

    }
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
