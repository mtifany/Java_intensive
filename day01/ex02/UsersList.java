

public interface UsersList {

    void add(User user);
    User getbyId(Integer identifier);
    User getbyIndex(Integer id);
    Integer NumberofUsers();
}
