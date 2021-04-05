import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class OlympicGame {
	static class Game implements Comparable<Game>{
		int day;
		String start;
		String end;
		
		Game(int a, String b, String c) {
			day = a;
			start = b;
			end = c;
		}
		
		@Override
		public int compareTo(Game target) {
			if(day > target.day)
				return 1;
			else if(day == target.day)
				return end.compareTo(target.end);
			else
				return -1;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ±×¸®µð
		StringBuilder sb = new StringBuilder();
		int temp;
		int sum;
		int prev_day;
		String prev_end;
		Game g;
		PriorityQueue<Game> queue;
		int n, m;
		int d;
		String s, e;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; ++i) {
			queue = new PriorityQueue<>();
			sum = 0;
			prev_end = "0000";
			prev_day = 0;
			temp = 0;
			m = Integer.parseInt(br.readLine());
			
			for(int j = 0; j < m; ++j) {
				st = new StringTokenizer(br.readLine());
				d = Integer.parseInt(st.nextToken());
				s = st.nextToken();
				e = st.nextToken();
				
				queue.add(new Game(d, s, e));
			}
			
			while(!queue.isEmpty()) {
				g = queue.poll();
				if(prev_day != g.day) {
					prev_end = "0000";
					prev_day = g.day;
					sum += temp;
					temp = 0;
				}
				if(g.start.compareTo(prev_end) >= 0) {
					prev_end = g.end;
					++temp;
				}
			}
			sum += temp;
			sb.append("Scenario #" + i + ":\n" + sum + "\n\n");
		}
		System.out.println(sb.toString());
	}
}
