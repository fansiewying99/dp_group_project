package com.villagersstory.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class House extends GameObject{
    String imgFile = "house/house1.png";
    public House() {
        image = new Texture(Gdx.files.internal(imgFile));
    }
}
