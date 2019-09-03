import java.util.Scanner;

public class Solution_4522 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i <= iT ; i++) {
			String str = sc.next();
			boolean check = true;
			for (int j = 0; j < str.length(); j++) {
				int len = str.length()-1;
				if(!(str.charAt(j) == '?' || str.charAt(len - j) == '?' || str.charAt(j) == str.charAt(len-j))) {
					check = false;
				}
			}
			if(check) {
				System.out.printf("#%d Exist\n",i);
			}
			else {
				System.out.printf("#%d Not exist\n",i);
			}
		}

		
	}

}
