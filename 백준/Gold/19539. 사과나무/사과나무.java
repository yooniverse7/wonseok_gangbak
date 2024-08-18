import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 나무 개수
		int sum = 0; // 전체 나무 높이
		int cnt1 = 0; // 1을 사용한 횟수
		int cnt2 = 0; // 2를 사용한 횟수
		String result = "YES";
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int tree = Integer.parseInt(st.nextToken());
			sum += tree;
			cnt1 += tree%2;
			cnt2 += tree/2;
		}
		
		if(sum%3 > 0 || cnt1 > cnt2) { // 합이 0이 아니거나 1의 개수가 2보다 많으면, 
			result = "NO";
		}
		
		System.out.println(result);
	}

}
