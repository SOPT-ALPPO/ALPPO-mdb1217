import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AssembleEnergy {

	static int max = 0;
	static int sum = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	static int N;
	public static void main(String[] args) throws IOException {
		// 백트래킹
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i)
			list.add(Integer.parseInt(st.nextToken()));
		
		tracking(0);
		System.out.println(max);
	}

	static void tracking(int d) {
		if(d == N - 2)
			max = Math.max(max, sum);
		else {
			int temp;
			int energy;
			for(int i = 1; i <= list.size() - 2; ++i) {
				energy = list.get(i);
				temp = list.get(i - 1) * list.get(i + 1);
				list.remove(i);
				sum += temp;
				tracking(d + 1);
				sum -= temp;
				list.add(i, energy);
			}
		}
	}
}
