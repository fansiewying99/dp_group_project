package com.villagersstory.game.GameObjects.tree;

import java.util.ArrayList;
import java.util.Random;

public class TreeFactory {
    static TreeFactory treeFactory = new TreeFactory();
    Random rand = new Random();
    public ArrayList<Tree> trees = new ArrayList<>();

    private TreeFactory() {
//        createTree();
//        generateTree();
    }
    public static TreeFactory getInstance(){
        return treeFactory;
    }
    public Tree createTree(String treeType){
        if(treeType.equals("dead"))
            trees.add(new TreeDead());
        else if(treeType.equals("coconut"))
            trees.add(new TreeCoconut());
        else if(treeType.equals("pine"))
            trees.add(new TreePine());
        else if(treeType.equals("oak"))
            trees.add(new TreeOak());

        trees.get(trees.size()-1).setLocationX(rand.nextInt(1280));
        trees.get(trees.size()-1).setLocationY(rand.nextInt(540));

        return trees.get(trees.size()-1);
    }
    public void generateTree(){
        for(int i=0; i<trees.size(); i++){
            trees.get(i).setLocationX(rand.nextInt(1280));
            trees.get(i).setLocationY(rand.nextInt(540));
        }

    }
    public void generateCoconut(){
        trees.get(1).generate();
    }
}
