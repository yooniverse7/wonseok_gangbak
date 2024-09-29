import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집합 내 문자열 수
		int M = Integer.parseInt(st.nextToken()); // 탐색할 문자열 수
		HashSet<String> hSet = new HashSet<>(); // 탐색할 문자열 셋
		
		int result = 0; // 포함된 문자열 개수
		
		for(int i = 0; i<N; i++) {
			hSet.add(br.readLine());
		}
		
		
		for(int i = 0; i<M; i++) {
			String element = br.readLine();
			if(hSet.contains(element)) {
				result++;
			}
		}
		sb.append(result);
		
		System.out.println(sb.toString());
	}
		
}