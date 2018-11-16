import java.util.Scanner;

public class BJ11048_DP_Move_TopDown {

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
					d[i][j] = -1;
				}
			}
			//Top-Down
			int result = go(n,m);
			System.out.println(d[n][m]);
		}
	}
	
	static int go(int x, int y){
		if(x==1 && y==1) return p[1][1];
		if(x<1 || y<1) return 0;
		if(d[x][y] >= 0){
			return d[x][y];
		}
		d[x][y] = Math.max(go(x-1,y), go(x,y-1))+p[x][y];
		return d[x][y];
	}
	
}
