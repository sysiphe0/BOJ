import java.util.Scanner;

public class BJ11048_DP_Move_BottomUp {

	static int p[][],n,m,d[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		for(int T=1; T<=tc; T++){
			n = sc.nextInt();
			m = sc.nextInt();
			p = new int[n+1][m+1];
			d = new int[n+1][m+1];
			
			for(int i=1; i<=n; i++){
				for(int j=1; j<=m; j++){
					p[i][j] = sc.nextInt();
				}
			}
			
			d[1][1] = p[1][1];
			for(int i=1; i<=n; i++){
				for(int j=1; j<=m; j++){
					if(i==1 && j==1) continue;
					d[i][j] = Math.max(Math.max(d[i-1][j],d[i][j-1]),d[i-1][j-1])+p[i][j];
				}
			}
			System.out.println(d[n][m]);
		}
	}
	
}
