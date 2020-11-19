package concurrent.synchronize;

public interface Store {
    void add(User user);
    boolean update(User user);
    boolean delete(User user);
    User findByID(int id);
}
