import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        
        for(int i = 0; i < 12; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }
        
        int cnt = 0;
        while (true) {
            end = true;
            visited = new boolean[12][6];

            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    if(map[i][j] != '.' && !visited[i][j]) {
                        if(bfs(i, j, map[i][j])) {
                            end = false;
                        }
                    }
                }
            }
            
            // 터진 블록이 없으면 종료
            if (end) {
                break;
            }
            
            // 블록 떨어트리기
            dropBlocks();
            cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean bfs(int x, int y, char c) {
        Deque<int[]> dq = new ArrayDeque<>();
        List<int[]> toRemove = new ArrayList<>();
        dq.offer(new int[] {x, y});
        visited[x][y] = true;
        toRemove.add(new int[] {x, y});
        int sum = 1;

        while (!dq.isEmpty()) {
            int[] n = dq.poll();
            int nextX = n[0];
            int nextY = n[1];
            for(int i = 0; i < 4; i++) {
                int nx = nextX + dx[i];
                int ny = nextY + dy[i];
                if(nx >= 0 && nx < 12 && ny >= 0 && ny < 6 
                        && !visited[nx][ny] && map[nx][ny] == c) {
                    visited[nx][ny] = true;
                    dq.offer(new int[] {nx, ny});
                    toRemove.add(new int[] {nx, ny});
                    sum++;
                }
            }
        }

        // 4개 이상 연결된 경우 블록을 터뜨림
        if(sum >= 4) {
            for (int[] pos : toRemove) {
                map[pos[0]][pos[1]] = '.';
            }
            return true; // 블록을 터뜨렸음을 반환
        }

        return false; // 터뜨릴 블록이 없음을 반환
    }

    // 터진 후 블록들 떨어트리는 함수
    public static void dropBlocks() {
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] == '.') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != '.') {
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
