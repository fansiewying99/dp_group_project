package com.villagersstory.road;

public abstract class RoadDecorator implements Road{
	Road road;
	public RoadDecorator(Road road) {
		this.road=road;
	}
	public void create() {
		System.out.println("create road");
	}
	
}