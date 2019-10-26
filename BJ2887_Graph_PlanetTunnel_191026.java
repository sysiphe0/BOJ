package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ2887_Graph_PlanetTunnel_191026 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Planet> pList = new ArrayList<Planet>(); // 행성정보(정점번호, x좌표, y좌표, z좌표)
		ArrayList<Edge> eList = new ArrayList<Edge>(); // 간선정보(시작정점번호, 도착정점번호, 가중치)
		
		// 우선 행성정보를 ArrayList에 담는다.
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			long t1 = Integer.parseInt(st.nextToken());
			long t2 = Integer.parseInt(st.nextToken());
			long t3 = Integer.parseInt(st.nextToken());
			pList.add(new Planet(i,t1,t2,t3));
		}
		
		/* 기본샘플 예제의 경우 정점이 5개이므로 최종 MST간선은 5-1개, 즉 4개가 되며,
		      각 간선끼리 연결되는 모든 경우의 수는 4+3+2+1 = 10가지가 된다.
		      각 간선마다 가중치는 |Xa-Xb|일수도있고, |Ya-Yb|일수도있고, |Za-Zb|일수도 있기때문에 (총 3세트),
		      전체 가중치 후보군의 개수는 10x3 = 30개가 된다.
		   (같은 말이지만) 다르게 표현하면, 총 30개의 간선후보 중 x좌표로 된건 10개가 있고, y좌표도 10개, z좌표도 10개가 있다.
		      이제부터 X좌표(10개), Y좌표(10개), Z좌표(10개) 각 후보군들 중, 실제 최종 MST간선으로 선택될 가능성 있는 애들만 추려낼 것이다.
		*/
		
		// 행성정보 ArrayList를 x좌표 기준으로 정렬
		Collections.sort(pList, new CompareX());
		
		/* 정렬된 후, 서로 인접한 정점끼리의 간선만 최종 MST간선의 후보가 된다.
		      왜냐하면, 인접하지 않은 정점끼리의 (|Xa-Xb|가 가중치인) 간선은 eList에 담는다해도
		      정렬하면 어차피 우리가 최종 후보로 선택한 인접한 정점사이의 간선보다 뒤쪽(후순위)으로 올 수 밖에 없기때문에
		      결국 Kruskal 알고리즘 푸는데 고려되지 않으므로 무시한다.
		*/ 
		for(int i=0; i<n-1; i++){
			int start = pList.get(i).v;
			int end = pList.get(i+1).v;
			long c = pList.get(i+1).x - pList.get(i).x;
			eList.add(new Edge(start,end,c));
		}
		
		// 행성정보 ArrayList를 y좌표 기준으로 정렬 후, 서로 인접한 정점끼리의 간선만 최종 MST간선의 후보로 넣는다.
		Collections.sort(pList, new CompareY());
		for(int i=0; i<n-1; i++){
			int start = pList.get(i).v;
			int end = pList.get(i+1).v;
			long c = pList.get(i+1).y - pList.get(i).y;
			eList.add(new Edge(start,end,c));
		}
		
		// 행성정보 ArrayList를 z좌표 기준으로 정렬 후, 서로 인접한 정점끼리의 간선만 최종 MST간선의 후보로 넣는다.
		Collections.sort(pList, new CompareZ());
		for(int i=0; i<n-1; i++){
			int start = pList.get(i).v;
			int end = pList.get(i+1).v;
			long c = pList.get(i+1).z - pList.get(i).z;
			eList.add(new Edge(start,end,c));
		}
		
		// 최종 후보 간선이 정해졌으니, 이제부터 일반적인 크루스칼 알고리즘으로 풀어내면 된다. 이후 설명은 생략.
		Collections.sort(eList, new Compare());
		int[] p = new int[n+1];
		for(int i=1; i<=n; i++){
			p[i] = i;
		}
		long ans = 0;
		
		for(Edge now : eList){
			int x = find(p,now.s);
			int y = find(p,now.e);
			if(x!=y){
				ans += now.c;
				p[x] = y;
			}
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}	
	
	static class Planet{
		int v;
		long x,y,z;
		public Planet(int v, long x, long y, long z){
			this.v=v;
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}
	
	static class Edge{
		int s,e;
		long c;
		public Edge(int s, int e, long c){
			this.s=s;
			this.e=e;
			this.c=c;
		}
	}
	
	static class CompareX implements Comparator<Planet>{
		public int compare(Planet one, Planet two){
			return Long.compare(one.x, two.x);
		}
	}
	
	static class CompareY implements Comparator<Planet>{
		public int compare(Planet one, Planet two){
			return Long.compare(one.y, two.y);
		}
	}
	
	static class CompareZ implements Comparator<Planet>{
		public int compare(Planet one, Planet two){
			return Long.compare(one.z, two.z);
		}
	}
	
	static class Compare implements Comparator<Edge>{
		public int compare(Edge one, Edge two){
			return Long.compare(one.c, two.c);
		}
	}
	
	static int find(int[] p, int x){
		if(x==p[x]){
			return x;
		}else{
			return (p[x] = find(p,p[x]));
		}
	}
	
}
