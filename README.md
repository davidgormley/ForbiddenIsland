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

## Reading the Map
When viewing the map in-game, each tile is presented in a 3x4-char format:

    |1234| <- Numbers indicate which players are on a given tile (corresponding to play order)
    | FL | <- Acronyms correspond to the names of each tile (listed below)
    |D  T| <- lower left shows tile flood state (D=Dry,F=Flooded); 
              lower right indicates whether a treasure can be captured here

## Map Legend

Code | Tile Name
------------ | -------------
BB | Breaker's Bridge
BG | Bronze Gate
CA | Cliffs of Abandon
CE | Cave of Embers
CF | Crimson Forest
CG | Copper Gate
CP | Coral Palace
CS | Cave of Shadows
DD | Dunes of Deception
FL | Fool's Landing
GG | Gold Gate
HG | Howling Garden
IG | Iron Gate
LL | Lost Lagoon
MM | Misty Marsh
OB | Observatory
PR | Phantom Rock
SG | Silver Gate
TM | Temple of the Moon
TP | Tidal Palace
TS | Temple of the Sun
TW | Twilight Hollow
WG | Whispering Garden
WT | Watchtower
