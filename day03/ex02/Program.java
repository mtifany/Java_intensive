

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        int sum = 0;
        int arraySize = Integer.parseInt(args[0].substring(12));
        int threadsCount = Integer.parseInt(args[1].substring(15));
        List <Integer> array = new ArrayList<>(arraySize);
        for (int i = 0; i < arraySize; i++) {
           array.add((int) Math.round((Math.random() * 2000) - 1000));
            sum += array.get(i);

        }
        System.out.println("Sum: " + sum);
        if (threadsCount == 0){
            return;
        }

       List<Thread>  threads = new ArrayList<>(threadsCount);

       int start = 0;
       int end = 1;
        for (int i = 0; i < (threadsCount - 1); i++) {
            start = i * (arraySize / (threadsCount));
            end = (i + 1) * (arraySize / (threadsCount)) -1;
           threads.add(new Threadlist(array.subList(start, end + 1), start, end +1));
        }
           if (threadsCount == 1){
               threads.add(new Threadlist(array.subList((0), (arraySize)), (0), (arraySize)));
           }else {
               threads.add(new Threadlist(array.subList((end + 1), (arraySize)), (end + 1), (arraySize)));
           }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum by threads: " + Threadlist.getFinalcounter());
        }
}





