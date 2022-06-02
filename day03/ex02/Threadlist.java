

import java.util.List;

public class Threadlist extends Thread {
    private static int finalcounter;
    private static int id = 1;

    int start;
    int end;
    int threadsum;

    public  Threadlist(List<Integer> list, int start, int end){
        super("Thread " + id++);
        this.start = start;
        this.end = end;
        for (int i = 0; i < end - start; i++) {
            threadsum += list.get(i);
        }
    }

    public static int getFinalcounter() {
        return finalcounter;
    }

    public synchronized void increment(int start, int end, int threadsum) {
        System.out.printf("%s from %d to %d sum is %d \n",
                Thread.currentThread().getName(), start, end -1, threadsum);
        finalcounter += threadsum;
    }

    @Override
    public void run() {

        increment(start,end, threadsum);
    }

}

