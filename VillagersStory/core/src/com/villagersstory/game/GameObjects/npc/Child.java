package com.villagersstory.game.GameObjects.npc;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.villagersstory.game.GameClock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Child extends NPC {
    public Rectangle hitbox = new Rectangle();

    Random rand = new Random();
    String[] randomImage = {"child1.png", "child2.png", "child3.png", "child4.png"};

    GameClock clock = GameClock.getInstance();
    double speed = 2;
    double oriSpeed = 2;
    int startTick = 0;
    int endTick=startTick+10;
    public float wait;
    public float initWait;

    TextureRegion region;
    int textureIndex=0;

    final List<TextureRegion> walkRightTextures=new ArrayList<>();
    final List<TextureRegion> walkLeftTextures=new ArrayList<>();
    final List<TextureRegion> walkUpTextures=new ArrayList<>();
    final List<TextureRegion> walkDownTextures=new ArrayList<>();
    ShapeRenderer shapeRenderer;
    public Child() {
//        image = new Texture(Gdx.files.internal("Male.png"));
        initWait=2;//actual speed control
        wait=initWait;

        region = new TextureRegion(new Texture(Gdx.files.internal("npc/"+randomImage[rand.nextInt(4)])));
        int frameWidth = region.getRegionWidth() / 3; //3x4
        int frameHeight = region.getRegionHeight() / 4;
        imgWidth = frameWidth/2; //render size
        imgHeight = frameHeight/2;

        walkDownTextures.add(new TextureRegion(region, 0 * frameWidth, 0 * frameHeight, frameWidth, frameHeight));
        walkDownTextures.add(new TextureRegion(region, 1 * frameWidth, 0 * frameHeight, frameWidth, frameHeight));
        walkDownTextures.add(new TextureRegion(region, 2 * frameWidth, 0 * frameHeight, frameWidth, frameHeight));

        walkLeftTextures.add(new TextureRegion(region, 0 * frameWidth, 1 * frameHeight, frameWidth, frameHeight));
        walkLeftTextures.add(new TextureRegion(region, 1 * frameWidth, 1 * frameHeight, frameWidth, frameHeight));
        walkLeftTextures.add(new TextureRegion(region, 2 * frameWidth, 1 * frameHeight, frameWidth, frameHeight));

        walkRightTextures.add(new TextureRegion(region, 0 * frameWidth, 2 * frameHeight, frameWidth, frameHeight));
        walkRightTextures.add(new TextureRegion(region, 1 * frameWidth, 2 * frameHeight, frameWidth, frameHeight));
        walkRightTextures.add(new TextureRegion(region, 2 * frameWidth, 2 * frameHeight, frameWidth, frameHeight));

        walkUpTextures.add(new TextureRegion(region, 0 * frameWidth, 3 * frameHeight, frameWidth, frameHeight));
        walkUpTextures.add(new TextureRegion(region, 1 * frameWidth, 3 * frameHeight, frameWidth, frameHeight));
        walkUpTextures.add(new TextureRegion(region, 2 * frameWidth, 3 * frameHeight, frameWidth, frameHeight));

        img = walkDownTextures.get(1);



    }
    @Override
    protected void walk(){

        if(endTick>=clock.tick) {
            switch(direction) {
//                Gdx.graphics.getDeltaTime()
                case(0): //right
                    if(wait==0) {
                        loadTexture(walkRightTextures);
                        locationX += speed;
                        wait=initWait;
                    }else if(wait>0) {
                        wait-=1;
                    }
                    break;
                case(1): //left
                    if(wait==0) {
                        loadTexture(walkLeftTextures);
                        locationX -= speed;
                        wait=initWait;
                    }else if(wait>0) {
                        wait-=1;
                    }
                    break;
                case(2): //up
                    if(wait==0) {
                        loadTexture(walkUpTextures);
                        locationY += speed;
                        wait=initWait;
                    }else if(wait>0) {
                        wait-=1;
                    }
                    break;
                case(3): //down
                    if(wait==0) {
                        loadTexture(walkDownTextures);
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
            endTick = startTick + 10;

            direction = rand.nextInt(4);
        }


    }

    @Override
    public void setSpeed(double multiplier) {
        speed = oriSpeed * multiplier;
    }

    public void loadTexture(List<TextureRegion> textures) {
        //List <Texture> textures=walkRightTextures;
        if(textureIndex < textures.size()-1) {
            textureIndex+=1;
        }
        else
            textureIndex=0;
        img=textures.get(textureIndex);
    }
}
