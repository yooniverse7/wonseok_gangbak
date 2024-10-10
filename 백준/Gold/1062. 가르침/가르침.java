import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

	static int N, K;
	static boolean[] visited;
	static List<LinkedList<Character>> wordList = new ArrayList<>();
	static int max = Integer.MIN_VALUE; // 읽을 수 있는 문자열 최대 개수
	static int[] alp; // 들어온 알파벳 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 단어 개수
		K = Integer.parseInt(st.nextToken()); // 알파벳 개수
		visited = new boolean[26]; 
		alp = new int[26];
		int cnt = 0;
		
		visited['a' - 'a'] = true;
		visited['c' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['t' - 'a'] = true;
		
		
		for(int i = 0; i<N; i++) {
			String word = br.readLine();
			LinkedList<Character> chars = new LinkedList<>();
			word = word.replace("anta", "");
			word = word.replace("tica", "");
			
			for(char ch : word.toCharArray()) {
				if(!visited[ch - 'a']) { // a, n, t, i, c를 제외한 문자
					chars.add(ch);
					alp[ch - 'a'] = 1; // 들어온 알파벳 확인
					
				}
			}
			wordList.add(chars);
		}
		
		for(int i = 0; i<26; i++) {
			if(alp[i] == 1) {
				cnt++;
			}
		}
		
		
		if(K<5) { // K가 5보다 작으면 0 출력
			System.out.println(0);
		} else if(K==26){ // K가 26면 모두 다 읽을 수 있으므로 N 출력
			System.out.println(N);
		} else if(cnt <= (K-5)) {
			System.out.println(N);
		} else {
			backtracking(0, 0);
			System.out.println(max);
		}
		
		
		
	}
	
	public static void backtracking(int start, int count) {
		if(count == K - 5) { // 선택을 다했다면,
			int cnt = 0; // 읽을 수 있는 단어 개수
			for(LinkedList<Character> chars : wordList) {
				boolean canRead = true;
				for(char ch : chars) {
					if(!visited[ch - 'a']) { // 방문을 하지 않은 알파벳이 있다면,
						canRead = false; // 읽을 수 없음
						break;
					}
				}
				if(canRead) cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		
		
		for(int i = start; i<26; i++) {
			if (!visited[i] && alp[i] == 1) { // 방문하지 않았는데 들어온 알파벳이라면,
				visited[i] = true;
				backtracking(i+1, count+1);
				visited[i] = false;
			}
		}
	}
	
}
