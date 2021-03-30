import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EntranceJudge {

	public static void main(String[] args) throws IOException {
		// ÀÌºÐ Å½»ö
		long ans = 0;
		long sum;
		long left = 0, right;
		long mid;
		long max = 0;
		int N, M;
		int list[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new int[N];
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
			max = Math.max(list[i], max);
		}
		right = max * M;
		
		while(left <= right) {
			sum = 0;
			mid = (left + right) / 2;
			
			for(int i = 0; i < N; i++)
				sum += mid / list[i];
			
			if(sum >= M) {
				right = mid - 1;
				ans = mid;
			}
			else
				left = mid + 1;
		}
		
		System.out.println(ans);
	}

}
