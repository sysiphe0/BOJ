import java.util.Scanner;

public class BJ1890_DP_jump {
	
	static int n, p[][];
	static long d[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;
		
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			p = new int[n+1][n+1];
			d = new long[n+1][n+1];
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					p[i][j] = sc.nextInt();
				}
			}
			d[1][1] = 1;
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					if(p[i][j]==0) continue;
					if(j+p[i][j]<=n) d[i][j+p[i][j]] += d[i][j];
					if(i+p[i][j]<=n) d[i+p[i][j]][j] += d[i][j];
				}
			}
			System.out.println(d[n][n]);
		}
	}
}
