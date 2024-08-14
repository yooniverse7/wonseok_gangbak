import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			Deque<Character> dq = new ArrayDeque<>();
			String st = br.readLine();
			boolean result = true;
			
			cute: for(int j = 0; j<N; j++) {
				char pair = st.charAt(j);
				if(pair == '(' || pair == '{' || pair == '[' || pair == '<') {
					dq.addLast(pair);
				}
				else {
					if(!dq.isEmpty()) {
						char check = dq.peekLast();
						if(pair == ')' && check == '(') {
							dq.pollLast();
						} else if(pair == '}' && check == '{') {
							dq.pollLast();
						} else if(pair == ']' && check == '[') {
							dq.pollLast();
						}else if(pair == '>' && check == '<') {
							dq.pollLast();
						}else {
							result = false;
							break cute;
						}
					} else {
						result = false;
					}
				}
				
			}
			
			if(result) {
				if(dq.isEmpty()) {
					System.out.println("#" + i + " " + 1);
				}else {
					System.out.println("#" + i + " " + 0);
				}
			}else {
				System.out.println("#" + i + " " + 0);
			}
			
		}
        
        
		
		
		
	}

}
