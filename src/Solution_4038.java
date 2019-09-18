import java.util.Scanner;

public class Solution_4038 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = Integer.parseInt(sc.next());
		
		for(int i = 1 ; i <= iT ;i++) {
			String book = sc.next();
			String keyword = sc.next();;
			int start = 0;
			int result = 0;
			
			while(true) {
				if(book.indexOf(keyword,start) > -1) {
					start = book.indexOf( keyword , start ) + 1;
					result++;
				}
				else {
					break;
				}
			}
			System.out.println("#"+i+" "+result);
		}

	}

}
