package com.skilldistillery.jets.app;

public class VanillaCessna extends Jet {

	public VanillaCessna(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("IM a cessna woooooO!");
	}

}
