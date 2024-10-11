import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, H;
    public static int[][][] tomato;
    public static boolean[][][] visited;
    public static int[] dh = {-1, 0, 0, 1, 0, 0};
    public static int[] dx = {0, -1, 1, 0, 0, 0};
    public static int[] dy = {0, 0, 0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][M][N];
        visited = new boolean[H][M][N];
        
        Deque<int[]> dq = new ArrayDeque<>();
        
        for (int h = 0; h < H; h++) {
        	for (int i = 0; i < M; i++) {
        		st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    tomato[h][i][j] = Integer.parseInt(st.nextToken());
                    if (tomato[h][i][j] == 1) {
                        dq.offer(new int[] {h, i, j}); // 익은 토마토를 모두 큐에 넣음
                        visited[h][i][j] = true;
                    } else if (tomato[h][i][j] == -1) {
                        visited[h][i][j] = true; // 토마토가 없는 곳도 방문 처리
                    }
                }
            }
		}
        
        bfs(dq);
        
        int max = 0;
        for(int h = 0; h<H; h++) {
        	for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (tomato[h][i][j] == 0) { // 익지 않은 토마토가 있다면
                        System.out.println("-1");
                        return;
                    }
                    max = Math.max(max, tomato[h][i][j]);
                }
            }
        }
        
        System.out.println(max - 1); // 첫 날을 1로 시작했으므로 최종 값에서 1을 뺌
    }
    
    public static void bfs(Deque<int[]> dq) {
        while (!dq.isEmpty()) {
            int[] n = dq.poll();
            int nh = n[0];
            int nx = n[1];
            int ny = n[2];
            for (int i = 0; i < 6; i++) {
            	int nextH = nh + dh[i];
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];
                if (nextH <0 || nextH >= H || nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || visited[nextH][nextX][nextY]) 
                    continue;
                
                if (tomato[nextH][nextX][nextY] == 0) { // 안 익은 토마토를 발견하면
                    tomato[nextH][nextX][nextY] = tomato[nh][nx][ny] + 1; // 익히고, 날짜 증가
                    visited[nextH][nextX][nextY] = true;
                    dq.offer(new int[] {nextH, nextX, nextY});
                }
            }
        }
    }
}
