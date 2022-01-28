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
    Table bgCanvas;
    Table table;
    private Skin skin;
    private TextButton button;
    private Stage stage;
    private ArrayList<TextButton> menu = new ArrayList<>();
    private ArrayList<TextButton> tempButtons = new ArrayList<>();

    private ArrayList<TextButton> npcButtons = new ArrayList<>();
    private ArrayList<TextButton> treeButtons = new ArrayList<>();
    private ArrayList<TextButton> skyButtons = new ArrayList<>();
    private ArrayList<TextButton> animalButtons = new ArrayList<>();
    private ArrayList<TextButton> houseButtons = new ArrayList<>();

    //items
    TreeFactory treeFactory = TreeFactory.getInstance();

    public void create() {
        //make a stage for your button to go on
        stage = new Stage();
        // skin is from gdx-skins (https://github.com/czyzby/gdx-skins)
        skin = new Skin(Gdx.files.internal("kenney-pixel/skin/skin.json"));
        bgCanvas = new Table(skin);
        bgCanvas.setBackground(skin.getDrawable("buttonUp"));
//        bgCanvas.setSize(stage.getWidth(), stage.getHeight());
        bgCanvas.setSize(150, 100);
        bgCanvas.setPosition(0,620);
        bgCanvas.left();

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
        for(int i=0; i<menu.size(); i++) {
            table.add(menu.get(i)).fillX();
        }
        table.row();
        //create buttons
        npcButtons.add(new TextButton("Add Adult", skin));
        npcButtons.add(new TextButton("Add Child", skin));

        //add to temporary location
        tempButtons = npcButtons;
        for(int i=0; i<tempButtons.size(); i++) {
            table.add(tempButtons.get(i));
        }



        //add it to your stage
//        table.row();
//        table.add(button).fillX();
//        bgCanvas.add(table);
//        stage.addActor(table);
//        bgCanvas.add(table).expand().bottom().fillX().height(50);
        bgCanvas.add(table).expand().top().fillX();
        stage.addActor(bgCanvas);

        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            System.out.println("I was clicked");
            treeFactory.generateCoconut();
            }
        });
        for(int i=0; i<menu.size(); i++) {
            final int finalI = i;
            menu.get(i).addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    System.out.println("I was clicked");
                    String str = menu.get(finalI).getText().toString();
                    if(str.equals("Houses")){
                        System.out.println("sup");
                    }

                }
            });
        }

        Gdx.input.setInputProcessor(stage);
    }

    public void render() {
        // tell stage to do action and then draw itself
        stage.draw();
        stage.act();
    }
}