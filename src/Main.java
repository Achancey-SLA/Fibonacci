
void main() throws Exception {
    Fibonacci fib1 = new Fibonacci("tim",200,0,1,10);
    Fibonacci fib2 = new Fibonacci("joe",200,0,5,10);
    Fibonacci fib3 = new Fibonacci("mike",200,0,3,10);
    Thread thread1 = new Thread(fib1);
    Thread thread2 = new Thread(fib2);
    Thread thread3 = new Thread(fib3);
    thread1.start();
    thread2.start();
    thread3.start();
}
