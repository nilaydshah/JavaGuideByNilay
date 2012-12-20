package in.nilayshah.threading;


class A extends Thread {   
    Object locka, lockb;   
 //   
    A(Object obja, Object objb) {   
       this.locka = obja;   
       this.lockb = objb;   
    }   
 //   
    public void run() {   
       synchronized (locka) {   
          synchronized (lockb) {   
             System.out.println(Thread.currentThread().getName()   
                + " holds locka= " + Thread.holdsLock(locka));   
             System.out.println(Thread.currentThread().getName()   
                + " holds lockb= " + Thread.holdsLock(lockb));   
             try {   
                lockb.wait();   
             } catch (InterruptedException e) {   
                e.printStackTrace();   
             }   
          }   
       }   
    }   
 //   
    public static void main(String[] args) {   
       Object locka = new Object();   
       Object lockb = new Object();   
       new A(locka,lockb).start();   
 //   
       Thread.yield(); //give the other thread a chance to run   
       System.out.println(Thread.currentThread().getName()   
          + " attempting to acquire locka");   
 //   
       synchronized (locka) {   
          System.out.println(Thread.currentThread().getName()   
             + " attempting to acquire lockb");   
 //   
          synchronized (lockb) {   
             System.out.println(Thread.currentThread().getName()   
                + " holds locka= " + Thread.holdsLock(locka));   
             System.out.println(Thread.currentThread().getName()   
                + " holds lockb= " + Thread.holdsLock(lockb));   
             lockb.notify();   
          }   
       }   
    }   
 }  