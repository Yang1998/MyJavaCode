package offer;

import java.util.List;

public class MinInStack_30<E extends Comparable> {
    private List<E> data;
    private List<E> min;

    private E top(List<E> data) {
        if(data == null || data.size() == 0) {
            return null;
        }
        return data.get(data.size() - 1);
    }
    public synchronized void push(E elem) {
        if(elem == null) {
            throw new IllegalArgumentException("element should not null!");
        }
        data.add(elem);
        if(min.isEmpty() || elem.compareTo(top(min)) < 0) {
            min.add(elem);
        } else {
            min.add(top(min));
        }
    }

    public synchronized void pop() {
        if(data.isEmpty() && min.isEmpty()) {
            return;
        }
        data.remove(data.size() - 1);
        min.remove(min.size() - 1);
    }

    public synchronized E min() {
        if(data.isEmpty() && min.isEmpty()) {
            return null;
        }
        return top(min);
    }
}
