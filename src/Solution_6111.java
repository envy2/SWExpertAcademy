import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6111 {
	static ArrayList<Integer> arr;
	static int K;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		
		for(int i = 1 ;i <= iT ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new ArrayList<>();
			res = Integer.MAX_VALUE;
			StringTokenizer sst = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr.add(Integer.parseInt(sst.nextToken()));
			}
			Remove();
			System.out.printf("#%d %d\n",i,res);
		}

	}
	
	public static void Remove() {
		boolean[] ar = new boolean[arr.size()];
		for (int i = 0; i < arr.size()-2; i++) {
			if(arr.get(i) + K == arr.get(i+1) && arr.get(i+1) + K == arr.get(i+2)) {
				ar[i] = true;
			}
		}
		if(Check(ar)) {
			res = res < arr.size() ? res : arr.size();
			return;
		}
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]) {
				int a = arr.remove(i);
				int b = arr.remove(i);
				int c = arr.remove(i);
				Remove();
				arr.add(i,c);
				arr.add(i,b);
				arr.add(i,a);
			}
		}
	}
	public static boolean Check(boolean[] ar) {
		boolean check = true;
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]) {
				check = false;
				break;
			}
		}
		return check;
	}
}
