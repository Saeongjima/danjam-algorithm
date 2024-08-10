
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static boolean key=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n= input.nextInt();//정점의 갯수
		int color = input.nextInt();//색칠할 갯수
		boolean[]check; check= new boolean[n];//check를 한거를 표현을
		int carr[]= new int[n];//color을 초기화를 시킵시다
		int arr[]= new int[n];
		int matrix[][]=new int[n][n];//이차원 배열을 생성
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int x= input.nextInt();
				matrix[i][j]=x;
				matrix[j][i]=x;//인접행렬을 생성합시다
			}
		}//
		dfs(matrix,0,check,carr,color);
		if(!key) {
			System.out.println("NONE");
		}
		
	}
	public static void dfs(int[][]matrix,int x,boolean[]check,int[]carr,int color) {
		if(x==matrix.length) {//맞으면 리턴
			key=true;
			for(int i=0;i<carr.length;i++) {
				System.out.print(carr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=color;i++) {
			check[x]=true;
			carr[x]=i;//여기에 컬러를 고정
			if(!find(matrix,x,carr)) {//여기에 안걸리면 
				
				dfs(matrix,x+1,check,carr,color);
				check[x]=false;
				carr[x]=0;
			}
			else {
			check[x]=false;
			carr[x]=0;
			}
		}
	}

	public static boolean find(int[][]matrix,int x,int[]carr) {
		boolean find=false;
		for(int i=0;i<matrix.length;i++) {//인접한 얘들을 찾아서 color값이 같으면 truefmf flxjs
			if(matrix[x][i]==1&&carr[x]!=0&&carr[x]==carr[i]) {
				find=true;
				break;
			}
		}
		return find;
	}

}
