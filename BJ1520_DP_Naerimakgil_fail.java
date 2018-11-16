import java.util.Scanner;

public class BJ1520_DP_Naerimakgil_fail {

	static int n, m, p[][], d[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			m = sc.nextInt();
			p = new int[n+1][m+1];
			d = new int[n+1][m+1];
			for(int i=1; i<=n; i++){
				for(int j=1; j<=m; j++){
					p[i][j] = sc.nextInt();
				}
			}
			d[1][1]=1;
			for(int i=1; i<=n; i++){
				for(int j=1; j<=m; j++){
					if(d[i][j] != 0){
						if(i<n && p[i][j] > p[i+1][j]) d[i+1][j]++;
						if(j<m && p[i][j] > p[i][j+1]) d[i][j+1]++;
						if(i>1 && p[i][j] > p[i-1][j]) d[i-1][j]++;
						if(j>1 && p[i][j] > p[i][j-1]) d[i][j-1]++;
					}
				}
			}
			
			System.out.println(d[n][m]);
			for(int i=1; i<=n; i++){
				for(int j=1; j<=m; j++){
					System.out.print(d[i][j]);
				}
				System.out.println();
			}
		}
	}
}
