import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_8998 {
	static Work[] work;
	static ArrayList<Work> works;
	static long result;
	
	static class TimeComparator implements Comparator<Work>{

		@Override
		public int compare(Work o1, Work o2) {
			if( o1.deadline > o2.deadline ) {
				return 1;
			}
			else if( o1.deadline == o2.deadline ) {
				if( o1.time > o2.time ) {
					return 1;
				}
				else if( o1.time == o2.time ) {
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
	
	static class Work{
		int deadline, time;

		public Work(int deadline, int time) {
			this.deadline = deadline;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Work [deadline=" + deadline + ", time=" + time + "]";
		}
		
	}

	public static void init(Scanner sc) {
		int N = sc.nextInt();
		work = new Work[N];
		
		int deadline, time;
		works = new ArrayList<>();
		result = 0;
		
		for (int i = 0; i < work.length; i++) {
			time = sc.nextInt();
			deadline = sc.nextInt();
			works.add(new Work(deadline - time,time));
		}
		
		Collections.sort(works, new TimeComparator());
		
	}
	
	public static void binary() {
		long left = 0;
		long right = works.get(0).deadline;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			if(solution(mid)) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		result = right;
	}
	
	public static boolean solution(long value) {
		for (int i = 0; i < works.size(); i++) {
			if(value <= works.get(i).deadline) {
				value += works.get(i).time;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ;t <= tc ; t++) {
			init(sc);
			binary();
			System.out.println("#"+ t + " "+ result);
		}

	}

}
