import java.util.Scanner;

public class Solution_5644 {
	static Battery[][] maps;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int Asum,Bsum;
	static People pa,pb;
	public static void main(String[] args) {
		//지도 가로 세로 10
		//사용자는 2명 (1,1) (10,10)
		//총 이동시간 20 <= M <= 100
		//충전기 개수는 1<= A <= 8
		// 충전 범위는 1<= C <= 4
		//충전기 성능 10 <= P <= 500 짝수
		//초기위치 0부터 충전가능
		//AB가 같은 위치로 이동하는 경우 존재
		//0    1 2 3 4 
		//제자리 상 우 하 좌
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1 ; i <= iT ; i++) {
			maps = new Battery[10][10];
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps[0].length; y++) {
					maps[x][y] = new Battery(0, 0);
				}
			}
			int M = sc.nextInt();
			int A = sc.nextInt();
			
			pa = new People(0, 0);
			pb = new People(9, 9);
			
			int[] Amove = new int[M];
			int[] Bmove = new int[M];
			
			for (int j = 0; j < Amove.length; j++) {
				Amove[j] = sc.nextInt();
			}
			for (int j = 0; j < Bmove.length; j++) {
				Bmove[j] = sc.nextInt();
			}

			for (int j = 0; j < A; j++) {
				Charge(sc.nextInt()-1,sc.nextInt()-1,sc.nextInt(),sc.nextInt());
			}
			Asum = Bsum = 0;
			
			
			for (int m = 0; m < Bmove.length; m++) {
				AMoving(Amove[m]);
				BMoving(Bmove[m]);
				
			}
			
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps[0].length; y++) {
					System.out.print(maps[x][y]);
				}
				System.out.println();
			}
		}
		

	}
	public static void AMoving(int m) {
		switch(m) {
		case 0:
			break;
		case 1:
			pa.x--;
			break;
		case 2:
			pa.y++;
			break;
		case 3:
			pa.x++;
			break;
		case 4:
			pa.y--;
			break;
		}
	}
	public static void BMoving(int m) {
		switch(m) {
		case 0:
			break;
		case 1:
			pb.x--;
			break;
		case 2:
			pb.y++;
			break;
		case 3:
			pb.x++;
			break;
		case 4:
			pb.y--;
			break;
		}
	}
	public static void Charge(int y, int x, int range, int power) {
		maps[x][y].B1 = power;
		for(int r = 1 ; r <= range ; r++) {
			for (int i = 0; i < dx.length; i++) {
				if(x + (dx[i]*r) >= 0 && y + (dy[i]*r) >= 0 && x + (dx[i]*r) < maps.length && y + (dy[i]*r) < maps.length) {
					if(maps[x+(dx[i]*r)][y+(dy[i]*r)].B1 != 0) {
						if(maps[x+(dx[i]*r)][y+(dy[i]*r)].B1 > power) {
							maps[x+(dx[i]*r)][y+(dy[i]*r)].B2 = power;
						}
						else {
							maps[x+(dx[i]*r)][y+(dy[i]*r)].B2 = maps[x+(dx[i]*r)][y+(dy[i]*r)].B1;
							maps[x+(dx[i]*r)][y+(dy[i]*r)].B1 = power;
						}
					}
					else {
						maps[x+(dx[i]*r)][y+(dy[i]*r)].B1 = power;
					}
				}
			}
		}
	}
	static class People{
		int x,y;
		public People(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Battery{
		int B1,B2;
		public Battery(int b1,int b2) {
			this.B1 = b1;
			this.B2 = b2;
		}
		@Override
		public String toString() {
			return "[B1=" + B1 + ", B2=" + B2 + "]";
		}
		
	}
}
