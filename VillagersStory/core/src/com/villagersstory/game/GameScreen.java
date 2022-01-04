package com.villagersstory.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.villagersstory.animal.Animal;
import com.villagersstory.animal.Cat;
import com.villagersstory.road.NormalRoadDecorator;
import com.villagersstory.road.Road;
import com.villagersstory.road.RoadDecorator;
import com.villagersstory.road.StraightRoad;
import com.villagersstory.animal.Bird;
import com.villagersstory.animal.BirdAdapter;

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
    
    Animal cat;
    BirdAdapter bird;
    List <Road> roads=new ArrayList<>();
    /*Road straightRoad1;
    Road straightRoad2;
    Road straightRoad3;
    Road straightRoad4;*/

    public GameScreen(final VillagerStory game) {
        this.game = game;
        bgImage = new Texture(Gdx.files.internal("background ex.png"));
        house = new Texture(Gdx.files.internal("house64.png"));

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 360);
        cameraPos = new Vector3();

        // create a Rectangle to logically represent the bucket
        bg = new Rectangle();

        // the bottom screen edge
        bg.width = 1280; // 32 units // 40 per unit
        bg.height = 720; // 18 units // 40 per unit

        clock = GameClock.getInstance();
        try {
            clock.startTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        cat=new Cat(game);
        bird=new BirdAdapter(new Bird(game, "up"));
        roads.add(new NormalRoadDecorator(new StraightRoad(game, "horizontal", 2, 17, 0, 1)));
        roads.add(new NormalRoadDecorator(new StraightRoad(game, "horizontal", 2, 17, 0, 7)));
        roads.add(new NormalRoadDecorator(new StraightRoad(game, "horizontal", 2, 17, 15, 5)));
        roads.add(new NormalRoadDecorator(new StraightRoad(game, "vertical", 1, 5, 5, 2)));
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

        Gdx.gl.glClearColor(0/255f, 0/255f, 0/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        game.batch.draw(bgImage, bg.x, bg.y, bg.width, bg.height);
        
        for(Road road: roads) {
        	road.create();
        }
        
        /*straightRoad1.create();
        straightRoad2.create();
        straightRoad3.create();
        straightRoad4.create();*/

        game.batch.draw(house, 0, 0, 64, 64);
        
        cat.walk();
        bird.fly();

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
        camSettings.move(cameraPos, camera);
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.E))
            camSettings.setResolution(camera);
        
        //cat.makeSound(); //will need to set the timeout, wait time and so on
        //bird.makeSound();
        //bird.fly();
        //straightRoad.create();
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

