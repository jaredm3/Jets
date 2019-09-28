package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {

	private AirField airField = new AirField(); // created to use AirField class
	private Scanner scanner = new Scanner(System.in);

	// NoArg Constructor
	public JetsApplication() {

	}

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		String fileName = "Airplanes.txt";

		jetApp.populatePilots();// adds pilots to List<String> in AirField

		List<Jet> jetList = jetApp.launch(fileName);// .txt file to List<Jet>

		jetApp.displayUserMenu(jetList);

	}

	public List<Jet> launch(String fileName) {
		List<Jet> result = new ArrayList<>();
		// AirField a = new AirField();

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				String[] jetRecords = line.split(", ");
				String type = jetRecords[0];
				String name = jetRecords[1];
				double speed = Double.parseDouble((jetRecords[2]));
				int range = Integer.parseInt(jetRecords[3]);
				long price = Long.parseLong(jetRecords[4]);

				if (type.equals("CargoPlane")) {
					Jet j = new CargoPlane(name, speed, range, price);
					result.add(j);// added to local List<Jet>
					airField.addJets(j);// added to airField List<Jet> #UserStory3

				} else if (type.equals("FighterJet")) {
					Jet j = new FighterJet(name, speed, range, price);
					result.add(j);
					airField.addJets(j);
				} else {
					Jet j = new VanillaCessna(name, speed, range, price);
					result.add(j);
					airField.addJets(j);
				}

			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem while reading " + e.getMessage());
		}
		return result;
	}

	public void populatePilots() {
		airField.populatePilots();
	}

	public void displayUserMenu(List<Jet> jetList) {
		boolean run = true;
		while (run) {
			System.out.println("***** Welcome to the HANGAR *****");
			System.out.println("Please choose a number: ");
			System.out.println("1) List Fleet");
			System.out.println("2) Fly all Jets");
			System.out.println("3) View Fastest Jet");
			System.out.println("4) View jet with longest range");
			System.out.println("5) Load all cargo jets");
			System.out.println("6) DOGFIGHT");
			System.out.println("7) Add a jet to the fleet");
			System.out.println("8) Remove a jet from the fleet");
			System.out.println("9) Quit");
			System.out.println("------- Beta Implementations -------");
			System.out.println("10) Randomly Assign Pilots to Fleet");
			System.out.println("11) Launch Single Jet");
			int userChoice = scanner.nextInt();

			switch (userChoice) {
			case 1:
				listFleet(jetList);
				break;
			case 2:
				flyJets();
				break;
			case 3:
				viewFastest();
				break;
			case 4:
				viewLongestRange();
				break;
			case 5:
				loadAllCargo();
				break;
			case 6:
				dogfight();
				break;
			case 7:
				addToFleet(jetList);
				break;
			case 8:
				removeFromFleet(jetList);
				break;
			case 9:// quit
				System.out.println("CYA!");
				run = false;
				break;
			case 10:
				assignPilotsRandom(jetList);
				break;
			case 11:
				System.out.println("Which jet would you like to fly? (enter model)");
				String userFly = scanner.next();
				launchSingleJet(userFly);
				break;
			default:
				System.out.println("Enter a number 0-9: \n");
				break;
			}
		}
	}

	public void listFleet(List<Jet> jetList) {

		for (Jet j : jetList) {
			System.out.println(j);
		}
		System.out.println();
	}

	public void flyJets() {
		airField.launchJets();
		System.out.println();
	}

	public void viewFastest() {
		System.out.println(airField.findFastest());
		System.out.println();
	}

	public void viewLongestRange() {
		System.out.println(airField.findLongestRange());
		System.out.println();
	}

	public void loadAllCargo() {
		airField.loadAllCargo();
		System.out.println();
	}

	public void dogfight() {
		airField.dogfight();
		System.out.println();
	}

	public void addToFleet(List<Jet> jetList) {

		System.out.println("Enter the type of the jet (fighter-cargo-basic): ");
		String jetType = scanner.next();
		System.out.println("Enter the model of the jet: ");
		String modelInput = scanner.next();
		System.out.println("Enter the speed of the jet: ");
		double nameInput = scanner.nextDouble();
		System.out.println("Enter the range of the jet: ");
		int rangeInput = scanner.nextInt();
		System.out.println("Enter the price of the jet: ");
		long priceInput = scanner.nextLong();

		if (jetType.toLowerCase().equals("fighter")) {
			Jet newTypeJet = new FighterJet(modelInput, nameInput, rangeInput, priceInput);
			jetList.add(newTypeJet);
			airField.addJets(newTypeJet);
		} else if (jetType.toLowerCase().equals("cargo")) {
			Jet newTypeJet = new CargoPlane(modelInput, nameInput, rangeInput, priceInput);
			jetList.add(newTypeJet);
			airField.addJets(newTypeJet);
		} else {
			Jet newJet = new VanillaCessna(modelInput, nameInput, rangeInput, priceInput);
			jetList.add(newJet);
			airField.addJets(newJet);
		}

	}

	public void removeFromFleet(List<Jet> jetList) {
		Jet copyRemove = null;
		System.out.println("Enter the model of the jet to remove: ");
		String modelInput = scanner.next();

		for (Jet j : jetList) {
			if (j.getModel().equals(modelInput)) {
				copyRemove = j;
			}
		}

		if (copyRemove.getModel().equals(null)) {
			return;
		}
		jetList.remove(copyRemove);
		airField.removeJets(copyRemove);
	}

	public void assignPilotsRandom(List<Jet> jetList) {
		System.out.println();
		airField.assignPilotsRandom();
		System.out.println();
	}
	
	public void launchSingleJet(String userInput) {
		airField.launchJet(userInput);
	}

}
