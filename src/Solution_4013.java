import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4013 {
	static ArrayList<Integer> m1,m2,m3,m4;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1 ;i<= iT ; i++) {
			int K = sc.nextInt();
			m1 = new ArrayList<>();
			m2 = new ArrayList<>();
			m3 = new ArrayList<>();
			m4 = new ArrayList<>();
			
			for (int m = 0; m < 8; m++) {
				m1.add(sc.nextInt());
			}
			System.out.println(m2);
			for (int m = 0; m < 8; m++) {
				m2.add(sc.nextInt());
			}
			for (int m = 0; m < 8; m++) {
				m3.add(sc.nextInt());
			}
			for (int m = 0; m < 8; m++) {
				m4.add(sc.nextInt());
			}
			
		}

	}
	public static void magnet(ArrayList<Integer> m,int c) {
		if(c == 1) {
			m.add(0, m.remove(7));
		}
		else {
			m.add(m.remove(0));
		}
	}
	
	public static void lotation(int m, int c) {
		
	}
}
