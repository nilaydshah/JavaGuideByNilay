package in.nilayshah.programs;

public class FindMinAndMaxInArray {
	private static void findMinMax(int[] arr){
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++){
			if(arr[i]< min)
				min=arr[i];
			if(arr[i]> max)
				max=arr[i];
		}
		System.out.println("Min:"+min);
		System.out.println("Max:"+max);
	}
	public static void main(String[] args){
		int[] arr = new int[]{25,7,45,34,12,67,35,2,88,11};
		findMinMax(arr);
	}
}
