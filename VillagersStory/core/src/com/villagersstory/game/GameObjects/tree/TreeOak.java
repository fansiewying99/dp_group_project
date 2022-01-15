package com.villagersstory.game.GameObjects.tree;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameObjects.GameObject;

public class TreeOak extends GameObject implements Tree{
    String imgFile = "tree/tree_oak.png";
    public TreeOak() {
        image = new Texture(Gdx.files.internal(imgFile));
    }
}
