import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 가장 긴 증가하는 부분 수열
		int ans;
		int left, right, mid;
		int N;
		int A[];
		int cnt = 0;
		int list[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		list = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; ++i)
			A[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; ++i) {
			if(list[cnt] < A[i])
				list[++cnt] = A[i];
			else {
				ans = 0;
				left = 1;
				right = cnt;
				
				while(left <= right) {
					mid = (left + right) / 2;
					
					if(list[mid] < A[i])
						left = mid + 1;
					else {
						right = mid - 1;
						ans = mid;
					}
				}
				list[ans] = A[i];
			}
		}
		System.out.println(cnt);
	}

}
