import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10942_DP_palindrome_bottomUp {

	static int n,p[],d[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++){
			p[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int q[][] = new int[m+1][2];
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			q[i][0] = Integer.parseInt(st.nextToken());
			q[i][1] = Integer.parseInt(st.nextToken());
		}
		
		d = new int[n+1][n+1];
		// 1개칸 체크
		for(int i=1; i<=n; i++){
			d[i][i] = 1;
			chkPalinToDiagonal(i,i);
		}
		// 2개칸 체크
		for(int i=1; i<n; i++){
			if(p[i]==p[i+1]){
				d[i][i+1] = 1;
				chkPalinToDiagonal(i,i+1);
			}
		}
		
		// 정답 추출
		int t = 0;
		while(++t<=m){
			System.out.println(d[q[t][0]][q[t][1]]);
		}
	}
	
	static void chkPalinToDiagonal(int x,int y){
		while(x>1 && y<n){
			if(p[--x]==p[++y]){
				d[x][y] = 1;
			}else{
				break;
			}
		}
	}
}
