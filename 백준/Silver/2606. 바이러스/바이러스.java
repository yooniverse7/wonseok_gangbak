import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	public static int w,h;
	public static boolean[] visited;
	public static StringBuilder sb;
	public static int cnt;
	public static ArrayList<List<Integer>> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 노드 개수
		int M = Integer.parseInt(br.readLine()); // 간선 개수
		visited = new boolean[N+1];
		list = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list.get(n1).add(n2);
			list.get(n2).add(n1);
		}
		
		dfs(1);
		
		cnt = 0;
		for(int i = 0; i<=N; i++) {
			if(visited[i]) cnt++;
		}
		
		System.out.println(cnt-1);
	}
	
	public static void dfs(int x) {
		visited[x] = true;
		for(int n : list.get(x)) {
			if(!visited[n]) {
				dfs(n);
			}
		}
	}
}
