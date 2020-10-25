package pl.first.firstjava;

import java.util.Random;

public class SudokuBoard {

    private int[][] board;
    public static final int size = 9;
    public SudokuBoard() {
        this.board = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }




    private boolean checkLine(int line, int number) {
        for (int i = 0; i < size; i++)
            if (board[line][i] == number)
                return true;

        return false;
    }


    private boolean checkColumn(int column, int number) {
        for (int i = 0; i < size; i++)
            if (board[i][column] == number)
                return true;

        return false;
    }


    private boolean whichbox(int line, int column, int number) {
        int l = line - line % 3;
        int c = column - column % 3;

        for (int i = l; i < l + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;

        return false;
    }


    private boolean checkOK(int line, int column, int number) {
        return !checkLine(line, number)  &&  !checkColumn(column, number)  &&  !whichbox(line, column, number);
    }

    public boolean fillBoard() {
        Random rand = new Random();
        for (int line = 0; line < size; line++) {
            for (int column = 0; column < size; column++) {

                if (board[line][column] == 0) {



                    int R=rand.nextInt(9) + 1;
                    for (int z = 1; z <= size; z++) {
                        int number=(R+z)%size+1;


                        if (checkOK(line, column, number)) {

                            board[line][column] = number;

                            if (fillBoard()) {
                                return true;
                            } else {
                                board[line][column] = 0;
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }


    public void show() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + board[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }
    public int getField(int x,int y){
        return board[y][x];
    }

    public static void main (String[] args) {



        SudokuBoard sudoku = new SudokuBoard();
        System.out.println("Zainicjowane samymi zerami");
        sudoku.show();


        if (sudoku.fillBoard()) {
            System.out.println("Po wykonaniu algorytmu");
            sudoku.show();
        } else {
            System.out.println("Błąd !!!");
        }
    }


}




