import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1230 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tcase = 0; tcase < 10; tcase++) {
			
			ArrayList<Integer> password = new ArrayList<>();
			ArrayList<String> order = new ArrayList<>();
			
			int pass_len = sc.nextInt();
			
			for (int i = 0; i < pass_len; i++) {
				password.add(sc.nextInt());
			}
			
			int order_len = sc.nextInt();
			
			for (int i = 0; i < order_len; i++) {
				String word = sc.next();
				order.add(word);
				switch(word) {
				case "I":
					order.add(sc.next());
					int ilen = sc.nextInt();
					order.add(ilen+"");
					for (int j = 0; j < ilen; j++) {
						order.add(sc.next());
					}
					break;
				case "A":
					int alen = sc.nextInt();
					order.add(alen+"");
					for (int j = 0; j < alen; j++) {
						order.add(sc.next());
					}
					break;
				case "D":
					order.add(sc.next());
					order.add(sc.next());
					break;
				}
			}
			
			for (int i = 0; i < order.size(); i++) {
				switch(order.get(i)) {
				case "I":
					int len = Integer.parseInt(order.get(i+2));
					for(int j =  len + 2; j > 2 ; j--) {
						password.add(Integer.parseInt(order.get(i+1)),Integer.parseInt(order.get(i+j)));
					}
					
					break;
				case "A":
					int len1 = Integer.parseInt(order.get(i+1));
					for (int j = 0; j < len1; j++) {
						password.add(Integer.parseInt(order.get(i+2+j)));
					}
					break;
				case "D":
					int len2 = Integer.parseInt(order.get(i+2));
					for (int j = 0; j < len2; j++) {
						password.remove(Integer.parseInt(order.get(i+1)));
					}
					break;
					
				}
			}
			System.out.printf("#%d ",tcase+1);
			for (int i = 0; i < 10; i++) {
				System.out.print(password.get(i) +" ");
			}
			System.out.println();
		}
		
	}

}
