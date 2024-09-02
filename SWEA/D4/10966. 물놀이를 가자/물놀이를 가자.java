import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static int N, M, sum;
	public static int[][] arr;
	public static boolean[][] visited;
	public static Deque<int[]> dq;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			visited = new boolean[N][M];
			dq = new ArrayDeque<int[]>();
			sum = 0;
			
			for(int i = 0; i<N; i++) {
				String[] elements = br.readLine().split("");
				for(int j = 0; j<M; j++) {
					if(elements[j].equals("W")) { // 물은 덱에 넣기
						arr[i][j] = 0;
						dq.offer(new int[]{i, j});
						visited[i][j] = true;
					} else {
						arr[i][j] = -1;
					}
				}
			}
			
			bfs(dq);
			
			
			sb.append("#").append(tc + " ").append(sum + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs(Deque<int[]>dq) {
		while (!dq.isEmpty()) {
			int[] n = dq.poll();
			int nx = n[0];
			int ny = n[1];
			for(int i = 0; i<4; i++) {
				int nextX = nx + dx[i];
				int nextY = ny + dy[i];
				
				if(nextX < 0 || nextX >=N || nextY < 0 || nextY>=M || visited[nextX][nextY]) continue;
				if(arr[nextX][nextY]==-1 && !visited[nextX][nextY]) {
					arr[nextX][nextY] = arr[nx][ny] + 1;
					sum += arr[nextX][nextY];
					visited[nextX][nextY] = true;
					dq.offer(new int[] {nextX, nextY});
				}
			}
			
		}
		
	}
}
