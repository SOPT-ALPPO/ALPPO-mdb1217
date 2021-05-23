import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KevinBacon {
	static class Distance {
		int person;
		int distance;
		
		Distance(int a, int b) {
			person = a;
			distance = b;
		}
	}
	
	static int N, M;
	static ArrayList<ArrayList<Distance>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// bfs
		int ans = 0, ans_num = Integer.MAX_VALUE;
		int a;
		int start, end;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N + 1; ++i)
			list.add(new ArrayList<>());
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Distance(end, 1));
			list.get(end).add(new Distance(start, 1));
		}
		
		for(int i = 1; i <= N; ++i) {
			if((a = bfs(i)) < ans_num) {
				ans_num = a;
				ans = i;
			}
		}
		
		System.out.println(ans);
	}

	static int bfs(int start) {
		Distance d;
		int sum = 0;
		Queue<Distance> queue = new LinkedList<>();
		boolean Visited[] = new boolean[N + 1];
		
		queue.addAll(list.get(start));
		while(!queue.isEmpty()) {
			d = queue.poll();
			if(Visited[d.person])
				continue;
			
			Visited[d.person] = true;
			sum += d.distance;
			
			for(Distance dt : list.get(d.person)) {
				if(!Visited[dt.person])
					queue.add(new Distance(dt.person, 1 + d.distance));
			}
		}
		
		return sum;
	}
}
