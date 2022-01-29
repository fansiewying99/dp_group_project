package com.villagersstory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    final VillagerStory game;
    GameDisplay gameDisplay;
    GameClock gameClock;
    GameInput gameInput;
    GameCamera gameCamera;

    static OrthographicCamera camera;
    Vector3 cameraPos;

    GameCamera camSettings = GameCamera.getInstance();
    boolean camToggle = true;

    public GameScreen(final VillagerStory game) {
        this.game = game;
        gameDisplay = new GameDisplay(game);
        gameInput = new GameInput();

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 640, 360);
        camera.setToOrtho(false, 1280, 720);
        cameraPos = new Vector3();
        camSettings.setResolution(camera, true);
    }


    @Override
    public void render(float delta) {
        //update in real time camera, background, images, input
        ScreenUtils.clear(0, 0, 0.2f, 1);
        // tell the camera to update its matrices.
        camera.update();
        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);


        gameDisplay.render();//use GameDisplay class

//        game.batch.end();

        camera.position.lerp(cameraPos,0.1f);

        gameInput.receiveInput(cameraPos, camera); //go to input class

        camSettings.move(cameraPos, camera); //not used

        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.E)) {
            camToggle=camSettings.setResolution(camera, camToggle);
        }
//        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.F)) {
//            bgImage = ColorChange.genTexture("background ex.png");
//        }

    }

    @Override
    public void resize(int width, int height) { //zoom method
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
        gameDisplay.sound();
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
//        bgImage.dispose();
    }

}

