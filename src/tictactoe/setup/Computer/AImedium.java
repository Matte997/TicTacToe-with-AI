package tictactoe.setup.Computer;

import tictactoe.setup.TrisGrid;
import java.util.Random;

public class AImedium {
    private final Random random = new Random();
    private boolean attack;
    private boolean defense;

    public void move(TrisGrid tris) {
         if (tris.isNearToTrisX() || tris.isNearToTrisO()){
             mediumMove(tris);
         }

        if (!attack && !defense) {
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
        }
        tris.addToSymbol();
    }

    public void mediumMove(TrisGrid tris) {
        if (tris.getNextSymbol() % 2 == 0) {
            if (tris.isNearToTrisX()) {
                aiAttacks(tris);
            } else {
                aiDefends(tris);
            }
        } else {
            if (tris.isNearToTrisO()) {
                aiAttacks(tris);
            } else {
                aiDefends(tris);
            }
        }
    }

    public void aiAttacks(TrisGrid tris) {
        attack = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (attack) {
                    break;
                }

                if (!tris.determineIfAIMoveIsPossible(i, j)) {
                    continue;
                }

                tris.nextAImove(tris.getNextSymbol(), i, j);
                tris.checkTris();

                if (tris.checkTrisO() && tris.checkTrisX()) {
                    tris.resetCell(i, j);
                    continue;
                }

                tris.nextAImove(tris.getNextSymbol(), i, j);
                attack = true;
            }

            if (attack) {
                break;
            }
        }
    }

    public void aiDefends(TrisGrid tris) {
        defense = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (defense) {
                    break;
                }

                if (!tris.determineIfAIMoveIsPossible(i, j)) {
                    continue;
                }

                tris.invertSymbol(tris.getNextSymbol(), i, j);
                tris.checkTris();

                if (tris.checkTrisO() && tris.checkTrisX()) {
                    tris.resetCell(i, j);
                    continue;
                }

                tris.nextAImove(tris.getNextSymbol(), i, j);
                defense = true;
            }

            if (defense) {
                break;
            }
        }
    }
}
