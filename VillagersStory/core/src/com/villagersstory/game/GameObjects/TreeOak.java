package com.villagersstory.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TreeOak extends GameObject implements Tree{
    String imgFile = "tree_oak.png";
    public TreeOak() {
        image = new Texture(Gdx.files.internal(imgFile));
    }
}
