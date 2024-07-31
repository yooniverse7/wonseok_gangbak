import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken(); // 입력 명령어
			
			if(str.equals("push")) { //push일 때
				dq.addLast(Integer.parseInt(st.nextToken()));
				
			} else if (str.equals("pop")) { //pop일 때
				if(dq.isEmpty()) { // 비어있을 때
					sb.append("-1\n");
				}else { // 차있을 때
					sb.append(dq.pollLast() +"\n");
				}
				
			} else if (str.equals("top")) { // top일 때
				if(dq.isEmpty()) { // 비어있을 때
					sb.append("-1\n");
				}else { // 차있을 때
					sb.append(dq.peekLast() +"\n");
					
				}
				
			} else if (str.equals("size")) { //size일 때
				sb.append(dq.size() +"\n");
				
				
			}else if (str.equals("empty")) { // empty일 때 
				if(dq.isEmpty()) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}
			
		}

		System.out.println(sb.toString());
	}

}
