package com.skilldistillery.jets.app;

public class VanillaCessna extends Jet {

	public VanillaCessna(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		super.setTimeAloft(this.getRange() / this.getSpeed());
	}

	@Override
	public void fly() {
		System.out.println("\nIm a " + this.getModel() + " cessna");
		System.out.println("We're flying in this thing???");
		System.out.println(this);
		System.out.print("I can stay aloft for ");
		System.out.printf("%.2f", this.getTimeAloft());
		System.out.println(" Hours.\n");
	}

}
