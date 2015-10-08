package in.nilayshah.threading;

import java.util.HashMap;
public class Test
{
    public static void main(String[] args) //throws SecurityException, ClassNotFoundException
    {
	MotorCycle m = new MotorCycle();
	Bicycle b = new Bicycle();
	b = (Bicycle)m;
	if(m instanceof Bicycle){
	m = (MotorCycle)b;
	System.out.println(m.wheels);
	}
	System.out.println(m.wheels);
	
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	map.put(1, "abc");
	map.put(1, "def");
	System.out.println(map.get(1));
			
    }
}

class Bicycle{
    int wheels= 12;   
     void my_name(){
	
    }
}

class MotorCycle extends Bicycle {
    
    void my_name(){
	System.out.println("Hello");
    }
    
    
    
}

class Car extends MotorCycle{
    
}