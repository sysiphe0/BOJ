import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1395_SegmentTree_Lazy_Switch_1 {

	static int tree[], lazy[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		tree = new int[4*n+1];
		lazy = new int[4*n+1];
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int t3 = Integer.parseInt(st.nextToken());
			if(t1==0){
				update(1,1,n,t2,t3);
			}else if(t1==1){
				System.out.println(sum(1,1,n,t2,t3));
			}
		}
	}
	
	static void lazy_update(int node, int start, int end){
		if(lazy[node] != 0){
			if(lazy[node]%2==1){
				tree[node] = (end-start+1)-tree[node];
			}
			if(start != end){
				lazy[node*2] += lazy[node];
				lazy[node*2+1] += lazy[node];
			}
			lazy[node] = 0;
		}
	}
	
	static void update(int node, int start, int end, int i, int j){
		lazy_update(node, start, end);
		if(i>end || j<start){
			return;
		}else if(i<=start && end<=j){
			tree[node] = (end-start+1)-tree[node];
			if(start != end){
				lazy[node*2]++;
				lazy[node*2+1]++;
			}
		}else{
			update(node*2, start, (start+end)/2, i, j);
			update(node*2+1, (start+end)/2+1, end, i, j);
			tree[node] = tree[node*2]+tree[node*2+1];
		}
	}
	
	static int sum(int node, int start, int end, int i, int j){
		lazy_update(node,start,end);
		if(i>end || j<start){
			return 0;
		}else if(i<=start && end<=j){
			return tree[node];
		}else{
			return sum(node*2, start, (start+end)/2, i, j)+sum(node*2+1, (start+end)/2+1, end, i, j);
		}
	}
}
