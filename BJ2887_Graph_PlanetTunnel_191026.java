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
		ArrayList<Planet> pList = new ArrayList<Planet>(); // �༺����(������ȣ, x��ǥ, y��ǥ, z��ǥ)
		ArrayList<Edge> eList = new ArrayList<Edge>(); // ��������(����������ȣ, ����������ȣ, ����ġ)
		
		// �켱 �༺������ ArrayList�� ��´�.
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			long t1 = Integer.parseInt(st.nextToken());
			long t2 = Integer.parseInt(st.nextToken());
			long t3 = Integer.parseInt(st.nextToken());
			pList.add(new Planet(i,t1,t2,t3));
		}
		
		/* �⺻���� ������ ��� ������ 5���̹Ƿ� ���� MST������ 5-1��, �� 4���� �Ǹ�,
		      �� �������� ����Ǵ� ��� ����� ���� 4+3+2+1 = 10������ �ȴ�.
		      �� �������� ����ġ�� |Xa-Xb|�ϼ����ְ�, |Ya-Yb|�ϼ����ְ�, |Za-Zb|�ϼ��� �ֱ⶧���� (�� 3��Ʈ),
		      ��ü ����ġ �ĺ����� ������ 10x3 = 30���� �ȴ�.
		   (���� ��������) �ٸ��� ǥ���ϸ�, �� 30���� �����ĺ� �� x��ǥ�� �Ȱ� 10���� �ְ�, y��ǥ�� 10��, z��ǥ�� 10���� �ִ�.
		      �������� X��ǥ(10��), Y��ǥ(10��), Z��ǥ(10��) �� �ĺ����� ��, ���� ���� MST�������� ���õ� ���ɼ� �ִ� �ֵ鸸 �߷��� ���̴�.
		*/
		
		// �༺���� ArrayList�� x��ǥ �������� ����
		Collections.sort(pList, new CompareX());
		
		/* ���ĵ� ��, ���� ������ ���������� ������ ���� MST������ �ĺ��� �ȴ�.
		      �ֳ��ϸ�, �������� ���� ���������� (|Xa-Xb|�� ����ġ��) ������ eList�� ��´��ص�
		      �����ϸ� ������ �츮�� ���� �ĺ��� ������ ������ ���������� �������� ����(�ļ���)���� �� �� �ۿ� ���⶧����
		      �ᱹ Kruskal �˰��� Ǫ�µ� ������� �����Ƿ� �����Ѵ�.
		*/ 
		for(int i=0; i<n-1; i++){
			int start = pList.get(i).v;
			int end = pList.get(i+1).v;
			long c = pList.get(i+1).x - pList.get(i).x;
			eList.add(new Edge(start,end,c));
		}
		
		// �༺���� ArrayList�� y��ǥ �������� ���� ��, ���� ������ ���������� ������ ���� MST������ �ĺ��� �ִ´�.
		Collections.sort(pList, new CompareY());
		for(int i=0; i<n-1; i++){
			int start = pList.get(i).v;
			int end = pList.get(i+1).v;
			long c = pList.get(i+1).y - pList.get(i).y;
			eList.add(new Edge(start,end,c));
		}
		
		// �༺���� ArrayList�� z��ǥ �������� ���� ��, ���� ������ ���������� ������ ���� MST������ �ĺ��� �ִ´�.
		Collections.sort(pList, new CompareZ());
		for(int i=0; i<n-1; i++){
			int start = pList.get(i).v;
			int end = pList.get(i+1).v;
			long c = pList.get(i+1).z - pList.get(i).z;
			eList.add(new Edge(start,end,c));
		}
		
		// ���� �ĺ� ������ ����������, �������� �Ϲ����� ũ�罺Į �˰������� Ǯ��� �ȴ�. ���� ������ ����.
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
