package com.villagersstory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class GameInput {
    /**
     * call object methods instead
     */
    GameCamera camSettings = GameCamera.getInstance();
    Cursor cursor = Cursor.getInstance();
    public void receiveInput(Vector3 cameraPos, OrthographicCamera camera){
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.A))
            cameraPos.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D))
            cameraPos.x += 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.S))
            cameraPos.y -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.W))
            cameraPos.y += 200 * Gdx.graphics.getDeltaTime();

        // move camera using mouse click
//        if (Gdx.input.isTouched()) {
//            Vector3 touchPos = new Vector3();
//            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//            camera.unproject(touchPos);
//            cameraPos.x = touchPos.x;
//            cameraPos.y = touchPos.y;
//        }

        if (Gdx.input.justTouched()) {
//            Vector3 touchPos = new Vector3();
//            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//            camera.unproject(touchPos);
            cursor.updateLocation(Gdx.input.getX(), 720 - Gdx.input.getY());
        }
    }
}
