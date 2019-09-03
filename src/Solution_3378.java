import java.util.ArrayList;
import java.util.Scanner;

public class Solution_3378 {
	static int R,C,S;
	static ArrayList<Three> t;
	static RCS[] solve;
	static int[][] result;
	static int index;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ;i++) {
			int master = sc.nextInt();
			int I = sc.nextInt();
			String[] mstr = new String[master];
			String[] istr = new String[I];
			for (int j = 0; j < master; j++) {
				mstr[j] = sc.next();
			}
			for (int j = 0; j < I; j++) {
				istr[j] = sc.next();
			}
			
			solve = new RCS[8000];
			int index = 0;
			for (int r = 1; r < 21; r++) {
				for (int c = 1; c < 21; c++) {
					for (int s = 1; s < 21; s++) {
						solve[index++] = new RCS(r,c,s);
					}
				}
			}
			
			R = C = S = 0;
			Solve(mstr);
			ArrayList<RCS> real = new ArrayList<>();
			System.out.print("#"+i+" ");
			for (int s = 0; s < solve.length; s++) {
				if(solve[s].x != 0) {
					real.add(solve[s]);
				}
			}
			result = new int[real.size()][istr.length];
			index = 0;
			for (int j = 0; j < real.size(); j++) {
				R = real.get(j).x;
				C = real.get(j).y;
				S = real.get(j).z;
				Isolve(istr);
				index++;
			}
			
			for (int y = 0; y < result[0].length; y++) {
				for (int x = 1; x < result.length; x++) {
					if(result[x][y] != result[x-1][y]) {
						result[x][0] = -1;
						break;
					}
				}
			}
			
			
//출력부분 잘하면됨.			
			
			
		}
	}
	public static void Isolve(String[] str) {
		result[index][0] = 0;
		int a,b,c,d,e,f;
		a = b = c = d = e = f = 0;
		for (int i = 1; i < str.length; i++) {
			for (int j = 0; j < str[i-1].length(); j++) {
				switch(str[i-1].charAt(j)) {
				case '(':
					a++;
					break;
				case ')':
					b++;
					break;
				case '{':
					c++;
					break;
				case '}':
					d++;
					break;
				case '[':
					e++;
					break;
				case ']':
					f++;
					break;
				}
			}
			result[index][i] = (R * (a-b)) + (C * (c-d)) + (S * (e-f));
		}
	}
	public static void Solve(String[] str) {
		int point,a,b,c,d,e,f;
		a = b = c = d = e = f = 0;
		t = new ArrayList<>(); 
		
		for (int i = 1; i < str.length; i++) {
			point = 0;
			for (int j = 0; j < str[i].length(); j++) {
				if(str[i].charAt(j) == '.') {
					point++;
				}
				else {
					break;
				}
			}
			
			for (int j = 0; j < str[i-1].length(); j++) {
				switch(str[i-1].charAt(j)) {
				case '(':
					a++;
					break;
				case ')':
					b++;
					break;
				case '{':
					c++;
					break;
				case '}':
					d++;
					break;
				case '[':
					e++;
					break;
				case ']':
					f++;
					break;
				}
			}
			
			if(point > 0) {
				t.add(new Three(a-b,c-d,e-f,point));
			}
		}
		style();
	}
	public static void style() {
		for (int i = 0; i < t.size(); i++) {
			for (int j = 0; j < solve.length; j++) {
				if(solve[j].x != 0 && (solve[j].x*t.get(i).x) + (solve[j].y*t.get(i).y) + (solve[j].z*t.get(i).z) != t.get(i).point ) {
					solve[j].x = solve[j].y = solve[j].z = 0;
				}
			}
		}
	}
	static class Three{
		int x,y,z;
		int point;
		public Three(int x, int y, int z, int p) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.point = p;
		}
	}
	static class RCS{
		int x,y,z;
		public RCS(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public String toString() {
			return "RCS [x=" + x + ", y=" + y + ", z=" + z + "]";
		}
		
	}
}
