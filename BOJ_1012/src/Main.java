import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K;
	static int[][] arr;
	static boolean[][] visited;
	static int result;
	static int[] dx = {-1, 0, 1, 0}; // 위, 오른쪽, 아래, 왼쪽
	static int[] dy = {0, 1, 0, -1}; // 위, 오른쪽, 아래, 왼쪽
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			K = Integer.parseInt(st.nextToken()); // 배추 개수
			arr = new int[M][N];
			visited = new boolean[M][N];
			cnt = 0;
			
			for(int i = 0; i<K; i++) { // 배추 위치
				StringTokenizer line = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(line.nextToken());
				int y = Integer.parseInt(line.nextToken());
				
				arr[x][y] = 1;
			}
			
			for(int i = 0; i<M; i++) {
				for(int j = 0; j<N; j++) {
					if(arr[i][j] == 1 && visited[i][j] == false) {
						visited[i][j] = true;
						bfs(i, j);
					}
				}
			}
			
			System.out.println(cnt);
			
		}

	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new  LinkedList<>();
		q.add(new int[] {x, y});
		while (! q.isEmpty())  {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i = 0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX >=M || nextX <0 || nextY >=N || nextY<0 || visited[nextX][nextY] == true) { 
					continue;
				}
				if(arr[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
					q.add(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
					
				}
			}
		}
		cnt++;
		
		
	}

}
