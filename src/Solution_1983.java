import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_1983 {

	static int M;
	static int[][] map;
	static String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int people = sc.nextInt();
			int rank = sc.nextInt();
			PriorityQueue<student> pq = new PriorityQueue<>(new sComparator());
			
			
			for (int j = 1; j <= people; j++) {
				pq.add(new student(sc.nextInt(),sc.nextInt(),sc.nextInt(),j));
			}
			int p = people / 10;
			int index = -1;
			
			while(true) {
				student s = pq.poll();
				index++;
				if(s.number == rank) {
					break;
				}
			}
			System.out.printf("#%d "+grade[index/p]+"\n",i);
		}
	}
	static class student{
		double total;
		int number;
		
		
		student(int m, int f, int r, int n){
			this.number = n;
			this.total = (m * 0.35) + (f* 0.45) + (r * 0.2);
		}
		@Override
		public String toString() {
			return "student [total=" + total + ", number=" + number + "]";
		}
		
	}
	static class sComparator implements Comparator<student>{

		@Override
		public int compare(student o1, student o2) {
			// TODO Auto-generated method stub
			return o1.total < o2.total ? 1: -1;
		}
		
	}
}
