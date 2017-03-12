package in.nilayshah.programs;

public class MyFibonacci {
	public static int fibArray[]=new int[26];
	
	private static int fib(int n){
		int fibValue = 0;
		if(n<=0){
			return 0;
		}
		else if(n==1){
			return 1;
		}
		else if(fibArray[n]!=0){
			return fibArray[n];
		}
		else {
			fibValue = fib(n-1)+fib(n-2); 
			fibArray[n] = fibValue;
			System.out.println(fibValue);
			return fibValue;
		}		
	}
	public static void main(String[] args) {
		fibArray[0]=1;
		fibArray[1]=1;
		fib(25);
	}
}
