import java.util.Scanner;

public class Solution_8556 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i =1 ; i<= iT ;i++) {
			String dir = sc.next();
			int w = dir.length() - 1;
			double res = 0;
			int cnt = 0;
			if(dir.charAt(w) == 't') {
				res = 90;
				w -= 4;
			}
			while(w > 0) {
				if(dir.charAt(w) == 't') {
					res += 90 / Math.pow(2, cnt++);
					w-= 4;
				}
				else{
					res -= 90 / Math.pow(2, cnt++);
					w -= 5;
				}
			}
			String result= parse(res);
			System.out.println("#"+i+" "+result);
		}

	}
	public static String parse(double res) {
		int two = 0;
		while(true) {
			if(res != (int)res) {
				res *= 2;
				two++;
			}
			else {
				break;
			}
		}
		if(two == 0) {
			return (int)res+"";
		}
		else {
			return (int)res+"/"+(two*2);
		}
		
	}
}
