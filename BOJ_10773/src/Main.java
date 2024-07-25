import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				deque.removeFirst();
			}else {
				deque.addFirst(num);
			}
		}
		int sum = 0;
		int size = deque.size();
		for(int i = 0; i<size; i++) {
			sum += deque.removeFirst();
		}
		System.out.println(sum);
		
	}

}
