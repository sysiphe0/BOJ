import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ11437_LCA_LCA {
	static int p[], d[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer>[] a = (List<Integer>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			a[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<n; i++){
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			a[t1].add(t2);
			a[t2].add(t1);
		}
		d = new int[n+1]; //뎁스 정보
		int c[] = new int[n+1]; //체크 여부
		p = new int[n+1]; //부모 정보
		d[1] = 0;
		c[1] = 1;
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		dq.add(1);
		while(!dq.isEmpty()){
			int tmp = dq.pollFirst();
			for(int x : a[tmp]){
				if(c[x]==1) continue;
				d[x] = d[tmp]+1;
				c[x] = 1;
				p[x] = tmp;
				dq.add(x);
			}
		}
		
		int m = sc.nextInt();
		for(int i=1; i<=m; i++){
			System.out.println(lca(sc.nextInt(), sc.nextInt()));
		}
	}
	
	static int lca(int u, int v){
		if(d[u]<d[v]){
			int tmp = u;
			u=v;
			v=tmp;
		}
		while(d[u]!=d[v]){
			u=p[u];
		}
		while(u!=v){
			u=p[u];
			v=p[v];
		}
		return u;
	}
}
