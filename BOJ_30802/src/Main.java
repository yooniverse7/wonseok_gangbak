import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // �� �ο�
		int[] arr = new int[6]; 
		StringTokenizer ss = new StringTokenizer(br.readLine());
		for(int i = 0; i<6; i++) {
			arr[i] = Integer.parseInt(ss.nextToken());
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Tee = Integer.parseInt(st.nextToken()); // Ƽ���� �� ����
		int Pen = Integer.parseInt(st.nextToken()); // �� �� ����
		int cnt = 0;

		for(int i = 0; i<6; i++) { // Ƽ���� ���� ī��Ʈ
			cnt +=arr[i] / Tee;
			if(arr[i] % Tee != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println(N/Pen + " " + N%Pen); // �� ������ ������
		
	}

}
