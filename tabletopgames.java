package codes;

public class tabletopgames {
	public static int LENGTH = 10;
	public static int WIDTH = 10;
	public static int SHIPS[][] = new int[LENGTH][WIDTH];
	public static boolean SCAN[][] = new boolean[LENGTH][WIDTH];

	public static void displayShips() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++)
				System.out.print(SHIPS[x][y] + " ");
			System.out.println();
		}
	}

	public static int RNG(int min, int max) { // random number generator
		int random = (int) (Math.random() * (max - min + 1) + min);
		return random;
	}

	public static void displayScan() {// displays the array for the hits
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++)
				System.out.print(SCAN[x][y] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public static void randomScan() { // randomly pick spots on the grid and hit them.
		int count = 0;
		do {
			int x = RNG(0, 9);
			int y = RNG(0, 9);

			while (SCAN[x][y] == false) {
				SCAN[x][y] = true;
				count++;
			}
		} while (count < 50);

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

		//randomScan();
		// everyOther();
		displayScan();

	}
}
