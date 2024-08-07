import java.util.Scanner;

public class Game {
    // символ текущего игрока 'X' или 'O'
    char currentPlayer = 'X';
    // создание игрового поля
    char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    // для вывода игрового поля в консоль
    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println("\n+----+----+----+");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + "   "); // Добавлено пространство перед и после символа
            }
        }
        System.out.println("\n+----+----+----+");
    }


    // для проверки, является ли ход игрока допустимым (т.е. клетка пуста).
    // +ход игроков
    public void go() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        int i = scanner.nextInt() - 1;
        System.out.print("Введите столбец: ");
        int j = scanner.nextInt() - 1;

        try {
            if (board[i][j] == ' ') {
                board[i][j] = currentPlayer;
                switchPlayer();
            } else {
                System.out.println("Клетка занята");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.fillInStackTrace();
            System.out.println("\nВведите числа от 1 до 3!");
        }

    }

    // Переключение текущего игрока
    public void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    // для определения победителя. Возвращает символ игрока,
    // который выиграл, или ' ' в случае ничьей.
    public boolean getWinner() {
        // Check for horizontal wins
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                System.out.println("Выиграл игрок " + board[i][0] + "!");
                return true; // Stop the game if a winner is found
            }
        }

        // Check for vertical wins
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                System.out.println("Выиграл игрок " + board[0][j] + "!");
                return true; // Stop the game if a winner is found
            }
        }

        // Check for diagonal wins
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            System.out.println("Выиграл игрок " + board[0][0] + "!");
            return true; // Stop the game if a winner is found
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            System.out.println("Выиграл игрок " + board[0][2] + "!");
            return true; // Stop the game if a winner is found
        }

        // Check for a draw (full board)
        boolean fullBoard = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    fullBoard = false;
                    break;
                }
            }
        }
        if (fullBoard) {
            System.out.println("Ничья!");
            return true; // Stop the game if it's a draw
        }

        return false; // No winner yet, continue the game
    }

}
