package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11780_Graph_Floyd_Floyd2_190907 {
	static int[][] v, d;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		d = new int[n+1][n+1];
		v = new int[n+1][n+1];
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
						v[i][j] = k;
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
		
		ArrayDeque<Integer> path = new ArrayDeque<Integer>();
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(i==j){
					bw.write("0\n");
				}else{
					findPath(i,j,path);
					int size = path.size();
					bw.write(size+" ");
					for(int p=1; p<=size; p++){
						bw.write(path.pollFirst()+"");
						if(p!=size){
							bw.write(" ");
						}
					}
					bw.write("\n");
				}
				path.clear();
			}
		}
		bw.flush();
		bw.close();
	}
	
	static void findPath(int i, int j, ArrayDeque<Integer> path){
		if(v[i][j]==0){
			path.addLast(i);
			if(i!=j){
				path.addLast(j);
			}
		}else{
			findPath(i,v[i][j],path);
			path.pollLast();
			findPath(v[i][j],j,path);
		}
	}
}
