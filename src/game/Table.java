package game;

import java.util.ArrayList;

public class Table {
    private char[][] table = new char[3][3];

    public Table() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = '-';
            }
        }
    }

    void outputTable() {
        for (int indexI = 0; indexI < 3; indexI++) {

            for (int indexJ = 0; indexJ < 3; indexJ++) {
                System.out.print("|");
                System.out.print(table[indexI][indexJ]); //System.out.print("-");
            }

            System.out.print("|");
            System.out.println();
        }
    }
    private void outputTable(ArrayList<Step> gameplay) {


        for (int indexI = 0; indexI < 3; indexI++) {

            for (int indexJ = 0; indexJ < 3; indexJ++) {
                System.out.print("|");
                //System.out.print(table; //System.out.print("-");
            }

            System.out.print("|");
            System.out.println();
        }
    }

    public void setTable(int i, int j, char value) {
        if ((value == 'X' || value == '0') & (i < 3 & j < 3)) {
            table[i][j] = value;
        }
    }

    public char[][] getTable() {
        return table;
    }

    public char getTable(int i, int j) {
        return table[i][j];
    }
}
