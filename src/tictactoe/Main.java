package tictactoe;

import tictactoe.setup.Match;
import tictactoe.setup.TrisGrid;
import tictactoe.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        TrisGrid tris = new TrisGrid();
        Match partita = new Match(tris);
        UserInterface ui = new UserInterface(partita, tris);

        ui.start();
    }
}
