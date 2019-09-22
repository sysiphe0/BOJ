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

public class BJ16398_Graph_MST_Prime_190922 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		List<Edge>[] p = (List<Edge>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Edge>();
		}
		int[] vst = new int[n+1];
		
		Compare cmp = new Compare();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(1,cmp);
		long ans = 0;
		
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++){
				int tmp = Integer.parseInt(st.nextToken());
				if(i!=j){
					p[i].add(new Edge(j,tmp));
					if(tmp==0){
						pq.add(new Edge(j,tmp));
					}
				}
			}
		}
		
		if(pq.isEmpty()){
			pq.add(new Edge(1,0));
		}
		
		while(!pq.isEmpty()){
			Edge now = pq.poll();
			if(vst[now.e]==1) continue;
			vst[now.e]=1;
			ans += now.c;
			for(Edge next : p[now.e]){
				if(vst[next.e]==1) continue;
				pq.add(next);
			}
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		
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
