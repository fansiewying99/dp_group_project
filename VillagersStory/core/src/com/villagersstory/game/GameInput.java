package com.villagersstory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class GameInput {
    GameCamera camSettings = GameCamera.getInstance();
    public void receiveInput(Vector3 cameraPos, OrthographicCamera camera){
//        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.E))
//            camera.setToOrtho(false, 1280, 720);

        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.A))
            cameraPos.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D))
            cameraPos.x += 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.S))
            cameraPos.y -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.W))
            cameraPos.y += 200 * Gdx.graphics.getDeltaTime();

        // process user input
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            cameraPos.x = touchPos.x;
            cameraPos.y = touchPos.y;
        }
    }
}
