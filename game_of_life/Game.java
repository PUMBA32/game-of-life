package game_of_life;

public class Game {
	private int width;
	private int height;
	
	private int[][] board;
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		this.board = new int[width][height];
	}
	
	// Вывод игрового поля в консоль
	public void showBoard() {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if(this.board[x][y] == 0) {
					System.out.print(" ");
				}
				else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}
	
	// Клетка - жива
	public void setAlive(int x, int y) {
		this.board[x][y] = 1;
	}
	
	// Клетка - мертва
	public void setDead(int x, int y) {
		this.board[x][y] = 0;
	}
	
	// Подсчет кол-ва соседей
	public int countNighboors(int x, int y) {
		int count = 0;
		
		count += isAlive(x-1, y-1);
		count += isAlive(x, y-1);
		count += isAlive(x+1, y-1);
		
		count += isAlive(x-1, y);
		count += isAlive(x+1, y);
		
		count += isAlive(x-1, y+1);
		count += isAlive(x, y+1);
		count += isAlive(x+1, y+1);
		
		return count;
	}
	
	// Получение состояния клетки по x и y 
	public int isAlive(int x, int y) {
		if(x < 0 || x >= width) {
			return 0;
		}
		
		if(y < 0 || y >= height) {
			return 0;
		}
		
		return board[x][y];
	}
	
	// Игровой ход
	public void step() {
		int[][] new_board = new int[width][height];
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int aliveNighbours = countNighboors(x,y);
				
				if(isAlive(x,y) == 1) {
					if(aliveNighbours < 2) {
						new_board[x][y] = 0;
					}
					else if(aliveNighbours == 2 || aliveNighbours == 3) {
						new_board[x][y] = 1;
					}
					else if(aliveNighbours > 3) {
						new_board[x][y] = 0;
					}
				}
				else {
					if(aliveNighbours == 3) {
						new_board[x][y] = 1;
					}
				}
			}
		}	
		this.board = new_board;
	}
	
	// Очистка консоли
	public void cls() {
		System.out.print("\033[H\033[J");
	}
}
