import com.sun.source.tree.SynchronizedTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci implements FibonacciLike, Runnable{
    private static final Object fibLock = new Object();
    int amountofNumbersInSequence = 0;
    int number1 = 0;
    int number2 = 0;
    String name;
    long wait;
    public Fibonacci(String name,long wait,int number1, int number2, int amountofNumbersInSequence) {
        this.number2 = number2;
        this.number1 = number1;
        this.amountofNumbersInSequence = amountofNumbersInSequence;
        this.name=name;
        this.wait=wait;
    }
    ArrayList<Integer> numbers;

    public void calculate(){
        numbers = new ArrayList<>();

        numbers.add(number1);
        numbers.add(number2);

        for (int i = 0; i < amountofNumbersInSequence - 2; i++) {
            numbers.add(numbers.get(numbers.size() - 1) + numbers.get(numbers.size() - 2));

            System.out.println(name + ": " + numbers);

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
            }
        }

    }



    public List<Integer> calculateRecursive(int num1, int num2, int numbersLeft){
        if(numbersLeft>0){
            numbers.add(numbers.get(numbers.size()-1)+numbers.get(numbers.size()-2));
            return calculateRecursive(num2,num1+num2,numbersLeft-1);
        }
        else{
            return Arrays.asList(num1,num2);
        }
    }


    public void run(){
    calculate();
    }
}
