

import java.util.UUID;
public class Program {

    public static void main(String[] args) {

        User user1 = new User("John", 10000);
        User user2 = new User("Mary", 100000);
        User user3 = new User("Alex", 1000000);

        TransactionsLinkedList list = new TransactionsLinkedList();
        user1.setTransactionsLinkedList(list);
        user2.setTransactionsLinkedList(list);


        Transaction transaction1 = new Transaction(user2, user1, Transaction.Category.CREDIT, -1000);
        Transaction transaction2 = new Transaction(user1, user2, Transaction.Category.DEBIT, 200);
        Transaction transaction3 = new Transaction(user2, user3, Transaction.Category.CREDIT, -500);
        Transaction transaction4 = new Transaction(user3, user2, Transaction.Category.DEBIT, 5000);


        list.add(transaction1);
        list.add(transaction2);
        list.add(transaction3);
        list.add(transaction4);

        System.out.println("Transactions");
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        System.out.println("-------------------");
        System.out.println("deleting");
        list.removeTransaction(transaction2.getIdentifier());
        System.out.println("-------------------");
        System.out.println("after");
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        System.out.println("-------------------");
        System.out.println("Exception");
        list.removeTransaction(UUID.randomUUID());
    }
}
