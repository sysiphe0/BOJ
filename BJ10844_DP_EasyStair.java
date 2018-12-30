import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10844_DP_EasyStair {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long d[][] = new long[n+1][10];
		for(int i=1; i<=9; i++){
			d[1][i] = 1;
		}
		for(int i=2; i<=n; i++){
			d[i][0] = d[i-1][1]%1000000000;
			for(int j=1; j<=8; j++){
				d[i][j] = (d[i-1][j-1]+d[i-1][j+1])%1000000000;
			}
			d[i][9] = d[i-1][8]%1000000000;
		}
		long sol = 0;
		for(int i=0; i<=9; i++){
			sol += d[n][i];
		}
		System.out.println(sol%1000000000);
	}
}
