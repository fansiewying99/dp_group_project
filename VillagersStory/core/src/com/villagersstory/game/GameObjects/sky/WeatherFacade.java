package com.villagersstory.game.GameObjects.sky;

import com.villagersstory.game.GameObjects.animal.Animal;
import com.villagersstory.game.GameObjects.animal.BirdAdapter;
import com.villagersstory.game.GameObjects.npc.NPC;
import com.villagersstory.game.VillagerStory;

import java.util.List;

public class WeatherFacade {
    Sky sky;
    List<NPC> npc;
    List<Animal> animals;
    List<BirdAdapter> birds;
    final VillagerStory game;


    public WeatherFacade(VillagerStory game, Sky sky, List<NPC> npc, List<Animal> animals, List<BirdAdapter> birds) {
        this.game = game;
        this.sky = sky;
        this.npc = npc;
        this.animals = animals;
        this.birds = birds;
    }

    public void changeWeather(String weather){
        if (weather.equalsIgnoreCase("sunny")){
            sky.setColour(weather);
            game.batch.setColor(1f,1f,1f,1f);
            for(NPC i:npc){
                i.setSpeed(1.0);
            };
            for (Animal i:animals) {
                i.setSpeed(1.0);
            }
            for (BirdAdapter i: birds){
                i.setSpeed(1.0);
            }
        }
        else if (weather.equalsIgnoreCase("rainy")){
            sky.setColour(weather);
            game.batch.setColor(0.7f,0.7f,0.7f,1f);
            for(NPC i:npc){
                i.setSpeed(4.0);
            };
            for (Animal i:animals) {
                i.setSpeed(3.0);
            }
            for (BirdAdapter i: birds){
                i.setSpeed(3.0);
            }
        }
        else if(weather.equalsIgnoreCase("dark")){
            sky.setColour(weather);
            game.batch.setColor(0.5F, 0.5F, 0.5F, 1F);
            for(NPC i:npc){
                i.setSpeed(0.4);
            };
            for (Animal i:animals) {
                i.setSpeed(1.0);
            }
            for (BirdAdapter i: birds){
                i.setSpeed(1.0);
            }
        }
        else if (weather.equalsIgnoreCase("evening")){
            sky.setColour(weather);
            game.batch.setColor(220/255F, 176/255F, 111/255F, 1F);
            for(NPC i:npc){
                i.setSpeed(0.8);
            };
            for (Animal i:animals) {
                i.setSpeed(3.0);
            }
            for (BirdAdapter i: birds){
                i.setSpeed(3.0);
            }
        }
    }
}