package com.villagersstory.game.GameObjects.sky;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.villagersstory.game.GameClock;
import com.villagersstory.game.GameObjects.GameObject;

import java.util.Random;

public class Sky {
    private Color colour;
    private GameObject objectOnSky = new GameObject();
    private Random rand = new Random();
    private GameClock clock = GameClock.getInstance();

    public static final Color sunny = new Color(39/255f, 204/255f, 245/255f, 204/255f); // light blue
    public static final Color rainy = new Color(22/255f,71/255f,163/255f,204/255f);//greyish blue
    public static final Color dark = new Color(0/255f,0/255f,0/255f,255/255f);//black
    public static final Color evening = new Color(253/255f,145/255f,12/255f,186/255f);//light orange

    public Sky(){
        colour = sunny;
        objectOnSky.image = new Texture(Gdx.files.internal("sky/sun_shiny.png"));
        objectOnSky.width = 50;
        objectOnSky.height = 50;
        objectOnSky.locationX = rand.nextInt(1280);
        objectOnSky.locationY = rand.nextInt(30)+660;
    }

    public void setColour(String weather){
        if (weather.toLowerCase().equals("sunny")){
            colour = sunny;
            objectOnSky.image = new Texture(Gdx.files.internal("sky/sun_shiny.png"));
            objectOnSky.width = 50;
            objectOnSky.height = 50;
            objectOnSky.locationX = rand.nextInt(1280);
            objectOnSky.locationY = rand.nextInt(30)+660;
        }
        else if (weather.toLowerCase().equals("rainy")){
            colour = rainy;
            int time = clock.tick;
            objectOnSky.image = new Texture(Gdx.files.internal("sky/rain_drops-0"+(time % 4 +1)+".png"));
            objectOnSky.width = 1280;
            objectOnSky.height = 720;
            objectOnSky.locationX = 0;
            objectOnSky.locationY = 0;
        }
        else if (weather.toLowerCase().equals("dark")){
            colour = dark;
            objectOnSky.image = new Texture(Gdx.files.internal("sky/M1011.png"));
            objectOnSky.width = 50;
            objectOnSky.height = 50;
            objectOnSky.locationX = rand.nextInt(1280);
            objectOnSky.locationY = rand.nextInt(30)+660;
        }
        else if (weather.toLowerCase().equals("evening")){
            colour = evening;
            objectOnSky.image = new Texture(Gdx.files.internal("sky/sun_shiny.png"));
            objectOnSky.width = 50;
            objectOnSky.height = 50;
            objectOnSky.locationX = rand.nextInt(1280);
            objectOnSky.locationY = 630;
        }

    }

    public Color getColour() {
        return colour;
    }

    public GameObject getObjectOnSky() {
        return objectOnSky;
    }
}