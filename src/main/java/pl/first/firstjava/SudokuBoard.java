package pl.first.firstjava;

import java.util.Random;

public class SudokuBoard {

    private int[][] board;
    public static final int size = 9;
    final private SudokuSolver sudokuSolver;
    public SudokuBoard(SudokuSolver sudokuSolver) {
        this.board = new int[size][size];
        this.sudokuSolver = sudokuSolver;

    }

    public void solveGame(){

        sudokuSolver.solve(this);

    }

    public int get(int x, int y) {
        return board[x][y];
    }

    public void set(int x, int y, int value) {
        this.board[x][y] = value;
    }

    boolean checkLine(int line, int number) {
        for (int i = 0; i < size; i++)
            if (board[line][i] == number)
                return true;

        return false;
    }

    boolean checkColumn(int column, int number) {
        for (int i = 0; i < size; i++)
            if (board[i][column] == number)
                return true;

        return false;
    }

    boolean whichbox(int line, int column, int number) {
        int l = line - line % 3;
        int c = column - column % 3;

        for (int i = l; i < l + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;

        return false;
    }


    boolean checkOK(int line, int column, int number) {
        return !checkLine(line, number)  &&  !checkColumn(column, number)  &&  !whichbox(line, column, number);
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


//    public static void main (String[] args) {
//
//
//
//        SudokuBoard sudoku = new SudokuBoard();
//        System.out.println("Zainicjowane samymi zerami");
//        sudoku.show();
//
//
//        if (sudoku.fillBoard()) {
//            System.out.println("Po wykonaniu algorytmu");
//            sudoku.show();
//        } else {
//            System.out.println("Błąd !!!");
//        }
//    }


}



