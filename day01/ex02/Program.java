

public class Program {

    public static void main(String[] args) {
        User user1 = new User("Terry", 1_000);
        User user2 = new User("Torry", 50_000);
        User user3 = new User("Barry", -1_000);
        User user4 = new User("Mary", 0);
        UsersList list = new UsersArrayList();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        System.out.println("List -----------");
        System.out.println(list.getbyIndex(0) + " == " + user1);
        System.out.println(list.getbyIndex(user2.getIdentifier()) + " == " + user2);
        System.out.println("size = " + list.NumberofUsers());
        System.out.println("Exception -----------");
        System.out.println(list.getbyId(3));
        System.out.println(list.getbyIndex(user4.getIdentifier()));
    }
}
