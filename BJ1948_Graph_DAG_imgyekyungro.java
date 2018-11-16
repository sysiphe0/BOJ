import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ1948_Graph_DAG_imgyekyungro {

	static int n,m,s[],st,ed,ind1[],ans; //숫자,간선갯수,정점까지시간,시작정점,도착종점,진입차수,최종정답(도로갯수)
	static List<Edge> p[],rp[]; //간선정보,(역)간선정보
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = 1;
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			m = sc.nextInt();
			p = (List<Edge>[]) new List[n+1];
			rp = (List<Edge>[]) new List[n+1];
			s = new int[n+1];
			ind1 = new int[n+1];
			
			for(int i=1; i<=n; i++){
				p[i] = new ArrayList<Edge>();
				rp[i] = new ArrayList<Edge>();
			}
			
			for(int i=1; i<=m; i++){
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				int tmp3 = sc.nextInt();
				p[tmp1].add(new Edge(tmp2,tmp3,0));
				rp[tmp2].add(new Edge(tmp1,tmp3,0));
				ind1[tmp2]++;
			}
			st = sc.nextInt();
			ed = sc.nextInt();
			
			ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
			dq.add(st);
			
			// calculate max time at destination
			while(!dq.isEmpty()){
				int parent = dq.pollFirst();
				for(Edge child : p[parent]){
					if(--ind1[child.e]==0) dq.add(child.e);
					s[child.e] = Math.max(s[child.e],s[parent]+child.c);
				}
			}
			
			// calculate road count
			dq.clear();
			dq.add(ed);
			while(!dq.isEmpty()){
				int parent = dq.pollFirst();
				if(parent==st) continue;
				for(Edge child : rp[parent]){
					if(s[parent]-child.c == s[child.e] && child.v==0){
						dq.add(child.e);
						ans++;
						child.v = 1;
					}
				}
			}
			
			// final solution
			System.out.println(s[ed]);
			System.out.println(ans);
		}
	}
	
	static class Edge{
		int	e;
		int c;
		int v;
		public Edge(int e, int c, int v){
			this.e = e;
			this.c = c;
			this.v = v;
		}
	}
}
