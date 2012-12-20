package in.nilayshah.threading;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionTest
{
//    MyClass obj = new MyClass();
    public void test() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException
    {

	try{
	    Class MyClass = Class.forName("in.nilayshah.threading.MyClass");
	    /*Method[] methods = MyClass.getMethods();
	    for(Method m: methods){
		System.out.println("Method Name: "+m.getName());
	    }*/
	    
	    Constructor constructor = MyClass.class.getConstructor(int.class);
//	    MyClass obj = (MyClass)MyClass.newInstance();
	   
	    MyClass obj = (MyClass)constructor.newInstance(5);
//	    obj.doSomething(10,"Nilay");
	    
	    Method doSomething = MyClass.getDeclaredMethod("doSomething", int.class, String[].class);
	    String[] s={"nilay","shah"};
	    doSomething.invoke(obj, 10, s);
	    
	}catch (Exception e){
	    e.printStackTrace();
	}
    }
    
    public static void main(String[] args){
	try{
	    new ReflectionTest().test();
	}catch (Exception e){
	    e.printStackTrace();
	}
    }
}

class MyClass{
    
    int i;
    public MyClass()
    {
	
    }
    
    public MyClass(int i){
	this.i= i;
    }
    
    @Override
    public String toString() {
	return "MyClass.class";
    }

    public void doSomething(int j,String[] s){
	System.out.println("doSomething() Called");
	System.out.println("Value of i:"+i);
	System.out.println("Value of j:"+j);
	System.out.println("Value of s[0]:"+s[0]);
	System.out.println("Value of s[1]:"+s[1]);
    }
}
