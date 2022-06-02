
public class Program {

    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--count=")){
            System.out.println("Wrong arguments!");
            System.exit(-1);
        }
        int count = 0;
        try {
           count = Integer.parseInt(args[0].substring(8));
       }
       catch(Exception e){
           System.out.println("Wrong arguments!");
           System.exit(-1);
       }
       if (count <= 0){
            System.out.println("Wrong arguments!");
            System.exit(-1);
        } 
        Hen hen = new Hen(count);
        Egg egg = new Egg(count);

        egg.start();
        hen.start();
        try {
            hen.join();
            egg.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        for(int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}


class Egg extends Thread {
    int count;

    public Egg(int count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i = 0; i < count; i++){
            System.out.println("Egg");
        }

    }
}
class Hen extends Thread {
    int count;

    public Hen(int count){
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("Hen");
        }

    }

}