

import java.util.UUID;

public class Transaction {

    private UUID identifier;
    private User recepient;
    private User sender;
    public enum Category{
        DEBIT,
        CREDIT
    }
    private Category category;
    private Integer amount;

    public Transaction(User recepient, User sender,Category category, Integer amount) {
        this.recepient = recepient;
        this.sender = sender;
        this.category = category;
        setAmount(amount);
        identifier = UUID.randomUUID();
    }

    public UUID getIdentifier(){
        return(identifier);
    }

    public User getRecepient(){
        return(recepient);
    }

    public void setRecepient(User recepient){
        this.recepient = recepient;
    }

    public User getSender(){
        return(sender);
    }
    public void setSender(User sender){
        this.recepient = sender;
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount){
        if (amount < 0 && category == Category.CREDIT || amount > 0 && category == Category.DEBIT){
            this.amount = amount;
        }
        else
        {
            System.out.println("Wrong amount sign for this Category");
        }
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "identifier =" + identifier +
                ", recepient = " + recepient.getName() +
                ", sender = " + sender.getName() +
                ", category =" + category +
                ", amount = " + amount + '}';
    }
}




