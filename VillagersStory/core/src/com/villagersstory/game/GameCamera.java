package com.villagersstory.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class GameCamera {
    static GameCamera cam = new GameCamera();
    int width, height;
    int speed;
    private GameCamera(){
        width = 640;
        height = 360;
    }
    public static GameCamera getInstance(){
        return cam;
    }
    public void input(OrthographicCamera camera){

    }
    public void setResolution(OrthographicCamera camera){
        width = 1280;
        height = 720;
        camera.setToOrtho(false, width, height);
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void move(Vector3 cameraPos, OrthographicCamera camera){
        /**
         * camera formula:
         * if (cameraPos.x < 0 + camWidth/2)
         *  cameraPos.x = 0 + camWidth/2;
         * if (cameraPos.x < max - camWidth/2)
         *  cameraPos.x = max - camWidth/2;
         */
        if (cameraPos.x < 0 + width/2)
            cameraPos.x = 0 + width/2;
        if (cameraPos.x > 1280-width/2)
            cameraPos.x = 1280-width/2;
        if (cameraPos.y < 0 + height/2)
            cameraPos.y = 0 + height/2;
        if (cameraPos.y > 720 - height/2)
            cameraPos.y = 720 - height/2;
    }
}
