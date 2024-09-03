import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int caseNumber = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            dist[0][0] = map[0][0];
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0, map[0][0]));

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int x = current.x;
                int y = current.y;
                int cost = current.cost;

                if (x == N - 1 && y == N - 1) {
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        int newCost = cost + map[nx][ny];
                        if (newCost < dist[nx][ny]) {
                            dist[nx][ny] = newCost;
                            pq.add(new Node(nx, ny, newCost));
                        }
                    }
                }
            }

            sb.append("Problem ").append(caseNumber++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
