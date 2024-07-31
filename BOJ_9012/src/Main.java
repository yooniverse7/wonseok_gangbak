import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bReader.readLine());
		
		
		for(int i = 0; i<n; i++) {
			Stack<Character> stack = new Stack<>();
			String str = bReader.readLine();
			boolean result = true;
			
			for(int j = 0; j<str.length(); j++) {
				if(str.charAt(j) == '(') {
					stack.push(str.charAt(j));
				}else if(stack.isEmpty()) {
					result = false;
					break;
				}else {
					stack.pop();
				}
			}

			if(result) {
				if(stack.isEmpty()) {
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}else {
				sb.append("NO\n");
			}
			
			
		}
		
		System.out.println(sb.toString());
	}

}
