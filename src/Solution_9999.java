import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9999 {
	static int L, N, len, result; // 광고 시간, 피크 시간대 갯수, 최대 길이, 결과값
	static boolean[] time = new boolean[100000000];
	
	public static void init(BufferedReader br) throws IOException {
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		result = 0;
		
		int start = 0;
		int end = 0;
		
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			for (int j = start; j < end; j++) {
				time[j] = true;
			}
		}
		
		len = end;
	}
	
	public static void solution() {
		int start = 0;
		int end = L;
		int sum = 0;
		
		for (int i = 0; i < L; i++) {
			sum += (time[i] ? 1 : 0);
			result = Math.max(result, sum);
		}
		
		while(end < len) {
			sum -= (time[start] ? 1 : 0);
			sum += (time[end] ? 1 : 0);
			result = Math.max(result, sum);
			
			start++;
			end++;
		}
		
		for (int i = 0; i < len; i++) {
			time[i] = false;
		}
		
		//Arrays.fill(time, false); 이거 쓰면 시간초과임
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			init(br);
			solution();
			System.out.println("#" + t + " " + result);
		}
		
		br.close();

	}

}
