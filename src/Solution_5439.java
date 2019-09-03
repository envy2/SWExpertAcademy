import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_5439 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= iT; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			Doll[] doll = new Doll[N];
			for (int j = 0; j < N; j++) {
				StringTokenizer ss = new StringTokenizer(br.readLine());
				doll[j] = new Doll(ss.nextToken(),ss.nextToken());
			}
			
			Mi[] mi = new Mi[Q];
			for(int j = 0 ; j < Q; j++) {
				StringTokenizer ss = new StringTokenizer(br.readLine());
				mi[j] = new Mi(ss.nextToken(),ss.nextToken());
			}
			
			PriorityQueue<Doll> p = new PriorityQueue<Doll>(new PSort());
			int result = 0;
			for (int j = 0; j < mi.length; j++) {
				for (int k = 0; k < doll.length; k++) {
					if(mi[j].round <= doll[k].round && mi[j].height >= doll[k].height) {
						p.add(doll[k]);
					}
				}
				result += (j+1)*LIS(p);
				p.clear();
			}
			
			System.out.printf("#%d %d\n",i,result);
		}

	}
	public static int LIS(PriorityQueue<Doll> p) {
		int[] arr = new int[p.size()];
		if(arr.length == 0) {
			return 0;
		}
		
		Doll[] a = new Doll[p.size()];
		int index = 0;
		for(Doll d:p) {
			a[index++] = d;
		}
		int max = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(a[i].round < a[j].round) {
					arr[j] = Math.max(arr[j], arr[i]+1);
					max = max > arr[j] ? max : arr[j];
				}
			}
		}
		return max;
	}
	
	static class PSort implements Comparator<Doll>{
		public int compare(Doll o1, Doll o2) {
			return o1.height > o2.height ? 1 : -1; 
		}
	}
}
class Doll {
	int round;
	int height;
	public Doll(String s, String s2) {
		this.round = Integer.parseInt(s);
		this.height = Integer.parseInt(s2);
	}
}
class Mi {
	int round;
	int height;
	public Mi(String s, String s2) {
		this.round = Integer.parseInt(s);
		this.height = Integer.parseInt(s2);
	}
}