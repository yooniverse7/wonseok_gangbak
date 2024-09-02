import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static int M, N, K;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static ArrayList<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		visited = new boolean[M][N];
		list = new ArrayList<>();
		
		for(int i = 0; i<K; i++){
			st = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(st.nextToken()); // 첫번째 꼭짓점값
			int fy = Integer.parseInt(st.nextToken());
			int lx = Integer.parseInt(st.nextToken()); // 마지막 꼭짓점 값 
			int ly = Integer.parseInt(st.nextToken());
			
			for(int j = fy; j < ly; j++ ) {
				for(int z = fx; z < lx; z++) {
					arr[j][z] = 1;
				}
			}
			
		}

		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j] == 0 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(list);
		
		sb = new StringBuilder();
		sb.append(list.size() + "\n");
		for(int n : list ) {
			sb.append(n + " ");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void bfs(int x, int y) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {x, y});
		int cnt = 1;
		while(!dq.isEmpty()) {
			int[] n = dq.poll();
			int nx = n[0];
			int ny = n[1];
			for(int i = 0; i<4; i++) {
				int nextX = nx + dx[i];
				int nextY = ny + dy[i];
				
				if(nextX<0 || nextX >= M || nextY<0 || nextY >= N || arr[nextX][nextY] == 1 || visited[nextX][nextY]) continue;
				
				if(arr[nextX][nextY] == 0 && visited[nextX][nextY] == false) {
					visited[nextX][nextY] = true;
					dq.offer(new int[] {nextX, nextY});
					cnt++;
				}
					
			}
		}
		list.add(cnt);
		
	}

}
