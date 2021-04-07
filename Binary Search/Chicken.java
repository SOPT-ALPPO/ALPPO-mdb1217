import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Chicken {

	public static void main(String[] args) throws IOException {
		// ÀÌºÐÅ½»ö
		long ans = 0;
		long num;
		long sum = 0;
		long temp;
		long left = 1, right, mid;
		ArrayList<Long> list = new ArrayList<>();
		int S, C;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < S; ++i) {
			list.add(Long.parseLong(br.readLine()));
			sum += list.get(i);
		}
			
		Collections.sort(list);
		right = list.get(S - 1);
		while(left <= right) {
			num = 0;
			temp = sum;
			mid = (left + right) / 2;
			
			for(int i = S - 1; i >= 0; --i) {
				num += list.get(i) / mid;
				temp -= (list.get(i) / mid) * mid;
				if(num >= C) {
					temp += mid * (num - C);
					break;
				}
			}
			
			if(num < C)
				right = mid - 1;
			else {
				left = mid + 1;
				ans = temp;
			}
		}
		
		System.out.println(ans);
	}
}
