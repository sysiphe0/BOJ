package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1719_Graph_Dijkstra_Delivery_190921 {

	static int[][] sol;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Edge>[] p = (List<Edge>[])new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Edge>();
		}
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int t3 = Integer.parseInt(st.nextToken());
			p[t1].add(new Edge(t2,t3));
			p[t2].add(new Edge(t1,t3));
		}

		sol = new int[n+1][n+1];
		Compare cmp = new Compare();
		for(int i=1; i<=n; i++){
			int[] c = new int[n+1];
			int[] d = new int[n+1];
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>(1,cmp);
			for(int j=1; j<=n; j++){
				d[j] = Integer.MAX_VALUE;
			}
			d[i] = 0;
			pq.add(new Edge(i,0));
			while(!pq.isEmpty()){
				Edge now = pq.poll();
				int x = now.e;
				if(c[now.e]==1) continue;
				c[now.e] = 1;
				for(Edge next : p[x]){
					int y = next.e;
					if(d[y] > d[x]+next.c){
						d[y] = d[x]+next.c;
						pq.add(new Edge(y,d[y]));
						sol[i][y] = x;
					}
				}
			}
		}
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(i==j){
					bw.write("-");
				}else{
					bw.write(find(i,j)+"");
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
	
	static int find(int x, int y){
		if(x==sol[x][y]){
			return y;
		}else{
			return find(x,sol[x][y]);
		}
	}
	
	static class Edge{
		int e;
		int c;
		public Edge(int e, int c){
			this.e=e;
			this.c=c;
		}
	}
	
	static class Compare implements Comparator<Edge>{
		public int compare(Edge one, Edge two){
			return Integer.compare(one.c, two.c);
		}
	}
}
