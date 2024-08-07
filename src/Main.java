
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        // Выводим игровое поле
        while (!game.getWinner()) {
            game.displayBoard();
            // Доступна ли клетка
            game.go();
        }
    }
}