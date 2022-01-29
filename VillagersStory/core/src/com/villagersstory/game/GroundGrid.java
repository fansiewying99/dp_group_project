package com.villagersstory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Random;

public class GroundGrid {
    private static GroundGrid groundGrid = new GroundGrid();
    Random rand = new Random();
    int width=1280, height=600;
    int tileSize = 32;
    Texture[][] grid = new Texture[height/tileSize][width/tileSize];
    String[] tileName = {"ground/LGrass1.png","ground/LGrass2.png","ground/LGrass3.png","ground/LGrass4.png","ground/LGrass5.png"};
    String[] grassLeaf = {"ground/leaf1.png","ground/leaf2.png","ground/leaf3.png","ground/leaf4.png","ground/leaf5.png","ground/leaf6.png","ground/leaf7.png"};
    ArrayList<Texture> leaf = new ArrayList<>();
    //    int[][] location = new
    //grass tile 32x32
    private GroundGrid(){

    }
    public static GroundGrid getInstance(){
        return groundGrid;
    }
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
                grid[i][j] = new Texture(Gdx.files.internal(tileName[rand.nextInt(tileName.length)]));
                //chance to spawn leaves
                int chance = rand.nextInt(10);
                if(chance == 0)//10% chance of spawning
                    grid[i][j] = combineTextures(grid[i][j], new Texture(Gdx.files.internal(grassLeaf[rand.nextInt(grassLeaf.length)])));
            }
        }
    }
    public void generateParticle(){
        for(int i=0; i<100; i++){
            leaf.add(new Texture(Gdx.files.internal(grassLeaf[rand.nextInt(grassLeaf.length)])));
        }
    }
    public Texture combineTextures(Texture texture1, Texture texture2) {
        texture1.getTextureData().prepare();
        Pixmap pixmap1 = texture1.getTextureData().consumePixmap();

        texture2.getTextureData().prepare();
        Pixmap pixmap2 = texture2.getTextureData().consumePixmap();
//        pixmap1.drawPixmap(pixmap2, 0, 0);

        //randomized location of leaves
        int x = rand.nextInt(pixmap1.getWidth()-pixmap2.getWidth());
        int y = rand.nextInt(pixmap1.getHeight()-pixmap2.getHeight());

        pixmap1.drawPixmap(pixmap2, x, y);
        Texture textureResult = new Texture(pixmap1);

        pixmap1.dispose();//must dispose
        pixmap2.dispose();

        return textureResult;
    }
}
