package tictactoe.setup;

import java.util.Arrays;

public class TrisGrid {
    final protected String[][] trisGrid;
    private int nextSymbol;
    private int rowX;
    private int rowO;
    private int colX;
    private int colO;
    private int diagonalLeftToRightX;
    private int diagonalLeftToRightO;
    private int diagonalRightToLeftX;
    private int diagonalRightToLeftO;
    private int emptyCells = 0;
    private boolean isNearToTrisX;
    private boolean isNearToTrisO;

    public TrisGrid() {
        this.trisGrid = new String[3][3];
    }

    public void setGrid() {
        for (String[] griglia : trisGrid) {
            Arrays.fill(griglia, " ");
        }
    }

    public void printGrid() {
        System.out.println("---------");
        for (String[] strings : trisGrid) {
            System.out.print("| ");
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    public int getEmptyCells() {
        return emptyCells;
    }

    public boolean isNearToTrisX() {
        return isNearToTrisX;
    }

    public boolean isNearToTrisO() {
        return isNearToTrisO;
    }

    public int getNextSymbol() {
        return nextSymbol;
    }

    public void addToSymbol() {
        nextSymbol++;
    }

    public void resetValueOfSymbol() {
        nextSymbol = 0;
    }

    public static int convertCoordinates(int y) {
        return y == 3 ? 0 : y == 2 ? 1 : 2;
    }

    public boolean determineIfHumanMoveIsPossible(int x, int convertiY) {
        return trisGrid[convertiY][x - 1].equals(" ");
    }

    public boolean determineIfAIMoveIsPossible(int x, int o) {
        return trisGrid[x][o].equals(" ");
    }

    public void nextPlayerMove(int symbol, int x, int convertiY) {
        if (symbol % 2 == 0) {
            trisGrid[convertiY][x - 1] = "X";
        } else {
            trisGrid[convertiY][x - 1] = "O";
        }
    }

    public void nextAImove(int symbol, int x, int o) {
        if (symbol % 2 == 0) {
            trisGrid[x][o] = "X";
        } else {
            trisGrid[x][o] = "O";
        }
    }

    public void invertSymbol(int symbol, int x, int o) {
        if (symbol % 2 == 0) {
            trisGrid[x][o] = "O";
        } else {
            trisGrid[x][o] = "X";
        }
    }

    public void resetCell(int x, int o) {
        trisGrid[x][o] = " ";
    }

    public boolean checkTrisX() {
        return colX != 3 && rowX != 3 && diagonalLeftToRightX != 3 && diagonalRightToLeftX != 3;
    }

    public boolean checkTrisO() {
        return colO != 3 && rowO != 3 && diagonalLeftToRightO != 3 && diagonalRightToLeftO != 3;
    }

    public void checkTris() {
        isNearToTrisO = false;
        isNearToTrisX = false;
        colX = 0;
        colO = 0;
        rowX = 0;
        rowO = 0;
        diagonalRightToLeftO = 0;
        diagonalLeftToRightO = 0;
        diagonalRightToLeftX = 0;
        diagonalLeftToRightX = 0;
        emptyCells = 0;

        for (int i = 0; i < trisGrid.length; i++) {
            colX = 0;
            colO = 0;
            rowX = 0;
            rowO = 0;

            for (int j = 0; j < trisGrid[i].length; j++) {
                if (i == j && trisGrid[i][j].equals("X")) {
                    diagonalLeftToRightX++;
                } else if (i == j && trisGrid[i][j].equals("O")) {
                    diagonalLeftToRightO++;
                }

                if (i + j == 2 && trisGrid[i][j].equals("X")) {
                    diagonalRightToLeftX++;
                } else if (i + j == 2 && trisGrid[i][j].equals("O")) {
                    diagonalRightToLeftO++;
                }

                if (trisGrid[i][j].equals("X")) {
                    rowX++;
                } else if (trisGrid[i][j].equals("O")) {
                    rowO++;
                }

                if (trisGrid[j][i].equals("X")) {
                    colX++;
                } else if (trisGrid[j][i].equals("O")) {
                    colO++;
                }

                if (trisGrid[i][j].equals(" ")) {
                    emptyCells++;
                }
            }

            if (rowO == 3 || rowX == 3 || colO == 3 || colX == 3) {
                break;
            }

            if (getNextSymbol() % 2 == 0) {
                if (rowX == 2 || colX == 2 || diagonalRightToLeftX == 2 || diagonalLeftToRightX == 2) {
                    isNearToTrisX = true;
                    isNearToTrisO = false;
                }
                if (rowO == 2 || colO == 2 || diagonalRightToLeftO == 2 || diagonalLeftToRightO == 2) {
                    isNearToTrisO = true;
                    isNearToTrisX = false;
                }
            } else {
                if (rowO == 2 || colO == 2 || diagonalRightToLeftO == 2 || diagonalLeftToRightO == 2) {
                    isNearToTrisO = true;
                    isNearToTrisX = false;
                }
                if (rowX == 2 || colX == 2 || diagonalRightToLeftX == 2 || diagonalLeftToRightX == 2) {
                    isNearToTrisX = true;
                    isNearToTrisO = false;
                }
            }
        }
    }

    public void finalResult() {
        if (rowO == 3 || colO == 3 || diagonalLeftToRightO == 3 || diagonalRightToLeftO == 3) {
            System.out.println("O wins");
        } else if (rowX == 3 || colX == 3 || diagonalLeftToRightX == 3 || diagonalRightToLeftX == 3) {
            System.out.println("X wins");
        } else {
            System.out.println("Draw");
        }
    }
}