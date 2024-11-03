import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	static LinkedList<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] temp = new int[M];
		for(int i = 0 ; i < M ; i++)
			temp[i] = Integer.parseInt(st.nextToken());
		
		// 필요한 변수
		// 일단 뽑아낼 원소의 위치가 left가 빠른지 right가 빠른지 판별하는 것
		// 아마도 q.size 절반보다 작으면 left 아니면 right가 빠르다.
		// 그걸로 보내주면 끝
		for(int i = 1 ; i <= N ; i++)
			q.add(i);
		
		for(int i = 0 ; i < M ; i++) {
			
			if(check(temp[i])) {
				while(temp[i]!=q.get(0)) {
				q.addLast(q.pollFirst());
				count++;
				}
			}else {
				while(temp[i]!=q.get(0)) {
				q.addFirst(q.pollLast());
				count++;
				}
			}
			
			q.poll();
		}

		
		System.out.println(count);

		}
	public static boolean check(int a) {
		
		for(int i = 0 ; i <= q.size()/2 ; i++) {
			if(a == q.get(i))
				return true;
		}
		
		return false;
	}

}