import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[21];
		StringBuilder sb = new StringBuilder(); 
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String element = st.nextToken();
			int x;
			if(element.equals("add")) {
				x = Integer.parseInt(st.nextToken());
				visited[x] = true;
			}
			else if(element.equals("check")) {
				x = Integer.parseInt(st.nextToken());
				if(visited[x]) { // x가 있다면,
					sb.append("1" + "\n");
				}else { // x가 없다면, 
					sb.append("0" + "\n");
				}
			}
			else if(element.equals("remove")){
				x = Integer.parseInt(st.nextToken());
				visited[x] = false;
			}
			
			else if(element.equals("toggle")) {
				x = Integer.parseInt(st.nextToken());
				if(visited[x]) { // x가 있다면,
					visited[x] = false;
				}else { // x가 없다면, 
					visited[x] = true;
				}
			}
			
			else if(element.equals("all")) {
				Arrays.fill(visited, true);
			}
			else if(element.equals("empty")) {
				Arrays.fill(visited, false);
			}
		}
		
		System.out.println(sb.toString());
	}

}
