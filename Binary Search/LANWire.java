import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LANWire {

	public static void main(String[] args) throws IOException {
		// ÀÌºÐ Å½»ö
		int K, N;
		int list[];
		long left = 1, right, mid;
		int max = 0;
		int ans = 0;
		long sum;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		list = new int[K];
		
		for(int i = 0; i < K; i++) {
			list[i] = Integer.parseInt(br.readLine());
			max = Math.max(list[i], max);
		}
		
		right = max;
		while(left <= right) {
			sum = 0;
			mid = (left + right) / 2;
			
			for(int i : list)
				sum += (i / mid);
			
			if(N <= sum) {
				ans = (int) mid;
				left = mid + 1;
			}
			else
				right = mid - 1;
		}
		System.out.println(ans);
	}

}
