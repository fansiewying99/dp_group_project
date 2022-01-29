package com.villagersstory.game.GameObjects.npc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.villagersstory.game.Cursor;
import com.villagersstory.game.GameClock;
import com.villagersstory.game.GameObjects.npc.NPC;

import java.util.ArrayList;
import java.util.List;

public class Human extends NPC {
    public TextureRegion img;
    public int imgWidth;
    public int imgHeight;
    public Rectangle hitbox = new Rectangle();
    Cursor cursor = Cursor.getInstance();



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
    public Human() {
//        image = new Texture(Gdx.files.internal("Male.png"));
        initWait=15;//actual speed control
        wait=initWait;

        region = new TextureRegion(new Texture(Gdx.files.internal("npc/Vi.png")));
        int frameWidth = region.getRegionWidth() / 12;
        imgWidth = frameWidth;
        imgHeight = region.getRegionHeight();

        walkUpTextures.add(new TextureRegion(region, 0 * frameWidth, 0, frameWidth, region.getRegionHeight()));
        walkUpTextures.add(new TextureRegion(region, 1 * frameWidth, 0, frameWidth, region.getRegionHeight()));
        walkUpTextures.add(new TextureRegion(region, 2 * frameWidth, 0, frameWidth, region.getRegionHeight()));

        walkRightTextures.add(new TextureRegion(region, 3 * frameWidth, 0, frameWidth, region.getRegionHeight()));
        walkRightTextures.add(new TextureRegion(region, 4 * frameWidth, 0, frameWidth, region.getRegionHeight()));
        walkRightTextures.add(new TextureRegion(region, 5 * frameWidth, 0, frameWidth, region.getRegionHeight()));

        walkDownTextures.add(new TextureRegion(region, 6 * frameWidth, 0, frameWidth, region.getRegionHeight()));
        walkDownTextures.add(new TextureRegion(region, 7 * frameWidth, 0, frameWidth, region.getRegionHeight()));
        walkDownTextures.add(new TextureRegion(region, 8 * frameWidth, 0, frameWidth, region.getRegionHeight()));

        walkLeftTextures.add(new TextureRegion(region, 9 * frameWidth, 0, frameWidth, region.getRegionHeight()));
        walkLeftTextures.add(new TextureRegion(region, 10 * frameWidth, 0, frameWidth, region.getRegionHeight()));
        walkLeftTextures.add(new TextureRegion(region, 11 * frameWidth, 0, frameWidth, region.getRegionHeight()));
        img = walkDownTextures.get(1);
        hitbox.setSize(imgWidth, imgHeight);
        shapeRenderer = new ShapeRenderer();

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
    public void draw(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(hitbox.x-width/2, hitbox.y-height/2, hitbox.width, hitbox.height);
        shapeRenderer.end();
    }
}
