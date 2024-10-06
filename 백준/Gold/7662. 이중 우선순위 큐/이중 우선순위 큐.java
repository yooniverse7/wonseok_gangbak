import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (s.equals("I")) { // 값 추가
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (s.equals("D") && !map.isEmpty()) { // 값 삭제
                    if (num == 1) { // 최댓값 삭제
                        int maxKey = map.lastKey();
                        if (map.put(maxKey, map.get(maxKey) - 1) == 1) {
                            map.remove(maxKey);
                        }
                    } else if (num == -1) { // 최솟값 삭제
                        int minKey = map.firstKey();
                        if (map.put(minKey, map.get(minKey) - 1) == 1) {
                            map.remove(minKey);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
