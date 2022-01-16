package com.villagersstory.game;

public class GroundGrid {
    int width=1280, height=720;
    int[][] grid = new int[height][width]; //space by pixel
    //grass tile 32x32
    public void setWidthHeight(int width, int height){
        this.width = width;
        this.height = height;
        grid = new int[height][width];
    }
    public void checkSpace(int width, int height){

    }
    public void generateGrass(){

    }
}
