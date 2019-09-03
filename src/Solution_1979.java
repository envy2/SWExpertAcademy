import java.util.Scanner;

public class Solution_1979 {
	static int[] dx = {1,0};
	static int[] dy = {0,1};
	//0 아래 1 오른쪽
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = sc.nextInt();
		
		for (int i = 0; i < tcase; i++) {
			int size = sc.nextInt();
			int len = sc.nextInt();
			count = 0;
			
			int[][] list = new int[size][size];
			int[][] zero = new int[size+(len*2)][size+(len*2)];
			for (int x = 0; x < size; x++) {
				for (int y = 0; y < size; y++) {
					list[x][y] = sc.nextInt();
				}
			}
			
			for (int x = len; x < size+len; x++) {
				for (int y = len; y < size+len; y++) {
					zero[x][y] = list[x-len][y-len];
				}
			}
			
			print(zero);
			row(zero,size,len);
			col(zero,size,len);
			
			System.out.printf("#%d %d\n",i+1,count);
		}

	}
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void col(int[][] arr,int size,int len) {
		boolean check = false;
	
		for (int x = len-1; x < size+len; x++) {
			for (int y = len-1; y < size+len; y++) {
				if(arr[x][y] == 0) {
					int xs = x+dx[0];
					int ys = y+dy[0];
					for (int z = 0; z < len; z++) {
						if(arr[xs][ys] == 1) {
							xs += dx[0];
							ys += dy[0];
							check = true;
							
						}
						else {
							check = false;
							break;
						}
					}
					if(arr[xs][ys] == 0 && check) {
						count++;
					}
				}
				
			}
		}
	}
	public static void row(int[][] arr,int size , int len) {
		boolean check = false;
		for (int x = len-1; x < size+len; x++) {
			for (int y = len-1; y < size+len; y++) {
				if(arr[x][y] == 0) {
					int xs = x+dx[1];
					int ys = y+dy[1];
					for (int z = 0; z < len; z++) {
						if(arr[xs][ys] == 1) {
							xs += dx[1];
							ys += dy[1];
							check = true;
							
						}
						else {
							check = false;
						}
					}
					if(arr[xs][ys] == 0 && check) {
						count++;
					}
				}
				
			}
		}
	}

}
