package com.villagersstory.game.GameObjects.tree;

import java.util.ArrayList;
import java.util.Random;

public class TreeFactory {
    Random rand = new Random();
    public ArrayList<Tree> trees = new ArrayList<>();

    public TreeFactory() {
        createTree();
        generateTree();
    }

    public void createTree(){
        trees.add(new TreeDead());
        trees.add(new TreeCoconut());
        trees.add(new TreePine());
        trees.add(new TreeOak());
    }
    public void generateTree(){
        for(int i=0; i<trees.size(); i++){
            trees.get(i).setLocationX(rand.nextInt(1280));
            trees.get(i).setLocationY(rand.nextInt(540));
        }
        trees.get(1).generate();
    }
}
