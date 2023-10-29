//A Java program that implements a multi-thread application that has three
threads.

import java.util.Random;
class SquareThread implements Runnable {
int x;
SquareThread(int x) {
this.x = x;
}
public void run() {
System.out.println(&quot;Thread Name:Square Thread and Square of &quot; + x +

&quot; is: &quot; + x * x);
}
}
class CubeThread implements Runnable {
int x;
CubeThread(int x) {
this.x = x;
}
public void run() {
System.out.println(&quot;Thread Name:Cube Thread and Cube of &quot; + x + &quot;

is: &quot;

+ x * x * x);

}
}
class RandomThread implements Runnable {
Random r;
Thread t2, t3;
public void run() {
int num;
r = new Random();
try {
while (true) {
num = r.nextInt(100);
System.out.println(&quot;Main Thread and Generated Number is

&quot; + num);

t2 = new Thread(new SquareThread(num));
t2.start();
t3 = new Thread(new CubeThread(num));
t3.start();
Thread.sleep(1000);
System.out.println(&quot;---------------------&quot;);
}
} catch (Exception ex) {
System.out.println(&quot;Interrupted Exception&quot;);
}
}

}
public class ThreadDemo {
public static void main(String[] args) {
RandomThread thread_obj = new RandomThread();
Thread t1 = new Thread(thread_obj);
t1.start();
}
}
