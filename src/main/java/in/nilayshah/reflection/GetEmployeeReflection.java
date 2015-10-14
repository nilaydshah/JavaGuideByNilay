package in.nilayshah.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.SecurityManager;
import java.security.Permission;
public class GetEmployeeReflection
{
    public static void main(String[] args){
	try{
	    
	    Class employee = Class.forName("com.syntel.cdttest.reflection.Employee");
	    Employee employeeObj = (Employee)employee.newInstance();
	    Class[] employeeMemberClasses = employee.getDeclaredClasses();
	    for(Class c: employeeMemberClasses){
		System.out.println("Member class:"+c.getName());
	    }
	    
	    Field[] employeeFields= employee.getDeclaredFields();
	    for(Field f: employeeFields){
		System.out.println("Field:"+f.getName());
		System.out.println("field type:"+f.getType());
		if(f.getType().toString().equals("int")){
//		    SecurityManager security = System.getSecurityManager();
		    f.setAccessible(true);
		    f.setInt(employeeObj, 5);
		    System.out.println("int::"+f.getInt(employeeObj));
		    System.out.println("employeeObj.getEmployeeId():"+employeeObj.getEmployeeId());
		}
		
//		System.out.println("is accessible?"+f.isAccessible());
		System.out.println();
	    }
	    
	    Method[] employeeMethods = employee.getMethods();
	    for(Method m: employeeMethods){
		System.out.println("Method:"+m.getName());
		System.out.println("Return Type:"+m.getReturnType());
	    }
	}catch (Exception e){
	    e.printStackTrace();
	}
    }
}
