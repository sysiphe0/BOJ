package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1507_Graph_Floyd_Minho_190907 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] d = new int[n+1][n+1];
		int[][] unused = new int[n+1][n+1];
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++){
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean impossible = false;
		for(int k=1; k<=n; k++){
			for(int i=1; i<=n; i++){
				if(i==k) continue;
				for(int j=1; j<=n; j++){
					if(i==j) continue;
					if(k==j) continue;
					if(d[i][j] > d[i][k]+d[k][j]){
						impossible = true;
						break;
					}
					if(d[i][j] == d[i][k]+d[k][j]){
						unused[i][j] = 1;
					}
				}
				if(impossible) break;
			}
			if(impossible) break;
		}
		int ans = 0;
		if(impossible){
			bw.write("-1");
		}else{
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					if(unused[i][j] == 0){
						ans += d[i][j];
					}
				}
			}
		}
		ans = ans/2;
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
}
