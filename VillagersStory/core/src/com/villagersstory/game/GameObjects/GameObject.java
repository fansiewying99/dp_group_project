package com.villagersstory.game.GameObjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;



/**
 * add collision, animation, path(for dynamic objects)
 */

public class GameObject {
    public Texture image;
    public Sound sound;
    public int width;
    public int height;
    public int locationX;
    public int locationY;
    public void display(){
    	System.out.println("its game object");
    }
}
