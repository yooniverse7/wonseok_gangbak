import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 우선순위 큐 
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> o2 - o1);
		
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) { // 0이 아니라면 우선순위큐에 담기
				pq.offer(num);
			}
			else if(num == 0) { // 0이라면
				if(!pq.isEmpty()) { // 큐가 비어있지 않다면
					sb.append(pq.poll() + "\n");
				}
				else { // 비어있다면
					sb.append("0" + "\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	

}
