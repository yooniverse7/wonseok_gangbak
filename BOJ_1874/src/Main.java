import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 숫자 개수
		int[] arr = new int[N]; // 숫자 배열
		
		for(int i = 0; i<N; i++) { // 배열 채우기
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Deque<Integer> deque = new ArrayDeque<>(); // deque 선언
		StringBuilder result = new StringBuilder();
		int cnt = 1; // 스택에 넣을 숫자
		
		for(int num : arr) { // 숫자 배열에서 순서대로 꺼내기
			while (cnt <= num) { // 지금 숫자보다 num이 크거나 같을 때까지
				deque.push(cnt); // 순서대로 스택에 담음
				result.append("+\n"); // 담았으니 + 출력
				cnt++;
			}
			
			if(deque.peek() != null && deque.peek() == num) { // 제일 위의 값이 num과 같다면
				deque.pop(); // 최상단 값 제거
				result.append("-\n"); // - 출력
			}else { // 다르다면 NO 출력
				System.out.println("NO");
				return;
			}
		}
		
		System.out.print(result.toString()); // 결과 전체 출력
	}

}
