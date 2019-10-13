import java.util.Scanner;
public class PertCpm{
	public static void main(String []args){
		new Pert();
	}
}
class Pert{
	int [][]a;
	int [][]temp;
	int []es;
	int []lf;
	int []ef;
	int []ls;
	int node, edge;
	Pert(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of nodes: ");
		node = input.nextInt();
		a = new int[node][node];
		temp = new int[node][node];
		temp = new int[node][node];
		System.out.println("Enter the number of edges: ");
		edge = input.nextInt();	
		int i, j, k;
		for(i=0;i<node;i++){
			for(j=0;j<node;j++){
				a[i][j] = -1;
				temp[i][j] = -1;
			}
		}
		for(i=0;i<edge;i++){
			System.out.println("Enter the start node: ");
			j = input.nextInt();
			j = j - 1;
			System.out.println("Enter the end node: ");
			k = input.nextInt();
			k = k - 1;
			System.out.println("Enter the value of the element a["+(j+1)+"]["+(k+1)+"]: ");
			a[j][k] = input.nextInt();
			temp[j][k] = a[j][k];
		}
		es = new int[node];
		lf = new int[node];
		ef = new int[node];
		ls = new int[node];
		for(i=0;i<node;i++){
			lf[i] = Integer.MAX_VALUE;
		}
		es[0] = 0;
		lf[0] = 0;
		find_critical_path();
	}
	void find_critical_path(){
		int i, j;
		int t, total = 0;
		for(i=0;i<node;i++){
			for(j=0;j<node;j++){
				if(temp[i][j]!=-1){
					t = temp[i][j] + es[i];
					if(t>es[j]){
						es[j] = t;
					}
				}
			}//end for j
		}//end for i
		lf[node-1] = es[node-1];
		for(i=node-2;i>=0;i--){
			for(j=node-1;j>=0;j--){
				if(temp[i][j]!=-1){
					t = es[j] - temp[i][j];
					if(t<lf[i]){
						lf[i] = t;
					}
				}
			}
		}
		System.out.println("ES\tLF");
		for(i=0;i<node;i++){
			System.out.println(es[i] +"\t"+ lf[i]);
		}
		System.out.println("PATH");
		for(i=0;i<node;i++){
			if(es[i] == lf[i]){
				System.out.print((i+1)+"->");
			}
		}
		System.out.println("\n");
		/*for(i=0;i<node;i++){
			for(j=0;j<node;j++){
				if(es[i]==lf[i] && es[j]==lf[j] && temp[i][j]!=-){
					total = total + temp[i][j];
				}
			}
		}*/
		System.out.println("Total = "+ lf[node-1]);
	}
}