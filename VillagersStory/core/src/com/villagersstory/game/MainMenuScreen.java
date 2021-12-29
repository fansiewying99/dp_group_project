package com.villagersstory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.stbtt.TrueTypeFontFactory;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class MainMenuScreen implements Screen {

    final VillagerStory game;
    Texture bgImage;
    OrthographicCamera camera;
    Rectangle bg;

    public MainMenuScreen(final VillagerStory game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        bgImage = new Texture(Gdx.files.internal("title.png"));
        bg = new Rectangle();
        bg.width = 1280;
        bg.height = 720;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0/255f, 0/255f, 0/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(bgImage, bg.x, bg.y, bg.width, bg.height);
        game.font.draw(game.batch, "Welcome to Villager Story!!! ", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


    //...Rest of class omitted for succinctness.

}
