# C07KerPlopGame_King_Harless
// Lucas King & Mason Harless
// C07A KerPlop Game

Character Legend for all pieces:
P - Player (you)
G - Gold (if you get two you will be able to escape the level)
R - Goat (a goat named Rupert who wanders around the map)
H - Hopper (can kill you if you are 1 square directly to the left or right)
T - Teleporter (if you can land on the teleporter you automatically escape to next level)
M - Clay Mine (will hurt if you land on it but can only hurt you once)
! - Caution sign (does nothing but add a "!" to the map)

Two Pieces that implement Moveable:
1. Goat - Will move in one direction until it hits the end of the map where it will change directions
2. Teleporter - Will move to a random free space on the game board
3. Hopper - Will hop in one direction until it hits the end of the map where it will change directions

Five Pieces that interact (extend Game Piece):
1. Goat - NONE
2. Clay Mine - HIT (same space)
3. Teleporter - ADVANCE (same space)
4. Gold = GET_POINT (same space)
5. Hopper = KILL (if player is on the space left or right)
