import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SheepKkong {
	static class Graph {
		int x;
		int y;
		
		Graph(int a, int b){
			x = a;
			y = b;
		}
		
	}
	
	static int s, w;
	static int R, C;
	static int op_X[] = {0,0,1,-1};//µ¿¼­³²ºÏ
	static int op_Y[] = {1,-1,0,0};
	static String Map[];
	static boolean Visited[][];
	public static void main(String[] args) throws IOException {
		// bfs
		int s_cnt = 0, w_cnt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		Map = new String[R];
		Visited = new boolean[R][C];
		for(int i = 0; i < R; ++i)
			Map[i] = br.readLine();
		
		for(int i = 0; i < R; ++i) {
			for(int j = 0; j < C; ++j) {
				if(Map[i].charAt(j) != '#' && !Visited[i][j]) {
					s = 0;
					w = 0;
					bfs(i, j);
					
					if(s > w)
						s_cnt += s;
					else
						w_cnt += w;
				}
			}
		}
		
		System.out.println(s_cnt + " " + w_cnt);
	}

	static void bfs(int x, int y) {
		int temp_x, temp_y;
		Graph g;
		Queue<Graph> queue = new LinkedList<>();
		
		queue.add(new Graph(x, y));
		Visited[x][y] = true;
		if(Map[x].charAt(y) == 'v')
			++w;
		else if(Map[x].charAt(y) == 'k')
			++s;
		
		while(!queue.isEmpty()) {
			g = queue.poll();
			
			for(int i = 0; i < 4; ++i) {
				temp_x = g.x + op_X[i];
				temp_y = g.y + op_Y[i];
				
				if(temp_x >= 0 && temp_x < R && temp_y >= 0 && temp_y < C) {
					if(Map[temp_x].charAt(temp_y) != '#' && !Visited[temp_x][temp_y]) {
						if(Map[temp_x].charAt(temp_y) == 'v')
							++w;
						else if(Map[temp_x].charAt(temp_y) == 'k')
							++s;
						Visited[temp_x][temp_y] = true;
						queue.add(new Graph(temp_x, temp_y));
					}
				}
			}
		}
	}
}
