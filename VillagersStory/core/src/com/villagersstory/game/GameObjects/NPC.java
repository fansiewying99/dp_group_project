package com.villagersstory.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class NPC extends GameObject{
    public NPC(String imgFile) {
        image = new Texture(Gdx.files.internal(imgFile));
    }
}
