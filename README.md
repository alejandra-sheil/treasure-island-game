# Treasure Island 🏴‍☠️

An interactive command-line treasure hunt game written in Java. Navigate an 8×8 island grid, avoid obstacles, find the shovel, and dig up the hidden treasure — all through typed commands.

## How to Play

You start at the top-left corner of the map (position 0,0). Move around the island using text commands to find the shovel, then reach the treasure and dig it up to win. Watch out — you can't walk through trees or off the edge of the island into the ocean.

### Commands
- `up`, `down`, `left`, `right` — move around the map
- `pick` — pick up the shovel when you're on its tile
- `dig` — dig for treasure (you must have the shovel first)
- `quit` — end the game

### Map Key
- `.` — empty tile
- `T` — tree (obstacle you can't pass)
- `S` — shovel
- `X` — treasure

### How to Win
Find and `pick` up the shovel, then move to the treasure tile and `dig`. You need the shovel before digging will work.

## Concepts Used
- 2D arrays to represent the game map
- A game loop that runs until the player wins or quits
- State tracking (player position and whether the shovel has been collected)
- Conditional logic for movement, boundary detection, and obstacle collision
- Handling invalid input without crashing

## How to Run
1. Make sure you have Java installed (JDK 8 or higher).
2. Compile the program:
3.  Run it:
