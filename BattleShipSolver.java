package codes;

public class BattleShipSolver {

	public static int LENGTH = 10;
	public static int WIDTH = 10;
	public static int SHIPS[][] = new int[LENGTH][WIDTH];
	public static boolean SCAN[][] = new boolean[LENGTH][WIDTH];

	public static void displayShips() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++)
				System.out.print(SHIPS[y][x] + " ");
			System.out.println();
		}
	}
	
	public static int shipHitHorizontal(int y, int x, int count){
			count = count + hitShipRight(y,x,count);
			if(SHIPS[y][x] != 0){
				count = count + hitShipLeft(y,x,count);
			}
			return count;
	}
	
	public static int shipHitVertical(int y, int x, int count){
		count = count + hitShipUp(y,x,count);
		if(SHIPS[y][x] != 0){
			count = count + hitShipDown(y,x,count);
		}
		return count;
}

	public static int hitShipUp(int y, int x, int count) {
		while (SHIPS[y][x] != 0) {
			if (y-1 < 0) {
				break;
			}
			y--;
			SCAN[y][x] = true;
			count++;
		}
		return count;
	}

	public static int hitShipDown(int y, int x, int count) {
		while (SHIPS[y][x] != 0) {
			if (y+1 > 9) {
				break;
			}
			y++;
			SCAN[y][x] = true;
			count++;
		}
		return count;
	}

	public static int hitShipLeft(int y, int x, int count) {
		while (SHIPS[y][x] != 0) {
			if (x-1 < 0) {
				break;
			}
			x--;
			SCAN[y][x] = true;
			count++;
		}
		return count;
	}

	public static int hitShipRight(int y, int x, int count) {
		while (SHIPS[y][x] != 0) {
			if (x+1 > 9) {
				break;
			}
			x++;
			SCAN[y][x] = true;
			count++;
		}
		return count;
	}

	public static int RNG(int min, int max) { // random number generator
		int random = (int) (Math.random() * (max - min + 1) + min);
		return random;
	}

	public static void displayScan() {// displays the array for the hits
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++)
				System.out.print(SCAN[y][x] + " ");
			System.out.println();
		}
		System.out.println();
	}
	

	public static void randomScan() { // randomly pick spots on the grid and hit
										// them.
		int count = 0;
		do{
			int x = RNG(0, 9);
			int y = RNG(0, 9);
			if (SCAN[y][x] == false) {
				SCAN[y][x] = true;
				count++;
			}
			if(SHIPS[y][x] != 0){
				count = count + shipHitHorizontal(y,x,count);
			}
			if(SHIPS[y][x] != 0){
				count = count + shipHitVertical(y,x,count);
			} 
		displayScan();
		displayShips();
		}while (count < 20);
		
	}

	public static void everyOther() { // hits every other plot in the grid
		for (int y = 0; y < 10; y = y + 2) {
			for (int x = 0; x < 10; x = x + 2) {
				SCAN[y][x] = true;
			}
		}
		for (int y = 1; y < 10; y = y + 2) {
			for (int x = 1; x < 10; x = x + 2) {
				SCAN[y][x] = true;
			}
		}
	}

	public static void main(String[] args) {
		SHIPS[4][4] = 2;
		SHIPS[4][5] = 2;
		SHIPS[4][3] = 2;
		SHIPS[5][4] = 2;
		SHIPS[3][4] = 2;
		
		randomScan();
		//everyOther();
		displayShips();
		displayScan();

	}
}
