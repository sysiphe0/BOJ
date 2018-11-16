import java.util.Scanner;

public class BJ1520_DP_Naerimakgil {

	static int n, m, p[][];
	static long d[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			m = sc.nextInt();
			p = new int[n+1][m+1];
			d = new long[n+1][m+1];
			for(int i=1; i<=n; i++){
				for(int j=1; j<=m; j++){
					p[i][j] = sc.nextInt();
					d[i][j] = -1;
				}
			}
			d[n][m]=1;
			go(1,1);
			
			System.out.println(d[1][1]);
		}
	}
	
	static long go(int x, int y){
		if(d[x][y] < 0){
			d[x][y]=0;
			if(x>1 && p[x][y] > p[x-1][y]){
				d[x][y] += go(x-1,y);
			}
			if(y>1 && p[x][y] > p[x][y-1]){
				d[x][y] += go(x,y-1);
			}
			if(y<m && p[x][y] > p[x][y+1]){
				d[x][y] += go(x,y+1);
			}
			if(x<n && p[x][y] > p[x+1][y]){
				d[x][y] += go(x+1,y);
			}
		}
		return d[x][y];
	}
	
}
