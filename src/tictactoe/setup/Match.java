package tictactoe.setup;

import tictactoe.setup.Computer.AIeasy;
import tictactoe.setup.Computer.AImedium;
import tictactoe.setup.Player.HumanPlayer;

public class Match {
    private final TrisGrid tris;

    public Match(TrisGrid tris) {
        this.tris = tris;
        tris.setGrid();
    }

    public void userVsAIeasy() {
        do {
            setUser();
            setEasyBot();
        } while (tris.checkTrisO() && tris.checkTrisX() && tris.getEmptyCells() != 0);
    }

    public void userVsUser() {
        do {
            setUser();
        } while (tris.checkTrisO() && tris.checkTrisX() && tris.getEmptyCells() != 0);
    }

    public void AIeasyVsAIeasy() {
        do {
            setEasyBot();
        } while (tris.checkTrisO() && tris.checkTrisX() && tris.getEmptyCells() != 0);
    }

    public void AIeasyVsUser() {
        do {
            setEasyBot();
            if (!tris.checkTrisX() || !tris.checkTrisO()) {
                break;
            }
            setUser();
        } while (tris.checkTrisO() && tris.checkTrisX() && tris.getEmptyCells() != 0);
    }

    public void AImediumVsAImedium() {
        do {
            setMediumBot();
        } while (tris.checkTrisO() && tris.checkTrisX() && tris.getEmptyCells() != 0);
    }

    public void userVsAImedium() {
        do {
            setUser();
            if (!tris.checkTrisX() || !tris.checkTrisO()) {
                break;
            }
            setMediumBot();
        } while (tris.checkTrisO() && tris.checkTrisX() && tris.getEmptyCells() != 0);
    }

    public void AImediumVsUser() {
        do {
            setMediumBot();
            if (!tris.checkTrisX() || !tris.checkTrisO()) {
                break;
            }
            setUser();
        } while (tris.checkTrisO() && tris.checkTrisX() && tris.getEmptyCells() != 0);
    }

    protected void setUser() {
        HumanPlayer player = new HumanPlayer();
        tris.checkTris();
        player.userPlay(tris);
        tris.printGrid();
        tris.checkTris();
    }

    protected void setEasyBot() {
        AIeasy AIeasy = new AIeasy();
        System.out.println("Making move level \"easy\"");
        tris.checkTris();
        AIeasy.move(tris);
        tris.printGrid();
        tris.checkTris();
    }

    protected void setMediumBot() {
        AImedium AImedium = new AImedium();
        System.out.println("Making move level \"medium\"");
        tris.checkTris();
        AImedium.move(tris);
        tris.printGrid();
        tris.checkTris();
    }
}