import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t =0; t<10; t++) {
			int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
			Deque<Integer> dq = new ArrayDeque<>(); // 숫자 저장 deque
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<8; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			boolean stop = true;
			while (stop) {
				for(int i = 1; i<=5; i++) {
					int num = dq.poll();
					num -=i;
					if(num <= 0) {
						dq.offerLast(0);
						stop = false;
						break;
					}else {
						dq.offerLast(num);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<8; i++) { 
				sb.append(dq.poll()).append(" ");
			}
			
			System.out.println("#" + T + " " + sb.toString());
		}
	}
}