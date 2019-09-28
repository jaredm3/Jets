package com.skilldistillery.jets.app;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		super.setTimeAloft(this.getRange() / this.getSpeed());
	}

	@Override
	public void fly() {

		System.out.println("\nIm a " + this.getModel() + " fighter jet!");
		System.out.println("Whatchya say Goose... lets go get some bogies!!");
		System.out.println(this);
		System.out.print("I can stay aloft for ");
		System.out.printf("%.2f", this.getTimeAloft());
		System.out.println(" Hours.\n");
	}

	@Override
	public void fight() {
		System.out.println("Im " + this.getModel() + " fighter jet!");
		System.out.println("I'm goin hot!! Crankin & bankin!!\n");
	}

}
