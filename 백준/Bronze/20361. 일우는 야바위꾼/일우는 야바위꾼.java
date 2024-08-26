import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // ������ ����
		int X = Integer.parseInt(st.nextToken()); // ���� ó�� ��ġ
		int K = Integer.parseInt(st.nextToken()); // ������ �̵� Ƚ��
		int[] arr = new int[N];
		arr[X-1] = 1; // �ʱ� ��ġ�� ���� ����ֱ�
		
		
		
		for(int i = 0; i<K; i++) { // ���� ��ġ �Ű��ֱ� 
			StringTokenizer str = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(str.nextToken())-1;
			int n2 = Integer.parseInt(str.nextToken())-1;
		
			int tmp = arr[n1];
			
			arr[n1] = arr[n2];
			arr[n2] = tmp;
		}
	
		for(int i = 0; i<N; i++) {
			if(arr[i] == 1) {
				sb.append(i+1);
			}
		}
			
			
		
		System.out.println(sb.toString());
	}

}
