package game;

import gameplay.Gameplay;
import player.Player;
import table.Table;
import testcase.WriterHistory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    private Table table;
    File reportFile;
    Gameplay gameplay = new Gameplay();
    WriterHistory writerHistory = new WriterHistory();

    private Player player1 = new Player("Tom");
    private Player player2 = new Player("Jerry");

    public int iTable = 0;
    public int jTable = 0;

    public Game() throws IOException {
        reportFile = new File("Report.txt");
        reportFile.createNewFile();
    }

    public void gameStarted() {
        table = new Table();
        Scanner in = new Scanner(System.in);

        for (int i = 1; i <= 9; i++) {
            if (i % 2 != 0) System.out.println(player1.getName() + " сделайте свой ход");
            else if (i % 2 == 0) System.out.println(player2.getName() + " сделайте свой ход");

            do {
                System.out.println("значение по вертикали ");
                iTable = in.nextInt();
                System.out.println("значение по горизонтали ");
                jTable = in.nextInt();
                if (i % 2 != 0) gameplay.addStep( iTable, jTable, 1);
                else if (i % 2 == 0) gameplay.addStep(iTable, jTable, 2);

                if (iTable >= 3 || jTable >= 3) {
                    System.out.println("значения выходят за рамки поля,введите еще раз");
                }
            } while (iTable >= 3 || jTable >= 3);


            if (i % 2 != 0) {
                table.setTable(iTable, jTable, 'X');
                table.outputTable();
            } else if (i % 2 == 0) {
                table.setTable(iTable, jTable, '0');
                table.outputTable();
            }

            boolean checkWins = false;

            if (table.checkTablePLayer1()) {
                player1.setWins(true);
                checkWins = true;
                System.out.println("выграл" + player1.getName());
            } else if (table.checkTablePLayer2()) {
                player2.setWins(true);
                checkWins = true;
                System.out.println("выграл" + player2.getName());
            }

            if (checkWins == true) {
                System.out.println("хотите сыграть еще раз?");
                System.out.println("1-да");
                System.out.println("0-нет");
                int value = in.nextInt();
                if (value == 0) {
                   writerHistory.createGameplaySource(gameplay);
                    break;
                } else if (value == 1) {
                    gameStarted();
                    break;
                }
            }
        }


    }


}
