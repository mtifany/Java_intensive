
import static java.lang.System.*;

public class Program {

    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--count=")){
            System.out.println("Wrong arguments!");
            exit(-1);
        }
       try {
           Integer.parseInt(args[0].substring(8));
       }  catch (NumberFormatException e) {
           System.out.println("Wrong arguments!");
           exit(-1);
        }
        int count = Integer.parseInt(args[0].substring(8));
        if (count <= 0){
            System.out.println("Wrong arguments!");
            System.exit(-1);
        }
        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < count; i++){
                    wn.printEgg();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < count; i++){
                    wn.printHen();
                }
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class WaitAndNotify{

    public void printEgg(){
        synchronized (this){

            out.println("Egg");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printHen(){
        try {
           Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this){
            out.println("Hen");
            notify();

        }
    }

}
