package com.villagersstory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Timer;
import java.util.TimerTask;

public class GameScreen implements Screen {
    final VillagerStory game;
    Texture bgImage;
    Rectangle bg;
    OrthographicCamera camera;
    Vector3 cameraPos;
    public int day,hour,min;
    GameClock clock;

    public GameScreen(final VillagerStory game) {
        this.game = game;

        bgImage = new Texture(Gdx.files.internal("background ex.png"));

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 360);
        cameraPos = new Vector3();

        // create a Rectangle to logically represent the bucket
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
        // clear the screen with a dark blue color. The
        // arguments to clear are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        ScreenUtils.clear(0, 0, 0.2f, 1);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the bucket and
        // all drops
        game.batch.begin();

        game.batch.draw(bgImage, bg.x, bg.y, bg.width, bg.height);

        game.font.draw(game.batch, "Time: ", 0, 700);
        game.font.draw(game.batch, "Day: "+day, 0, 690);
        game.font.draw(game.batch, "Hour: "+hour, 0, 680);
        game.font.draw(game.batch, "Min: "+min, 0, 670);
        game.batch.end();

        day = clock.day;
        hour = clock.hour;
        min = clock.min;
        camera.position.lerp(cameraPos,0.1f);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            cameraPos.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            cameraPos.x += 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            cameraPos.y -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            cameraPos.y += 200 * Gdx.graphics.getDeltaTime();

        // process user input
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            cameraPos.x = touchPos.x;
            cameraPos.y = touchPos.y;
        }
        // make sure the bucket stays within the screen bounds
        /**
         * camera formula:
         * if (cameraPos.x < 0 + camWidth/2)
         *  cameraPos.x = 0 + camWidth/2;
         * if (cameraPos.x < max - camWidth/2)
         *  cameraPos.x = max - camWidth/2;
         */
        if (cameraPos.x < 0 + 320)
            cameraPos.x = 0 + 320;
        if (cameraPos.x > 1280-320)
            cameraPos.x = 1280-320;
        if (cameraPos.y < 0 + 180)
            cameraPos.y = 0 + 180;
        if (cameraPos.y > 720 - 180)
            cameraPos.y = 720 - 180;
    }

    @Override
    public void resize(int width, int height) {
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

