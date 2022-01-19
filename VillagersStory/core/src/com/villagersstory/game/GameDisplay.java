package com.villagersstory.game;


import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.villagersstory.game.GameObjects.ButtonObject;
import com.villagersstory.game.GameObjects.house.House;
import com.villagersstory.game.GameObjects.NPC;

import com.villagersstory.game.GameObjects.animal.Animal;
import com.villagersstory.game.GameObjects.animal.Bird;
import com.villagersstory.game.GameObjects.animal.BirdAdapter;
import com.villagersstory.game.GameObjects.animal.Cat;
import com.villagersstory.game.GameObjects.animal.Dog;

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
    List<NPC> npc = new ArrayList<>();

    List<Animal> animals = new ArrayList<>();
    List<BirdAdapter> birds = new ArrayList<>();

    TreeFactory treeFactory = new TreeFactory();
    List<Tree> trees;

    Random rand = new Random();

    ButtonObject buttonObject = new ButtonObject();


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

        generateHouse();
        generateNPC();

        generateAnimal();
        trees = treeFactory.trees;
        ground.generateGrass();
        buttonObject.create();

    }

    public void render() {
        game.batch.draw(mountainImage, 0, 520, 1368, 216);
//        game.batch.draw(bgImage, bg.x, bg.y, bg.width, bg.height);
        displayGround();
        displayTime();
        displayHouse();
        displayTree();

        displayAnimal();
        displayNPC();

        buttonObject.render();
    }

    public void sound(){

    }
    public void setVolume(){

    }

    public void displayTime(){
        game.font.draw(game.batch, "Time ", 0, 700);
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
    }

    public void generateNPC(){
        for(int i=0; i<3; i++) {
            npc.add(new NPC());
            npc.get(i).locationX = rand.nextInt(1280);
            npc.get(i).locationY = rand.nextInt(540);
        }
    }
    public void displayNPC(){
        for(int i=0; i<3; i++) {
            npc.get(i).move();
            game.batch.draw(npc.get(i).img, npc.get(i).locationX, npc.get(i).locationY, npc.get(i).imgWidth, npc.get(i).imgHeight);
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
            animals.get(i).walk();
            game.batch.draw(animals.get(i).getImage(), animals.get(i).getLocationX(), animals.get(i).getLocationY(), 30, 30);
        }
        for(int i=0; i<birds.size(); i++) {
            birds.get(i).fly();
            game.batch.draw(birds.get(i).getImage(), birds.get(i).getLocationX(), birds.get(i).getLocationY(), 130, 130);
        }
    }
}
