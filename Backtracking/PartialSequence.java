import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartialSequence {

	static int ans = 0;
	static int sum = 0;
	static int n_list[];
	static int N, S;
	public static void main(String[] args) throws IOException {
		// 백트래킹
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		n_list = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i)
			n_list[i] = Integer.parseInt(st.nextToken());
		
		tracking(0, 0);
		System.out.println(ans);
	}
	
	static void tracking(int start, int d) {
		if(d != N) {
			for(int i = start; i < N; ++i) {
				sum += n_list[i];
				if(sum == S)
					++ans;
				tracking(i + 1, d + 1);
				sum -= n_list[i];
			}
		}
	}

}
