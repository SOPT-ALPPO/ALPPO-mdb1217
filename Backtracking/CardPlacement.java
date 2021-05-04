import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CardPlacement {

	static boolean Visited[];
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	static ArrayList<String> ans_list = new ArrayList<>();
	static int N, K;
	static int list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 백트래킹
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		list = new int[N];
		Visited = new boolean[N];
		
		for(int i = 0; i < N; ++i)
			list[i] = Integer.parseInt(br.readLine());
		
		tracking(0);
		System.out.println(cnt);
	}

	static void tracking(int d) {
		if(d == K) {
			if(!ans_list.contains(sb.toString())) {
				ans_list.add(sb.toString());
				++cnt;
			}
		}
		else {
			for(int i = 0; i < N; ++i) {
				if(!Visited[i]) {
					Visited[i] = true;
					sb.append(list[i]);
					tracking(d + 1);
					if(list[i] / 10 >= 1)
						sb.delete(sb.length() - 2, sb.length());
					else
						sb.deleteCharAt(sb.length() - 1);
					Visited[i] = false;
				}
			}
		}
	}
}
