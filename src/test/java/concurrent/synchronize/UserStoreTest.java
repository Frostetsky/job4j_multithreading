package concurrent.synchronize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserStoreTest {
    @Test
    public void whenAddInStore() {
        UserStore store = new UserStore();
        store.add(new User(1, 50));
        assertEquals(store.findByID(1), new User(1, 50));
    }

    @Test
    public void whenDeleteFromStore() {
        UserStore store = new UserStore();
        User user = new User(1, 50);
        User otherUser = new User(2, 100);
        store.add(user);
        store.add(otherUser);
        store.delete(user);
        assertEquals(store.getSize(), 1);
    }

    @Test
    public void whenUpdateUserInStore() {
        UserStore store = new UserStore();
        User user = new User(1, 60);
        User updateUser = new User(1, 100);
        store.add(user);
        store.update(updateUser);
        assertEquals(store.findByID(1).getAmount(), 100);
    }

    @Test
    public void whenTransferMoney() {
        UserStore store = new UserStore();
        User from = new User(1, 50);
        User to = new User(2, 35);
        store.add(from);
        store.add(to);
        store.transfer(1, 2, 30);
        assertEquals(store.findByID(1).getAmount(), 20);
        assertEquals(store.findByID(2).getAmount(), 65);
    }
}