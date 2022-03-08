package game;

public class Table {
    private char[][] table = new char[3][3];

    public Table() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = '-';
            }
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
