package game_of_life;

public class Main {
	public static void main(String[] args) {
		Game game = new Game(50, 50); // Создание игрового поля
		
		// Создание планера
		game.setAlive(3, 3);  // Создание клетки
		game.setAlive(4, 3);
		game.setAlive(5, 3);
		game.setAlive(5, 2);
		game.setAlive(4, 1);
		
		
		while(true) {
			game.step();  // игровой ход
			game.showBoard();  // отображение доски
			game.cls();  // очистка консоли
		}
	}
}
