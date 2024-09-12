import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
   public static int N;
   public static int M;
   public static int V;
   public static boolean[] visit;
   public static int[][] arr;
   public static StringBuilder sb = new StringBuilder();

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());

      arr = new int[N+1][N+1];
      visit = new boolean[N+1];

      for (int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine());
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());

         arr[x][y] = arr[y][x] = 1;
      }

      dfs(V);
      Arrays.fill(visit, false);
      bfs(V);
      System.out.println(sb);
   }

   public static void dfs(int num) {
      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(num);
      while (!stack.isEmpty()) {
         int current = stack.pop();
         if (!visit[current]) {
            visit[current] = true;
            sb.append(current).append(" ");
            for (int i = N; i >= 1; i--) {
               if (arr[current][i] == 1 && !visit[i]) {
                  stack.push(i);
               }
            }
         }
      }
   }

   public static void bfs(int num) {
      Deque<Integer> queue = new ArrayDeque<>();
      queue.add(num);
      visit[num] = true;
      sb.append('\n').append(num).append(" ");
      while (!queue.isEmpty()) {
         int current = queue.poll();
         for (int i = 1; i <= N; i++) {
            if (arr[current][i] == 1 && !visit[i]) {
               queue.add(i);
               visit[i] = true;
               sb.append(i).append(" ");
            }
         }
      }
   }
}
