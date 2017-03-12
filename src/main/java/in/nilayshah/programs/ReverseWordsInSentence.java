package in.nilayshah.programs;

public class ReverseWordsInSentence {

	private static StringBuffer s = new StringBuffer("Let us reverse this");

	public static void main(String[] args) {
		int i=0, j=0, w=0;
		while(i<s.length()){
			if(i==0)
				w=0;
			if(s.charAt(i) == ' '|| i == s.length() - 1) {
				j=i;
				if (i == s.length() - 1) {
					j=i;
				} else {
					j--;	
				}
				swap(w,j);
				w= i+1;
			}
			i++;
		}
		
		System.out.println(s);
	}
	
	static void swap(int i, int j){
		while (i<j){
			char ch = s.charAt(i);
			s.setCharAt(i, s.charAt(j));
			s.setCharAt(j, ch);
			i++;
			j--;
		}
	}

}
