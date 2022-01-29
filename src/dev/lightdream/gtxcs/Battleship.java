package dev.lightdream.gtxcs;

import java.util.Scanner;

public class Battleship {

    public static char[][] map1 = new char[5][5];
    public static char[][] map1_attack = new char[5][5];
    public static char[][] map2 = new char[5][5];
    public static char[][] map2_attack = new char[5][5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");

        prepareMaps();

        System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");
        for (int i = 1; i <= 5; i++) readShip(i, 1, scanner);
        printBattleShip(map1);

        System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");
        for (int i = 1; i <= 5; i++) readShip(i, 2, scanner);
        printBattleShip(map2);

        boolean player1 = true;
        do {
            attack(player1, scanner);
            if (checkMap(player1)) {
                System.out.println("PLAYER " + (player1 ? "1" : "2") + " WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                break;
            }

            player1 = !player1;
        } while (true);
        formatFinalBoard();
    }

    private static void formatFinalBoard() {
        char[][] m1 = new char[5][5];
        char[][] m2 = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                m1[i][j] = '-';
                m2[i][j] = '-';
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map1[i][j] != '-') {
                    m1[i][j] = map1[i][j];
                }
                if (map2_attack[i][j] != '-') {
                    m1[i][j] = map2_attack[i][j];
                }
                if (map2[i][j] != '-') {
                    m2[i][j] = map2[i][j];
                }
                if (map1_attack[i][j] != '-') {
                    m2[i][j] = map1_attack[i][j];
                }
            }
        }

        System.out.println("Final boards:\n");

        printBattleShip(m1);
        printBattleShip(m2);
    }

    private static boolean checkMap(boolean player1) {
        int cnt = 0;

        if (player1) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map1_attack[i][j] == 'X') {
                        cnt++;
                    }
                }
            }

        } else {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map2_attack[i][j] == 'X') {
                        cnt++;
                    }
                }
            }
        }
        return cnt == 5;
    }

    private static void attack(boolean player1, Scanner scanner) {
        System.out.println("Player " + (player1 ? "1" : "2") + ", enter hit row/column:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a >= 5 || b >= 5) {
            System.out.println("Invalid coordinates. Choose different coordinates.");
            attack(player1, scanner);
            return;
        }
        if (player1) {
            if (map1_attack[a][b] != '-') {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                attack(player1, scanner);
                return;
            }
            if (map2[a][b] == '@') {
                System.out.println("PLAYER 1 HIT PLAYER 2’s SHIP!");
                map1_attack[a][b] = 'X';

            } else {
                System.out.println("PLAYER 1 MISSED!");
                map1_attack[a][b] = 'O';
            }
            printBattleShip(map1_attack);
        } else {
            if (map2_attack[a][b] != '-') {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                attack(player1, scanner);
                return;
            }
            if (map1[a][b] == '@') {
                System.out.println("PLAYER 2 HIT PLAYER 1’s SHIP!");
                map2_attack[a][b] = 'X';
            } else {
                System.out.println("PLAYER 2 MISSED!");
                map2_attack[a][b] = 'O';
            }
            printBattleShip(map2_attack);
        }

    }

    private static void prepareMaps() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map1[i][j] = '-';
                map1_attack[i][j] = '-';
                map2[i][j] = '-';
                map2_attack[i][j] = '-';
            }
        }
    }

    private static void readShip(int index, int map, Scanner scanner) {
        System.out.println("Enter ship " + index + " location:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a >= 5 || b >= 5) {
            System.out.println("Invalid coordinates. Choose different coordinates.");
            readShip(index, map, scanner);
            return;
        }
        if (map == 1) {
            if (map1[a][b] == '@') {
                System.out.println("You already have a ship there. Choose different coordinates.");
                readShip(index, map, scanner);
                return;
            }
            map1[a][b] = '@';
        } else {
            if (map2[a][b] == '@') {
                System.out.println("You already have a ship there. Choose different coordinates.");
                readShip(index, map, scanner);
                return;
            }
            map2[a][b] = '@';
        }
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}