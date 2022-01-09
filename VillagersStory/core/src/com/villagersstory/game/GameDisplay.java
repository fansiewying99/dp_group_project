package com.villagersstory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.villagersstory.game.GameObjects.House;
import com.villagersstory.game.GameObjects.NPC;
import com.villagersstory.game.GameObjects.animal.Animal;
import com.villagersstory.game.GameObjects.animal.Bird;
import com.villagersstory.game.GameObjects.animal.BirdAdapter;
import com.villagersstory.game.GameObjects.animal.Cat;
import com.villagersstory.game.GameObjects.animal.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameDisplay {
    final VillagerStory game;
    GameClock clock;
    List<House> houses = new ArrayList<>();
    List<NPC> npc = new ArrayList<>();
    List<Animal> animals = new ArrayList<>();
    List<BirdAdapter> birds = new ArrayList<>();
    Random rand = new Random();

    public GameDisplay(VillagerStory game) {
        this.game = game;
        clock = GameClock.getInstance();
        try {
            clock.startTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        generateHouse();
        generateNPC();
        generateAnimal();
    }



    public void render() {
        displayTime();
        displayHouse();
        displayNPC();
        displayAnimal();
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
        for(int i=0; i<10; i++) {
            houses.add(new House("../core/assets/house64.png"));
            houses.get(i).locationX = rand.nextInt(1280);
            houses.get(i).locationY = rand.nextInt(540);
        }
    }

    private void displayHouse() {
        for(int i=0; i<10; i++) {
            game.batch.draw(houses.get(i).image, houses.get(i).locationX, houses.get(i).locationY, 256, 256);
        }
    }


    public void generateTree(){

    }
    public void generateNPC(){
        for(int i=0; i<10; i++) {
            npc.add(new NPC("../core/assets/alex.png"));
            npc.get(i).locationX = rand.nextInt(1280);
            npc.get(i).locationY = rand.nextInt(540);
        }
    }
    public void displayNPC(){
        for(int i=0; i<10; i++) {
            npc.get(i).move();
            game.batch.draw(npc.get(i).image, npc.get(i).locationX, npc.get(i).locationY, 23, 48);
        }
    }
    public void generateAnimal(){
    	//int ranInt=rand.nextInt(3);
    	for(int i=0; i<20; i++) {
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
