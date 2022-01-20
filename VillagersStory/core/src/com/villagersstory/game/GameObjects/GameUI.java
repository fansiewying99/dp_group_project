package com.villagersstory.game.GameObjects;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;

public class GameUI {
public class GameUI{
    Table table;
    private Skin skin;
    private TextButton button;
    private Stage stage;

    public void create() {
        //make a stage for your button to go on
        stage = new Stage();
        //load a skin(a collection of styles for objects)
        // skin is from gdx-skins (https://github.com/czyzby/gdx-skins)
        skin = new Skin(Gdx.files.internal("kenney-pixel/skin/skin.json"));

        table = new Table(skin);
        button = new TextButton("Button1", skin);
        table.add(button);
        //create your button


        //add it to your stage
        table.setPosition(30,500);
        stage.addActor(table);
//        stage.addActor(button);

        // add a listener to your buttons so it does something when clicked
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("I was clicked");
            }
        });

        // set the sgae as the input processor so it will respond to clicks etc
        Gdx.input.setInputProcessor(stage);

    }

    public void render() {
        // tell stage to do action and then draw itself
        stage.draw();
        stage.act();
    }
}