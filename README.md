## Jets

### Week 3 Homework Project for Skill Distillery

### Overview

  This program reads a text file (.txt) and parses the information into Jet Objects, each with its own set of different characteristics. These Jets live in an AirField class, specifically in an ArrayList.



  The user is then confronted with this menu:

  			------------------------------------
  			***** Welcome to the HANGAR ******
			Please choose a number:
			1) List Fleet
			2) Fly all Jets
			3) View Fastest Jet
			4) View jet with longest range
			5) Load all cargo jets
			6) DOGFIGHT
			7) Add a jet to the fleet
			8) Remove a jet from the fleet
			9) Quit
			------- Beta Implementations -------
			10) Randomly Assign Pilots to Fleet
			11) Launch Single Jet
  			------------------------------------

  When the user chooses an action item (Fly Jets, Load cargo Jets, DOGFIGHT & Launch Single Jet) a method calls Objects that are an instance of a specific Interface. When adding a Jet to the fleet, the user has the option of selecting which type of Jet it is going to be, which governs its behavior (which Interface it implements). 
  
  Choosing to Randomly Assign Pilots to Fleet takes a hardcoded list of 10 pilots and pairs a pilot randomly to a Jet in the fleet. 

### Technologies/Topics Applied

  1) Object Oriented Programming
  
   Inheritance and Abstraction methodologies were put to use during this project. There is an Abstract Jet SuperClass that other subclasses extend. These subclasses (FighterJet, CargoJet, VanillaCessna) also implement certain Interfaces.  

  2) Eclipse Debugging
  
    Using the Eclipse Debugging was a great help while writing this program. I was having an issue with two Lists that were tied to the same 'variable' or spot on the 'Heap'. When I used the debugging feature, I was able to see that while it was going through a loop and editing one List, the copy of the List was also being edited. 

  3) Interfaces
  
    Interfaces were utilized to define an Objects behavior. For example, only the Cargo Jets can 'Load Cargo' and only Fighter Jets can 'Dogfight'. 
