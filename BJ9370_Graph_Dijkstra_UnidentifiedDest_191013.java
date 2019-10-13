package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ9370_Graph_Dijkstra_UnidentifiedDest_191013 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int[] dest = new int[t+1];
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			List<Edge>[] p = (List<Edge>[]) new List[n+1];
			for(int i=1; i<=n; i++){
				p[i] = new ArrayList<Edge>();
			}
			for(int i=1; i<=m; i++){
				st = new StringTokenizer(br.readLine());
				int t1 = Integer.parseInt(st.nextToken());
				int t2 = Integer.parseInt(st.nextToken());
				int t3 = Integer.parseInt(st.nextToken());
				t3 = t3*2;
				if((t1==g && t2==h) || (t1==h && t2==g)){
					t3--;
				}
				p[t1].add(new Edge(t2,t3));
				p[t2].add(new Edge(t1,t3));
			}
			for(int i=1; i<=t; i++){
				st = new StringTokenizer(br.readLine());
				dest[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(dest);
			Compare cmp = new Compare();
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>(1,cmp);
			pq.add(new Edge(s,0));
			int[] d = new int[n+1];
			for(int i=1; i<=n; i++){
				d[i] = Integer.MAX_VALUE;
			}
			d[s] = 0;
			int[] c = new int[n+1];
			
			while(!pq.isEmpty()){
				Edge now = pq.poll();
				int x = now.e;
				if(c[x]==1) continue;
				c[x] = 1;
				for(Edge next : p[x]){
					int y = next.e;
					if(d[y] > d[x]+next.c){
						d[y] = d[x]+next.c;
						if(c[y] == 0){
							pq.add(new Edge(y,d[y]));
						}
					}
				}
			}
			ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
			for(int i=1; i<=t; i++){
				if(d[dest[i]] != Integer.MAX_VALUE && d[dest[i]]%2==1){
					dq.add(dest[i]);
				}
			}
			while(!dq.isEmpty()){
				bw.write(dq.pollFirst()+"");
				if(!dq.isEmpty()){
					bw.write(" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	static class Edge{
		int e,c;
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
