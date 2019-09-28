package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.List;

public class AirField {

	private List<Jet> jets = new ArrayList<>(); // home for Jets #User Story2
	private List<String> pilots = new ArrayList<>();// home for pilots (strings)

	public AirField() {

	}

	public void addJets(Jet j) {
		jets.add(j);
	}

	public void removeJets(Jet j) {
		jets.remove(j);
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
	
	public void launchJet(String userInput) {
		for (Jet j : jets) {
			if (j.getModel().equals(userInput)) {
				j.fly();
				break;
			}
		}
	}

	public Jet findFastest() {
		double topSpeed = 0;
		Jet fastJet = null;
		for (Jet j : jets) {
			if (j.getSpeed() > topSpeed) {
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
			if (j.getRange() > topRange) {
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

	public void populatePilots() {
		pilots.add("Chuck");
		pilots.add("Amelia");
		pilots.add("Charles");
		pilots.add("Bessie");
		pilots.add("Jimmy");
		pilots.add("Hoover");
		pilots.add("Howard");
		pilots.add("Pappy");
		pilots.add("Pancho");
		pilots.add("Wiley");
	}

	public void assignPilotsRandom() {
		int pilotsNeeded = jets.size();
		List<String> pilotsCopy = new ArrayList<>(pilots);// copy of pilots list

		for (int i = 0; i < jets.size(); i++) {//gets random pilot & assigns to plane
			int index = (int) (Math.random() * pilotsNeeded);
			System.out.println(pilots.get(index) + " is flying the " + jets.get(i).getModel());
			pilots.remove(index);
			pilotsNeeded--;
		}
		pilots = pilotsCopy;// Allows method to be called over w/o exiting program
	}

	public void assignPilotsUser() {

	}

}
