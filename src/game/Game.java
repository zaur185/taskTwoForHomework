package game;

import player.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    private Table table;
    File reportFile;

    private Player player1 = new Player("Tom");
    private Player player2 = new Player("Jerry");

    public int iTable = 0;
    public int jTable = 0;

    public Game() throws IOException {
        reportFile = new File("Report.txt");
        reportFile.createNewFile();
    }

    public void gameStarted() {
        table=new Table();
        Scanner in = new Scanner(System.in);

        for (int i = 1; i <= 9; i++) {
            if (i % 2 != 0) System.out.println(player1.getName() + " сделайте свой ход");
            else if (i % 2 == 0) System.out.println(player2.getName() + " сделайте свой ход");

            do{
                System.out.println("значение по вертикали ");
                iTable = in.nextInt();
                System.out.println("значение по горизонтали ");
                jTable = in.nextInt();
                if(iTable>=3 || jTable>=3){
                    System.out.println("значения выходят за рамки поля,введите еще раз");
                }
            }while(iTable>=3 || jTable>=3);



            if (i % 2 != 0) {
                table.setTable(iTable, jTable, 'X');
                outputTable();
            } else if (i % 2 == 0) {
                table.setTable(iTable, jTable, '0');
                outputTable();
            }

            boolean checkWins=false;

            if(checkTablePLayer1()){
                player1.setWins(true);
                checkWins=true;
                System.out.println("выграл"+player1.getName());
            }else if (checkTablePLayer2()){
                player2.setWins(true);
                checkWins=true;
                System.out.println("выграл"+player2.getName());
            }

            if(checkWins==true){
                System.out.println("хотите сыграть еще раз?");
                System.out.println("1-да");
                System.out.println("0-нет");
                int value = in.nextInt();
                if(value==0){
                 writeReport();
                 break;
                }else if(value==1){
                    gameStarted();
                    break;
                }
            }
        }


    }

    private void outputTable() {
        for (int indexI = 0; indexI < 3; indexI++) {

            for (int indexJ = 0; indexJ < 3; indexJ++) {
                System.out.print("|");
                System.out.print(table.getTable(indexI, indexJ)); //System.out.print("-");
            }

            System.out.print("|");
            System.out.println();
        }
    }

    public boolean checkTablePLayer1() {
        if (table.getTable(0, 0) == 'X' &
                table.getTable(0, 1) == 'X' &
                table.getTable(0, 2) == 'X') {
            return true;
        }else if (table.getTable(1, 0) == 'X' &
                table.getTable(1, 1) == 'X' &
                table.getTable(1, 2) == 'X') {
            return true;
        }else if (table.getTable(2, 0) == 'X' &
                table.getTable(2, 1) == 'X' &
                table.getTable(2, 2) == 'X') {
            return true;
        }else if (table.getTable(0, 0) == 'X' &
                table.getTable(1, 0) == 'X' &
                table.getTable(2, 0) == 'X') {
            return true;
        }if (table.getTable(0, 1) == 'X' &
                table.getTable(1, 1) == 'X' &
                table.getTable(2, 1) == 'X') {
            return true;
        }if (table.getTable(0, 2) == 'X' &
                table.getTable(1, 2) == 'X' &
                table.getTable(2, 2) == 'X') {
            return true;
        }if (table.getTable(0, 0) == 'X' &
                table.getTable(1, 1) == 'X' &
                table.getTable(2, 2) == 'X') {
            return true;
        }if (table.getTable(0, 2) == 'X' &
                table.getTable(1, 1) == 'X' &
                table.getTable(2, 0) == 'X') {
            return true;
        }
        return false;
    }

    public boolean checkTablePLayer2() {
        if (table.getTable(0, 0) == '0' &
                table.getTable(0, 1) == '0' &
                table.getTable(0, 2) == '0') {
            return true;
        }else if (table.getTable(1, 0) == '0' &
                table.getTable(1, 1) == '0' &
                table.getTable(1, 2) == '0') {
            return true;
        }else if (table.getTable(2, 0) == '0' &
                table.getTable(2, 1) == '0' &
                table.getTable(2, 2) == '0') {
            return true;
        }else if (table.getTable(0, 0) == '0' &
                table.getTable(1, 0) == '0' &
                table.getTable(2, 0) == '0') {
            return true;
        }if (table.getTable(0, 1) == '0' &
                table.getTable(1, 1) == '0' &
                table.getTable(2, 1) == '0') {
            return true;
        }if (table.getTable(0, 2) == '0' &
                table.getTable(1, 2) == '0' &
                table.getTable(2, 2) == '0') {
            return true;
        }if (table.getTable(0, 0) == '0' &
                table.getTable(1, 1) == '0' &
                table.getTable(2, 2) == '0') {
            return true;
        }if (table.getTable(0, 2) == '0' &
                table.getTable(1, 1) == '0' &
                table.getTable(2, 0) == '0') {
            return true;
        }
        return false;
    }

    public void writeReport(){
        try {
            FileWriter fw = new FileWriter(reportFile,true);

            fw.write(player1.getName()+" кол-во побед "+player1.getWins()+"||");
            fw.write(player2.getName()+" кол-во побед "+player2.getWins());
            fw.write("\n");

            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
