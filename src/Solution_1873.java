import java.util.Arrays;
import java.util.Scanner;

public class Solution_1873 {
	static Tank tank;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT ; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] maps = new char[H][W];
			
			for (int j = 0; j < maps.length; j++) {
				String str = sc.next();
				for (int j2 = 0; j2 < maps[0].length; j2++) {
					maps[j][j2] = str.charAt(j2);
				}
			}
			int len = sc.nextInt();
			String order = sc.next();
			
			start(maps);
			for (int j = 0; j < order.length(); j++) {
				switch(order.charAt(j)) {
				case 'L': 
					if(tank.y - 1 >= 0 && maps[tank.x][tank.y - 1] =='.' ) {
						maps[tank.x][tank.y] = '.'; 
						tank.y = tank.y - 1 ;
					}
					tank.aim = '<';
					break;
				case 'R':
					if(tank.y + 1 < W && maps[tank.x][tank.y + 1] =='.' ) {
						maps[tank.x][tank.y] = '.'; 
						tank.y = tank.y + 1 ;
					}
					tank.aim = '>';
					break;
				case 'U':
					if(tank.x - 1 >= 0 && maps[tank.x - 1][tank.y] =='.' ) {
						maps[tank.x][tank.y] = '.'; 
						tank.x = tank.x - 1 ;
					}
					tank.aim = '^';
					break;
				case 'D':
					if(tank.x + 1 < H && maps[tank.x + 1][tank.y] =='.' ) {
						maps[tank.x][tank.y] = '.'; 
						tank.x = tank.x + 1 ;
					}
					tank.aim = 'v';
					break;
				case 'S':
					shoot(maps,tank.aim);
					break;
				}
				maps[tank.x][tank.y] = tank.aim; 
				
			}
			System.out.printf("#%d ",i);
			print(maps);
			
		}

	}
	public static void print(char[][] maps) {
		for (int j = 0; j < maps.length; j++) {
			for (int j2 = 0; j2 < maps[0].length; j2++) {
				System.out.print(maps[j][j2]);
			}
			System.out.println();
		}
	}
	public static void shoot(char[][] maps,char a) {
		switch(a) {
		case '^':
			for (int i = 1; i <= tank.x; i++) {
				if(maps[tank.x - i][tank.y] == '*') {
					maps[tank.x - i][tank.y] = '.';
					break;
				}
				else if(maps[tank.x - i][tank.y] == '#') {
					break;
				}
			}
			break;
		case 'v':
			for (int i = 1; i < maps.length - tank.x; i++) {
				if(maps[tank.x + i][tank.y] == '*') {
					maps[tank.x + i][tank.y] = '.';
					break;
				}
				else if(maps[tank.x + i][tank.y] == '#') {
					break;
				}
			}
			break;
		case '<':
			for (int i = 1; i <= tank.y; i++) {
				if(maps[tank.x][tank.y - i] == '*') {
					maps[tank.x][tank.y - i] = '.';
					break;
				}
				else if(maps[tank.x][tank.y - i] == '#') {
					break;
				}
			}
			break;
		case '>':
			for (int i = 1; i < maps[0].length - tank.y; i++) {
				if(maps[tank.x][tank.y + i] == '*') {
					maps[tank.x][tank.y + i] = '.';
					break;
				}
				else if(maps[tank.x][tank.y + i] == '#') {
					break;
				}
			}
			break;
		}
	}
	public static void start(char[][] c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				if(c[i][j] == '<') {
					tank = new Tank(i,j,'<');
				}
				if(c[i][j] == '>') {
					tank = new Tank(i,j,'>');
				}
				if(c[i][j] == '^') {
					tank = new Tank(i,j,'^');
				}
				if(c[i][j] == 'v') {
					tank = new Tank(i,j,'v');
				}
			}
		}
	}
}

class Tank{
	int x;
	int y;
	char aim;
	public Tank(int x, int y ,char a) {
		this.x = x;
		this.y = y;
		this.aim = a;
	}
}