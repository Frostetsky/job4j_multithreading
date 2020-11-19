package concurrent.synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;

@ThreadSafe
public class SimpleLockList<T> implements Iterable<T> {

    @GuardedBy("this")
    private final SimpleArray<T> list = new SimpleArray<>();

    public synchronized void add(T value) {
        list.add(value);
    }

    public synchronized T get(int index) {
        return list.get(index);
    }

    private SimpleArray<T> copy() {
        SimpleArray<T> cop = new SimpleArray<>();
        for (T element : list) {
            cop.add(element);
        }
        return cop;
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return copy().iterator();
    }
}
