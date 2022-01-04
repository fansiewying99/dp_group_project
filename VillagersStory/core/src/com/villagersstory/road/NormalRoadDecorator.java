package com.villagersstory.road;

public class NormalRoadDecorator extends RoadDecorator {
	//Road road;
	public NormalRoadDecorator(Road road) {
		super(road);
	}
	public void create() {
		//setNormalRoad(this.road);
		road.create();
	}
	private void setNormalRoad(Road road) {
		//System.out.println("create normal road ");
	}
}
