import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CountCalculate {

	static boolean success = false;
	static boolean Visited[];
	static int end;
	static ArrayList<Queue<Integer>> list = new ArrayList<>();
	static int n, m;
	public static void main(String[] args) throws IOException {
		// dfs
		int start, x, y;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		Visited = new boolean[n + 1];
		for(int i = 0; i < n + 1; ++i)
			list.add(new LinkedList<>());
		
		m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		dfs(start, 0);
		if(!success)
			System.out.println(-1);
	}
	
	static void dfs(int x, int d) {
		if(x == end) {
			success = true;
			System.out.println(d);
		}
		if(!success) {
			for(int i : list.get(x)) {
				if(!Visited[i]) {
					Visited[i] = true;
					dfs(i, d + 1);
					if(success)
						break;
				}
			}
		}
	}
}
