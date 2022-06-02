

public class User {

    private Integer identifier;
    private String name;
    private Integer balance;

    public User(String name, Integer balance){
        setName(name);
        setBalance(balance);
        identifier = UserIdsGenerator.getInstance().generateId();
    }

    public Integer getIdentifier(){
        return (identifier);
    }
    public void setIdentifier(Integer identifier){
        this.identifier = identifier;
    }

    public String getName(){
        return(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance(){
        return(balance);
    }

    public void setBalance(Integer balance){
        if (balance < 0) {
            System.out.println("Wrong balance for " + name);
            this.balance = 0;
        }
        else {
            this.balance = balance;
        }
    }
    @Override
    public String toString() {
        return "User{" +
                "id =" + identifier +
                ", Name = " + name +
                ", balance = " + balance + '}';
    }

}