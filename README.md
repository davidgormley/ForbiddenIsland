# Software Engineering Project - Forbidden Island

## Project Overview
Design and implement the Forbidden Island game. Objective of the game is to work cooperatively with the other players to keep Forbidden Island from sinking, in order to buy enough time to capture its four treasures. Once you have captured them, you must make it to Fools’ Landing and escape by helicopter to win.

## Team Members
* David Gormley
* Owen Ryan-Hanbury
* Srinithi Ramprasad

## Game Components
* 4 Treasures
* 24 Island Tiles
* 4 Pawns
* Treasure Deck
* Flood Deck
* Water Meter

## Game Rules
The number of players should range from 2 to 4. Each Player can have a role: Engineer, Explorer, Diver, Pilot, Messenger, Navigator. Depending on his/her role, a player’s pawn will be placed initially on a specific Island tile. The Engineer will be placed on Bronze Gate, the Explorer will be placed on Copper Gate, the Diver will be placed on Iron Gate, the Pilot will be placed on Fools’ Landing, the Messenger will be placed on Silver Gate, and the Navigator will be placed on Gold Gate.

Each player in turn should perform the following three things in order:
1. Take up to 3 Actions (could also be 0, 1, or 2)
2. Draw 2 cards from the Treasure Deck
3. Draw a number of Flood cards equal to the Water level


## Game Setup
1. Create the Forbidden Island
2. The Island Starts to Sink
3. Assign a Role to each player
4. Hand out treasure cards
5. Set the water level


## Design Considerations
* Each tile needs a variable for a flooded and unflooded side.
* DG: Do we need more than one class to represent all the players?
* DG: How do we handle special abilities for more than one class type?
* DG: There are 4 pawns, each of them assigned to a player. Should they be added in to a player class or as part of game logic?
