import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int r, c, dir;
	public static int[][] arr;
	// 방향: 북, 동, 남, 서 (0: 북, 1: 동, 2: 남, 3: 서)
	public static int[] dx = {-1, 0, 1, 0}; 
	public static int[] dy = {0, 1, 0, -1};
	public static int cnt;
	
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new int[N][M];
    	
    	cnt = 0;
    	
    	st = new StringTokenizer(br.readLine());
    	r = Integer.parseInt(st.nextToken()); // 좌표
    	c = Integer.parseInt(st.nextToken());
    	dir = Integer.parseInt(st.nextToken()); // 방향 
    	
    	for(int i = 0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<M; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	clean(r, c, dir);
    	
    	System.out.println(cnt);
	}
    
    public static void clean(int r, int c, int dir) {
		if(arr[r][c] == 0) { // 청소되지 않은 곳이라면
			arr[r][c] = 2;   // 청소 완료
			cnt++;
		}
		
		boolean cleaned = false;
		
		for(int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4; // 왼쪽으로 회전
			int nx = r + dx[dir];
			int ny = c + dy[dir];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
				clean(nx, ny, dir);
				cleaned = true;
				break;
			}
		}
		
		if (!cleaned) { // 4방향 모두 청소되었거나 벽인 경우 후진
			switch (dir) {
				case 0: // 북
					if (r + 1 < N && arr[r + 1][c] != 1) {
						clean(r + 1, c, dir);
					}
					break;
				case 1: // 동
					if (c - 1 >= 0 && arr[r][c - 1] != 1) {
						clean(r, c - 1, dir);
					}
					break;
				case 2: // 남
					if (r - 1 >= 0 && arr[r - 1][c] != 1) {
						clean(r - 1, c, dir);
					}
					break;
				case 3: // 서
					if (c + 1 < M && arr[r][c + 1] != 1) {
						clean(r, c + 1, dir);
					}
					break;
			}
		}
	}
}
