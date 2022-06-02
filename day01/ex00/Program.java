

import java.util.UUID;

public class Program {

    public static void main(String[] args) {
    User user1 = new User("Boris", 10000);
    User user2 = new User("Lola", 50000);

    Transaction tr1 = new Transaction(user1, user2, Transaction.Category.CREDIT, 1000);
    Transaction tr2 = new Transaction(user2, user1, Transaction.Category.DEBIT, 1000);
        System.out.println(tr1);
        System.out.println(tr2);

    }
}