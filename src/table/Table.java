package table;

import gameplay.Gameplay;

public class Table {
    private char[][] table = new char[3][3];

    public Table() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = '-';
            }
        }
    }

    public void outputTable() {
        for (int indexI = 0; indexI < 3; indexI++) {

            for (int indexJ = 0; indexJ < 3; indexJ++) {
                System.out.print("|");
                System.out.print(table[indexI][indexJ]); //System.out.print("-");
            }

            System.out.print("|");
            System.out.println();
        }
    }
    private void outputTable(Gameplay gameplay) {

        for(int index = 0; index < gameplay.getStepArrayList().size(); index++) {

            int i=Integer.parseInt(gameplay.getStepArrayList().get(index).getIndexI()) ;
            int j = Integer.parseInt(gameplay.getStepArrayList().get(index).getIndexJ());

            for (int indexI = 0; indexI < 3; indexI++) {

                for (int indexJ = 0; indexJ < 3; indexJ++) {
                    System.out.print("|");
                    System.out.print(table[i][j]); //System.out.print("-");
                }

                System.out.print("|");
                System.out.println();
            }
        }
    }

    public boolean checkTablePLayer1() {
        if (table[0][0] == 'X' &
                table[0][1] == 'X' &
                table[0][2] == 'X') {
            return true;
        }else if (table[1][0] == 'X' &
                table[1][1] == 'X' &
                table[1][2]== 'X') {
            return true;
        }else if (table[2][0] == 'X' &
                table[2][1] == 'X' &
                table[2][2] == 'X') {
            return true;
        }else if (table[0][0] == 'X' &
                table[1][0] == 'X' &
                table[2][0] == 'X') {
            return true;
        }if (table[0][1] == 'X' &
                table[1][1] == 'X' &
                table[2][1] == 'X') {
            return true;
        }if (table[0][2]== 'X' &
                table[1][2] == 'X' &
                table[2][2] == 'X') {
            return true;
        }if (table[0][0] == 'X' &
                table[1][1] == 'X' &
                table[2][2]== 'X') {
            return true;
        }if (table[0][2] == 'X' &
                table[1][1] == 'X' &
                table[2][0] == 'X') {
            return true;
        }
        return false;
    }

    public boolean checkTablePLayer2() {
        if (table[0][0] == '0' &
                table[0][1] == '0' &
                table[0][2] == '0') {
            return true;
        }else if (table[1][0] == '0' &
                table[1][1] == '0' &
                table[1][2]== '0') {
            return true;
        }else if (table[2][0] == '0' &
                table[2][1] == '0' &
                table[2][2] == '0') {
            return true;
        }else if (table[0][0] == '0' &
                table[1][0] == '0' &
                table[2][0] == '0') {
            return true;
        }if (table[0][1] == '0' &
                table[1][1] == '0' &
                table[2][1] == '0') {
            return true;
        }if (table[0][2]== '0' &
                table[1][2] == '0' &
                table[2][2] == '0') {
            return true;
        }if (table[0][0] == '0' &
                table[1][1] == '0' &
                table[2][2]== '0') {
            return true;
        }if (table[0][2] == '0' &
                table[1][1] == '0' &
                table[2][0] == '0') {
            return true;
        }
        return false;
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
