package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11403_Graph_Floyd_FindPath_190907 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] d = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++){
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=1; k<=n; k++){
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					if(d[i][k]==1 && d[k][j]==1){
						d[i][j]=1;
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				bw.write(d[i][j]+"");
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
