package tictactoe.setup.Computer;

import tictactoe.setup.TrisGrid;
import java.util.Random;

public class AIeasy implements AImove{

    @Override
    public void move(TrisGrid tris) {
        Random random = new Random();
        boolean botMove = false;

        while (!botMove) {
            int randomX = random.nextInt(3);
            int randomO = random.nextInt(3);

            if (tris.getEmptyCells() == 0) {
                break;
            }

            if (!(tris.determineIfAIMoveIsPossible(randomX, randomO))) {
                continue;
            }

            tris.nextAImove(tris.getNextSymbol(), randomX, randomO);
            botMove = true;
        }
        tris.addToSymbol();
    }
}