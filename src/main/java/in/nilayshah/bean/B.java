package in.nilayshah.bean;

class A{
	public A(int a){
	}
	
}

public class B extends A{
    public B(){
	super(5);
    }
    
    public static void main(String[] args)
    {
	B b = (B) new A(5);
	A a = new B();
    }
}

