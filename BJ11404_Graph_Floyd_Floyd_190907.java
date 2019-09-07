package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11404_Graph_Floyd_Floyd_190907 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[][] d = new int[n+1][n+1];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(i!=j){
					d[i][j] = 10000001;
				}
			}
		}
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());
			if(d[tmp1][tmp2] > tmp3){
				d[tmp1][tmp2] = tmp3;
			}
		}
		
		for(int k=1; k<=n; k++){
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					if(d[i][j] > d[i][k]+d[k][j]){
						d[i][j] = d[i][k]+d[k][j];
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(d[i][j]>=10000001){
					bw.write("0");
				}else{
					bw.write(d[i][j]+"");
				}
				if(j!=n){
					bw.write(" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
