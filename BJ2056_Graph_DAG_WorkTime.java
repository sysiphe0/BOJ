import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ2056_Graph_DAG_WorkTime {

	static int n,time[],ind[],sol[],max;
	static List<Integer>[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;
		n = sc.nextInt();
		time = new int[n+1];
		ind = new int[n+1];
		sol = new int[n+1];
		p = (List<Integer>[]) new List[n+1];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=n; i++){
			time[i] = sc.nextInt();
			ind[i] = sc.nextInt();
			for(int j=1; j<=ind[i]; j++){
				p[sc.nextInt()].add(i);
			}
		}
		
		for(int i=1; i<=n; i++){
			sol[i] = time[i];
			max = Math.max(max, sol[i]);
			if(ind[i]==0) pq.add(i);
		}
		
		while(!pq.isEmpty()){
			int parent = pq.poll();
			for(int child : p[parent]){
				if(--ind[child]==0) pq.add(child);
				sol[child] = Math.max(sol[child], sol[parent]+time[child]);
				max = Math.max(max, sol[child]);
			}
		}
		System.out.println(max);
	}
}
