package pl.first.firstjava;


public class SudokuBoard {

    public static final int size = 9;
    //private int[][] board = new int[size][size];
    private SudokuField[][] board = new SudokuField[size][size];

    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = new SudokuField();

            }

        }
    }

    private SudokuSolver sudokuSolver = new BacktrackingSudokuSolver();


    public void solveGame() {
        sudokuSolver.solve(this);

    }


    public int get(int x, int y) {

        return board[y][x].getFieldValue();
    }

    public void set(int x, int y, int value) {

        this.board[y][x].setFieldValue(value);
    }


    public SudokuRow getRow(int y) {
        SudokuField [] field = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            field[i] = new SudokuField(get(y,i));
        }
        SudokuRow row = new SudokuRow(field);
        return row;
    }


    public SudokuBox getBox(int x, int y) {
        SudokuField [] box = new SudokuField[9];
        int l = y - y % 3;
        int c = x - x % 3;
        int index = 0;
        for (int i = l; i < l + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                box[index++] = new SudokuField(board[i][j]);
            }
        }
        return new SudokuBox(box);
    }



    public SudokuColumn getColumn(int x) {
        SudokuField [] field = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            field[i] = new SudokuField(get(i,x));
        }
        SudokuColumn column = new SudokuColumn(field);
        return column;
    }


    //
    //    boolean checkLine(int line, int number) {
    //        for (int i = 0; i < size; i++) {
    //            if (board[line][i] == number) {
    //                return true;
    //            }
    //        }
    //        return false;
    //    }
    //
    //    boolean checkColumn(int column, int number) {
    //        for (int i = 0; i < size; i++) {
    //            if (board[i][column] == number) {
    //                return true;
    //            }
    //        }
    //        return false;
    //    }
    //
    //    boolean whichbox(int line, int column, int number) {
    //        int l = line - line % 3;
    //        int c = column - column % 3;
    //
    //        for (int i = l; i < l + 3; i++) {
    //            for (int j = c; j < c + 3; j++) {
    //                if (board[i][j] == number) {
    //                    return true;
    //                }
    //            }
    //        }
    //        return false;
    //  }



    private boolean checkBoard() {
        for (int i = 0; i < 9; i++) {
            if (!(getColumn(i).verify() && getRow(i).verify())) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!(getBox(i,j).verify())) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkOK(int y, int x, int number) {
        if (getRow(y).tryValue(number).verify() && checkBoard()) {
            if (getColumn(x).tryValue(number).verify()) {
                if (getBox(x,y).tryValue(number).verify()) {
                        return true;
                }
            }

        }
        return false;
    }



    //    public void show() {
    //        for (int i = 0; i < size; i++) {
    //            for (int j = 0; j < size; j++) {
    //                System.out.print(" " + board[i][j].getFieldValue());
    //            }
    //
    //            System.out.println();
    //        }
    //
    //        System.out.println();
    //    }

    //    public static void main (String[] args) {
    //
    //
    //
    //        SudokuBoard sudoku = new SudokuBoard();
    //        System.out.println("Zainicjowane samymi zerami");
    //        sudoku.show();
    //
    //
    //        if (sudoku.sudokuSolver.solve(sudoku)) {
    //            System.out.println("Po wykonaniu algorytmu");
    //            sudoku.show();
    //        } else {
    //            System.out.println("Błąd !!!");
    //        }
    //  }

}



