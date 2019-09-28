package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	
	public List<Jet> jets = new ArrayList<>();    //change to private
	
	public AirField() {
		 
	}
	
	public void addJets(Jet j) {
		jets.add(j);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirField [jets=");
		builder.append(jets);
		builder.append("]");
		return builder.toString();
	}
	
	public void launchJets() {
		for (Jet j : jets) {
			j.fly();
		}
	}
	
	public Jet findFastest() {
		double topSpeed = 0;
		Jet fastJet = null;
		for (Jet j : jets) {
			if (j.getSpeed()>topSpeed) {
				topSpeed = j.getSpeed();
				fastJet = j;
				
			}
		}
		return fastJet;
	}
	
	public Jet findLongestRange() {
		int topRange = 0;
		Jet topRangeJet = null;
		for (Jet j : jets) {
			if (j.getRange()>topRange) {
				topRange = j.getRange();
				topRangeJet = j;
				
			}
		}
		return topRangeJet;
	}
	
	public void loadAllCargo() {
		for (Jet j : jets) {
			if (j instanceof CargoCarrier) {
				((CargoCarrier) j).loadCargo();
			}
		}
	}
	
	public void dogfight() {
		for (Jet j : jets) {
			if (j instanceof CombatReady) {
				((CombatReady) j).fight();
			}
		}
	}
	
}
