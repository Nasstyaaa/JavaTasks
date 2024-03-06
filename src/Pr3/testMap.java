package Pr3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testMap implements Map {
    Map map = new HashMap(); // внутреннее хранилище для элементов Map
    private static final Lock lock = new ReentrantLock(); // добавление нового статического поля Lock

    @Override
    public int size() {
        lock.lock(); // блокировка доступа к map для предотвращения одновременного изменения
        try {
            int m = map.size();
            return m;

        } finally {
            lock.unlock(); // разблокировка после завершения операции
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try {
            boolean m = map.isEmpty();
            return m;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        try {
            boolean m = map.containsKey(key);
            return m;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        try {
            boolean m = map.containsValue(value);
            return m;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public Object get(Object key) {
        lock.lock();
        try {
            Object m = map.get(key);
            return m;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public Object put(Object key, Object value) {
        lock.lock();
        try {
            Object m = map.put(key, value);
            return m;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public Object remove(Object key) {
        lock.lock();
        try {
            Object m = map.remove(key);
            return m;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public void putAll(Map m) {
        lock.lock();
        try {
            map.putAll(m);

        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        lock.lock();
        try {
            map.clear();

        } finally {
            lock.unlock();
        }
    }

    @Override
    public Set keySet() {
        lock.lock();
        try {
            Set m = map.keySet();
            return m;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public Collection values() {
        lock.lock();
        try {
            Collection m = map.values();
            return m;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public Set<Entry> entrySet() {
        lock.lock();
        try {
            Set m = map.entrySet();
            return m;

        } finally {
            lock.unlock();
        }
    }
}
