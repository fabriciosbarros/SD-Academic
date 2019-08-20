Software Development Academic Project.


Project Title: CCTAir

This is a group project.

Group participants:

Fabricio Barros
Fermin Aguilar
Aldana Louzan


REQUIREMENTS:

********************************************************
Module Learning Outcome: 
understand and employ fundamental concepts and principles of programming such as variables, Boolean expressions, control flow structures, methods, arrays, etc. (Linked to PLO 1, 3) 

demonstrate a structured approach to algorithmic design and problem solving and exhibit professional development best practices in designing and developing robust, maintainable software (Linked to PLO 5, 6) 

discriminate between elements of object-oriented programming (abstract and
nested classes, interfaces, access modifiers, etc.) and employ them appropriately in program construction  (Linked to PLO 2,4,5)


********************************************************


The Project:  CCTAir
Design an airline schedule to contain as a minimum the following.
Design and implement a class called AirPlane that will store data about a commercial aircraft.
Data for an airplane includes (but not limited to):
 - make (type of plane, such as, “Boeing”)
 - model (model number, for example, 707)
 - capacity (seating capacity of the plane – a whole number up to 400) 
 - pilot (name of pilot assigned to the aircraft)
Your implementation should include:
a) A constructor that accepts parameters in the order given above and initializes the corresponding instance variables;
b) Getter methods as given below:
getMake() – return a string with the make of the airplane
getModel() – return a number being the airplane’s model
getPilot() – return (at a minimum) the pilot’s name
capacity() - return a number being the capacity of the airplane.
c) A method called assignPilot which accepts the name of a pilot and assigns the pilot to the airplane (pilot may also be created as an object to include the rating of the Pilot, ie. What type of planes they are qualified to fly).
d) A toString() method which should return a string with the format:
 Airplane Information: Aircraft : <<insert make>> <<insert model>> Capacity: ___ seats Pilot: _____


Design and implement a class called Flight that will store data about a commercial flight. 
Data includes:
 - origin (e.g. “Dublin”) 
- destination (e.g. “New York”)
 - departure time (e.g. “10:10”)
 - arrival time (e.g “13:30”)
 - date of flight (e.g. “06/03/2019”)
 - aircraft assigned (this should be an object);
Your implementation should include:
 a) A constructor which accepts data (except for departure time and arrival time), in the order listed above and initializes each relevant instance variable accordingly.
b) A toString() method which should return a string with the format:
 Flight Information: 
Date: <<insert date of flight>> 
From: <<insert origin>> 
to <<insert destination>>
 Departure time: <<insert departure time>> 
arrival time <<insert arrival time>> 
 Plane Information: Aircraft : <<insert make>> <<insert model>> Capacity: ___ seats Pilot: _____
In the Flight class, define the following methods(overload) that will set the scheduled time for a flight: 
void schedule(String arrivalTime)
void schedule(String arrivalTime, String departureTime)



Implement a driver class (main method), called CCTAir that will do, as a minimum, the following:
 a. Declare and initialize a number of flights.(min 30)
 b. Add up to 5 new flights of your choice.(user input)
 c. Use the second version of the schedule method to set the time schedule for a flight.
 d. Use the first version of the schedule method to update the arrival time for a flight in the list. 
e. display all flights.
