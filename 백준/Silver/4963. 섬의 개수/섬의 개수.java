import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static int w,h;
	public static int[][] arr;
	public static boolean[][] visited;
	public static StringBuilder sb;
	public static int cnt;
	public static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1}; // 8방향
	public static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0&&h==0) break;
			
			arr = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;
			
			
			for(int i = 0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<h; i++) {
				for (int j = 0; j < w; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt + "\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int x, int y) {
	
		for(int i = 0; i<8; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;
			if(nextX < 0 || nextX>=h || nextY < 0 || nextY >= w || visited[nextX][nextY]) continue;
			
			if(arr[nextX][nextY] == 1 && !visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				 dfs(nextX, nextY);
			}
		}
	}
}
