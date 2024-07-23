import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 카드 개수 
		
		Deque<Integer> deque = new ArrayDeque<>(); // deque 선언
		
		for(int i = 1; i<=N; i++) { // 채우기
			deque.offer(i);
		}
		
		while (deque.size()!=1) { // 하나만 남을 때 까지
			deque.remove(); // 첫번째 요소 삭제
			int num = deque.poll(); // 담기
			deque.offerLast(num); // 두번째 요소 맨끝으로 보내기
			
		}
		
		System.out.print(deque.poll());
	}

}
