import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Rope {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ±×¸®µð
		int max = 0;
		int cnt = 1;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++)
			queue.add(Integer.parseInt(br.readLine()));
		
		while(!queue.isEmpty()) {
			N = queue.poll();
			max = Math.max(N * cnt, max);
			++cnt;
		}
		System.out.println(max);
	}

}
