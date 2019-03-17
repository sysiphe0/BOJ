import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ10942_DP_palindrome_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p[] = new int[n+1];
		int d[][] = new int[n+1][n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++){
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		/*1. �ʱ����(base condition)*/
		
		// 1-1) 2������� d�� (S==E��) �밢���� ��� 1�̴�. S==E�� ���ڸ� ���ڴ� ������ �Ӹ�����̱⶧��.
		for(int i=1; i<=n; i++){
			d[i][i]=1;
		}
		
		// 1-2) E==S+1 �� �α��ڱ��� �ʱ� �������ش�.
		for(int i=1; i<n; i++){
			if(p[i]==p[i+1]) d[i][i+1] = 1;
		}
		
		/*2. �� ����(DP) ����*/
		
		// 2-1) p[S]==p[E]�̸鼭 d[S+1][E-1]==1 �̸� �Ӹ�����̴�. (�� p[S]!=p[E]�̸� ������ �Ӹ���оƴϴ�.)
		int k = 3; // üũ�Ϸ��� ���� �ڸ���
		while(k<=n){ // üũ ���ڼ��� ���ڼ������� ������ loop�ߴ�.
			for(int x=1; x<=n; x++){
				int y = x+k-1;
				if(y<=n){
					if(p[x]==p[y] && d[x+1][y-1]==1){
						d[x][y] = 1;
					}
				}else{
					break;
				}
			}
			k++;
		}
		
		/*3. �����ް� ���� ���*/
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			bw.write(d[x][y]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
}
