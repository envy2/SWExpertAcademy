import java.util.Scanner;

public class Solution_4039 {
	static int result;
	static String str;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ;i++) {
			int L = sc.nextInt();
			str = sc.next();
			result = 0;
			
			binary(0,L-1);
			System.out.println("#"+i+" "+result);
		}
	}
	public static void binary(int left, int right) {
		if(left == right) {
			result = left;
			return;
		}
		int len = ((left + right) / 2) + 1;
		int start = 0;
		String substr;
		int cnt;
		int idx = 0;
		boolean check = false;
		while(start + len < str.length()) {
			cnt = 0;
			substr = str.substring(start,start + len);
			while(true) {
				if(str.indexOf(substr,idx) != -1) {
					idx = str.indexOf(substr,idx) + 1;
					cnt++;
					if(cnt == 2) {
						check = true;
						break;
					}
				}
				else {
					cnt = 0;
					break;
				}
			}
			start++;
			
			if(check) {
				break;
			}
		}
		
		if(check) {
			binary(len,right);
		}
		else {
			binary(left,len-1);
		}
	}
}
