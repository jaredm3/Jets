package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {

	private AirField airField = new AirField();
	private Scanner scanner = new Scanner(System.in);

	public JetsApplication() {

	}

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		String fileName = "Airplanes.txt";

		List<Jet> jetList = jetApp.launch(fileName);

		//System.out.println(jetList);

		jetApp.displayUserMenu(jetList);

	}

	public List<Jet> launch(String fileName) {
		List<Jet> result = new ArrayList<>();
		AirField a = new AirField();

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

//				System.out.println("0 is " + jetRecords[0]);
//				System.out.println("1 is " + jetRecords[1]);
//				System.out.println("2 is " + jetRecords[2]);
//				System.out.println("3 is " + jetRecords[3]);
//				System.out.println("4 is " + jetRecords[4]);

				if (type.equals("CargoPlane")) {
					Jet j = new CargoPlane(name, speed, range, price);
					result.add(j);
					airField.addJets(j);
					// a.addJets(j);
				} else if (type.equals("FighterJet")) {
					Jet j = new FighterJet(name, speed, range, price);
					result.add(j);
					airField.addJets(j);
					// a.addJets(j);
				} else {
					Jet j = new VanillaCessna(name, speed, range, price);
					result.add(j);
					airField.addJets(j);
					// a.addJets(j);
				}

			}

			// System.out.println(a); print check
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem while reading " + e.getMessage());
		}
		return result;
	}

	public void displayUserMenu(List<Jet> jetList) {
		boolean run = true;
		while (run) {
			System.out.println("***** Welcome to the HANGAR *****");
			System.out.println();
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

			default:
				break;
			}
		}
	}

	public void listFleet(List<Jet> jetList) {

		for (Jet j : jetList) {
			System.out.println(j);
		}
	}

	public void flyJets() {
		airField.launchJets();
		// System.out.println(airField.jets);
	}

	public void viewFastest() {
		System.out.println(airField.findFastest());
	}

	public void viewLongestRange() {
		System.out.println(airField.findLongestRange());
	}

	public void loadAllCargo() {
		airField.loadAllCargo();
	}

	public void dogfight() {
		airField.dogfight();
	}

	public void addToFleet(List<Jet> jetList) {

		System.out.println("Enter the model of the jet: ");
		String modelInput = scanner.next();
		System.out.println("Enter the speed of the jet: ");
		double nameInput = scanner.nextDouble();
		System.out.println("Enter the range of the jet: ");
		int rangeInput = scanner.nextInt();
		System.out.println("Enter the price of the jet: ");
		long priceInput = scanner.nextLong();

		Jet newJet = new VanillaCessna(modelInput, nameInput, rangeInput, priceInput);
		jetList.add(newJet);
		
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
	}

}
