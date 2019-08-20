Software Development Academic Project.


Project Title: Pokemon Hotel

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


The Project:  Pokemon Hotel
You are the owner of a prestigious Pokemon Hotel. Your hotel has received a request to host a group of 80 pokemon, you must determine how many of this group you can accommodate.
Program setup:
You must generate the 80 Pokemon.
Pokemon are split into the following categories:
Land / Air / Water
Land: Normal / Grass / Fighting / poison / Ground / Rock / Steel
Air : Fire / Electric / Flying / Psychic / Bug / Ghost / Dragon / Fairy
Water : Water / Ice / Dark

Each Pokemon has the following properties:
Name :  randomly selected (supplied .txt file of names)
Genetic stamp: (unique identifier)
Type : randomly selected (supplied .txt file of 18 types)
Special attack rating : randomly generated. (from 5 to 15)
Speed rating : randomly generated. (from 5 to 15)
Expert level: randomly generated. (from 1 to 10)





You must generate 100 rooms, each room can hold one guest, each room has the following properties:
Room number: (must be unique)
Resistance rating : randomly generated number (from 3 to 7) (must be greater than The Pokemon guest’s special attack plus speed rating divided by 3 to allow a Pokemon to stay in the room)
Guest:

Your hotel supplies personal assistants for Pokemon. Generate 20 personal assistants. Each personal assistant has the following (but not limited to) properties:
Name: 
Expert level: Randomly generated from 1 to 6 (must be greater than or equal to the Pokemon expert level).
Pokemon type : max of two (limited to 2 types of Pokemon, randomly assigned)
Pokemon guests : max of 5. (limited to 5 Pokemon)

Your program is required to determine how many Pokemon can stay at your hotel. This is based on the room suitability and the availability of suitable personal assistants.
Your program is required to:
 output the Pokemon group seeking rooms.
output the total of the Pokemon group your hotel can accommodate.
Output the Pokemon group your hotel can accommodate.
output the Pokemon group your hotel cannot accommodate.

Output the Personal assistants and their assigned Pokemon, the category they belong to and their room numbers.
Allow a user to view a particular room and see:
The Pokemon staying there and their assigned assistant.
Allow a user to search for a particular Genetic stamp and view:
The Pokemon
It’s room
It’s personal assistant
Output any un-assigned personal assistants
Output any un-occupied rooms