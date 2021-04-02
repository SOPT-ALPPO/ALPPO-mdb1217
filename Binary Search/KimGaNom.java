import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KimGaNom {

	public static void main(String[] args) throws IOException {
		// ÀÌºÐ Å½»ö
		ArrayList<Integer> list = new ArrayList<>();
		int N, K, M;
		int max = 0;
		long sum;
		int left = 1, right, mid;
		int ans = 0;
		int L;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; ++i) {
			L = Integer.parseInt(br.readLine());
			if(L > K) {
				if(L >= 2 * K)
					L = L - (2 * K);
				else 
					L = L - K;
				list.add(L);
				max = Math.max(L, max);
			}
		}
		right = max;
		
		while(left <= right) {
			mid = (left + right) / 2;
			sum = 0;
			
			for(int i : list)
				sum += i / mid;
			
			if(sum >= M) {
				left = mid + 1;
				ans = mid;
			}
			else
				right = mid - 1;
		}
		
		System.out.println(ans != 0? ans : -1);
	}

}
