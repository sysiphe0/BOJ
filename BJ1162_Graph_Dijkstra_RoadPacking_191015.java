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

public class BJ1162_Graph_Dijkstra_RoadPacking_191015 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Edge>[] p = (List<Edge>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Edge>();
		}
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int t3 = Integer.parseInt(st.nextToken());
			p[t1].add(new Edge(t2,t3,k));
			p[t2].add(new Edge(t1,t3,k));
		}
		
		int[][] c = new int[n+1][k+1];
		long[][] d = new long[n+1][k+1];
		for(int i=2; i<=n; i++){
			for(int j=0; j<=k; j++){
				d[i][j] = Long.MAX_VALUE;
			}
		}
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(1,new Compare());
		pq.add(new Edge(1,0,k));
		
		while(!pq.isEmpty()){
			Edge now = pq.poll();
			int x = now.e;
			int cnt = now.cnt;
			if(c[x][cnt]==1) continue;
			c[x][cnt] = 1;
			for(Edge next : p[x]){
				int y = next.e;
				if(d[y][cnt] > d[x][cnt] + next.c){
					d[y][cnt] = d[x][cnt] + next.c;
					if(c[y][cnt]==0){
						pq.add(new Edge(y,d[y][cnt],cnt));
					}
				}
				if(cnt > 0 && d[y][cnt-1] > d[x][cnt]){
					d[y][cnt-1] = d[x][cnt];
					if(c[y][cnt-1]==0){
						pq.add(new Edge(y,d[y][cnt-1],cnt-1));
					}
				}
			}
		}
		
		long ans = Long.MAX_VALUE;
		for(int i=0; i<=k; i++){
			ans = Math.min(ans, d[n][i]);
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	
	static class Edge{
		int e,cnt;
		long c;
		public Edge(int e, long c, int cnt){
			this.e=e;
			this.c=c;
			this.cnt=cnt;
		}
	}
	
	static class Compare implements Comparator<Edge>{
		public int compare(Edge one, Edge two){
			return Long.compare(one.c, two.c);
		}
	}
}
