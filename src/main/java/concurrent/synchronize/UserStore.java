package concurrent.synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class UserStore implements Store {

    @GuardedBy("this")
    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    public int getSize() {
        return users.size();
    }

    @Override
    public void add(User user) {
        users.putIfAbsent(user.getId(), user);
    }

    @Override
    public boolean update(User user) {
        return users.replace(user.getId(), user) != null;
    }

    @Override
    public boolean delete(User user) {
        return users.remove(user.getId()) != null;
    }

    @Override
    public User findByID(int id) {
        return users.get(id);
    }

    public synchronized boolean transfer(int id_user1, int id_user2, int amount) {
        User from = findByID(id_user1);
        User to = findByID(id_user2);
        if (from == null || to == null || from.getAmount() < amount) {
            return false;
        }
        from.setAmount(from.getAmount() - amount);
        to.setAmount(to.getAmount() + amount);
        return true;
    }
}
