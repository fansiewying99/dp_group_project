package com.villagersstory.game.GameObjects;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.villagersstory.game.GameObjects.tree.TreeFactory;

import java.util.ArrayList;

public class GameUI{
    Table mainTable;
    Table table;
    private Skin skin;
    private TextButton button;
    private Stage stage;
    private ArrayList<TextButton> buttons;
    private ArrayList<TextButton> menu = new ArrayList<>();

    //items
    TreeFactory treeFactory = TreeFactory.getInstance();

    public void create() {
        //make a stage for your button to go on
        stage = new Stage();
        //load a skin(a collection of styles for objects)
        // skin is from gdx-skins (https://github.com/czyzby/gdx-skins)
//        skin = new Skin(Gdx.files.internal("kenney-pixel/skin/skin.json"));
        skin = new Skin(Gdx.files.internal("shade/skin/uiskin.json"));

        mainTable = new Table(skin);
        mainTable.setBackground(skin.getDrawable("dialogDim"));
//        mainTable.setSize(stage.getWidth(), stage.getHeight());
        mainTable.setSize(150, 500);
        mainTable.setPosition(0,100);
        mainTable.left();

        table = new Table(skin);
//        table.setPosition(0,600);
//        table.left();

        button = new TextButton("Add Coconut", skin);

        //create menu
        menu.add(new TextButton("Sky & Weather", skin));
        menu.add(new TextButton("Houses", skin));
        menu.add(new TextButton("Trees", skin));
        menu.add(new TextButton("Animals", skin));
        menu.add(new TextButton("NPC", skin));
        /**
         * Creation:
         * button -> factory(yo i want this) -> new object
         *
         * Edit:
         * Arraylist(object.name) -> button -> factory(specific object) -> object.editMethod()
         */
        //add menu to stage
        for(int i=0; i<menu.size(); i++) {
            table.add(menu.get(i)).fillX();
        }

        //add it to your stage
        table.row();
        table.add(button).fillX();
//        mainTable.add(table);
//        stage.addActor(table);
//        mainTable.add(table).expand().bottom().fillX().height(50);
        mainTable.add(table).expand().top().fillX();

        stage.addActor(mainTable);

        // add a listener to your buttons so it does something when clicked
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("I was clicked");
                treeFactory.generateCoconut();
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