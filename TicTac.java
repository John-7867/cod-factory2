package gr.aueb.cf.chTest;

import java.util.Scanner;

public class TicTac {

    public static void main(String[] args) {
        char [] board = {'1','2','3',
                         '4','5','6',
                         '7','8','9'};
        var timer = 0;
        var currentPlayer = 'X';
        var gameMessage = "Out of moves: Draw!";

        while (timer < 9) {
            printTheBoard(board);
            do {
                try {
                    System.out.printf("Player %s choose a square by typing its number  ", currentPlayer);
                    var scanner = new Scanner(System.in);
                    var input = scanner.nextInt();
                    if (board[input - 1] < 9){
                    board[input - 1] = currentPlayer;
                    break;
                    } else {
                        System.out.println("That place is taken!");
                    }
                }catch (Exception e) {
                    System.out.println("Something is wrong. Choose different number");
                }
            } while (true);

//            0 | 1 | 2
//            3 | 4 | 5
//            6 | 7 | 8

            if ( (board[0] == currentPlayer) && (board[1] == currentPlayer) && (board[2] == currentPlayer)
              || (board[3] == currentPlayer) && (board[4] == currentPlayer) && (board[5] == currentPlayer)
              || (board[6] == currentPlayer) && (board[7] == currentPlayer) && (board[8] == currentPlayer)
              || (board[0] == currentPlayer) && (board[3] == currentPlayer) && (board[6] == currentPlayer)
              || (board[1] == currentPlayer) && (board[4] == currentPlayer) && (board[7] == currentPlayer)
              || (board[2] == currentPlayer) && (board[5] == currentPlayer) && (board[8] == currentPlayer)
              || (board[0] == currentPlayer) && (board[4] == currentPlayer) && (board[8] == currentPlayer)
              || (board[2] == currentPlayer) && (board[4] == currentPlayer) && (board[6] == currentPlayer)){
                printTheBoard(board);
                gameMessage = "Congratulations, You Won!";
                break;
            } else {
                timer++;
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }

        }

        System.out.println(gameMessage);
    }

    public static void printTheBoard(char[] board) {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }
}
