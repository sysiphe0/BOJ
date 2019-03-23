import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2167_DP_2x2matrixSum {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int p[][] = new int[n+1][m+1];
		int d[][] = new int[n+1][m+1];
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++){
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// (1,1)���� (i,j)������ �� ���� d[][]�� ����
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				if(i==1){
					if(j==1) d[i][j] = p[i][j];
					else d[i][j] = d[i][j-1]+p[i][j];
				}else if(j==1){
					d[i][j] = d[i-1][j]+p[i][j];
				}else{
					d[i][j] = d[i-1][j]+d[i][j-1]-d[i-1][j-1]+p[i][j];
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		
		// (sx,sy) ~ (ex,ey)�� ���� d[ex][ey]���� (sx,sy)�� ��,�� �簢���� ���� �ٽ� �밢���� �簢��(sx-1,sy-1)�� ���� ���̴�. 
		for(int i=1; i<=k; i++){
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			if(sx==1){
				if(sy==1) System.out.println(d[ex][ey]);
				else System.out.println(d[ex][ey]-d[ex][sy-1]);
			}else if(sy==1){
				System.out.println(d[ex][ey]-d[sx-1][ey]);
			}else{
				System.out.println(d[ex][ey]-d[ex][sy-1]-d[sx-1][ey]+d[sx-1][sy-1]);
			}
		}
	}

}
