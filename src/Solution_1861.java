import java.util.Scanner;
import java.util.Stack;

public class Solution_1861 {
	static int[][] maps;
	static Stack<Integer> stack;
	static int max;
	static int[] room;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ;i++) {
			int size = sc.nextInt();
			maps = new int[size][size];
			stack = new Stack<>();
			max = 1;
			room = new int[size*size + 1];
			
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					maps[j][k] = sc.nextInt();
				}
			}//맵 입력
			
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps.length; y++) {
					dfs(x,y);
				}
			}
			
			int maxIndex = 0;
			for (int j = 1; j < room.length; j++) {
				if(max == room[j]) {
					maxIndex = j;
					break;
				}
			}
			System.out.printf("#%d %d %d\n",i,maxIndex,max);
		}

	}
	public static void dfs(int x, int y) {
		stack.push(maps[x][y]);
		if(stack.size() >= max) {
			max = stack.size();
			room[stack.firstElement()] = max;
		}
		if(x-1 >= 0 && maps[x][y] + 1 == maps[x-1][y]) { //위
			dfs(x-1,y);
		}
		if(x+1 < maps.length && maps[x][y] + 1 == maps[x+1][y]) { //아래
			dfs(x+1,y);
		}
		if(y-1 >= 0 && maps[x][y] + 1 == maps[x][y-1]) { //왼쪽
			dfs(x,y-1);
		}
		if(y+1 < maps.length && maps[x][y] + 1 == maps[x][y+1]) { //오른쪽
			dfs(x,y+1);
		}
		
		stack.pop();
	}
}
