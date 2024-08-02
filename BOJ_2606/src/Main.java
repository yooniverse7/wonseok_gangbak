import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static boolean[] visited;
	static int[][] arr;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		M = Integer.parseInt(br.readLine()); // 간선 개수
		
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u][v] = arr[v][u] = 1;
		}
		visited[1] = true;
		System.out.println(bfs(1));
		

	}
	
	public static int bfs(int x) {
		int cnt = 0;
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(x);
		while (!deque.isEmpty()) {
			int temp = deque.poll();
			for(int i=1; i<=N; i++) {
				if(arr[temp][i] == 1 && !visited[i]) {
					deque.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}

}
