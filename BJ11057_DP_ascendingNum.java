import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11057_DP_ascendingNum {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int sum[][] = new int[n+1][10];
		for(int i=0; i<10 ;i++){
			sum[1][i] = i+1;
		}
		for(int i=2; i<=n; i++){
			sum[i][0] = 1;
			for(int j=1; j<10; j++){
				sum[i][j] = (sum[i][j-1] + sum[i-1][j])%10007;
			}
		}
		System.out.println(sum[n][9]);
	}
}
