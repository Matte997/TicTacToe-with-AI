package tictactoe.setup.Player;

import tictactoe.setup.TrisGrid;

import java.util.Scanner;
import static tictactoe.setup.TrisGrid.convertCoordinates;

public class HumanPlayer implements Player{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void userPlay(TrisGrid tris) {
        boolean userMove = false;

        while (!userMove) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();

            if (input.matches("\\D+")) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (input.matches("\\d+\\s*")) {
                System.out.println("Coordinates must be two numbers from 1 to 3 separated by space!");
                continue;
            }

            String[] userInput = input.split(" ");

            if (userInput.length > 2) {
                System.out.println("You should output only two numbers!");
                continue;
            }

            int x = Integer.parseInt(userInput[0]);
            int o = Integer.parseInt(userInput[1]);

            if (x > 3 || o > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (tris.getEmptyCells() == 0) {
                break;
            }

            if (!(tris.determineIfHumanMoveIsPossible(x, convertCoordinates(o)))) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                tris.nextPlayerMove(tris.getNextSymbol(), x, convertCoordinates(o));
                userMove = true;
            }
            tris.addToSymbol();
        }
    }
}
