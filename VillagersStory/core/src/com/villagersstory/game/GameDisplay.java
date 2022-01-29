package com.villagersstory.game;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.villagersstory.game.GameObjects.GameUI;
import com.villagersstory.game.GameObjects.Sky;
import com.villagersstory.game.GameObjects.WeatherFacade;
import com.villagersstory.game.GameObjects.npc.Adult;
import com.villagersstory.game.GameObjects.npc.Child;
import com.villagersstory.game.GameObjects.npc.NPC;
import com.villagersstory.game.GameObjects.house.House;
import com.villagersstory.game.GameObjects.npc.Human;

import com.villagersstory.game.GameObjects.animal.Animal;
import com.villagersstory.game.GameObjects.animal.Bird;
import com.villagersstory.game.GameObjects.animal.BirdAdapter;
import com.villagersstory.game.GameObjects.animal.Cat;
import com.villagersstory.game.GameObjects.animal.Dog;

import com.villagersstory.game.GameObjects.tree.Fruit;
import com.villagersstory.game.GameObjects.tree.Tree;
import com.villagersstory.game.GameObjects.tree.TreeFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * generate method should share
 */

public class GameDisplay {
    final VillagerStory game;
    GameClock clock;
    Texture bgImage;
    Texture mountainImage;
    Rectangle bg;
    Music townMusic = Gdx.audio.newMusic(Gdx.files.internal("TownTheme.mp3"));
    Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("Rain.mp3"));
    GroundGrid ground = GroundGrid.getInstance();

    List<House> houses = new ArrayList<>();
    List<NPC> human = new ArrayList<>();

    List<Animal> animals = new ArrayList<>();
    List<BirdAdapter> birds = new ArrayList<>();

    TreeFactory treeFactory = TreeFactory.getInstance();
    List<Tree> trees = new ArrayList<>();;
    Sky sky;
    WeatherFacade weather;

    Random rand = new Random();

    //UI elements
    Table bgCanvas;
    Table table;
    private Skin skin;
    private Stage stage;
    private ArrayList<TextButton> menu = new ArrayList<>();
    private ArrayList<TextButton> tempButtons = new ArrayList<>();

    private ArrayList<TextButton> npcButtons = new ArrayList<>();
    private ArrayList<TextButton> treeButtons = new ArrayList<>();
    private ArrayList<TextButton> skyButtons = new ArrayList<>();
    private ArrayList<TextButton> animalButtons = new ArrayList<>();
    private ArrayList<TextButton> houseButtons = new ArrayList<>();
    //UI elements end

    public GameDisplay(VillagerStory game) {
        this.game = game;
        clock = GameClock.getInstance();
        try {
            clock.startTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        townMusic.setLooping(true);
        townMusic.setVolume(0.05f);
        rainMusic.setVolume(0.1f);
        rainMusic.setLooping(true);
        mountainImage = new Texture(Gdx.files.internal("sky/mountains.png"));
        bg = new Rectangle();
        // the bottom screen edge
        bg.width = 1280;
        bg.height = 720;
        ground.generateGrass();

        createUI();
        sky = new Sky();
        weather = new WeatherFacade(game, sky, human, animals, birds);
    }

    public void render() {
        //Render Sky color
        Gdx.gl.glClearColor(sky.getColour().r, sky.getColour().g, sky.getColour().b, sky.getColour().a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        if (!sky.getColour().equals(Sky.rainy)){
            displaySky();
        }
        game.batch.draw(mountainImage, 0, 520);

        displayGround();
        displayHouse();
        displayTree();

        displayAnimal();
        displayHumans();

        if (sky.getColour().equals(Sky.rainy)){
            displaySky();
        }
        displayTime();
        game.batch.end();
        renderUI();
    }

    public void sound(){
        townMusic.play();
    }
    public void setVolume(){

    }

    public void displayTime(){
        game.font.draw(game.batch, "Day:  "+clock.day, 1140, 705);
        game.font.draw(game.batch, "Time: "+String.format("%02d", clock.hour), 1140, 690);
        game.font.draw(game.batch, ": "+String.format("%02d", clock.min), 1200, 690);
    }
    public void generateHouse(){
        houses.add(new House());
        houses.get(houses.size()-1).locationX = rand.nextInt(1280);
        houses.get(houses.size()-1).locationY = rand.nextInt(540);

    }
    private void displayGround() {
        for(int i=0; i< ground.height/ground.tileSize; i++) {
            for (int j = 0; j < ground.width /ground.tileSize; j++) {
                game.batch.draw(ground.grid[i][j], j*ground.tileSize, i*ground.tileSize, ground.tileSize, ground.tileSize);
            }
        }
    }
    private void displayHouse() {
        for(int i=0; i<houses.size(); i++) {
            game.batch.draw(houses.get(i).image, houses.get(i).locationX, houses.get(i).locationY, 128, 128);
        }
    }


    private void displayTree() {
        for(int i=0; i< trees.size(); i++) {
            game.batch.draw(trees.get(i).getImage(), trees.get(i).getLocationX(), trees.get(i).getLocationY(), 128, 128);

        }

    }

    public void generateHumans(String age){
        if(age.equals("adult")) {
            human.add(new Adult());
            human.get(human.size()-1).locationX = rand.nextInt(1280);
            human.get(human.size()-1).locationY = rand.nextInt(540);
        }
        else if(age.equals("child")) {
            human.add(new Child());
            human.get(human.size()-1).locationX = rand.nextInt(1280);
            human.get(human.size()-1).locationY = rand.nextInt(540);
        }

    }
    public void displayHumans(){
        for(int i=0; i<human.size(); i++) {
            human.get(i).move();
            game.batch.draw(human.get(i).img, human.get(i).locationX, human.get(i).locationY, human.get(i).imgWidth, human.get(i).imgHeight);
        }
    }
    public void generateAnimal(){
    	//int ranInt=rand.nextInt(3);
    	for(int i=0; i<10; i++) {
    		int ranInt=rand.nextInt(3)+1;
    		System.out.println(ranInt);
    		
    		if(ranInt==2) {
    			BirdAdapter bird=new BirdAdapter(new Bird());
	            birds.add(bird);
	            bird.setLocationX(rand.nextInt(1280));
	            bird.setLocationY(rand.nextInt(540));
    		}else{
    			Animal animal=null;
	    		if(ranInt==1) {
	    			animal=new Cat();
	    		}
	    		else if(ranInt==3) {
	    			animal=new Dog();
	    		}
	    		animal.setLocationX(rand.nextInt(1280));
	            animal.setLocationY(rand.nextInt(540));
	            animals.add(animal);
    		}
        }
    }
    public void displayAnimal(){
        for(int i=0; i<animals.size(); i++) {
            NPC animalNPC = (NPC) animals.get(i);
            if(animalNPC!= null)
                animalNPC.move();

            game.batch.draw(animals.get(i).getImage(), animals.get(i).getLocationX(), animals.get(i).getLocationY(), 30, 30);
        }
        for(int i=0; i<birds.size(); i++) {
            birds.get(i).fly();
            game.batch.draw(birds.get(i).getImage(), birds.get(i).getLocationX(), birds.get(i).getLocationY(), 130, 130);
        }
    }
    public void displaySky(){
        game.batch.draw(sky.getObjectOnSky().image, sky.getObjectOnSky().locationX, sky.getObjectOnSky().locationY,
                sky.getObjectOnSky().width, sky.getObjectOnSky().height);
        if (sky.getColour().equals(Sky.rainy)) {
            if(!rainMusic.isPlaying())
                rainMusic.play();
            weather.changeWeather("rainy");
        } else {
            if(rainMusic.isPlaying())
                rainMusic.stop();
        }
    }
    public void createUI() {
        //make a stage for your button to go on
        stage = new Stage();
        // skin is from gdx-skins (https://github.com/czyzby/gdx-skins)
        skin = new Skin(Gdx.files.internal("kenney-pixel/skin/skin.json"));
        bgCanvas = new Table(skin);
        bgCanvas.setSize(350, 150);
        bgCanvas.setPosition(0,570);
        bgCanvas.left();
        bgCanvas.top();

        table = new Table(skin);
        table.left();
        table.top();
        bgCanvas.top();

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
        //create buttons
        npcButtons.add(new TextButton("Add Adult", skin));
        npcButtons.add(new TextButton("Add Child", skin));

        skyButtons.add(new TextButton("Sunny", skin));
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

        houseButtons.add(new TextButton("Add House", skin));

        bgCanvas.add(table).expand().top().fillX();
        stage.addActor(bgCanvas);

        for(int i=0; i<menu.size(); i++) {
            final int finalI = i;
            menu.get(i).addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    table.clear();
//                    for(int i=0; i<tempButtons.size(); i++) {
//                        tempButtons.get(i).clearListeners();
//                    }

                    System.out.println("I was clicked");
                    String str = menu.get(finalI).getText().toString();
                    if(str.equals("Sky & Weather")){
                        tempButtons = skyButtons;
                    }
                    else if(str.equals("Houses")){
                        tempButtons = houseButtons;
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
                        final int finalJ = i;

                        if(tempButtons.get(i).getListeners().size <= 1 ) {
                            tempButtons.get(i).addListener(new ChangeListener() {
                                @Override
                                public void changed(ChangeEvent event, Actor actor) {
                                    System.out.println("temp buttons");
                                    String str = tempButtons.get(finalJ).getText().toString();
                                    if (str.equals("Sunny")) {
                                        weather.changeWeather("sunny");
                                    } else if (str.equals("Rainy")) {
                                        weather.changeWeather("rainy");
                                    } else if (str.equals("Dusk")) {
                                        weather.changeWeather("evening");
                                    } else if (str.equals("Night")) {
                                        weather.changeWeather("dark");
                                    } else if (str.equals("Add Adult")) {
                                        generateHumans("adult");
                                    } else if (str.equals("Add Child")) {
                                        generateHumans("child");
                                    } else if (str.equals("Add Dead Tree")) {
                                        trees.add(treeFactory.createTree("dead"));
                                    } else if (str.equals("Add Coconut Tree")) {
                                        trees.add(treeFactory.createTree("coconut"));
                                    } else if (str.equals("Add Oak Tree")) {
                                        trees.add(treeFactory.createTree("oak"));
                                    } else if (str.equals("Add Pine Tree")) {
                                        trees.add(treeFactory.createTree("pine"));
                                    } else if (str.equals("Add Cat")) {
                                        //
                                    } else if (str.equals("Add Dog")) {
                                        //
                                    } else if (str.equals("Add Dragon")) {
                                        //
                                    }
                                    else if (str.equals("Add House")) {
                                        generateHouse();
                                    }

                                }

                            });
                        }

                    }
                    System.out.println(tempButtons.size());
                }
            });
        }

        Gdx.input.setInputProcessor(stage);
    }
    public void renderUI() {
        // tell stage to do action and then draw itself
        stage.draw();
        stage.act();
    }
}
