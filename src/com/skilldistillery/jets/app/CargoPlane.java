package com.skilldistillery.jets.app;

public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("Im a cargo plane FLYYYY");
	}
	
	@Override
	public void loadCargo() {
		System.out.println("Im a cargo plane loading cargo!");
	}

}
