package com.villagersstory.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;

public class ColorChange {
    private static final Color dusk = new Color(255/255f, 177/255f, 0/255f, 64/255f);//orange

    public static Texture genTexture(String texturename) {
        Texture tex =new Texture(Gdx.files.internal(texturename));
        TextureData textureData = tex.getTextureData();
        textureData.prepare();
        Pixmap pixmap = tex.getTextureData().consumePixmap();
        for (int y = 0; y < pixmap.getHeight(); y++) {
            for (int x = 0; x < pixmap.getWidth(); x++) {
                pixmap.setColor(dusk);
                pixmap.fillRectangle(x, y, 1, 1);
                pixmap.setColor(new Color(0/255f, 0/255f, 0/255f, 127/255f));//black
                pixmap.fillRectangle(x, y, 1, 1);
            }
        }
        tex = new Texture(pixmap);
        textureData.disposePixmap();
        pixmap.dispose();

        return tex;
    }

}
