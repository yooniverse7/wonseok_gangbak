import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static Map<Integer, List<Integer>> board;
	public static int[] parent;
	public static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 노드 개수
		board = new HashMap<>(); // 노드 연결 정보
		parent = new int[N+1]; // 부모 노드 저장
		
		Arrays.fill(parent, -1); // 부모 배열 초기화
        parent[1] = 1; // 1번 노드는 루트 
		
		
		for(int i = 0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			if(board.containsKey(key)) { // 해당 키값이 있으면 거기에 value 추가
				board.get(key).add(value);
				
			} else { // 해당 키값없으면 새로운 맵 추가 
				List<Integer> list = new ArrayList<>();
				list.add(value);
				board.put(key, list);
			}
			if(board.containsKey(value)) { // 해당 키값이 있으면 거기에 value 추가
				board.get(value).add(key);
				
			} else { // 해당 키값없으면 새로운 맵 추가 
				List<Integer> list = new ArrayList<>();
				list.add(key);
				board.put(value, list);
			}
		
 		}
		
		bfs(1);
		
		for(int i = 2; i<N+1; i++) {
			System.out.println(parent[i]);
		}
		
		
	}
	
	
	public static void bfs(int x) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(x);
		
		while (!dq.isEmpty()) {
			int checkNum = dq.poll();
			List<Integer> targetValue = board.get(checkNum);
			for(int i = 0; i<targetValue.size(); i++) {
				int num = targetValue.get(i);
				if(parent[num] == -1) { // 방문하지 않았다면,
					parent[num] = checkNum; // 해당 키값을 부모로 넣기
					dq.offer(num); // 큐에 담기
				}
			}
			
		}
		
	}

}