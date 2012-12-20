package in.nilayshah.threading;

public class B extends B1
{
    
    static synchronized void  callB(B b){
	System.out.println(Thread.currentThread().getName()+" called callB()  ");
//	System.out.println(Thread.currentThread().getName()+" holds lock on this "+Thread.holdsLock(this));
	System.out.println(Thread.currentThread().getName()+" holds lock on B.class : "+Thread.holdsLock(B.class));
	System.out.println(Thread.currentThread().getName()+" holds lock on B1.class : "+Thread.holdsLock(B1.class));
    }
    
    public static void main(String[] args){
	B b = new B();
	synchronized(b){
	    System.out.println(Thread.currentThread().getName()+" holds lock on B.class : "+Thread.holdsLock(B.class));
	    System.out.println(Thread.currentThread().getName()+" holds lock on B1.class : "+Thread.holdsLock(B1.class));
	    B.callB(b);
	    System.out.println(Thread.currentThread().getName()+" holds lock on B.class : "+Thread.holdsLock(B.class));
	    System.out.println(Thread.currentThread().getName()+" holds lock on B1.class : "+Thread.holdsLock(B1.class));
	}
	Thread t1 = new Thread(b,"Thread-1");
	t1.setPriority(10);
	Thread t2 = new Thread(b, "Thread-2");
	
	t1.start();
	/*try{
	    t1.join();
	}
	catch (InterruptedException e){
	    e.printStackTrace();
	}*/
	t2.start();
//	Thread.yield();
	
    }

    @Override
    public void run()
    {
	System.out.println(Thread.currentThread().getName()+" STARTS");
	synchronized(this) {
	    System.err.println(Thread.currentThread().getName()+" holds lock on this : "+Thread.holdsLock(this));
	    System.out.println(Thread.currentThread().getName()+" holds lock on B.class : "+Thread.holdsLock(B.class));
	    System.out.println(Thread.currentThread().getName()+" holds lock on B1.class : "+Thread.holdsLock(B1.class));
	    callB(this);
	    try
	    {
		if(Thread.currentThread().getName().endsWith("1")){
		    System.err.println(Thread.currentThread().getName()+" WAITING...");
		    wait(5000);
		}
	    }
	    catch (InterruptedException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    System.err.println(Thread.currentThread().getName()+" holds lock on this : "+Thread.holdsLock(this));
	    System.out.println(Thread.currentThread().getName()+" holds lock on B.class : "+Thread.holdsLock(B.class));
	    System.out.println(Thread.currentThread().getName()+" holds lock on B1.class : "+Thread.holdsLock(B1.class));
	    
	    System.out.println(Thread.currentThread().getName()+" ENDS");
	}
    }
}

abstract class B1 implements Runnable{
    
    static synchronized void callB(B1 b1){
	System.out.println("callB called in B1");
    }
    
}