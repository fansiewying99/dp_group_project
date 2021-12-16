package com.villagersstory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    final VillagerStory game;
    Texture bgImage;
    Rectangle bg;
    OrthographicCamera camera;
    Vector3 cameraPos;
    public int day,hour,min;
    GameClock clock;

    Texture house;
    GameInput gameInput = new GameInput();
    GameCamera camSettings = GameCamera.getInstance();
    boolean camToggle = true;

    public GameScreen(final VillagerStory game) {
        this.game = game;
        bgImage = new Texture(Gdx.files.internal("background ex.png"));
        house = new Texture(Gdx.files.internal("house64.png"));

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 360);
        cameraPos = new Vector3();

        bg = new Rectangle();

        // the bottom screen edge
        bg.width = 1280;
        bg.height = 720;

        clock = GameClock.getInstance();
        try {
            clock.startTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0/255f, 0/255f, 0/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        game.batch.draw(bgImage, bg.x, bg.y, bg.width, bg.height);

        game.batch.draw(house, 0, 0, 64, 64);

        game.font.draw(game.batch, "Time: ", 0, 700);
        game.font.draw(game.batch, "Day: "+day, 0, 690);
        game.font.draw(game.batch, "Hour: "+hour, 0, 680);
        game.font.draw(game.batch, "Min: "+min, 0, 670);
        game.batch.end();

        day = clock.day;
        hour = clock.hour;
        min = clock.min;
        camera.position.lerp(cameraPos,0.1f);

        gameInput.receiveInput(cameraPos, camera); //go to input class
        camSettings.move(cameraPos, camera); //not used
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.E)) { //make E click delay
            camToggle=camSettings.setResolution(camera, camToggle);
        }
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.F)) {
            bgImage = ColorChange.genTexture("background ex.png");
        }

    }

    @Override
    public void resize(int width, int height) { //zoom method
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        bgImage.dispose();
    }

}

