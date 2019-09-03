import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4013 {
	static ArrayList<Integer> m1;
	static ArrayList<Integer> m2;
	static ArrayList<Integer> m3;
	static ArrayList<Integer> m4;
	
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
			for (int m = 0; m < 8; m++) {
				m2.add(sc.nextInt());
			}
			for (int m = 0; m < 8; m++) {
				m3.add(sc.nextInt());
			}
			for (int m = 0; m < 8; m++) {
				m4.add(sc.nextInt());
			}
			for (int j = 0; j < K; j++) {
				int mag = sc.nextInt();
				int clock = sc.nextInt();
				
				lotation(mag,clock);
				System.out.println(m1);
				System.out.println(m2);
				System.out.println(m3);
				System.out.println(m4);
			}
			int result = 0;
			if(m1.get(0) == 1) {
				result += 1;
			}
			if(m2.get(0) == 1) {
				result += 2;
			}
			if(m3.get(0) == 1) {
				result += 4;
			}
			if(m4.get(0) == 1) {
				result += 8;
			}
			System.out.println("#"+i+" "+ result);
		}

	}
	public static void lotation(int m, int c) {
		switch(m) {
		case 1:
			if(c == 1) {
				if(m1.get(2) != m2.get(6)) {
					m2.add(m2.remove(0));
				}
				m1.add(0, m1.remove(7));
			}
			else {
				if(m1.get(2) != m2.get(6)) {
					m2.add(0,m2.remove(7));
				}
				m1.add(m1.remove(0));
			}
			break;
		case 2:
			if(c == 1) {
				if(m1.get(2) != m2.get(6)) {
					m1.add(m1.remove(0));
				}
				if(m2.get(2) != m3.get(6)) {
					m3.add(m3.remove(0));
				}
				m2.add(0,m2.remove(7));
			}
			else {
				if(m1.get(2) != m2.get(6)) {
					m1.add(0,m1.remove(7));
				}
				if(m2.get(2) != m3.get(6)) {
					m3.add(0,m3.remove(7));
				}
				m2.add(m2.remove(0));
			}
			break;
		case 3:
			if(c == 1) {
				if(m2.get(2) != m3.get(6)) {
					m2.add(m2.remove(0));
				}
				if(m3.get(2) != m4.get(6)) {
					m3.add(m4.remove(0));
				}
				m3.add(0,m3.remove(7));
			}
			else {
				if(m1.get(2) != m2.get(6)) {
					m1.add(0,m1.remove(7));
				}
				if(m2.get(2) != m3.get(6)) {
					m3.add(0,m3.remove(7));
				}
				m2.add(m2.remove(0));
			}
			break;
		case 4:
			if(c == 1) {
				m4.add(0, m4.remove(7));
				if(m3.get(2) != m4.get(7)) {
					lotation(3,-1);
				}
			}
			else {
				m4.add(m4.remove(0));
				if(m3.get(2) != m4.get(5)) {
					lotation(3,1);
				}
			}
			break;
		}
	}
}
