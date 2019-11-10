import java.util.Scanner;

class HelloWorld {
    private int n;
    public HelloWorld( int n){
        this.n = n;
    }

    private int flag=1;//标志位，1为执行hello线程，2为执行word线程
    public void hello() throws InterruptedException{
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (flag != 1) {
                    try {
                        this.wait();//非该线程执行，该线程休眠
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("Hello");
                flag = 2;//转换标志位
                this.notifyAll();//唤醒其它所有线程
            }
        }
    }

    public void world() throws InterruptedException{
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (flag != 2) {
                    try {
                        this.wait();//非该线程执行，该线程休眠
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("World!");
                flag = 1;//转换标志位
                this.notifyAll();//唤醒其它所有线程
            }
        }
    }

}

class PrintWorld implements Runnable{
    HelloWorld helloWorld;
    public PrintWorld(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run(){
        try {
            helloWorld.world();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintHello implements Runnable {
    HelloWorld helloWorld;
    public PrintHello(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run() {
        try {
            helloWorld.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HelloWorld helloWorld = new HelloWorld(n);
        PrintHello printHello = new PrintHello(helloWorld);
        PrintWorld printWorld = new PrintWorld(helloWorld);
        new Thread(printHello).start();
        new Thread(printWorld).start();
    }
}

