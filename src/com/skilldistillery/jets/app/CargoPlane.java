package com.skilldistillery.jets.app;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		super.setTimeAloft(this.getRange() / this.getSpeed());
	}

	@Override
	public void fly() { // Print Jet details & amt time in air

		System.out.println("\nIm a " + this.getModel() + " cargo plane!");
		System.out.println("Kick the tires and light the fire EH!?");
		System.out.println(this);
		System.out.print("I can stay aloft for ");
		System.out.printf("%.2f", this.getTimeAloft());
		System.out.println(" Hours.\n");
	}

	@Override
	public void loadCargo() {
		System.out.println("Im " + this.getModel() + " cargo plane!");
		System.out.println("Loading cargo.....\n Cargo Loaded!\n");
	}

}
