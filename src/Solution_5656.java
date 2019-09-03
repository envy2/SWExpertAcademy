import java.util.Scanner;

public class Solution_5656 {
	static int min;
	static int W,H;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ;i++) {
			int N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			int[][] maps = new int[H][W];
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps[0].length; y++) {
					maps[x][y] = sc.nextInt();
				}
			}
			
			
			
			min = Integer.MAX_VALUE;
			
			Drop(N,maps);
			System.out.println(min);
		}

	}
	public static void press(int[][] copy) { 
		for(int i=H-1; i>=0; i--) { 
			for(int j=0; j<W; j++) {
				if(copy[i][j]==0) { 
					for(int k=i; k>=0; k--) {
						if(copy[k][j]!=0) { 
							copy[i][j] = copy[k][j];
							copy[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}

	public static void Drop(int n,int[][] maps) {
		if(n == 0) {
			int count = 0;
			for (int i = 0; i < maps.length; i++) {
				for (int j = 0; j < maps[0].length; j++) {
					if(maps[i][j] != 0) {
						count++;
					}
				}
			}
			min = Math.min(count, min);
			return;
		}
		for(int j=0; j<W; j++) { 
			int[][] tmp = new int[H][W];
			deepCopy(maps, tmp);
			
			for(int i=0; i<H; i++) { 
				if(tmp[i][j]!=0) { 
					Boom(i, j,tmp);
					break;
				}
			}
			press(tmp);
			Drop(n-1,tmp); 
		}		

		
		
	}
	static void deepCopy(int[][] arr, int[][] tmp){
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
	}

	public static int[][] Boom(int x, int y, int[][] maps) {
		int size = maps[x][y];
		maps[x][y] = 0;
		for (int i = x; i < x + size; i--) {
			if(i >= 0 && i < maps.length) {
				if(maps[i][y] > 1) {
					Boom(i,y,maps);
				}
				
				maps[i][y] = 0;
			}
		}
		for (int i = x + size - 1; i >= x; i--) {
			if(i >= 0 && i < maps.length) {
				if(maps[i][y] > 1) {
					Boom(i,y,maps);
				}
				
				maps[i][y] = 0;
			}
		}
		for (int i = y; i < y + size; i--) {
			if(i >= 0 && i < maps[0].length) {
				if(maps[x][i] > 1) {
					Boom(x,i,maps);
				}
				
				maps[x][i] = 0;
			}
		}
		for (int i = y + size - 1; i >= y; i--) {
			if(i >= 0 && i < maps[0].length) {
				if(maps[x][i] > 1) {
					Boom(x,i,maps);
				}
				
				maps[x][i] = 0;
			}
		}
		return maps;
	}
}
