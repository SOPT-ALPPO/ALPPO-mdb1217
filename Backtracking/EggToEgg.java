import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EggToEgg {

	static int max = 0;
	static int N;
	static int weight[];
	static int durability[];
	public static void main(String[] args) throws IOException {
		// 백트래킹
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		durability = new int[N];
		weight = new int[N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			durability[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		tracking(0, 0);
		System.out.println(max);
	}

	static void tracking(int d, int break_num) {
		if(d == N)
			max = Math.max(max, break_num);
		else {
			int temp;
			boolean attack = false;
			if(durability[d] > 0) {
				for(int i = 0; i < N; ++i) {
					if(i == d || durability[i] <= 0)
						continue;
					temp = 0;
					durability[i] -= weight[d];
					if(durability[i] <= 0)
						++temp;
					durability[d] -= weight[i];
					if(durability[d] <= 0)
						++temp;
					tracking(d + 1, break_num + temp);
					
					durability[i] += weight[d];
					durability[d] += weight[i];
					attack = true;
				}
				
				if(!attack)
					tracking(d + 1, break_num);
			}
			else
				tracking(d + 1, break_num);
		}
	}
}
