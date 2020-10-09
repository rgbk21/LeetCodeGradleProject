package Threads;

public class A_CreatingThreads {

    public static void main(String[] args) {

        Thread dummy = new Thread();
        dummy.start();

        Runnable r = () -> System.out.println("Inside Runnable");
        Thread dummy2 = new Thread(r);
        dummy2.start();

        NewThread dummy3 = new NewThread();
        dummy3.start();

        Thread dummy4 = new Thread(MethodThread::methodThread);
        dummy4.start();
    }
}


class NewThread extends Thread {

    @Override
    public void run() {
        System.out.println("In new Thread");
    }
}

class MethodThread {

    // The static is only because I am trying to run the thread from the psvm method.
    // Otherwise the static is not required on the method definition
    public static void methodThread() {
        System.out.println("In Method Thread");
    }

}