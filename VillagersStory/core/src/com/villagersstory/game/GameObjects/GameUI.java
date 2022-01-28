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
//        bgCanvas.setBackground(skin.getDrawable("buttonUp"));
//        bgCanvas.setSize(stage.getWidth(), stage.getHeight());
        bgCanvas.setSize(350, 150);
        bgCanvas.setPosition(0,570);
        bgCanvas.left();
        bgCanvas.top();

        table = new Table(skin);
        table.left();
        table.top();
        bgCanvas.top();
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
            bgCanvas.add(menu.get(i)).fillX();
        }
        bgCanvas.row();
//        table.row();
        //create buttons
        npcButtons.add(new TextButton("Add Adult", skin));
        npcButtons.add(new TextButton("Add Child", skin));

        skyButtons.add(new TextButton("Clear", skin));
        skyButtons.add(new TextButton("Rainy", skin));
        skyButtons.add(new TextButton("Dusk", skin));
        skyButtons.add(new TextButton("Night", skin));

        treeButtons.add(new TextButton("Add Dead Tree", skin));
        treeButtons.add(new TextButton("Add Coconut Tree", skin));
        treeButtons.add(new TextButton("Add Oak Tree", skin));
        treeButtons.add(new TextButton("Add Pine Tree", skin));

        animalButtons.add(new TextButton("Add Cat", skin));
        animalButtons.add(new TextButton("Add Dog", skin));
        animalButtons.add(new TextButton("Add Dragon", skin));

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
                    table.clear();
                    System.out.println("I was clicked");
                    String str = menu.get(finalI).getText().toString();
                    if(str.equals("Sky & Weather")){
                        tempButtons = skyButtons;
                    }
                    else if(str.equals("Houses")){
                        System.out.println("sup");
                    }
                    else if(str.equals("Trees")){
                        tempButtons = treeButtons;
                    }
                    else if(str.equals("Animals")){
                        tempButtons = animalButtons;
                    }
                    else if(str.equals("NPC")){
                        tempButtons = npcButtons;
                    }
                    for(int i=0; i<tempButtons.size(); i++) {
                        table.add(tempButtons.get(i)).expand().bottom().fillX().width(120);
                        table.row();
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