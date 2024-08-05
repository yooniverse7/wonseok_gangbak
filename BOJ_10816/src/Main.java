import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 상근이 카드 개수
		HashMap<Integer, Integer> count = new HashMap<>(); // 상근이 카드 빈도
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			int card = Integer.parseInt(st.nextToken());
			count.put(card, count.getOrDefault(card, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine()); // 정수 개수
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<M; i++) {
			int checkCard = Integer.parseInt(st2.nextToken());
			sb.append(count.getOrDefault(checkCard, 0)).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
