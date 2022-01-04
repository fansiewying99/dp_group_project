package com.villagersstory.animal;

import com.badlogic.gdx.graphics.Texture;

public class BirdAdapter implements Animal{
	private Bird bird;

    public BirdAdapter(Bird bird)
    {
        this.bird = bird;
    }

    public void fly()
    {
        // A turkey is not a duck but, act like one
        bird.fly();
    }
    
    public void setFlyDirection(String dir) {
		this.bird.setFlyDirection(dir);
	}

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("bird sound");
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Texture getAnimal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWalkDirection(String direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStandDirection(String direction) {
		// TODO Auto-generated method stub
		
	}
}
