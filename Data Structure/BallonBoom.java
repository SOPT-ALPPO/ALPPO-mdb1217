import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BallonBoom {
	static class Ballon {
		int num;
		int move;
		
		Ballon(int a, int b) {
			num = a;
			move = b;
		}
	}
	public static void main(String[] args) throws IOException {
		// 자료구조
		StringBuilder s = new StringBuilder();
		Ballon b;
		ArrayList<Ballon> list = new ArrayList<>();
		int N;
		int a;
		int move = 0;
		int temp;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			a = Integer.parseInt(st.nextToken());
			list.add(new Ballon(i, a));
		}
		
		b = list.get(0);
		a = b.num + 1;
		s.append(a + " ");
		list.remove(0);
		if(!list.isEmpty()) { 
			if(b.move > 0)
				move = (b.move - 1) % list.size();
			else
				move = list.size() - ((-b.move) % list.size());
		}
		
		for(int i = 1; i < N; i++) {
			b = list.get(move);
			a = b.num + 1;
			s.append(a + " ");
			list.remove(move);
			if(!list.isEmpty()) {
				if(b.move > 0) 
					move = (move + b.move - 1) % list.size();
				else {
					temp = move + b.move;
					if(temp >= 0)
						move = temp;
					else {
						for(int j = 0; j < -b.move; j++) {
							move = move - 1;
							if(move == -1)
								move = list.size() - 1;
						}
					}
				}
			}
		}
		
		System.out.println(s.toString());
	}

}
