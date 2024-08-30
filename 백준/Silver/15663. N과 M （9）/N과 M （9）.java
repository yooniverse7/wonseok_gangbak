import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	public static int N, M;
	public static int[] result;
	public static boolean[] visited;
	public static int[] arr;
	public static HashSet<String> hs;
	public static StringBuilder sb, sb2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		visited = new boolean[N];
		arr = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		dfs(0);
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth) {
		HashSet<Integer> hs = new HashSet<>();
		if (depth == M) {
			for(int i = 0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i<N; i++) {
			if (!visited[i] && !hs.contains(arr[i])) {
				visited[i] = true;
				result[depth] = arr[i];
				hs.add(result[depth]);
				dfs(depth + 1);
				visited[i] = false;
			}
		}
		
	}

}
