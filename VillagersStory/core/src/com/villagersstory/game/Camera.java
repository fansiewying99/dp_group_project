package com.villagersstory.game;

public class Camera {
    Camera camera = new Camera();
    int width, height;
    private Camera(){
        width = 1280;
        height = 720;
    }
    public Camera getInstance(){
        return camera;
    }
    public void input(){

    }
    public void setResolution(int res){
        switch(res){
            case 0:
                width = 640;
                height = 480;
                break;
            case 1:
                width = 1280;
                height = 720;
                break;
            case 2:
                width = 1366;
                height = 768;
                break;
            case 3:
                width = 1600;
                height = 900;
                break;
            case 4:
                width = 1920;
                height = 1080;
                break;
        }
    }
}
