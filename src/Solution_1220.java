import java.util.Scanner;

public class Solution_1220 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = 10;
		for(int i = 1 ; i <= iT ; i++) {
			int size = sc.nextInt();
			
			int[][] maps = new int[size][size];
			for (int j = 0; j < maps.length; j++) {
				for (int j2 = 0; j2 < maps.length; j2++) {
					maps[j][j2] = sc.nextInt();
				}
			}
			boolean Ncheck = false;
			int res = 0;
			for (int x = 0; x < maps.length; x++) {
				Ncheck = false;
				for (int y = 0; y < maps.length; y++) {
					if(maps[y][x] == 1) {
						Ncheck = true;
					}
					if(maps[y][x] == 2 && Ncheck) {
						Ncheck = false;
						res++;
					}
				}
			}
			System.out.printf("#%d %d\n",i,res);
		}

	}

}
