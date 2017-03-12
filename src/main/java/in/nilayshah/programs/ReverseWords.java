package in.nilayshah.programs;

import java.util.Stack;

public class ReverseWords {
	public static String s= "This is Great";
	
	public static void main(String[] args){
		/*
		// solution with stack
		Stack<String> stack = new Stack<String>();
		String words[] = s.split(" ");
		for(int i=0; i<words.length; i++){
			stack.add(words[i]);
		}
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
		*/
		reverse(s.toCharArray());
		System.out.println(s);
	}
	private static void reverse(char[] c) {
		//first reverse whole string
		reverse(c,0,c.length-1);
		//then reverse each word
		int wordStart=0;
		for(int i=0;i<c.length;i++)
		{
			if(c[i]==' ')
			{
				reverse(c,wordStart,i-1);
				wordStart=i+1;
			}
			else if(i==c.length-1)
			{
				reverse(c,wordStart,i);
			}
		}
		s = new String(c);
	}

	private static void reverse(char[] c, int i, int j) {
		while(i<j) {
			char temp=c[i];
			c[i]=c[j];
			c[j]=temp;
			i++;
			j--;
		}
	}

}
