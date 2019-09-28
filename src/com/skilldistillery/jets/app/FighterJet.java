package com.skilldistillery.jets.app;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("Im a fighter jet and im flying!!");
	}

	@Override
	public void fight() {
		System.out.println("WOOO Balls 2 the WALL boys! FullAB T/O!");
	}

}
