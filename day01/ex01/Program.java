

public class Program {

    public static void main(String[] args) {
        User user1 = new User("Boris", 10000);
        User user2 = new User("Lola", 50000);
        User user3 = new User("Tom", 0);

        System.out.println(user1.getIdentifier());
        System.out.println(user2.getIdentifier());
        System.out.println(user3.getIdentifier());


    }
}
