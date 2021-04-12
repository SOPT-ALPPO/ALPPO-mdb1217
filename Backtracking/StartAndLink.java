import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StartAndLink {
	
	static boolean Visited[];
	static int ans = Integer.MAX_VALUE;
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	static int start_team = 0;
	static int link_team = 0;
	static int stat[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 백트래킹
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		stat = new int[N][N];
		Visited = new boolean[N];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				stat[i][j] = Integer.parseInt(st.nextToken());
				link_team += stat[i][j];
			}
		}
		
		tracking(0, 0);
		
		System.out.println(ans);
	}
	
	static void tracking(int start, int d) {
		int k;
		if(d == (N / 2))
			ans = Math.min(ans, Math.abs(link_team - start_team));
		else {
			for(int i = start; i < N; ++i) {
				for(int j = 0; j < list.size(); ++j) {
					k = list.get(j);
					start_team += stat[i][k];
					start_team += stat[k][i];
				}
				for(int j = 0; j < N; ++j) {
					if(!Visited[j]) {
						link_team -= stat[i][j];
						link_team -= stat[j][i];
					}
				}
				Visited[i] = true;
				list.add(i);
				
				tracking(i + 1, d + 1);
				
				list.remove(list.size() - 1);
				Visited[i] = false;
				for(int j = 0; j < list.size(); ++j) {
					k = list.get(j);
					start_team -= stat[i][k];
					start_team -= stat[k][i];
				}
				for(int j = 0; j < N; ++j) {
					if(!Visited[j]) {
						link_team += stat[i][j];
						link_team += stat[j][i];
					}
				}
			}
		}
	}

}
