package com.villagersstory.game;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.villagersstory.game.GameObjects.GameUI;
import com.villagersstory.game.GameObjects.Sky;
import com.villagersstory.game.GameObjects.WeatherFacade;
import com.villagersstory.game.GameObjects.npc.Adult;
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

    GroundGrid ground = new GroundGrid();

    List<House> houses = new ArrayList<>();
    List<Adult> human = new ArrayList<>();

    List<Animal> animals = new ArrayList<>();
    List<BirdAdapter> birds = new ArrayList<>();

    TreeFactory treeFactory = TreeFactory.getInstance();
    List<Tree> trees;
    Sky sky;
    WeatherFacade weather;

    Random rand = new Random();

    GameUI gameUI = new GameUI();
    Cursor cursor = Cursor.getInstance();

    public GameDisplay(VillagerStory game) {
        this.game = game;
        clock = GameClock.getInstance();
        try {
            clock.startTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        bgImage = new Texture(Gdx.files.internal("background ex.png"));
        mountainImage = new Texture(Gdx.files.internal("sky/mountains.png"));
        bg = new Rectangle();
        // the bottom screen edge
        bg.width = 1280;
        bg.height = 720;
        ground.generateGrass();
        generateHouse();
        generateHumans();

        generateAnimal();
        trees = treeFactory.trees;
        gameUI.create();
        sky = new Sky();
        weather = new WeatherFacade(game, sky, human, animals, birds);
    }

    public void render() {

//        game.batch.draw(bgImage, bg.x, bg.y, bg.width, bg.height);
        //Render Sky color
        Gdx.gl.glClearColor(sky.getColour().r, sky.getColour().g, sky.getColour().b, sky.getColour().a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        if (!sky.getColour().equals(Sky.rainy)){
            displaySky();
        }
        if(Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.U))
            weather.changeWeather("sunny");
        if(Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.I))
            weather.changeWeather("rainy");
        if(Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.O))
            weather.changeWeather("evening");
        if(Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.P))
            weather.changeWeather("dark");
        game.batch.draw(mountainImage, 0, 520);

        displayGround();
        displayHouse();
        displayTree();

        displayAnimal();
        displayHumans();

        displayTime();
//
        if (sky.getColour().equals(Sky.rainy)){
            displaySky();
        }
        game.batch.end();

        gameUI.render();
        human.get(0).draw();
        cursor.draw(GameScreen.camera);
    }

    public void sound(){

    }
    public void setVolume(){

    }

    public void displayTime(){
        game.font.draw(game.batch, "Day: "+clock.day, 0, 690);
        game.font.draw(game.batch, "Hour: "+clock.hour, 0, 680);
        game.font.draw(game.batch, "Min: "+clock.min, 0, 670);

    }
    public void generateHouse(){
    	/*FileHandle dirHandle;

		dirHandle = Gdx.files.internal("../core/assets");
		
		for (FileHandle entry: dirHandle.list()) {
			System.out.println(entry);
		}*/

        for(int i=0; i<5; i++) {
            houses.add(new House());
            houses.get(i).locationX = rand.nextInt(1280);
            houses.get(i).locationY = rand.nextInt(540);
        }
    }
    private void displayGround() {
        for(int i=0; i< ground.height/ground.tileSize; i++) {
            for (int j = 0; j < ground.width /ground.tileSize; j++) {
                game.batch.draw(ground.grid[i][j], j*ground.tileSize, i*ground.tileSize, ground.tileSize, ground.tileSize);
            }
        }
//        for(int i=0; i<ground.leaf.size(); i++)
//            game.batch.draw(ground.leaf.get(i), i*ground.tileSize, i*ground.tileSize, 24,24);
    }
    private void displayHouse() {
        for(int i=0; i<5; i++) {
            game.batch.draw(houses.get(i).image, houses.get(i).locationX, houses.get(i).locationY, 128, 128);
        }
    }


    private void displayTree() {
        for(int i=0; i< trees.size(); i++) {
            game.batch.draw(trees.get(i).getImage(), trees.get(i).getLocationX(), trees.get(i).getLocationY(), 128, 128);

        }
        ArrayList<Fruit> fruits = trees.get(1).dropFruit();
        for(int i=0; i< fruits.size(); i++) {
            game.batch.draw(fruits.get(i).getImage(), fruits.get(i).getLocationX(), fruits.get(i).getLocationY(), 16, 16);
        }
    }

    public void generateHumans(){
        for(int i=0; i<3; i++) {
            human.add(new Adult());
            human.get(i).locationX = rand.nextInt(1280);
            human.get(i).locationY = rand.nextInt(540);
        }
    }
    public void displayHumans(){
        for(int i=0; i<3; i++) {
            human.get(i).move();
            game.batch.draw(human.get(i).img, human.get(i).locationX, human.get(i).locationY, human.get(i).imgWidth, human.get(i).imgHeight);
        }
    }
    public void generateAnimal(){
    	//int ranInt=rand.nextInt(3);
    	for(int i=0; i<10; i++) {
    		int ranInt=rand.nextInt(3)+1;
    		System.out.println(ranInt);
    		//int catnum=0;
    		//int birdnum=0;
    		
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
    }
}
