package in.nilayshah.programs;

public class MyFactorial {

	private static int fact(int n){
		if(n==1)
			return 1;
		else if(n==0)
			return 1;
		else
			return n*fact(n-1);
	}
	public static void main(String[] args) {
		int result = fact(5);
		System.out.println(result);
	}

}
