import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1258 {
	static ArrayList<UN> un = new ArrayList<>();
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= iT ; i++) {
			int size = Integer.parseInt(br.readLine());
			int[][] maps = new int[size][size];
			visit = new boolean[size][size];
			
			for (int j = 0; j < size; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < size; k++) {
					maps[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps.length; y++) {
					if(maps[x][y] != 0) {
						CheckSize(maps, x, y);
					}
				}
			}
			
			Collections.sort(un, new SSort());
			System.out.printf("#%d %d ",i,un.size());
			for(UN a : un) {
				System.out.printf("%d %d ",a.row,a.col);
			}
			System.out.println();
			un.clear();
		}
	}
	static class SSort implements Comparator<UN>{

		@Override
		public int compare(UN o1, UN o2) {
			if(o1.size > o2.size) {
				return 1;
			}
			else if( o1.size == o2.size) {
				if(o1.row > o2.row) {
					return 1;
				}
				else if( o1.row == o2.row ) {
					return 0;
				}
				else {
					return -1;
				}
			}
			else {
				return -1;
			}
		}

		
	}
	public static void CheckSize(int[][] maps,int x, int y) {
		if(visit[x][y]) {
			return;
		}
		int col = 0;
		int row = 0;
		for (int i = x; i < maps.length; i++) {
			if(maps[i][y] > 0) {
				row++;
			}
			else {
				break;
			}
		}
		for (int i = y; i < maps.length; i++) {
			if(maps[x][i] > 0) {
				col++;
			}
			else {
				break;
			}
		}
		
		for (int i = x; i < x+row; i++) {
			for (int j = y; j < y+col; j++) {
				visit[i][j] = true;
			}
		}
		un.add(new UN(row,col,row*col));
	}

}
class UN{
	int row;
	int col;
	int size;
	public UN(int r, int c, int s) {
		this.row = r;
		this.col = c;
		this.size = s;
	}
	@Override
	public String toString() {
		return "UN [col=" + col + ", row=" + row + ", size=" + size + "]";
	}
	
}