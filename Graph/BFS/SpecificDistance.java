import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SpecificDistance {
	static class City {
		int city;
		int dis;//�Ÿ�
		
		City(int a, int b) {
			city = a;
			dis = b;
		}
	}
	
	static int N;
	static int K;
	static int Visited[];
	static ArrayList<ArrayList<Integer>> Map = new ArrayList<>();
	static PriorityQueue<Integer> heap = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		// bfs �ִ� �Ÿ�
		// ���� ArrayList ����
		int M;
		int X;
		int A, B;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		Visited = new int[N + 1];
		for(int i = 0; i < N + 1; i++) {
			Map.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			Map.get(A).add(B);//A -> B
		}
		bfs(X);
		if(!heap.isEmpty()) {
			for(int i : heap)
				System.out.println(i);
		}
		else 
			System.out.println(-1);
	}
	
	static void bfs(int start_city) {
		City city;
		int city_num;
		int cnt = 0;
		Queue<City> list = new LinkedList<>();
		list.add(new City(start_city, cnt));
		Visited[start_city] = 1;
		
		while(!list.isEmpty()) {
			city = list.poll();
			cnt = city.dis + 1;
			if(cnt > K)
				break;
			city_num = city.city;
			for(int i : Map.get(city_num)) {
				if(Visited[i] == 0) {
					list.add(new City(i, cnt));
					Visited[i] = 1;
					if(cnt == K)
						heap.add(i);
				}
			}
		}
	}

}
