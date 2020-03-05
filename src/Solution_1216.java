import java.util.Scanner;

public class Solution_1216 {
	static char[][] maps;
	static int result;

	public static void init(Scanner sc) {
		sc.nextInt();

		maps = new char[100][100];
		result = 1;

		for (int i = 0; i < maps.length; i++) {
			maps[i] = sc.next().toCharArray();
		}

		palindrome();
	
	}
	
	public static void palindrome() {
		for (int x = 0; x < maps.length; x++) {
			for (int y = 0; y < maps.length; y++) {
				for (int z = maps.length - y; z > result; z--) {
					if(horizontal(x, y, z)) {
						result = z;
					}
				}
				for (int z = maps.length - x; z > result; z--) {
					if(vertical(x, y, z)) {
						result = z;
					}
				}
			}
		}
	}
	
	public static boolean horizontal(int x, int y, int length) {
		boolean check = true;

		for (int i = 0; i < length; i++) {
			if (maps[x][y + i] != maps[x][y + length - i - 1]) {
				check = false;
				break;
			}
		}

		return check;

	}

	public static boolean vertical(int x, int y, int length) {
		boolean check = true;

		for (int i = 0; i < length; i++) {
			if (maps[x + i][y] != maps[x + length - i - 1][y]) {
				check = false;
				break;
			}
		}

		return check;
	}

	public static void print() {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps.length; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			init(sc);
			System.out.println("#"+ tc + " "+result);
		}

	}

}
