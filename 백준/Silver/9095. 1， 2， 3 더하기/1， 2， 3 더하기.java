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
	
		int[] arr = new int[11];
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		
		for(int i = 3; i<11; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			System.out.println(arr[Integer.parseInt(br.readLine())-1]);
		}
		
	}
		
}