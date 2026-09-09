import java.util.Scanner;

// Treasure Island: Design (interactive command)
// create variables
public class TreasureIsland {

    public static void main(String[] args) {
        // variablres
        Scanner scnr = new Scanner(System.in);
        // Map size between 7x7 and 10x10 rows
        final int rows_Map = 8;
        final int colums_Map = 8;

        // define obstacles
        final char emp_Ty = '.';
        final char tree_Obstacle = 'T'; 
        // add mound too and the shovel
        final char shovel = 'S';
        final char treasure = 'X'; 

      // add obstacles and initials for shovel, treasure
        char[][] map = {
            //   0    1    2    3    4    5    6    7   (Columns)
                {'.', '.', '.', '.', 'T', '.', '.', '.'}, // Row 0
                {'T', '.', '.', '.', '.', '.', '.', '.'}, // Row 1
                {'.', '.', 'T', '.', 'S', '.', '.', '.'}, // Row 2 (Shovel at 2,4)
                {'.', '.', '.', '.', '.', '.', 'T', '.'}, // Row 3
                {'.', '.', '.', '.', '.', 'T', '.', '.'}, // Row 4
                {'.', 'T', '.', '.', '.', '.', '.', 'X'}, // Row 5 (Treasure at 5,7)
                {'.', '.', '.', '.', '.', '.', '.', 'T'}, // Row 6
                {'.', '.', '.', 'T', '.', '.', '.', '.'}  // Row 7
        };
        /* Map Key:
           . = Empty tile
           T = Tree (Obstacle)
           S = Shovel
           X = Treasure
         */

        // wirte variables, boolean and string comamand 
        int player_Row = 0; // Start at (0, 0)
        int player_Col = 0;
        boolean getShovel = false;
        boolean gameOver = false;
        String command = "";

        System.out.println("Welcome to the Colombian Treasure Island!");
        System.out.println("Your goal is to find the treasure while avoiding the obstacles.Good luck!");
        System.out.println("Commands: up, down, left, right, pick, dig, quit");
        System.out.println("You are starting at location (0, 0).");

        // game start (loop)
        while (!gameOver) {
            System.out.print("Enter command: ");
            command = scnr.next();

         // start if-else staments
            if (command.equals("quit")) {
                gameOver = true;
                System.out.println("Game over");

            } else if (command.equals("up") || command.equals("down") ||
                       command.equals("left") || command.equals("right")) {

                int next_Row = player_Row;
                int next_Colum = player_Col;

                //use branchs
                if (command.equals("up")) {
                    next_Row = player_Row - 1;
                } else if (command.equals("down")) {
                    next_Row = player_Row + 1;
                } else if (command.equals("left")) {
                    next_Colum = player_Col - 1;
                } else if (command.equals("right")) {
                    next_Colum = player_Col + 1;
                }

                // write conditions
                if (next_Row < 0 || next_Row >= rows_Map ||
                next_Colum < 0 || next_Colum >= colums_Map) {
                    System.out.println("You cannot go there because of the ocean.");
                } else {
                    
                    char next_Tile = map[next_Row][next_Colum];

                    if (next_Tile == tree_Obstacle) {
                        System.out.println("You cannot go there because of a tree.");
                    //other obsatacle
                    } else {

                        player_Row = next_Row;
                        player_Col = next_Colum;
                        System.out.println("You moved " + command + ". You are now at location (" + player_Row + ", " + player_Col + ").");

                        char currentTile = map[player_Row][player_Col];
                        if (currentTile == shovel) {
                            System.out.println("There is a shovel at this location. Use 'pick' to get it.");
                        } else if (currentTile == treasure) {
                            System.out.println("Oh! It seems like you found something. Let's dig...");
                        } else if (currentTile == emp_Ty){
                            System.out.println("Nothing seems out of place here.");
                        }
                    }
                }

            } else if (command.equals("pick")) {
             
                if (map[player_Row][player_Col] == shovel) {
                    if (!getShovel) {
                        getShovel = true;
                        map[player_Row][player_Col] = emp_Ty; 
                        System.out.println("You got the shovel.");
                    } else {
                        System.out.println("You already have a shovel.");
                    }
                } else {
                    System.out.println("There is nothing to get here.");
                }

            } else if (command.equals("dig")) {
        
                if (getShovel) {
                
                    if (map[player_Row][player_Col] == treasure) {
                        System.out.println("Congratulations, you got the treasure! You won!");
                        gameOver = true; 
                    } else {
                        System.out.println("It looks your hardwork was not fruitfull.");
                    }
                } else {
                    System.out.println("You need a shovel to dig.");
                }

            } else {
            // if user input something wrong
                System.out.println("Invalid command. Available commands: up, down, left, right, pick, dig, quit");
            }

        }
        scnr.close();
        System.out.println("Game Over.");
    }
}