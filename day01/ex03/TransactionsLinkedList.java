

import java.util.UUID;

class TransactionNotFoundException extends RuntimeException {}
public class TransactionsLinkedList implements TransactionsList {

    private Node head;
    private Node tail;
    private Integer size;

    public TransactionsLinkedList(){

    size = 0;
}

    @Override
    public void add(Transaction transaction){
    if (size == 0){
        head = new Node(null, transaction, null);
        tail = head;
    } else {
        tail.setNext(new Node(tail, transaction, null));
        tail = tail.getNext();
    }
    size++;
    }

    public void remove(Node current){
        Node prev = current.getPrev();
        Node next = current.getNext();
        if (prev == null){
            head = next;
            head.setNext(null);
        } else {
            prev.setNext(next);
            current.setPrev(null);
        }
        if (next == null){
             tail = prev;
             tail.setNext(null);
        } else {
            next.setPrev(prev);
            current.setNext(null);
        }
        current.setTransaction(null);
    size--;
    }

    @Override
    public void removeTransaction(UUID uuid){
    Node current = head;
    while (current != null){
        if (current.getTransaction().getIdentifier().equals(uuid)){
           remove(current);
           return;
        }
        current = current.next;
    }
    throw new TransactionNotFoundException();
    }




    @Override
    public Transaction[] toArray(){
    Transaction[] transactionArray = new Transaction[size];
    Node node = head;
        for (int i = 0; i < size; i++) {
        transactionArray[i] = node.getTransaction();
        node = node.next;
        }
        return transactionArray;
    }

    private static class Node {
        private Transaction transaction;
        private Node next;
        private Node prev;

        public Node(Node prev, Transaction transaction, Node next) {
            this.transaction = transaction;
            this.next = next;
            this.prev = prev;
        }

        public void setTransaction(Transaction transaction) {
            this.transaction = transaction;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }


        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }



        public Transaction getTransaction() {
            return transaction;
        }


    }
}
