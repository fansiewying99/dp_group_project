package com.villagersstory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GroundGrid {
    int width=1280, height=600;
    int tileSize = 32;
    Texture[][] grid = new Texture[height/tileSize][width/tileSize]; //space by pixel
//    int[][] location = new
    //grass tile 32x32
    public void setWidthHeight(int width, int height){
        this.width = width;
        this.height = height;
        grid = new Texture[height][width];
    }
    public void checkSpace(int width, int height){

    }
    public void generateGrass(){
        for(int i=0; i<height/tileSize; i++){
            for(int j=0; j<width/tileSize; j++){
                System.out.println(i+" "+j);
                grid[i][j] = new Texture(Gdx.files.internal("ground/Grass 001.png"));
            }
        }
    }
}
