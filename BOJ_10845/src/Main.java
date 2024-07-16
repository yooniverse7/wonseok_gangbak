import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 명령 수
		Queue<Integer> q = new LinkedList<>(); // 큐
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("push")) { // 큐에 삽입
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			if(s.equals("pop")) { // 비어있으면 -1 출력, 있으면 지우고 출력 
				if(q.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(q.remove());
				}
			}
			
			if(s.equals("size")) { // 큐 사이즈 출력
				System.out.println(q.size());
			}
			
			if(s.equals("empty")) { // 큐가 비어있으면 1, 아니면 0 출력
				if (q.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
				
			}
			
			if(s.equals("front")) { // 큐가 비었으면 -1, 아니면 첫번째 요소 출력
				if(q.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(q.peek());
				}
			}
			
			if(s.equals("back")) { // 마지막 수 출력하기
				if(q.isEmpty()) {
					System.out.println("-1");
				}else {
					int lastNumber=((LinkedList<Integer>) q).peekLast();
                    System.out.println(lastNumber); 
				}
			}
		}
		
	}
}
