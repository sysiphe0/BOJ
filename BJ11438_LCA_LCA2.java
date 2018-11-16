import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ11438_LCA_LCA2 {

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
		int d[] = new int[n+1];
		int p1[] = new int[n+1];
		int c[] = new int[n+1];
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		dq.add(1);
		d[1] = 0;
		p1[1] = 0;
		c[1] = 1;
		while(!dq.isEmpty()){
			int x = dq.pollFirst();
			for(int y : a[x]){
				if(c[y]==1) continue;
				d[y] = d[x]+1;
				p1[y] = x;
				c[y] = 1;
				dq.add(y);
			}
		}
		int log = 1;
		while((1<<log) <= n){
			log += 1;
		}
		log -= 1;
		int p2[][] = new int[n+1][log+1];
		
		for(int i=1; i<=n; i++){
			p2[i][0] = p1[i];
		}
		
		for(int j=1; (1<<j) < n; j++){
			for(int i=1; i<=n; i++){
				if(p2[i][j-1] == 0) continue;
				p2[i][j] = p2[p2[i][j-1]][j-1];
			}
		}
		
		int m = sc.nextInt();
		for(int i=1; i<=m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			if(d[u]<d[v]){
				int tmp = u;
				u = v;
				v = tmp;
			}
		}
	}
}
