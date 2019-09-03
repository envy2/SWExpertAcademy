import java.util.Scanner;

public class Solution_1824 {
	static Memory memory;
	static char[][] maps;
	static boolean res;
	static boolean[][][][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			maps = new char[row][col];
			memory = new Memory(0,0,0,'>');
			res = false;
			visit = new boolean[row][col][16][4];
			
			for (int x = 0; x < row; x++) {
				String line = sc.next();
				for (int y = 0; y < col; y++) {
					maps[x][y] = line.charAt(y);
				}
			}
			check(memory.x,memory.y,memory.m,maps[memory.x][memory.y]);
			if(res) {
				System.out.printf("#%d YES\n",i);
			}
			else {
				System.out.printf("#%d NO\n",i);
			}
		}
	}
	public static int distance(char c) {
		int ret = 0;
		switch(c) {
		case '<':
			ret = 1;
		case '>':
			ret = 2;
		case '^':
			ret = 3;
		case 'v':
			ret = 0;
		}
		return ret;
	}
	public static void moving(int x, int y , int m , char d) {
		if(!visit[x][y][m][distance(d)]) {
			visit[x][y][m][distance(d)] = true;
		}
		else {
			return;
		}
		switch(d) {
		case '<':
			if(y - 1 >= 0) {
				y -= 1;
				check(x,y,m,maps[x][y]);
			}
			else {
				return;
			}
			break;
		case '>':
			if(y + 1 < maps[0].length) {
				y += 1;
				check(x,y,m,maps[x][y]);
			}
			else {
				return;
			}
			break;
		case '^':
			if(x - 1 >= 0) {
				x -= 1;
				check(x,y,m,maps[x][y]);
			}
			else {
				return;
			}
			break;
		case 'v':
			if(x +1 < maps.length) {
				x += 1;
				check(x,y,m,maps[x][y]);
			}
			else {
				return;
			}
			break; 
		}
		
	}
	public static void check(int x, int y , int m,char c) {
		switch(c) {
		case '<':
			c = '<';
			break;
		case '>':
			c = '>';
			break;
		case '^':
			c = '^';
			break;
		case 'v':
			c = 'v';
			break;
		case '_':
			if(m == 0) {
				c = '>';
			}
			else {
				c = '<';
			}
			break;
		case '|':
			if(m == 0) {
				c = 'v';
			}
			else {
				c = '^';
			}
			break;
		case '?':
			moving(x,y,m,'<');
			moving(x,y,m,'>');
			moving(x,y,m,'v');
			moving(x,y,m,'^');
			break;
		case '.':
			break;
		case '@':
			res = true;
			return;
		case '+':
			if(m == 15) {
				m = 0;
			}
			else {
				m += 1;
			}
			break;
		case '-':
			if(m == 0) {
				m = 15;
			}
			else {
				m -= 1;
			}
			break;
		default :
			m = c - '0';
			break;
		}
		moving(x,y,m,c);
		
	}
	static class Memory{
		int x,y,m;
		char dis;
		public Memory(int x, int y, int m,char d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.dis = d;
		}
	}
}
