package com.villagersstory.game.GameObjects.house;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameObjects.GameObject;

public class House extends GameObject {
    String imgFile = "house/house1.png";
    public House() {
        image = new Texture(Gdx.files.internal(imgFile));
    }
}
