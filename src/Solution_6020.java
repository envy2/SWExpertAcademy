import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_6020 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ; i++) {
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			Result[] res = new Result[N];
			for (int j = 0; j < N; j++) {
				res[j] = new Result(sc.nextInt(),sc.nextInt(),sc.nextInt());
			}
			
			Arrays.sort(res, new SSort());
			Process[] pro = new Process[N-1];
			for (int j = 1; j < res.length; j++) {
				pro[j-1] = new Process(res[j-1].a - res[j].a,res[j-1].b1 - res[j].b2,res[j-1].b2 - res[j].b1);
			}
			
			Range[] range = new Range[N-1];
			for (int j = 0; j < res.length-1; j++) {
				range[j] = new Range(((double)pro[j].b1)/(double)pro[j].a, ((double)pro[j].b2)/(double)pro[j].a);
			}
			
			double start = range[0].start;
			double end = range[0].end;
			for (int j = 0; j < range.length; j++) {
				start = Math.max(range[j].start, start);
				end = Math.min(range[j].end, end);
			}
			
			
			double gob = (start + end)/2; 
			
			double bstart = res[0].b1 - (res[0].a * gob);
			double bend = res[0].b2 - (res[0].a * gob);
			boolean check = true;
			if(start <= end) {
				for (int j = 0; j < res.length; j++) {
					bstart = Math.max(bstart, res[j].b1 - (res[j].a * gob) );
					bend = Math.min(bend, res[j].b2 - (res[j].a * gob) );
				}
				
				if(bstart <= bend) {
					if(bstart > W || bend < 0) {
						check = false;
					}
					if(check) {
						System.out.printf("#%d YES\n",i);
					}
					else {
						System.out.printf("#%d NO\n",i);
					}
				}
				else {
					System.out.printf("#%d NO\n",i);
				}
			}
			else {
				System.out.printf("#%d NO\n",i);
			}
		}
	}
	static class SSort implements Comparator<Result>{
		@Override
		public int compare(Result o1, Result o2) {
			// TODO Auto-generated method stub
			return o1.a > o2.a ? -1:1;
		}

	}
	static class Process{
		int a;
		int b1,b2;
		public Process(int a, int b1,int b2) {
			this.a = a;
			this.b1 = b1;
			this.b2 = b2;
		}
	}
	static class Result{
		int a;
		int b1,b2;
		public Result(int a, int b1,int b2) {
			this.a = a;
			this.b1 = b1;
			this.b2 = b2;
		}
		@Override
		public String toString() {
			return "Result [a=" + a + ", b1=" + b1 + ", b2=" + b2 + "]";
		}
		
	}
	static class Range{
		double start;
		double end;
		public Range(double s, double e) {
			this.start = s;
			this.end = e;
		}
		@Override
		public String toString() {
			return "Range [start=" + start + ", end=" + end + "]";
		}
		
	}
	
}
