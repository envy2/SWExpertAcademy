import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Solution_1225 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			int tcase = sc.nextInt();
			for (int j = 0; j < 8; j++) {
				list.add(sc.nextInt());
			}
			
			while(list.getLast() != 0) {
				int count = 1;
				for (int x = 0; x < 5; x++) {
					list.add(list.removeFirst() - count++);
					if(list.getLast() <= 0) {
						list.removeLast();
						list.addLast(0);
						break;
					}
				}
				
			}
			System.out.print("#"+tcase+" ");
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j)+" ");
			}
			System.out.println();
			
		}

	}

}
