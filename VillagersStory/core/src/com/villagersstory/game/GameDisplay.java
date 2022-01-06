package com.villagersstory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.villagersstory.game.GameObjects.House;
import com.villagersstory.game.GameObjects.NPC;
import com.villagersstory.game.GameObjects.TreeOak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * generate method should share
 */
public class GameDisplay {
    final VillagerStory game;
    GameClock clock;
    List<House> houses = new ArrayList<>();
    List<NPC> npc = new ArrayList<>();
    List<TreeOak> trees = new ArrayList<>();
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
        generateTree();
    }



    public void render() {
        displayTime();
        displayHouse();
        displayTree();
        displayNPC();
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
        for(int i=0; i<5; i++) {
            houses.add(new House("house1.png"));
            houses.get(i).locationX = rand.nextInt(1280);
            houses.get(i).locationY = rand.nextInt(540);
        }
    }

    private void displayHouse() {
        for(int i=0; i<5; i++) {
            game.batch.draw(houses.get(i).image, houses.get(i).locationX, houses.get(i).locationY, 128, 128);
        }
    }


    public void generateTree(){
        for(int i=0; i<5; i++) {
            trees.add(new TreeOak());
            trees.get(i).locationX = rand.nextInt(1280);
            trees.get(i).locationY = rand.nextInt(540);
        }
    }

    private void displayTree() {
        for(int i=0; i<5; i++) {
            game.batch.draw(trees.get(i).image, trees.get(i).locationX, trees.get(i).locationY, 128, 128);
        }
    }

    public void generateNPC(){
        for(int i=0; i<10; i++) {
            npc.add(new NPC("alex.png"));
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

    }
}
