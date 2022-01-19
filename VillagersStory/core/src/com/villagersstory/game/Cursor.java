package com.villagersstory.game;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Cursor {
    private static Cursor cursor = new Cursor();
    float x=0, y=0;
    int width = 10, height = 10;
    public Rectangle box = new Rectangle(x, y, width, height);
    ShapeRenderer shapeRenderer;
    private Cursor(){
        shapeRenderer = new ShapeRenderer();

    }
    public static Cursor getInstance(){
        return cursor;
    }
    public void updateLocation(float newX, float newY){
        x = newX;
        y = newY;
        box.setCenter(x, y);
        System.out.println(x +" "+ y);
    }
    void draw(OrthographicCamera camera){
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(x-width/2, y-height/2, width, height);
        shapeRenderer.end();
    }
}
