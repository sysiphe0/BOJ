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
		
		/*1. 초기셋팅(base condition)*/
		
		// 1-1) 2차원행렬 d의 (S==E인) 대각선은 모두 1이다. S==E인 한자리 숫자는 무조건 팰린드롬이기때문.
		for(int i=1; i<=n; i++){
			d[i][i]=1;
		}
		
		// 1-2) E==S+1 인 두글자까지 초기 셋팅해준다.
		for(int i=1; i<n; i++){
			if(p[i]==p[i+1]) d[i][i+1] = 1;
		}
		
		/*2. 본 로직(DP) 시작*/
		
		// 2-1) p[S]==p[E]이면서 d[S+1][E-1]==1 이면 팰린드롬이다. (※ p[S]!=p[E]이면 무조건 팰린드론아니다.)
		int k = 3; // 체크하려는 글자 자리수
		while(k<=n){ // 체크 글자수가 글자수범위를 넘으면 loop중단.
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
		
		/*3. 질문받고 정답 출력*/
		
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
