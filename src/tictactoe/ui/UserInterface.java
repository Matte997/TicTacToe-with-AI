package tictactoe.ui;

import tictactoe.setup.Match;
import tictactoe.setup.TrisGrid;
import java.util.Scanner;

public class UserInterface {
    final protected Match match;
    final protected TrisGrid trisResult;
    final protected Scanner scanner = new Scanner(System.in);

    public UserInterface(Match match, TrisGrid tris) {
        this.trisResult = tris;
        this.match = match;
    }

    public void start() {
        while (true) {
            trisResult.setGrid();
            System.out.print("Input command: ");
            String inputChoose = scanner.nextLine();

            if ("exit".equals(inputChoose)) {
                break;
            }
            String[] splitInput = inputChoose.split(" ");

            if (splitInput.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }
            trisResult.printGrid();

            switch (inputChoose) {
                case "start easy easy":
                    match.AIeasyVsAIeasy();
                    break;
                case "start easy user":
                    match.AIeasyVsUser();
                    break;
                case "start user easy":
                    match.userVsAIeasy();
                    break;
                case "start user user":
                    match.userVsUser();
                    break;
                case "start medium medium":
                    match.AImediumVsAImedium();
                    break;
                case "start user medium":
                    match.userVsAImedium();
                    break;
                case "start medium user":
                    match.AImediumVsUser();
                    break;
                default:
                    System.out.println("Error in typo, retry");
                    continue;
            }
            trisResult.resetValueOfSymbol();
            trisResult.finalResult();
        }
    }
}