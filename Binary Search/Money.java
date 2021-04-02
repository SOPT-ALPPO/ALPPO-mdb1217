import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Money {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ÀÌºÐ Å½»ö
		ArrayList<Integer> list = new ArrayList<>();
		int N;
		int M;
		int sum;
		int left = 1, right, mid;
		int ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));
		Collections.sort(list);
		right = list.get(list.size() - 1);
		
		M = Integer.parseInt(br.readLine());
		
		while(left <= right) {
			mid = (left + right) / 2;
			sum = 0;
			for(int i = 0; i < list.size(); ++i) {
				if(list.get(i) <= mid)
					sum += list.get(i);
				else {
					sum += (list.size() - i) * mid;
					break;
				}
			}
			
			if(sum < M) {
				left = mid + 1;
				ans = mid;
			}
			else if(sum == M) {
				ans = mid;
				break;
			}
			else
				right = mid - 1;
		}
		
		System.out.println(ans);
	}

}
