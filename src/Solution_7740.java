import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_7740 {
	static PriorityQueue<Ninja> ninja;
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= iT; i++) {
			System.out.print("#"+i+" ");
			ninja = new PriorityQueue<>(new NComparator());

			int command = Integer.parseInt(br.readLine());
			int order = 1;
			int result = 0;
			StringTokenizer st;
			for (int c = 0; c < command; c++) {
				st = new StringTokenizer(br.readLine());
				if (st.nextToken().equals("D")) {
					ninja.add(new Ninja(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), order++));
				} else {
					result = teacher(Integer.parseInt(st.nextToken()));
					if(result == -1) {
						System.out.print("NE ");
					}
					else {
						System.out.print(result+" ");
					}
				}
			}
			System.out.println();
		}
	}

	public static int teacher(int person) {
		int myPower = 0;
		int myAge = 0;
		for (Ninja n : ninja) {
			if (myPower != 0 && myAge != 0) {
				if(myPower <= n.power && myAge <= n.age) {
					return n.order;
				}
			}
			if (n.order == person) {
				myPower = n.power;
				myAge = n.age;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		init();
	}

	static class NComparator implements Comparator<Ninja> {

		@Override
		public int compare(Ninja o1, Ninja o2) {
			if (o1.power > o2.power) {
				return 1;
			} else if (o1.power == o2.power) {
				if (o1.age > o2.age) {
					return 1;
				} else if (o1.age == o2.age) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}

	}

	static class Ninja {
		int power, age, order;

		public Ninja(int power, int age, int order) {
			super();
			this.power = power;
			this.age = age;
			this.order = order;
		}

		@Override
		public String toString() {
			return "Ninja [power=" + power + ", age=" + age + ", order=" + order + "]";
		}

	}
}
