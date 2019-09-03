import java.util.Scanner;

public class Solution_1868 {
	static char[][] mine;
	static int size;
	static char[][] maps;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ; i++) {
			size = sc.nextInt();
			mine = new char[size][size];
			maps = new char[size][size];
			
			for (int x = 0; x < mine.length; x++) {
				String str = sc.next();
				for (int y = 0; y < mine.length; y++) {
					mine[x][y] = str.charAt(y);
				}
			}
			for (int x = 0; x < mine.length; x++) {
				for (int y = 0; y < mine.length; y++) {
					if(mine[x][y] == '.') {
						if(check8(x,y)) {
							maps[x][y] = 'a';
						}
						else {
							maps[x][y] = 'b';
						}
					}
					else {
						maps[x][y] = 'c';
					}
				}
			}
			int click = 0;
			
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps.length; y++) {
					if(maps[x][y] == 'a') {
						click++;
						clicked(x,y);
					}
				}
			}
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps.length; y++) {
					if(maps[x][y] == 'b') {
						click++;
						
					}
				}
			}
			System.out.printf("#%d %d\n",i,click);
			
		}

	}
	public static void clicked(int x, int y) {
		maps[x][y] = 'c';
		if(x - 1 >= 0 && maps[x-1][y] == 'b') {
			maps[x-1][y] = 'c';
		}
		if(x + 1 < size && maps[x+1][y] == 'b' ) {
			maps[x+1][y] = 'c';
		}
		if(y - 1 >= 0 && maps[x][y-1] == 'b') {
			maps[x][y-1] = 'c';
		}
		if(y + 1 < size && maps[x][y+1] == 'b' ) {
			maps[x][y+1] = 'c';
		}
		if(x - 1 >= 0 && y - 1 >= 0 && maps[x-1][y-1] == 'b') {
			maps[x-1][y-1] = 'c';
		}
		if(x + 1 < size && y - 1 >= 0 && maps[x+1][y-1] == 'b' ) {
			maps[x+1][y-1] = 'c';
		}
		if(x - 1 >= 0 && y + 1 < size && maps[x-1][y+1] == 'b') {
			maps[x-1][y+1] = 'c';
		}
		if(x + 1 < size && y + 1 < size && maps[x+1][y+1] == 'b' ) {
			maps[x+1][y+1] = 'c';
		}
		
		if(x - 1 >= 0 && maps[x-1][y] == 'a') {
			clicked(x-1,y);
		}
		if(x + 1 < size && maps[x+1][y] == 'a' ) {
			clicked(x+1,y);
		}
		if(y - 1 >= 0 && maps[x][y-1] == 'a') {
			clicked(x,y-1);
		}
		if(y + 1 < size && maps[x][y+1] == 'a' ) {
			clicked(x,y+1);
		}
		if(x - 1 >= 0 && y - 1 >= 0 && maps[x-1][y-1] == 'a') {
			clicked(x-1,y-1);
		}
		if(x + 1 < size && y - 1 >= 0 && maps[x+1][y-1] == 'a' ) {
			clicked(x+1,y-1);
		}
		if(x - 1 >= 0 && y + 1 < size && maps[x-1][y+1] == 'a') {
			clicked(x-1,y+1);
		}
		if(x + 1 < size && y + 1 < size && maps[x+1][y+1] == 'a' ) {
			clicked(x+1,y+1);
		}
		
	}
	public static boolean check8(int x, int y) {
		if(x - 1 >= 0 && mine[x-1][y] != '.') {
			return false;
		}
		if(x + 1 < size && mine[x+1][y] != '.' ) {
			return false;
		}
		if(y - 1 >= 0 && mine[x][y-1] != '.') {
			return false;
		}
		if(y + 1 < size && mine[x][y+1] != '.' ) {
			return false;
		}
		if(x - 1 >= 0 && y - 1 >= 0 && mine[x-1][y-1] != '.') {
			return false;
		}
		if(x + 1 < size && y - 1 >= 0 && mine[x+1][y-1] != '.' ) {
			return false;
		}
		if(x - 1 >= 0 && y + 1 < size && mine[x-1][y+1] != '.') {
			return false;
		}
		if(x + 1 < size && y + 1 < size && mine[x+1][y+1] != '.' ) {
			return false;
		}
		return true;
	}
}
