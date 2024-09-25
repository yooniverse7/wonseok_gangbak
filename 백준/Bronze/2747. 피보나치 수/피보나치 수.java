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
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i<=N; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		
		System.out.println(arr[N]);
	}
		
}