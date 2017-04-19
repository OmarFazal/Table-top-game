package codes;

public class tabletopgames {
	public static int LENGTH = 10;
	public static int WIDTH = 10;
	public static int SHIPS[][] = new int[LENGTH][WIDTH];
	public static boolean SCAN[][] = new boolean[LENGTH][WIDTH];

	/*public static void displayShips() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++)
				System.out.print(SHIPS[x][y] + " ");
			System.out.println();
		}
	}*/

	public static int RNG(int min, int max) { //random number generator
		int random = (int) (Math.random() * (max - min + 1) + min);
		return random;
	}

	public static void displayScan() {//displays the array for the hits
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++)
				System.out.print(SCAN[x][y] + " ");
			System.out.println();
		}
	}
	public static void randomScan(){ // randomly pick spots on the grid and hit them.
		int x = RNG(0,9);
		int y = RNG(0,9);
		SCAN[x][y] = true;
	}

	public static void main(String[] args) {
		//displayShips();
		displayScan();
		randomScan();
		System.out.println();
		displayScan();
	
	}
}
