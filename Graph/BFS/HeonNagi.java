import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HeonNagi {
	static class Graph {
		int x;
		int y;
		
		Graph(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	static boolean Visited[][];
	static char map[][];
	static int n, m;
	public static void main(String[] args) throws IOException {
		// bfs
		int sum = 0;
		int start_x = 0, start_y = 0;
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Visited = new boolean[n][m];
		map = new char[n][m];
		for(int i = 0; i < n; ++i) {
			s = br.readLine();
			for(int j = 0; j < m; ++j) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j] == 'I') {
					start_x = i;
					start_y = j;
				}
			}
		}
		
		sum = bfs(start_x, start_y);
		
		System.out.println(sum == 0? "TT" : sum);
	}

	static int bfs(int start_x, int start_y) {
		int op_x[] = {-1, 1, 0, 0};
		int op_y[] = {0, 0, 1, -1};
		int temp_x, temp_y;
		int sum = 0;
		Graph g;
		Queue<Graph> queue = new LinkedList<>();
		queue.add(new Graph(start_x, start_y));
		
		while(!queue.isEmpty()) {
			g = queue.poll();
			for(int i = 0; i < 4; ++i) {
				temp_x = g.x + op_x[i];
				temp_y = g.y + op_y[i];
				
				if(temp_x >= 0 && temp_y >= 0 && temp_x < n && temp_y < m) {
					if(!Visited[temp_x][temp_y] && map[temp_x][temp_y] != 'X') {
						Visited[temp_x][temp_y] = true;
						if(map[temp_x][temp_y] == 'P')
							++sum;
						
						queue.add(new Graph(temp_x, temp_y));
					}
				}
			}
		}
		
		return sum;
	}
}
